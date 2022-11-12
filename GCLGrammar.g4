grammar GCLGrammar; 
import GCLLexer;

ident: TkId;

readA: TkId TkOBracket TkNum TkCBracket;

lit  : TkNum 
     | TkTrue 
     | TkFalse 
     | TkString
     | TkOBracket TkNum TkSoForth TkNum TkCBracket
     ;

neg  : TkMinus (ident | lit | readA);

mult : (ident | lit | readA) TkMult (ident | lit | readA);

add  : (ident | lit | readA) TkPlus (ident | lit | readA);

minus: (ident | lit | readA) TkMinus (ident | lit | readA);

great: (ident | lit | readA) TkGreater (ident | lit | readA);

less : (ident | lit | readA) TkLess (ident | lit | readA);

geq  : (ident | lit | readA) TkGeq (ident | lit | readA);

leq  : (ident | lit | readA) TkLeq (ident | lit | readA);

eq   : (ident | lit | readA) TkEqual (ident | lit | readA);

neq  : (ident | lit | readA) TkNEqual (ident | lit | readA);

and  : (ident | lit | readA) TkAnd (ident | lit | readA);

or   : (ident | lit | readA) TkOr (ident | lit | readA);

not  : TkNot (ident | lit | readA);

conc : (ident | lit | readA) TkConcat conc*
     | (ident | lit | readA) TkConcat (ident | lit | readA)
     ;

op   : neg
     | mult
     | add 
     | minus 
     | great
     | less
     | not
     | geq
     | leq
     | and
     | or
     | eq
     | neq
     | conc
     ;

asig : TkId TkAsig (lit | op);

print: TkPrint (op | lit | ident | readA);

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

block: TkOBlock 
       declaration*
       seq
       TkCBlock;