%start expressions

%% /* language grammar */

expressions
  : e EOF
      {return $1;}
  ;

e
  : e '+' e
      {$$ = $1 + $3;}
  | e '-' e
      {$$ = $1 - $3;}
  | e '*' e
      {$$ = $1 * $3;}
  | e '/' e
      {$$ = $1 / $3;}
  | e '^' e
      {$$ = Math.pow($1, $3);}
  | '-' e %prec UMINUS
      {$$ = -$2;}
  | '(' e ')'
      {$$ = $2;}
  | NUMBER
      {$$ = Number(yytext);}
  | PI
      {$$ = Math.PI;}
  ;

