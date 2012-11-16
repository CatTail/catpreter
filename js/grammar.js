// This file was generated automatically by genGrammar.js
// Don't edit it directly
var grammar = { selection_statement: 
   [ [ '\'if\'',
       '\'(\'',
       'expression',
       '\')\'',
       'statement',
       { '?': [ '\'else\'', 'statement' ] } ] ],
  init_declarator: [ [ 'declarator', { '?': [ '\'=\'', 'initializer' ] } ] ],
  declarator: 
   [ [ 'IDENTIFIER',
       { '*': [ '\'[\'', { '?': [ 'constant_expression' ] }, '\']\'' ] } ] ],
  expression: 
   [ [ 'assignment_expression',
       { '*': [ '\',\'', 'assignment_expression' ] } ] ],
  equality_expression: 
   [ [ 'relational_expression',
       { '*': 
          [ { '|': 
               [ [ 'EQ_OP', 'relational_expression' ],
                 [ 'NE_OP', 'relational_expression' ] ] } ] } ] ],
  relational_expression: 
   [ [ 'additive_expression',
       { '*': [ '\'<\'', 'additive_expression' ] } ] ],
  additive_expression: 
   [ [ 'multiplicative_expression',
       { '*': 
          [ { '|': 
               [ [ '\'+\'', 'multiplicative_expression' ],
                 [ '\'-\'', 'multiplicative_expression' ] ] } ] } ] ],
  multiplicative_expression: 
   [ [ 'unary_expression',
       { '*': 
          [ { '|': 
               [ [ '\'*\'', 'unary_expression' ],
                 [ '\'/\'', 'unary_expression' ] ] } ] } ] ],
  statement_list: [ [ 'statement+' ] ] };
if (exports) exports.grammar = grammar;
