package com.parsing;
// Generated from java-escape by ANTLR 4.11.1
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast", "CheckReturnValue"})
public class GCLGrammarParser extends Parser {
	static { RuntimeMetaData.checkVersion("4.11.1", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		TkIf=1, TkFi=2, TkDo=3, TkOd=4, TkTo=5, TkIn=6, TkInt=7, TkBool=8, TkFor=9, 
		TkRof=10, TkArray=11, TkSkip=12, TkPrint=13, TkDeclare=14, TkComma=15, 
		TkOpenPar=16, TkClosePar=17, TkSemicolon=18, TkOBlock=19, TkCBlock=20, 
		TkSoForth=21, TkAsig=22, TkArrow=23, TkGuard=24, TkConcat=25, TkOBracket=26, 
		TkCBracket=27, TkPlus=28, TkMinus=29, TkMult=30, TkNot=31, TkTwoPoints=32, 
		TkLess=33, TkGreater=34, TkNEqual=35, TkLeq=36, TkGeq=37, TkEqual=38, 
		TkOr=39, TkAnd=40, TkTrue=41, TkFalse=42, TkNum=43, TkString=44, TkId=45, 
		SLCMT=46, WS=47;
	public static final int
		RULE_writeABody = 0, RULE_writeA = 1, RULE_readA = 2, RULE_numericLit = 3, 
		RULE_exp = 4, RULE_concatenable = 5, RULE_concatenation = 6, RULE_asignable = 7, 
		RULE_arrayInit = 8, RULE_asignation = 9, RULE_printeable = 10, RULE_print = 11, 
		RULE_type = 12, RULE_decl = 13, RULE_then = 14, RULE_guardBody = 15, RULE_guard = 16, 
		RULE_ifOp = 17, RULE_in = 18, RULE_to = 19, RULE_forOp = 20, RULE_doOp = 21, 
		RULE_seqDecl = 22, RULE_inst = 23, RULE_seq = 24, RULE_declarationBlock = 25, 
		RULE_block = 26;
	private static String[] makeRuleNames() {
		return new String[] {
			"writeABody", "writeA", "readA", "numericLit", "exp", "concatenable", 
			"concatenation", "asignable", "arrayInit", "asignation", "printeable", 
			"print", "type", "decl", "then", "guardBody", "guard", "ifOp", "in", 
			"to", "forOp", "doOp", "seqDecl", "inst", "seq", "declarationBlock", 
			"block"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "'if'", "'fi'", "'do'", "'od'", "'to'", "'in'", "'int'", "'bool'", 
			"'for'", "'rof'", "'array'", "'skip'", "'print'", "'declare'", "','", 
			"'('", "')'", "';'", "'|['", "']|'", "'..'", "':='", "'-->'", "'[]'", 
			"'.'", "'['", "']'", "'+'", "'-'", "'*'", "'!'", "':'", "'<'", "'>'", 
			"'!='", "'<='", "'>='", "'=='", "'\\/'", "'/\\'", "'true'", "'false'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, "TkIf", "TkFi", "TkDo", "TkOd", "TkTo", "TkIn", "TkInt", "TkBool", 
			"TkFor", "TkRof", "TkArray", "TkSkip", "TkPrint", "TkDeclare", "TkComma", 
			"TkOpenPar", "TkClosePar", "TkSemicolon", "TkOBlock", "TkCBlock", "TkSoForth", 
			"TkAsig", "TkArrow", "TkGuard", "TkConcat", "TkOBracket", "TkCBracket", 
			"TkPlus", "TkMinus", "TkMult", "TkNot", "TkTwoPoints", "TkLess", "TkGreater", 
			"TkNEqual", "TkLeq", "TkGeq", "TkEqual", "TkOr", "TkAnd", "TkTrue", "TkFalse", 
			"TkNum", "TkString", "TkId", "SLCMT", "WS"
		};
	}
	private static final String[] _SYMBOLIC_NAMES = makeSymbolicNames();
	public static final Vocabulary VOCABULARY = new VocabularyImpl(_LITERAL_NAMES, _SYMBOLIC_NAMES);

	/**
	 * @deprecated Use {@link #VOCABULARY} instead.
	 */
	@Deprecated
	public static final String[] tokenNames;
	static {
		tokenNames = new String[_SYMBOLIC_NAMES.length];
		for (int i = 0; i < tokenNames.length; i++) {
			tokenNames[i] = VOCABULARY.getLiteralName(i);
			if (tokenNames[i] == null) {
				tokenNames[i] = VOCABULARY.getSymbolicName(i);
			}

			if (tokenNames[i] == null) {
				tokenNames[i] = "<INVALID>";
			}
		}
	}

	@Override
	@Deprecated
	public String[] getTokenNames() {
		return tokenNames;
	}

	@Override

	public Vocabulary getVocabulary() {
		return VOCABULARY;
	}

	@Override
	public String getGrammarFileName() { return "java-escape"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }

	public GCLGrammarParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@SuppressWarnings("CheckReturnValue")
	public static class WriteABodyContext extends ParserRuleContext {
		public TerminalNode TkOpenPar() { return getToken(GCLGrammarParser.TkOpenPar, 0); }
		public List<ExpContext> exp() {
			return getRuleContexts(ExpContext.class);
		}
		public ExpContext exp(int i) {
			return getRuleContext(ExpContext.class,i);
		}
		public TerminalNode TkTwoPoints() { return getToken(GCLGrammarParser.TkTwoPoints, 0); }
		public TerminalNode TkClosePar() { return getToken(GCLGrammarParser.TkClosePar, 0); }
		public WriteABodyContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_writeABody; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GCLGrammarVisitor ) return ((GCLGrammarVisitor<? extends T>)visitor).visitWriteABody(this);
			else return visitor.visitChildren(this);
		}
	}

	public final WriteABodyContext writeABody() throws RecognitionException {
		WriteABodyContext _localctx = new WriteABodyContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_writeABody);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(54);
			match(TkOpenPar);
			setState(55);
			exp(0);
			setState(56);
			match(TkTwoPoints);
			setState(57);
			exp(0);
			setState(58);
			match(TkClosePar);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class WriteAContext extends ParserRuleContext {
		public TerminalNode TkId() { return getToken(GCLGrammarParser.TkId, 0); }
		public WriteABodyContext writeABody() {
			return getRuleContext(WriteABodyContext.class,0);
		}
		public WriteAContext writeA() {
			return getRuleContext(WriteAContext.class,0);
		}
		public WriteAContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_writeA; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GCLGrammarVisitor ) return ((GCLGrammarVisitor<? extends T>)visitor).visitWriteA(this);
			else return visitor.visitChildren(this);
		}
	}

	public final WriteAContext writeA() throws RecognitionException {
		return writeA(0);
	}

	private WriteAContext writeA(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		WriteAContext _localctx = new WriteAContext(_ctx, _parentState);
		WriteAContext _prevctx = _localctx;
		int _startState = 2;
		enterRecursionRule(_localctx, 2, RULE_writeA, _p);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			{
			setState(61);
			match(TkId);
			setState(62);
			writeABody();
			}
			_ctx.stop = _input.LT(-1);
			setState(68);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,0,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					{
					_localctx = new WriteAContext(_parentctx, _parentState);
					pushNewRecursionContext(_localctx, _startState, RULE_writeA);
					setState(64);
					if (!(precpred(_ctx, 1))) throw new FailedPredicateException(this, "precpred(_ctx, 1)");
					setState(65);
					writeABody();
					}
					} 
				}
				setState(70);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,0,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			unrollRecursionContexts(_parentctx);
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class ReadAContext extends ParserRuleContext {
		public WriteAContext writeA() {
			return getRuleContext(WriteAContext.class,0);
		}
		public TerminalNode TkOBracket() { return getToken(GCLGrammarParser.TkOBracket, 0); }
		public ExpContext exp() {
			return getRuleContext(ExpContext.class,0);
		}
		public TerminalNode TkCBracket() { return getToken(GCLGrammarParser.TkCBracket, 0); }
		public TerminalNode TkId() { return getToken(GCLGrammarParser.TkId, 0); }
		public ReadAContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_readA; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GCLGrammarVisitor ) return ((GCLGrammarVisitor<? extends T>)visitor).visitReadA(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ReadAContext readA() throws RecognitionException {
		ReadAContext _localctx = new ReadAContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_readA);
		try {
			setState(81);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,1,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(71);
				writeA(0);
				setState(72);
				match(TkOBracket);
				setState(73);
				exp(0);
				setState(74);
				match(TkCBracket);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(76);
				match(TkId);
				setState(77);
				match(TkOBracket);
				setState(78);
				exp(0);
				setState(79);
				match(TkCBracket);
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class NumericLitContext extends ParserRuleContext {
		public TerminalNode TkMinus() { return getToken(GCLGrammarParser.TkMinus, 0); }
		public NumericLitContext numericLit() {
			return getRuleContext(NumericLitContext.class,0);
		}
		public TerminalNode TkNum() { return getToken(GCLGrammarParser.TkNum, 0); }
		public NumericLitContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_numericLit; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GCLGrammarVisitor ) return ((GCLGrammarVisitor<? extends T>)visitor).visitNumericLit(this);
			else return visitor.visitChildren(this);
		}
	}

	public final NumericLitContext numericLit() throws RecognitionException {
		NumericLitContext _localctx = new NumericLitContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_numericLit);
		try {
			setState(86);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case TkMinus:
				enterOuterAlt(_localctx, 1);
				{
				setState(83);
				match(TkMinus);
				setState(84);
				numericLit();
				}
				break;
			case TkNum:
				enterOuterAlt(_localctx, 2);
				{
				setState(85);
				match(TkNum);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class ExpContext extends ParserRuleContext {
		public ExpContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_exp; }
	 
		public ExpContext() { }
		public void copyFrom(ExpContext ctx) {
			super.copyFrom(ctx);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class OrdExpContext extends ExpContext {
		public ExpContext a;
		public Token op;
		public ExpContext b;
		public List<ExpContext> exp() {
			return getRuleContexts(ExpContext.class);
		}
		public ExpContext exp(int i) {
			return getRuleContext(ExpContext.class,i);
		}
		public TerminalNode TkGeq() { return getToken(GCLGrammarParser.TkGeq, 0); }
		public TerminalNode TkGreater() { return getToken(GCLGrammarParser.TkGreater, 0); }
		public TerminalNode TkLeq() { return getToken(GCLGrammarParser.TkLeq, 0); }
		public TerminalNode TkLess() { return getToken(GCLGrammarParser.TkLess, 0); }
		public OrdExpContext(ExpContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GCLGrammarVisitor ) return ((GCLGrammarVisitor<? extends T>)visitor).visitOrdExp(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class AndExpContext extends ExpContext {
		public ExpContext a;
		public Token op;
		public ExpContext b;
		public List<ExpContext> exp() {
			return getRuleContexts(ExpContext.class);
		}
		public ExpContext exp(int i) {
			return getRuleContext(ExpContext.class,i);
		}
		public TerminalNode TkAnd() { return getToken(GCLGrammarParser.TkAnd, 0); }
		public AndExpContext(ExpContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GCLGrammarVisitor ) return ((GCLGrammarVisitor<? extends T>)visitor).visitAndExp(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class BoolExpContext extends ExpContext {
		public Token a;
		public TerminalNode TkTrue() { return getToken(GCLGrammarParser.TkTrue, 0); }
		public TerminalNode TkFalse() { return getToken(GCLGrammarParser.TkFalse, 0); }
		public BoolExpContext(ExpContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GCLGrammarVisitor ) return ((GCLGrammarVisitor<? extends T>)visitor).visitBoolExp(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class MinPlusExpContext extends ExpContext {
		public ExpContext a;
		public Token op;
		public ExpContext b;
		public List<ExpContext> exp() {
			return getRuleContexts(ExpContext.class);
		}
		public ExpContext exp(int i) {
			return getRuleContext(ExpContext.class,i);
		}
		public TerminalNode TkPlus() { return getToken(GCLGrammarParser.TkPlus, 0); }
		public TerminalNode TkMinus() { return getToken(GCLGrammarParser.TkMinus, 0); }
		public MinPlusExpContext(ExpContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GCLGrammarVisitor ) return ((GCLGrammarVisitor<? extends T>)visitor).visitMinPlusExp(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class OrExpContext extends ExpContext {
		public ExpContext a;
		public Token op;
		public ExpContext b;
		public List<ExpContext> exp() {
			return getRuleContexts(ExpContext.class);
		}
		public ExpContext exp(int i) {
			return getRuleContext(ExpContext.class,i);
		}
		public TerminalNode TkOr() { return getToken(GCLGrammarParser.TkOr, 0); }
		public OrExpContext(ExpContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GCLGrammarVisitor ) return ((GCLGrammarVisitor<? extends T>)visitor).visitOrExp(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class NotExpContext extends ExpContext {
		public Token op;
		public ExpContext a;
		public TerminalNode TkNot() { return getToken(GCLGrammarParser.TkNot, 0); }
		public ExpContext exp() {
			return getRuleContext(ExpContext.class,0);
		}
		public NotExpContext(ExpContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GCLGrammarVisitor ) return ((GCLGrammarVisitor<? extends T>)visitor).visitNotExp(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class NumExpContext extends ExpContext {
		public Token a;
		public TerminalNode TkNum() { return getToken(GCLGrammarParser.TkNum, 0); }
		public NumExpContext(ExpContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GCLGrammarVisitor ) return ((GCLGrammarVisitor<? extends T>)visitor).visitNumExp(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class UnMinExpContext extends ExpContext {
		public Token op;
		public ExpContext a;
		public TerminalNode TkMinus() { return getToken(GCLGrammarParser.TkMinus, 0); }
		public ExpContext exp() {
			return getRuleContext(ExpContext.class,0);
		}
		public UnMinExpContext(ExpContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GCLGrammarVisitor ) return ((GCLGrammarVisitor<? extends T>)visitor).visitUnMinExp(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class EqExpContext extends ExpContext {
		public ExpContext a;
		public Token op;
		public ExpContext b;
		public List<ExpContext> exp() {
			return getRuleContexts(ExpContext.class);
		}
		public ExpContext exp(int i) {
			return getRuleContext(ExpContext.class,i);
		}
		public TerminalNode TkEqual() { return getToken(GCLGrammarParser.TkEqual, 0); }
		public TerminalNode TkNEqual() { return getToken(GCLGrammarParser.TkNEqual, 0); }
		public EqExpContext(ExpContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GCLGrammarVisitor ) return ((GCLGrammarVisitor<? extends T>)visitor).visitEqExp(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class ReadAExpContext extends ExpContext {
		public ReadAContext a;
		public ReadAContext readA() {
			return getRuleContext(ReadAContext.class,0);
		}
		public ReadAExpContext(ExpContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GCLGrammarVisitor ) return ((GCLGrammarVisitor<? extends T>)visitor).visitReadAExp(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class IdExpContext extends ExpContext {
		public Token a;
		public TerminalNode TkId() { return getToken(GCLGrammarParser.TkId, 0); }
		public IdExpContext(ExpContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GCLGrammarVisitor ) return ((GCLGrammarVisitor<? extends T>)visitor).visitIdExp(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class ParExpContext extends ExpContext {
		public ExpContext a;
		public TerminalNode TkOpenPar() { return getToken(GCLGrammarParser.TkOpenPar, 0); }
		public TerminalNode TkClosePar() { return getToken(GCLGrammarParser.TkClosePar, 0); }
		public ExpContext exp() {
			return getRuleContext(ExpContext.class,0);
		}
		public ParExpContext(ExpContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GCLGrammarVisitor ) return ((GCLGrammarVisitor<? extends T>)visitor).visitParExp(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class MultExpContext extends ExpContext {
		public ExpContext a;
		public Token op;
		public ExpContext b;
		public List<ExpContext> exp() {
			return getRuleContexts(ExpContext.class);
		}
		public ExpContext exp(int i) {
			return getRuleContext(ExpContext.class,i);
		}
		public TerminalNode TkMult() { return getToken(GCLGrammarParser.TkMult, 0); }
		public MultExpContext(ExpContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GCLGrammarVisitor ) return ((GCLGrammarVisitor<? extends T>)visitor).visitMultExp(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ExpContext exp() throws RecognitionException {
		return exp(0);
	}

	private ExpContext exp(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		ExpContext _localctx = new ExpContext(_ctx, _parentState);
		ExpContext _prevctx = _localctx;
		int _startState = 8;
		enterRecursionRule(_localctx, 8, RULE_exp, _p);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(101);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,3,_ctx) ) {
			case 1:
				{
				_localctx = new ParExpContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;

				setState(89);
				match(TkOpenPar);
				setState(90);
				((ParExpContext)_localctx).a = exp(0);
				setState(91);
				match(TkClosePar);
				}
				break;
			case 2:
				{
				_localctx = new UnMinExpContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(93);
				((UnMinExpContext)_localctx).op = match(TkMinus);
				setState(94);
				((UnMinExpContext)_localctx).a = exp(12);
				}
				break;
			case 3:
				{
				_localctx = new NotExpContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(95);
				((NotExpContext)_localctx).op = match(TkNot);
				setState(96);
				((NotExpContext)_localctx).a = exp(11);
				}
				break;
			case 4:
				{
				_localctx = new IdExpContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(97);
				((IdExpContext)_localctx).a = match(TkId);
				}
				break;
			case 5:
				{
				_localctx = new NumExpContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(98);
				((NumExpContext)_localctx).a = match(TkNum);
				}
				break;
			case 6:
				{
				_localctx = new ReadAExpContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(99);
				((ReadAExpContext)_localctx).a = readA();
				}
				break;
			case 7:
				{
				_localctx = new BoolExpContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(100);
				((BoolExpContext)_localctx).a = _input.LT(1);
				_la = _input.LA(1);
				if ( !(_la==TkTrue || _la==TkFalse) ) {
					((BoolExpContext)_localctx).a = (Token)_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				}
				break;
			}
			_ctx.stop = _input.LT(-1);
			setState(123);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,5,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(121);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,4,_ctx) ) {
					case 1:
						{
						_localctx = new MultExpContext(new ExpContext(_parentctx, _parentState));
						((MultExpContext)_localctx).a = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_exp);
						setState(103);
						if (!(precpred(_ctx, 10))) throw new FailedPredicateException(this, "precpred(_ctx, 10)");
						setState(104);
						((MultExpContext)_localctx).op = match(TkMult);
						setState(105);
						((MultExpContext)_localctx).b = exp(11);
						}
						break;
					case 2:
						{
						_localctx = new MinPlusExpContext(new ExpContext(_parentctx, _parentState));
						((MinPlusExpContext)_localctx).a = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_exp);
						setState(106);
						if (!(precpred(_ctx, 9))) throw new FailedPredicateException(this, "precpred(_ctx, 9)");
						setState(107);
						((MinPlusExpContext)_localctx).op = _input.LT(1);
						_la = _input.LA(1);
						if ( !(_la==TkPlus || _la==TkMinus) ) {
							((MinPlusExpContext)_localctx).op = (Token)_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(108);
						((MinPlusExpContext)_localctx).b = exp(10);
						}
						break;
					case 3:
						{
						_localctx = new OrdExpContext(new ExpContext(_parentctx, _parentState));
						((OrdExpContext)_localctx).a = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_exp);
						setState(109);
						if (!(precpred(_ctx, 8))) throw new FailedPredicateException(this, "precpred(_ctx, 8)");
						setState(110);
						((OrdExpContext)_localctx).op = _input.LT(1);
						_la = _input.LA(1);
						if ( !(((_la) & ~0x3f) == 0 && ((1L << _la) & 231928233984L) != 0) ) {
							((OrdExpContext)_localctx).op = (Token)_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(111);
						((OrdExpContext)_localctx).b = exp(9);
						}
						break;
					case 4:
						{
						_localctx = new EqExpContext(new ExpContext(_parentctx, _parentState));
						((EqExpContext)_localctx).a = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_exp);
						setState(112);
						if (!(precpred(_ctx, 7))) throw new FailedPredicateException(this, "precpred(_ctx, 7)");
						setState(113);
						((EqExpContext)_localctx).op = _input.LT(1);
						_la = _input.LA(1);
						if ( !(_la==TkNEqual || _la==TkEqual) ) {
							((EqExpContext)_localctx).op = (Token)_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(114);
						((EqExpContext)_localctx).b = exp(8);
						}
						break;
					case 5:
						{
						_localctx = new AndExpContext(new ExpContext(_parentctx, _parentState));
						((AndExpContext)_localctx).a = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_exp);
						setState(115);
						if (!(precpred(_ctx, 6))) throw new FailedPredicateException(this, "precpred(_ctx, 6)");
						setState(116);
						((AndExpContext)_localctx).op = match(TkAnd);
						setState(117);
						((AndExpContext)_localctx).b = exp(7);
						}
						break;
					case 6:
						{
						_localctx = new OrExpContext(new ExpContext(_parentctx, _parentState));
						((OrExpContext)_localctx).a = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_exp);
						setState(118);
						if (!(precpred(_ctx, 5))) throw new FailedPredicateException(this, "precpred(_ctx, 5)");
						setState(119);
						((OrExpContext)_localctx).op = match(TkOr);
						setState(120);
						((OrExpContext)_localctx).b = exp(6);
						}
						break;
					}
					} 
				}
				setState(125);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,5,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			unrollRecursionContexts(_parentctx);
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class ConcatenableContext extends ParserRuleContext {
		public TerminalNode TkString() { return getToken(GCLGrammarParser.TkString, 0); }
		public ExpContext exp() {
			return getRuleContext(ExpContext.class,0);
		}
		public ConcatenableContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_concatenable; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GCLGrammarVisitor ) return ((GCLGrammarVisitor<? extends T>)visitor).visitConcatenable(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ConcatenableContext concatenable() throws RecognitionException {
		ConcatenableContext _localctx = new ConcatenableContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_concatenable);
		try {
			setState(128);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case TkString:
				enterOuterAlt(_localctx, 1);
				{
				setState(126);
				match(TkString);
				}
				break;
			case TkOpenPar:
			case TkMinus:
			case TkNot:
			case TkTrue:
			case TkFalse:
			case TkNum:
			case TkId:
				enterOuterAlt(_localctx, 2);
				{
				setState(127);
				exp(0);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class ConcatenationContext extends ParserRuleContext {
		public List<ConcatenableContext> concatenable() {
			return getRuleContexts(ConcatenableContext.class);
		}
		public ConcatenableContext concatenable(int i) {
			return getRuleContext(ConcatenableContext.class,i);
		}
		public TerminalNode TkConcat() { return getToken(GCLGrammarParser.TkConcat, 0); }
		public TerminalNode TkOpenPar() { return getToken(GCLGrammarParser.TkOpenPar, 0); }
		public ConcatenationContext concatenation() {
			return getRuleContext(ConcatenationContext.class,0);
		}
		public TerminalNode TkClosePar() { return getToken(GCLGrammarParser.TkClosePar, 0); }
		public ConcatenationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_concatenation; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GCLGrammarVisitor ) return ((GCLGrammarVisitor<? extends T>)visitor).visitConcatenation(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ConcatenationContext concatenation() throws RecognitionException {
		return concatenation(0);
	}

	private ConcatenationContext concatenation(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		ConcatenationContext _localctx = new ConcatenationContext(_ctx, _parentState);
		ConcatenationContext _prevctx = _localctx;
		int _startState = 12;
		enterRecursionRule(_localctx, 12, RULE_concatenation, _p);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(139);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,7,_ctx) ) {
			case 1:
				{
				setState(131);
				concatenable();
				setState(132);
				match(TkConcat);
				setState(133);
				concatenable();
				}
				break;
			case 2:
				{
				setState(135);
				match(TkOpenPar);
				setState(136);
				concatenation(0);
				setState(137);
				match(TkClosePar);
				}
				break;
			}
			_ctx.stop = _input.LT(-1);
			setState(146);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,8,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					{
					_localctx = new ConcatenationContext(_parentctx, _parentState);
					pushNewRecursionContext(_localctx, _startState, RULE_concatenation);
					setState(141);
					if (!(precpred(_ctx, 2))) throw new FailedPredicateException(this, "precpred(_ctx, 2)");
					setState(142);
					match(TkConcat);
					setState(143);
					concatenable();
					}
					} 
				}
				setState(148);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,8,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			unrollRecursionContexts(_parentctx);
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class AsignableContext extends ParserRuleContext {
		public ExpContext exp() {
			return getRuleContext(ExpContext.class,0);
		}
		public WriteAContext writeA() {
			return getRuleContext(WriteAContext.class,0);
		}
		public AsignableContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_asignable; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GCLGrammarVisitor ) return ((GCLGrammarVisitor<? extends T>)visitor).visitAsignable(this);
			else return visitor.visitChildren(this);
		}
	}

	public final AsignableContext asignable() throws RecognitionException {
		AsignableContext _localctx = new AsignableContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_asignable);
		try {
			setState(151);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,9,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(149);
				exp(0);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(150);
				writeA(0);
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class ArrayInitContext extends ParserRuleContext {
		public List<AsignableContext> asignable() {
			return getRuleContexts(AsignableContext.class);
		}
		public AsignableContext asignable(int i) {
			return getRuleContext(AsignableContext.class,i);
		}
		public TerminalNode TkComma() { return getToken(GCLGrammarParser.TkComma, 0); }
		public ArrayInitContext arrayInit() {
			return getRuleContext(ArrayInitContext.class,0);
		}
		public ArrayInitContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_arrayInit; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GCLGrammarVisitor ) return ((GCLGrammarVisitor<? extends T>)visitor).visitArrayInit(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ArrayInitContext arrayInit() throws RecognitionException {
		return arrayInit(0);
	}

	private ArrayInitContext arrayInit(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		ArrayInitContext _localctx = new ArrayInitContext(_ctx, _parentState);
		ArrayInitContext _prevctx = _localctx;
		int _startState = 16;
		enterRecursionRule(_localctx, 16, RULE_arrayInit, _p);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			{
			setState(154);
			asignable();
			setState(155);
			match(TkComma);
			setState(156);
			asignable();
			}
			_ctx.stop = _input.LT(-1);
			setState(163);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,10,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					{
					_localctx = new ArrayInitContext(_parentctx, _parentState);
					pushNewRecursionContext(_localctx, _startState, RULE_arrayInit);
					setState(158);
					if (!(precpred(_ctx, 2))) throw new FailedPredicateException(this, "precpred(_ctx, 2)");
					setState(159);
					match(TkComma);
					setState(160);
					asignable();
					}
					} 
				}
				setState(165);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,10,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			unrollRecursionContexts(_parentctx);
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class AsignationContext extends ParserRuleContext {
		public TerminalNode TkId() { return getToken(GCLGrammarParser.TkId, 0); }
		public TerminalNode TkAsig() { return getToken(GCLGrammarParser.TkAsig, 0); }
		public AsignableContext asignable() {
			return getRuleContext(AsignableContext.class,0);
		}
		public ArrayInitContext arrayInit() {
			return getRuleContext(ArrayInitContext.class,0);
		}
		public AsignationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_asignation; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GCLGrammarVisitor ) return ((GCLGrammarVisitor<? extends T>)visitor).visitAsignation(this);
			else return visitor.visitChildren(this);
		}
	}

	public final AsignationContext asignation() throws RecognitionException {
		AsignationContext _localctx = new AsignationContext(_ctx, getState());
		enterRule(_localctx, 18, RULE_asignation);
		try {
			setState(172);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,11,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(166);
				match(TkId);
				setState(167);
				match(TkAsig);
				setState(168);
				asignable();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(169);
				match(TkId);
				setState(170);
				match(TkAsig);
				setState(171);
				arrayInit(0);
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class PrinteableContext extends ParserRuleContext {
		public TerminalNode TkString() { return getToken(GCLGrammarParser.TkString, 0); }
		public ConcatenationContext concatenation() {
			return getRuleContext(ConcatenationContext.class,0);
		}
		public ExpContext exp() {
			return getRuleContext(ExpContext.class,0);
		}
		public PrinteableContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_printeable; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GCLGrammarVisitor ) return ((GCLGrammarVisitor<? extends T>)visitor).visitPrinteable(this);
			else return visitor.visitChildren(this);
		}
	}

	public final PrinteableContext printeable() throws RecognitionException {
		PrinteableContext _localctx = new PrinteableContext(_ctx, getState());
		enterRule(_localctx, 20, RULE_printeable);
		try {
			setState(177);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,12,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(174);
				match(TkString);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(175);
				concatenation(0);
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(176);
				exp(0);
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class PrintContext extends ParserRuleContext {
		public TerminalNode TkPrint() { return getToken(GCLGrammarParser.TkPrint, 0); }
		public PrinteableContext printeable() {
			return getRuleContext(PrinteableContext.class,0);
		}
		public PrintContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_print; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GCLGrammarVisitor ) return ((GCLGrammarVisitor<? extends T>)visitor).visitPrint(this);
			else return visitor.visitChildren(this);
		}
	}

	public final PrintContext print() throws RecognitionException {
		PrintContext _localctx = new PrintContext(_ctx, getState());
		enterRule(_localctx, 22, RULE_print);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(179);
			match(TkPrint);
			setState(180);
			printeable();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class TypeContext extends ParserRuleContext {
		public TypeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_type; }
	 
		public TypeContext() { }
		public void copyFrom(TypeContext ctx) {
			super.copyFrom(ctx);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class TBoolContext extends TypeContext {
		public TerminalNode TkBool() { return getToken(GCLGrammarParser.TkBool, 0); }
		public TBoolContext(TypeContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GCLGrammarVisitor ) return ((GCLGrammarVisitor<? extends T>)visitor).visitTBool(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class TIntContext extends TypeContext {
		public TerminalNode TkInt() { return getToken(GCLGrammarParser.TkInt, 0); }
		public TIntContext(TypeContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GCLGrammarVisitor ) return ((GCLGrammarVisitor<? extends T>)visitor).visitTInt(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class TArrayContext extends TypeContext {
		public TerminalNode TkArray() { return getToken(GCLGrammarParser.TkArray, 0); }
		public TerminalNode TkOBracket() { return getToken(GCLGrammarParser.TkOBracket, 0); }
		public List<NumericLitContext> numericLit() {
			return getRuleContexts(NumericLitContext.class);
		}
		public NumericLitContext numericLit(int i) {
			return getRuleContext(NumericLitContext.class,i);
		}
		public TerminalNode TkSoForth() { return getToken(GCLGrammarParser.TkSoForth, 0); }
		public TerminalNode TkCBracket() { return getToken(GCLGrammarParser.TkCBracket, 0); }
		public TArrayContext(TypeContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GCLGrammarVisitor ) return ((GCLGrammarVisitor<? extends T>)visitor).visitTArray(this);
			else return visitor.visitChildren(this);
		}
	}

	public final TypeContext type() throws RecognitionException {
		TypeContext _localctx = new TypeContext(_ctx, getState());
		enterRule(_localctx, 24, RULE_type);
		try {
			setState(191);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case TkInt:
				_localctx = new TIntContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(182);
				match(TkInt);
				}
				break;
			case TkBool:
				_localctx = new TBoolContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(183);
				match(TkBool);
				}
				break;
			case TkArray:
				_localctx = new TArrayContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(184);
				match(TkArray);
				setState(185);
				match(TkOBracket);
				setState(186);
				numericLit();
				setState(187);
				match(TkSoForth);
				setState(188);
				numericLit();
				setState(189);
				match(TkCBracket);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class DeclContext extends ParserRuleContext {
		public TerminalNode TkId() { return getToken(GCLGrammarParser.TkId, 0); }
		public DeclContext decl() {
			return getRuleContext(DeclContext.class,0);
		}
		public TerminalNode TkTwoPoints() { return getToken(GCLGrammarParser.TkTwoPoints, 0); }
		public TypeContext type() {
			return getRuleContext(TypeContext.class,0);
		}
		public TerminalNode TkComma() { return getToken(GCLGrammarParser.TkComma, 0); }
		public DeclContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_decl; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GCLGrammarVisitor ) return ((GCLGrammarVisitor<? extends T>)visitor).visitDecl(this);
			else return visitor.visitChildren(this);
		}
	}

	public final DeclContext decl() throws RecognitionException {
		DeclContext _localctx = new DeclContext(_ctx, getState());
		enterRule(_localctx, 26, RULE_decl);
		try {
			setState(206);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,14,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(193);
				match(TkId);
				setState(194);
				decl();
				setState(195);
				match(TkTwoPoints);
				setState(196);
				type();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(198);
				match(TkId);
				setState(199);
				match(TkTwoPoints);
				setState(200);
				type();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(201);
				match(TkComma);
				setState(202);
				match(TkId);
				setState(203);
				decl();
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(204);
				match(TkComma);
				setState(205);
				match(TkId);
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class ThenContext extends ParserRuleContext {
		public ExpContext exp() {
			return getRuleContext(ExpContext.class,0);
		}
		public ThenContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_then; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GCLGrammarVisitor ) return ((GCLGrammarVisitor<? extends T>)visitor).visitThen(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ThenContext then() throws RecognitionException {
		ThenContext _localctx = new ThenContext(_ctx, getState());
		enterRule(_localctx, 28, RULE_then);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(208);
			exp(0);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class GuardBodyContext extends ParserRuleContext {
		public ThenContext then() {
			return getRuleContext(ThenContext.class,0);
		}
		public TerminalNode TkArrow() { return getToken(GCLGrammarParser.TkArrow, 0); }
		public InstContext inst() {
			return getRuleContext(InstContext.class,0);
		}
		public SeqContext seq() {
			return getRuleContext(SeqContext.class,0);
		}
		public GuardBodyContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_guardBody; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GCLGrammarVisitor ) return ((GCLGrammarVisitor<? extends T>)visitor).visitGuardBody(this);
			else return visitor.visitChildren(this);
		}
	}

	public final GuardBodyContext guardBody() throws RecognitionException {
		GuardBodyContext _localctx = new GuardBodyContext(_ctx, getState());
		enterRule(_localctx, 30, RULE_guardBody);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(210);
			then();
			setState(211);
			match(TkArrow);
			setState(214);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,15,_ctx) ) {
			case 1:
				{
				setState(212);
				inst();
				}
				break;
			case 2:
				{
				setState(213);
				seq(0);
				}
				break;
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class GuardContext extends ParserRuleContext {
		public List<GuardBodyContext> guardBody() {
			return getRuleContexts(GuardBodyContext.class);
		}
		public GuardBodyContext guardBody(int i) {
			return getRuleContext(GuardBodyContext.class,i);
		}
		public TerminalNode TkGuard() { return getToken(GCLGrammarParser.TkGuard, 0); }
		public GuardContext guard() {
			return getRuleContext(GuardContext.class,0);
		}
		public GuardContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_guard; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GCLGrammarVisitor ) return ((GCLGrammarVisitor<? extends T>)visitor).visitGuard(this);
			else return visitor.visitChildren(this);
		}
	}

	public final GuardContext guard() throws RecognitionException {
		return guard(0);
	}

	private GuardContext guard(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		GuardContext _localctx = new GuardContext(_ctx, _parentState);
		GuardContext _prevctx = _localctx;
		int _startState = 32;
		enterRecursionRule(_localctx, 32, RULE_guard, _p);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(222);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,16,_ctx) ) {
			case 1:
				{
				setState(217);
				guardBody();
				setState(218);
				match(TkGuard);
				setState(219);
				guardBody();
				}
				break;
			case 2:
				{
				setState(221);
				guardBody();
				}
				break;
			}
			_ctx.stop = _input.LT(-1);
			setState(229);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,17,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					{
					_localctx = new GuardContext(_parentctx, _parentState);
					pushNewRecursionContext(_localctx, _startState, RULE_guard);
					setState(224);
					if (!(precpred(_ctx, 3))) throw new FailedPredicateException(this, "precpred(_ctx, 3)");
					setState(225);
					match(TkGuard);
					setState(226);
					guardBody();
					}
					} 
				}
				setState(231);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,17,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			unrollRecursionContexts(_parentctx);
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class IfOpContext extends ParserRuleContext {
		public TerminalNode TkIf() { return getToken(GCLGrammarParser.TkIf, 0); }
		public GuardContext guard() {
			return getRuleContext(GuardContext.class,0);
		}
		public TerminalNode TkFi() { return getToken(GCLGrammarParser.TkFi, 0); }
		public IfOpContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_ifOp; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GCLGrammarVisitor ) return ((GCLGrammarVisitor<? extends T>)visitor).visitIfOp(this);
			else return visitor.visitChildren(this);
		}
	}

	public final IfOpContext ifOp() throws RecognitionException {
		IfOpContext _localctx = new IfOpContext(_ctx, getState());
		enterRule(_localctx, 34, RULE_ifOp);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(232);
			match(TkIf);
			setState(233);
			guard(0);
			setState(234);
			match(TkFi);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class InContext extends ParserRuleContext {
		public TerminalNode TkId() { return getToken(GCLGrammarParser.TkId, 0); }
		public TerminalNode TkIn() { return getToken(GCLGrammarParser.TkIn, 0); }
		public ExpContext exp() {
			return getRuleContext(ExpContext.class,0);
		}
		public InContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_in; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GCLGrammarVisitor ) return ((GCLGrammarVisitor<? extends T>)visitor).visitIn(this);
			else return visitor.visitChildren(this);
		}
	}

	public final InContext in() throws RecognitionException {
		InContext _localctx = new InContext(_ctx, getState());
		enterRule(_localctx, 36, RULE_in);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(236);
			match(TkId);
			setState(237);
			match(TkIn);
			setState(238);
			exp(0);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class ToContext extends ParserRuleContext {
		public TerminalNode TkTo() { return getToken(GCLGrammarParser.TkTo, 0); }
		public ExpContext exp() {
			return getRuleContext(ExpContext.class,0);
		}
		public ToContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_to; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GCLGrammarVisitor ) return ((GCLGrammarVisitor<? extends T>)visitor).visitTo(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ToContext to() throws RecognitionException {
		ToContext _localctx = new ToContext(_ctx, getState());
		enterRule(_localctx, 38, RULE_to);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(240);
			match(TkTo);
			setState(241);
			exp(0);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class ForOpContext extends ParserRuleContext {
		public TerminalNode TkFor() { return getToken(GCLGrammarParser.TkFor, 0); }
		public InContext in() {
			return getRuleContext(InContext.class,0);
		}
		public ToContext to() {
			return getRuleContext(ToContext.class,0);
		}
		public TerminalNode TkArrow() { return getToken(GCLGrammarParser.TkArrow, 0); }
		public TerminalNode TkRof() { return getToken(GCLGrammarParser.TkRof, 0); }
		public InstContext inst() {
			return getRuleContext(InstContext.class,0);
		}
		public SeqContext seq() {
			return getRuleContext(SeqContext.class,0);
		}
		public ForOpContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_forOp; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GCLGrammarVisitor ) return ((GCLGrammarVisitor<? extends T>)visitor).visitForOp(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ForOpContext forOp() throws RecognitionException {
		ForOpContext _localctx = new ForOpContext(_ctx, getState());
		enterRule(_localctx, 40, RULE_forOp);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(243);
			match(TkFor);
			setState(244);
			in();
			setState(245);
			to();
			setState(246);
			match(TkArrow);
			setState(249);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,18,_ctx) ) {
			case 1:
				{
				setState(247);
				inst();
				}
				break;
			case 2:
				{
				setState(248);
				seq(0);
				}
				break;
			}
			setState(251);
			match(TkRof);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class DoOpContext extends ParserRuleContext {
		public TerminalNode TkDo() { return getToken(GCLGrammarParser.TkDo, 0); }
		public GuardContext guard() {
			return getRuleContext(GuardContext.class,0);
		}
		public TerminalNode TkOd() { return getToken(GCLGrammarParser.TkOd, 0); }
		public DoOpContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_doOp; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GCLGrammarVisitor ) return ((GCLGrammarVisitor<? extends T>)visitor).visitDoOp(this);
			else return visitor.visitChildren(this);
		}
	}

	public final DoOpContext doOp() throws RecognitionException {
		DoOpContext _localctx = new DoOpContext(_ctx, getState());
		enterRule(_localctx, 42, RULE_doOp);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(253);
			match(TkDo);
			setState(254);
			guard(0);
			setState(255);
			match(TkOd);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class SeqDeclContext extends ParserRuleContext {
		public List<DeclContext> decl() {
			return getRuleContexts(DeclContext.class);
		}
		public DeclContext decl(int i) {
			return getRuleContext(DeclContext.class,i);
		}
		public TerminalNode TkSemicolon() { return getToken(GCLGrammarParser.TkSemicolon, 0); }
		public SeqDeclContext seqDecl() {
			return getRuleContext(SeqDeclContext.class,0);
		}
		public SeqDeclContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_seqDecl; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GCLGrammarVisitor ) return ((GCLGrammarVisitor<? extends T>)visitor).visitSeqDecl(this);
			else return visitor.visitChildren(this);
		}
	}

	public final SeqDeclContext seqDecl() throws RecognitionException {
		return seqDecl(0);
	}

	private SeqDeclContext seqDecl(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		SeqDeclContext _localctx = new SeqDeclContext(_ctx, _parentState);
		SeqDeclContext _prevctx = _localctx;
		int _startState = 44;
		enterRecursionRule(_localctx, 44, RULE_seqDecl, _p);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			{
			setState(258);
			decl();
			setState(259);
			match(TkSemicolon);
			setState(260);
			decl();
			}
			_ctx.stop = _input.LT(-1);
			setState(267);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,19,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					{
					_localctx = new SeqDeclContext(_parentctx, _parentState);
					pushNewRecursionContext(_localctx, _startState, RULE_seqDecl);
					setState(262);
					if (!(precpred(_ctx, 1))) throw new FailedPredicateException(this, "precpred(_ctx, 1)");
					setState(263);
					match(TkSemicolon);
					setState(264);
					decl();
					}
					} 
				}
				setState(269);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,19,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			unrollRecursionContexts(_parentctx);
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class InstContext extends ParserRuleContext {
		public ForOpContext forOp() {
			return getRuleContext(ForOpContext.class,0);
		}
		public IfOpContext ifOp() {
			return getRuleContext(IfOpContext.class,0);
		}
		public DoOpContext doOp() {
			return getRuleContext(DoOpContext.class,0);
		}
		public AsignationContext asignation() {
			return getRuleContext(AsignationContext.class,0);
		}
		public PrintContext print() {
			return getRuleContext(PrintContext.class,0);
		}
		public BlockContext block() {
			return getRuleContext(BlockContext.class,0);
		}
		public TerminalNode TkSkip() { return getToken(GCLGrammarParser.TkSkip, 0); }
		public InstContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_inst; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GCLGrammarVisitor ) return ((GCLGrammarVisitor<? extends T>)visitor).visitInst(this);
			else return visitor.visitChildren(this);
		}
	}

	public final InstContext inst() throws RecognitionException {
		InstContext _localctx = new InstContext(_ctx, getState());
		enterRule(_localctx, 46, RULE_inst);
		try {
			setState(277);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case TkFor:
				enterOuterAlt(_localctx, 1);
				{
				setState(270);
				forOp();
				}
				break;
			case TkIf:
				enterOuterAlt(_localctx, 2);
				{
				setState(271);
				ifOp();
				}
				break;
			case TkDo:
				enterOuterAlt(_localctx, 3);
				{
				setState(272);
				doOp();
				}
				break;
			case TkId:
				enterOuterAlt(_localctx, 4);
				{
				setState(273);
				asignation();
				}
				break;
			case TkPrint:
				enterOuterAlt(_localctx, 5);
				{
				setState(274);
				print();
				}
				break;
			case TkOBlock:
				enterOuterAlt(_localctx, 6);
				{
				setState(275);
				block();
				}
				break;
			case TkSkip:
				enterOuterAlt(_localctx, 7);
				{
				setState(276);
				match(TkSkip);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class SeqContext extends ParserRuleContext {
		public List<InstContext> inst() {
			return getRuleContexts(InstContext.class);
		}
		public InstContext inst(int i) {
			return getRuleContext(InstContext.class,i);
		}
		public TerminalNode TkSemicolon() { return getToken(GCLGrammarParser.TkSemicolon, 0); }
		public SeqContext seq() {
			return getRuleContext(SeqContext.class,0);
		}
		public SeqContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_seq; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GCLGrammarVisitor ) return ((GCLGrammarVisitor<? extends T>)visitor).visitSeq(this);
			else return visitor.visitChildren(this);
		}
	}

	public final SeqContext seq() throws RecognitionException {
		return seq(0);
	}

	private SeqContext seq(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		SeqContext _localctx = new SeqContext(_ctx, _parentState);
		SeqContext _prevctx = _localctx;
		int _startState = 48;
		enterRecursionRule(_localctx, 48, RULE_seq, _p);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			{
			setState(280);
			inst();
			setState(281);
			match(TkSemicolon);
			setState(282);
			inst();
			}
			_ctx.stop = _input.LT(-1);
			setState(289);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,21,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					{
					_localctx = new SeqContext(_parentctx, _parentState);
					pushNewRecursionContext(_localctx, _startState, RULE_seq);
					setState(284);
					if (!(precpred(_ctx, 1))) throw new FailedPredicateException(this, "precpred(_ctx, 1)");
					setState(285);
					match(TkSemicolon);
					setState(286);
					inst();
					}
					} 
				}
				setState(291);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,21,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			unrollRecursionContexts(_parentctx);
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class DeclarationBlockContext extends ParserRuleContext {
		public TerminalNode TkDeclare() { return getToken(GCLGrammarParser.TkDeclare, 0); }
		public DeclContext decl() {
			return getRuleContext(DeclContext.class,0);
		}
		public SeqDeclContext seqDecl() {
			return getRuleContext(SeqDeclContext.class,0);
		}
		public DeclarationBlockContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_declarationBlock; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GCLGrammarVisitor ) return ((GCLGrammarVisitor<? extends T>)visitor).visitDeclarationBlock(this);
			else return visitor.visitChildren(this);
		}
	}

	public final DeclarationBlockContext declarationBlock() throws RecognitionException {
		DeclarationBlockContext _localctx = new DeclarationBlockContext(_ctx, getState());
		enterRule(_localctx, 50, RULE_declarationBlock);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(292);
			match(TkDeclare);
			setState(295);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,22,_ctx) ) {
			case 1:
				{
				setState(293);
				decl();
				}
				break;
			case 2:
				{
				setState(294);
				seqDecl(0);
				}
				break;
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class BlockContext extends ParserRuleContext {
		public TerminalNode TkOBlock() { return getToken(GCLGrammarParser.TkOBlock, 0); }
		public DeclarationBlockContext declarationBlock() {
			return getRuleContext(DeclarationBlockContext.class,0);
		}
		public TerminalNode TkCBlock() { return getToken(GCLGrammarParser.TkCBlock, 0); }
		public InstContext inst() {
			return getRuleContext(InstContext.class,0);
		}
		public SeqContext seq() {
			return getRuleContext(SeqContext.class,0);
		}
		public BlockContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_block; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GCLGrammarVisitor ) return ((GCLGrammarVisitor<? extends T>)visitor).visitBlock(this);
			else return visitor.visitChildren(this);
		}
	}

	public final BlockContext block() throws RecognitionException {
		BlockContext _localctx = new BlockContext(_ctx, getState());
		enterRule(_localctx, 52, RULE_block);
		try {
			setState(312);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,25,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(297);
				match(TkOBlock);
				setState(298);
				declarationBlock();
				setState(301);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,23,_ctx) ) {
				case 1:
					{
					setState(299);
					inst();
					}
					break;
				case 2:
					{
					setState(300);
					seq(0);
					}
					break;
				}
				setState(303);
				match(TkCBlock);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(305);
				match(TkOBlock);
				setState(308);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,24,_ctx) ) {
				case 1:
					{
					setState(306);
					inst();
					}
					break;
				case 2:
					{
					setState(307);
					seq(0);
					}
					break;
				}
				setState(310);
				match(TkCBlock);
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public boolean sempred(RuleContext _localctx, int ruleIndex, int predIndex) {
		switch (ruleIndex) {
		case 1:
			return writeA_sempred((WriteAContext)_localctx, predIndex);
		case 4:
			return exp_sempred((ExpContext)_localctx, predIndex);
		case 6:
			return concatenation_sempred((ConcatenationContext)_localctx, predIndex);
		case 8:
			return arrayInit_sempred((ArrayInitContext)_localctx, predIndex);
		case 16:
			return guard_sempred((GuardContext)_localctx, predIndex);
		case 22:
			return seqDecl_sempred((SeqDeclContext)_localctx, predIndex);
		case 24:
			return seq_sempred((SeqContext)_localctx, predIndex);
		}
		return true;
	}
	private boolean writeA_sempred(WriteAContext _localctx, int predIndex) {
		switch (predIndex) {
		case 0:
			return precpred(_ctx, 1);
		}
		return true;
	}
	private boolean exp_sempred(ExpContext _localctx, int predIndex) {
		switch (predIndex) {
		case 1:
			return precpred(_ctx, 10);
		case 2:
			return precpred(_ctx, 9);
		case 3:
			return precpred(_ctx, 8);
		case 4:
			return precpred(_ctx, 7);
		case 5:
			return precpred(_ctx, 6);
		case 6:
			return precpred(_ctx, 5);
		}
		return true;
	}
	private boolean concatenation_sempred(ConcatenationContext _localctx, int predIndex) {
		switch (predIndex) {
		case 7:
			return precpred(_ctx, 2);
		}
		return true;
	}
	private boolean arrayInit_sempred(ArrayInitContext _localctx, int predIndex) {
		switch (predIndex) {
		case 8:
			return precpred(_ctx, 2);
		}
		return true;
	}
	private boolean guard_sempred(GuardContext _localctx, int predIndex) {
		switch (predIndex) {
		case 9:
			return precpred(_ctx, 3);
		}
		return true;
	}
	private boolean seqDecl_sempred(SeqDeclContext _localctx, int predIndex) {
		switch (predIndex) {
		case 10:
			return precpred(_ctx, 1);
		}
		return true;
	}
	private boolean seq_sempred(SeqContext _localctx, int predIndex) {
		switch (predIndex) {
		case 11:
			return precpred(_ctx, 1);
		}
		return true;
	}

	public static final String _serializedATN =
		"\u0004\u0001/\u013b\u0002\u0000\u0007\u0000\u0002\u0001\u0007\u0001\u0002"+
		"\u0002\u0007\u0002\u0002\u0003\u0007\u0003\u0002\u0004\u0007\u0004\u0002"+
		"\u0005\u0007\u0005\u0002\u0006\u0007\u0006\u0002\u0007\u0007\u0007\u0002"+
		"\b\u0007\b\u0002\t\u0007\t\u0002\n\u0007\n\u0002\u000b\u0007\u000b\u0002"+
		"\f\u0007\f\u0002\r\u0007\r\u0002\u000e\u0007\u000e\u0002\u000f\u0007\u000f"+
		"\u0002\u0010\u0007\u0010\u0002\u0011\u0007\u0011\u0002\u0012\u0007\u0012"+
		"\u0002\u0013\u0007\u0013\u0002\u0014\u0007\u0014\u0002\u0015\u0007\u0015"+
		"\u0002\u0016\u0007\u0016\u0002\u0017\u0007\u0017\u0002\u0018\u0007\u0018"+
		"\u0002\u0019\u0007\u0019\u0002\u001a\u0007\u001a\u0001\u0000\u0001\u0000"+
		"\u0001\u0000\u0001\u0000\u0001\u0000\u0001\u0000\u0001\u0001\u0001\u0001"+
		"\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0005\u0001C\b\u0001"+
		"\n\u0001\f\u0001F\t\u0001\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002"+
		"\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002"+
		"\u0003\u0002R\b\u0002\u0001\u0003\u0001\u0003\u0001\u0003\u0003\u0003"+
		"W\b\u0003\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004"+
		"\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004"+
		"\u0001\u0004\u0001\u0004\u0003\u0004f\b\u0004\u0001\u0004\u0001\u0004"+
		"\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004"+
		"\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004"+
		"\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0005\u0004z\b\u0004"+
		"\n\u0004\f\u0004}\t\u0004\u0001\u0005\u0001\u0005\u0003\u0005\u0081\b"+
		"\u0005\u0001\u0006\u0001\u0006\u0001\u0006\u0001\u0006\u0001\u0006\u0001"+
		"\u0006\u0001\u0006\u0001\u0006\u0001\u0006\u0003\u0006\u008c\b\u0006\u0001"+
		"\u0006\u0001\u0006\u0001\u0006\u0005\u0006\u0091\b\u0006\n\u0006\f\u0006"+
		"\u0094\t\u0006\u0001\u0007\u0001\u0007\u0003\u0007\u0098\b\u0007\u0001"+
		"\b\u0001\b\u0001\b\u0001\b\u0001\b\u0001\b\u0001\b\u0001\b\u0005\b\u00a2"+
		"\b\b\n\b\f\b\u00a5\t\b\u0001\t\u0001\t\u0001\t\u0001\t\u0001\t\u0001\t"+
		"\u0003\t\u00ad\b\t\u0001\n\u0001\n\u0001\n\u0003\n\u00b2\b\n\u0001\u000b"+
		"\u0001\u000b\u0001\u000b\u0001\f\u0001\f\u0001\f\u0001\f\u0001\f\u0001"+
		"\f\u0001\f\u0001\f\u0001\f\u0003\f\u00c0\b\f\u0001\r\u0001\r\u0001\r\u0001"+
		"\r\u0001\r\u0001\r\u0001\r\u0001\r\u0001\r\u0001\r\u0001\r\u0001\r\u0001"+
		"\r\u0003\r\u00cf\b\r\u0001\u000e\u0001\u000e\u0001\u000f\u0001\u000f\u0001"+
		"\u000f\u0001\u000f\u0003\u000f\u00d7\b\u000f\u0001\u0010\u0001\u0010\u0001"+
		"\u0010\u0001\u0010\u0001\u0010\u0001\u0010\u0003\u0010\u00df\b\u0010\u0001"+
		"\u0010\u0001\u0010\u0001\u0010\u0005\u0010\u00e4\b\u0010\n\u0010\f\u0010"+
		"\u00e7\t\u0010\u0001\u0011\u0001\u0011\u0001\u0011\u0001\u0011\u0001\u0012"+
		"\u0001\u0012\u0001\u0012\u0001\u0012\u0001\u0013\u0001\u0013\u0001\u0013"+
		"\u0001\u0014\u0001\u0014\u0001\u0014\u0001\u0014\u0001\u0014\u0001\u0014"+
		"\u0003\u0014\u00fa\b\u0014\u0001\u0014\u0001\u0014\u0001\u0015\u0001\u0015"+
		"\u0001\u0015\u0001\u0015\u0001\u0016\u0001\u0016\u0001\u0016\u0001\u0016"+
		"\u0001\u0016\u0001\u0016\u0001\u0016\u0001\u0016\u0005\u0016\u010a\b\u0016"+
		"\n\u0016\f\u0016\u010d\t\u0016\u0001\u0017\u0001\u0017\u0001\u0017\u0001"+
		"\u0017\u0001\u0017\u0001\u0017\u0001\u0017\u0003\u0017\u0116\b\u0017\u0001"+
		"\u0018\u0001\u0018\u0001\u0018\u0001\u0018\u0001\u0018\u0001\u0018\u0001"+
		"\u0018\u0001\u0018\u0005\u0018\u0120\b\u0018\n\u0018\f\u0018\u0123\t\u0018"+
		"\u0001\u0019\u0001\u0019\u0001\u0019\u0003\u0019\u0128\b\u0019\u0001\u001a"+
		"\u0001\u001a\u0001\u001a\u0001\u001a\u0003\u001a\u012e\b\u001a\u0001\u001a"+
		"\u0001\u001a\u0001\u001a\u0001\u001a\u0001\u001a\u0003\u001a\u0135\b\u001a"+
		"\u0001\u001a\u0001\u001a\u0003\u001a\u0139\b\u001a\u0001\u001a\u0000\u0007"+
		"\u0002\b\f\u0010 ,0\u001b\u0000\u0002\u0004\u0006\b\n\f\u000e\u0010\u0012"+
		"\u0014\u0016\u0018\u001a\u001c\u001e \"$&(*,.024\u0000\u0004\u0001\u0000"+
		")*\u0001\u0000\u001c\u001d\u0002\u0000!\"$%\u0002\u0000##&&\u014b\u0000"+
		"6\u0001\u0000\u0000\u0000\u0002<\u0001\u0000\u0000\u0000\u0004Q\u0001"+
		"\u0000\u0000\u0000\u0006V\u0001\u0000\u0000\u0000\be\u0001\u0000\u0000"+
		"\u0000\n\u0080\u0001\u0000\u0000\u0000\f\u008b\u0001\u0000\u0000\u0000"+
		"\u000e\u0097\u0001\u0000\u0000\u0000\u0010\u0099\u0001\u0000\u0000\u0000"+
		"\u0012\u00ac\u0001\u0000\u0000\u0000\u0014\u00b1\u0001\u0000\u0000\u0000"+
		"\u0016\u00b3\u0001\u0000\u0000\u0000\u0018\u00bf\u0001\u0000\u0000\u0000"+
		"\u001a\u00ce\u0001\u0000\u0000\u0000\u001c\u00d0\u0001\u0000\u0000\u0000"+
		"\u001e\u00d2\u0001\u0000\u0000\u0000 \u00de\u0001\u0000\u0000\u0000\""+
		"\u00e8\u0001\u0000\u0000\u0000$\u00ec\u0001\u0000\u0000\u0000&\u00f0\u0001"+
		"\u0000\u0000\u0000(\u00f3\u0001\u0000\u0000\u0000*\u00fd\u0001\u0000\u0000"+
		"\u0000,\u0101\u0001\u0000\u0000\u0000.\u0115\u0001\u0000\u0000\u00000"+
		"\u0117\u0001\u0000\u0000\u00002\u0124\u0001\u0000\u0000\u00004\u0138\u0001"+
		"\u0000\u0000\u000067\u0005\u0010\u0000\u000078\u0003\b\u0004\u000089\u0005"+
		" \u0000\u00009:\u0003\b\u0004\u0000:;\u0005\u0011\u0000\u0000;\u0001\u0001"+
		"\u0000\u0000\u0000<=\u0006\u0001\uffff\uffff\u0000=>\u0005-\u0000\u0000"+
		">?\u0003\u0000\u0000\u0000?D\u0001\u0000\u0000\u0000@A\n\u0001\u0000\u0000"+
		"AC\u0003\u0000\u0000\u0000B@\u0001\u0000\u0000\u0000CF\u0001\u0000\u0000"+
		"\u0000DB\u0001\u0000\u0000\u0000DE\u0001\u0000\u0000\u0000E\u0003\u0001"+
		"\u0000\u0000\u0000FD\u0001\u0000\u0000\u0000GH\u0003\u0002\u0001\u0000"+
		"HI\u0005\u001a\u0000\u0000IJ\u0003\b\u0004\u0000JK\u0005\u001b\u0000\u0000"+
		"KR\u0001\u0000\u0000\u0000LM\u0005-\u0000\u0000MN\u0005\u001a\u0000\u0000"+
		"NO\u0003\b\u0004\u0000OP\u0005\u001b\u0000\u0000PR\u0001\u0000\u0000\u0000"+
		"QG\u0001\u0000\u0000\u0000QL\u0001\u0000\u0000\u0000R\u0005\u0001\u0000"+
		"\u0000\u0000ST\u0005\u001d\u0000\u0000TW\u0003\u0006\u0003\u0000UW\u0005"+
		"+\u0000\u0000VS\u0001\u0000\u0000\u0000VU\u0001\u0000\u0000\u0000W\u0007"+
		"\u0001\u0000\u0000\u0000XY\u0006\u0004\uffff\uffff\u0000YZ\u0005\u0010"+
		"\u0000\u0000Z[\u0003\b\u0004\u0000[\\\u0005\u0011\u0000\u0000\\f\u0001"+
		"\u0000\u0000\u0000]^\u0005\u001d\u0000\u0000^f\u0003\b\u0004\f_`\u0005"+
		"\u001f\u0000\u0000`f\u0003\b\u0004\u000baf\u0005-\u0000\u0000bf\u0005"+
		"+\u0000\u0000cf\u0003\u0004\u0002\u0000df\u0007\u0000\u0000\u0000eX\u0001"+
		"\u0000\u0000\u0000e]\u0001\u0000\u0000\u0000e_\u0001\u0000\u0000\u0000"+
		"ea\u0001\u0000\u0000\u0000eb\u0001\u0000\u0000\u0000ec\u0001\u0000\u0000"+
		"\u0000ed\u0001\u0000\u0000\u0000f{\u0001\u0000\u0000\u0000gh\n\n\u0000"+
		"\u0000hi\u0005\u001e\u0000\u0000iz\u0003\b\u0004\u000bjk\n\t\u0000\u0000"+
		"kl\u0007\u0001\u0000\u0000lz\u0003\b\u0004\nmn\n\b\u0000\u0000no\u0007"+
		"\u0002\u0000\u0000oz\u0003\b\u0004\tpq\n\u0007\u0000\u0000qr\u0007\u0003"+
		"\u0000\u0000rz\u0003\b\u0004\bst\n\u0006\u0000\u0000tu\u0005(\u0000\u0000"+
		"uz\u0003\b\u0004\u0007vw\n\u0005\u0000\u0000wx\u0005\'\u0000\u0000xz\u0003"+
		"\b\u0004\u0006yg\u0001\u0000\u0000\u0000yj\u0001\u0000\u0000\u0000ym\u0001"+
		"\u0000\u0000\u0000yp\u0001\u0000\u0000\u0000ys\u0001\u0000\u0000\u0000"+
		"yv\u0001\u0000\u0000\u0000z}\u0001\u0000\u0000\u0000{y\u0001\u0000\u0000"+
		"\u0000{|\u0001\u0000\u0000\u0000|\t\u0001\u0000\u0000\u0000}{\u0001\u0000"+
		"\u0000\u0000~\u0081\u0005,\u0000\u0000\u007f\u0081\u0003\b\u0004\u0000"+
		"\u0080~\u0001\u0000\u0000\u0000\u0080\u007f\u0001\u0000\u0000\u0000\u0081"+
		"\u000b\u0001\u0000\u0000\u0000\u0082\u0083\u0006\u0006\uffff\uffff\u0000"+
		"\u0083\u0084\u0003\n\u0005\u0000\u0084\u0085\u0005\u0019\u0000\u0000\u0085"+
		"\u0086\u0003\n\u0005\u0000\u0086\u008c\u0001\u0000\u0000\u0000\u0087\u0088"+
		"\u0005\u0010\u0000\u0000\u0088\u0089\u0003\f\u0006\u0000\u0089\u008a\u0005"+
		"\u0011\u0000\u0000\u008a\u008c\u0001\u0000\u0000\u0000\u008b\u0082\u0001"+
		"\u0000\u0000\u0000\u008b\u0087\u0001\u0000\u0000\u0000\u008c\u0092\u0001"+
		"\u0000\u0000\u0000\u008d\u008e\n\u0002\u0000\u0000\u008e\u008f\u0005\u0019"+
		"\u0000\u0000\u008f\u0091\u0003\n\u0005\u0000\u0090\u008d\u0001\u0000\u0000"+
		"\u0000\u0091\u0094\u0001\u0000\u0000\u0000\u0092\u0090\u0001\u0000\u0000"+
		"\u0000\u0092\u0093\u0001\u0000\u0000\u0000\u0093\r\u0001\u0000\u0000\u0000"+
		"\u0094\u0092\u0001\u0000\u0000\u0000\u0095\u0098\u0003\b\u0004\u0000\u0096"+
		"\u0098\u0003\u0002\u0001\u0000\u0097\u0095\u0001\u0000\u0000\u0000\u0097"+
		"\u0096\u0001\u0000\u0000\u0000\u0098\u000f\u0001\u0000\u0000\u0000\u0099"+
		"\u009a\u0006\b\uffff\uffff\u0000\u009a\u009b\u0003\u000e\u0007\u0000\u009b"+
		"\u009c\u0005\u000f\u0000\u0000\u009c\u009d\u0003\u000e\u0007\u0000\u009d"+
		"\u00a3\u0001\u0000\u0000\u0000\u009e\u009f\n\u0002\u0000\u0000\u009f\u00a0"+
		"\u0005\u000f\u0000\u0000\u00a0\u00a2\u0003\u000e\u0007\u0000\u00a1\u009e"+
		"\u0001\u0000\u0000\u0000\u00a2\u00a5\u0001\u0000\u0000\u0000\u00a3\u00a1"+
		"\u0001\u0000\u0000\u0000\u00a3\u00a4\u0001\u0000\u0000\u0000\u00a4\u0011"+
		"\u0001\u0000\u0000\u0000\u00a5\u00a3\u0001\u0000\u0000\u0000\u00a6\u00a7"+
		"\u0005-\u0000\u0000\u00a7\u00a8\u0005\u0016\u0000\u0000\u00a8\u00ad\u0003"+
		"\u000e\u0007\u0000\u00a9\u00aa\u0005-\u0000\u0000\u00aa\u00ab\u0005\u0016"+
		"\u0000\u0000\u00ab\u00ad\u0003\u0010\b\u0000\u00ac\u00a6\u0001\u0000\u0000"+
		"\u0000\u00ac\u00a9\u0001\u0000\u0000\u0000\u00ad\u0013\u0001\u0000\u0000"+
		"\u0000\u00ae\u00b2\u0005,\u0000\u0000\u00af\u00b2\u0003\f\u0006\u0000"+
		"\u00b0\u00b2\u0003\b\u0004\u0000\u00b1\u00ae\u0001\u0000\u0000\u0000\u00b1"+
		"\u00af\u0001\u0000\u0000\u0000\u00b1\u00b0\u0001\u0000\u0000\u0000\u00b2"+
		"\u0015\u0001\u0000\u0000\u0000\u00b3\u00b4\u0005\r\u0000\u0000\u00b4\u00b5"+
		"\u0003\u0014\n\u0000\u00b5\u0017\u0001\u0000\u0000\u0000\u00b6\u00c0\u0005"+
		"\u0007\u0000\u0000\u00b7\u00c0\u0005\b\u0000\u0000\u00b8\u00b9\u0005\u000b"+
		"\u0000\u0000\u00b9\u00ba\u0005\u001a\u0000\u0000\u00ba\u00bb\u0003\u0006"+
		"\u0003\u0000\u00bb\u00bc\u0005\u0015\u0000\u0000\u00bc\u00bd\u0003\u0006"+
		"\u0003\u0000\u00bd\u00be\u0005\u001b\u0000\u0000\u00be\u00c0\u0001\u0000"+
		"\u0000\u0000\u00bf\u00b6\u0001\u0000\u0000\u0000\u00bf\u00b7\u0001\u0000"+
		"\u0000\u0000\u00bf\u00b8\u0001\u0000\u0000\u0000\u00c0\u0019\u0001\u0000"+
		"\u0000\u0000\u00c1\u00c2\u0005-\u0000\u0000\u00c2\u00c3\u0003\u001a\r"+
		"\u0000\u00c3\u00c4\u0005 \u0000\u0000\u00c4\u00c5\u0003\u0018\f\u0000"+
		"\u00c5\u00cf\u0001\u0000\u0000\u0000\u00c6\u00c7\u0005-\u0000\u0000\u00c7"+
		"\u00c8\u0005 \u0000\u0000\u00c8\u00cf\u0003\u0018\f\u0000\u00c9\u00ca"+
		"\u0005\u000f\u0000\u0000\u00ca\u00cb\u0005-\u0000\u0000\u00cb\u00cf\u0003"+
		"\u001a\r\u0000\u00cc\u00cd\u0005\u000f\u0000\u0000\u00cd\u00cf\u0005-"+
		"\u0000\u0000\u00ce\u00c1\u0001\u0000\u0000\u0000\u00ce\u00c6\u0001\u0000"+
		"\u0000\u0000\u00ce\u00c9\u0001\u0000\u0000\u0000\u00ce\u00cc\u0001\u0000"+
		"\u0000\u0000\u00cf\u001b\u0001\u0000\u0000\u0000\u00d0\u00d1\u0003\b\u0004"+
		"\u0000\u00d1\u001d\u0001\u0000\u0000\u0000\u00d2\u00d3\u0003\u001c\u000e"+
		"\u0000\u00d3\u00d6\u0005\u0017\u0000\u0000\u00d4\u00d7\u0003.\u0017\u0000"+
		"\u00d5\u00d7\u00030\u0018\u0000\u00d6\u00d4\u0001\u0000\u0000\u0000\u00d6"+
		"\u00d5\u0001\u0000\u0000\u0000\u00d7\u001f\u0001\u0000\u0000\u0000\u00d8"+
		"\u00d9\u0006\u0010\uffff\uffff\u0000\u00d9\u00da\u0003\u001e\u000f\u0000"+
		"\u00da\u00db\u0005\u0018\u0000\u0000\u00db\u00dc\u0003\u001e\u000f\u0000"+
		"\u00dc\u00df\u0001\u0000\u0000\u0000\u00dd\u00df\u0003\u001e\u000f\u0000"+
		"\u00de\u00d8\u0001\u0000\u0000\u0000\u00de\u00dd\u0001\u0000\u0000\u0000"+
		"\u00df\u00e5\u0001\u0000\u0000\u0000\u00e0\u00e1\n\u0003\u0000\u0000\u00e1"+
		"\u00e2\u0005\u0018\u0000\u0000\u00e2\u00e4\u0003\u001e\u000f\u0000\u00e3"+
		"\u00e0\u0001\u0000\u0000\u0000\u00e4\u00e7\u0001\u0000\u0000\u0000\u00e5"+
		"\u00e3\u0001\u0000\u0000\u0000\u00e5\u00e6\u0001\u0000\u0000\u0000\u00e6"+
		"!\u0001\u0000\u0000\u0000\u00e7\u00e5\u0001\u0000\u0000\u0000\u00e8\u00e9"+
		"\u0005\u0001\u0000\u0000\u00e9\u00ea\u0003 \u0010\u0000\u00ea\u00eb\u0005"+
		"\u0002\u0000\u0000\u00eb#\u0001\u0000\u0000\u0000\u00ec\u00ed\u0005-\u0000"+
		"\u0000\u00ed\u00ee\u0005\u0006\u0000\u0000\u00ee\u00ef\u0003\b\u0004\u0000"+
		"\u00ef%\u0001\u0000\u0000\u0000\u00f0\u00f1\u0005\u0005\u0000\u0000\u00f1"+
		"\u00f2\u0003\b\u0004\u0000\u00f2\'\u0001\u0000\u0000\u0000\u00f3\u00f4"+
		"\u0005\t\u0000\u0000\u00f4\u00f5\u0003$\u0012\u0000\u00f5\u00f6\u0003"+
		"&\u0013\u0000\u00f6\u00f9\u0005\u0017\u0000\u0000\u00f7\u00fa\u0003.\u0017"+
		"\u0000\u00f8\u00fa\u00030\u0018\u0000\u00f9\u00f7\u0001\u0000\u0000\u0000"+
		"\u00f9\u00f8\u0001\u0000\u0000\u0000\u00fa\u00fb\u0001\u0000\u0000\u0000"+
		"\u00fb\u00fc\u0005\n\u0000\u0000\u00fc)\u0001\u0000\u0000\u0000\u00fd"+
		"\u00fe\u0005\u0003\u0000\u0000\u00fe\u00ff\u0003 \u0010\u0000\u00ff\u0100"+
		"\u0005\u0004\u0000\u0000\u0100+\u0001\u0000\u0000\u0000\u0101\u0102\u0006"+
		"\u0016\uffff\uffff\u0000\u0102\u0103\u0003\u001a\r\u0000\u0103\u0104\u0005"+
		"\u0012\u0000\u0000\u0104\u0105\u0003\u001a\r\u0000\u0105\u010b\u0001\u0000"+
		"\u0000\u0000\u0106\u0107\n\u0001\u0000\u0000\u0107\u0108\u0005\u0012\u0000"+
		"\u0000\u0108\u010a\u0003\u001a\r\u0000\u0109\u0106\u0001\u0000\u0000\u0000"+
		"\u010a\u010d\u0001\u0000\u0000\u0000\u010b\u0109\u0001\u0000\u0000\u0000"+
		"\u010b\u010c\u0001\u0000\u0000\u0000\u010c-\u0001\u0000\u0000\u0000\u010d"+
		"\u010b\u0001\u0000\u0000\u0000\u010e\u0116\u0003(\u0014\u0000\u010f\u0116"+
		"\u0003\"\u0011\u0000\u0110\u0116\u0003*\u0015\u0000\u0111\u0116\u0003"+
		"\u0012\t\u0000\u0112\u0116\u0003\u0016\u000b\u0000\u0113\u0116\u00034"+
		"\u001a\u0000\u0114\u0116\u0005\f\u0000\u0000\u0115\u010e\u0001\u0000\u0000"+
		"\u0000\u0115\u010f\u0001\u0000\u0000\u0000\u0115\u0110\u0001\u0000\u0000"+
		"\u0000\u0115\u0111\u0001\u0000\u0000\u0000\u0115\u0112\u0001\u0000\u0000"+
		"\u0000\u0115\u0113\u0001\u0000\u0000\u0000\u0115\u0114\u0001\u0000\u0000"+
		"\u0000\u0116/\u0001\u0000\u0000\u0000\u0117\u0118\u0006\u0018\uffff\uffff"+
		"\u0000\u0118\u0119\u0003.\u0017\u0000\u0119\u011a\u0005\u0012\u0000\u0000"+
		"\u011a\u011b\u0003.\u0017\u0000\u011b\u0121\u0001\u0000\u0000\u0000\u011c"+
		"\u011d\n\u0001\u0000\u0000\u011d\u011e\u0005\u0012\u0000\u0000\u011e\u0120"+
		"\u0003.\u0017\u0000\u011f\u011c\u0001\u0000\u0000\u0000\u0120\u0123\u0001"+
		"\u0000\u0000\u0000\u0121\u011f\u0001\u0000\u0000\u0000\u0121\u0122\u0001"+
		"\u0000\u0000\u0000\u01221\u0001\u0000\u0000\u0000\u0123\u0121\u0001\u0000"+
		"\u0000\u0000\u0124\u0127\u0005\u000e\u0000\u0000\u0125\u0128\u0003\u001a"+
		"\r\u0000\u0126\u0128\u0003,\u0016\u0000\u0127\u0125\u0001\u0000\u0000"+
		"\u0000\u0127\u0126\u0001\u0000\u0000\u0000\u01283\u0001\u0000\u0000\u0000"+
		"\u0129\u012a\u0005\u0013\u0000\u0000\u012a\u012d\u00032\u0019\u0000\u012b"+
		"\u012e\u0003.\u0017\u0000\u012c\u012e\u00030\u0018\u0000\u012d\u012b\u0001"+
		"\u0000\u0000\u0000\u012d\u012c\u0001\u0000\u0000\u0000\u012e\u012f\u0001"+
		"\u0000\u0000\u0000\u012f\u0130\u0005\u0014\u0000\u0000\u0130\u0139\u0001"+
		"\u0000\u0000\u0000\u0131\u0134\u0005\u0013\u0000\u0000\u0132\u0135\u0003"+
		".\u0017\u0000\u0133\u0135\u00030\u0018\u0000\u0134\u0132\u0001\u0000\u0000"+
		"\u0000\u0134\u0133\u0001\u0000\u0000\u0000\u0135\u0136\u0001\u0000\u0000"+
		"\u0000\u0136\u0137\u0005\u0014\u0000\u0000\u0137\u0139\u0001\u0000\u0000"+
		"\u0000\u0138\u0129\u0001\u0000\u0000\u0000\u0138\u0131\u0001\u0000\u0000"+
		"\u0000\u01395\u0001\u0000\u0000\u0000\u001aDQVey{\u0080\u008b\u0092\u0097"+
		"\u00a3\u00ac\u00b1\u00bf\u00ce\u00d6\u00de\u00e5\u00f9\u010b\u0115\u0121"+
		"\u0127\u012d\u0134\u0138";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}