/*
ANSI C ANTLR v3 grammar

refer to the following two webpages to figure out ANSI C grammar
References
	http://www.lysator.liu.se/c/ANSI-C-grammar-l.html
	http://www.lysator.liu.se/c/ANSI-C-grammar-y.html#init-declarator-list

cattail(http://www.cattail.me)
Sep 2012
*/
grammar CMM;


statement
	: compound_statement
	| expression_statement
	| selection_statement
	| iteration_statement
	;
compound_statement
	:
	;
expression_statement
	: ';'
	| expression ';'
	;
selection_statement
	:
	;
iteration_statement
	:
	;

expression
	: assignment_expression
	;
//TODO 对左递归进行重构
/*
实例
additive_expression
	: (multiplicative_expression) ('+' multiplicative_expression | '-' multiplicative_expression)*
	;
*/
assignment_expression
	: equality_expression
	| primary_expression assignment_operator assignment_expression
	;
equality_expression
	: relational_expression
	| equality_expression EQ_OP relational_expression 
	| equality_expression NE_OP relational_expression
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
	: primary_expression
	| multiplicative_expression '*' primary_expression
	| multiplicative_expression '/' primary_expression
	;
primary_expression
	: CONSTANT
	| IDENTIFIER
	| '(' expression ')'
	;
CONSTANT
	: INT
	| REAL
	;
IDENTIFIER
	: ('a'..'z'|'A'..'Z')('a'..'z'|'A'..'Z'|'_'|'0'..'9')*('a'..'z'|'A'..'Z'|'0'..'9')?
	;
INT
	: ('+'|'-')? ('0'..'9')+
	;
REAL
	: INT '.' INT ( ('e'|'E') ('+'|'-') INT )?
	;
assignment_operator
	: '='
	| '+='
	| '-='
	| '*='
	| '/='
	;
declaration
	: type init_declarator_list ';'
	;
type
	: 'int'
	| 'real'
	;
init_declarator_list
	: init_declarator
	| init_declarator ',' init_declarator_list
	;
init_declarator
	: IDENTIFIER '=' number
	;

COMMENT
    :   '/*' ( options {greedy=false;} : . )* '*/' {$channel=HIDDEN;}
    ;

LINE_COMMENT
    : '//' ~('\n'|'\r')* '\r'? '\n' {$channel=HIDDEN;}
    ;
EQ_OP
	: '=='
	;
NE_OP
	: '<>'
	;
