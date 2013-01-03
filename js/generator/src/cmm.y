%left '='
%left '==' '<>' '<'
%left '+' '-'
%left '*' '/'

%start prog

%{
var g = require('./grammar');
var util = require('util');
%}

%%

prog
  : statement_list EOF
      {
        $$=new g.Program($1);
        console.log(util.inspect($$, false, null));
        console.log($$.assemble());
      }
  ;
statement_list
  : statement
      {$$=new g.StatementList($1);}
  | statement_list statement
      {$$=$1.appendChild($2);}
  ;
statement
  : compound_statement
      {$$=$1;}
  | expression_statement
      {$$=$1;}
  | selection_statement
      {$$=$1;}
  | iteration_statement
      {$$=$1;}
  | declaration
      {$$=$1;}
  ;

compound_statement
  : empty_compound_statement
      {$$=$1;}
  | wrapped_compound_statement
      {$$=$1;}
  ;
empty_compound_statement
  : '{' '}'
      {$$=new g.EmptyCompoundStatement();}
  ;
wrapped_compound_statement
  : '{' statement_list '}'
      {$$=new g.WrappedCompoundStatement($2);}
  ;

selection_statement
  : if_statement
      {$$=$1;}
  | if_else_statement
      {$$=$1;}
  ;
if_statement
  : 'if' '(' expression ')' statement
      {$$=new g.IfStatement($3, $5);}
  ;
if_else_statement
  : 'if' '(' expression ')' statement 'else' statement
      {$$=new g.IfElseStatement($3, $5, $7);}
  ;

iteration_statement
  : 'while' '(' expression ')' statement
      {$$=new g.WhileStatement($3, $5);}
  ;

expression_statement
  : empty_expression_statement
      {$$=$1;}
  | ended_expression_statement
      {$$=$1;}
  | write_expression_statement
      {$$=$1;}
  | read_expression_statement
      {$$=$1;}
  ;
empty_expression_statement
  : ';'
      {$$=new g.EmptyExpressionStatement();}
  ;
ended_expression_statement
  : expression ';'
      {$$=new g.EndedExpressionStatement($1);}
  ;
write_expression_statement
  : 'write' expression ';'
      {$$=new g.WriteExpressionStatement($2);}
  ;
read_expression_statement
  : 'read' IDENTIFIER
      {$$=new g.ReadExpressionStatement($2);}
  ;

expression
  : assignment_expression
      {$$=new g.Expression($1);}
  | expression ',' assignment_expression
      {$$=$1.appendChild($3);}
  ;
assignment_expression
  : equality_expression
      {$$=$1;}
  | lvalue_expression assignment_operator assignment_expression
      {$$=new g.AssignmentExpression($1, $2, $3);}
  ;
lvalue_expression
  : IDENTIFIER
      {$$=new g.LValueIdentifier($1);}
  | lvalue_expression '[' expression ']'
      {$$=$1.addPostfix($3);}
  ;
assignment_operator
  : '='
      {$$=$1;}
  | '+='
      {$$=$1;}
  | '-='
      {$$=$1;}
  | '*='
      {$$=$1;}
  | '/='
      {$$=$1;}
  ;
equality_expression
  : relational_expression
      {$$=$1;}
  | equality_expression equality_operator relational_expression
      {$$=new g.EqualityExpression($1, $2, $3);}
  ;
equality_operator
  : '=='
      {$$=$1;}
  | '<>'
      {$$=$1;}
  ;
relational_expression
  : additive_expression
      {$$=$1;}
  | relational_expression '<' additive_expression
      {$$=new g.RealtionalExpression($1, $3);}
  ;
additive_expression
  : multiplicative_expression
      {$$=$1;}
  | additive_expression '+' multiplicative_expression
      {$$=new g.AdditveExpression($1, $2, $3);}
  | additive_expression '-' multiplicative_expression
      {$$=new g.AdditveExpression($1, $2, $3);}
  ;
multiplicative_expression
  : unary_expression
      {$$=$1;}
  | multiplicative_expression '*' unary_expression
      {$$=new g.MultiplicativeExpression($1, $2, $3);}
  | multiplicative_expression '/' unary_expression
      {$$=new g.MultiplicativeExpression($1, $2, $3);}
  ;
unary_expression
  : postfix_expression
      {$$=$1;}
  | '+' unary_expression
      {$$=$1;}
  | minus_unary_expression
      {$$=$1;}
  ;
minus_unary_expression
  : '-' unary_expression
      {$$=new g.MinusUnaryExpression($2);}
  ;
postfix_expression
  : primary_expression
      {$$=$1;}
  | primary_expression '[' expression ']'
      {$$=$1.addPostfix($3);}
  ;
primary_expression
  : INT_LITERAL
      {$$=new g.IntLiteral($1);}
  | REAL_LITERAL
      {$$=new g.RealLiteral($1);}
  | IDENTIFIER
      {$$=new g.RValueIdentifier($1);}
  | '(' expression ')'
      {$$=new PrimaryExpression($2);}
  ;

declaration
  : declarator_specifiers init_declarator_list ';'
      {$$=new g.Declaration($1, $2);}
  ;
declarator_specifiers
  : 'int'
      {$$=$1;}
  | 'real'
      {$$=$1;}
  ;
init_declarator_list
  : init_declarator
      {$$=new g.InitDeclaratorList($1);}
  | init_declarator_list ',' init_declarator
      {$$=$1.appendChild($3);}
  ;
init_declarator
  : declarator
      {$$=$1;}
  | declarator '=' initializer
      {$1.init($3);}
  ;
declarator
  : IDENTIFIER
      {$$=new g.DeclaratorIdentifier($1);}
  | IDENTIFIER '[' constant_expression ']'
      {$$=$1.addPostfix($3);}
  ;
constant_expression
  : equality_expression
      {$$=$1;}
  ;
initializer
  : assignment_expression
      {$$=$1;}
  ;

%%
