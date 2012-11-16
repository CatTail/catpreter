{ selection_statement: 
   [ [ '\'if\'',
       '\'(\'',
       'expression',
       '\')\'',
       'statement',
       'selection_statement$?' ] ],
  init_declarator: [ [ 'declarator', 'init_declarator$?' ] ],
  declarator: [ [ 'IDENTIFIER', 'declarator$*' ] ],
  expression: [ [ 'assignment_expression', 'expression$*' ] ],
  equality_expression: [ [ 'relational_expression', 'equality_expression$*' ] ],
  relational_expression: [ [ 'additive_expression', 'relational_expression$*' ] ],
  additive_expression: [ [ 'multiplicative_expression', 'additive_expression$*' ] ],
  multiplicative_expression: [ [ 'unary_expression', 'multiplicative_expression$*' ] ],
  statement_list: [ [ 'statement+' ] ],
  'selection_statement$?': [ [ '\'else\'', 'statement' ], [] ],
  'init_declarator$?': [ [ '\'=\'', 'initializer' ], [] ],
  'declarator$*': [ [ '\'[\'', 'declarator$*$?', '\']\'', 'declarator$*' ], [] ],
  'declarator$*$?': [ [ 'constant_expression' ], [] ],
  'expression$*': [ [ '\',\'', 'assignment_expression', 'expression$*' ], [] ],
  'equality_expression$*': 
   [ [ 'equality_expression$*$|_OhMmYm', 'equality_expression$*' ],
     [] ],
  'equality_expression$*$|_OhMmYm': 
   [ [ 'EQ_OP', 'relational_expression' ],
     [ 'NE_OP', 'relational_expression' ] ],
  'relational_expression$*': 
   [ [ '\'<\'', 'additive_expression', 'relational_expression$*' ],
     [] ],
  'additive_expression$*': 
   [ [ 'additive_expression$*$|_fWUtfu', 'additive_expression$*' ],
     [] ],
  'additive_expression$*$|_fWUtfu': 
   [ [ '\'+\'', 'multiplicative_expression' ],
     [ '\'-\'', 'multiplicative_expression' ] ],
  'multiplicative_expression$*': 
   [ [ 'multiplicative_expression$*$|_angUPx',
       'multiplicative_expression$*' ],
     [] ],
  'multiplicative_expression$*$|_angUPx': 
   [ [ '\'*\'', 'unary_expression' ],
     [ '\'/\'', 'unary_expression' ] ] }
