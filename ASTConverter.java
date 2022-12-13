import com.parsing.utils.SymbolsTable;
import com.parsing.GCLGrammarParser;

import java.util.regex.Pattern;
import java.util.regex.Matcher;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.ListIterator;
import java.util.Stack;
import java.util.ArrayDeque;

import org.antlr.v4.runtime.ParserRuleContext;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.tree.TerminalNode;

/** 
 * Clase que se encarga de visitar cada uno de los nodos del arbol sintactico abstracto generado
 * y hacer chequeo de tipos
 */
public class ASTConverter extends com.parsing.GCLGrammarBaseVisitor<String> {
    
    private static final String OR_STR_CODE = "c_{4}";
    private static final String AND_STR_CODE = "c_{5}";
    private static final String NOT_STR_CODE = "c_{7}";
    private static final String TRUE_STR_CODE = "c_{8}";
    private static final String FALSE_STR_CODE = "c_{9}";
    private static final String SEQ_STR_CODE = "c_{34}";
    private static final String INT_STR_CODE = "c_{36}";
    private static final String BOOL_STR_CODE = "c_{37}";
    private static final String ARR_STR_CODE = "c_{38}";
    private static final String IDE_STR_CODE = "c_{39}";
    private static final String NUM_STR_CODE = "c_{54}";
    private static final String SUM_STR_CODE = "c_{55}";
    private static final String SUB_STR_CODE = "c_{56}";
    private static final String MUL_STR_CODE = "c_{57}";

    // Tablas de simbolos
    private ArrayDeque<SymbolsTable> _symbolStack = new ArrayDeque<SymbolsTable>();
    private ArrayDeque<String> _forStack = new ArrayDeque<String>();

    private int _idNum = 0;
    private Stack<SymbolsTable> _idNames = new Stack<SymbolsTable>();   //x1,x2....xi
    private Stack<SymbolsTable> _idMTypes = new Stack<SymbolsTable>();  //Z,B,Z^[1..3]...
    private Stack<SymbolsTable> _idsState = new Stack<SymbolsTable>();  //x1 + 2, 2 + 1, x3...

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
     * Visita un nodo, aumenta la profundidad, imprime el nombre del nodo,
     * visita a sus hijos, y decrementa la profundidad.
     * @param txt Texto a imprimir
     * @param ctx Nodo a visitar
     * @return vacio.
     */
    private String addPrintVisitLeave(String txt, ParserRuleContext ctx)
    {
        StringBuilder pref = generatePrefix(_currRealDepth++).append(txt);
        System.out.println(pref.toString());

        visitChildren(ctx);
        _currRealDepth--;
        return null;
    }

    

    public String numberToCode(int number) {
        Stack<String> tmp = new Stack<String>();
        StringBuilder res = new StringBuilder();

        if (number == 0)
            return "(c_{42})";

        while (number > 0) {
            int dig = number % 10;
            number = number / 10;
            tmp.add(String.format("c_{%s}", 42 + dig));
        }

        if (tmp.size() == 1)
            return String.format("(%s)", tmp.pop());

        for (int i = 0; !tmp.isEmpty(); i += 2)
        {
            if (tmp.size() > 2) {
                res.append("(" + NUM_STR_CODE + " " + tmp.pop() + " (");
                continue;
            }

            res.append("(" + NUM_STR_CODE + " " + tmp.pop() + " " + tmp.pop() + ")");
            for (; i > 0; --i) {
                res.append(")");
            }
        }
        
        return res.toString();
    }


    public String typeToCode(String type) {
        switch (type) {
            case "int":
                return INT_STR_CODE;
            case "bool":
                return BOOL_STR_CODE;
            default:
                break;
        }

        StringBuilder trad = new StringBuilder(ARR_STR_CODE).append(" (");

        Pattern p = Pattern.compile("-*[0-9]+");
        Matcher match = p.matcher(type);

        Integer a2 = null;
        Integer a3 = null;
        while (match.find()) {
            if (a2 == null) {
                a2 = Integer.parseInt(match.group());
                continue;
            }

            a3 = Integer.parseInt(match.group()); 
        }

        return trad.append(numberToCode(a2)).append(" ")
            .append(numberToCode(a3)).toString();
    }
    

    @Override
    public String visitBlock(GCLGrammarParser.BlockContext ctx) {
        addPrintVisitLeave("Block", ctx);
        return null;
    }


    @Override
    public String visitDeclarationBlock(GCLGrammarParser.DeclarationBlockContext ctx) {
        return addPrintVisitLeave("Symbols Table", ctx);
    }


    @Override
    public String visitSeqDecl(GCLGrammarParser.SeqDeclContext ctx)
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
    @Override
    public String visitLdec(GCLGrammarParser.LdecContext ctx)
    {
        String id = ctx.TkId().getText();
        _idNames.peek().addSymbol(id, "x_{120} " + numberToCode(_idNum++)); // falta agregar el subindice, no se si esto este bien
        _idMTypes.peek().addSymbol(id, typeToCode(ctx.gclType));
        _idsState.peek().addSymbol(id, IDE_STR_CODE + typeToCode(ctx.gclType)); // es asi? no deberia llevar algo por defecto? 
        return "";
    }


    @Override
    public String visitDecl(GCLGrammarParser.DeclContext ctx)
    {
        return null;
    }


    @Override
    public String visitNumericLit(GCLGrammarParser.NumericLitContext ctx)
    {
        return null;
    }


    @Override
    public String visitSeq(GCLGrammarParser.SeqContext ctx)
    {
        StringBuilder trad = new StringBuilder(SEQ_STR_CODE).append(" (");

        ListIterator<org.antlr.v4.runtime.tree.ParseTree> iterator = ctx.children.listIterator(ctx.children.size());
        while (iterator.hasPrevious()) {
            org.antlr.v4.runtime.tree.ParseTree cur = iterator.previous();
            if (cur instanceof TerminalNode)
                continue;
            
            trad.append(visit(cur));
        }
        trad.append(")");
        return trad.toString();
    }


    // Preguntarle a flavi por el - unario
    @Override
    public String visitUnMinExp(GCLGrammarParser.UnMinExpContext ctx)
    {
        StringBuilder pref = generatePrefix(_currRealDepth++);
        pref.append("Minus | type : int");
        System.err.println(pref.toString());

        GCLGrammarParser.ExpContext cExp = ctx.exp();

        visitChildren(ctx);
        _currRealDepth--;
        return null;       
    }


    @Override
    public String visitNotExp(GCLGrammarParser.NotExpContext ctx)
    {
        StringBuilder trad = new StringBuilder(NOT_STR_CODE);
        trad.append(" (");

        ListIterator<org.antlr.v4.runtime.tree.ParseTree> iterator = ctx.children.listIterator(ctx.children.size());
        while (iterator.hasPrevious()) {
            org.antlr.v4.runtime.tree.ParseTree cur = iterator.previous();
            if (cur instanceof TerminalNode)
                continue;
            
            trad.append(visit(cur));
        }
        trad.append(")");
        return trad.toString();
    }


    @Override
    public String visitMinPlusExp(GCLGrammarParser.MinPlusExpContext ctx)
    {
        StringBuilder trad = new StringBuilder();
        switch (ctx.op.getType()) {
            case GCLGrammarParser.TkPlus:
                trad.append(SUM_STR_CODE);
                break;
            case GCLGrammarParser.TkMinus:
                trad.append(SUB_STR_CODE);
                break;
        }
        trad.append(" (");

        ListIterator<org.antlr.v4.runtime.tree.ParseTree> iterator = ctx.children.listIterator(ctx.children.size());
        while (iterator.hasPrevious()) {
            org.antlr.v4.runtime.tree.ParseTree cur = iterator.previous();
            if (cur instanceof TerminalNode)
                continue;
            
            trad.append(visit(cur));
        }
        trad.append(")");
        return trad.toString();
    }


    @Override
    public String visitMultExp(GCLGrammarParser.MultExpContext ctx)
    {
        StringBuilder trad = new StringBuilder(MUL_STR_CODE).append(" (");

        ListIterator<org.antlr.v4.runtime.tree.ParseTree> iterator = ctx.children.listIterator(ctx.children.size());
        while (iterator.hasPrevious()) {
            org.antlr.v4.runtime.tree.ParseTree cur = iterator.previous();
            if (cur instanceof TerminalNode)
                continue;
            
            trad.append(visit(cur));
        }
        trad.append(")");
        return trad.toString();
    }


    @Override
    public String visitOrdExp(GCLGrammarParser.OrdExpContext ctx)
    {
        StringBuilder trad = new StringBuilder();
        switch (ctx.op.getType()) {
            case GCLGrammarParser.TkLeq:
                trad.append("Leq");
                break;
            case GCLGrammarParser.TkLess:
                trad.append("Less");
                break;
            case GCLGrammarParser.TkGeq:
                trad.append("Geq");
                break;
            case GCLGrammarParser.TkGreater:
                trad.append("Greater");
                break;
        }
        trad.append(" (");

        ListIterator<org.antlr.v4.runtime.tree.ParseTree> iterator = ctx.children.listIterator(ctx.children.size());
        while (iterator.hasPrevious()) {
            org.antlr.v4.runtime.tree.ParseTree cur = iterator.previous();
            if (cur instanceof TerminalNode)
                continue;
            
            trad.append(visit(cur));
        }
        trad.append(")");
        return trad.toString();
    }


    @Override
    public String visitEqExp(GCLGrammarParser.EqExpContext ctx)
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

            if (cType == null) {
                cType = cExp.expType;
                visit(cExp);
                continue;
            }
            
            if (!cType.equals(cExp.expType)) {
                Token tok = cExp.start;
                System.exit(-1);
            }

            visit(cExp);
        }

        _currRealDepth--;
        return null;
    }


    @Override
    public String visitAndExp(GCLGrammarParser.AndExpContext ctx)
    {
        StringBuilder trad = new StringBuilder(AND_STR_CODE);
        trad.append(" (");

        ListIterator<org.antlr.v4.runtime.tree.ParseTree> iterator = ctx.children.listIterator(ctx.children.size());
        while (iterator.hasPrevious()) {
            org.antlr.v4.runtime.tree.ParseTree cur = iterator.previous();
            if (cur instanceof TerminalNode)
                continue;
            
            trad.append(visit(cur));
        }
        trad.append(")");
        return trad.toString();
    }


    @Override
    public String visitOrExp(GCLGrammarParser.OrExpContext ctx)
    {
        StringBuilder trad = new StringBuilder(OR_STR_CODE);
        trad.append(" (");

        ListIterator<org.antlr.v4.runtime.tree.ParseTree> iterator = ctx.children.listIterator(ctx.children.size());
        while (iterator.hasPrevious()) {
            org.antlr.v4.runtime.tree.ParseTree cur = iterator.previous();
            if (cur instanceof TerminalNode)
                continue;
            
            trad.append(visit(cur));
        }
        trad.append(")");
        return trad.toString();
    }


    @Override
    public String visitParExp(GCLGrammarParser.ParExpContext ctx)
    {
        visitChildren(ctx); // Ignoramos los tokens parentesis
        return null;
    }


    @Override
    public String visitIdExp(GCLGrammarParser.IdExpContext ctx)
    {
        StringBuilder pref = generatePrefix(_currRealDepth++);

        Token idTok = ctx.TkId().getSymbol();
        String id = idTok.getText();
        return null;
    }


    @Override
    public String visitNumExp(GCLGrammarParser.NumExpContext ctx)
    {
        return numberToCode(Integer.parseInt(ctx.getText()));
    }


    @Override
    public String visitBoolExp(GCLGrammarParser.BoolExpContext ctx)
    {
        StringBuilder trad = new StringBuilder(OR_STR_CODE).append("(")
            .append((Boolean.parseBoolean(ctx.getText())? TRUE_STR_CODE : FALSE_STR_CODE))
            .append(")");

        return trad.toString();
    }


    @Override
    public String visitReadAExp(GCLGrammarParser.ReadAExpContext ctx)
    {
        visitChildren(ctx);
        return null;
    }


    @Override
    public String visitAsignable(GCLGrammarParser.AsignableContext ctx)
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
    public String visitArrayInitLen(GCLGrammarParser.ArrayInitContext ctx, int len)
    {
        return null;
    }


    @Override
    public String visitAsignation(GCLGrammarParser.AsignationContext ctx)
    {
        return null;
    }


    @Override
    public String visitReadA(GCLGrammarParser.ReadAContext ctx)
    {
        return null;
    }


    @Override
    public String visitWriteA(GCLGrammarParser.WriteAContext ctx)
    {
        return null;
    }


    @Override
    public String visitWriteABody(GCLGrammarParser.WriteABodyContext ctx)
    {
        return null;
    }


    @Override
    public String visitInst(GCLGrammarParser.InstContext ctx)
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
    public String visitForOp(GCLGrammarParser.ForOpContext ctx)
    {
        addPrintVisitLeave("For", ctx);
        _forStack.pop();
        return null;
    }


    @Override
    public String visitIn(GCLGrammarParser.InContext ctx)
    {
        StringBuilder pref = generatePrefix(_currRealDepth++).append("In");
        System.out.println(pref.toString());

        String id = ctx.TkId().getText();

        _forStack.push(id);
        pref = generatePrefix(_currRealDepth).append("Ident: " + id + " | type: int");
        System.out.println(pref);

        visitChildren(ctx);
        _currRealDepth--;
        return null;
    }


    @Override
    public String visitTo(GCLGrammarParser.ToContext ctx)
    {
        return null;
    }


    @Override
    public String visitPrinteable(GCLGrammarParser.PrinteableContext ctx)
    {
        return null;
    }


    @Override
    public String visitPrint(GCLGrammarParser.PrintContext ctx)
    {
        return null;
    }


    @Override
    public String visitConcatenable(GCLGrammarParser.ConcatenableContext ctx)
    {
        if (ctx.TkString() != null)
        {
            StringBuilder pref = generatePrefix(_currRealDepth++).append("String: ").append(ctx.getText());
            pref = pref.append(" | type : string");
            System.out.println(pref.toString());
            _currRealDepth--;
            return null;
        }

        visitChildren(ctx);
        return null;
    }


    @Override
    public String visitConcatenation(GCLGrammarParser.ConcatenationContext ctx)
    {
        return null;
    }


    @Override
    public String visitIfOp(GCLGrammarParser.IfOpContext ctx)
    {
        return null;
    }


    @Override
    public String visitGuard(GCLGrammarParser.GuardContext ctx)
    {
        return null;
    }


    @Override
    public String visitThen(GCLGrammarParser.ThenContext ctx)
    {
        return null;
    }


    @Override
    public String visitDoOp(GCLGrammarParser.DoOpContext ctx)
    {
        return null;
    }
}
