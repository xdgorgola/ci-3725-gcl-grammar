import org.antlr.v4.runtime.ParserRuleContext;
import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.TerminalNode;
import org.antlr.v4.runtime.tree.TerminalNodeImpl;

import com.parsing.GCLGrammarParser;

public class ASTCopy extends com.parsing.GCLGrammarBaseVisitor<ParseTree> implements Cloneable {


	@Override 
    public ParseTree visitWriteABody(GCLGrammarParser.WriteABodyContext ctx) { 
        GCLGrammarParser.WriteABodyContext cpy = new GCLGrammarParser.WriteABodyContext(null, ctx.invokingState);
        cpy.start = ctx.start;
        cpy.stop = ctx.stop;

        for (ParseTree c : ctx.children) {
            if (c instanceof TerminalNode) {
                TerminalNode ccpy = (TerminalNode)visit(c);
                ccpy.setParent(cpy);
                cpy.addChild(ccpy);
                continue;
            }
            
            ParserRuleContext ccpy = (ParserRuleContext)visit(c);
            ccpy.setParent(cpy);
            cpy.addChild(ccpy);
        }
        return cpy; 
    }


	@Override 
    public ParseTree visitWriteA(GCLGrammarParser.WriteAContext ctx) { 
        GCLGrammarParser.WriteAContext cpy = new GCLGrammarParser.WriteAContext(null, ctx.invokingState);
        cpy.start = ctx.start;
        cpy.stop = ctx.stop;

        for (ParseTree c : ctx.children) {
            if (c instanceof TerminalNode) {
                TerminalNode ccpy = (TerminalNode)visit(c);
                ccpy.setParent(cpy);
                cpy.addChild(ccpy);
                continue;
            }
            
            ParserRuleContext ccpy = (ParserRuleContext)visit(c);
            ccpy.setParent(cpy);
            cpy.addChild(ccpy);
        }
        return cpy; 
    }


    // PENDIENTE CON ESTE
	@Override 
    public ParseTree visitReadA(GCLGrammarParser.ReadAContext ctx) { 
        GCLGrammarParser.ReadAContext cpy = new GCLGrammarParser.ReadAContext(null, ctx.invokingState);
        cpy.start = ctx.start;
        cpy.stop = ctx.stop;

        for (ParseTree c : ctx.children) {
            if (c instanceof TerminalNode) {
                TerminalNode ccpy = (TerminalNode)visit(c);
                ccpy.setParent(cpy);
                cpy.addChild(ccpy);
                continue;
            }
            
            ParserRuleContext ccpy = (ParserRuleContext)visit(c);
            ccpy.setParent(cpy);
            cpy.addChild(ccpy);
        }
        return cpy; 
    }


    // PENDIENTE CON ESTE
	@Override 
    public ParseTree visitNumericLit(GCLGrammarParser.NumericLitContext ctx) { 
        GCLGrammarParser.NumericLitContext cpy = new GCLGrammarParser.NumericLitContext(null, ctx.invokingState);
        cpy.start = ctx.start;
        cpy.stop = ctx.stop;

        for (ParseTree c : ctx.children) {
            if (c instanceof TerminalNode) {
                TerminalNode ccpy = (TerminalNode)visit(c);
                ccpy.setParent(cpy);
                cpy.addChild(ccpy);
                continue;
            }
            
            ParserRuleContext ccpy = (ParserRuleContext)visit(c);
            ccpy.setParent(cpy);
            cpy.addChild(ccpy);
        }
        return cpy; 
    }


	@Override 
    public ParseTree visitOrdExp(GCLGrammarParser.OrdExpContext ctx) { 
        GCLGrammarParser.OrdExpContext cpy = new GCLGrammarParser.OrdExpContext(ctx);
        cpy.start = ctx.start;
        cpy.stop = ctx.stop;
        cpy.expType = ctx.expType;
        cpy.op = ctx.op;

        // tenemos que settear a y b de vuelta, por los momentos no afecta porque 
        // en astconverter no chequeamos ni a ni b, solo iteramos

        for (ParseTree c : ctx.children) {
            if (c instanceof TerminalNode) {
                TerminalNode ccpy = (TerminalNode)visit(c);
                ccpy.setParent(cpy);
                cpy.addChild(ccpy);
                continue;
            }
            
            ParserRuleContext ccpy = (ParserRuleContext)visit(c);
            ccpy.setParent(cpy);
            cpy.addChild(ccpy);
        }
        return cpy; 
    }


	@Override 
    public ParseTree visitAndExp(GCLGrammarParser.AndExpContext ctx) { 
        GCLGrammarParser.AndExpContext cpy = new GCLGrammarParser.AndExpContext(ctx);
        cpy.start = ctx.start;
        cpy.stop = ctx.stop;
        cpy.expType = ctx.expType;
        cpy.op = ctx.op;

        for (ParseTree c : ctx.children) {
            if (c instanceof TerminalNode) {
                TerminalNode ccpy = (TerminalNode)visit(c);
                ccpy.setParent(cpy);
                cpy.addChild(ccpy);
                continue;
            }
            
            ParserRuleContext ccpy = (ParserRuleContext)visit(c);
            ccpy.setParent(cpy);
            cpy.addChild(ccpy);
        }
        return cpy; 
    }


    // PENDIENTE CON ESTE
	@Override 
    public ParseTree visitBoolExp(GCLGrammarParser.BoolExpContext ctx) { 
        GCLGrammarParser.BoolExpContext cpy = new GCLGrammarParser.BoolExpContext(ctx);
        cpy.start = ctx.start;
        cpy.expType = ctx.expType;
        cpy.stop = ctx.stop;

        for (ParseTree c : ctx.children) {
            if (c instanceof TerminalNode) {
                TerminalNode ccpy = (TerminalNode)visit(c);
                ccpy.setParent(cpy);
                cpy.addChild(ccpy);
                continue;
            }
            
            ParserRuleContext ccpy = (ParserRuleContext)visit(c);
            ccpy.setParent(cpy);
            cpy.addChild(ccpy);
        }
        return cpy;  
    }


	@Override 
    public ParseTree visitMinPlusExp(GCLGrammarParser.MinPlusExpContext ctx) { 
        GCLGrammarParser.MinPlusExpContext cpy = new GCLGrammarParser.MinPlusExpContext(ctx);
        cpy.start = ctx.start;
        cpy.stop = ctx.stop;
        cpy.expType = ctx.expType;
        cpy.op = ctx.op;

        for (ParseTree c : ctx.children) {
            if (c instanceof TerminalNode) {
                TerminalNode ccpy = (TerminalNode)visit(c);
                ccpy.setParent(cpy);
                cpy.addChild(ccpy);
                continue;
            }
            
            ParserRuleContext ccpy = (ParserRuleContext)visit(c);
            ccpy.setParent(cpy);
            cpy.addChild(ccpy);
        }
        return cpy; 
    }


	@Override 
    public ParseTree visitOrExp(GCLGrammarParser.OrExpContext ctx) { 
        GCLGrammarParser.OrExpContext cpy = new GCLGrammarParser.OrExpContext(ctx);
        cpy.start = ctx.start;
        cpy.stop = ctx.stop;
        cpy.expType = ctx.expType;
        cpy.op = ctx.op;

        for (ParseTree c : ctx.children) {
            if (c instanceof TerminalNode) {
                TerminalNode ccpy = (TerminalNode)visit(c);
                ccpy.setParent(cpy);
                cpy.addChild(ccpy);
                continue;
            }
            
            ParserRuleContext ccpy = (ParserRuleContext)visit(c);
            ccpy.setParent(cpy);
            cpy.addChild(ccpy);
        }
        return cpy; 
    }


	@Override 
    public ParseTree visitNotExp(GCLGrammarParser.NotExpContext ctx) { 
        GCLGrammarParser.NotExpContext cpy = new GCLGrammarParser.NotExpContext(ctx);
        cpy.start = ctx.start;
        cpy.stop = ctx.stop;
        cpy.expType = ctx.expType;
        cpy.op = ctx.op;

        for (ParseTree c : ctx.children) {
            if (c instanceof TerminalNode) {
                TerminalNode ccpy = (TerminalNode)visit(c);
                ccpy.setParent(cpy);
                cpy.addChild(ccpy);
                continue;
            }
            
            ParserRuleContext ccpy = (ParserRuleContext)visit(c);
            ccpy.setParent(cpy);
            cpy.addChild(ccpy);
        }
        return cpy; 
    }


    // PENDIENTE CON ESTE
	@Override 
    public ParseTree visitNumExp(GCLGrammarParser.NumExpContext ctx) { 
        GCLGrammarParser.NumExpContext cpy = new GCLGrammarParser.NumExpContext(ctx);
        cpy.start = ctx.start;
        cpy.stop = ctx.stop;
        cpy.expType = ctx.expType;

        for (ParseTree c : ctx.children) {
            if (c instanceof TerminalNode) {
                TerminalNode ccpy = (TerminalNode)visit(c);
                ccpy.setParent(cpy);
                cpy.addChild(ccpy);
                continue;
            }
            
            ParserRuleContext ccpy = (ParserRuleContext)visit(c);
            ccpy.setParent(cpy);
            cpy.addChild(ccpy);
        }
        return cpy; 
    }


	@Override 
    public ParseTree visitUnMinExp(GCLGrammarParser.UnMinExpContext ctx) { 
        GCLGrammarParser.UnMinExpContext cpy = new GCLGrammarParser.UnMinExpContext(ctx);
        cpy.start = ctx.start;
        cpy.stop = ctx.stop;
        cpy.expType = ctx.expType;
        cpy.op = ctx.op;

        for (ParseTree c : ctx.children) {
            if (c instanceof TerminalNode) {
                TerminalNode ccpy = (TerminalNode)visit(c);
                ccpy.setParent(cpy);
                cpy.addChild(ccpy);
                continue;
            }
            
            ParserRuleContext ccpy = (ParserRuleContext)visit(c);
            ccpy.setParent(cpy);
            cpy.addChild(ccpy);
        }
        return cpy; 
    }


	@Override 
    public ParseTree visitEqExp(GCLGrammarParser.EqExpContext ctx) { 
        GCLGrammarParser.EqExpContext cpy = new GCLGrammarParser.EqExpContext(ctx);
        cpy.start = ctx.start;
        cpy.stop = ctx.stop;
        cpy.expType = ctx.expType;
        cpy.op = ctx.op;

        for (ParseTree c : ctx.children) {
            if (c instanceof TerminalNode) {
                TerminalNode ccpy = (TerminalNode)visit(c);
                ccpy.setParent(cpy);
                cpy.addChild(ccpy);
                continue;
            }
            
            ParserRuleContext ccpy = (ParserRuleContext)visit(c);
            ccpy.setParent(cpy);
            cpy.addChild(ccpy);
        }
        return cpy; 
    }


    // pendiente
	@Override 
    public ParseTree visitReadAExp(GCLGrammarParser.ReadAExpContext ctx) { 
        GCLGrammarParser.ReadAExpContext cpy = new GCLGrammarParser.ReadAExpContext(ctx);
        cpy.start = ctx.start;
        cpy.stop = ctx.stop;
        cpy.expType = ctx.expType;

        for (ParseTree c : ctx.children) {
            if (c instanceof TerminalNode) {
                TerminalNode ccpy = (TerminalNode)visit(c);
                ccpy.setParent(cpy);
                cpy.addChild(ccpy);
                continue;
            }
            
            ParserRuleContext ccpy = (ParserRuleContext)visit(c);
            ccpy.setParent(cpy);
            cpy.addChild(ccpy);
        }
        return cpy; 
    }


    // pendiente
	@Override 
    public ParseTree visitIdExp(GCLGrammarParser.IdExpContext ctx) { 
        GCLGrammarParser.IdExpContext cpy = new GCLGrammarParser.IdExpContext(ctx);
        cpy.start = ctx.start;
        cpy.stop = ctx.stop;
        cpy.expType = ctx.expType;

        for (ParseTree c : ctx.children) {
            if (c instanceof TerminalNode) {
                TerminalNode ccpy = (TerminalNode)visit(c);
                ccpy.setParent(cpy);
                cpy.addChild(ccpy);
                continue;
            }
            
            ParserRuleContext ccpy = (ParserRuleContext)visit(c);
            ccpy.setParent(cpy);
            cpy.addChild(ccpy);
        }
        return cpy; 
    }


	@Override 
    public ParseTree visitParExp(GCLGrammarParser.ParExpContext ctx) { 
        GCLGrammarParser.ParExpContext cpy = new GCLGrammarParser.ParExpContext(ctx);
        cpy.start = ctx.start;
        cpy.stop = ctx.stop;
        cpy.expType = ctx.expType;

        for (ParseTree c : ctx.children) {
            if (c instanceof TerminalNode) {
                TerminalNode ccpy = (TerminalNode)visit(c);
                ccpy.setParent(cpy);
                cpy.addChild(ccpy);
                continue;
            }
            
            ParserRuleContext ccpy = (ParserRuleContext)visit(c);
            ccpy.setParent(cpy);
            cpy.addChild(ccpy);
        }
        return cpy; 
    }


	@Override 
    public ParseTree visitMultExp(GCLGrammarParser.MultExpContext ctx) { 
        GCLGrammarParser.MultExpContext cpy = new GCLGrammarParser.MultExpContext(ctx);
        cpy.start = ctx.start;
        cpy.stop = ctx.stop;
        cpy.expType = ctx.expType;
        cpy.op = ctx.op;

        for (ParseTree c : ctx.children) {
            if (c instanceof TerminalNode) {
                TerminalNode ccpy = (TerminalNode)visit(c);
                ccpy.setParent(cpy);
                cpy.addChild(ccpy);
                continue;
            }
            
            ParserRuleContext ccpy = (ParserRuleContext)visit(c);
            ccpy.setParent(cpy);
            cpy.addChild(ccpy);
        }
        return cpy; 
    }


	@Override 
    public ParseTree visitConcatenable(GCLGrammarParser.ConcatenableContext ctx) { 
        GCLGrammarParser.ConcatenableContext cpy = new GCLGrammarParser.ConcatenableContext(null, ctx.invokingState);
        cpy.start = ctx.start;
        cpy.stop = ctx.stop;

        for (ParseTree c : ctx.children) {
            if (c instanceof TerminalNode) {
                TerminalNode ccpy = (TerminalNode)visit(c);
                ccpy.setParent(cpy);
                cpy.addChild(ccpy);
                continue;
            }
            
            ParserRuleContext ccpy = (ParserRuleContext)visit(c);
            ccpy.setParent(cpy);
            cpy.addChild(ccpy);
        }
        return cpy; 
    }


	@Override 
    public ParseTree visitConcatenation(GCLGrammarParser.ConcatenationContext ctx) { 
        GCLGrammarParser.ConcatenationContext cpy = new GCLGrammarParser.ConcatenationContext(null, ctx.invokingState);
        cpy.start = ctx.start;
        cpy.stop = ctx.stop;

        for (ParseTree c : ctx.children) {
            if (c instanceof TerminalNode) {
                TerminalNode ccpy = (TerminalNode)visit(c);
                ccpy.setParent(cpy);
                cpy.addChild(ccpy);
                continue;
            }
            
            ParserRuleContext ccpy = (ParserRuleContext)visit(c);
            ccpy.setParent(cpy);
            cpy.addChild(ccpy);
        }
        return cpy; 
    }


	@Override 
    public ParseTree visitAsignable(GCLGrammarParser.AsignableContext ctx) { 
        GCLGrammarParser.AsignableContext cpy = new GCLGrammarParser.AsignableContext(null, ctx.invokingState);
        cpy.start = ctx.start;
        cpy.stop = ctx.stop;

        for (ParseTree c : ctx.children) {
            if (c instanceof TerminalNode) {
                TerminalNode ccpy = (TerminalNode)visit(c);
                ccpy.setParent(cpy);
                cpy.addChild(ccpy);
                continue;
            }
            
            ParserRuleContext ccpy = (ParserRuleContext)visit(c);
            ccpy.setParent(cpy);
            cpy.addChild(ccpy);
        }
        return cpy; 
    }


	@Override 
    public ParseTree visitArrayInit(GCLGrammarParser.ArrayInitContext ctx) { 
        GCLGrammarParser.ArrayInitContext cpy = new GCLGrammarParser.ArrayInitContext(null, ctx.invokingState);
        cpy.start = ctx.start;
        cpy.stop = ctx.stop;

        for (ParseTree c : ctx.children) {
            if (c instanceof TerminalNode) {
                TerminalNode ccpy = (TerminalNode)visit(c);
                ccpy.setParent(cpy);
                cpy.addChild(ccpy);
                continue;
            }
            
            ParserRuleContext ccpy = (ParserRuleContext)visit(c);
            ccpy.setParent(cpy);
            cpy.addChild(ccpy);
        }
        return cpy; 
    }


	@Override 
    public ParseTree visitAsignation(GCLGrammarParser.AsignationContext ctx) { 
        GCLGrammarParser.AsignationContext cpy = new GCLGrammarParser.AsignationContext(null, ctx.invokingState);
        cpy.start = ctx.start;
        cpy.stop = ctx.stop;

        for (ParseTree c : ctx.children) {
            if (c instanceof TerminalNode) {
                TerminalNode ccpy = (TerminalNode)visit(c);
                ccpy.setParent(cpy);
                cpy.addChild(ccpy);
                continue;
            }
            
            ParserRuleContext ccpy = (ParserRuleContext)visit(c);
            ccpy.setParent(cpy);
            cpy.addChild(ccpy);
        }
        return cpy; 
    }


	@Override 
    public ParseTree visitPrinteable(GCLGrammarParser.PrinteableContext ctx) { 
        GCLGrammarParser.PrinteableContext cpy = new GCLGrammarParser.PrinteableContext(null, ctx.invokingState);
        cpy.start = ctx.start;
        cpy.stop = ctx.stop;

        for (ParseTree c : ctx.children) {
            if (c instanceof TerminalNode) {
                TerminalNode ccpy = (TerminalNode)visit(c);
                ccpy.setParent(cpy);
                cpy.addChild(ccpy);
                continue;
            }
            
            ParserRuleContext ccpy = (ParserRuleContext)visit(c);
            ccpy.setParent(cpy);
            cpy.addChild(ccpy);
        }
        return cpy; 
    }


	@Override 
    public ParseTree visitPrint(GCLGrammarParser.PrintContext ctx) { 
        GCLGrammarParser.PrintContext cpy = new GCLGrammarParser.PrintContext(null, ctx.invokingState);
        cpy.start = ctx.start;
        cpy.stop = ctx.stop;

        for (ParseTree c : ctx.children) {
            if (c instanceof TerminalNode) {
                TerminalNode ccpy = (TerminalNode)visit(c);
                ccpy.setParent(cpy);
                cpy.addChild(ccpy);
                continue;
            }
            
            ParserRuleContext ccpy = (ParserRuleContext)visit(c);
            ccpy.setParent(cpy);
            cpy.addChild(ccpy);
        }
        return cpy; 
    }


	@Override 
    public ParseTree visitThen(GCLGrammarParser.ThenContext ctx) { 
        GCLGrammarParser.ThenContext cpy = new GCLGrammarParser.ThenContext(null, ctx.invokingState);
        cpy.start = ctx.start;
        cpy.stop = ctx.stop;

        for (ParseTree c : ctx.children) {
            if (c instanceof TerminalNode) {
                TerminalNode ccpy = (TerminalNode)visit(c);
                ccpy.setParent(cpy);
                cpy.addChild(ccpy);
                continue;
            }
            
            ParserRuleContext ccpy = (ParserRuleContext)visit(c);
            ccpy.setParent(cpy);
            cpy.addChild(ccpy);
        }
        return cpy; 
    }


	@Override 
    public ParseTree visitIn(GCLGrammarParser.InContext ctx) { 
        GCLGrammarParser.InContext cpy = new GCLGrammarParser.InContext(null, ctx.invokingState);
        cpy.start = ctx.start;
        cpy.stop = ctx.stop;

        for (ParseTree c : ctx.children) {
            if (c instanceof TerminalNode) {
                TerminalNode ccpy = (TerminalNode)visit(c);
                ccpy.setParent(cpy);
                cpy.addChild(ccpy);
                continue;
            }
            
            ParserRuleContext ccpy = (ParserRuleContext)visit(c);
            ccpy.setParent(cpy);
            cpy.addChild(ccpy);
        }
        return cpy; 
    }


	@Override 
    public ParseTree visitTo(GCLGrammarParser.ToContext ctx) { 
        GCLGrammarParser.ToContext cpy = new GCLGrammarParser.ToContext(null, ctx.invokingState);
        cpy.start = ctx.start;
        cpy.stop = ctx.stop;

        for (ParseTree c : ctx.children) {
            if (c instanceof TerminalNode) {
                TerminalNode ccpy = (TerminalNode)visit(c);
                ccpy.setParent(cpy);
                cpy.addChild(ccpy);
                continue;
            }
            
            ParserRuleContext ccpy = (ParserRuleContext)visit(c);
            ccpy.setParent(cpy);
            cpy.addChild(ccpy);
        }
        return cpy; 
    }


	@Override 
    public ParseTree visitForOp(GCLGrammarParser.ForOpContext ctx) { 
        GCLGrammarParser.ForOpContext cpy = new GCLGrammarParser.ForOpContext(null, ctx.invokingState);
        cpy.start = ctx.start;
        cpy.stop = ctx.stop;

        for (ParseTree c : ctx.children) {
            if (c instanceof TerminalNode) {
                TerminalNode ccpy = (TerminalNode)visit(c);
                ccpy.setParent(cpy);
                cpy.addChild(ccpy);
                continue;
            }
            
            ParserRuleContext ccpy = (ParserRuleContext)visit(c);
            ccpy.setParent(cpy);
            cpy.addChild(ccpy);
        }
        return cpy; 
    }


	@Override 
    public ParseTree visitGuard(GCLGrammarParser.GuardContext ctx) { 
        GCLGrammarParser.GuardContext cpy = new GCLGrammarParser.GuardContext(null, ctx.invokingState);
        cpy.start = ctx.start;
        cpy.stop = ctx.stop;

        for (ParseTree c : ctx.children) {
            if (c instanceof TerminalNode) {
                TerminalNode ccpy = (TerminalNode)visit(c);
                ccpy.setParent(cpy);
                cpy.addChild(ccpy);
                continue;
            }
            
            ParserRuleContext ccpy = (ParserRuleContext)visit(c);
            ccpy.setParent(cpy);
            cpy.addChild(ccpy);
        }
        return cpy; 
    }


	@Override 
    public ParseTree visitIfOp(GCLGrammarParser.IfOpContext ctx) { 
        GCLGrammarParser.IfOpContext cpy = new GCLGrammarParser.IfOpContext(null, ctx.invokingState);
        cpy.start = ctx.start;
        cpy.stop = ctx.stop;

        for (ParseTree c : ctx.children) {
            if (c instanceof TerminalNode) {
                TerminalNode ccpy = (TerminalNode)visit(c);
                ccpy.setParent(cpy);
                cpy.addChild(ccpy);
                continue;
            }
            
            ParserRuleContext ccpy = (ParserRuleContext)visit(c);
            ccpy.setParent(cpy);
            cpy.addChild(ccpy);
        }
        return cpy; 
    }


	@Override 
    public ParseTree visitDoOp(GCLGrammarParser.DoOpContext ctx) { 
        GCLGrammarParser.DoOpContext cpy = new GCLGrammarParser.DoOpContext(null, ctx.invokingState);
        cpy.start = ctx.start;
        cpy.stop = ctx.stop;

        for (ParseTree c : ctx.children) {
            if (c instanceof TerminalNode) {
                TerminalNode ccpy = (TerminalNode)visit(c);
                ccpy.setParent(cpy);
                cpy.addChild(ccpy);
                continue;
            }
            
            ParserRuleContext ccpy = (ParserRuleContext)visit(c);
            ccpy.setParent(cpy);
            cpy.addChild(ccpy);
        }
        return cpy; 
    }


	@Override 
    public ParseTree visitTInt(GCLGrammarParser.TIntContext ctx) { 
        GCLGrammarParser.TIntContext cpy = new GCLGrammarParser.TIntContext(ctx);
        cpy.start = ctx.start;
        cpy.stop = ctx.stop;

        for (ParseTree c : ctx.children) {
            if (c instanceof TerminalNode) {
                TerminalNode ccpy = (TerminalNode)visit(c);
                ccpy.setParent(cpy);
                cpy.addChild(ccpy);
                continue;
            }
            
            ParserRuleContext ccpy = (ParserRuleContext)visit(c);
            ccpy.setParent(cpy);
            cpy.addChild(ccpy);
        }
        return cpy; 
    }


	@Override 
    public ParseTree visitTBool(GCLGrammarParser.TBoolContext ctx) { 
        GCLGrammarParser.TBoolContext cpy = new GCLGrammarParser.TBoolContext(ctx);
        cpy.start = ctx.start;
        cpy.stop = ctx.stop;

        for (ParseTree c : ctx.children) {
            if (c instanceof TerminalNode) {
                TerminalNode ccpy = (TerminalNode)visit(c);
                ccpy.setParent(cpy);
                cpy.addChild(ccpy);
                continue;
            }
            
            ParserRuleContext ccpy = (ParserRuleContext)visit(c);
            ccpy.setParent(cpy);
            cpy.addChild(ccpy);
        }
        return cpy; 
    }


	@Override 
    public ParseTree visitTArray(GCLGrammarParser.TArrayContext ctx) { 
        GCLGrammarParser.TArrayContext cpy = new GCLGrammarParser.TArrayContext(ctx);
        cpy.start = ctx.start;
        cpy.stop = ctx.stop;

        for (ParseTree c : ctx.children) {
            if (c instanceof TerminalNode) {
                TerminalNode ccpy = (TerminalNode)visit(c);
                ccpy.setParent(cpy);
                cpy.addChild(ccpy);
                continue;
            }
            
            ParserRuleContext ccpy = (ParserRuleContext)visit(c);
            ccpy.setParent(cpy);
            cpy.addChild(ccpy);
        }
        return cpy; 
    }


	@Override 
    public ParseTree visitLdec(GCLGrammarParser.LdecContext ctx) { 
        GCLGrammarParser.LdecContext cpy = new GCLGrammarParser.LdecContext(null, ctx.invokingState);
        cpy.gclType = ctx.gclType;
        cpy.start = ctx.start;
        cpy.stop = ctx.stop;

        for (ParseTree c : ctx.children) {
            if (c instanceof TerminalNode) {
                TerminalNode ccpy = (TerminalNode)visit(c);
                ccpy.setParent(cpy);
                cpy.addChild(ccpy);
                continue;
            }
            
            ParserRuleContext ccpy = (ParserRuleContext)visit(c);
            ccpy.setParent(cpy);
            cpy.addChild(ccpy);
        }
        return cpy; 
    }


	@Override 
    public ParseTree visitDecl(GCLGrammarParser.DeclContext ctx) { 
        GCLGrammarParser.DeclContext cpy = new GCLGrammarParser.DeclContext(null, ctx.invokingState);
        cpy.start = ctx.start;
        cpy.stop = ctx.stop;

        for (ParseTree c : ctx.children) {
            if (c instanceof TerminalNode) {
                TerminalNode ccpy = (TerminalNode)visit(c);
                ccpy.setParent(cpy);
                cpy.addChild(ccpy);
                continue;
            }
            
            ParserRuleContext ccpy = (ParserRuleContext)visit(c);
            ccpy.setParent(cpy);
            cpy.addChild(ccpy);
        }
        return cpy; 
    }


	@Override 
    public ParseTree visitSeqDecl(GCLGrammarParser.SeqDeclContext ctx) { 
        GCLGrammarParser.SeqDeclContext cpy = new GCLGrammarParser.SeqDeclContext(null, ctx.invokingState);
        cpy.start = ctx.start;
        cpy.stop = ctx.stop;

        for (ParseTree c : ctx.children) {
            if (c instanceof TerminalNode) {
                TerminalNode ccpy = (TerminalNode)visit(c);
                ccpy.setParent(cpy);
                cpy.addChild(ccpy);
                continue;
            }
            
            ParserRuleContext ccpy = (ParserRuleContext)visit(c);
            ccpy.setParent(cpy);
            cpy.addChild(ccpy);
        }
        return cpy; 
    }


	@Override 
    public ParseTree visitInst(GCLGrammarParser.InstContext ctx) { 
        GCLGrammarParser.InstContext cpy = new GCLGrammarParser.InstContext(null, ctx.invokingState);
        cpy.start = ctx.start;
        cpy.stop = ctx.stop;

        for (ParseTree c : ctx.children) {
            if (c instanceof TerminalNode) {
                TerminalNode ccpy = (TerminalNode)visit(c);
                ccpy.setParent(cpy);
                cpy.addChild(ccpy);
                continue;
            }
            
            ParserRuleContext ccpy = (ParserRuleContext)visit(c);
            ccpy.setParent(cpy);
            cpy.addChild(ccpy);
        }
        return cpy; 
    }


	@Override 
    public ParseTree visitSeq(GCLGrammarParser.SeqContext ctx) { 
        GCLGrammarParser.SeqContext cpy = new GCLGrammarParser.SeqContext(null, ctx.invokingState);
        cpy.start = ctx.start;
        cpy.stop = ctx.stop;

        for (ParseTree c : ctx.children) {
            if (c instanceof TerminalNode) {
                TerminalNode ccpy = (TerminalNode)visit(c);
                ccpy.setParent(cpy);
                cpy.addChild(ccpy);
                continue;
            }
            
            ParserRuleContext ccpy = (ParserRuleContext)visit(c);
            ccpy.setParent(cpy);
            cpy.addChild(ccpy);
        }
        return cpy; 
    }


	@Override 
    public ParseTree visitDeclarationBlock(GCLGrammarParser.DeclarationBlockContext ctx) { 
        GCLGrammarParser.DeclarationBlockContext cpy = new GCLGrammarParser.DeclarationBlockContext(null, ctx.invokingState);
        cpy.start = ctx.start;
        cpy.stop = ctx.stop;

        for (ParseTree c : ctx.children) {
            if (c instanceof TerminalNode) {
                TerminalNode ccpy = (TerminalNode)visit(c);
                ccpy.setParent(cpy);
                cpy.addChild(ccpy);
                continue;
            }
            
            ParserRuleContext ccpy = (ParserRuleContext)visit(c);
            ccpy.setParent(cpy);
            cpy.addChild(ccpy);
        }
        return cpy; 
    }


	@Override 
    public ParseTree visitBlock(GCLGrammarParser.BlockContext ctx) { 
        GCLGrammarParser.BlockContext cpy = new GCLGrammarParser.BlockContext(null, ctx.invokingState);
        
        cpy.symbols = ctx.symbols.clone(); // esto es pasar la referencia, debemos copiarlo
        cpy.start = ctx.start;
        cpy.stop = ctx.stop;

        for (ParseTree c : ctx.children) {
            if (c instanceof TerminalNode) {
                TerminalNode ccpy = (TerminalNode)visit(c);
                ccpy.setParent(cpy);
                cpy.addChild(ccpy);
                continue;
            }
            
            ParserRuleContext ccpy = (ParserRuleContext)visit(c);
            ccpy.setParent(cpy);
            cpy.addChild(ccpy);
        }
        return cpy; 
    }


    @Override
    public ParseTree visitTerminal(TerminalNode node) {
        return new TerminalNodeImpl(node.getSymbol());
    }
}
