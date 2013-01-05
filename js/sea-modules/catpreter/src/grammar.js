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
exports.Program = Program;

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
exports.StatementList = StatementList;

// EmptyCompoundStatement
function EmptyCompoundStatement () {
}
EmptyCompoundStatement.prototype.assemble = function () {
  return '';
};
exports.EmptyCompoundStatement = EmptyCompoundStatement;

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
exports.WrappedCompoundStatement = WrappedCompoundStatement;

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
exports.IfStatement = IfStatement;

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
exports.IfElseStatement = IfElseStatement;

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
exports.WhileStatement = WhileStatement;

// EmptyExpressionStatement
function EmptyExpressionStatement () {
}
EmptyExpressionStatement.prototype.assemble = function () {
  return '';
};
exports.EmptyExpressionStatement = EmptyExpressionStatement;

// EndedExpressionStatement
function EndedExpressionStatement (expression) {
  this.expression = expression;
}
EndedExpressionStatement.prototype.assemble = function () {
  return this.expression.assemble();
};
exports.EndedExpressionStatement = EndedExpressionStatement;

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
exports.WriteExpressionStatement = WriteExpressionStatement;

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
exports.ReadExpressionStatement = ReadExpressionStatement;

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
exports.Expression = Expression;

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
exports.AssignmentExpression = AssignmentExpression;

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
exports.EqualityExpression = EqualityExpression;

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
exports.RelationalExpression = RelationalExpression;

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
exports.AdditiveExpression = AdditiveExpression;

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
exports.MultiplicativeExpression = MultiplicativeExpression;

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
exports.MinusUnaryExpression = MinusUnaryExpression;

// IntLiteral
function IntLiteral (int_literal) {
  this.int_literal = int_literal;
}
IntLiteral.prototype.assemble = function () {
  return 'push '+this.int_literal;
};
exports.IntLiteral = IntLiteral;

// RealLiteral
function RealLiteral (real_literal) {
  this.real_literal = real_literal;
}
RealLiteral.prototype.assemble = function () {
  return 'push '+this.real_literal;
};
exports.RealLiteral = RealLiteral;

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
exports.Identifier = Identifier;

// PrimaryExpression
function PrimaryExpression (expression) {
  this.expression = expression;
}
PrimaryExpression.prototype.assemble = function () {
  return this.expression.assemble();
};
exports.PrimaryExpression = PrimaryExpression;

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
exports.Declaration = Declaration;

// InitDeclaratorList
function InitDeclaratorList (init_declarator) {
  this.init_declarators = [init_declarator];
}
InitDeclaratorList.prototype.appendChild = function (init_declarator) {
  this.init_declarators.push(init_declarator);
};
exports.InitDeclaratorList = InitDeclaratorList;
