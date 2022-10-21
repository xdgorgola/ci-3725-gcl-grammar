lexer grammar GCL;

// Tokens
// Palabras claves
TkIf:       'if' ;
TkFi:       'fi' ;
TkDo:       'do' ;
TkOd:       'od' ;
TkIn:       'in' ;
TkFor:      'for' ;
TkRof:      'rof' ;
TkSkip:     'skip' ;
TkPrint:    'print' ;
TkDeclare:  'declare' ;

// Literales
// CTTES Booleanas
TkTrue:     'true' ;
TkFalse:    'false' ;

// Enteros
TkNum:  [1-9]+[0-9]* ;

// Strings
TkString: '"'.*?'"' ;

// Variables
TkId:   '_'+([a-zA-Z0-9])+([a-zA-Z0-9]|'_')*
    |   ([a-zA-Z])+([a-zA-Z0-9]|'_')* ;


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
TkPlus:     '+' ;
TkMinus:    '-' ;
TkMult:     '*' ;
TkNot:      '!' ;
TkLess:     '<' ;
TkGreater:  '>' ;
TkLeq:      '<=' ;
TkGeq:      '>=' ;
TkEqual:    '==' ;
TkOr:       '\\/' ;
TkAnd:      '/\\)' ;

// Ignorar comentarios
SLCMT: '//'.*?('\n'|'\r''\n'|EOF) -> skip ; // revisar
// Ignorar espacios en blanco
WS: [ \t\r\n]+ -> skip ;