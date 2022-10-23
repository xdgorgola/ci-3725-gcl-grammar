lexer grammar GCL;

// Tokens
// Palabras claves
TkIf:       'if' ;
TkFi:       'fi' ;
TkDo:       'do' ;
TkOd:       'od' ;
TkIn:       'in' ;
TkInt:      'int';
TkFor:      'for' ;
TkRof:      'rof' ;
TkArray:    'array';
TkSkip:     'skip' ;
TkPrint:    'print' ;
TkDeclare:  'declare' ;

// Separadores
TkComma:        ',' ;
TkOpenPar:      '(' ;
TKClosePar:     ')' ;
TkSemicolon:    ';' ;
TkOBlock:       '|[' ;
TkCBlock:       ']|' ;
TkSoForth:      '..' ;
TkAsig:         ':=' ;
TkArrow:        '-->' ;

// Operadores
TkConcat: '.';
TkOBracket: '[';
TkCBracket: ']';
TkPlus:     '+' ;
TkMinus:    '-' ;
TkMult:     '*' ;
TkNot:      '!' ;
TkTwoPoints: ':';
TkLess:     '<' ;
TkGreater:  '>' ;
TkNEqual:   '!=';
TkLeq:      '<=' ;
TkGeq:      '>=' ;
TkEqual:    '==' ;
TkOr:       '\\/' ;
TkAnd:      '/\\' ;

// Literales
// CTTES Booleanas
TkTrue:     'true' ;
TkFalse:    'false' ;

// Enteros
TkNum:  '-'*[1-9]+[0-9]* 
     |  '-'*'0';

// Strings
TkString: '"'.*?'"' ;

// Variables
TkId:   '_'+([a-zA-Z0-9])+([a-zA-Z0-9]|'_')*
    |   ([a-zA-Z])+([a-zA-Z0-9]|'_')* ;

// Ignorar comentarios
SLCMT: '//'.*?('\n'|'\r''\n'|EOF) -> skip ; // revisar
// Ignorar espacios en blanco
WS: [ \t\r\n]+ -> skip ;