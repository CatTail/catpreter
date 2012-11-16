#! /usr/bin/env node

// This is just a grammar generator example used by nodejs.
// The finnal version will generate grammar automatically by webpage.
var fs = require('fs');
var util = require('util');
//var content = fs.readFileSync('_grammar','utf8');
var content = fs.readFileSync('_grammar_test','utf8');
var subpatterns = [')', ')?', ')*', ')+'];

(function genGrammar(){
  var grammar = {};
  var productions = content.split('\n\t;\n');
  productions.forEach(function(production){
    var head = production.split('\n\t: ')[0];
    if (head!=='') {
      grammar[head] = [];
      var bodys = production.split('\n\t: ')[1].split('\n\t| ');
      bodys.forEach(function(body){
        var symbols = body.split(' ');
        grammar[head].push(genBody(symbols));
      });
    }
  });
  var result = util.inspect(grammar,false,null);
  result = "// This file was generated automatically by genGrammar.js\n" +
    "// Don't edit it directly\n" +
    'var grammar = ' + result + ';\n' +
    'if (exports) exports.grammar = grammar;'

  console.log(result);
})();

// Generator production body
function genBody(symbols){
  var stack = [];
  symbols.forEach(function(symbol){
    if (subpatterns.indexOf(symbol) !== -1) {
      handleSub(stack,symbol);
    }else{
      stack.push(symbol);
    }
  });
  return stack;
}

// Handle subpattern
function handleSub(symbols,type){
  var stack = [],
  sub = {};
  for (var symbol = symbols.pop();
    symbol !== '(' ;
    symbol = symbols.pop()) {
    stack.push(symbol);
  }
  stack.reverse();
  switch (type) {
    case ')?':
    case ')*':
    case ')+':
      sub[type.slice(1)] = handleOpt(stack);
      break;
    default:
      sub = handleOpt(stack);
      break;
  }
  symbols.push(sub);
}

// Handle optional pattern
function handleOpt(symbols){
  if (symbols.indexOf('|')!==-1) {
    var stack = [[]],
    cur = stack[stack.length-1];
    symbols.forEach(function(symbol){
      if (symbol === '|') {
        stack.push([]);
        cur = stack[stack.length-1];
      }else{
        cur.push(symbol);
      }
    });
    return [{'|': stack}];
  }else{
    return symbols;
  }
}
