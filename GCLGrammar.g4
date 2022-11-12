grammar GCLGrammar; 
import GCLLexer;

block: TkOBlock 
       declaration*
       seq
       TkCBlock;

declaration   : TkDeclare (seq | decl);

seq  : decl (TkSemicolon decl)+ (TkSemicolon seq)*
     | asig (TkSemicolon seq)*
     | print (TkSemicolon seq)*
     ;

decl : TkId (TkComma TkId)* TkTwoPoints type;

type : TkInt
     | TkBool
     | TkArray TkOBracket TkNum TkSoForth TkNum TkCBracket
     ;

asig : TkId TkAsig (lit | op);

print: TkPrint (op | lit | ident | readA);

op   : sum 
     | sus 
     | mult 
     | neg
     | mayor
     | menor
     | mayorig
     | menorig
     | y
     | o
     | no
     | desig
     | conc
     ;

sum  : (ident | lit) TkPlus (ident | lit);

sus  : (ident | lit) TkMinus (ident | lit);

mult : (ident | lit) TkMult (ident | lit);

neg  : TkMinus (ident | lit);

mayor: (ident | lit) TkGreater (ident | lit);

menor: (ident | lit) TkLess (ident | lit);

mayorig: (ident | lit) TkGeq (ident | lit);

menorig: (ident | lit) TkLeq (ident | lit);

desig: (ident | lit) TkNEqual (ident | lit);

y    : (ident | lit) TkAnd (ident | lit);

o    : (ident | lit) TkOr (ident | lit);

no   : TkNot (ident | lit);

conc : (lit | ident) TkConcat conc*
     | (lit | ident) TkConcat (lit | ident)
     ;

ident: TkId;

readA: TkId TkOBracket TkNum TkCBracket;

lit  : TkNum 
     | TkTrue 
     | TkFalse 
     | TkString
     | TkOBracket TkNum TkSoForth TkNum TkCBracket
     ;