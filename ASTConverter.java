import com.parsing.utils.SymbolsTable;
import com.parsing.GCLGrammarParser;

import java.util.regex.Pattern;
import java.util.regex.Matcher;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.ListIterator;
import java.util.Stack;
import java.util.Map.Entry;
import java.util.ArrayDeque;

import org.antlr.v4.runtime.ParserRuleContext;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.tree.TerminalNode;

/** 
 * Clase que se encarga de visitar cada uno de los nodos del arbol sintactico abstracto generado
 * y hacer chequeo de tipos
 */
public class ASTConverter extends com.parsing.GCLGrammarBaseVisitor<String> {
    
    private static final String BOOL_EQ_STR_CODE = "c_{1}";
    private static final String OR_STR_CODE = "c_{4}";
    private static final String AND_STR_CODE = "c_{5}";
    private static final String BOOL_NEQ_STR_CODE = "c_{6}";
    private static final String NOT_STR_CODE = "c_{7}";
    private static final String TRUE_STR_CODE = "c_{8}";
    private static final String FALSE_STR_CODE = "c_{9}";
    private static final String EXIST_OCON_STR_CODE = "c_{13}";
    private static final String INT_EQ_STR_CODE = "c_{15}";
    private static final String SET_COMP_STR_CODE = "c_{19}";
    private static final String CURLY_STR_CODE = "c_{20}";
    private static final String COMMA_STR_CODE = "c_{21}";
    private static final String SMALL_UNION_STR_CODE = "c_{24}";
    private static final String PAR_ORD_STR_CODE = "c_{31}";
    private static final String CROSS_STR_CODE = "c_{32}";
    private static final String TUPL_STR_CODE = "c_{33}";
    private static final String SEQ_STR_CODE = "c_{34}";
    private static final String INT_STR_CODE = "c_{36}";
    private static final String BOOL_STR_CODE = "c_{37}";
    private static final String POW_STR_CODE = "c_{38}";
    private static final String IDENT_STR_CODE = "c_{39}";
    private static final String NUM_STR_CODE = "c_{54}";
    private static final String SUM_STR_CODE = "c_{55}";
    private static final String SUB_STR_CODE = "c_{56}";
    private static final String MUL_STR_CODE = "c_{57}";
    private static final String WRITEA_STR_CODE = "c_{58}";
    private static final String ARR_RANG_STR_CODE = "c_{59}";
    private static final String MIN_STR_CODE = "c_{60}";
    private static final String INT_NEQ_STR_CODE = "c_{62}";
    private static final String LESS_STR_CODE = "c_{63}";
    private static final String LEQ_STR_CODE = "c_{64}";
    private static final String GREATER_STR_CODE = "c_{65}";
    private static final String GEQ_STR_CODE = "c_{66}";
    private static final String ABT_ABT_STR_CODE = "(c_{20} (c_{31} c_{40} c_{40}))";
    private static final String LAMBDA_STR_CODE = "\\lambda";

    // Tablas de simbolos
    private ArrayDeque<SymbolsTable> _symbolStack = new ArrayDeque<SymbolsTable>();
    private ArrayDeque<String> _forStack = new ArrayDeque<String>();

    // Usamos stack en vez de ArrayDeque para recorrer el iterator de bottom to top
    private int _idNum = 0;
    private Stack<SymbolsTable> _idNames = new Stack<SymbolsTable>();   //x1,x2....xi
    private Stack<SymbolsTable> _idMTypes = new Stack<SymbolsTable>();  //Z,B,Z^[1..3]...


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
        SymbolsTable cur = _symbolStack.peek();
        for(;cur != null; cur = cur.getPreviousTable()) {
            if (cur.isSymbolInTable(ident))
                return cur.getSymbolType(ident);
        }

        return (isSymbolInForStack(ident) ? "int" : null);
    }


    private String numberToCode(int number) {
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


    private String arrayReadCode(String arrName, String index) {
        return String.format("(%s %s)", arrName, index);
    }

    //private String gentuplas(GCLGrammarParser.ArrayInitContext ctx, String type) {
//
    //    Pattern p = Pattern.compile("-*[0-9]+");
    //    Matcher match = p.matcher(type);
//
    //    Integer lo = null;
    //    Integer hi = null;
    //    match.find();
    //    lo = Integer.parseInt(match.group());
    //    match.find();
    //    hi = Integer.parseInt(match.group());
//
    //    GCLGrammarParser.ArrayInitContext cur = 
    //    StringBuilder tup = new StringBuilder("");
    //    while (lo <= hi) {
    //        if (ctx.arrayInit != null) {
    //            tup.append(PAR_ORD_STR_CODE + " " + ctx.asignable() + " " + low.toString())
    //        }
    //        
    //    }
    //}

    private String typeToCode(String type) {
        switch (type) {
            case "int":
                return INT_STR_CODE;
            case "bool":
                return BOOL_STR_CODE;
            default:
                break;
        }

        StringBuilder trad = new StringBuilder("(").append(POW_STR_CODE)
            .append(" (").append(ARR_RANG_STR_CODE + " ");

        Pattern p = Pattern.compile("-*[0-9]+");
        Matcher match = p.matcher(type);

        Integer lo = null;
        Integer hi = null;
        match.find();
        lo = Integer.parseInt(match.group());
        match.find();
        hi = Integer.parseInt(match.group());

        trad.append(String.format("%s %s", numberToCode(hi), numberToCode(lo)))
            .append(") ").append(INT_STR_CODE + ")");

        return trad.toString();
    }


    private void declareVar(String id, String type) {
        SymbolsTable nId = _idNames.peek();
        SymbolsTable nType = _idMTypes.peek();

        String typeAplic = typeToCode(type);
        nId.addSymbol(id, String.format("x_{%s}", _idNum++));
        nType.addSymbol(id, typeAplic);
    }


    private String getSymbolMID(String symb) {
        for (SymbolsTable cur = _idNames.peek(); cur != null; cur = cur.getPreviousTable()) {
            if (cur.isSymbolInTable(symb))
                return cur.getSymbolType(symb);
        }

        return null;
    }


    private String commaSeparateCode(String a1, String a2) {
        return String.format("%s %s %s", COMMA_STR_CODE, a2, a1);    
    }


    private String crossProductCode(String a1, String a2) {
        return String.format("%s %s %s", CROSS_STR_CODE, a2, a1);
    }


    private String generarParEspacio(String symb, String exp) {
        StringBuilder names = new StringBuilder(TUPL_STR_CODE + " (");
        StringBuilder exps = new StringBuilder(TUPL_STR_CODE + " (");

        SymbolsTable cur = null;
        int totCount = 0;

        for (cur = _idNames.peek(); cur != null; cur = cur.getPreviousTable())
            totCount += cur.size();

        int parCount = totCount;
        for (cur = _idNames.peek(); cur != null; cur = cur.getPreviousTable()) {
            String[] ids = cur.getValues();
            for (int i = cur.size() - 1; i >= 0; --i, --totCount) {
                String id = ids[i];
                if (totCount > 1) {
                    names.append(commaSeparateCode("(", id));

                    exps.append(commaSeparateCode("(", (id.equals(symb) ? exp : id)));
                    continue;
                }

                names.append(" " + ids[i]);
                exps.append(" " + (id.equals(symb) ? exp : id));
            }
        }

        // checar nro parentesis
        for (int p = 0; p < parCount; ++p) {
            names.append(")");
            exps.append(")");
        }

        return String.format("(%s (%s) (%s))", PAR_ORD_STR_CODE, exps.toString(), names.toString());
    }

    
    private String generarTuplaEspacio() {
        StringBuilder cruz = new StringBuilder("");
        SymbolsTable cur = null;
        int totCount = 0;
        
        for (cur = _idMTypes.peek(); cur != null; cur = cur.getPreviousTable())
            totCount += cur.size();
        
        int parCount = totCount;
        for (cur = _idMTypes.peek(); cur != null; cur = cur.getPreviousTable()) {
            String[] types = cur.getValues();
            for (int i = cur.size() - 1; i >= 0; --i, --totCount) {

                if (totCount > 1) {
                    cruz.append(crossProductCode("(", types[i]));
                    continue;
                }
                
                cruz.append(" " + types[i]);
            }
        }

        // checar nro parentesis
        for (int p = 0; p < parCount - 1; ++p) {
            cruz.append(")");
        }

        return String.format("(%s (%s))", TUPL_STR_CODE, cruz.toString());
    }


    private String generarParTipoEspacio() {
        String tupla = generarTuplaEspacio();
        return String.format("(%s)", crossProductCode(tupla, tupla));
    }


    private String generarEspacioAsignacion(String symb, String exp) {
        StringBuilder total = new StringBuilder(String.format("%s (%s x_{120} . ", 
            SET_COMP_STR_CODE, LAMBDA_STR_CODE));

        StringBuilder exist = new StringBuilder("");
        StringBuilder equ = new StringBuilder(String.format("(%s %s %s)", INT_EQ_STR_CODE, generarParEspacio(symb, exp), "x_{120}"));
        StringBuilder types = new StringBuilder(String.format("(%s x_{120} . %s)", LAMBDA_STR_CODE, generarParTipoEspacio()));

        for (int t = 0; t < _idNames.size(); ++t) {
            SymbolsTable cur = _idNames.get(t);
            String[] ids = cur.getValues();
            for (int i = 0; i < ids.length; ++i) {
                String id = ids[i];
                exist.append(String.format("%s (%s %s . ", EXIST_OCON_STR_CODE, LAMBDA_STR_CODE, id)); // existenciales
            }

            exist.append(equ);
            for (int i = 0; i <= ids.length; ++i) {
                exist.append(")");
            }
        }

        total.append(exist.toString());
        total.append(" " + types.toString());        
        return String.format("(%s %s (%s))", SMALL_UNION_STR_CODE, ABT_ABT_STR_CODE, total.toString());
    }
    

    @Override
    public String visitBlock(GCLGrammarParser.BlockContext ctx) {
        _symbolStack.add(ctx.symbols);
        visitChildren(ctx);
        _symbolStack.pop();
        return null;
    }


    @Override
    public String visitDeclarationBlock(GCLGrammarParser.DeclarationBlockContext ctx) {
        _idNames.add(new SymbolsTable(_idNames.isEmpty() ? null : _idNames.peek()));
        _idMTypes.add(new SymbolsTable(_idMTypes.isEmpty() ? null : _idMTypes.peek()));
        return visitChildren(ctx);
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
        declareVar(id, _symbolStack.peek().getSymbolType(id));
        visitChildren(ctx);
        return "";
    }


    @Override
    public String visitDecl(GCLGrammarParser.DeclContext ctx)
    {
        visitChildren(ctx);
        return null;
    }


    @Override
    public String visitNumericLit(GCLGrammarParser.NumericLitContext ctx)
    {
        return visitChildren(ctx);
    }


    @Override
    public String visitSeq(GCLGrammarParser.SeqContext ctx)
    {
        StringBuilder trad = new StringBuilder(SEQ_STR_CODE + " ");

        ListIterator<org.antlr.v4.runtime.tree.ParseTree> iterator = ctx.children.listIterator(ctx.children.size());
        while (iterator.hasPrevious()) {
            org.antlr.v4.runtime.tree.ParseTree cur = iterator.previous();
            if (cur instanceof TerminalNode)
                continue;
            
            trad.append(visit(cur));
        }
        return String.format("(%s)", trad.toString());
    }

    @Override
    public String visitUnMinExp(GCLGrammarParser.UnMinExpContext ctx)
    {
        StringBuilder trad = new StringBuilder(MIN_STR_CODE + " ");

        ListIterator<org.antlr.v4.runtime.tree.ParseTree> iterator = ctx.children.listIterator(ctx.children.size());
        while (iterator.hasPrevious()) {
            org.antlr.v4.runtime.tree.ParseTree cur = iterator.previous();
            if (cur instanceof TerminalNode)
                continue;
            
            trad.append(visit(cur));
        }
        return String.format("(%s)", trad.toString());      
    }


    @Override
    public String visitNotExp(GCLGrammarParser.NotExpContext ctx)
    {
        StringBuilder trad = new StringBuilder(NOT_STR_CODE + " ");

        ListIterator<org.antlr.v4.runtime.tree.ParseTree> iterator = ctx.children.listIterator(ctx.children.size());
        while (iterator.hasPrevious()) {
            org.antlr.v4.runtime.tree.ParseTree cur = iterator.previous();
            if (cur instanceof TerminalNode)
                continue;
            
            trad.append(visit(cur));
        }

        return String.format("(%s)", trad.toString());
    }


    @Override
    public String visitMinPlusExp(GCLGrammarParser.MinPlusExpContext ctx)
    {
        StringBuilder trad = new StringBuilder("");
        switch (ctx.op.getType()) {
            case GCLGrammarParser.TkPlus:
                trad.append(SUM_STR_CODE + " ");
                break;
            case GCLGrammarParser.TkMinus:
                trad.append(SUB_STR_CODE + " ");
                break;
        }
        ListIterator<org.antlr.v4.runtime.tree.ParseTree> iterator = ctx.children.listIterator(ctx.children.size());
        while (iterator.hasPrevious()) {
            org.antlr.v4.runtime.tree.ParseTree cur = iterator.previous();
            if (cur instanceof TerminalNode)
                continue;
            
            trad.append(visit(cur));
            if (iterator.hasPrevious()) {
                trad.append(" ");
                continue;
            }
        }
        return String.format("(%s)", trad.toString());
    }


    @Override
    public String visitMultExp(GCLGrammarParser.MultExpContext ctx)
    {
        StringBuilder trad = new StringBuilder(MUL_STR_CODE + " ");
        ListIterator<org.antlr.v4.runtime.tree.ParseTree> iterator = ctx.children.listIterator(ctx.children.size());
        while (iterator.hasPrevious()) {
            org.antlr.v4.runtime.tree.ParseTree cur = iterator.previous();
            if (cur instanceof TerminalNode)
                continue;
            
            trad.append(visit(cur));
            if (iterator.hasPrevious()) {
                trad.append(" ");
                continue;
            }
        }
        return String.format("(%s)", trad.toString());
    }


    @Override
    public String visitOrdExp(GCLGrammarParser.OrdExpContext ctx)
    {
        StringBuilder trad = new StringBuilder("");
        switch (ctx.op.getType()) {
            case GCLGrammarParser.TkLeq:
                trad.append(LEQ_STR_CODE).append(" ");
                break;
            case GCLGrammarParser.TkLess:
                trad.append(LESS_STR_CODE).append(" ");
                break;
            case GCLGrammarParser.TkGeq:
                trad.append(GEQ_STR_CODE).append(" ");
                break;
            case GCLGrammarParser.TkGreater:
                trad.append(GREATER_STR_CODE).append(" ");
                break;
        }
        ListIterator<org.antlr.v4.runtime.tree.ParseTree> iterator = ctx.children.listIterator(ctx.children.size());
        while (iterator.hasPrevious()) {
            org.antlr.v4.runtime.tree.ParseTree cur = iterator.previous();
            if (cur instanceof TerminalNode)
                continue;
            
            trad.append(visit(cur));
            if (iterator.hasPrevious()) {
                trad.append(" ");
                continue;
            }
        }
        return String.format("(%s)", trad.toString());
    }


    @Override
    public String visitEqExp(GCLGrammarParser.EqExpContext ctx)
    {
        StringBuilder trad = new StringBuilder("");
        switch (ctx.op.getType()) {
            case GCLGrammarParser.TkEqual:
                switch (ctx.a.expType) {
                    case "bool": 
                        trad.append(BOOL_EQ_STR_CODE).append(" ");
                        break;
                    case "int":
                        trad.append(INT_EQ_STR_CODE).append(" ");
                        break;
                }
                break;

            case GCLGrammarParser.TkNEqual:
                switch (ctx.a.expType) {
                    case "bool": 
                        trad.append(BOOL_NEQ_STR_CODE).append(" ");
                        break;
                    case "int":
                        trad.append(INT_NEQ_STR_CODE).append(" ");
                        break;
                }
                break;
        }

        ListIterator<org.antlr.v4.runtime.tree.ParseTree> iterator = ctx.children.listIterator(ctx.children.size());
        while (iterator.hasPrevious()) {
            org.antlr.v4.runtime.tree.ParseTree cur = iterator.previous();
            if (cur instanceof TerminalNode)
                continue;
                    
            trad.append(visit(cur));
            if (iterator.hasPrevious()) {
                trad.append(" ");
                continue;
            }
        }

        return String.format("(%s)", trad.toString());
    }


    @Override
    public String visitAndExp(GCLGrammarParser.AndExpContext ctx)
    {
        StringBuilder trad = new StringBuilder(AND_STR_CODE + " ");
        ListIterator<org.antlr.v4.runtime.tree.ParseTree> iterator = ctx.children.listIterator(ctx.children.size());
        while (iterator.hasPrevious()) {
            org.antlr.v4.runtime.tree.ParseTree cur = iterator.previous();
            if (cur instanceof TerminalNode)
                continue;
            
            trad.append(visit(cur));
            if (iterator.hasPrevious()) {
                trad.append(" ");
                continue;
            }
        }

        return String.format("(%s)", trad.toString());
    }


    @Override
    public String visitOrExp(GCLGrammarParser.OrExpContext ctx)
    {
        StringBuilder trad = new StringBuilder(OR_STR_CODE + " ");
        ListIterator<org.antlr.v4.runtime.tree.ParseTree> iterator = ctx.children.listIterator(ctx.children.size());
        while (iterator.hasPrevious()) {
            org.antlr.v4.runtime.tree.ParseTree cur = iterator.previous();
            if (cur instanceof TerminalNode)
                continue;
            
            trad.append(visit(cur));
            if (iterator.hasPrevious()) {
                trad.append(" ");
                continue;
            }
        }
        return String.format("(%s)", trad.toString());
    }


    @Override
    public String visitParExp(GCLGrammarParser.ParExpContext ctx)
    {
         // Ignoramos los tokens parentesis
        return visit(ctx.exp());
    }


    @Override
    public String visitIdExp(GCLGrammarParser.IdExpContext ctx)
    {
        return getSymbolMID(ctx.TkId().getText());
    }


    @Override
    public String visitNumExp(GCLGrammarParser.NumExpContext ctx)
    {
        return numberToCode(Integer.parseInt(ctx.getText()));
    }


    @Override
    public String visitBoolExp(GCLGrammarParser.BoolExpContext ctx)
    {
        StringBuilder trad = new StringBuilder("(")
            .append((Boolean.parseBoolean(ctx.getText())? TRUE_STR_CODE : FALSE_STR_CODE))
            .append(")");

        return trad.toString();
    }


    @Override
    public String visitReadAExp(GCLGrammarParser.ReadAExpContext ctx)
    {
        return visit(ctx.readA());
    }


    @Override
    public String visitAsignable(GCLGrammarParser.AsignableContext ctx)
    {
        return visitChildren(ctx);
    }


    /**
     * Visita un nodo de inicializacion de arreglo
     * @param ctx Contexto de regla ArrayInit
     * @return nada
     */
    public String visitArrayInit(GCLGrammarParser.ArrayInitContext ctx, int indice)
    {
        System.out.println(indice);
        if (ctx.arrayInit() != null)
            visitArrayInit(ctx.arrayInit(), ++indice);

        return null;
    }


    @Override
    public String visitAsignation(GCLGrammarParser.AsignationContext ctx)
    {
        String matId = getSymbolMID(ctx.TkId().getText());
        if (ctx.asignable() != null)
            return generarEspacioAsignacion(matId, visit(ctx.asignable()));

        // Pon regex aca y sacas el largo.
        return generarEspacioAsignacion(matId, visitArrayInit(ctx.arrayInit(), 0));
    }


    @Override
    public String visitReadA(GCLGrammarParser.ReadAContext ctx)
    {
        TerminalNode id;
        if ((id = ctx.TkId()) != null)
            return arrayReadCode(getSymbolMID(id.getText()), visit(ctx.exp()));
        
        System.out.println(arrayReadCode(visit(ctx.writeA()), visit(ctx.exp())));
        return arrayReadCode(visit(ctx.writeA()), visit(ctx.exp()));
    }


    @Override
    public String visitWriteA(GCLGrammarParser.WriteAContext ctx)
    {
        if (ctx.TkId() != null) {
            String id = getSymbolMID(ctx.TkId().getText());
            return String.format("(%s %s %s)", WRITEA_STR_CODE, visit(ctx.writeABody()), id);
        }

        return String.format("(%s %s %s)", WRITEA_STR_CODE, visit(ctx.writeABody()), visit(ctx.writeA()));
    }


    @Override
    public String visitWriteABody(GCLGrammarParser.WriteABodyContext ctx)
    {
        StringBuilder res = new StringBuilder("");
        ListIterator<org.antlr.v4.runtime.tree.ParseTree> iterator = ctx.children.listIterator(ctx.children.size());
        while (iterator.hasPrevious()) {
            org.antlr.v4.runtime.tree.ParseTree cur = iterator.previous();
            if (cur instanceof TerminalNode)
                continue;
            
            res.append(visit(cur));
            if (iterator.hasPrevious()) {
                res.append(" ");
                continue;
            }
        }

        return res.toString();
    }


    @Override
    public String visitInst(GCLGrammarParser.InstContext ctx)
    {
        // Instruccion skip
        if (ctx.TkSkip() != null)
        {
            StringBuilder trad = new StringBuilder(IDENT_STR_CODE + " ");
            trad.append(generarTuplaEspacio());
            return String.format("(%s)", trad.toString());
        }

        return visit(ctx.getChild(0));
    }


    @Override
    public String visitForOp(GCLGrammarParser.ForOpContext ctx)
    {
        //addPrintVisitLeave("For", ctx);
        _forStack.pop();
        return visitChildren(ctx);
    }


    @Override
    public String visitIn(GCLGrammarParser.InContext ctx)
    {
        //StringBuilder pref = generatePrefix(_currRealDepth++).append("In");
        //System.out.println(pref.toString());
//
//
        String id = ctx.TkId().getText();
        _forStack.push(id);
        //pref = generatePrefix(_currRealDepth).append("Ident: " + id + " | type: int");
        //System.out.println(pref);
//
        //visitChildren(ctx);
        //_currRealDepth--;
        return visitChildren(ctx);
    }


    @Override
    public String visitTo(GCLGrammarParser.ToContext ctx)
    {
        return visitChildren(ctx);
    }


    @Override
    public String visitPrinteable(GCLGrammarParser.PrinteableContext ctx)
    {
        return visitChildren(ctx);
    }


    @Override
    public String visitPrint(GCLGrammarParser.PrintContext ctx)
    {
        return visitChildren(ctx);
    }


    @Override
    public String visitConcatenable(GCLGrammarParser.ConcatenableContext ctx)
    {
        //if (ctx.TkString() != null)
        //{
        //    StringBuilder pref = generatePrefix(_currRealDepth++).append("String: ").append(ctx.getText());
        //    pref = pref.append(" | type : string");
        //    System.out.println(pref.toString());
        //    _currRealDepth--;
        //    return null;
        //}
//
        //visitChildren(ctx);
        return visitChildren(ctx);
    }


    @Override
    public String visitConcatenation(GCLGrammarParser.ConcatenationContext ctx)
    {
        return visitChildren(ctx);
    }


    @Override
    public String visitIfOp(GCLGrammarParser.IfOpContext ctx)
    {
        return visitChildren(ctx);
    }


    @Override
    public String visitGuard(GCLGrammarParser.GuardContext ctx)
    {
        return visitChildren(ctx);
    }


    @Override
    public String visitThen(GCLGrammarParser.ThenContext ctx)
    {
        return visitChildren(ctx);
    }


    @Override
    public String visitDoOp(GCLGrammarParser.DoOpContext ctx)
    {
        return visitChildren(ctx);
    }
}
