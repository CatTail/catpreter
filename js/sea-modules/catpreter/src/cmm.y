%left '='
%left '==' '<>' '<'
%left '+' '-'
%left '*' '/'

%start prog

%{
var g = {};
// utils
var random = (function(){
  var ranNum = function(min, max) {
    min = min || 0;
    max = max || 9;
    return Math.floor(Math.random() * (max - min) + min);
  };
  return function (len, range) {
    var alphabet = 'abcdefghijklmnopqistuvwxyzABCDEFGHIJKLMNOPQISTUVWXYZ';
    if (arguments.length === 1) {
      // supplied with one argument
      if (typeof len === 'number') {
        range = alphabet;
      } else {
        range = len;
        len = 4;
      }
    } else {
      len = len || 4;
      range = range || alphabet;
    }
    var str = '';
    for ( ; len>0; len-- ) {
      str += range[ranNum(0, range.length)];
    }
    return str;
  };
}());

function createLabel () {
  return random(8);
}

// Program
function Program (statement_list) {
  this.statement_list = statement_list;
}
Program.prototype.assemble = function () {
  var buf = [], buf2 = [], i;
  buf.push(this.statement_list.assemble());
  buf.push('halt');
  // remove empty instruction
  buf = buf.join('\n').split('\n');
  for (i=0; i<buf.length; i++) {
    if (buf[i] !== '') {
      buf2.push(buf[i]);
    }
  }
  return buf2.join('\n');
};
g.Program = Program;

// StatementList
function StatementList (statement) {
  this.statement_list = [statement];
}
StatementList.prototype.appendChild = function (statement) {
  this.statement_list.push(statement);
};
StatementList.prototype.assemble = function () {
  var buf = [], i;
  for (i=0; i<this.statement_list.length; i++) {
    buf.push(this.statement_list[i].assemble());
  }
  return buf.join('\n');
};
g.StatementList = StatementList;

// EmptyCompoundStatement
function EmptyCompoundStatement () {
}
EmptyCompoundStatement.prototype.assemble = function () {
  return '';
};
g.EmptyCompoundStatement = EmptyCompoundStatement;

// WrappedCompoundStatement
function WrappedCompoundStatement (statement_list) {
  this.start_label = createLabel();
  this.statement_list = statement_list;
  this.end_label = createLabel();
}
WrappedCompoundStatement.prototype.assemble = function () {
  var buf = [];
  buf.push('label '+this.start_label);
  buf.push(this.statement_list.assemble());
  buf.push('label '+this.end_label);
  return buf.join('\n');
};
g.WrappedCompoundStatement = WrappedCompoundStatement;

// IfStatement
function IfStatement (condition, true_statement) {
  this.condition = condition;
//  this.start_label = createLabel();
  this.true_statement = true_statement;
  this.end_label = createLabel();
}
IfStatement.prototype.assemble = function () {
  var buf = [];
  buf.push(this.condition.assemble());
  buf.push('jf '+this.end_label);
  buf.push(this.true_statement.assemble());
  buf.push('label '+this.end_label);
  return buf.join('\n');
};
g.IfStatement = IfStatement;

// IfElseStatement
function IfElseStatement (condition, true_statement, false_statement) {
  this.condition = condition;
  this.true_statement = true_statement;
  this.else_label = createLabel();
  this.false_statement = false_statement;
  this.end_label = createLabel();
}
IfElseStatement.prototype.assemble = function () {
  var buf = [];
  buf.push(this.condition.assemble());
  buf.push('jf '+this.else_label);
  buf.push(this.true_statement.assemble());
  buf.push('ja '+this.end_label);
  buf.push('label '+this.else_label);
  buf.push(this.false_statement.assemble());
  buf.push('label '+this.end_label);
  return buf.join('\n');
};
g.IfElseStatement = IfElseStatement;

// WhileStatement
function WhileStatement (condition, statement) {
  this.start_label = createLabel();
  this.condition = condition;
  this.statement = statement;
  this.end_label = createLabel();
}
WhileStatement.prototype.assemble = function () {
  var buf = [];
  buf.push('label '+this.start_label);
  buf.push(this.condition.assemble());
  buf.push('jf '+this.end_label);
  buf.push(this.statement.assemble());
  buf.push('ja '+this.start_label);
  buf.push('label '+this.end_label);
  return buf.join('\n');
};
g.WhileStatement = WhileStatement;

// EmptyExpressionStatement
function EmptyExpressionStatement () {
}
EmptyExpressionStatement.prototype.assemble = function () {
  return '';
};
g.EmptyExpressionStatement = EmptyExpressionStatement;

// EndedExpressionStatement
function EndedExpressionStatement (expression) {
  this.expression = expression;
}
EndedExpressionStatement.prototype.assemble = function () {
  return this.expression.assemble();
};
g.EndedExpressionStatement = EndedExpressionStatement;

// WriteExpressionStatement
function WriteExpressionStatement (expression) {
  this.expression = expression;
}
WriteExpressionStatement.prototype.assemble = function () {
  var buf = [];
  buf.push(this.expression.assemble());
  buf.push('write');
  return buf.join('\n');
};
g.WriteExpressionStatement = WriteExpressionStatement;

// ReadExpressionStatement
function ReadExpressionStatement (identifier) {
  this.identifier = identifier;
}
ReadExpressionStatement.prototype.assemble = function () {
  var buf = [];
  buf.push('read');
  buf.push('st '+this.identifier);
  return buf.join('\n');
};
g.ReadExpressionStatement = ReadExpressionStatement;

// Expression
function Expression (assignment_expression) {
  this.assignment_expressions = [assignment_expression];
}
Expression.prototype.appendChild = function (assignment_expression) {
  this.assignment_expressions.push(assignment_expression);
};
Expression.prototype.assemble = function () {
  var buf = [], i;
  for (i=0; i<this.assignment_expressions.length; i++) {
    buf.push(this.assignment_expressions[i].assemble());
  }
  return buf.join('\n');
};
g.Expression = Expression;

// AssignmentExpression
function AssignmentExpression (lvalue, assignment_operator, assignment_expression) {
  this.lvalue = lvalue;
  this.assignment_operator = assignment_operator;
  this.assignment_expression = assignment_expression;
}
AssignmentExpression.prototype.assemble = function () {
  // TODO: add assignment_operator switch
  var buf = [];
  buf.push(this.assignment_expression.assemble());
//  buf.push(this.lvalue.getIdentifier());
//  buf.push(this.lvalue.assemble('lvalue'));
  buf.push('st '+this.lvalue.getIdentifier());
  return buf.join('\n');
};
g.AssignmentExpression = AssignmentExpression;

// EqualityExpression
function EqualityExpression (equality_expresion, equality_operator, relational_expression) {
  this.equality_expresion = equality_expresion;
  this.equality_operator = equality_operator;
  this.relational_expression = relational_expression;
}
EqualityExpression.prototype.assemble = function () {
  var buf = [];
  buf.push(this.equality_expresion.assemble());
  buf.push(this.relational_expression.assemble());
  switch (this.equality_operator) {
    case '==':
      buf.push('eq');
    break;
    case '<>':
      buf.push('neq');
    break;
  }
  return buf.join('\n');
};
g.EqualityExpression = EqualityExpression;

// RelationalExpression
function RelationalExpression (relational_expression, additive_expression) {
  this.relational_expression = relational_expression;
  this.additive_expression = additive_expression;
}
RelationalExpression.prototype.assemble = function () {
  var buf = [];
  buf.push(this.relational_expression.assemble());
  buf.push(this.additive_expression.assemble());
  buf.push('lt');
  return buf.join('\n');
};
g.RelationalExpression = RelationalExpression;

// AdditiveExpression
function AdditiveExpression (additive_expression, operator, multiplicative_expression) {
  this.additive_expression = additive_expression;
  this.operator = operator;
  this.multiplicative_expression = multiplicative_expression;
}
AdditiveExpression.prototype.assemble = function () {
  var buf = [];
  buf.push(this.additive_expression.assemble());
  buf.push(this.multiplicative_expression.assemble());
  switch (this.operator) {
    case '+':
      buf.push('add');
    break;
    case '-':
      buf.push('sub');
    break;
  }
  return buf.join('\n');
};
g.AdditiveExpression = AdditiveExpression;

// MultiplicativeExpression
function MultiplicativeExpression (multiplicative_expression, operator, unary_expression) {
  this.multiplicative_expression = multiplicative_expression;
  this.operator = operator;
  this.unary_expression = unary_expression;
}
MultiplicativeExpression.prototype.assemble = function () {
  var buf = [];
  buf.push(this.multiplicative_expression.assemble());
  buf.push(this.unary_expression.assemble());
  switch (this.operator) {
    case '*':
      buf.push('mul');
    break;
    case '/':
      buf.push('div');
    break;
  }
  return buf.join('\n');
}
g.MultiplicativeExpression = MultiplicativeExpression;

// MinusUnaryExpression
function MinusUnaryExpression (unary_expression) {
  this.unary_expression = unary_expression;
}
MinusUnaryExpression.prototype.assemble = function () {
  var buf = [];
  buf.push(this.unary_expression.assemble());
  buf.push('push -1');
  buf.push('mul');
  return buf.join('\n');
};
g.MinusUnaryExpression = MinusUnaryExpression;

// IntLiteral
function IntLiteral (int_literal) {
  this.int_literal = int_literal;
}
IntLiteral.prototype.assemble = function () {
  return 'push '+this.int_literal;
};
g.IntLiteral = IntLiteral;

// RealLiteral
function RealLiteral (real_literal) {
  this.real_literal = real_literal;
}
RealLiteral.prototype.assemble = function () {
  return 'push '+this.real_literal;
};
g.RealLiteral = RealLiteral;

// Identifier
function Identifier (identifier) {
  this.identifier = identifier;
}
Identifier.prototype.addPostfix = function (int_literal) {
  this.postfix ? this.postfix.push(int_literal) : this.postfix = [int_literal];
};
Identifier.prototype.getPostfix = function () {
  if (this.postfix) {
    return ['[', this.postfix.join(','), ']'].join('');
  }
  return '';
};
Identifier.prototype.getIdentifier = function () {
  return this.identifier + this.getPostfix();
};
Identifier.prototype.init = function (initializer) {
  this.initializer = initializer;
};
Identifier.prototype.assemble = function (type) {
  // only right value will call this method
  return 'ld '+this.getIdentifier();
};
g.Identifier = Identifier;

// PrimaryExpression
function PrimaryExpression (expression) {
  this.expression = expression;
}
PrimaryExpression.prototype.assemble = function () {
  return this.expression.assemble();
};
g.PrimaryExpression = PrimaryExpression;

// Declaration
function Declaration (declarator_specifier, init_declarator_list) {
  this.declarator_specifier = declarator_specifier;
  this.init_declarator_list = init_declarator_list;
}
Declaration.prototype.assemble = function () {
  var buf = [], i, declarator;
  for (i=0; i<this.init_declarator_list.init_declarators.length; i++) {
    declarator = this.init_declarator_list.init_declarators[i];
    buf.push(
      declarator.initializer ? declarator.initializer.assemble() : 'push NULL'
    );
    buf.push(
      ['def', this.declarator_specifier+declarator.getPostfix(), declarator.identifier].join(' ')
    );
  }
  return buf.join('\n');
};
g.Declaration = Declaration;

// InitDeclaratorList
function InitDeclaratorList (init_declarator) {
  this.init_declarators = [init_declarator];
}
InitDeclaratorList.prototype.appendChild = function (init_declarator) {
  this.init_declarators.push(init_declarator);
};
g.InitDeclaratorList = InitDeclaratorList;

%}

%%

prog
  : statement_list EOF
      {
        $$=new g.Program($1);
        return $$.assemble();
      }
  ;
statement_list
  : statement
      {$$=new g.StatementList($1);}
  | statement_list statement
      {$1.appendChild($2);$$=$1;}
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
      {$1.appendChild($3);$$=$1;}
  ;
assignment_expression
  : equality_expression
      {$$=$1;}
  | postfix_expression assignment_operator assignment_expression
      {$$=new g.AssignmentExpression($1, $2, $3);}
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
      {$$=new g.RelationalExpression($1, $3);}
  ;
additive_expression
  : multiplicative_expression
      {$$=$1;}
  | additive_expression '+' multiplicative_expression
      {$$=new g.AdditiveExpression($1, $2, $3);}
  | additive_expression '-' multiplicative_expression
      {$$=new g.AdditiveExpression($1, $2, $3);}
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
  | primary_expression '[' INT_LITERAL ']'
      {$1.addPostfix($3);$$=$1;}
  ;
primary_expression
  : INT_LITERAL
      {$$=new g.IntLiteral($1);}
  | REAL_LITERAL
      {$$=new g.RealLiteral($1);}
  | IDENTIFIER
      {$$=new g.Identifier($1);}
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
      {$1.appendChild($3);$$=$1;}
  ;
init_declarator
  : declarator
      {$$=$1;}
  | declarator '=' initializer
      {$1.init($3);}
  ;
declarator
  : IDENTIFIER
      {$$=new g.Identifier($1);}
  | declarator '[' INT_LITERAL ']'
      {$1.addPostfix($3);$$=$1;}
  ;
initializer
  : assignment_expression
      {$$=$1;}
  ;

%%
