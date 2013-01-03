(function(){

function StatementList (statement) {
  this.statement_list = [statement];
}
StatementList.prototype.appendChild = function (statement) {
  this.statement_list.push(statement);
};
exports.StatementList = StatementList;

function EmptyCompoundStatement () {
}
exports.EmptyCompoundStatement = EmptyCompoundStatement;

function WrappedCompoundStatement (statement_list) {
  this.statement_list = statement_list;
}
exports.WrappedCompoundStatement = WrappedCompoundStatement;

function IfStatement (condition, true_statement) {
  this.condition = condition;
  this.true_statement = true_statement;
}
exports.IfStatement = IfStatement;

function IfElseStatement (condition, true_statement, false_statement) {
  this.condition = condition;
  this.true_statement = true_statement;
  this.false_statement = false_statement;
}
exports.IfElseStatement = IfElseStatement;

function WhileStatement (condition, statement) {
  this.condition = condition;
  this.statement = statement;
}
exports.WhileStatement = WhileStatement;

function EmptyExpressionStatement () {
}
exports.EmptyExpressionStatement = EmptyExpressionStatement;

function EndedExpressionStatement (expression) {
  this.expression = expression;
}
exports.EndedExpressionStatement = EndedExpressionStatement;

function WriteExpressionStatement (expression) {
  this.expression = expression;
}
exports.WriteExpressionStatement = WriteExpressionStatement;

function ReadExpressionStatement (identifier, declarator_specifier) {
  this.identifier = identifier;
  this.declarator_specifier = declarator_specifier;
}
exports.ReadExpressionStatement = ReadExpressionStatement;

function Expression (assignment_expression) {
  this.assignment_expressions = [assignment_expression];
}
Expression.prototype.appendChild = function (assignment_expression) {
  this.assignment_expressions.push(assignment_expression);
};
exports.Expression = Expression;

function AssignmentExpression (unary_expression, assignment_operator, assignment_expression) {
  this.unary_expression = unary_expression;
  this.assignment_operator = assignment_operator;
  this.assignment_expression = assignment_expression;
}
exports.AssignmentExpression = AssignmentExpression;

function EqualityExpression (equality_expresion, equality_operator, relational_expression) {
  this.equality_expresion = equality_expresion;
  this.equality_operator = equality_operator;
  this.relational_expression = relational_expression;
}
exports.EqualityExpression = EqualityExpression;

function RelationalExpresssion (relational_expression, additive_expression) {
  this.relational_expression = relational_expression;
  this.additive_expression = additive_expression;
}
exports.RelationalExpresssion = RelationalExpresssion;

function AdditiveExpression (additive_expression, operator, multiplicative_expression) {
  this.additive_expression = additive_expression;
  this.operator = operator;
  this.multiplicative_expression = multiplicative_expression;
}
exports.AdditiveExpression = AdditiveExpression;

function MultiplicativeExpression (multiplicative_expression, operator, unary_expression) {
  this.multiplicative_expression = multiplicative_expression;
  this.operator = operator;
  this.unary_expression = unary_expression;
}
exports.MultiplicativeExpression = MultiplicativeExpression;

function MinusUnaryExpression (unary_expression) {
  this.unary_expression = unary_expression;
}
exports.MinusUnaryExpression = MinusUnaryExpression;

function IntLiteral (int_literal) {
  this.int_literal = int_literal;
}
exports.IntLiteral = IntLiteral;

function RealLiteral (real_literal) {
  this.real_literal = real_literal;
}
exports.RealLiteral = RealLiteral;

function Identifier (identifier) {
  this.identifier = identifier;
}
Identifier.prototype.addPostfix = function (expression) {
  this.postfixExpr = expression;
};
exports.Identifier = Identifier;

function PrimaryExpression (expression) {
  this.expression = expression;
}
exports.PrimaryExpression = PrimaryExpression;

function Declaration (declarator_specifier, init_declarator_list) {
  this.declarator_specifier = declarator_specifier;
  this.init_declarator_list = init_declarator_list;
}
exports.Declaration = Declaration;

function InitDeclaratorList (init_declarator) {
  this.init_declarators = [init_declarator];
}
InitDeclaratorList.prototype.appendChild = function (init_declarator) {
  this.init_declarators.push(init_declarator);
};
exports.InitDeclaratorList = InitDeclaratorList;

function InitDeclarator (declarator, initalizer) {
  this.declarator = declarator;
  this.initalizer = initalizer;
}
exports.InitDeclarator = InitDeclarator;

}());
