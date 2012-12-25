DIGIT                     \d+
INT                       {DIGIT}+ 
REAL                      {INT}\.{INT}('e'[-+]?{INT})?
LETTER                    [a-zA-Z]
NUMBER                    [0-9]
IDENTIFIER                {LETTER}({LETTER}|{NUMBER}|'_')*

%x comment

%%

"//".*                  /* ignore line comment */
"/*"                    this.begin(comment);
<comment>[^*\n]*        /* eat anything that's not a '*' */
<comment>"*"+[^*/\n]*   /* eat up '*'s not followed by '/'s */
<comment>\n             this.yylineno++;
<comment>"*"+"/"        this.begin(INITIAL);
\s+                     /* ignore white space */
"if"                    return 'if';
"else"                  return 'else';
"while"                 return 'while';
"read"                  return 'read';
"write"                 return 'write';
"int"                   return 'int';
"real"                  return 'real';
{INT}                   return 'INT_LITERAL';
{REAL}                  return 'REAL_LITERAL';
{IDENTIFIER}            return 'IDENTIFIER';
"+"                     return '+';
"-"                     return '-';
"*"                     return '*';
"/"                     return '/';
"<"                     return '<';
"=="                    return '==';
"<>"                    return '<>';
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
