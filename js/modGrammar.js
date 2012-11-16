#! /usr/bin/env node
var util = require('util');
var cat = require('../lib/catjs/cat.js').cat;
var grammar = require('./output/first.js').grammar;
var Lexer = require('./lexer.js').Lexer;
var Parser = require('./parser.js').Parser;

var parser = new Parser(new Lexer(), grammar);
var result = util.inspect(parser.grammar, false, null);
result = "// This file was generated automatically by modGramamr.js\n" +
  "// Don't edit it directly\n" +
  'var grammar = ' + result + ';\n' +
  'if (exports) exports.grammar = grammar;'
console.log(result);
