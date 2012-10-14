/*
ANSI C ANTLR v3 grammar

Refer to the following two webpages to figure out ANSI C grammar
References
	http://www.lysator.liu.se/c/ANSI-C-grammar-l.html
	http://www.lysator.liu.se/c/ANSI-C-grammar-y.html

cattail(http://www.cattail.me)
Sep 2012
*/
grammar CMM;
options {
	backtrack=true;
	memoize=true;
	k=2;
}
scope Symbols{
	Set types;
	HashMap values;
}
@header{
	import java.util.Set;
	import java.util.HashMap;
}

@members {
	Object getValue(String name) {
		for (int i = Symbols_stack.size()-1; i>=0; i--) {
			Symbols_scope scope = (Symbols_scope)Symbols_stack.get(i);
			if ( scope.values.containsKey(name) ) {
				return scope.values.get(name);
			}
		}
		return new Object();
	}
}

prog
scope Symbols;
@init {
  $Symbols::values= new HashMap();
}
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
scope Symbols; // blocks have a scope of symbols
@init {
  $Symbols::values = new HashMap();
}
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
unary_expression returns [Object value]
	: postfix_expression {$value=$postfix_expression.value;}
	| unary_operator unary_expression
		{
			switch($unary_operator.text){
				case "-":
					$value=-(Float)$value;
					break;
				case "+":
					$value=$value;
					break;
			}
		}
	;
postfix_expression returns [Object value]
	: primary_expression ('[' expression ']')*
		{$value=getValue($text);}
	;
primary_expression returns [Object value]
	: constant {$value=$constant.value;}
	| IDENTIFIER {$value=getValue($IDENTIFIER.text);}
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
		{
			$Symbols::values.put($declarator.text,0);
		}
	;
declarator
	: IDENTIFIER ('[' constant_expression? ']')*
	;
initializer
	: assignment_expression 
	;

constant returns [Object value]
	: INT_LITERAL {$value=Integer.parseInt($INT_LITERAL.text);}
	| REAL_LITERAL {$value=Float.parseFloat($REAL_LITERAL.text);}
	;
IDENTIFIER
	: LETTER (LETTER | '0'..'9' |  '_' )* ( LETTER | '0'..'9' )?
	;
fragment
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
	;
WS  :  (' '|'\r'|'\t'|'\u000C'|'\n') {$channel=HIDDEN;}
    ;
COMMENT
    :   '/*' ( options {greedy=false;} : . )* '*/' {$channel=HIDDEN;}
    ;
LINE_COMMENT
    : '//' ~('\n'|'\r')* '\r'? '\n' {$channel=HIDDEN;}
    ;
