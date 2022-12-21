import com.parsing.utils.SymbolsTable;
import com.parsing.GCLGrammarParser;
import com.parsing.GCLGrammarLexer;

import java.util.regex.Pattern;
import java.util.regex.Matcher;
import java.util.Iterator;
import java.util.ListIterator;
import java.util.Stack;
import java.util.ArrayDeque;

import org.antlr.v4.runtime.CommonTokenFactory;
import org.antlr.v4.runtime.RuleContext;
import org.antlr.v4.runtime.tree.TerminalNode;
import org.antlr.v4.runtime.tree.TerminalNodeImpl;

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
    private static final String FOR_ALL_STR_CODE = "c_{12}";
    private static final String EXIST_OCON_STR_CODE = "c_{13}";
    private static final String EXIST_STR_CODE = "c_{14}";
    private static final String INT_EQ_STR_CODE = "c_{15}";
    private static final String IN_STR_CODE = "c_{16}";
    private static final String NIN_STR_CODE = "c_{17}";
    private static final String SET_COMP_STR_CODE = "c_{19}";
    private static final String CURLY_STR_CODE = "c_{20}";
    private static final String COMMA_STR_CODE = "c_{21}";
    private static final String BIG_UNION_STR_CODE = "c_{22}";
    private static final String SMALL_UNION_STR_CODE = "c_{24}";
    private static final String PAR_ORD_STR_CODE = "c_{31}";
    private static final String CROSS_STR_CODE = "c_{32}";
    private static final String TUPL_STR_CODE = "c_{33}";
    private static final String SEQ_STR_CODE = "c_{34}";
    private static final String UNIV_STR_CODE = "c_{35}";
    private static final String INT_STR_CODE = "c_{36}";
    private static final String BOOL_STR_CODE = "c_{37}";
    private static final String POW_STR_CODE = "c_{38}";
    private static final String IDENT_STR_CODE = "c_{39}";
    private static final String ABORT_STR_CODE = "c_{40}";
    private static final String COMP_POW_STR_CODE = "c_{41}";
    private static final String NUM_STR_CODE = "c_{54}";
    private static final String SUM_STR_CODE = "c_{55}";
    private static final String SUB_STR_CODE = "c_{56}";
    private static final String MUL_STR_CODE = "c_{57}";
    private static final String WRITEA_STR_CODE = "c_{58}";
    private static final String ARR_RANG_STR_CODE = "c_{59}";
    private static final String MIN_STR_CODE = "c_{60}";
    private static final String DOM_STR_CODE = "c_{61}";
    private static final String INT_NEQ_STR_CODE = "c_{62}";
    private static final String LESS_STR_CODE = "c_{63}";
    private static final String LEQ_STR_CODE = "c_{64}";
    private static final String GREATER_STR_CODE = "c_{65}";
    private static final String GEQ_STR_CODE = "c_{66}";
    private static final String PI_STR_CODE = "c_{67}";
    private static final String ABT_ABT_STR_CODE = "(c_{20} (c_{31} c_{40} c_{40}))";
    private static final String LAMBDA_STR_CODE = "\\lambda";

    // Tablas de simbolos
    private Stack<SymbolsTable> _symbolStack = new Stack<SymbolsTable>();
    private Stack<String> _forStack = new Stack<String>();
    private boolean _firstBlock = true;

    // Usamos stack en vez de ArrayDeque para recorrer el iterator de bottom to top
    private int _idNum = 0;
    private Stack<SymbolsTable> _idNames = new Stack<SymbolsTable>();   //x1,x2....xi
    private Stack<SymbolsTable> _idMTypes = new Stack<SymbolsTable>();  //Z,B,Z^[1..3]...

    private ASTCopy _copier = new ASTCopy();

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


    private String numberToCode(int number) {
        Stack<String> tmp = new Stack<String>();
        StringBuilder res = new StringBuilder();
        boolean neg = number < 0;

        if (number == 0)
            return "(c_{42})";

        if (neg)
            number *= - 1;
            
        while (number > 0) {
            int dig = number % 10;
            number = number / 10;
            tmp.add(String.format("c_{%s}", 42 + dig));
        }

        if (tmp.size() == 1)
        {
            if (neg)
                return String.format("(%s %s)", MIN_STR_CODE, tmp.pop());

            return String.format("(%s)", tmp.pop());
        }

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
        
        if (neg)
            return String.format("(%s %s)", MIN_STR_CODE, res.toString());

        return res.toString();
    }


    private String arrayReadCode(String arrName, String index) {
        return String.format("(%s %s)", arrName, index);
    }

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
    
    private Integer calculateProjections() {
        return 0;
    }

    private TerminalNode createTerminal(int tok, String string) {
        return  new TerminalNodeImpl(CommonTokenFactory.DEFAULT.create(tok, string));
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


    private String generarEspacioExt() {
        return String.format("(%s (%s %s) %s)", 
            SMALL_UNION_STR_CODE, CURLY_STR_CODE, ABORT_STR_CODE, generarTuplaEspacio());
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
        int p = 0;
        for (int t = 0; t < _idNames.size(); ++t) {
            SymbolsTable cur = _idNames.get(t); // ver orden de esto :) problema por aca en existenciales!
            String[] ids = cur.getValues();
            p += ids.length;
            for (int i = 0; i < ids.length; ++i) {
                String id = ids[i];
                exist.append(String.format("%s (%s %s . ", EXIST_OCON_STR_CODE, LAMBDA_STR_CODE, id)); // existenciales
            }
        }

        exist.append(equ);
        for (int i = 0; i <= p; ++i) {
            exist.append(")");
        }

        total.append(exist.toString());
        total.append(" " + types.toString());        
        return String.format("(%s %s (%s))", SMALL_UNION_STR_CODE, ABT_ABT_STR_CODE, total.toString());
    }
    

    @Override
    public String visitBlock(GCLGrammarParser.BlockContext ctx) {
        _symbolStack.add(ctx.symbols);
        if (ctx.declarationBlock() != null)
            visit(ctx.declarationBlock());
        
        boolean prevFirst = _firstBlock;
        if (_firstBlock)
            _firstBlock = false;

        String semInsts = visit(ctx.inst() != null ? ctx.inst() : ctx.seq());
        String semBlock = semInsts;
        StringBuilder projStr = new StringBuilder("");


        if (!prevFirst && ctx.symbols.size() > 0){
            projStr.append(String.format("(%s %s ", SEQ_STR_CODE, semInsts));
            for (int i = 0; i < ctx.symbols.size(); ++i)
            {
                if (i == ctx.symbols.size() - 1) {
                    projStr.append(String.format("%s", PI_STR_CODE));
                    continue;
                }
                projStr.append(String.format("(%s %s ", SEQ_STR_CODE, PI_STR_CODE));
            }
            for (int i = 0; i < ctx.symbols.size(); ++i) // agregamos ctx.symbols.size() - 1 + 1 extra del inicio
                projStr.append(")");
            
            semBlock = projStr.toString();
        }

        _symbolStack.pop();
        _idMTypes.pop();
        _idNames.pop();
        _idNum -= ctx.symbols.size();
        return semBlock;
    }


    @Override
    public String visitDeclarationBlock(GCLGrammarParser.DeclarationBlockContext ctx) {
        _idNames.add(new SymbolsTable(_idNames.isEmpty() ? null : _idNames.peek()));
        _idMTypes.add(new SymbolsTable(_idMTypes.isEmpty() ? null : _idMTypes.peek()));

        visitChildren(ctx);
        return "";
    }


    @Override
    public String visitSeqDecl(GCLGrammarParser.SeqDeclContext ctx)
    {
        visitChildren(ctx);
        return "";
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
        return "";
    }


    @Override
    public String visitNumericLit(GCLGrammarParser.NumericLitContext ctx)
    {
        return "";
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
        return String.format("(%s %s)", TUPL_STR_CODE, visit(ctx.exp()));
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
        return String.format("(%s)", 
            (Boolean.parseBoolean(ctx.getText())? TRUE_STR_CODE : FALSE_STR_CODE));
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
        StringBuilder trad = new StringBuilder(COMMA_STR_CODE + " ");
        if (ctx.arrayInit() != null) {
            for (GCLGrammarParser.AsignableContext cAsig : ctx.asignable()) {
                trad.append("( " + PAR_ORD_STR_CODE + " " + visitAsignable(cAsig) + " " + numberToCode(indice) + ")" + " ");
            }
            trad.append(visitArrayInit(ctx.arrayInit(), --indice));

            if (ctx.parent instanceof GCLGrammarParser.ArrayInitContext)
                return String.format("(%s)", trad.toString());

            return String.format("(%s (%s))", CURLY_STR_CODE, trad.toString());
        }

        ListIterator<org.antlr.v4.runtime.tree.ParseTree> iterator = ctx.children.listIterator(ctx.children.size());
        while (iterator.hasPrevious()) {
            org.antlr.v4.runtime.tree.ParseTree cur = iterator.previous();
            if (cur instanceof TerminalNode)
                continue;
                
            trad.append("(" + PAR_ORD_STR_CODE + " " + visit(cur) + " " + numberToCode(indice--) + ")");
            if (iterator.hasPrevious()) {
                trad.append(" ");
                continue;
            }
        }
        
        return String.format("(%s)", trad.toString());
    }


    @Override
    public String visitAsignation(GCLGrammarParser.AsignationContext ctx)
    {
        String matId = getSymbolMID(ctx.TkId().getText());
        if (ctx.asignable() != null)
            return generarEspacioAsignacion(matId, visit(ctx.asignable()));

        Pattern p = Pattern.compile("-*[0-9]+");
        Matcher match = p.matcher(lookSymbolType(ctx.TkId().getText()));
        match.find(); match.find();
         
        return generarEspacioAsignacion(matId, visitArrayInit(ctx.arrayInit(), Integer.parseInt(match.group())));
    }


    @Override
    public String visitReadA(GCLGrammarParser.ReadAContext ctx)
    {
        TerminalNode id;
        if ((id = ctx.TkId()) != null)
            return arrayReadCode(getSymbolMID(id.getText()), visit(ctx.exp()));
        
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
            return String.format("(%s %s)", IDENT_STR_CODE, generarEspacioExt());

        return visit(ctx.getChild(0));
    }


    private GCLGrammarParser.DeclarationBlockContext generarDeclBlockFor(GCLGrammarParser.InContext root) {
        GCLGrammarParser.DeclarationBlockContext dBlock = new GCLGrammarParser.DeclarationBlockContext(null, 0);
        GCLGrammarParser.DeclContext decl = new GCLGrammarParser.DeclContext(null, 0);
        GCLGrammarParser.LdecContext ldecl = new GCLGrammarParser.LdecContext(null, 0);

        TerminalNode idNode = (TerminalNode)_copier.visit(root.TkId());
        TerminalNode intNode = createTerminal(GCLGrammarLexer.TkInt, "int");
        TerminalNode twoPNde = createTerminal(GCLGrammarLexer.TkTwoPoints, ":");
        GCLGrammarParser.TypeContext type = new GCLGrammarParser.TypeContext(null, 0);

        dBlock.addChild(decl);
        decl.parent = dBlock;

        decl.addChild(ldecl);
        ldecl.parent = decl;

        type.addChild(intNode);
        intNode.setParent(type);
        
        ldecl.addChild(idNode);
        idNode.setParent(ldecl);
        ldecl.addChild(twoPNde);
        twoPNde.setParent(ldecl);
        ldecl.addChild(type);
        type.parent = ldecl;

        return dBlock;
    }


    private GCLGrammarParser.ExpContext[] obtenerBoundsFor(GCLGrammarParser.ToContext root) {
        return new GCLGrammarParser.ExpContext[] {
            (GCLGrammarParser.ExpContext)_copier.visit(root.exp(0)), // lower bound
            (GCLGrammarParser.ExpContext)_copier.visit(root.exp(1)), // high bound
        };
    }


    private GCLGrammarParser.OrdExpContext generarCondFor(TerminalNode id, GCLGrammarParser.ExpContext highB) {
        TerminalNode idCpy = (TerminalNode)_copier.visit(id);
        GCLGrammarParser.ExpContext expCpy = (GCLGrammarParser.ExpContext)_copier.visit(highB);
        GCLGrammarParser.OrdExpContext cond = new GCLGrammarParser.OrdExpContext(new GCLGrammarParser.ExpContext());
        GCLGrammarParser.IdExpContext idExp = new GCLGrammarParser.IdExpContext(new GCLGrammarParser.ExpContext()); 
        idExp.addChild(idCpy);
        idCpy.setParent(idExp);

        cond.addChild(idExp);
        idExp.parent = cond;

        cond.addChild(createTerminal(GCLGrammarLexer.TkLeq, "<="));
        cond.op = ((TerminalNode)cond.children.get(1)).getSymbol();

        cond.addChild(expCpy);
        expCpy.setParent(cond);
        
        return cond;
    }


    private GCLGrammarParser.AsignationContext[] generarAsignsFor(TerminalNode id, GCLGrammarParser.ExpContext lowB) {
        GCLGrammarParser.AsignationContext lowAsign = new GCLGrammarParser.AsignationContext(null, 0);
        GCLGrammarParser.AsignableContext lowAsignable = new GCLGrammarParser.AsignableContext(null, 0);
        GCLGrammarParser.ExpContext lowCpy = (GCLGrammarParser.ExpContext)_copier.visit(lowB);

        lowAsignable.addChild(lowCpy);
        lowCpy.parent = lowAsignable;

        lowAsign.addChild((TerminalNode)_copier.visit(id));
        lowAsign.addChild(createTerminal(GCLGrammarLexer.TkAsig, ":="));
        lowAsign.addChild(lowAsignable);
        lowAsignable.parent = lowAsign;

        GCLGrammarParser.AsignationContext countAsign = new GCLGrammarParser.AsignationContext(null, 0);
        GCLGrammarParser.AsignableContext countAsignable = new GCLGrammarParser.AsignableContext(null, 0);

        GCLGrammarParser.MinPlusExpContext sumExp = new GCLGrammarParser.MinPlusExpContext(new GCLGrammarParser.ExpContext());
        GCLGrammarParser.IdExpContext idExp = new GCLGrammarParser.IdExpContext(new GCLGrammarParser.ExpContext());
        GCLGrammarParser.NumExpContext oneExp = new GCLGrammarParser.NumExpContext(new GCLGrammarParser.ExpContext());
        
        idExp.addChild((TerminalNode)_copier.visit(id));
        oneExp.addChild(createTerminal(GCLGrammarParser.TkNum, "1"));

        sumExp.addChild(idExp);
        sumExp.addChild(createTerminal(GCLGrammarLexer.TkPlus, "+"));
        sumExp.addChild(oneExp);
        sumExp.op = ((TerminalNode)sumExp.children.get(1)).getSymbol();

        idExp.parent = sumExp;
        oneExp.parent = oneExp;

        countAsignable.addChild(sumExp);
        countAsign.addChild((TerminalNode)_copier.visit(id));
        countAsign.addChild(createTerminal(GCLGrammarLexer.TkAsig, ":="));
        countAsign.addChild(countAsignable);
        
        return new GCLGrammarParser.AsignationContext[] {
            lowAsign,
            countAsign
        };
    }


    private GCLGrammarParser.DoOpContext generarDoFor(
        GCLGrammarParser.OrdExpContext cond, 
        GCLGrammarParser.AsignationContext intAsig,
        GCLGrammarParser.InstContext inst,
        GCLGrammarParser.SeqContext seq) {

        if ((seq == null && inst == null) || (inst != null && seq != null))
            return null; // crasheate realmente.
        
        GCLGrammarParser.DoOpContext doOp = new GCLGrammarParser.DoOpContext(null, 0);
        GCLGrammarParser.ThenContext then = new GCLGrammarParser.ThenContext(null, 0);
        GCLGrammarParser.SeqContext doSeq = new GCLGrammarParser.SeqContext(null, 0);
        doSeq.addChild((inst != null ? inst : seq));
        doSeq.addChild(createTerminal(GCLGrammarLexer.TkSemicolon, ";"));
        doSeq.addChild(intAsig);

        then.addChild(cond);
        then.addChild(createTerminal(GCLGrammarLexer.TkArrow, "-->"));
        then.addChild(doSeq);

        doOp.addChild(then);
        return doOp;
    }


    @Override
    public String visitForOp(GCLGrammarParser.ForOpContext ctx)
    {
        GCLGrammarParser.BlockContext block = new GCLGrammarParser.BlockContext(null, 0);
        SymbolsTable forTable = new SymbolsTable(_symbolStack.peek());
        TerminalNode forId = ctx.in().TkId();

        forTable.addSymbol(forId.getText(), "int");
        block.symbols = forTable;

        GCLGrammarParser.DeclarationBlockContext declBlock = generarDeclBlockFor(ctx.in()); // bien en teoria
        GCLGrammarParser.ExpContext[] bounds = obtenerBoundsFor(ctx.in().to()); // bien en teoria
        GCLGrammarParser.OrdExpContext doCond = generarCondFor(forId, bounds[1]); // bien pero cuidado con null.
        GCLGrammarParser.AsignationContext[] asignations = generarAsignsFor(forId, bounds[0]); // bien en teorio
        GCLGrammarParser.SeqContext extSeq = new GCLGrammarParser.SeqContext(null, 0);

        GCLGrammarParser.InstContext intDoInst = (ctx.inst() != null ? (GCLGrammarParser.InstContext)_copier.visit(ctx.inst()) : null);
        GCLGrammarParser.SeqContext intDoSeq = (ctx.seq() != null ? (GCLGrammarParser.SeqContext)_copier.visit(ctx.seq()) : null);
        GCLGrammarParser.DoOpContext doOp = generarDoFor(doCond, asignations[1], intDoInst, intDoSeq);

        extSeq.addChild(asignations[0]);
        extSeq.addChild(createTerminal(GCLGrammarParser.TkSemicolon, ";"));
        extSeq.addChild(doOp);

        block.addChild(createTerminal(GCLGrammarParser.TkOBlock, "|["));
        block.addChild(declBlock);
        block.addChild(extSeq);
        block.addChild(createTerminal(GCLGrammarParser.TkCBlock, "]|"));

        return visit(block);
    }


    @Override
    public String visitIn(GCLGrammarParser.InContext ctx)
    {
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
        return "";
    }


    @Override
    public String visitPrint(GCLGrammarParser.PrintContext ctx)
    {
        return "";
    }


    @Override
    public String visitConcatenable(GCLGrammarParser.ConcatenableContext ctx)
    {
        return "";
    }


    @Override
    public String visitConcatenation(GCLGrammarParser.ConcatenationContext ctx)
    {
        return "";
    }


    @Override
    public String visitIfOp(GCLGrammarParser.IfOpContext ctx)
    {
        String[] ops;
        if (ctx.guard() != null)
            ops = auxGenGuardIf(ctx.guard());
        else
            ops = generarThenIf(ctx.then());
        
        ops[1] = String.format("(%s (%s (%s %s) (%s %s)))", 
            TUPL_STR_CODE, CROSS_STR_CODE, CURLY_STR_CODE, ABORT_STR_CODE, COMP_POW_STR_CODE, ops[1]);
        
        return String.format("(%s %s %s)", SMALL_UNION_STR_CODE, ops[1], ops[0]);
    }


    private String generarTi(GCLGrammarParser.ExpContext cond) {
        return String.format("(%s (%s x_{120} . %s) (%s x_{120} . %s))",
            SET_COMP_STR_CODE, LAMBDA_STR_CODE, visit(cond), LAMBDA_STR_CODE, generarTuplaEspacio());
    }


    private String[] generarThenIf(GCLGrammarParser.ThenContext then) {
        String ti = generarTi(then.exp());
        String semIns = (then.inst() != null ? visit(then.inst()) : visit(then.seq()));
        return new String[] 
            {
                String.format("(%s (%s (%s %s) %s))", TUPL_STR_CODE, SEQ_STR_CODE, IDENT_STR_CODE, ti, semIns), 
                ti
            };
    } 


    private String[] auxGenGuardIf(GCLGrammarParser.GuardContext guard)
    {
        if (guard.guard() != null) {
            String[] cgp = auxGenGuardIf(guard.guard());
            String[] then = generarThenIf(guard.then(0));
            return new String[] 
            {
                String.format("(%s %s %s)", SMALL_UNION_STR_CODE, then[0], cgp[0]),
                String.format("(%s %s %s)", SMALL_UNION_STR_CODE, then[1], cgp[1])
            };
        }
        String[] thenL = generarThenIf(guard.then(0)); // checar si es de izq a derecha
        String[] thenR = generarThenIf(guard.then(1)); // checar si es de izq a derecha

        return new String[] 
            {
                String.format("(%s %s %s)", SMALL_UNION_STR_CODE, thenR[0], thenL[0]),
                String.format("(%s %s %s)", SMALL_UNION_STR_CODE, thenR[1], thenL[1])
            };
    }


    @Override
    public String visitGuard(GCLGrammarParser.GuardContext ctx) {
        return null;
    }


    @Override
    public String visitThen(GCLGrammarParser.ThenContext ctx) {
        return null;
    }


    private String generarDo0(GCLGrammarParser.ThenContext root) {
        GCLGrammarParser.ThenContext thenCpy = (GCLGrammarParser.ThenContext)_copier.visit(root);
        GCLGrammarParser.IfOpContext do0Root = new GCLGrammarParser.IfOpContext(null, 0);
        GCLGrammarParser.InstContext skipDmmy = new GCLGrammarParser.InstContext(null, 0);
        GCLGrammarParser.NotExpContext notDo0G = new GCLGrammarParser.NotExpContext(new GCLGrammarParser.ExpContext());

        skipDmmy.addChild(createTerminal(GCLGrammarLexer.TkSkip, "skip"));

        do0Root.addChild(thenCpy);  // agregamos then al if
        thenCpy.removeLastChild();  // quitamos inst | seq
        thenCpy.addChild(skipDmmy); // agregamos la instruccion de skip
            
        notDo0G.addAnyChild(createTerminal(GCLGrammarLexer.TkNot, "!"));
        notDo0G.addChild(thenCpy.exp()); //negamos la cond original
        thenCpy.children.set(0, notDo0G); // reemplazamos la condicion.

        return visit(do0Root);
    }


    private GCLGrammarParser.IfOpContext generarIfDummy(int invkState) {
        GCLGrammarParser.IfOpContext ifRoot = new GCLGrammarParser.IfOpContext(null, invkState);
        ifRoot.addChild(createTerminal(GCLGrammarLexer.TkIf, "if"));
        ifRoot.addChild((RuleContext)null);
        ifRoot.addChild(createTerminal(GCLGrammarLexer.TkFi, "fi"));

        return ifRoot;
    }


    private String generarDoIfSing(GCLGrammarParser.ThenContext root) {
        

        GCLGrammarParser.InstContext skipDmmy = new GCLGrammarParser.InstContext(null, 0);
        skipDmmy.addChild(createTerminal(GCLGrammarLexer.TkSkip, "skip"));

        GCLGrammarParser.IfOpContext ifRoot = generarIfDummy(root.invokingState);
        GCLGrammarParser.GuardContext ifGuard = new GCLGrammarParser.GuardContext(null, 0);
        GCLGrammarParser.ThenContext topThen = new GCLGrammarParser.ThenContext(null, 0);
        GCLGrammarParser.ThenContext botThen = new GCLGrammarParser.ThenContext(null, 0);

        GCLGrammarParser.ExpContext condCpy1 = (GCLGrammarParser.ExpContext)_copier.visit(root.exp());
        GCLGrammarParser.ExpContext condCpy2 = (GCLGrammarParser.ExpContext)_copier.visit(root.exp());
        GCLGrammarParser.NotExpContext notCond = new GCLGrammarParser.NotExpContext(new GCLGrammarParser.ExpContext());

        notCond.addAnyChild(createTerminal(GCLGrammarLexer.TkNot, "!")); 
        notCond.addChild(condCpy2); // negamos cond
        
        topThen.addChild(condCpy1);     // then cond no negada
        botThen.addChild(notCond);      // then cond negada
        
        topThen.addChild(createTerminal(GCLGrammarLexer.TkArrow, "-->"));
        botThen.addChild(createTerminal(GCLGrammarLexer.TkArrow, "-->"));

        if (root.inst() != null)
            topThen.addChild((GCLGrammarParser.InstContext)_copier.visit(root.inst())); // instruccion al then top
        else
            topThen.addChild((GCLGrammarParser.SeqContext)_copier.visit(root.seq()));  // seq al then top
        
        botThen.addChild(skipDmmy); // skip a la negada

        // creamos la guardia
        ifGuard.addChild(topThen);
        ifGuard.addAnyChild(createTerminal(GCLGrammarLexer.TkGuard, "[]"));
        ifGuard.addChild(botThen);

        // padre de la guardia + actualizamos la guardia del if
        ifGuard.parent = ifRoot;
        ifRoot.children.set(1, ifGuard);

        return visit(ifRoot);
    }


    private GCLGrammarParser.IfOpContext generarDoIfMult(GCLGrammarParser.GuardContext gIni) {
        
        GCLGrammarParser.GuardContext gcpy = (GCLGrammarParser.GuardContext)_copier.visit(gIni);
        GCLGrammarParser.IfOpContext ifRes = generarIfDummy(gIni.parent.invokingState);
        ifRes.children.set(1, gcpy);
        gcpy.setParent(ifRes);
        
        return ifRes;
    }


    private ArrayDeque<GCLGrammarParser.ExpContext> extractCondsDo(GCLGrammarParser.GuardContext root) {
        ArrayDeque<GCLGrammarParser.ExpContext> conds = new ArrayDeque<GCLGrammarParser.ExpContext>();

        if (root.guard() != null)
        {
            ArrayDeque<GCLGrammarParser.ExpContext> cExps = extractCondsDo(root.guard());
            
            while (!cExps.isEmpty())
                conds.offer(cExps.pop());
            
            conds.offer(root.then().get(0).exp());
            return conds;
        }

        for (GCLGrammarParser.ThenContext thenC : root.then())
            conds.offer(thenC.exp());

        return conds;
    }


    private String generarDoMultiple(GCLGrammarParser.DoOpContext doRoot) {
        ArrayDeque<GCLGrammarParser.ExpContext> conds = extractCondsDo(doRoot.guard());
        GCLGrammarParser.OrExpContext condExp = null;
        while (!conds.isEmpty()) {
            if (condExp == null) {
                condExp = new GCLGrammarParser.OrExpContext(new GCLGrammarParser.ExpContext());
                condExp.addChild(conds.poll());
                condExp.addChild(createTerminal(GCLGrammarLexer.TkOr, "/\\"));
                condExp.addChild(conds.poll());
                continue;
            }

            GCLGrammarParser.OrExpContext tmp = new GCLGrammarParser.OrExpContext(new GCLGrammarParser.ExpContext());
            tmp.addChild(condExp);
            tmp.addChild(createTerminal(GCLGrammarLexer.TkOr, "/\\"));
            tmp.addChild(conds.poll());
            condExp = tmp;
        }
        
        System.out.println("nueva guardia multiple do");
        System.out.println(visit(condExp));
        System.out.println();
        
        GCLGrammarParser.IfOpContext ifInt = generarDoIfMult(doRoot.guard());
        GCLGrammarParser.InstContext thenInst = new GCLGrammarParser.InstContext(null, 0);
        thenInst.addChild(ifInt);

        GCLGrammarParser.ThenContext then = new GCLGrammarParser.ThenContext(null, 0);
        then.addChild(condExp);
        then.addChild(createTerminal(GCLGrammarLexer.TkArrow, "-->"));
        then.addChild(thenInst);
        
        GCLGrammarParser.DoOpContext finalDo = new GCLGrammarParser.DoOpContext(null, 0);
        finalDo.addChild(then); // deberiamos agregar los tokens pero no nos interesa.
        return visit(finalDo);
    }


    private String DFunction(String arg) {
        return String.format("(%s %s (%s %s))", NUM_STR_CODE, 
            "x_{68}", TUPL_STR_CODE, arg);
    }


    private String doInternalForAll(String do0, String doIf) {
        String range = String.format("(%s (%s %s %s) (%s %s %s))", AND_STR_CODE, LEQ_STR_CODE, 
        "x_{109}", "c_{42}", LEQ_STR_CODE, "x_{105}", "c_{42}");

        String leftOr = String.format("(%s (%s %s %s) (%s %s %s))", AND_STR_CODE, INT_EQ_STR_CODE, 
            do0, DFunction("(x_{109})"), INT_EQ_STR_CODE, "c_{42}", "x_{109}");

        String rightOr = String.format("(%s (%s %s (%s %s %s)) (%s %s %s))", AND_STR_CODE, SEQ_STR_CODE, doIf, INT_EQ_STR_CODE, 
            DFunction("(c_{56} c_{43} x_{109})"), DFunction("(x_{109})"), GREATER_STR_CODE, "c_{42}", "x_{109}");

        return String.format("(%s (%s x_{109} . (%s %s %s)) (%s x_{109} . %s))", FOR_ALL_STR_CODE, LAMBDA_STR_CODE,
            OR_STR_CODE, rightOr, leftOr, LAMBDA_STR_CODE, range);
    }


    private String doInternalDFuncExist(String forAll) {
        String extSpace = generarEspacioExt();
        String range = String.format("(%s (%s (%s %s %s) (%s %s %s)) x_{68})", IN_STR_CODE, POW_STR_CODE, ARR_RANG_STR_CODE,
        "x_{105}", "c_{42}", POW_STR_CODE, extSpace, extSpace);

        String andSeqLeft = String.format("(%s (%s x_{68} (%s x_{105})) x_{67})", INT_EQ_STR_CODE, NUM_STR_CODE, TUPL_STR_CODE);
        String idSet = String.format("(%s (%s (%s x_{120} . %s (%s %s (%s (%s %s))) %s) (%s x_{120} . %s)))", IDENT_STR_CODE, 
        SET_COMP_STR_CODE, LAMBDA_STR_CODE, NIN_STR_CODE, NUM_STR_CODE, DFunction("x_{105}"), TUPL_STR_CODE, CURLY_STR_CODE, 
        "x_{120}", ABORT_STR_CODE, LAMBDA_STR_CODE, generarTuplaEspacio());
        
        String andRight = String.format("(%s (%s (%s %s %s)) %s)", SEQ_STR_CODE, TUPL_STR_CODE, SMALL_UNION_STR_CODE, 
            ABT_ABT_STR_CODE, idSet, andSeqLeft);
        
        String and = String.format("(%s %s %s)", AND_STR_CODE, andRight, forAll);
        //System.out.println(String.format("(%s (%s x_{68} . %s) (%s x_{68} . %s))", EXIST_STR_CODE, LAMBDA_STR_CODE, and, LAMBDA_STR_CODE, range));
        return String.format("(%s (%s x_{68} . %s) (%s x_{68} . %s))", EXIST_STR_CODE, LAMBDA_STR_CODE, and, LAMBDA_STR_CODE, range);
    }


    private String doInternalSetComp(String dExist) {
        String iExist = String.format("(%s (%s x_{105} . %s) (%s x_{105} . (%s %s %s)))", EXIST_STR_CODE, LAMBDA_STR_CODE, dExist,
            LAMBDA_STR_CODE, GEQ_STR_CODE, "c_{42}", "x_{105}");
        
        String espExt = generarEspacioExt();
        String setLeft = String.format("(%s (%s %s %s))", UNIV_STR_CODE, CROSS_STR_CODE, espExt, espExt);

        return String.format("(%s (%s x_{67} . %s) (%s x_{67} . %s))", SET_COMP_STR_CODE, LAMBDA_STR_CODE, iExist,
            LAMBDA_STR_CODE, setLeft);
    }


    private String doShallowExist(String intSet) {
        String range = String.format("(%s (%s %s) %s)", INT_EQ_STR_CODE, BIG_UNION_STR_CODE, intSet, "x_{121}");

        String leftPart = String.format("(%s (%s (%s (%s %s) (%s (%s %s))) (%s)) (%s))", IN_STR_CODE, SMALL_UNION_STR_CODE, CROSS_STR_CODE,
            CURLY_STR_CODE, ABORT_STR_CODE, COMP_POW_STR_CODE, DOM_STR_CODE, "x_{121}", "x_{121}", "x_{122}");

        //System.out.println(String.format("(%s (%s x_{121} . %s) (%s x_{121} . %s))", EXIST_STR_CODE, LAMBDA_STR_CODE, leftPart, LAMBDA_STR_CODE, range));
        return String.format("(%s (%s x_{121} . %s) (%s x_{121} . %s))", EXIST_STR_CODE, LAMBDA_STR_CODE, leftPart, LAMBDA_STR_CODE, range);

    }

    private String generarDoFinal(String do0, String doIf) 
    {
        String intForAll = doInternalForAll(do0, doIf);
        String intSet = doInternalSetComp(doInternalDFuncExist(intForAll));
        String shallowEx = doShallowExist(intSet);

        String espExt = generarEspacioExt();
        
        return String.format("(%s (%s x_{122} . %s) (%s x_{122} . (%s %s %s)))", SET_COMP_STR_CODE, LAMBDA_STR_CODE, shallowEx,
        LAMBDA_STR_CODE, CROSS_STR_CODE, espExt, espExt);
    }


    @Override
    public String visitDoOp(GCLGrammarParser.DoOpContext ctx)
    {
        // de uno solo.
        if (ctx.guard() == null) {
            String do0 = generarDo0(ctx.then());
            String ifDo = generarDoIfSing(ctx.then());

            return generarDoFinal(do0, ifDo);
        }

        return generarDoMultiple(ctx);
    }
}
