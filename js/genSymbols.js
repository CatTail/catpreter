#! /usr/bin/env node

var grammar = require('./output/first.js').grammar;
var cat = require('../lib/catjs/cat.js').cat;
var util = require('util');

var symbols = {
  'terminal': [],
  'unterminal': []
};
var all = {};
for (var head in grammar) {
  grammar[head].forEach(function(body){
    body.forEach(function(item){
      parseItem(item);
    });
  });
}
function parseItem(item){
  if (cat.type(item) === 'Object') {
    var is = item[Object.keys(item)[0]];
    is.forEach(function(i){
      parseItem(i);
    });
  }else if (cat.type(item) === 'Array') {
    item.forEach(function(i){
      parseItem(i);
    });
  }else{
    all[item] = 0;
  }
}
for (var item in all) {
  //TODO : compare range
  //65 - 90 upper case
  //97 - 122 lower case
  var ascii = item[0].charCodeAt();
  if (item[0] === '\'') {
    symbols.terminal.push(item);
  }else if (ascii >= 65 && ascii <= 90) {
    symbols.terminal.push(item);
  }else if (ascii >= 97 && ascii <= 122) { 
    symbols.unterminal.push(item);
  }
}
var result = util.inspect(symbols, false, null);
result = "// This file was generated automatically by genSymbols.js\n" +
  "// Don't edit it directly\n" +
  'var symbols = ' + result + ';\n' +
  'if (exports) exports.symbols = symbols;'
console.log(result);
