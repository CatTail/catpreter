#! /usr/bin/env node

var grammar = require('./output/first.js').grammar;
//var cat = require('../lib/catjs/cat.js').cat;
var util = require('util');

var symbols = {
  'terminals': [],
//  'unterminals': []
// unterminals will be generate dynamically through grammar analysis
};
var all = {};
Object.keys(grammar).forEach(function(item){
  parseItem(item);
});
for (var head in grammar) {
  grammar[head].forEach(function(body){
    body.forEach(function(item){
      parseItem(item);
    });
  });
}
for (var item in all) {
  //65 - 90 upper case
  //97 - 122 lower case
  var ascii = item[0].charCodeAt();
  if (item[0] === '\'') {
    symbols.terminals.push(item);
  }else if (ascii >= 65 && ascii <= 90) {
    symbols.terminals.push(item);
  }else if (ascii >= 97 && ascii <= 122) { 
//    symbols.unterminals.push(item);
  }
}
symbols.terminals.sort();
//symbols.unterminals.sort();

function classof (o){
  if (o === null) { return "null"; }
  if (o === undefined) { return "undefined"; }
  if (o !== o) { return "NaN"; }
  if (o.constructor && o.constructor.name) { return o.constructor.name; }
  return Object.prototype.toString.call(o).slice(8,-1);
};
function parseItem(item){
  if (classof(item) === 'Object') {
    var is = item[Object.keys(item)[0]];
    is.forEach(function(i){
      parseItem(i);
    });
  }else if (classof(item) === 'Array') {
    item.forEach(function(i){
      parseItem(i);
    });
  }else{
    all[item] = 0;
  }
}

var result = util.inspect(symbols, false, null);
result = "// This file was generated automatically by genSymbols.js\n" +
  "// Don't edit it directly\n" +
  'var symbols = ' + result + ';\n' +
  'try{exports.symbols = symbols;}catch(err){}'
console.log(result);
