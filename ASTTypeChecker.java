import com.parsing.GCLGrammarBaseVisitor;
import com.parsing.GCLGrammarLexer;
import com.parsing.GCLGrammarParser;
import com.parsing.GCLGrammarParser.ExpContext;

import java.util.Stack;
import java.util.function.Consumer;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.List;

import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.ParserRuleContext;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.tree.TerminalNode;

/** 
 * Clase que se encarga de visitar cada uno de los nodos del arbol sintactico abstracto generado.
 * Cada una de las funciones cuyo nombre inicia con visit, es equivalente a visitar un nodo de 
 * este arbol. 
 */
public class ASTTypeChecker extends com.parsing.GCLGrammarBaseVisitor<Void> {
    
    private Stack<Hashtable<String, String>> _symbolStack = new Stack<Hashtable<String, String>>();
    private Stack<String> _forStack = new Stack<String>();

    public boolean isSymbolInTables(String symbol) {
        Iterator<Hashtable<String, String>> tablesIT = _symbolStack.iterator();
        while (tablesIT.hasNext())
        {
            if (tablesIT.next().containsKey(symbol))
                return true;
        }

        return false;
    }


    public boolean isSymbolInForStack(String symbol) {
        Iterator<String> forIT = _forStack.iterator();
        while (forIT.hasNext())
        {
            if (forIT.next().equals(symbol))
                return true;
        }

        return false;
    }

    public String lookSymbolType(String ident) {
        Iterator<Hashtable<String, String>> tablesIT = _symbolStack.iterator();
        while (tablesIT.hasNext())
        {
            Hashtable<String, String> table = tablesIT.next();
            if (table.containsKey(ident))
                return table.get(ident);
        }

        return null;
    }

    public void addToTopSymbols(String id, String gclType, Token tok) 
    {
         _symbolStack.peek().put(id, gclType);
    }

    private GCLGrammarParser _target = null;
    /** Profundidad actual del arbol */
    private int _currRealDepth = 0;

    /**
     * Genera un stringbuilder con prefijo -
     * @param len Cantidad de prefijos
     * @return Stringbuilder con - len veces.
     */
    private StringBuilder generatePrefix(int len) {
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < len; builder.append('-'), ++i)
            ;
        return builder;
    }
    

    private void resolveExpIDType(GCLGrammarParser.ExpContext current)
    {
        // parentesis
        if (current instanceof GCLGrammarParser.ParExpContext)
        {
            GCLGrammarParser.ExpContext child = ((GCLGrammarParser.ParExpContext)current).exp();
            resolveExpIDType(child);
            current.expType = child.expType;
            System.out.println("Resuelto tipo: " + current.expType);
            return;
        }

        // tiene que ser tipo id si o si
        GCLGrammarParser.IdExpContext idCTX = ((GCLGrammarParser.IdExpContext)current);
        Token idTok = idCTX.TkId().getSymbol();
        String id = idTok.getText();
        String t = lookSymbolType(id);
        if (t == null) {
            System.out.println("Symbol " + id + " undeclared in row " + idTok.getLine() + 
                ", column " + idTok.getCharPositionInLine());
                System.exit(-1);
        }
    }

    private StringBuilder expectedTypeErrorString(String expc, String recv, int row, int col) {
        return new StringBuilder().append(String.format("Unexpected type received in row %d col %d." + 
            "Received %s but expected %s", row, col, recv, expc));
    }

    /**
     * Visita un nodo, aumenta la profundidad, imprime el nombre del nodo,
     * visita a sus hijos, y decrementa la profundidad.
     * @param txt Texto a imprimir
     * @param ctx Nodo a visitar
     * @return vacio.
     */
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
        _symbolStack.push(ctx.symbols);
        addPrintVisitLeave("Block", ctx);
        _symbolStack.pop();
        return null;
    }


    @Override
    public Void visitDeclarationBlock(GCLGrammarParser.DeclarationBlockContext ctx) {
        return addPrintVisitLeave("Symbols Table", ctx);
    }


    @Override
    public Void visitSeqDecl(GCLGrammarParser.SeqDeclContext ctx)
    {
        visitChildren(ctx);
        return null;
    }


    public Void visitLdec(GCLGrammarParser.LdecContext ctx, String gclType)
    {
        ctx.gclType = gclType;

        StringBuilder lvl = generatePrefix(_currRealDepth);
        String id = ctx.TkId().getText();
        Token idTok = ctx.TkId().getSymbol();
        if (isSymbolInTables(id))
        {
            System.out.println("Symbol " + id + " redeclaration in row " + idTok.getLine() + 
                ", column " + idTok.getCharPositionInLine());
                System.exit(-1);
        }

        if (isSymbolInForStack(id))
        {
            System.out.println("Error in row " + idTok.getLine() + ", column " + idTok.getCharPositionInLine() + 
            ": It is changing the variable \"" + id + "\", which is a control variable of a ’for’ statement");
            System.exit(-1);
        }

        addToTopSymbols(id, gclType, ctx.TkId().getSymbol());
        lvl.append("variable: " + id + " | type: " + gclType);
        System.out.println(lvl.toString());

        GCLGrammarParser.LdecContext c = ctx.ldec();
        if (c != null)
            visitLdec(c, gclType);

        return null;
    }


    @Override
    public Void visitDecl(GCLGrammarParser.DeclContext ctx)
    {
        _currRealDepth++;
        visitLdec(ctx.ldec(), ctx.type().getText());
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
        StringBuilder pref = generatePrefix(_currRealDepth++);
        pref.append("Minus | type : int");
        GCLGrammarParser.ExpContext cExp = ctx.exp();
        if (cExp.expType == null)
            resolveExpIDType(cExp);

        if (!cExp.expType.equals("int")) {
            Token tok = ctx.start;
            System.out.println(expectedTypeErrorString("int", cExp.expType, tok.getLine(), tok.getCharPositionInLine()));
            System.exit(1);
        }

        visitChildren(ctx);
        _currRealDepth--;
        return null;       
    }


    @Override
    public Void visitNotExp(GCLGrammarParser.NotExpContext ctx)
    {
        StringBuilder pref = generatePrefix(_currRealDepth++);
        pref.append("Not | type : bool");
        GCLGrammarParser.ExpContext cExp = ctx.exp();
        if (cExp.expType == null)
            resolveExpIDType(cExp);

        if (!cExp.expType.equals("bool")) {
            Token tok = ctx.start;
            System.out.println(expectedTypeErrorString("bool", cExp.expType, tok.getLine(), tok.getCharPositionInLine()));
            System.exit(1);
        }
        
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

        pref.append(" | type: int");
        System.out.println(pref.toString());

        for (GCLGrammarParser.ExpContext cExp : ctx.exp()) {
            if (cExp.expType == null)
                resolveExpIDType(cExp);

            if (!cExp.expType.equals("int")) {
                Token tok = ctx.start;
                System.out.println(expectedTypeErrorString("int", cExp.expType, tok.getLine(), tok.getCharPositionInLine()));
                System.exit(1);
            }
        }

        visitChildren(ctx);
        _currRealDepth--;
        return null;
    }


    @Override
    public Void visitMultExp(GCLGrammarParser.MultExpContext ctx)
    {
        StringBuilder pref = generatePrefix(_currRealDepth++);

        pref.append("Mult | type : int");
        System.out.println(pref.toString());

        for (GCLGrammarParser.ExpContext cExp : ctx.exp()) {
            if (cExp.expType == null)
                resolveExpIDType(cExp);

            if (!cExp.expType.equals("int")) {
                Token tok = ctx.start;
                System.out.println(expectedTypeErrorString("int", cExp.expType, tok.getLine(), tok.getCharPositionInLine()));
                System.exit(1);
            }
        }

        visitChildren(ctx);
        _currRealDepth--;
        return null;
    }


    @Override
    public Void visitOrdExp(GCLGrammarParser.OrdExpContext ctx)
    {
        StringBuilder pref = generatePrefix(_currRealDepth++);
        // Clasificando operador
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

        pref.append(" | type: bool");
        System.out.println(pref.toString());

        for (GCLGrammarParser.ExpContext cExp : ctx.exp()) {
            if (cExp.expType == null)
                resolveExpIDType(cExp);

            if (!cExp.expType.equals("bool")) {
                Token tok = ctx.start;
                System.out.println(expectedTypeErrorString("bool", cExp.expType, tok.getLine(), tok.getCharPositionInLine()));
                System.exit(1);
            }
        }

        visitChildren(ctx);
        _currRealDepth--;
        return null;
    }


    @Override
    public Void visitEqExp(GCLGrammarParser.EqExpContext ctx)
    {
        StringBuilder pref = generatePrefix(_currRealDepth++);
        // Clasificando operador
        switch (ctx.op.getType()) {
            case GCLGrammarParser.TkEqual:
                pref.append("Equal");
                break;
            case GCLGrammarParser.TkNEqual:
                pref.append("NotEqual");
                break;
        }

        pref.append(" | type: bool");
        System.out.println(pref.toString());

        String cType = null;
        for (GCLGrammarParser.ExpContext cExp : ctx.exp()) {
            if (cExp.expType == null)
                resolveExpIDType(cExp);

            if (cType == null) {
                cType = cExp.expType;
                continue;
            }
            
            if (!cType.equals(cExp.expType)) {
                Token tok = ctx.start;
                System.out.println(expectedTypeErrorString(cType, cExp.expType, tok.getLine(), tok.getCharPositionInLine()));
                System.exit(1);
            }
        }

        visitChildren(ctx);
        _currRealDepth--;
        return null;
    }


    @Override
    public Void visitAndExp(GCLGrammarParser.AndExpContext ctx)
    {
        StringBuilder pref = generatePrefix(_currRealDepth++);

        pref.append("And | type : bool");
        System.out.println(pref.toString());

        for (GCLGrammarParser.ExpContext cExp : ctx.exp()) {
            if (cExp.expType == null)
                resolveExpIDType(cExp);

            if (!cExp.expType.equals("bool")) {
                Token tok = ctx.start;
                System.out.println(expectedTypeErrorString("bool", cExp.expType, tok.getLine(), tok.getCharPositionInLine()));
                System.exit(1);
            }
        }

        visitChildren(ctx);
        _currRealDepth--;
        return null;
    }


    @Override
    public Void visitOrExp(GCLGrammarParser.OrExpContext ctx)
    {
        StringBuilder pref = generatePrefix(_currRealDepth++);

        pref.append("Or | type : bool");
        System.out.println(pref.toString());

        for (GCLGrammarParser.ExpContext cExp : ctx.exp()) {
            if (cExp.expType == null)
                resolveExpIDType(cExp);

            if (!cExp.expType.equals("bool")) {
                Token tok = ctx.start;
                System.out.println(expectedTypeErrorString("bool", cExp.expType, tok.getLine(), tok.getCharPositionInLine()));
                System.exit(1);
            }
        }

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
        StringBuilder pref = generatePrefix(_currRealDepth++);

        Token idTok = ctx.TkId().getSymbol();
        String id = idTok.getText();
        String idType = lookSymbolType(id);
        if (idType == null) {
            System.out.println("Symbol " + id + " undeclared in row " + idTok.getLine() + 
                ", column " + idTok.getCharPositionInLine());
                System.exit(-1);
        }

        pref = pref.append("Ident: " + id + " | type: " + idType);
        System.out.println(pref.toString());

        _currRealDepth--;
        return null;
    }


    @Override
    public Void visitNumExp(GCLGrammarParser.NumExpContext ctx)
    {
        StringBuilder pref = generatePrefix(_currRealDepth++);
        pref = pref.append("Literal: " + ctx.getText() + " | type: " + "int");
    
        System.out.println(pref.toString());
        _currRealDepth--;
        return null;
    }


    @Override
    public Void visitBoolExp(GCLGrammarParser.BoolExpContext ctx)
    {
        StringBuilder pref = generatePrefix(_currRealDepth++);
        pref = pref.append("Literal: " + ctx.getText() + " | type: bool");
    
        System.out.println(pref.toString());
        _currRealDepth--;
        return null;
    }


    @Override
    public Void visitReadAExp(GCLGrammarParser.ReadAExpContext ctx)
    {
        visitChildren(ctx); // falta esto
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
        return addPrintVisitLeave("Comma | type : array de largo algo.", ctx); // aca va cosa de array
    }


    @Override
    public Void visitAsignation(GCLGrammarParser.AsignationContext ctx)
    {
        StringBuilder pref = generatePrefix(_currRealDepth++).append("Asig");
        System.out.println(pref.toString());

        pref = generatePrefix(_currRealDepth);
        Token idTok = ctx.TkId().getSymbol();
        String id = idTok.getText();
        String idType = lookSymbolType(id);
        if (idType == null) {
            System.out.println("Symbol " + id + " undeclared in row " + idTok.getLine() + 
                ", column " + idTok.getCharPositionInLine());
                System.exit(-1);
        }

        if (isSymbolInForStack(idType)) {
            System.out.println("Error in row " + idTok.getLine() + ", column " + idTok.getCharPositionInLine() + 
            ": It is changing the variable \"" + id + "\", which is a control variable of a ’for’ statement");
            System.exit(-1);
        }

        pref = pref.append("Ident: " + id + " | type: " + idType);
        System.out.println(pref);

        if (ctx.asignable() != null) {
            if (ctx.asignable().exp() != null) {
                GCLGrammarParser.ExpContext cExp = ctx.asignable().exp();
                if (cExp.expType == null)
                    resolveExpIDType(cExp);

                if (!cExp.expType.equals(idType)) {
                    Token tok = ctx.start;
                    System.out.println(expectedTypeErrorString(idType, cExp.expType, tok.getLine(), tok.getCharPositionInLine()));
                    System.exit(1);
                }
            }
        }
        visitChildren(ctx);

        _currRealDepth--;
        return null;
    }


    @Override
    public Void visitReadA(GCLGrammarParser.ReadAContext ctx)
    {
        StringBuilder pref = generatePrefix(_currRealDepth++).append("ReadArray | type: int");
        System.out.println(pref.toString());

        // Extraccion de ID array
        if (ctx.TkId() != null) {
            String id = ctx.TkId().toString();
            String idType = lookSymbolType(id);
            if (idType == null) {
                System.out.println("coso no decalrado");
                return null;
            }

            if (!idType.contains("array")) {
                System.out.println("error de tipo");
                return null;
            }

            pref = generatePrefix(_currRealDepth++).append("Ident: " + id + " | type: int");
            System.out.println(pref.toString());
            _currRealDepth--;
        }

        visitChildren(ctx); // chequear si [] es int
        _currRealDepth--;

        ExpContext cExp = ctx.exp();
        if (cExp.expType != "int") {
            Token tok = cExp.start;
            System.out.println(expectedTypeErrorString("int", cExp.expType, tok.getLine(), tok.getCharPositionInLine()));
            return null;
        }

        return null;
    }


    @Override
    public Void visitWriteA(GCLGrammarParser.WriteAContext ctx)
    {
        StringBuilder pref = generatePrefix(_currRealDepth++).append("WriteArray");
        System.out.println(pref.toString());

        // Extraccion de ID array
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
        // Instruccion skip
        if (ctx.TkSkip() != null)
        {
            StringBuilder pref = generatePrefix(_currRealDepth++).append("skip");
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
    public Void visitIn(GCLGrammarParser.InContext ctx)
    {
        StringBuilder pref = generatePrefix(_currRealDepth++).append("In");
        System.out.println(pref.toString());

        String id = ctx.TkId().getText();
        Token idTok = ctx.TkId().getSymbol();
        if (isSymbolInTables(id))
        {
            System.out.println("Symbol " + id + " redeclaration in row " + idTok.getLine() + 
                ", column " + idTok.getCharPositionInLine());
            System.exit(-1);
        }

        if (isSymbolInForStack(id))
        {
            System.out.println("Error in row " + idTok.getLine() + ", column " + idTok.getCharPositionInLine() + 
            ": It is changing the variable \"" + id + "\", which is a control variable of a ’for’ statement");
            System.exit(-1);
        }

        _forStack.push(id);
        pref = generatePrefix(_currRealDepth).append("Ident: ").append(id);
        System.out.println(pref);

        visitChildren(ctx);
        _currRealDepth--;
        return null;
    }


    @Override
    public Void visitTo(GCLGrammarParser.ToContext ctx)
    {
        StringBuilder pref = generatePrefix(_currRealDepth++).append("To");
        System.out.println(pref.toString());

        for (GCLGrammarParser.ExpContext val : ctx.exp()) {
            visit(val);
            if (val.expType != "int")
            {
                System.out.println("ERROR DE TIPO");
                return null;
            }
        }
        _currRealDepth--;
        return null;
    }


    @Override
    public Void visitPrinteable(GCLGrammarParser.PrinteableContext ctx)
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
        addPrintVisitLeave("Then", ctx);
        if (!ctx.exp().expType.equals("bool")) {
            System.out.println("ERROR DE TIPO");
            return null;
        }
        return null;
    }


    @Override
    public Void visitDoOp(GCLGrammarParser.DoOpContext ctx)
    {
        return addPrintVisitLeave("Do", ctx);
    }

    
    public ASTTypeChecker(GCLGrammarParser target) {
        super();
        _target = target;
    }
}
