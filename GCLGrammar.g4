grammar GCLGrammar; 
import GCLLexer;


readA: TkId TkOBracket TkNum TkCBracket;

boolLit   : TkTrue
          | TkFalse
          ;

          
lit  : TkNum 
     | TkString
     | TkOBracket TkNum TkSoForth TkNum TkCBracket
     ;

expNum    : TkMinus expNum
          | expNum op=TkMult expNum
          | expNum op=(TkPlus | TkMinus) expNum
          | TkOpenPar expNum TkClosePar
          | (TkId | lit | readA)
          ;

expLogNum : expLogNum op=(TkLeq | TkLess) expLogNum
          | expLogNum op=(TkGeq | TkGreater) expLogNum
          | expLogNum op=(TkEqual | TkNEqual) expLogNum
          | TkOpenPar expLogNum TkClosePar
          | expNum
          ;

expLog    : TkNot expLog
          | expLog op=TkAnd expLog
          | expLog op=TkOr expLog
          | expLog op=(TkEqual | TkNEqual) expLog
          | TkOpenPar expLog TkOpenPar
          | (expLogNum | boolLit)
          ;

conc : (TkId | lit | readA) TkConcat ((TkId | lit | readA) | conc) ; // No seguro. Revisar flavi.

asig : TkId TkAsig (expNum | conc);

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

block: TkOBlock declaration* seq* TkCBlock; // pendiente single expresion