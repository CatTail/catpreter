// This file was generated automatically by modGramamr.js
// Don't edit it directly
var grammar = { prog: [ [ 'statement' ] ],
  statement: 
   [ [ 'compound_statement' ],
     [ 'expression_statement' ],
     [ 'selection_statement' ],
     [ 'iteration_statement' ],
     [ 'declaration' ] ],
  compound_statement: [ [ '\'{\'', 'compound_statement$c_yOIygl' ] ],
  statement_list: [ [ 'statement_list$+' ] ],
  expression_statement: [ [ '\';\'' ], [ 'expression', '\';\'' ] ],
  selection_statement: 
   [ [ '\'if\'',
       '\'(\'',
       'expression',
       '\')\'',
       'statement',
       'selection_statement$?' ] ],
  iteration_statement: [ [ '\'while\'', '\'(\'', 'expression', '\')\'', 'statement' ] ],
  expression: [ [ 'assignment_expression', 'expression$*' ] ],
  constant_expression: [ [ 'equality_expression' ] ],
  assignment_expression: 
   [ [ 'equality_expression' ],
     [ 'primary_expression',
       'assignment_operator',
       'assignment_expression' ] ],
  equality_expression: [ [ 'relational_expression', 'equality_expression$*' ] ],
  relational_expression: [ [ 'additive_expression', 'relational_expression$*' ] ],
  additive_expression: [ [ 'multiplicative_expression', 'additive_expression$*' ] ],
  multiplicative_expression: [ [ 'unary_expression', 'multiplicative_expression$*' ] ],
  unary_expression: 
   [ [ 'postfix_expression' ],
     [ 'unary_operator', 'unary_expression' ] ],
  postfix_expression: [ [ 'primary_expression', 'postfix_expression$*' ] ],
  primary_expression: 
   [ [ 'constant' ],
     [ 'IDENTIFIER' ],
     [ '\'(\'', 'expression', '\')\'' ] ],
  declaration: [ [ 'declarator_specifiers', 'init_declarator_list', '\';\'' ] ],
  declarator_specifiers: [ [ '\'int\'' ], [ '\'real\'' ] ],
  init_declarator_list: [ [ 'init_declarator', 'init_declarator_list$*' ] ],
  init_declarator: [ [ 'declarator', 'init_declarator$?' ] ],
  declarator: [ [ 'IDENTIFIER', 'declarator$*' ] ],
  initializer: [ [ 'assignment_expression' ] ],
  constant: [ [ 'INT_LITERAL' ], [ 'REAL_LITERAL' ] ],
  assignment_operator: [ [ '\'=\'' ] ],
  unary_operator: [ [ '\'+\'' ], [ '\'-\'' ], [ '\'read\'' ], [ '\'write\'' ] ],
  'statement_list$+': [ [ 'statement', 'statement_list$+$*' ] ],
  'statement_list$+$*': [ [ 'statement', 'statement_list$+$*' ], [] ],
  'selection_statement$?': [ [ '\'else\'', 'statement' ], [] ],
  'expression$*': [ [ '\',\'', 'assignment_expression', 'expression$*' ], [] ],
  'equality_expression$*': 
   [ [ 'equality_expression$*$|_xpGmYl', 'equality_expression$*' ],
     [] ],
  'equality_expression$*$|_xpGmYl': 
   [ [ '\'==\'', 'relational_expression' ],
     [ '\'<>\'', 'relational_expression' ] ],
  'relational_expression$*': 
   [ [ '\'<\'', 'additive_expression', 'relational_expression$*' ],
     [] ],
  'additive_expression$*': 
   [ [ 'additive_expression$*$|_tagpRN', 'additive_expression$*' ],
     [] ],
  'additive_expression$*$|_tagpRN': 
   [ [ '\'+\'', 'multiplicative_expression' ],
     [ '\'-\'', 'multiplicative_expression' ] ],
  'multiplicative_expression$*': 
   [ [ 'multiplicative_expression$*$|_ftYWTj',
       'multiplicative_expression$*' ],
     [] ],
  'multiplicative_expression$*$|_ftYWTj': 
   [ [ '\'*\'', 'unary_expression' ],
     [ '\'/\'', 'unary_expression' ] ],
  'postfix_expression$*': 
   [ [ '\'[\'', 'expression', '\']\'', 'postfix_expression$*' ],
     [] ],
  'init_declarator_list$*': [ [ '\',\'', 'init_declarator', 'init_declarator_list$*' ], [] ],
  'init_declarator$?': [ [ '\'=\'', 'initializer' ], [] ],
  'declarator$*': [ [ '\'[\'', 'declarator$*$?', '\']\'', 'declarator$*' ], [] ],
  'declarator$*$?': [ [ 'constant_expression' ], [] ],
  'compound_statement$c_yOIygl': [ [ '\'}\'' ], [ 'statement_list', '\'}\'' ] ] };
if (exports) exports.grammar = grammar;
