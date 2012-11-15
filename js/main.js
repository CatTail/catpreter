#! /usr/bin/env node
var cat = require('../lib/catjs/cat.js').cat;
var grammar = require('./grammar.js').grammar;
var Lexer = require('./lexer.js').Lexer;
var Parser = require('./parser.js').Parser;

new Parser(new Lexer(), grammar);
