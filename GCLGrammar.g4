grammar GCLGrammar; 
import GCLLexer;

// Array related
writeABody : TkOpenPar exp TkTwoPoints exp TkClosePar; // pendiente con exp aca!

writeA    : TkId  writeABody
          | writeA writeABody
          ;

readA     : writeA  TkOBracket exp TkCBracket
          | TkId TkOBracket exp TkCBracket
          ;


// Expresiones
numericLit     : TkMinus numericLit
               | TkNum // pendiente con esto y los arreglos?
               ; 

exp       : TkOpenPar a=exp TkClosePar #parExp
          | op=TkMinus a=exp #unMinExp
          | op=TkNot a=exp #notExp // pendiente con esto pq deberia permitir solo tktrue o tkfalse segun flavi pero yo no lo creo
          | <assoc=left> a=exp op=TkMult b=exp #multExp
          | <assoc=left> a=exp op=(TkPlus | TkMinus) b=exp #minPlusExp
          | <assoc=left> a=exp op=(TkGeq | TkGreater | TkLeq | TkLess) b=exp #ordExp
          | <assoc=left> a=exp op=(TkEqual | TkNEqual) b=exp #eqExp
          | <assoc=left> a=exp op=TkAnd b=exp #andExp
          | <assoc=left> a=exp op=TkOr b=exp #orExp
          | a=TkId #idExp
          | a=TkNum #numExp
          | a=readA #readAExp
          | a=(TkTrue | TkFalse) #boolExp
          ;


// Instrucciones
concatenable   : TkString
               | exp
               ;

concatenation  : concatenable TkConcat concatenable
               | concatenation TkConcat concatenable
               | TkOpenPar concatenation TkClosePar
               ; 

asignable      : exp 
               | writeA
               ;

arrayInit      : arrayInit TkComma asignable
               | asignable TkComma asignable
               ;

asignation     : TkId TkAsig asignable 
               | TkId TkAsig arrayInit
               ;

printeable     : TkString
               | concatenation 
               | exp
               ;

print     : TkPrint printeable;


// Declaraciones
type : TkInt #tInt
     | TkBool #tBool
     | TkArray TkOBracket numericLit TkSoForth numericLit TkCBracket #tArray
     ;

decl : TkId decl TkTwoPoints type 
     | TkId TkTwoPoints type
     | TkComma TkId decl
     | TkComma TkId
     ;

// Bloques

then : exp TkArrow (inst | seq);

in   : TkId TkIn to;

to   : exp TkTo exp;

forOp     : TkFor in TkArrow (inst | seq) TkRof;  

guard     : then TkGuard then
          | guard TkGuard then
          ;

ifOp : TkIf guard TkFi
     | TkIf then TkFi
     ;

doOp : TkDo guard TkOd
     | TkDo then TkOd
     ;

// Secuencias
seqDecl   : decl TkSemicolon decl
          | seqDecl TkSemicolon decl 
          ;

inst : forOp
     | ifOp
     | doOp
     | asignation
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