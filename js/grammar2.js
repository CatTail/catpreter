{ selection_statement: 
   [ [ '\'if\'',
       '\'(\'',
       'expression',
       '\')\'',
       'statement',
       'selection_statement$?_ZxmyLj' ] ],
  init_declarator: [ [ 'declarator', 'init_declarator$?_WYcVos' ] ],
  declarator: [ [ 'IDENTIFIER', 'declarator$*_xkzwJf' ] ],
  expression: [ [ 'assignment_expression', 'expression$*_SbpbXh' ] ],
  equality_expression: [ [ 'relational_expression', 'equality_expression$*_uMUVrU' ] ],
  relational_expression: [ [ 'additive_expression', 'relational_expression$*_ZXMuWM' ] ],
  additive_expression: [ [ 'multiplicative_expression', 'additive_expression$*_GoxGbS' ] ],
  multiplicative_expression: [ [ 'unary_expression', 'multiplicative_expression$*_EAgObR' ] ],
  statement_list: [ [ 'statement+' ] ],
  'selection_statement$?_ZxmyLj': [ [ '\'else\'', 'statement' ], [] ],
  'init_declarator$?_WYcVos': [ [ '\'=\'', 'initializer' ], [] ],
  'declarator$*_xkzwJf': 
   [ [ '\'[\'',
       { '?': [ 'constant_expression' ] },
       '\']\'',
       'declarator$*_xkzwJf' ],
     [] ],
  'expression$*_SbpbXh': 
   [ [ '\',\'', 'assignment_expression', 'expression$*_SbpbXh' ],
     [] ],
  'equality_expression$*_uMUVrU': 
   [ [ { '|': 
          [ [ 'EQ_OP', 'relational_expression' ],
            [ 'NE_OP', 'relational_expression' ] ] },
       'equality_expression$*_uMUVrU' ],
     [] ],
  'relational_expression$*_ZXMuWM': 
   [ [ '\'<\'',
       'additive_expression',
       'relational_expression$*_ZXMuWM' ],
     [] ],
  'additive_expression$*_GoxGbS': 
   [ [ { '|': 
          [ [ '\'+\'', 'multiplicative_expression' ],
            [ '\'-\'', 'multiplicative_expression' ] ] },
       'additive_expression$*_GoxGbS' ],
     [] ],
  'multiplicative_expression$*_EAgObR': 
   [ [ { '|': 
          [ [ '\'*\'', 'unary_expression' ],
            [ '\'/\'', 'unary_expression' ] ] },
       'multiplicative_expression$*_EAgObR' ],
     [] ] }
