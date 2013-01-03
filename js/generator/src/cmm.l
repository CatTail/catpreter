DIGIT                     \d+
INT                       {DIGIT}+ 
REAL                      {INT}\.{INT}('e'[-+]?{INT})?
LETTER                    [a-zA-Z]
NUMBER                    [0-9]
IDENTIFIER                {LETTER}({LETTER}|{NUMBER}|'_')*

%s comment

%%

"//".*                  /* ignore line comment */
"/*"                  {this.begin('comment');}
<comment>"*/"         {this.popState();}
<comment>.            {/* skip comment content*/}
\s+                     /* ignore white space */
"if"                    return 'if';
"else"                  return 'else';
"while"                 return 'while';
"read"                  return 'read';
"write"                 return 'write';
"int"                   return 'int';
"real"                  return 'real';
{REAL}                  return 'REAL_LITERAL';
{INT}                   return 'INT_LITERAL';
{IDENTIFIER}            return 'IDENTIFIER';
"+="                    return '+=';
"-="                    return '-=';
"*="                    return '*=';
"/="                    return '/=';
"=="                    return '==';
"<>"                    return '<>';
"+"                     return '+';
"-"                     return '-';
"*"                     return '*';
"/"                     return '/';
"<"                     return '<';
"["                     return '[';
"]"                     return ']';
"="                     return '=';
"("                     return '(';
")"                     return ')';
";"                     return ';';
"{"                     return '{';
"}"                     return '}';
","                     return ',';
.                       /* ignore */
<<EOF>>                 return 'EOF'

%%
