## Introduction
This project is base on https://github.com/zaach/jison.
I start from my own catpreter when I realized that LL can't parse CMM language, then
I came across jison for help. Through out reading jison's source file, I learn more about
compiler and I was amazed about the power of BNF. The most interested part of jison is it
use BNF to define BNF. As the author told me, bootstraping is wonderful!

## Dependencies
* catjs
* jison
* jquery
* jquery ui
* jade
* seajs
* bootstrap
* codemirror

## Issue
* unable to dectect error address, only throw error outside
* type varify is not supported

## Feature
### EBNF
    ? 0-1
    * 0-*
    + 1-*
    | optional

## Virsual machine spec
### Assembly instruction
Following define a stack-oriented instruction set.
Stack-oriented defined instruction set differ from register-oriented instruction set in that it's instruction set use stack rather than registers for operation.

    def   define variable
    ld    load varible value into stack top
    st    store stack top into varible
    add   add top two element in stack,store result in accumulator
    sub   sub top two element in stack,store result in accumulator
    mul   multiple top two element in stack,store result in accumulator
    div   divide top two element in stack,store result in accumulator
    eq    test if top two element in stack are equal
    neq   test if top two element in stack are not equal
    lt    test if top element is little then under element in stack
    ja    change program count in all condition
    jt    change program count if stack top is truly value
    jf    change program count if stack top is falsy value
    push  push value in stack
    pop   pop stack top
    read  standard input
    write standard output
    label define label stand for address
    halt  end of program


### Registers
* sp: stack pointer
* pc: program count
* ac: accumulator(deprecated)

### Brief introdution
Virtual machine code definition.

    function Machine () {
      this.stack = []; // memory stack
      this.registers = {sp: 0, pc: 0, ac: 0};
      this.memory = []; // memory used to store instructions
      this.symbols = {};
      this.buffer = ''; // output buffer, could be seen as terminal or anything you like
    };

Stack operation.

Let's examine how Assembler works. We just explain the simplest part here, say we want to calculate `1 + 2` and `write` it in output. CMM compiler which create by Catpreter will do the work for us to create assembles so we don't need to afraid of lex, grammar analysis. Result assembles will be:

    push 1
    push 2
    write
    halt

Now let's take a look at these instructions to understack stack-oriented instruction-set.

     -------
    |       | 
    |-------|
    |       |
    |-------|
    |       | <-- stack top
     -------

`push 1`

     -------
    |       | 
    |-------|
    |       | <-- stack top
    |-------|
    |   1   |
     -------

`push 2`

     -------
    |       | <-- stack top
    |-------|
    |   2   | 
    |-------|
    |   1   |
     -------

`add`

     -------                   -------                     -------                     -------               
    |       | <-- stack top   |       |                   |       |                   |       |              
    |-------|                 |-------|                   |-------|                   |-------|              
    |   2   |                 |       | <-- stack top     |       |                   |       |   <-- stack top
    |-------|                 |-------|                   |-------|                   |-------|              
    |   1   |                 |   1   |                   |       |  <-- stack top    |   3   |             
     -------                   -------                     -------                     -------               

`write`

     -------
    |       | 
    |-------|
    |       |
    |-------|
    |       | <-- stack top
     -------

After all, we will get the result we want `3`

On the contrary, follow is what register-oriend instruction-set's behaviour:

     -------
    |       | <-- accumulator
     -------

     -------
    |       | <-- stack top 
    |-------|
    |   1   |
    |-------|
    |   2   |
     -------

`ld`

     -------
    |   1   | <-- accumulator
     -------

     -------
    |       | 
    |-------|
    |       | <-- stack top 
    |-------|
    |   2   |
     -------

`add`

     -------
    |   3   | <-- accumulator
     -------

     -------
    |       | 
    |-------|
    |       | 
    |-------|
    |       | <-- stack top
     -------

`st`

     -------
    |       | <-- accumulator
     -------

     -------
    |       | 
    |-------|
    |       | <-- stack top 
    |-------|
    |   3   |
     -------

I don't want to take a close look at why there are two approch and what's the difference and EVEN which is better, if you are interested, I recommand you to read this book `汇编语言与计算机体系结构,使用c++和Java`. I benefit a lot from this book.

## Catpreter spec
### BNF defined grammar
    prog
      : statement
      ;
    statement
      : compound_statement
      | expression_statement
      | selection_statement
      | iteration_statement
      | declaration
      ;
    compound_statement
      : '{' '}'
      | '{' statement_list '}'
      ;
    statement_list
      : ( statement )+
      ;
    expression_statement
      : ';'
      | expression ';'
      ;
    selection_statement
      : 'if' '(' expression ')' statement ( 'else' statement )?
      ;
    iteration_statement
      : 'while' '(' expression ')' statement
      ;
    expression
      : assignment_expression ( ',' assignment_expression )*
      ;
    constant_expression
      : equality_expression
      ;
    assignment_expression
      : equality_expression
      | primary_expression assignment_operator assignment_expression
      ;
    equality_expression
      : relational_expression ( '==' relational_expression | '<>' relational_expression )*
      ;
    relational_expression
      : additive_expression ( '<' additive_expression )*
      ;
    additive_expression
      : multiplicative_expression ( '+' multiplicative_expression | '-' multiplicative_expression )*
      ;
    multiplicative_expression
      : unary_expression ( '*' unary_expression | '/' unary_expression )*
      ;
    unary_expression
      : postfix_expression
      | unary_operator unary_expression
      ;
    postfix_expression
      : primary_expression ( '[' expression ']' )*
      ;
    primary_expression
      : constant
      | IDENTIFIER
      | '(' expression ')'
      ;
    declaration
      : declarator_specifiers init_declarator_list ';'
      ;
    declarator_specifiers
      : 'int'
      | 'real'
      ;
    init_declarator_list
      : init_declarator ( ',' init_declarator )*
      ;
    init_declarator
      : declarator ( '=' initializer )?
      ;
    declarator
      : IDENTIFIER ( '[' ( constant_expression )? ']' )*
      ;
    initializer
      : assignment_expression
      ;
    constant
      : INT_LITERAL
      | REAL_LITERAL
      ;
    assignment_operator
      : '='
      ;
    unary_operator
      : '+'
      | '-'
      | 'read'
      | 'write'
      ;

After grammar generator:

    // This file was generated automatically by genGrammar.js
    // Don't edit it directly
    var grammar = { prog: [ [ 'statement' ] ],
      statement: 
       [ [ 'compound_statement' ],
         [ 'expression_statement' ],
         [ 'selection_statement' ],
         [ 'iteration_statement' ],
         [ 'declaration' ] ],
      compound_statement: [ [ '\'{\'', '\'}\'' ], [ '\'{\'', 'statement_list', '\'}\'' ] ],
      statement_list: [ [ { '+': [ 'statement' ] } ] ],
      expression_statement: [ [ '\';\'' ], [ 'expression', '\';\'' ] ],
      selection_statement: 
       [ [ '\'if\'',
           '\'(\'',
           'expression',
           '\')\'',
           'statement',
           { '?': [ '\'else\'', 'statement' ] } ] ],
      iteration_statement: [ [ '\'while\'', '\'(\'', 'expression', '\')\'', 'statement' ] ],
      expression: 
       [ [ 'assignment_expression',
           { '*': [ '\',\'', 'assignment_expression' ] } ] ],
      constant_expression: [ [ 'equality_expression' ] ],
      assignment_expression: 
       [ [ 'equality_expression' ],
         [ 'primary_expression',
           'assignment_operator',
           'assignment_expression' ] ],
      equality_expression: 
       [ [ 'relational_expression',
           { '*': 
              [ { '|': 
                   [ [ '\'==\'', 'relational_expression' ],
                     [ '\'<>\'', 'relational_expression' ] ] } ] } ] ],
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
      unary_expression: 
       [ [ 'postfix_expression' ],
         [ 'unary_operator', 'unary_expression' ] ],
      postfix_expression: 
       [ [ 'primary_expression',
           { '*': [ '\'[\'', 'expression', '\']\'' ] } ] ],
      primary_expression: 
       [ [ 'constant' ],
         [ 'IDENTIFIER' ],
         [ '\'(\'', 'expression', '\')\'' ] ],
      declaration: [ [ 'declarator_specifiers', 'init_declarator_list', '\';\'' ] ],
      declarator_specifiers: [ [ '\'int\'' ], [ '\'real\'' ] ],
      init_declarator_list: [ [ 'init_declarator', { '*': [ '\',\'', 'init_declarator' ] } ] ],
      init_declarator: [ [ 'declarator', { '?': [ '\'=\'', 'initializer' ] } ] ],
      declarator: 
       [ [ 'IDENTIFIER',
           { '*': [ '\'[\'', { '?': [ 'constant_expression' ] }, '\']\'' ] } ] ],
      initializer: [ [ 'assignment_expression' ] ],
      constant: [ [ 'INT_LITERAL' ], [ 'REAL_LITERAL' ] ],
      assignment_operator: [ [ '\'=\'' ] ],
      unary_operator: [ [ '\'+\'' ], [ '\'-\'' ], [ '\'read\'' ], [ '\'write\'' ] ] };
    try{exports.grammar = grammar;}catch(err){}

After eliminate left recursive, extract common factor and expand EBNF `? * +`:

    { prog: [ [ 'statement' ] ],
      statement: 
       [ [ 'compound_statement' ],
         [ 'expression_statement' ],
         [ 'selection_statement' ],
         [ 'iteration_statement' ],
         [ 'declaration' ] ],
      compound_statement: [ [ '\'{\'', 'compound_statement$c_cJFmBc' ] ],
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
       [ [ 'equality_expression$*$|_pynGFz', 'equality_expression$*' ],
         [] ],
      'equality_expression$*$|_pynGFz': 
       [ [ '\'==\'', 'relational_expression' ],
         [ '\'<>\'', 'relational_expression' ] ],
      'relational_expression$*': 
       [ [ '\'<\'', 'additive_expression', 'relational_expression$*' ],
         [] ],
      'additive_expression$*': 
       [ [ 'additive_expression$*$|_CuSWdJ', 'additive_expression$*' ],
         [] ],
      'additive_expression$*$|_CuSWdJ': 
       [ [ '\'+\'', 'multiplicative_expression' ],
         [ '\'-\'', 'multiplicative_expression' ] ],
      'multiplicative_expression$*': 
       [ [ 'multiplicative_expression$*$|_FhAVbz',
           'multiplicative_expression$*' ],
         [] ],
      'multiplicative_expression$*$|_FhAVbz': 
       [ [ '\'*\'', 'unary_expression' ],
         [ '\'/\'', 'unary_expression' ] ],
      'postfix_expression$*': 
       [ [ '\'[\'', 'expression', '\']\'', 'postfix_expression$*' ],
         [] ],
      'init_declarator_list$*': [ [ '\',\'', 'init_declarator', 'init_declarator_list$*' ], [] ],
      'init_declarator$?': [ [ '\'=\'', 'initializer' ], [] ],
      'declarator$*': [ [ '\'[\'', 'declarator$*$?', '\']\'', 'declarator$*' ], [] ],
      'declarator$*$?': [ [ 'constant_expression' ], [] ],
      'compound_statement$c_cJFmBc': [ [ '\'}\'' ], [ 'statement_list', '\'}\'' ] ] }

## CMM lex
    DIGIT                     \d+
    INT                       {DIGIT}+ 
    REAL                      {INT}\.{INT}('e'[-+]?{INT})?
    LETTER                    [a-zA-Z]
    NUMBER                    [0-9]
    IDENTIFIER                {LETTER}({LETTER}|{NUMBER}|'_')*

    "//".*                  /* ignore line comment */
    "/*"                    {this.begin('comment');}
    <comment>"*/"           {this.popState();}
    <comment>.              {/* skip comment content*/}
    \s+                     /* ignore white space */
    "if"                    return 'if';
    "else"                  return 'else';
    "while"                 return 'while';
    "read"                  return 'read';
    "write"                 return 'write';
    "int"                   return 'int';
    "real"                  return 'real';
    {REAL}                  return 'REAL_LITERAL';
    {INT}                   return 'INT_LITERAL';
    {IDENTIFIER}            return 'IDENTIFIER';
    "+="                    return '+=';
    "-="                    return '-=';
    "*="                    return '*=';
    "/="                    return '/=';
    "=="                    return '==';
    "<>"                    return '<>';
    "+"                     return '+';
    "-"                     return '-';
    "*"                     return '*';
    "/"                     return '/';
    "<"                     return '<';
    "["                     return '[';
    "]"                     return ']';
    "="                     return '=';
    "("                     return '(';
    ")"                     return ')';
    ";"                     return ';';
    "{"                     return '{';
    "}"                     return '}';
    ","                     return ',';
    .                       /* ignore */

## CMM grammar
    %start prog
    prog
      : statement_list EOF
      ;
    statement_list
      : statement
      | statement_list statement
      ;
    statement
      : compound_statement
      | expression_statement
      | selection_statement
      | iteration_statement
      | declaration
      ;

    compound_statement
      : empty_compound_statement
      | wrapped_compound_statement
      ;
    empty_compound_statement
      : '{' '}'
      ;
    wrapped_compound_statement
      : '{' statement_list '}'
      ;

    selection_statement
      : if_statement
      | if_else_statement
      ;
    if_statement
      : 'if' '(' expression ')' statement
      ;
    if_else_statement
      : 'if' '(' expression ')' statement 'else' statement
      ;

    iteration_statement
      : 'while' '(' expression ')' statement
      ;

    expression_statement
      : empty_expression_statement
      | ended_expression_statement
      | write_expression_statement
      | read_expression_statement
      ;
    empty_expression_statement
      : ';'
      ;
    ended_expression_statement
      : expression ';'
      ;
    write_expression_statement
      : 'write' expression ';'
      ;
    read_expression_statement
      : 'read' IDENTIFIER
      ;

    expression
      : assignment_expression
      | expression ',' assignment_expression
      ;
    assignment_expression
      : equality_expression
      | postfix_expression assignment_operator assignment_expression
      ;
    assignment_operator
      : '='
      | '+='
      | '-='
      | '*='
      | '/='
      ;
    equality_expression
      : relational_expression
      | equality_expression equality_operator relational_expression
      ;
    equality_operator
      : '=='
      | '<>'
      ;
    relational_expression
      : additive_expression
      | relational_expression '<' additive_expression
      ;
    additive_expression
      : multiplicative_expression
      | additive_expression '+' multiplicative_expression
      | additive_expression '-' multiplicative_expression
      ;
    multiplicative_expression
      : unary_expression
      | multiplicative_expression '*' unary_expression
      | multiplicative_expression '/' unary_expression
      ;
    unary_expression
      : postfix_expression
      | '+' unary_expression
      | minus_unary_expression
      ;
    minus_unary_expression
      : '-' unary_expression
      ;
    postfix_expression
      : primary_expression
      | primary_expression '[' INT_LITERAL ']'
      ;
    primary_expression
      : INT_LITERAL
      | REAL_LITERAL
      | IDENTIFIER
      | '(' expression ')'
      ;

    declaration
      : declarator_specifiers init_declarator_list ';'
      ;
    declarator_specifiers
      : 'int'
      | 'real'
      ;
    init_declarator_list
      : init_declarator
      | init_declarator_list ',' init_declarator
      ;
    init_declarator
      : declarator
      | declarator '=' initializer
      ;
    declarator
      : IDENTIFIER
      | declarator '[' INT_LITERAL ']'
      ;
    initializer
      : assignment_expression
      ;
