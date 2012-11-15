var util = require('util');
var Lexer = require('./lexer.js').Lexer;
var grammar = require('./grammar.js').grammar;
var cat = require('../lib/cat.js');

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
    this.widthFirst(head);
  }
};

/**
 * Using width-first technique to extract factor.
 * @param {String} head Production head
 * @returns {Array} Array of indexes have the same common factor
 */
Parser.prototype.widthFirst = function(head){
  var level1 ; 
  for (var body in this.grammar[head]) {
    level1.push(body);
  }
};

new Parser(new Lexer(), grammar);
