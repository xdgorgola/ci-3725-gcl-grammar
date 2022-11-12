// Generated from java-escape by ANTLR 4.11.1
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link GCLGrammarParser}.
 */
public interface GCLGrammarListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link GCLGrammarParser#block}.
	 * @param ctx the parse tree
	 */
	void enterBlock(GCLGrammarParser.BlockContext ctx);
	/**
	 * Exit a parse tree produced by {@link GCLGrammarParser#block}.
	 * @param ctx the parse tree
	 */
	void exitBlock(GCLGrammarParser.BlockContext ctx);
	/**
	 * Enter a parse tree produced by {@link GCLGrammarParser#declaration}.
	 * @param ctx the parse tree
	 */
	void enterDeclaration(GCLGrammarParser.DeclarationContext ctx);
	/**
	 * Exit a parse tree produced by {@link GCLGrammarParser#declaration}.
	 * @param ctx the parse tree
	 */
	void exitDeclaration(GCLGrammarParser.DeclarationContext ctx);
	/**
	 * Enter a parse tree produced by {@link GCLGrammarParser#seq}.
	 * @param ctx the parse tree
	 */
	void enterSeq(GCLGrammarParser.SeqContext ctx);
	/**
	 * Exit a parse tree produced by {@link GCLGrammarParser#seq}.
	 * @param ctx the parse tree
	 */
	void exitSeq(GCLGrammarParser.SeqContext ctx);
	/**
	 * Enter a parse tree produced by {@link GCLGrammarParser#decl}.
	 * @param ctx the parse tree
	 */
	void enterDecl(GCLGrammarParser.DeclContext ctx);
	/**
	 * Exit a parse tree produced by {@link GCLGrammarParser#decl}.
	 * @param ctx the parse tree
	 */
	void exitDecl(GCLGrammarParser.DeclContext ctx);
	/**
	 * Enter a parse tree produced by {@link GCLGrammarParser#type}.
	 * @param ctx the parse tree
	 */
	void enterType(GCLGrammarParser.TypeContext ctx);
	/**
	 * Exit a parse tree produced by {@link GCLGrammarParser#type}.
	 * @param ctx the parse tree
	 */
	void exitType(GCLGrammarParser.TypeContext ctx);
	/**
	 * Enter a parse tree produced by {@link GCLGrammarParser#asig}.
	 * @param ctx the parse tree
	 */
	void enterAsig(GCLGrammarParser.AsigContext ctx);
	/**
	 * Exit a parse tree produced by {@link GCLGrammarParser#asig}.
	 * @param ctx the parse tree
	 */
	void exitAsig(GCLGrammarParser.AsigContext ctx);
	/**
	 * Enter a parse tree produced by {@link GCLGrammarParser#print}.
	 * @param ctx the parse tree
	 */
	void enterPrint(GCLGrammarParser.PrintContext ctx);
	/**
	 * Exit a parse tree produced by {@link GCLGrammarParser#print}.
	 * @param ctx the parse tree
	 */
	void exitPrint(GCLGrammarParser.PrintContext ctx);
	/**
	 * Enter a parse tree produced by {@link GCLGrammarParser#op}.
	 * @param ctx the parse tree
	 */
	void enterOp(GCLGrammarParser.OpContext ctx);
	/**
	 * Exit a parse tree produced by {@link GCLGrammarParser#op}.
	 * @param ctx the parse tree
	 */
	void exitOp(GCLGrammarParser.OpContext ctx);
	/**
	 * Enter a parse tree produced by {@link GCLGrammarParser#sum}.
	 * @param ctx the parse tree
	 */
	void enterSum(GCLGrammarParser.SumContext ctx);
	/**
	 * Exit a parse tree produced by {@link GCLGrammarParser#sum}.
	 * @param ctx the parse tree
	 */
	void exitSum(GCLGrammarParser.SumContext ctx);
	/**
	 * Enter a parse tree produced by {@link GCLGrammarParser#sus}.
	 * @param ctx the parse tree
	 */
	void enterSus(GCLGrammarParser.SusContext ctx);
	/**
	 * Exit a parse tree produced by {@link GCLGrammarParser#sus}.
	 * @param ctx the parse tree
	 */
	void exitSus(GCLGrammarParser.SusContext ctx);
	/**
	 * Enter a parse tree produced by {@link GCLGrammarParser#mult}.
	 * @param ctx the parse tree
	 */
	void enterMult(GCLGrammarParser.MultContext ctx);
	/**
	 * Exit a parse tree produced by {@link GCLGrammarParser#mult}.
	 * @param ctx the parse tree
	 */
	void exitMult(GCLGrammarParser.MultContext ctx);
	/**
	 * Enter a parse tree produced by {@link GCLGrammarParser#neg}.
	 * @param ctx the parse tree
	 */
	void enterNeg(GCLGrammarParser.NegContext ctx);
	/**
	 * Exit a parse tree produced by {@link GCLGrammarParser#neg}.
	 * @param ctx the parse tree
	 */
	void exitNeg(GCLGrammarParser.NegContext ctx);
	/**
	 * Enter a parse tree produced by {@link GCLGrammarParser#mayor}.
	 * @param ctx the parse tree
	 */
	void enterMayor(GCLGrammarParser.MayorContext ctx);
	/**
	 * Exit a parse tree produced by {@link GCLGrammarParser#mayor}.
	 * @param ctx the parse tree
	 */
	void exitMayor(GCLGrammarParser.MayorContext ctx);
	/**
	 * Enter a parse tree produced by {@link GCLGrammarParser#menor}.
	 * @param ctx the parse tree
	 */
	void enterMenor(GCLGrammarParser.MenorContext ctx);
	/**
	 * Exit a parse tree produced by {@link GCLGrammarParser#menor}.
	 * @param ctx the parse tree
	 */
	void exitMenor(GCLGrammarParser.MenorContext ctx);
	/**
	 * Enter a parse tree produced by {@link GCLGrammarParser#mayorig}.
	 * @param ctx the parse tree
	 */
	void enterMayorig(GCLGrammarParser.MayorigContext ctx);
	/**
	 * Exit a parse tree produced by {@link GCLGrammarParser#mayorig}.
	 * @param ctx the parse tree
	 */
	void exitMayorig(GCLGrammarParser.MayorigContext ctx);
	/**
	 * Enter a parse tree produced by {@link GCLGrammarParser#menorig}.
	 * @param ctx the parse tree
	 */
	void enterMenorig(GCLGrammarParser.MenorigContext ctx);
	/**
	 * Exit a parse tree produced by {@link GCLGrammarParser#menorig}.
	 * @param ctx the parse tree
	 */
	void exitMenorig(GCLGrammarParser.MenorigContext ctx);
	/**
	 * Enter a parse tree produced by {@link GCLGrammarParser#desig}.
	 * @param ctx the parse tree
	 */
	void enterDesig(GCLGrammarParser.DesigContext ctx);
	/**
	 * Exit a parse tree produced by {@link GCLGrammarParser#desig}.
	 * @param ctx the parse tree
	 */
	void exitDesig(GCLGrammarParser.DesigContext ctx);
	/**
	 * Enter a parse tree produced by {@link GCLGrammarParser#y}.
	 * @param ctx the parse tree
	 */
	void enterY(GCLGrammarParser.YContext ctx);
	/**
	 * Exit a parse tree produced by {@link GCLGrammarParser#y}.
	 * @param ctx the parse tree
	 */
	void exitY(GCLGrammarParser.YContext ctx);
	/**
	 * Enter a parse tree produced by {@link GCLGrammarParser#o}.
	 * @param ctx the parse tree
	 */
	void enterO(GCLGrammarParser.OContext ctx);
	/**
	 * Exit a parse tree produced by {@link GCLGrammarParser#o}.
	 * @param ctx the parse tree
	 */
	void exitO(GCLGrammarParser.OContext ctx);
	/**
	 * Enter a parse tree produced by {@link GCLGrammarParser#no}.
	 * @param ctx the parse tree
	 */
	void enterNo(GCLGrammarParser.NoContext ctx);
	/**
	 * Exit a parse tree produced by {@link GCLGrammarParser#no}.
	 * @param ctx the parse tree
	 */
	void exitNo(GCLGrammarParser.NoContext ctx);
	/**
	 * Enter a parse tree produced by {@link GCLGrammarParser#conc}.
	 * @param ctx the parse tree
	 */
	void enterConc(GCLGrammarParser.ConcContext ctx);
	/**
	 * Exit a parse tree produced by {@link GCLGrammarParser#conc}.
	 * @param ctx the parse tree
	 */
	void exitConc(GCLGrammarParser.ConcContext ctx);
	/**
	 * Enter a parse tree produced by {@link GCLGrammarParser#ident}.
	 * @param ctx the parse tree
	 */
	void enterIdent(GCLGrammarParser.IdentContext ctx);
	/**
	 * Exit a parse tree produced by {@link GCLGrammarParser#ident}.
	 * @param ctx the parse tree
	 */
	void exitIdent(GCLGrammarParser.IdentContext ctx);
	/**
	 * Enter a parse tree produced by {@link GCLGrammarParser#readA}.
	 * @param ctx the parse tree
	 */
	void enterReadA(GCLGrammarParser.ReadAContext ctx);
	/**
	 * Exit a parse tree produced by {@link GCLGrammarParser#readA}.
	 * @param ctx the parse tree
	 */
	void exitReadA(GCLGrammarParser.ReadAContext ctx);
	/**
	 * Enter a parse tree produced by {@link GCLGrammarParser#lit}.
	 * @param ctx the parse tree
	 */
	void enterLit(GCLGrammarParser.LitContext ctx);
	/**
	 * Exit a parse tree produced by {@link GCLGrammarParser#lit}.
	 * @param ctx the parse tree
	 */
	void exitLit(GCLGrammarParser.LitContext ctx);
}