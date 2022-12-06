import com.parsing.GCLGrammarParser.ExpContext;
import com.parsing.GCLGrammarParser;

import java.util.Hashtable;
import java.util.Iterator;
import java.util.Stack;

import org.antlr.v4.runtime.ParserRuleContext;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.tree.TerminalNode;

/** 
 * Clase que se encarga de visitar cada uno de los nodos del arbol sintactico abstracto generado
 * y hacer chequeo de tipos
 */
public class ASTTypeChecker extends com.parsing.GCLGrammarBaseVisitor<Void> {
    
    // Tablas de simbolos
    private Stack<Hashtable<String, String>> _symbolStack = new Stack<Hashtable<String, String>>();
    private Stack<String> _forStack = new Stack<String>();

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


    /**
     * Revisa si un simbolo se encuentra en las tablas de simbolos.
     * @param symbol Simbolo a buscar
     * @return true si esta en alguna tabla. false en caso contrario.
     */
    public boolean isSymbolInTables(String symbol) {
        Iterator<Hashtable<String, String>> tablesIT = _symbolStack.iterator();
        while (tablesIT.hasNext())
        {
            if (tablesIT.next().containsKey(symbol))
                return true;
        }

        return false;
    }


    /**
     * Revisa si un simbolo se encuentra en alguna declaracion de for
     * @param symbol Simbolo a buscar
     * @return true si esta en algun for. false en caso contrario.
     */
    public boolean isSymbolInForStack(String symbol) {
        Iterator<String> forIT = _forStack.iterator();
        while (forIT.hasNext())
        {
            if (forIT.next().equals(symbol))
                return true;
        }

        return false;
    }


    /**
     * Busca el tipo de un simbolo en las tablas. Si no se encuentra en las tablas,
     * busca si se encuentra en un for.
     * @param ident Simbolo a buscar
     * @return Tipo del simbolo
     */
    public String lookSymbolType(String ident) {
        Iterator<Hashtable<String, String>> tablesIT = _symbolStack.iterator();
        while (tablesIT.hasNext())
        {
            Hashtable<String, String> table = tablesIT.next();
            if (table.containsKey(ident))
                return table.get(ident);
        }

        return (isSymbolInForStack(ident) ? "int" : null);
    }

    
    /**
     * Agrega un simbolo a la tabla de simbolos tope del stack
     * @param id Simbolo a agregar
     * @param gclType Tipo del simbolo
     */
    public void addToTopSymbols(String id, String gclType) 
    {
        _symbolStack.peek().put(id, gclType);
    }
    

    /**
     * Resuelve el tipo de un nodo del tipo Exp (expresion). Recorre los 
     * hijos del nodo actual hasta llegar a un nodo hoja.
     * @implNote Solo debe usarse en expresiones parentesis y expresiones TkId
     * @param current Nodo expresion actual.
     */
    private void resolveExpIDType(GCLGrammarParser.ExpContext current)
    {
        // parentesis
        if (current instanceof GCLGrammarParser.ParExpContext)
        {
            GCLGrammarParser.ExpContext child = ((GCLGrammarParser.ParExpContext)current).exp();
            resolveExpIDType(child);
            current.expType = child.expType;
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

        current.expType = t;
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


    /**
     * Visita nodos de la lista de declaraciones y agrega los simbolos 
     * a su respectiva tabla
     * @param ctx parsetree de LdecContext
     * @param gclType Tipo de los simbolos
     * @return nada
     */
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
            ": It is changing the variable \"" + id + "\", which is a control variable of a 'for' statement");
            System.exit(-1);
        }

        addToTopSymbols(id, gclType);
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
        visitLdec(ctx.ldec(), ctx.type().getText());
        return null;
    }


    @Override
    public Void visitNumericLit(GCLGrammarParser.NumericLitContext ctx)
    {
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
            Token tok = cExp.start;
            System.out.println(expectedTypeErrorString("int", cExp.expType, tok.getLine(), tok.getCharPositionInLine()));
            System.exit(-1);
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
            Token tok = cExp.start;
            System.out.println(expectedTypeErrorString("bool", cExp.expType, tok.getLine(), tok.getCharPositionInLine()));
            System.exit(-1);
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
                Token tok = cExp.start;
                System.out.println(expectedTypeErrorString("int", cExp.expType, tok.getLine(), tok.getCharPositionInLine()));
                System.exit(-1);
            }

            visit(cExp);
        }

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
                Token tok = cExp.start;
                System.out.println(expectedTypeErrorString("int", cExp.expType, tok.getLine(), tok.getCharPositionInLine()));
                System.exit(-1);
            }

            visit(cExp);
        }

        _currRealDepth--;
        return null;
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

        pref.append(" | type: bool");
        System.out.println(pref.toString());

        for (GCLGrammarParser.ExpContext cExp : ctx.exp()) {
            if (cExp.expType == null)
                resolveExpIDType(cExp);

            if (!cExp.expType.equals("int")) {
                Token tok = cExp.start;
                System.out.println(expectedTypeErrorString("int", cExp.expType, tok.getLine(), tok.getCharPositionInLine()));
                System.exit(-1);
            }

            visit(cExp);
        }

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
                visit(cExp);
                continue;
            }
            
            if (!cType.equals(cExp.expType)) {
                Token tok = cExp.start;
                System.out.println(expectedTypeErrorString(cType, cExp.expType, tok.getLine(), tok.getCharPositionInLine()));
                System.exit(-1);
            }

            visit(cExp);
        }

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
                Token tok = cExp.start;
                System.out.println(expectedTypeErrorString("bool", cExp.expType, tok.getLine(), tok.getCharPositionInLine()));
                System.exit(-1);
            }

            visit(cExp);
        }

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
                Token tok = cExp.start;
                System.out.println(expectedTypeErrorString("bool", cExp.expType, tok.getLine(), tok.getCharPositionInLine()));
                System.exit(-1);
            }

            visit(cExp);
        }

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
        visitChildren(ctx); // se encargan los hijos de adentro
        return null;
    }
    

    @Override
    public Void visitArrayInit(GCLGrammarParser.ArrayInitContext ctx)
    {
        return addPrintVisitLeave("Comma | type : array with length=algo.", ctx); // falta esto
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

        if (isSymbolInForStack(id)) {
            System.out.println("Error in row " + idTok.getLine() + ", column " + idTok.getCharPositionInLine() + 
            ": It is changing the variable \"" + id + "\", which is a control variable of a 'for' statement");
            System.exit(-1);
        }

        pref = pref.append("Ident: " + id + " | type: " + idType);
        System.out.println(pref);

        // puede ser dos cosas: asignable  = exp | writeA o arrayInit. si es array init hay que chequear largos de arreglos.
        // si es writeA hay que chequear de forma similar si los slices resultantes tienen largos iguales. y si el simbolo esta en for?
        if (ctx.asignable() != null) {
            if (ctx.asignable().exp() != null) {
                GCLGrammarParser.ExpContext cExp = ctx.asignable().exp();
                if (cExp.expType == null)
                    resolveExpIDType(cExp); // resuelve para for tambien!

                if (!cExp.expType.equals(idType)) {
                    Token tok = ctx.start;
                    System.out.println(expectedTypeErrorString(idType, cExp.expType, tok.getLine(), tok.getCharPositionInLine()));
                    System.exit(-1);
                }
            }
            else {
                // es un writeA chequeo tipos
            }
        }
        else {
            // es un arrayInit chequeo tipos
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
        TerminalNode idNode = ctx.TkId();
        if (idNode != null) { // no puede se null XD revisar
            String id = idNode.toString();
            String idType = lookSymbolType(id);
            if (idType == null) {
                System.out.println("Symbol " + id + " undeclared in row " + idNode.getSymbol().getLine() + 
                ", column " + idNode.getSymbol().getCharPositionInLine());
                System.exit(-1);
            }

            if (!idType.contains("array")) {
                Token tok = idNode.getSymbol();
                System.out.println(expectedTypeErrorString("array", idType, tok.getLine(), tok.getCharPositionInLine()));
                System.exit(-1);
            }

            pref = generatePrefix(_currRealDepth++).append("Ident: " + id + " | type: " + idType);
            System.out.println(pref.toString());
            _currRealDepth--;
        }

        ExpContext cExp = ctx.exp();
        if (cExp.expType != "int") {
            Token tok = cExp.start;
            System.out.println(expectedTypeErrorString("int", cExp.expType, tok.getLine(), tok.getCharPositionInLine()));
            System.exit(-1);
        }

        visitChildren(ctx);
        _currRealDepth--;

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
        StringBuilder pref = generatePrefix(_currRealDepth++).append("TwoPoints");
        System.out.println(pref.toString());

        for (GCLGrammarParser.ExpContext cExp : ctx.exp()) {
            if (cExp.expType == null)
                resolveExpIDType(cExp);

            if (!cExp.expType.equals("int")) {
                Token tok = cExp.start; 
                System.out.println(expectedTypeErrorString("int", cExp.expType, 
                    tok.getLine(), tok.getCharPositionInLine()));
                System.exit(-1);
            }

            visit(cExp);
        }
        _currRealDepth--;
        return null;
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
        addPrintVisitLeave("For", ctx);
        _forStack.pop();
        return null;
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
            ": It is changing the variable \"" + id + "\", which is a control variable of a 'for' statement");
            System.exit(-1);
        }

        _forStack.push(id);
        pref = generatePrefix(_currRealDepth).append("Ident: " + id + " | type: int");
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

        for (GCLGrammarParser.ExpContext cExp : ctx.exp()) {
            if (cExp.expType == null)
                resolveExpIDType(cExp);

            if (!cExp.expType.equals("int")) {
                Token tok = cExp.start; 
                System.out.println(expectedTypeErrorString("int", cExp.expType, 
                    tok.getLine(), tok.getCharPositionInLine()));
                System.exit(-1);
            }
            visit(cExp);
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
        GCLGrammarParser.ExpContext cExp = ctx.exp();
        if (cExp.expType == null)
            resolveExpIDType(cExp);

        if (!cExp.expType.equals("bool")) {
            Token tok = cExp.start;
            System.out.println(expectedTypeErrorString("bool", cExp.expType, 
                tok.getLine(), tok.getCharPositionInLine()));
            System.exit(-1);
        }
        return null;
    }


    @Override
    public Void visitDoOp(GCLGrammarParser.DoOpContext ctx)
    {
        return addPrintVisitLeave("Do", ctx);
    }
}
