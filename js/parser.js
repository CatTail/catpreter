#! /usr/bin/env node

var util = require('util');
var grammar = require('./grammar.js').grammar;
var Lexer = require('./lexer.js').Lexer;
console.log(grammar);

// Eliminate left recursive
// Extract left common factor
