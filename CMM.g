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
number
	: INT
	| REAL
	;
//expression
expression
	: assignment_expression
	;
primary_expression
	: number
	| IDENTIFIER
	;
multiplicative_expression
	: primary_expression '*' multiplicative_expression
	| primary_expression '/' multiplicative_expression
	| primary_expression
	;
additive_expression
	: multiplicative_expression '+' additive_expression
	| multiplicative_expression '-' additive_expression
	| multiplicative_expression
	;
//$(A9X$(B7O$(ATK$(B;;Id(B
/*
	a = 0
	a = b
	a = 1 + 1
	a = b = c + 1
*/
assignment_expression
	: IDENTIFIER assignment_operator number
	| IDENTIFIER assignment_operator expression
	;
//ignore self increase(decrease) right now
assignment_operator
	: '='
	| '+='
	| '-='
	| '*='
	| '/='
	;

		
//statement
statement
	: expression ';'
	;

INT
	: ('+'|'-')? ('0'..'9')+
	;
REAL
	: INT '.' INT ( ('e'|'E') ('+'|'-') INT )?
	;

COMMENT
    :   '/*' ( options {greedy=false;} : . )* '*/' {$channel=HIDDEN;}
    ;

LINE_COMMENT
    : '//' ~('\n'|'\r')* '\r'? '\n' {$channel=HIDDEN;}
    ;

//terminal
IDENTIFIER
	: ('a'..'z'|'A'..'Z')('a'..'z'|'A'..'Z'|'_'|'0'..'9')*('a'..'z'|'A'..'Z'|'0'..'9')?
	;
