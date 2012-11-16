#! /usr/bin/env node

var grammar = require('./grammar.js').grammar;
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
  if (typeof(item) === 'object') {
    for (var i in item[Object.keys(item)[0]]) {
      parseItem(i);
    }
  }else{
    debugger;
    all[item] = 0;
  }
}
for (var item in all) {
  //TODO : compare range
  //65 - 90
  //97 - 122
  if (item[0] === '\'') {
    symbols.terminal.push(item);
  }else if (item[0].char
}
console.log(util.inspect(all, false, null));
