import com.parsing.GCLGrammarBaseVisitor;
import com.parsing.GCLGrammarParser;

public class ASTPrinter extends com.parsing.GCLGrammarBaseVisitor<Void> {

    private int _currRealDepth = 0;

    private StringBuilder generatePrefix(int len) {
        StringBuilder builder = new StringBuilder(Integer.toString(len));
        for (int i = 0; i < len; builder.append('-'), ++i)
            ;
        return builder;
    }

    @Override
    public Void visitBlock(GCLGrammarParser.BlockContext ctx) {
        StringBuilder pref = generatePrefix(_currRealDepth++).append("Block");
        System.out.println(pref.toString());

        visitChildren(ctx);
        _currRealDepth--;
        return null;
    }

    @Override
    public Void visitDeclarationBlock(GCLGrammarParser.DeclarationBlockContext ctx) {
        StringBuilder pref = generatePrefix(_currRealDepth++).append("Declare");
        System.out.println(pref.toString());

        visitChildren(ctx);
        _currRealDepth--;
        return null;
    }

    @Override
    public Void visitSeqDecl(GCLGrammarParser.SeqDeclContext ctx)
    {
        StringBuilder pref = generatePrefix(_currRealDepth++);
        pref.append("Sequencing");
        System.out.println(pref);
        visitChildren(ctx);

        _currRealDepth--;
        return null;
    }

    @Override
    public Void visitDecl(GCLGrammarParser.DeclContext ctx)
    {
        StringBuilder pref = generatePrefix(_currRealDepth++);
        pref.append("DECLARACION: " + ctx.getText());
        System.out.println(pref);
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
        StringBuilder pref = generatePrefix(_currRealDepth++).append("Sequencing");
        System.out.println(pref);
        visitChildren(ctx);

        _currRealDepth--;
        return null;
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
        StringBuilder pref = generatePrefix(_currRealDepth++).append("Mult");
        System.out.println(pref.toString());
        visitChildren(ctx);
        _currRealDepth--;
        return null;
    }

    @Override
    public Void visitUnMinExp(GCLGrammarParser.UnMinExpContext ctx)
    {
        StringBuilder pref = generatePrefix(_currRealDepth++).append("Minus");
        System.out.println(pref.toString());
        visitChildren(ctx);
        
        _currRealDepth--;
        return null;
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
        StringBuilder pref = generatePrefix(_currRealDepth++).append("Comma ");
        System.out.println(pref.toString());

        visitChildren(ctx);

        _currRealDepth--;
        return null;
    }

    @Override
    public Void visitAsignation(GCLGrammarParser.AsignationContext ctx)
    {
        StringBuilder pref = generatePrefix(_currRealDepth++).append("Asignation: ");
        System.out.println(pref.toString());

        visitChildren(ctx);

        _currRealDepth--;
        return null;
    }

    @Override
    public Void visitReadA(GCLGrammarParser.ReadAContext ctx)
    {
        StringBuilder pref = generatePrefix(_currRealDepth++).append("ReadArray: ");
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
        StringBuilder pref = generatePrefix(_currRealDepth++).append("TwoPoints ");
        System.out.println(pref.toString());
        visitChildren(ctx);
        _currRealDepth--;
        return null;
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
}
