grammar GCLGrammar; 
import GCLLexer;

writeABody: TkOpenPar exp TkTwoPoints (TkId | exp) TkClosePar; // pendiente con exp aca!

// Valores
writeA    : TkId  writeABody
          | writeA writeABody
          ;

readA     : (writeA | TkId) TkOBracket (TkId | exp) TkCBracket; // pendiente exp aca!

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
concateneable  : TkId
               | TkString
               | exp
               ;

concatenation  : concateneable TkConcat concateneable
               | concatenation TkConcat concateneable
               | TkOpenPar concatenation TkClosePar
               ; 

assigneable    : TkId 
               | TkString
               | exp 
               | writeA
               ;

asig : TkId TkAsig assigneable (TkComma assigneable)*;

printeable     : concatenation 
               | exp
               ;

print     : TkPrint printeable;


// Declaraciones
type : TkInt #tInt
     | TkBool #tBool
     | TkArray TkOBracket numericLit TkSoForth numericLit TkCBracket #tArray
     ;

decl : TkId decl TkTwoPoints type 
     | TkComma TkId decl
     | TkComma TkId
     ;

// Bloques

then : exp ;

ifBody  : then TkArrow (inst | seq) ;

guard: guard TkGuard ifBody
     | ifBody TkGuard ifBody
     | ifBody
     ;

ifOp  : TkIf guard TkFi;

in   : TkId TkIn exp;

to   : TkTo exp;

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