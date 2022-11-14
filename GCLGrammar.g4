grammar GCLGrammar; 
import GCLLexer;


readA: TkId TkOBracket TkNum TkCBracket;

lit  : TkNum 
     | TkTrue 
     | TkFalse 
     | TkString
     | TkOBracket TkNum TkSoForth TkNum TkCBracket
     ;

expNum    : TkMinus expNum
          | expNum op=TkMult expNum
          | expNum op=(TkPlus | TkMinus) expNum
          | (TkId | lit | readA)
          ;

expLogNum : expNum op=(TkLeq | TkLess) expNum
          | expNum op=(TkGeq | TkGreater) expNum
          | expNum op=(TkEqual | TkNEqual) expNum
          ;

expLog    : TkNot expLog
          | expLog op=TkAnd expLog
          | expLog op=TkOr expLog
          | expLog op=(TkEqual | TkNEqual) expLog
          | (TkTrue | TkFalse)
          | expLogNum
          ;
     
//neg  : TkMinus (TkId | lit | readA);
//
//mult : (TkId | lit | readA) TkMult (TkId | lit | readA);
//
//add  : (TkId | lit | readA) TkPlus (TkId | lit | readA);
//
//minus: (TkId | lit | readA) TkMinus (TkId | lit | readA);

//great: (TkId | lit | readA) TkGreater (TkId | lit | readA);
//
//less : (TkId | lit | readA) TkLess (TkId | lit | readA);
//
//geq  : (TkId | lit | readA) TkGeq (TkId | lit | readA);
//
//leq  : (TkId | lit | readA) TkLeq (TkId | lit | readA);
//
//eq   : (TkId | lit | readA) TkEqual (TkId | lit | readA);
//
//neq  : (TkId | lit | readA) TkNEqual (TkId | lit | readA);
//
//and  : (TkId | lit | readA) TkAnd (TkId | lit | readA);
//
//or   : (TkId | lit | readA) TkOr (TkId | lit | readA);
//
//not  : TkNot (TkId | lit | readA);

conc : (TkId | lit | readA) TkConcat ((TkId | lit | readA) | conc) ; // No seguro. Revisar flavi.

//op   : neg
//     | mult
//     | add 
//     | minus 
//     | great
//     | less
//     | not
//     | geq
//     | leq
//     | and
//     | or
//     | eq
//     | neq
//     | conc
//     ;

asig : TkId TkAsig (lit | conc);

print: TkPrint (conc | lit | TkId | readA);

type : TkInt
     | TkBool
     | TkArray TkOBracket TkNum TkSoForth TkNum TkCBracket
     ;

decl : TkId (TkComma TkId)* TkTwoPoints type;

seq  : decl (TkSemicolon decl)+ (TkSemicolon seq)*
     | asig (TkSemicolon seq)*
     | print (TkSemicolon seq)*
     ;

declaration   : TkDeclare (seq | decl);

block: TkOBlock declaration* seq TkCBlock; // (seq* | ins*)