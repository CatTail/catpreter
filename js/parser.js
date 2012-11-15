if (require) {
  var cat = require('../lib/catjs/cat.js').cat;
}

/**
 * @constructor
 */
var Parser = function(lexer,grammar){
  this.lexer = lexer;
  this.grammar = grammar;  

  this.extFactor();
  this.eliRecur();
};

/**
 * Eliminate left recursive
 */
Parser.prototype.eliRecur = function(){
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
Parser.prototype.extFactor = function(){
  for (var head in this.grammar) {
    this.widthFirst(this.grammar[head]);
  }
};

/**
 * Using width-first technique to extract factor.
 * Filter 𝜀 as empty array.
 * @param {String} bodys Production bodys
 * @returns {Array} Array of indexes have the same common factor
 */
Parser.prototype.widthFirst = function(bodys){
  var hash = {},
  commons = [];
  cat.each(bodys, function(body, idx){
    var key = body[0];
    if (key != null) {//escape 𝜀
      if (hash[key] === undefined) {
        hash[key] = {'idx': [idx],'count': 1};
      }else{
        hash[key].idx.push(idx);
        hash[body[0]].count++;
      }
    }
  }); 
  for (var key in hash) {
    if (hash[key].count > 1) {
      commons.concat(hash[key].idx);
    }
  }
  commons = this._deeper(bodys, commons, 1);
};

/**
 * Dig deeper to level.
 * @param {Array} bodys Production bodys
 * @param {Array} commons Common factor production body index
 * @param {Integer} level Dig level
 * @returns {Array} Result common factors
 */
Parser.prototype._deeper = function(bodys, commons, level){
  var hash = {};
  cat.each(commons, function(idx){
    hash[idx][level];
  });
};

if (exports) {
  exports.Parser = Parser;
}
