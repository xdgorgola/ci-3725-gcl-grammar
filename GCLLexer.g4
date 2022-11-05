lexer grammar GCLLexer;

// Tokens
// Palabras claves
TkIf:          'if' ;
TkFi:          'fi' ;
TkDo:          'do' ;
TkOd:          'od' ;
TkTo:          'to' ;
TkIn:          'in' ;
TkInt:         'int';
TkBool:        'bool';
TkFor:         'for' ;
TkRof:         'rof' ;
TkArray:       'array';
TkSkip:        'skip' ;
TkPrint:       'print' ;
TkDeclare:     'declare' ;

// Separadores
TkComma:       ',' ;
TkOpenPar:     '(' ;
TkClosePar:    ')' ;
TkSemicolon:   ';' ;
TkOBlock:      '|[' ;
TkCBlock:      ']|' ;
TkSoForth:     '..' ;
TkAsig:        ':=' ;
TkArrow:       '-->' ;
TkGuard:       '[]' ;    

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
TkNum:  [1-9]+[0-9]* 
     |  '0';

// Strings
TkString:   '"' ('\\'[n"\\] | ~[\r\n\\"])*? '"' ;


// Variables
TkId:   ([a-zA-Z1-9] | '_')+([a-zA-Z0-9]|'_')* ;

// Ignorar comentarios
SLCMT: '//'.*?('\n'|'\r''\n'|EOF) -> skip ; // revisar
// Ignorar espacios en blanco
WS: [ \t\r\n]+ -> skip ;