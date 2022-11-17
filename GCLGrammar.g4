grammar GCLGrammar; 
import GCLLexer;

writeABody: TkOpenPar exp TkTwoPoints (TkId | exp) TkClosePar;

// Valores
writeA    : TkId  writeABody
          | writeA writeABody
          ;

readA     : (writeA | TkId) TkOBracket (TkId | exp) TkCBracket;

boolLit   : TkTrue
          | TkFalse
          ;
    
// tknum y exp cuidado con estos literales
lit  : TkString
     | boolLit
     ;


numeric   : TkNum
          | TkMinus TkNum // pendiente con esto y los arreglos?
          ; 

//concateneable  : TkId // No seguro que puede concatenarse.
//               | exp
//               | lit
//               | readA
//               ;
//
//concatenation  : concateneable TkConcat concateneable
//               | concatenation TkConcat concateneable
//               ; 

exp       : TkOpenPar a=exp TkClosePar #enPar
          | op=TkMinus a=exp #enMinusNum
          | op=TkNot a=exp #elNot // pendiente con esto pq deberia permitir solo tktrue o tkfalse segun flavi pero yo no lo creo
          | <assoc=left> a=exp op=TkMult b=exp #enMult
          | <assoc=left> a=exp op=(TkPlus | TkMinus) b=exp #enPlusMinus
          | <assoc=left> a=exp op=(TkGeq | TkGreater | TkLeq | TkLess) b=exp #elnGeqGreat
          | <assoc=left> a=exp op=(TkEqual | TkNEqual) b=exp #elnEqNEq
          | <assoc=left> a=exp op=TkAnd b=exp #elAnd
          | <assoc=left> a=exp op=TkOr b=exp #elOr
          | a=TkId #enIDVal
          | a=TkNum #enLitVal
          | a=readA #enAVal
          | a=boolLit #expBoolVal
          ;

// Instrucciones

concateneable  : TkId // No seguro que puede concatenarse.
               | exp
               | lit
               | readA
               ;

concatenation  : concateneable TkConcat concateneable
               | concatenation TkConcat concateneable
               | TkOpenPar concatenation TkClosePar
               ; 

assigneable    : TkId 
               | exp 
               | lit 
               | writeA
               ;

asig : TkId TkAsig assigneable (TkComma assigneable)*;

printeable     : concatenation 
               | exp
               | lit 
               | TkId 
               | readA
               ;

print     : TkPrint printeable;


// Declaraciones
type : TkInt #tInt
     | TkBool #tBool
     | TkArray TkOBracket exp TkSoForth exp TkCBracket #tArray // Pendiente de si expNum o no, pero negativos tiene que ser
     ;

decl : TkId (TkComma TkId)* TkTwoPoints type ;

// Bloques

then : exp ;

ifBody  : then TkArrow (inst | seq) ;

guard: guard TkGuard ifBody
     | ifBody TkGuard ifBody
     | ifBody
     ;

ifOp  : TkIf guard TkFi;

in   : TkId TkIn (lit | TkId | readA | exp);

to   : TkTo (lit | TkId | readA | exp);

forOp  : TkFor in to TkArrow (inst | seq) TkRof;

doOp   : TkDo then TkArrow (inst | seq) TkOd;


// Secuencias
seqDecl   : decl TkSemicolon decl
          | seqDecl TkSemicolon decl 
          ;

inst : forOp
     | ifOp
     | doOp
     | asig
     | print
     | block
     | TkSkip
     ;

seq  : inst TkSemicolon inst
     | seq TkSemicolon inst
     ;

declarationBlock   : TkDeclare (decl | seqDecl);

block     : TkOBlock declarationBlock (inst | seq) TkCBlock
          | TkOBlock (inst | seq) TkCBlock
          ;