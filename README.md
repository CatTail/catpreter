## Introduction
This project is base on https://github.com/zaach/jison.
I start from my own catpreter when I realized that LL can't parse CMM language, then
I came across jison for help. Through out reading jison's source file, I learn more about
compiler and I was amazed about the power of BNF. The most interested part of jison is it
use BNF to define BNF. As the author told me, bootstraping is wonderful!

## TODO
* 通过构建节点类实现语法树构建 

## Issue
* primary_expression should not contain CONSTANT values

## middle code
goto
def

## virsual machine spec
### registers
* sp: stack pointer
* pc: program count

### memory
stack


## EBNF
    ? 0-1
    * 0-*
    + 1-*
    | optional

## CMM lex
    +
    -
    *
    /
    <
    ==
    <>
    [
    ]
    =
    if
    else
    while
    read
    write
    int
    real
    960
    4.6e-10
    identifier
    (
    )
    ;
    {
    }
    //
    /*
    */

## CMM grammar
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
      : statement+
      ;
    expression_statement
      : ';'
      | expression ';'
      ;
    selection_statement
      : 'if' '(' expression ')' statement (options {k=1; backtrack=false;}:'else' statement)?
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
      : relational_expression ( EQ_OP relational_expression | NE_OP relational_expression )*
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
    unary_expression returns
      : postfix_expression
      | unary_operator unary_expression
      ;
    postfix_expression
      : primary_expression ('[' expression ']')*
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
      : declarator ('=' initializer)?
      ;
    declarator
      : IDENTIFIER ('[' constant_expression? ']')*
      ;
    initializer
      : assignment_expression 
      ;
    constant
      : INT_LITERAL
      | REAL_LITERAL
      ;
    IDENTIFIER
      : LETTER (LETTER | '0'..'9' |  '_' )* ( LETTER | '0'..'9' )?
      ;
    LETTER
      : ('a'..'z'|'A'..'Z')
      ;
    INT_LITERAL
      : ('0'..'9')+
      ;
    REAL_LITERAL
      : INT_LITERAL '.' INT_LITERAL ( ('e'|'E') ('+'|'-') INT_LITERAL )?
      ;
    assignment_operator
      : '='
      | '+='
      | '-='
      | '*='
      | '/='
      ;
    EQ_OP
      : '=='
      ;
    NE_OP
      : '<>'
      ;
    unary_operator
      : '+'
      | '-'
      | 'read'
      | 'write'
      ;
    WS
     :  (' '|'\r'|'\t'|'\u000C'|'\n')
     ;
