grammar LabeledExpr;

/** La entrada del programa son varias sentencias */
prog:   stat+ ;

/** Sentencias */
stat:   expr NEWLINE                # printExpr
    |   ID '=' expr NEWLINE         # assign
    |   NEWLINE                     # blank
    ;

/** Expresiones */
expr:   expr op=('*'|'/') expr      # MulDiv
    |   expr op=('+'|'-') expr      # AddSub
    |   expr FACT                   # Factorial
    |   func '(' expr ')'           # Function
    |   INT                         # int
    |   ID                          # id
    |   '(' expr ')'                # parens
    ;


func:   SIN | COS | TAN | SQRT | LN | LOG ;

/** Tokens */
MUL :   '*' ;
DIV :   '/' ;
ADD :   '+' ;
SUB :   '-' ;
FACT :   '!' ;

SIN :   'sin' ;
COS :   'cos' ;
TAN :   'tan' ;
SQRT:   'sqrt' ;
LN  :   'ln' ;
LOG :   'log' ;

ID  :   [a-zA-Z]+ ;
INT :   [0-9]+ ;
NEWLINE:'\r'? '\n' ;
WS  :   [ \t]+ -> skip ;
