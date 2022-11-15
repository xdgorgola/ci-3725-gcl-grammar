grammar GCLGrammar; 
import GCLLexer;

// Valores
readA: TkId TkOBracket (TkNum | TkId) TkCBracket;

boolLit   : TkTrue
          | TkFalse
          ;
    
lit  : TkNum 
     | TkString
     | TkOBracket TkNum TkSoForth TkNum TkCBracket
     ;


// Expresiones
expNum    : op=TkMinus expNum #enMinusNum
          | expNum op=TkMult expNum #enMult
          | expNum op=(TkPlus | TkMinus) expNum #enPlusMinus
          | TkOpenPar expNum TkClosePar #enPar
          | (TkId | lit | readA) #enVal
          ;

expLogNum : expLogNum op=(TkLeq | TkLess) expLogNum #elnLeqLess
          | expLogNum op=(TkGeq | TkGreater) expLogNum #elnGeqGreat
          | expLogNum op=(TkEqual | TkNEqual) expLogNum #elnEqNEq
          | TkOpenPar expLogNum TkClosePar #elnPar
          | expNum #elnVal
          ;

expLog    : TkNot expLog #elNot
          | expLog op=TkAnd expLog #elAnd
          | expLog op=TkOr expLog #elOr
          | expLog op=(TkEqual | TkNEqual) expLog #elEqNEq
          | TkOpenPar expLog TkOpenPar #elPar
          | (expLogNum | boolLit) #elVal
          ;


// Instrucciones
conc : (TkId | lit | readA) TkConcat ((TkId | lit | readA) | conc) ; // No seguro. Revisar flavi.

asig : TkId TkAsig (expNum | conc);

print: TkPrint (conc | lit | TkId | readA);


// Declaraciones
type : TkInt #tInt
     | TkBool #tBool
     | TkArray TkOBracket expNum TkSoForth expNum TkCBracket #tArray // Pendiente de si expNum o no, pero negativos tiene que ser
     ;

decl : TkId decl TkTwoPoints type #iniDeclA
     | TkId TkTwoPoints type #iniDeclB
     | TkComma TkId decl #nextDecl
     | TkComma TkId #finalDecl
     ;


// Bloques

then : expLog 
     | expLogNum
     ;

ifb  : then TkArrow block* seq*;

guard: guard TkGuard ifb
     | ifb TkGuard ifb
     | ifb
     ;

ifOp  : TkIf guard TkFi;

in   : TkId TkIn (lit | TkId | readA | expNum);

to   : TkTo (lit | TkId | readA | expNum);

forOp  : TkFor in to TkArrow block* seq* TkRof;

doOp   : TkDo then TkArrow block* seq* TkOd;


// Secuencias
seqDecl   : TkSemicolon decl seqDecl 
          | TkSemicolon decl
          ;

seq  : decl seqDecl
     | forOp (TkSemicolon seq)*
     | ifOp (TkSemicolon seq)*
     | doOp (TkSemicolon seq)*
     | asig (TkSemicolon seq)*
     | print (TkSemicolon seq)*
     | TkSkip (TkSemicolon seq)*
     ;

declarationBlock   : TkDeclare (seq | decl);

block     : TkOBlock declarationBlock* seq* TkCBlock

          ;