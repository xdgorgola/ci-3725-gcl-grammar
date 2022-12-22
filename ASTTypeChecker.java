import com.parsing.GCLGrammarParser.ExpContext;
import com.parsing.utils.SymbolsTable;
import com.parsing.GCLGrammarParser;

import java.util.regex.Pattern;
import java.util.regex.Matcher;
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
    private Stack<SymbolsTable> _symbolStack = new Stack<SymbolsTable>();
    private Stack<String> _forStack = new Stack<String>();

    /** Profundidad actual del arbol */
    private int _currRealDepth = 0;
    private boolean _print = false;

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
        SymbolsTable cur = (_symbolStack.empty() ? null : _symbolStack.peek());
        for(;cur != null; cur = cur.getPreviousTable()) {
            if (cur.isSymbolInTable(symbol))
                return true;
        }

        return false;
    }


    /**
     * Revisa si un simbolo se encuentra en la ultima tabla de simbolos
     * @param symbol Simbolo a buscar
     * @return true si esta en la ultima tabla. false en caso contrario.
     */
    public boolean isSymbolInLastTable(String symbol) {
        return _symbolStack.peek().isSymbolInTable(symbol);
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
        SymbolsTable cur = (_symbolStack.empty() ? null : _symbolStack.peek());
        for(;cur != null; cur = cur.getPreviousTable()) {
            if (cur.isSymbolInTable(ident))
                return cur.getSymbolType(ident);
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
        _symbolStack.peek().addSymbol(id, gclType);
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


    /**
     * Calcula el largo de un simbolo que representa un arreglo.
     * @param id Simbolo
     * @return largo del arreglo.
     */
    private int calculateSymbolArrayLen(String id) {
        int len = 0;
        String typeStr = lookSymbolType(id);
        Pattern p = Pattern.compile("-*[0-9]+");
        Matcher match = p.matcher(typeStr);
        while (match.find())
            len = Integer.parseInt(match.group()) - len;
        
        return len + 1;
    }


    /**
     * Genera un mensaje de error de tipo inesperado
     * @param expc Tipo esperado
     * @param recv Tipo recibido
     * @param row Linea del error
     * @param col Columna del error
     * @return Stringbuilder con el mensaje
     */
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

        if(_print)
            System.out.println(pref.toString());

        visitChildren(ctx);
        _currRealDepth--;
        return null;
    }
    

    @Override
    public Void visitBlock(GCLGrammarParser.BlockContext ctx) {
        ctx.symbols.setPreviousTable((_symbolStack.empty() ? null : _symbolStack.peek()));
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
        // Chequeo redeclaracion
        if (isSymbolInLastTable(id))
        {
            System.out.println("Symbol " + id + " redeclaration in row " + idTok.getLine() + 
                ", column " + idTok.getCharPositionInLine());
                System.exit(-1);
        }

        if (isSymbolInForStack(id))
        {
            System.out.println("Error in row " + idTok.getLine() + ", column " + idTok.getCharPositionInLine() + 
            ": It is redeclaring the variable \"" + id + "\", which is a control variable of a 'for' statement");
            System.exit(-1);
        }

        addToTopSymbols(id, gclType);
        lvl.append("variable: " + id + " | type: " + gclType);

        if(_print)
            System.out.println(lvl.toString());

        GCLGrammarParser.LdecContext c = ctx.ldec();
        if (c != null)
            visitLdec(c, gclType);

        return null;
    }


    @Override
    public Void visitDecl(GCLGrammarParser.DeclContext ctx)
    {
        String gclType = ctx.type().getText();
        if (gclType.contains("array")) {
            Pattern p = Pattern.compile("-*[0-9]+");
            Matcher match = p.matcher(gclType);

            match.find();
            int a = Integer.parseInt(match.group());
            match.find();
            int b = Integer.parseInt(match.group());

            if (b <= a) {
                Token tok = ctx.type().start;
                System.out.println("Wrong array declaration on row " + tok.getLine() + " , col " + 
                    tok.getCharPositionInLine() + ".Negative or zero.");
                System.exit(-1);
            }
        }
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

        if (_print)
            System.out.println(pref.toString());

        GCLGrammarParser.ExpContext cExp = ctx.exp();
        // Chequeo de tipo y null
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

        if(_print)
            System.out.println(pref.toString());
        
        GCLGrammarParser.ExpContext cExp = ctx.exp();
        // Chequeo de tipo y null
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
        
        if(_print)
            System.out.println(pref.toString());

        for (GCLGrammarParser.ExpContext cExp : ctx.exp()) {
            // Chequeo de tipo y null
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

        if(_print)
            System.out.println(pref.toString());

        for (GCLGrammarParser.ExpContext cExp : ctx.exp()) {
            // Chequeo de tipo y null
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
        
        if(_print)
            System.out.println(pref.toString());

        for (GCLGrammarParser.ExpContext cExp : ctx.exp()) {
            // Chequeo de tipo y null
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
        
        if(_print)
            System.out.println(pref.toString());

        String cType = null;
        for (GCLGrammarParser.ExpContext cExp : ctx.exp()) {
            // Chequeo de tipo y null
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

        if(_print)
            System.out.println(pref.toString());

        for (GCLGrammarParser.ExpContext cExp : ctx.exp()) {
            // Chequeo de tipo y null
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

        if(_print)
            System.out.println(pref.toString());

        for (GCLGrammarParser.ExpContext cExp : ctx.exp()) {
            // Chequeo de tipo y null
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

        // Chequeo de declaracion
        if (idType == null) {
            System.out.println("Symbol " + id + " undeclared in row " + idTok.getLine() + 
                ", column " + idTok.getCharPositionInLine());
                System.exit(-1);
        }

        ctx.expType = idType;
        pref = pref.append("Ident: " + id + " | type: " + idType);

        if(_print)
            System.out.println(pref.toString());

        _currRealDepth--;
        return null;
    }


    @Override
    public Void visitNumExp(GCLGrammarParser.NumExpContext ctx)
    {
        StringBuilder pref = generatePrefix(_currRealDepth++);
        pref = pref.append("Literal: " + ctx.getText() + " | type: " + "int");
    
        if(_print)
            System.out.println(pref.toString());
        _currRealDepth--;
        return null;
    }


    @Override
    public Void visitBoolExp(GCLGrammarParser.BoolExpContext ctx)
    {
        StringBuilder pref = generatePrefix(_currRealDepth++);
        pref = pref.append("Literal: " + ctx.getText() + " | type: bool");
    
        if(_print)
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
    

    /**
     * Visita un nodo de inicializacion de arreglo
     * @param ctx Contexto de regla ArrayInit
     * @param len Largo del arreglo a iniciar
     * @return nada
     */
    public Void visitArrayInitLen(GCLGrammarParser.ArrayInitContext ctx, int len)
    {
        StringBuilder pref = generatePrefix(_currRealDepth++);
        GCLGrammarParser.ExpContext cExp;

        pref.append("Comma | type: array with length=" + len);

        if(_print)
            System.out.println(pref.toString());

        // Si aun no estamos en el final, profundicemos
        if (ctx.arrayInit() != null)
            visitArrayInitLen(ctx.arrayInit(), len);

        for (GCLGrammarParser.AsignableContext cAsig : ctx.asignable()) {
            cExp = cAsig.exp();
            if (cExp == null) {
                Token tok = cAsig.writeA().start;
                System.out.println(expectedTypeErrorString("int", "array", tok.getLine(), tok.getCharPositionInLine()));
                System.exit(-1);
            }

            // Chequeo de tipo y null
            if (cExp.expType == null)
                resolveExpIDType(cExp);

            if (!cExp.expType.equals("int")) {
                Token tok = cExp.start;
                System.out.println(expectedTypeErrorString("int", cExp.expType, tok.getLine(), tok.getCharPositionInLine()));
                System.exit(-1);
            }

            visit(cAsig);
        }

        _currRealDepth--;
        return null;
    }


    @Override
    public Void visitAsignation(GCLGrammarParser.AsignationContext ctx)
    {
        StringBuilder pref = generatePrefix(_currRealDepth++).append("Asig");

        if(_print)
            System.out.println(pref.toString());

        pref = generatePrefix(_currRealDepth);
        Token idTok = ctx.TkId().getSymbol();
        String id = idTok.getText();
        String idType = lookSymbolType(id);

        // Chequeo declaracion
        if (idType == null) {
            System.out.println("Symbol " + id + " undeclared in row " + idTok.getLine() + 
                ", column " + idTok.getCharPositionInLine());
                System.exit(-1);
        }

        // Chequeo redeclaracion
        if (isSymbolInForStack(id)) {
            System.out.println("Error in row " + idTok.getLine() + ", column " + idTok.getCharPositionInLine() + 
            ": It is changing the variable \"" + id + "\", which is a control variable of a 'for' statement");
            System.exit(-1);
        }

        pref = pref.append("Ident: " + id + " | type: " + idType);

        if(_print)
            System.out.println(pref);

        GCLGrammarParser.AsignableContext asignable = ctx.asignable();
        if (asignable != null) {
            GCLGrammarParser.ExpContext cExp = ctx.asignable().exp();
            
            // caso expresion asignada
            if (cExp != null) {
                // Chequeo de tipo y null
                if (cExp.expType == null)
                    resolveExpIDType(cExp);

                if (!cExp.expType.equals(idType)) {
                    Token tok = ctx.start;
                    System.out.println(expectedTypeErrorString(idType, cExp.expType, tok.getLine(), tok.getCharPositionInLine()));
                    System.exit(-1);
                }

                visit(asignable);
                _currRealDepth--;
                return null;
            }

            // Caso WriteA asignado
            // Chequeo de tipo
            if (!idType.contains("array")) {
                Token tok = ctx.start;
                System.out.println(expectedTypeErrorString(idType, "array", tok.getLine(), tok.getCharPositionInLine()));
                System.exit(-1);
            }
            
            // Extraemos el TKId de WriteA
            String wAID;
            GCLGrammarParser.WriteAContext cur = asignable.writeA();
            while (cur != null) {
                if (cur.TkId() != null) {
                    break;
                }
                cur = cur.writeA();
            }

            wAID = cur.TkId().getText();
            String wType = lookSymbolType(wAID);
            Token wTok = cur.TkId().getSymbol();

            // Chequeo de tipo
            if (wType == null) {
                if (isSymbolInForStack(wAID)) {
                    expectedTypeErrorString(idType, "int", wTok.getLine(), wTok.getCharPositionInLine());
                    System.exit(-1);
                }

                // Chequeo declaracion
                System.out.println("Symbol " + wAID + " undeclared in row " + wTok.getLine() + 
                ", column " + wTok.getCharPositionInLine());
                System.exit(-1);
            }

            // Chequeo de tipo
            if (!wType.equals(idType)) {
                System.out.println(expectedTypeErrorString(idType, wType, wTok.getLine(), wTok.getCharPositionInLine()));
                System.exit(-1);
            }

            visit(asignable);
            _currRealDepth--;
            return null;
        }

        // Caso inicializacion de array
        GCLGrammarParser.ArrayInitContext initCtx = ctx.arrayInit();
        // Chequeo de tipo
        if (!idType.contains("array")) {
            Token tok = initCtx.getStart();
            System.out.println(expectedTypeErrorString(idType, "array", tok.getLine(), tok.getCharPositionInLine()));
            System.exit(-1);
        }
        
        // Chequeo de largo de arreglo a inicializar
        int len = calculateSymbolArrayLen(id);
        int commaCount = (int)initCtx.getText().chars().filter(c -> c == ',').count();
        if (commaCount + 1 != len) {
            System.out.println("Wrong array initialization length at row "+ initCtx.start.getLine() + 
                ". Received " + (commaCount +1) + " elements but array length is " + len);
            System.exit(-1);
        }

        visitArrayInitLen(ctx.arrayInit(), len);

        _currRealDepth--;
        return null;
    }


    @Override
    public Void visitReadA(GCLGrammarParser.ReadAContext ctx)
    {
        StringBuilder pref = generatePrefix(_currRealDepth++).append("ReadArray | type: int");

        if(_print)
            System.out.println(pref.toString());

        // Extraccion de ID array
        TerminalNode idNode = ctx.TkId();
        if (idNode != null) {
            String id = idNode.toString();
            String idType = lookSymbolType(id);

            // Chequeo de tipo y declacracion
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

            if(_print)
                System.out.println(pref.toString());
            _currRealDepth--;
        }

        // Chequeo de tipo y null
        ExpContext cExp = ctx.exp();
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
    public Void visitWriteA(GCLGrammarParser.WriteAContext ctx)
    {
        StringBuilder pref = generatePrefix(_currRealDepth++).append("WriteArray");

        if(_print)
            System.out.println(pref.toString());

        // Extraccion de ID array
        TerminalNode idNode = ctx.TkId();
        if (idNode != null)
        {
            String id = idNode.getText();
            String idType = lookSymbolType(id);
            Token idTok = idNode.getSymbol();

            // Chequeo de tipo
            if (idType == null) {
                if (isSymbolInForStack(id)) {
                    expectedTypeErrorString("array", "int", idTok.getLine(), idTok.getCharPositionInLine());
                    System.exit(-1);
                }

                // Chequeo declaracion
                System.out.println("Symbol " + id + " undeclared in row " + idTok.getLine() + 
                ", column " + idTok.getCharPositionInLine());
                System.exit(-1);
            }

            // Chequeo de tipo
            if (!idType.contains("array")) {
                expectedTypeErrorString("array", "int", idTok.getLine(), idTok.getCharPositionInLine());
                System.exit(-1);
            }

            pref = generatePrefix(_currRealDepth++).append("Ident: " + ctx.TkId().toString());
            pref = pref.append(" | type: " + idType);

            if(_print)
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

        if(_print)
            System.out.println(pref.toString());

        for (GCLGrammarParser.ExpContext cExp : ctx.exp()) {
            // Chequeo de tipo y null
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

            if(_print)
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

        if(_print)
            System.out.println(pref.toString());

        String id = ctx.TkId().getText();
        Token idTok = ctx.TkId().getSymbol();

        // Chequeo de redeclaraciones
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

        if(_print)
            System.out.println(pref);

        visitChildren(ctx);
        _currRealDepth--;
        return null;
    }


    @Override
    public Void visitTo(GCLGrammarParser.ToContext ctx)
    {
        StringBuilder pref = generatePrefix(_currRealDepth++).append("To");

        if(_print)
            System.out.println(pref.toString());

        for (GCLGrammarParser.ExpContext cExp : ctx.exp()) {
            // Chequeo de tipo y null
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
            pref = pref.append(" | type : string");
            
            if(_print)
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
            pref = pref.append(" | type : string");

            if(_print)
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

        // Chequeo de tipo y null
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


    public ASTTypeChecker(boolean print) {
        _print = print;
    }
}
