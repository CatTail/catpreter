if (require) {
  var cat = require('../lib/catjs/cat.js').cat;
  var settings = require('./settings.js').settings;
  var util = require('util');
}

/**
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
  debugger;

//  console.log(util.inspect(this.grammar, false, null));
  // Following action will alter this.grammar.so we can't put them into one
  // single loop.
  for (var head in this.grammar) {
    this.handleMagic(head);
  }
  /*
  for (var head in this.grammar) {
    this.extFactor(head);
  }
  for (var head in this.grammar) {
    this.eliRecur(head);
  }
  */

  console.log(util.inspect(this.grammar, false, null));
};

/**
 * Transform ?,*,+,| magic mark into production
 */
Parser.prototype.handleMagic = function(head){
  console.log(this.grammar[head]);
  cat.each(this.grammar[head], function(body, bIdx){
    // handle every production body
    cat.each(body, function(symbol, sIdx){
      // only affect magic ?,*,+,|
      if (typeof symbol === 'object') { 
        var type = Object.keys(symbol)[0];
        // can't cache magic |, for every | is somewhat different
        if (type === '|') {
            this._handleOpt(head, bIdx, sIdx);
        }else{
          // cache magic ?,*,+
          var newHead = head + '$' + type;
          if (this.magicCache.indexOf(newHead) === -1) {
            this.magicCache.push(newHead);
//            var symbol = this.grammar[head][bIdx][sIdx];
            var funcName = '_handle'+this.magicMapping[type];
            this[funcName](symbol, newHead);
          }
          this.grammar[head][bIdx].splice(sIdx, 1, newHead);
          // recursive incoke to eliminate magic
//          this.handleMagic(newHead);
        }
      }
    }, this);
  }, this);
};
// TODO :
// 建立如B+,B*等的数据库，使得每个magic都不需要重复建立如B+2,B+3，而可以重用B+
/**
 * Internally handle optional magic '|'
 * @param {String} head Production head
 * @param {Integer} bIdx Production body index
 * @param {Integer} sIdx Symbol index in production body
 */
Parser.prototype._handleOpt = function(head, bIdx, sIdx){
  var symbol = this.grammar[head][bIdx][sIdx];
  var newHead = head + '$|_' + cat.randomString(this.ranLen);
  this.grammar[newHead] = symbol['|'];
  this.grammar[head][bIdx].splice(sIdx, 1, newHead);
};
/**
 * Internally handle Zero or One magic '?'
 * @param {String} head Production head
 * @param {Integer} bIdx Production body index
 * @param {Integer} sIdx Symbol index in production body
 */
Parser.prototype._handleZero2One = function(symbol, newHead){
  this.grammar[newHead] = [symbol['?'], []];
};
/**
 * Internally handle Zero or Many magic '*'
 * @param {String} head Production head
 * @param {Integer} bIdx Production body index
 * @param {Integer} sIdx Symbol index in production body
 */
Parser.prototype._handleZero2Many = function(symbol, newHead){
  this.grammar[newHead] = [symbol['*'].concat(newHead), []];
};
/**
 * Internally handle One or Many magic '+'
 * @param {String} head Production head
 * @param {Integer} bIdx Production body index
 * @param {Integer} sIdx Symbol index in production body
 */
Parser.prototype._handleOne2Many = function(symbol, newHead){
  this.grammar[newHead] = [symbol['+'].concat({
    '*': symbol['+']
  })];
};


/**
 * Eliminate left recursive
 */
Parser.prototype.eliRecur = function(head){
/*
  for (var head in this.grammar) {
    this.grammar[head].forEach(function(body){
      if (head === body) {
        var body = this.grammar[head][idx];
      }
    });
  }
*/
};

/**
 * Extract left common factor.
 */
Parser.prototype.extFactor = function(head){
  var common_list = this.widthFirst(this.grammar[head]);
  this._extFactor(head, common_list);
};

/**
 * @param {String} head
 * @param {Array.Object} common_list See widthFirst returns
 */
Parser.prototype._extFactor = function(head, common_list){
  if (common_list.length === 0) return;
  // new bodys in old production
  var newBodys = [],
  bodys = this.grammar[head];

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
 * @returns {Array.Object} Array of common object have the same common factor
 *  [{'commons': [0,1,2],'level': 2},{'commons': [5,8],'level': 1}]
 */
Parser.prototype.widthFirst = function(bodys){
  var hash = {},
  common_list = [];
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
    }
  }
  return common_list;
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
