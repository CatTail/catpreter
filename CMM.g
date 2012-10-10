/*
ANSI C ANTLR v3 grammar

refer to the following two webpages to figure out ANSI C grammar
References
	http://www.lysator.liu.se/c/ANSI-C-grammar-l.html
	http://www.lysator.liu.se/c/ANSI-C-grammar-y.html

cattail(http://www.cattail.me)
Sep 2012
*/
grammar CMM;

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
assignment_expression
options {backtrack=true;}
	: equality_expression
	| primary_expression ASSIGNMENT_OPERATOR assignment_expression
	;
equality_expression
	: relational_expression ( EQ_OP relational_expression | NE_OP relational_expression )*
	;
relational_expression
	: additive_expression ( '<' additive_expression )*
	;
additive_expression
	: multiplicative_expression ( '+' multiplicative_expression | '-' multiplicative_expression )
	;
multiplicative_expression
	: primary_expression ( '*' primary_expression | '/' primary_expression )
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
	: declarator
	| declarator '=' initializer
	;
declarator
	: IDENTIFIER
	;
initializer
	: assignment_expression 
	;

COMMENT
    :   '/*' ( options {greedy=false;} : . )* '*/' {$channel=HIDDEN;}
    ;
LINE_COMMENT
    : '//' ~('\n'|'\r')* '\r'? '\n' {$channel=HIDDEN;}
    ;
constant
	: INT_LITERAL
	| REAL_LITERAL
	;
IDENTIFIER
	: ('a'..'z'|'A'..'Z')('a'..'z'|'A'..'Z'|'_'|'0'..'9')*('a'..'z'|'A'..'Z'|'0'..'9')?
	;
INT_LITERAL
	: ('+'|'-')? ('0'..'9')+
	;
REAL_LITERAL
	: INT_LITERAL '.' INT_LITERAL ( ('e'|'E') ('+'|'-') INT_LITERAL )?
	;
ASSIGNMENT_OPERATOR
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
