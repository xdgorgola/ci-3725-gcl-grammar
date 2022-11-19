import com.parsing.GCLGrammarParser;

import org.antlr.v4.runtime.ParserRuleContext;
import org.antlr.v4.runtime.tree.TerminalNode;

public class ASTPrinter extends com.parsing.GCLGrammarBaseVisitor<Void> {

    private int _currRealDepth = 0;

    private StringBuilder generatePrefix(int len) {
        StringBuilder builder = new StringBuilder(Integer.toString(len));
        for (int i = 0; i < len; builder.append('-'), ++i)
            ;
        return builder;
    }
    
    private Void addPrintVisitLeave(String txt, ParserRuleContext ctx)
    {
        StringBuilder pref = generatePrefix(_currRealDepth++).append(txt);
        System.out.println(pref.toString());

        visitChildren(ctx);
        _currRealDepth--;
        return null;
    }
    

    @Override
    public Void visitBlock(GCLGrammarParser.BlockContext ctx) {
        return addPrintVisitLeave("Block", ctx);
    }

    @Override
    public Void visitDeclarationBlock(GCLGrammarParser.DeclarationBlockContext ctx) {
        return addPrintVisitLeave("Declare", ctx);
    }

    @Override
    public Void visitSeqDecl(GCLGrammarParser.SeqDeclContext ctx)
    {
        return addPrintVisitLeave("Sequencing", ctx);
    }

    @Override
    public Void visitDecl(GCLGrammarParser.DeclContext ctx)
    {
        StringBuilder pref = generatePrefix(_currRealDepth++);
        if (ctx.type() != null)
        {
            pref = pref.append(ctx.getText());
            System.out.println(pref);
        }

        visitChildren(ctx);
        
        _currRealDepth--;
        return null;
    }

    @Override
    public Void visitNumericLit(GCLGrammarParser.NumericLitContext ctx)
    {
        StringBuilder pref = generatePrefix(_currRealDepth++);
        if (ctx.TkMinus() != null)
        {
            pref.append("Minus");
            System.out.println(pref);
            visitChildren(ctx);

            _currRealDepth--;
            return null;
        }

        pref.append("Literal: " + ctx.getText()); // esto no deberia ser para el caso este de arrays sin negativos! :(
        System.out.println(pref);

        _currRealDepth--;
        return null;
    }

    @Override
    public Void visitSeq(GCLGrammarParser.SeqContext ctx)
    {
        return addPrintVisitLeave("Sequencing", ctx);
    }

    @Override
    public Void visitUnMinExp(GCLGrammarParser.UnMinExpContext ctx)
    {
        return addPrintVisitLeave("Minus", ctx);
    }

    @Override
    public Void visitNotExp(GCLGrammarParser.NotExpContext ctx)
    {
        return addPrintVisitLeave("Not", ctx);
    }

    @Override
    public Void visitMinPlusExp(GCLGrammarParser.MinPlusExpContext ctx)
    {
        StringBuilder pref = generatePrefix(_currRealDepth++);
        switch (ctx.op.getType()) {
            case GCLGrammarParser.TkPlus:
                pref.append("Plus");
                break;
            case GCLGrammarParser.TkMinus:
                pref.append("Minus");
                break;
        }

        System.out.println(pref.toString());
        visitChildren(ctx);
        _currRealDepth--;
        return null;
    }

    @Override
    public Void visitMultExp(GCLGrammarParser.MultExpContext ctx)
    {
        return addPrintVisitLeave("Mult", ctx);
    }

    @Override
    public Void visitOrdExp(GCLGrammarParser.OrdExpContext ctx)
    {
        StringBuilder pref = generatePrefix(_currRealDepth++);
        switch (ctx.op.getType()) {
            case GCLGrammarParser.TkLeq:
                pref.append("Leq");
                break;
            case GCLGrammarParser.TkLess:
                pref.append("Less");
                break;
            case GCLGrammarParser.TkGeq:
                pref.append("Geq");
                break;
            case GCLGrammarParser.TkGreater:
                pref.append("Greater");
                break;
        }

        System.out.println(pref.toString());
        visitChildren(ctx);
        _currRealDepth--;
        return null;
    }

    @Override
    public Void visitEqExp(GCLGrammarParser.EqExpContext ctx)
    {
        StringBuilder pref = generatePrefix(_currRealDepth++);
        switch (ctx.op.getType()) {
            case GCLGrammarParser.TkEqual:
                pref.append("Equal");
                break;
            case GCLGrammarParser.TkNEqual:
                pref.append("NEqual");
                break;
        }

        System.out.println(pref.toString());
        visitChildren(ctx);
        _currRealDepth--;
        return null;
    }

    @Override
    public Void visitAndExp(GCLGrammarParser.AndExpContext ctx)
    {
        return addPrintVisitLeave("And", ctx);
    }

    @Override
    public Void visitOrExp(GCLGrammarParser.OrExpContext ctx)
    {
        return addPrintVisitLeave("Or", ctx);
    }

    @Override
    public Void visitParExp(GCLGrammarParser.ParExpContext ctx)
    {
        visitChildren(ctx); // Ignoramos los tokens parentesis
        return null;
    }

    @Override
    public Void visitIdExp(GCLGrammarParser.IdExpContext ctx)
    {
        StringBuilder pref = generatePrefix(_currRealDepth++).append("Ident: ");
        pref.append(ctx.getText());
    
        System.out.println(pref.toString()); // Hay que examinar el valor primero en realidad. solo de prueba
        _currRealDepth--;
        return null;
    }

    @Override
    public Void visitNumExp(GCLGrammarParser.NumExpContext ctx)
    {
        StringBuilder pref = generatePrefix(_currRealDepth++).append("Literal: ");
        pref.append(ctx.getText());
    
        System.out.println(pref.toString());
        _currRealDepth--;
        return null;
    }

    @Override
    public Void visitBoolExp(GCLGrammarParser.BoolExpContext ctx)
    {
        StringBuilder pref = generatePrefix(_currRealDepth++).append("Literal: ");
        pref.append(ctx.getText());
    
        System.out.println(pref.toString());
        _currRealDepth--;
        return null;
    }

    @Override
    public Void visitReadAExp(GCLGrammarParser.ReadAExpContext ctx)
    {
        visitChildren(ctx);
        return null;
    }

    @Override
    public Void visitAsignable(GCLGrammarParser.AsignableContext ctx)
    {
        visitChildren(ctx);
        return null;
    }

    @Override
    public Void visitArrayInit(GCLGrammarParser.ArrayInitContext ctx)
    {
        return addPrintVisitLeave("Comma", ctx);
    }

    @Override
    public Void visitAsignation(GCLGrammarParser.AsignationContext ctx)
    {
        StringBuilder pref = generatePrefix(_currRealDepth++).append("Asig");
        System.out.println(pref.toString());

        TerminalNode id = ctx.TkId();
        pref = generatePrefix(_currRealDepth).append("Ident: ").append(id.getText());
        System.out.println(pref);

        visitChildren(ctx);

        _currRealDepth--;
        return null;
    }

    @Override
    public Void visitReadA(GCLGrammarParser.ReadAContext ctx)
    {
        StringBuilder pref = generatePrefix(_currRealDepth++).append("ReadArray");
        System.out.println(pref.toString());

        if (ctx.TkId() != null)
        {
            pref = generatePrefix(_currRealDepth++).append("Ident: " + ctx.TkId().toString());
            System.out.println(pref.toString());
            _currRealDepth--;
        }

        visitChildren(ctx);
        _currRealDepth--;
        return null;
    }

    @Override
    public Void visitWriteA(GCLGrammarParser.WriteAContext ctx)
    {
        StringBuilder pref = generatePrefix(_currRealDepth++).append("WriteArray: ");
        System.out.println(pref.toString());
        if (ctx.TkId() != null)
        {
            pref = generatePrefix(_currRealDepth++).append("Ident: " + ctx.TkId().toString());
            System.out.println(pref.toString());
            _currRealDepth--;
        }

        visitChildren(ctx);
        _currRealDepth--;
        return null;
    }

    @Override
    public Void visitWriteABody(GCLGrammarParser.WriteABodyContext ctx)
    {
        return addPrintVisitLeave("TwoPoints", ctx);
    }

    @Override
    public Void visitInst(GCLGrammarParser.InstContext ctx)
    {
        if (ctx.TkSkip() != null)
        {
            StringBuilder pref = generatePrefix(_currRealDepth++).append("Skip");
            System.out.println(pref.toString());
            _currRealDepth--;
            return null;
        }

        visitChildren(ctx);
        return null;
    }

    @Override
    public Void visitForOp(GCLGrammarParser.ForOpContext ctx)
    {
        return addPrintVisitLeave("For", ctx);
    }

    @Override
    public Void visitIn(GCLGrammarParser.InContext ctx) // epa tkid aca xD?
    {
        StringBuilder pref = generatePrefix(_currRealDepth++).append("In");
        System.out.println(pref.toString());

        TerminalNode id = ctx.TkId();
        pref = generatePrefix(_currRealDepth).append(id.getText());
        System.out.println(pref);

        visitChildren(ctx);
        _currRealDepth--;
        return null;
        //return addPrintVisitLeave("In", ctx);
    }

    @Override
    public Void visitTo(GCLGrammarParser.ToContext ctx)
    {
        return addPrintVisitLeave("To", ctx);
    }

    @Override
    public Void visitPrinteable(GCLGrammarParser.PrinteableContext ctx)
    {
        if (ctx.TkString() != null) // pendiente
        {
            StringBuilder pref = generatePrefix(_currRealDepth++).append("String: ").append(ctx.getText());
            System.out.println(pref.toString());
            _currRealDepth--;
            return null;
        }

        visitChildren(ctx);
        return null;
    }

    @Override
    public Void visitPrint(GCLGrammarParser.PrintContext ctx)
    {
        return addPrintVisitLeave("Print", ctx);
    }

    @Override
    public Void visitConcatenable(GCLGrammarParser.ConcatenableContext ctx)
    {
        if (ctx.TkString() != null)
        {
            StringBuilder pref = generatePrefix(_currRealDepth++).append("String: ").append(ctx.getText());
            System.out.println(pref.toString());
            _currRealDepth--;
            return null;
        }

        visitChildren(ctx);
        return null;
    }

    @Override
    public Void visitConcatenation(GCLGrammarParser.ConcatenationContext ctx)
    {
        return addPrintVisitLeave("Concat", ctx);
    }

    @Override
    public Void visitIfOp(GCLGrammarParser.IfOpContext ctx)
    {
        return addPrintVisitLeave("If", ctx);
    }

    @Override
    public Void visitGuard(GCLGrammarParser.GuardContext ctx)
    {
        return addPrintVisitLeave("Guard", ctx);
    }

    @Override
    public Void visitThen(GCLGrammarParser.ThenContext ctx)
    {
        return addPrintVisitLeave("Then", ctx);
    }

    @Override
    public Void visitDoOp(GCLGrammarParser.DoOpContext ctx)
    {
        return addPrintVisitLeave("Do", ctx);
    }
}
