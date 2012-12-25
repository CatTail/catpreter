%left '='
%left '==' '<>' '<'
%left '+' '-'
%left '*' '/'

%start prog

%{
%}

%%

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
  : '{' '}'
  | '{' statement_list '}'
  ;
expression_statement
  : ';'
  | expression ';'
  | 'write' expression ';'
  | 'read' IDENTIFIER declarator_specifiers
  ;
selection_statement
  : 'if' '(' expression ')' statement
  | 'if' '(' expression ')' statement 'else' statement
  ;
iteration_statement
  : 'while' '(' expression ')' statement
  ;
expression
  : assignment_expression
  | expression ',' assignment_expression
  ;
assignment_expression
  : equality_expression
  | unary_expression '=' assignment_expression
  | unary_expression '+=' assignment_expression
  | unary_expression '-=' assignment_expression
  | unary_expression '*=' assignment_expression
  | unary_expression '/=' assignment_expression
  ;
equality_expression
  : relational_expression
  | equality_expression '==' relational_expression
  | equality_expression '<>' relational_expression
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
  | '-' unary_expression
  ;
postfix_expression
  : primary_expression
  | postfix_expression '[' expression ']'
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
  | declarator '[' constant_expression ']'
  ;
constant_expression
  : equality_expression
  ;
initializer
  : assignment_expression
  ;

%%
