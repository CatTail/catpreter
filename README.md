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
* if_else statement parse error

## Feature
### EBNF
    ? 0-1
    * 0-*
    + 1-*
    | optional

## virsual machine spec
### assembly instruction
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


### registers
* sp: stack pointer
* pc: program count
* ac: accumulator(deprecated)

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
