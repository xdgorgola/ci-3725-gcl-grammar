grammar GCLGrammar; 
import GCLLexer;

// Valores
writeA    : TkId  TkOpenPar expNum TkTwoPoints (TkId | lit) TkClosePar
          | writeA TkOpenPar expNum TkTwoPoints (TkId | lit) TkClosePar
          ;

readA     : (writeA | TkId) TkOBracket (TkNum | TkId) TkCBracket;

boolLit   : TkTrue
          | TkFalse
          ;
    
lit  : TkNum 
     | TkString
     | TkTrue
     | TkFalse
     ;


// Expresiones
expNum    : op=TkMinus a=expNum #enMinusNum
          | a=expNum op=TkMult b=expNum #enMult
          | a=expNum op=(TkPlus | TkMinus) b=expNum #enPlusMinus
          | TkOpenPar a=expNum TkClosePar #enPar
          | a=TkId #enIDVal
          | a=TkNum #enLitVal
          | a=readA #enAVal
          ;

expLogNum : a=expLogNum op=(TkLeq | TkLess) b=expLogNum #elnLeqLess
          | a=expLogNum op=(TkGeq | TkGreater) b=expLogNum #elnGeqGreat
          | a=expLogNum op=(TkEqual | TkNEqual) b=expLogNum #elnEqNEq
          | TkOpenPar a=expLogNum TkClosePar #elnPar
          | a=expNum #elnVal
          ;

expLog    : TkNot a=expLog #elNot
          | a=expLog op=TkAnd b=expLog #elAnd
          | a=expLog op=TkOr b=expLog #elOr
          | a=expLog op=(TkEqual | TkNEqual) b=expLog #elEqNEq
          | TkOpenPar b=expLog TkOpenPar #elPar
          | (expLogNum | boolLit) #elVal
          ;


// Instrucciones
conc : (TkId | lit | readA) TkConcat (TkId | lit | readA)
     | conc TkConcat (TkId | lit | readA)
     ; // No seguro.

asig : TkId TkAsig (TkId | lit | expNum | expLog | expLogNum | conc | writeA) (TkComma (TkId | lit | expNum | expLog | expLogNum | conc | writeA))*;

print: TkPrint (conc | lit | TkId | readA);


// Declaraciones
type : TkInt #tInt
     | TkBool #tBool
     | TkArray TkOBracket expNum TkSoForth expNum TkCBracket #tArray // Pendiente de si expNum o no, pero negativos tiene que ser
     ;

decl : TkId (TkComma TkId)* TkTwoPoints type ;

// Bloques

then : expLog 
     | expLogNum
     ;

ifBody  : then TkArrow (inst | seq) ;

guard: guard TkGuard ifBody
     | ifBody TkGuard ifBody
     | ifBody
     ;

ifOp  : TkIf guard TkFi;

in   : TkId TkIn (lit | TkId | readA | expNum);

to   : TkTo (lit | TkId | readA | expNum);

forOp  : TkFor in to TkArrow (inst | seq) TkRof;

doOp   : TkDo then TkArrow (inst | seq) TkOd;


// Secuencias
seqDecl   : decl TkSemicolon decl
          | seqDecl TkSemicolon decl 
          ;

//seq  : decl (TkSemicolon seq)
//     | inst (TkSemicolon seq)+ #instSeq
//     | inst #seqFinal
//     ;

inst : forOp
     | ifOp
     | doOp
     | asig
     | print
     | block
     | TkSkip
     ;

//(TkId | lit | readA) TkConcat (TkId | lit | readA)
//     | conc TkConcat (TkId | lit | readA)

seq  : inst TkSemicolon inst
     | seq TkSemicolon inst
     ;

declarationBlock   : TkDeclare (decl | seqDecl);

block     : TkOBlock declarationBlock (inst | seq) TkCBlock
          | TkOBlock (inst | seq) TkCBlock
          ;