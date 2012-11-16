if (require) {
}
var syntax = {
  'terminal': [
    '+', '-', '*', '/', '<', '==', '<>', '[', ']', '=',// operator
    'if', 'else', 'while', 'read', 'write', 'int', 'real',// keyword
    '(', ')', ';', ',', '{', '}',// punctuation
    'IDENTIFIER', 'INT_LITERAL', 'REAL_LITERAL'// more complex one
  ],
  'unterminal': [
  ]
};

if (exports) {
  exports.syntax = syntax;
}
