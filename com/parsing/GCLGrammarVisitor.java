package com.parsing;
// Generated from java-escape by ANTLR 4.11.1

import java.util.Hashtable;
import java.util.Stack;

import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link GCLGrammarParser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface GCLGrammarVisitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by {@link GCLGrammarParser#writeABody}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitWriteABody(GCLGrammarParser.WriteABodyContext ctx);
	/**
	 * Visit a parse tree produced by {@link GCLGrammarParser#writeA}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitWriteA(GCLGrammarParser.WriteAContext ctx);
	/**
	 * Visit a parse tree produced by {@link GCLGrammarParser#readA}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitReadA(GCLGrammarParser.ReadAContext ctx);
	/**
	 * Visit a parse tree produced by {@link GCLGrammarParser#numericLit}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNumericLit(GCLGrammarParser.NumericLitContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ordExp}
	 * labeled alternative in {@link GCLGrammarParser#exp}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitOrdExp(GCLGrammarParser.OrdExpContext ctx);
	/**
	 * Visit a parse tree produced by the {@code andExp}
	 * labeled alternative in {@link GCLGrammarParser#exp}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAndExp(GCLGrammarParser.AndExpContext ctx);
	/**
	 * Visit a parse tree produced by the {@code boolExp}
	 * labeled alternative in {@link GCLGrammarParser#exp}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBoolExp(GCLGrammarParser.BoolExpContext ctx);
	/**
	 * Visit a parse tree produced by the {@code minPlusExp}
	 * labeled alternative in {@link GCLGrammarParser#exp}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMinPlusExp(GCLGrammarParser.MinPlusExpContext ctx);
	/**
	 * Visit a parse tree produced by the {@code orExp}
	 * labeled alternative in {@link GCLGrammarParser#exp}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitOrExp(GCLGrammarParser.OrExpContext ctx);
	/**
	 * Visit a parse tree produced by the {@code notExp}
	 * labeled alternative in {@link GCLGrammarParser#exp}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNotExp(GCLGrammarParser.NotExpContext ctx);
	/**
	 * Visit a parse tree produced by the {@code numExp}
	 * labeled alternative in {@link GCLGrammarParser#exp}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNumExp(GCLGrammarParser.NumExpContext ctx);
	/**
	 * Visit a parse tree produced by the {@code unMinExp}
	 * labeled alternative in {@link GCLGrammarParser#exp}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitUnMinExp(GCLGrammarParser.UnMinExpContext ctx);
	/**
	 * Visit a parse tree produced by the {@code eqExp}
	 * labeled alternative in {@link GCLGrammarParser#exp}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitEqExp(GCLGrammarParser.EqExpContext ctx);
	/**
	 * Visit a parse tree produced by the {@code readAExp}
	 * labeled alternative in {@link GCLGrammarParser#exp}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitReadAExp(GCLGrammarParser.ReadAExpContext ctx);
	/**
	 * Visit a parse tree produced by the {@code idExp}
	 * labeled alternative in {@link GCLGrammarParser#exp}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIdExp(GCLGrammarParser.IdExpContext ctx);
	/**
	 * Visit a parse tree produced by the {@code parExp}
	 * labeled alternative in {@link GCLGrammarParser#exp}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitParExp(GCLGrammarParser.ParExpContext ctx);
	/**
	 * Visit a parse tree produced by the {@code multExp}
	 * labeled alternative in {@link GCLGrammarParser#exp}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMultExp(GCLGrammarParser.MultExpContext ctx);
	/**
	 * Visit a parse tree produced by {@link GCLGrammarParser#concatenable}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitConcatenable(GCLGrammarParser.ConcatenableContext ctx);
	/**
	 * Visit a parse tree produced by {@link GCLGrammarParser#concatenation}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitConcatenation(GCLGrammarParser.ConcatenationContext ctx);
	/**
	 * Visit a parse tree produced by {@link GCLGrammarParser#asignable}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAsignable(GCLGrammarParser.AsignableContext ctx);
	/**
	 * Visit a parse tree produced by {@link GCLGrammarParser#arrayInit}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitArrayInit(GCLGrammarParser.ArrayInitContext ctx);
	/**
	 * Visit a parse tree produced by {@link GCLGrammarParser#asignation}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAsignation(GCLGrammarParser.AsignationContext ctx);
	/**
	 * Visit a parse tree produced by {@link GCLGrammarParser#printeable}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPrinteable(GCLGrammarParser.PrinteableContext ctx);
	/**
	 * Visit a parse tree produced by {@link GCLGrammarParser#print}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPrint(GCLGrammarParser.PrintContext ctx);
	/**
	 * Visit a parse tree produced by {@link GCLGrammarParser#then}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitThen(GCLGrammarParser.ThenContext ctx);
	/**
	 * Visit a parse tree produced by {@link GCLGrammarParser#in}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIn(GCLGrammarParser.InContext ctx);
	/**
	 * Visit a parse tree produced by {@link GCLGrammarParser#to}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTo(GCLGrammarParser.ToContext ctx);
	/**
	 * Visit a parse tree produced by {@link GCLGrammarParser#forOp}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitForOp(GCLGrammarParser.ForOpContext ctx);
	/**
	 * Visit a parse tree produced by {@link GCLGrammarParser#guard}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitGuard(GCLGrammarParser.GuardContext ctx);
	/**
	 * Visit a parse tree produced by {@link GCLGrammarParser#ifOp}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIfOp(GCLGrammarParser.IfOpContext ctx);
	/**
	 * Visit a parse tree produced by {@link GCLGrammarParser#doOp}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDoOp(GCLGrammarParser.DoOpContext ctx);
	/**
	 * Visit a parse tree produced by the {@code tInt}
	 * labeled alternative in {@link GCLGrammarParser#type}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTInt(GCLGrammarParser.TIntContext ctx);
	/**
	 * Visit a parse tree produced by the {@code tBool}
	 * labeled alternative in {@link GCLGrammarParser#type}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTBool(GCLGrammarParser.TBoolContext ctx);
	/**
	 * Visit a parse tree produced by the {@code tArray}
	 * labeled alternative in {@link GCLGrammarParser#type}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTArray(GCLGrammarParser.TArrayContext ctx);
	/**
	 * Visit a parse tree produced by {@link GCLGrammarParser#ldec}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLdec(GCLGrammarParser.LdecContext ctx);
	/**
	 * Visit a parse tree produced by {@link GCLGrammarParser#decl}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDecl(GCLGrammarParser.DeclContext ctx);
	/**
	 * Visit a parse tree produced by {@link GCLGrammarParser#seqDecl}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSeqDecl(GCLGrammarParser.SeqDeclContext ctx);
	/**
	 * Visit a parse tree produced by {@link GCLGrammarParser#inst}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitInst(GCLGrammarParser.InstContext ctx);
	/**
	 * Visit a parse tree produced by {@link GCLGrammarParser#seq}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSeq(GCLGrammarParser.SeqContext ctx);
	/**
	 * Visit a parse tree produced by {@link GCLGrammarParser#declarationBlock}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDeclarationBlock(GCLGrammarParser.DeclarationBlockContext ctx);
	/**
	 * Visit a parse tree produced by {@link GCLGrammarParser#block}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBlock(GCLGrammarParser.BlockContext ctx);
}