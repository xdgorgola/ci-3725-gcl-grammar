grammar GCLGrammar; 
import GCLLexer;

@parser::header {
package com.parsing;
import java.util.ArrayDeque;
import com.parsing.utils.SymbolsTable;
}

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
               | TkNum
               ; 

exp  returns [String expType]
          : TkOpenPar a=exp TkClosePar { $expType = $a.expType; } #parExp
          | op=TkMinus a=exp { $expType = "int"; } #unMinExp
          | <assoc=left> a=exp op=TkMult b=exp { $expType = "int"; } #multExp
          | <assoc=left> a=exp op=(TkPlus | TkMinus) b=exp { $expType = "int"; } #minPlusExp
          | <assoc=left> a=exp op=(TkGeq | TkGreater | TkLeq | TkLess) b=exp { $expType = "bool"; } #ordExp
          | <assoc=left> a=exp op=(TkEqual | TkNEqual) b=exp { $expType = "bool"; } #eqExp
          | op=TkNot a=exp { $expType = "bool"; } #notExp
          | <assoc=left> a=exp op=TkAnd b=exp { $expType = "bool"; } #andExp
          | <assoc=left> a=exp op=TkOr b=exp { $expType = "bool"; } #orExp
          | TkId { $expType = null; } #idExp // Se cacha en runtime
          | a=TkNum { $expType = "int"; } #numExp
          | a=readA { $expType = "int"; } #readAExp
          | a=(TkTrue | TkFalse) { $expType = "bool"; } #boolExp
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
type : TkInt #tInt
     | TkBool #tBool
     | TkArray TkOBracket numericLit TkSoForth numericLit TkCBracket #tArray
     ;


ldec 
locals [
     String gclType = null
]
     : TkId TkComma ldec
     | TkId
     ;

decl : ldec TkTwoPoints type ;


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

block     
locals [
     SymbolsTable symbols
]
@init {
     $symbols = new SymbolsTable();
}
          : TkOBlock declarationBlock (inst | seq) TkCBlock
          | TkOBlock (inst | seq) TkCBlock
          ;