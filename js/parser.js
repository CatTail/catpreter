if (require) {
  var cat = require('../lib/catjs/cat.js').cat;
  var settings = require('./settings.js').settings;
  var util = require('util');
}

/**
 * Grammar analysis.
 * Include following action:
 *  1.magic mark translation
 *  2.common factor extract
 *  3.left recursive elimination
 * @constructor
 */
var Parser = function(lexer,grammar){
  this.lexer = lexer;
  this.grammar = grammar;  
  // random identifier length
  this.ranLen = settings.ranLen;
  // cache magic production header
  this.magicCache = [];
  this.magicMapping = {'?': 'Zero2One','*': 'Zero2Many','+': 'One2Many','|': 'Opt',};

  // Following action will alter this.grammar.so we can't put them into one
  // single loop.
  for (var head in this.grammar) {
    this.handleMagic(head);
  }
  for (var head in this.grammar) {
    this.extFactor(head);
  }
  for (var head in this.grammar) {
    this.eliRecur(head);
  }

  console.log(util.inspect(this.grammar, false, null));
};

/**
 * Transform ?,*,+,| magic mark into production
 */
Parser.prototype.handleMagic = function(head){
  cat.each(this.grammar[head], function(body, bIdx){
    // handle every production body
    cat.each(body, function(symbol, sIdx){
      // only affect magic ?,*,+,|
      if (typeof symbol === 'object') { 
        var newHead,
        type = Object.keys(symbol)[0];
        // can't cache magic '|', for every '|' is somewhat different
        if (type === '|') {
            var newHead = head + '$|_' + cat.randomString(this.ranLen);
            this._handleOpt(symbol, newHead);
        }else{
          // cache magic ?,*,+
          var newHead = head + '$' + type;
          if (this.magicCache.indexOf(newHead) === -1) {
            this.magicCache.push(newHead);
            var funcName = '_handle'+this.magicMapping[type];
            this[funcName](symbol, newHead);
          }
        }
        this.grammar[head][bIdx].splice(sIdx, 1, newHead);
        // recursive incoke to eliminate magic
        this.handleMagic(newHead);
      }
    }, this);
  }, this);
};
/**
 * Internally handle optional magic '|'
 * @param {Object} symbol Cound be any magic mark symbol
 * @param {String} newHead String represent nonterminal
 */
Parser.prototype._handleOpt = function(symbol, newHead){
  this.grammar[newHead] = symbol['|'];
};
/**
 * Internally handle Zero or One magic '?'
 * @param {Object} symbol Cound be any magic mark symbol
 * @param {String} newHead String represent nonterminal
 */
Parser.prototype._handleZero2One = function(symbol, newHead){
  this.grammar[newHead] = [symbol['?'], []];
};
/**
 * Internally handle Zero or Many magic '*'
 * @param {Object} symbol Cound be any magic mark symbol
 * @param {String} newHead String represent nonterminal
 */
Parser.prototype._handleZero2Many = function(symbol, newHead){
  this.grammar[newHead] = [symbol['*'].concat(newHead), []];
};
/**
 * Internally handle One or Many magic '+'
 * @param {Object} symbol Cound be any magic mark symbol
 * @param {String} newHead String represent nonterminal
 */
Parser.prototype._handleOne2Many = function(symbol, newHead){
  this.grammar[newHead] = [symbol['+'].concat({
    '*': symbol['+']
  })];
};


/**
 * Eliminate left recursive
 * @param {String} head Production head
 */
Parser.prototype.eliRecur = function(head){
  var rBodys = [],
  nBodys = [];
  cat.each(this.grammar[head], function(body){
    if (head === body[0]) {
      rBodys.push(body.slice(1));
    }else{
      nBodys.push(body);
    }
  });
  if (rBodys.length === 0) return;
  // left recursive exist
  var newHead = head + '$r_' + cat.randomString(this.ranLen);
  this.grammar[head] = [];
  cat.each(nBodys, function(nBody){
    this.grammar[head].push(nBody.concat(newHead));
  }, this);
  this.grammar[newHead] = [[]];
  cat.each(rBodys, function(rBody){
    this.grammar[newHead].push(rBody.concat(newHead));
  }, this);

  // recursively resolve left recursive
  this.eliRecur(newHead);
};

/**
 * Extract left common factor.
 * @param {String} head Production head
 */
Parser.prototype.extFactor = function(head){
  var similarity = this.widthFirst(this.grammar[head]);
  this._extFactor(head, similarity);
};

/**
 * @param {String} head Production head
 * @param {Object} similarity See widthFirst returns
 */
Parser.prototype._extFactor = function(head, similarity){
  var common_list = similarity.common_list;
  if (common_list.length === 0) return;
  // new bodys in old production
  var newBodys = [],
  bodys = this.grammar[head];

  // keep uncommon production bodys
  cat.each(similarity.uncommons, function(uncommon){
    newBodys.push(bodys[uncommon]);
  });
  cat.each(common_list, function(commons){
    // create new production
    var key = head+'$c_'+cat.randomString(this.ranLen);
    this.grammar[key] = [];
    cat.each(commons.commons, function(common){
      var body = bodys[common];
      if (!commons.hasAdd) {
        newBodys.push(body.slice(0, commons.level).concat(key));
        commons.hasAdd = true;
      }
      this.grammar[key].push(body.slice(commons.level));
    }, this);
    this.extFactor(key);
  }, this);
  this.grammar[head] = newBodys;

};

/**
 * Using width-first technique to extract factor.
 * Filter 𝜀 as empty array.
 * @param {String} bodys Production bodys
 * @returns {Object} Array of common object have the same common factor
 *  {
 *    'common_list': [{'commons': [0,1,2],'level': 2},{'commons': [5,8],'level': 1}],
 *    'uncommons': [3,4,6,7]
 *  }
 */
Parser.prototype.widthFirst = function(bodys){
  var hash = {},
  common_list = [],
  uncommons = [];
  cat.each(bodys, function(body, idx){
    var key = body[0];
    if (key != null) {//escape 𝜀
      if (hash[key] === undefined) {
        hash[key] = [idx];//{'idx': [idx],'count': 1};
      }else{
        hash[key].push(idx);
      }
    }
  }); 
  for (var key in hash) {
    if (hash[key].length > 1) {
      var level = this._deeper(bodys, hash[key], 1);
      common_list.push({
        'commons': hash[key],
        'level': level
      });
    }else{
      uncommons = uncommons.concat(hash[key]);
    }
  }
  return {'common_list': common_list, 'uncommons': uncommons};
};

/**
 * Dig deeper to level.
 * @param {Array} bodys Production bodys
 * @param {Array} commons Common factor production body index
 * @param {Integer} level Dig level
 * @returns {Integer} Result common factors depth
 */
Parser.prototype._deeper = function(bodys, commons, level){
  var hash = {};
  cat.each(commons, function(idx){
    var key = bodys[idx][level];
    hash[key] === undefined ? hash[key] = 1 : hash[key]++;
  });
  // all commons can deeper a bit more
  if (hash[bodys[commons[0]][level]] === commons.length) {
    return this._deeper(bodys, commons, ++level);
  }else{
    return level;
  }
};

if (exports) {
  exports.Parser = Parser;
}
