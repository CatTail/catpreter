#! /usr/bin/env node
var fs = require('fs');
var content = fs.readFileSync('grammar','utf8');

var grammar = {};
var productions = content.split('\n\t;\n');
productions.forEach(function(production){
  var head = production.split('\n\t: ')[0];
  if (head!=='') {
    grammar[head] = [];
    var bodys = production.split('\n\t: ')[1].split('\n\t| ');
    bodys.forEach(function(body){
      var symbols = body.split(' ');
      grammar[head].push(symbols);
    });
  }
});
console.log(grammar);
