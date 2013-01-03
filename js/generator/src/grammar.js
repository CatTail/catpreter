(function(){
function StatementList (statement) {
}
StatementList.prototype.appendChild = function (statement) {
};

function EmptyCompoundStatement () {
}

function WrappedCompoundStatement (statement_list) {
}

function IfStatement (expression, true_statement) {
}

function IfElseStatement (expression, true_statement, false_statement) {
}

function WhileStatement (expression, statement) {
}

function EmptyExpressionStatement () {
}

function EndedExpressionStatement (expression) {
}

function WriteExpressionStatement (expression) {
}

function ReadExpressionStatement (identifier, declarator_specifier) {
}

function Expression (assignment_expression) {
}
Expression.prototype.appendChild = function (assignment_expression) {
};

function AssignmentExpression (unary_expression, assignment_operator, assignment_expression) {
}

function EqualityExpression (equality_expresion, equality_operator, relational_expression) {
}

function RelationalExpresssion (relational_expression, additive_expression) {
}

function AdditiveExpression (additive_expression, operator, multiplicative_expression) {
}

function MultiplicativeExpression (multiplicative_expression, operator, unary_expression) {
}

function MinusUnaryExpression (unary_expression) {
}

function PostfixExpression (primary_expression) {
}
PostfixExpression.prototype.addPostfix = function (expression) {
};

function IntLiteral (int_literal) {
}

function RealLiteral (real_literal) {
}

function Identifier (identifier) {
}
Identifier.prototype.addPostfix = function (expression) {
};

function PrimaryExpression (expression) {
}

function Declaration (declarator_specifier, init_declarator_list) {
}

function InitDeclaratorList (init_declarator) {
}
InitDeclaratorList.prototype.appendChild = function (init_declarator) {
};

function InitDeclarator (declarator, initalizer) {
}

}());
