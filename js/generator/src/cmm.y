%left '='
%left '==' '<>' '<'
%left '+' '-'
%left '*' '/'

%start prog

%{
// symbol and constant table
var symbols = {};
var util = require('util');

function addSymbol (address) {
  if (symbols[address]) return symbols[address];
  return symbols[address] = {type: '', value: null};
}

function getSymbol (address) {
  return symbols[address];
}

function setValue (address, value) {
  var matches = address.match(/\[(\d+)\]/g);
  if (matches) {
    address = address.slice(0, address.indexOf('['));
    var symbol = getSymbol(address);
    var v = symbol.value ? symbol.value : [];
    for (var i=1; i<matches.length; i++) {
      v = v[matches[i]] = v[matches[i]] ? v[matches[i]] : [];
    }
    v[i-1] = value;
  } else {
    getSymbol(address).value = value;
  }
  return value;
}

function getValue (address) {
  var matches = address.match(/\[(\d+)\]/g);
  var value;
  if (matches) {
    // get array's value
    address = address.slice(0, address.indexOf('['));
    value = getSymbol(address).value;
    for (var i=1; i<matches.length; i++) {
      value = value[matches[i]];
    }
  } else {
    value = getSymbol(address).value;
  }
  return value;
}

%}

%%

prog
  : statement_list EOF
    {console.log(symbols);}
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
  : selection_statement_head statement
      {yy.continueExecution=true}
  | selection_statement_head statement selection_statement_else statement
      {yy.continueExecution=true}
  ;
selection_statement_head
  : 'if' '(' expression ')'
     {yy.continueExecution=!!getValue($3);}
  ;
selection_statement_else
  : 'else'
      {yy.continueExecution=!yy.continueExecution;}
  ;
iteration_statement
  : 'while' '(' expression ')' statement
  ;
expression
  : assignment_expression
      {$$=$1;}
  | expression ',' assignment_expression
      {$$=[$1, $2, $3].join(''); setValue($$, getValue($3));}
  ;
assignment_expression
  : equality_expression
      {$$=$1;}
  | unary_expression '=' assignment_expression
      {$$=[$1, $2, $3].join(''); setValue($1, addSymbol($$).value=getValue($3));}
  | unary_expression '+=' assignment_expression
      {
        $$=[$1, $2, $3].join('');
        var value = getValue($1) + getValue($3);
        setValue($1, value);
        addSymbol($$).value = value;
      }
  | unary_expression '-=' assignment_expression
      {
        $$=[$1, $2, $3].join('');
        var value = getValue($1) - getValue($3);
        setValue($1, value);
        addSymbol($$).value = value;
      }
  | unary_expression '*=' assignment_expression
      {
        $$=[$1, $2, $3].join('');
        var value = getValue($1) * getValue($3);
        setValue($1, value);
        addSymbol($$).value = value;
      }
  | unary_expression '/=' assignment_expression
      {
        $$=[$1, $2, $3].join('');
        var value = getValue($1) / getValue($3);
        setValue($1, value);
        addSymbol($$).value = value;
      }
  ;
equality_expression
  : relational_expression
      {$$=$1;}
  | equality_expression '==' relational_expression
      {$$=[$1, $2, $3].join(''); addSymbol($$).value=getValue($1)===getValue($3);}
  | equality_expression '<>' relational_expression
      {$$=[$1, $2, $3].join(''); addSymbol($$).value=getValue($1)!==getValue($3);}
  ;
relational_expression
  : additive_expression
      {$$=$1;}
  | relational_expression '<' additive_expression
      {$$=[$1, $2, $3].join(''); addSymbol($$).value=getValue($1)<getValue($3);}
  ;
additive_expression
  : multiplicative_expression
      {$$=$1;}
  | additive_expression '+' multiplicative_expression
      {$$=[$1, $2, $3].join(''); addSymbol($$).value=getValue($1)+getValue($3);}
  | additive_expression '-' multiplicative_expression
      {$$=[$1, $2, $3].join(''); addSymbol($$).value=getValue($1)-getValue($3);}
  ;
multiplicative_expression
  : unary_expression
      {$$=$1;}
  | multiplicative_expression '*' unary_expression
      {$$=[$1, $2, $3].join(''); addSymbol($$).value=getValue($1)*getValue($3);}
  | multiplicative_expression '/' unary_expression
      {$$=[$1, $2, $3].join(''); addSymbol($$).value=getValue($1)/getValue($3);}
  ;
unary_expression
  : postfix_expression
      {$$=$1;}
  | '+' unary_expression
      {$$=[$1, $2].join(''); addSymbol($$).value=getValue($1);}
  | '-' unary_expression
      {$$=[$1, $2].join(''); addSymbol($$).value=-getValue($1);}
  ;
postfix_expression
  : primary_expression
      {$$=$1;}
  | postfix_expression '[' expression ']'
      {$$=[$1, $2, getValue($3), $4].join(''); addSymbol($$);}
  ;
primary_expression
  : INT_LITERAL
      {$$=$1; addSymbol($$).type='int'; setValue($$, parseInt($1));}
  | REAL_LITERAL
      {$$=$1; addSymbol($$).type='real'; setValue($$, parseFloat($1));}
  | IDENTIFIER
      {$$=$1; addSymbol($$);}
  | '(' expression ')'
      {$$=[$1, $2, $3].join(''); addSymbol($$); setValue($$, getValue($2));}
  ;
declaration
  : declarator_specifiers init_declarator_list ';'
      {
        for (var i=0; i<$2.length; i++) {
          getSymbol($2[i]).type = $1 + getSymbol($2[i]).type;
        }
      }
  ;
declarator_specifiers
  : 'int' {$$ = $1;}
  | 'real' {$$ = $1;}
  ;
init_declarator_list
  : init_declarator
      {$$ = [$1]}
  | init_declarator_list ',' init_declarator
      {$1.push($3); $$=$1;}
  ;
init_declarator
  : declarator {$$=$1;}
  | declarator '=' initializer
      {$$=$1; setValue($1, getValue($3));}
  ;
declarator
  : IDENTIFIER
      {$$=$1; addSymbol($$);}
  | declarator '[' constant_expression ']'
      {$$=$1; getSymbol($$).type += '['+$3+']';}
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
