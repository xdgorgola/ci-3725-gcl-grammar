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
		RULE_exp = 4, RULE_concateneable = 5, RULE_concatenation = 6, RULE_assigneable = 7, 
		RULE_asig = 8, RULE_printeable = 9, RULE_print = 10, RULE_type = 11, RULE_decl = 12, 
		RULE_then = 13, RULE_ifBody = 14, RULE_guard = 15, RULE_ifOp = 16, RULE_in = 17, 
		RULE_to = 18, RULE_forOp = 19, RULE_doOp = 20, RULE_seqDecl = 21, RULE_inst = 22, 
		RULE_seq = 23, RULE_declarationBlock = 24, RULE_block = 25;
	private static String[] makeRuleNames() {
		return new String[] {
			"writeABody", "writeA", "readA", "numericLit", "exp", "concateneable", 
			"concatenation", "assigneable", "asig", "printeable", "print", "type", 
			"decl", "then", "ifBody", "guard", "ifOp", "in", "to", "forOp", "doOp", 
			"seqDecl", "inst", "seq", "declarationBlock", "block"
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
		public TerminalNode TkId() { return getToken(GCLGrammarParser.TkId, 0); }
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
			setState(52);
			match(TkOpenPar);
			setState(53);
			exp(0);
			setState(54);
			match(TkTwoPoints);
			setState(57);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,0,_ctx) ) {
			case 1:
				{
				setState(55);
				match(TkId);
				}
				break;
			case 2:
				{
				setState(56);
				exp(0);
				}
				break;
			}
			setState(59);
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
			setState(62);
			match(TkId);
			setState(63);
			writeABody();
			}
			_ctx.stop = _input.LT(-1);
			setState(69);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,1,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					{
					_localctx = new WriteAContext(_parentctx, _parentState);
					pushNewRecursionContext(_localctx, _startState, RULE_writeA);
					setState(65);
					if (!(precpred(_ctx, 1))) throw new FailedPredicateException(this, "precpred(_ctx, 1)");
					setState(66);
					writeABody();
					}
					} 
				}
				setState(71);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,1,_ctx);
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
		public TerminalNode TkOBracket() { return getToken(GCLGrammarParser.TkOBracket, 0); }
		public TerminalNode TkCBracket() { return getToken(GCLGrammarParser.TkCBracket, 0); }
		public WriteAContext writeA() {
			return getRuleContext(WriteAContext.class,0);
		}
		public List<TerminalNode> TkId() { return getTokens(GCLGrammarParser.TkId); }
		public TerminalNode TkId(int i) {
			return getToken(GCLGrammarParser.TkId, i);
		}
		public ExpContext exp() {
			return getRuleContext(ExpContext.class,0);
		}
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
			enterOuterAlt(_localctx, 1);
			{
			setState(74);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,2,_ctx) ) {
			case 1:
				{
				setState(72);
				writeA(0);
				}
				break;
			case 2:
				{
				setState(73);
				match(TkId);
				}
				break;
			}
			setState(76);
			match(TkOBracket);
			setState(79);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,3,_ctx) ) {
			case 1:
				{
				setState(77);
				match(TkId);
				}
				break;
			case 2:
				{
				setState(78);
				exp(0);
				}
				break;
			}
			setState(81);
			match(TkCBracket);
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
			switch ( getInterpreter().adaptivePredict(_input,5,_ctx) ) {
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
			_alt = getInterpreter().adaptivePredict(_input,7,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(121);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,6,_ctx) ) {
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
				_alt = getInterpreter().adaptivePredict(_input,7,_ctx);
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
	public static class ConcateneableContext extends ParserRuleContext {
		public TerminalNode TkId() { return getToken(GCLGrammarParser.TkId, 0); }
		public TerminalNode TkString() { return getToken(GCLGrammarParser.TkString, 0); }
		public ExpContext exp() {
			return getRuleContext(ExpContext.class,0);
		}
		public ConcateneableContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_concateneable; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GCLGrammarVisitor ) return ((GCLGrammarVisitor<? extends T>)visitor).visitConcateneable(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ConcateneableContext concateneable() throws RecognitionException {
		ConcateneableContext _localctx = new ConcateneableContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_concateneable);
		try {
			setState(129);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,8,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(126);
				match(TkId);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(127);
				match(TkString);
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(128);
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
	public static class ConcatenationContext extends ParserRuleContext {
		public List<ConcateneableContext> concateneable() {
			return getRuleContexts(ConcateneableContext.class);
		}
		public ConcateneableContext concateneable(int i) {
			return getRuleContext(ConcateneableContext.class,i);
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
			setState(140);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,9,_ctx) ) {
			case 1:
				{
				setState(132);
				concateneable();
				setState(133);
				match(TkConcat);
				setState(134);
				concateneable();
				}
				break;
			case 2:
				{
				setState(136);
				match(TkOpenPar);
				setState(137);
				concatenation(0);
				setState(138);
				match(TkClosePar);
				}
				break;
			}
			_ctx.stop = _input.LT(-1);
			setState(147);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,10,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					{
					_localctx = new ConcatenationContext(_parentctx, _parentState);
					pushNewRecursionContext(_localctx, _startState, RULE_concatenation);
					setState(142);
					if (!(precpred(_ctx, 2))) throw new FailedPredicateException(this, "precpred(_ctx, 2)");
					setState(143);
					match(TkConcat);
					setState(144);
					concateneable();
					}
					} 
				}
				setState(149);
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
	public static class AssigneableContext extends ParserRuleContext {
		public TerminalNode TkId() { return getToken(GCLGrammarParser.TkId, 0); }
		public TerminalNode TkString() { return getToken(GCLGrammarParser.TkString, 0); }
		public ExpContext exp() {
			return getRuleContext(ExpContext.class,0);
		}
		public WriteAContext writeA() {
			return getRuleContext(WriteAContext.class,0);
		}
		public AssigneableContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_assigneable; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GCLGrammarVisitor ) return ((GCLGrammarVisitor<? extends T>)visitor).visitAssigneable(this);
			else return visitor.visitChildren(this);
		}
	}

	public final AssigneableContext assigneable() throws RecognitionException {
		AssigneableContext _localctx = new AssigneableContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_assigneable);
		try {
			setState(154);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,11,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(150);
				match(TkId);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(151);
				match(TkString);
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(152);
				exp(0);
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(153);
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
	public static class AsigContext extends ParserRuleContext {
		public TerminalNode TkId() { return getToken(GCLGrammarParser.TkId, 0); }
		public TerminalNode TkAsig() { return getToken(GCLGrammarParser.TkAsig, 0); }
		public List<AssigneableContext> assigneable() {
			return getRuleContexts(AssigneableContext.class);
		}
		public AssigneableContext assigneable(int i) {
			return getRuleContext(AssigneableContext.class,i);
		}
		public List<TerminalNode> TkComma() { return getTokens(GCLGrammarParser.TkComma); }
		public TerminalNode TkComma(int i) {
			return getToken(GCLGrammarParser.TkComma, i);
		}
		public AsigContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_asig; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GCLGrammarVisitor ) return ((GCLGrammarVisitor<? extends T>)visitor).visitAsig(this);
			else return visitor.visitChildren(this);
		}
	}

	public final AsigContext asig() throws RecognitionException {
		AsigContext _localctx = new AsigContext(_ctx, getState());
		enterRule(_localctx, 16, RULE_asig);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(156);
			match(TkId);
			setState(157);
			match(TkAsig);
			setState(158);
			assigneable();
			setState(163);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,12,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(159);
					match(TkComma);
					setState(160);
					assigneable();
					}
					} 
				}
				setState(165);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,12,_ctx);
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
	public static class PrinteableContext extends ParserRuleContext {
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
		enterRule(_localctx, 18, RULE_printeable);
		try {
			setState(168);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,13,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(166);
				concatenation(0);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(167);
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
		enterRule(_localctx, 20, RULE_print);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(170);
			match(TkPrint);
			setState(171);
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
		enterRule(_localctx, 22, RULE_type);
		try {
			setState(182);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case TkInt:
				_localctx = new TIntContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(173);
				match(TkInt);
				}
				break;
			case TkBool:
				_localctx = new TBoolContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(174);
				match(TkBool);
				}
				break;
			case TkArray:
				_localctx = new TArrayContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(175);
				match(TkArray);
				setState(176);
				match(TkOBracket);
				setState(177);
				numericLit();
				setState(178);
				match(TkSoForth);
				setState(179);
				numericLit();
				setState(180);
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
		public List<TerminalNode> TkId() { return getTokens(GCLGrammarParser.TkId); }
		public TerminalNode TkId(int i) {
			return getToken(GCLGrammarParser.TkId, i);
		}
		public TerminalNode TkTwoPoints() { return getToken(GCLGrammarParser.TkTwoPoints, 0); }
		public TypeContext type() {
			return getRuleContext(TypeContext.class,0);
		}
		public List<TerminalNode> TkComma() { return getTokens(GCLGrammarParser.TkComma); }
		public TerminalNode TkComma(int i) {
			return getToken(GCLGrammarParser.TkComma, i);
		}
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
		enterRule(_localctx, 24, RULE_decl);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(184);
			match(TkId);
			setState(189);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==TkComma) {
				{
				{
				setState(185);
				match(TkComma);
				setState(186);
				match(TkId);
				}
				}
				setState(191);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(192);
			match(TkTwoPoints);
			setState(193);
			type();
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
		enterRule(_localctx, 26, RULE_then);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(195);
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
	public static class IfBodyContext extends ParserRuleContext {
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
		public IfBodyContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_ifBody; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GCLGrammarVisitor ) return ((GCLGrammarVisitor<? extends T>)visitor).visitIfBody(this);
			else return visitor.visitChildren(this);
		}
	}

	public final IfBodyContext ifBody() throws RecognitionException {
		IfBodyContext _localctx = new IfBodyContext(_ctx, getState());
		enterRule(_localctx, 28, RULE_ifBody);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(197);
			then();
			setState(198);
			match(TkArrow);
			setState(201);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,16,_ctx) ) {
			case 1:
				{
				setState(199);
				inst();
				}
				break;
			case 2:
				{
				setState(200);
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
		public List<IfBodyContext> ifBody() {
			return getRuleContexts(IfBodyContext.class);
		}
		public IfBodyContext ifBody(int i) {
			return getRuleContext(IfBodyContext.class,i);
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
		int _startState = 30;
		enterRecursionRule(_localctx, 30, RULE_guard, _p);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(209);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,17,_ctx) ) {
			case 1:
				{
				setState(204);
				ifBody();
				setState(205);
				match(TkGuard);
				setState(206);
				ifBody();
				}
				break;
			case 2:
				{
				setState(208);
				ifBody();
				}
				break;
			}
			_ctx.stop = _input.LT(-1);
			setState(216);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,18,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					{
					_localctx = new GuardContext(_parentctx, _parentState);
					pushNewRecursionContext(_localctx, _startState, RULE_guard);
					setState(211);
					if (!(precpred(_ctx, 3))) throw new FailedPredicateException(this, "precpred(_ctx, 3)");
					setState(212);
					match(TkGuard);
					setState(213);
					ifBody();
					}
					} 
				}
				setState(218);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,18,_ctx);
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
		enterRule(_localctx, 32, RULE_ifOp);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(219);
			match(TkIf);
			setState(220);
			guard(0);
			setState(221);
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
		enterRule(_localctx, 34, RULE_in);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(223);
			match(TkId);
			setState(224);
			match(TkIn);
			setState(225);
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
		enterRule(_localctx, 36, RULE_to);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(227);
			match(TkTo);
			setState(228);
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
		enterRule(_localctx, 38, RULE_forOp);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(230);
			match(TkFor);
			setState(231);
			in();
			setState(232);
			to();
			setState(233);
			match(TkArrow);
			setState(236);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,19,_ctx) ) {
			case 1:
				{
				setState(234);
				inst();
				}
				break;
			case 2:
				{
				setState(235);
				seq(0);
				}
				break;
			}
			setState(238);
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
		public ThenContext then() {
			return getRuleContext(ThenContext.class,0);
		}
		public TerminalNode TkArrow() { return getToken(GCLGrammarParser.TkArrow, 0); }
		public TerminalNode TkOd() { return getToken(GCLGrammarParser.TkOd, 0); }
		public InstContext inst() {
			return getRuleContext(InstContext.class,0);
		}
		public SeqContext seq() {
			return getRuleContext(SeqContext.class,0);
		}
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
		enterRule(_localctx, 40, RULE_doOp);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(240);
			match(TkDo);
			setState(241);
			then();
			setState(242);
			match(TkArrow);
			setState(245);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,20,_ctx) ) {
			case 1:
				{
				setState(243);
				inst();
				}
				break;
			case 2:
				{
				setState(244);
				seq(0);
				}
				break;
			}
			setState(247);
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
		int _startState = 42;
		enterRecursionRule(_localctx, 42, RULE_seqDecl, _p);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			{
			setState(250);
			decl();
			setState(251);
			match(TkSemicolon);
			setState(252);
			decl();
			}
			_ctx.stop = _input.LT(-1);
			setState(259);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,21,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					{
					_localctx = new SeqDeclContext(_parentctx, _parentState);
					pushNewRecursionContext(_localctx, _startState, RULE_seqDecl);
					setState(254);
					if (!(precpred(_ctx, 1))) throw new FailedPredicateException(this, "precpred(_ctx, 1)");
					setState(255);
					match(TkSemicolon);
					setState(256);
					decl();
					}
					} 
				}
				setState(261);
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
		public AsigContext asig() {
			return getRuleContext(AsigContext.class,0);
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
		enterRule(_localctx, 44, RULE_inst);
		try {
			setState(269);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case TkFor:
				enterOuterAlt(_localctx, 1);
				{
				setState(262);
				forOp();
				}
				break;
			case TkIf:
				enterOuterAlt(_localctx, 2);
				{
				setState(263);
				ifOp();
				}
				break;
			case TkDo:
				enterOuterAlt(_localctx, 3);
				{
				setState(264);
				doOp();
				}
				break;
			case TkId:
				enterOuterAlt(_localctx, 4);
				{
				setState(265);
				asig();
				}
				break;
			case TkPrint:
				enterOuterAlt(_localctx, 5);
				{
				setState(266);
				print();
				}
				break;
			case TkOBlock:
				enterOuterAlt(_localctx, 6);
				{
				setState(267);
				block();
				}
				break;
			case TkSkip:
				enterOuterAlt(_localctx, 7);
				{
				setState(268);
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
		int _startState = 46;
		enterRecursionRule(_localctx, 46, RULE_seq, _p);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			{
			setState(272);
			inst();
			setState(273);
			match(TkSemicolon);
			setState(274);
			inst();
			}
			_ctx.stop = _input.LT(-1);
			setState(281);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,23,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					{
					_localctx = new SeqContext(_parentctx, _parentState);
					pushNewRecursionContext(_localctx, _startState, RULE_seq);
					setState(276);
					if (!(precpred(_ctx, 1))) throw new FailedPredicateException(this, "precpred(_ctx, 1)");
					setState(277);
					match(TkSemicolon);
					setState(278);
					inst();
					}
					} 
				}
				setState(283);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,23,_ctx);
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
		enterRule(_localctx, 48, RULE_declarationBlock);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(284);
			match(TkDeclare);
			setState(287);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,24,_ctx) ) {
			case 1:
				{
				setState(285);
				decl();
				}
				break;
			case 2:
				{
				setState(286);
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
		enterRule(_localctx, 50, RULE_block);
		try {
			setState(304);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,27,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(289);
				match(TkOBlock);
				setState(290);
				declarationBlock();
				setState(293);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,25,_ctx) ) {
				case 1:
					{
					setState(291);
					inst();
					}
					break;
				case 2:
					{
					setState(292);
					seq(0);
					}
					break;
				}
				setState(295);
				match(TkCBlock);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(297);
				match(TkOBlock);
				setState(300);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,26,_ctx) ) {
				case 1:
					{
					setState(298);
					inst();
					}
					break;
				case 2:
					{
					setState(299);
					seq(0);
					}
					break;
				}
				setState(302);
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
		case 15:
			return guard_sempred((GuardContext)_localctx, predIndex);
		case 21:
			return seqDecl_sempred((SeqDeclContext)_localctx, predIndex);
		case 23:
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
	private boolean guard_sempred(GuardContext _localctx, int predIndex) {
		switch (predIndex) {
		case 8:
			return precpred(_ctx, 3);
		}
		return true;
	}
	private boolean seqDecl_sempred(SeqDeclContext _localctx, int predIndex) {
		switch (predIndex) {
		case 9:
			return precpred(_ctx, 1);
		}
		return true;
	}
	private boolean seq_sempred(SeqContext _localctx, int predIndex) {
		switch (predIndex) {
		case 10:
			return precpred(_ctx, 1);
		}
		return true;
	}

	public static final String _serializedATN =
		"\u0004\u0001/\u0133\u0002\u0000\u0007\u0000\u0002\u0001\u0007\u0001\u0002"+
		"\u0002\u0007\u0002\u0002\u0003\u0007\u0003\u0002\u0004\u0007\u0004\u0002"+
		"\u0005\u0007\u0005\u0002\u0006\u0007\u0006\u0002\u0007\u0007\u0007\u0002"+
		"\b\u0007\b\u0002\t\u0007\t\u0002\n\u0007\n\u0002\u000b\u0007\u000b\u0002"+
		"\f\u0007\f\u0002\r\u0007\r\u0002\u000e\u0007\u000e\u0002\u000f\u0007\u000f"+
		"\u0002\u0010\u0007\u0010\u0002\u0011\u0007\u0011\u0002\u0012\u0007\u0012"+
		"\u0002\u0013\u0007\u0013\u0002\u0014\u0007\u0014\u0002\u0015\u0007\u0015"+
		"\u0002\u0016\u0007\u0016\u0002\u0017\u0007\u0017\u0002\u0018\u0007\u0018"+
		"\u0002\u0019\u0007\u0019\u0001\u0000\u0001\u0000\u0001\u0000\u0001\u0000"+
		"\u0001\u0000\u0003\u0000:\b\u0000\u0001\u0000\u0001\u0000\u0001\u0001"+
		"\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0005\u0001"+
		"D\b\u0001\n\u0001\f\u0001G\t\u0001\u0001\u0002\u0001\u0002\u0003\u0002"+
		"K\b\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0003\u0002P\b\u0002\u0001"+
		"\u0002\u0001\u0002\u0001\u0003\u0001\u0003\u0001\u0003\u0003\u0003W\b"+
		"\u0003\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0001"+
		"\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0001"+
		"\u0004\u0001\u0004\u0003\u0004f\b\u0004\u0001\u0004\u0001\u0004\u0001"+
		"\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0001"+
		"\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0001"+
		"\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0005\u0004z\b\u0004\n\u0004"+
		"\f\u0004}\t\u0004\u0001\u0005\u0001\u0005\u0001\u0005\u0003\u0005\u0082"+
		"\b\u0005\u0001\u0006\u0001\u0006\u0001\u0006\u0001\u0006\u0001\u0006\u0001"+
		"\u0006\u0001\u0006\u0001\u0006\u0001\u0006\u0003\u0006\u008d\b\u0006\u0001"+
		"\u0006\u0001\u0006\u0001\u0006\u0005\u0006\u0092\b\u0006\n\u0006\f\u0006"+
		"\u0095\t\u0006\u0001\u0007\u0001\u0007\u0001\u0007\u0001\u0007\u0003\u0007"+
		"\u009b\b\u0007\u0001\b\u0001\b\u0001\b\u0001\b\u0001\b\u0005\b\u00a2\b"+
		"\b\n\b\f\b\u00a5\t\b\u0001\t\u0001\t\u0003\t\u00a9\b\t\u0001\n\u0001\n"+
		"\u0001\n\u0001\u000b\u0001\u000b\u0001\u000b\u0001\u000b\u0001\u000b\u0001"+
		"\u000b\u0001\u000b\u0001\u000b\u0001\u000b\u0003\u000b\u00b7\b\u000b\u0001"+
		"\f\u0001\f\u0001\f\u0005\f\u00bc\b\f\n\f\f\f\u00bf\t\f\u0001\f\u0001\f"+
		"\u0001\f\u0001\r\u0001\r\u0001\u000e\u0001\u000e\u0001\u000e\u0001\u000e"+
		"\u0003\u000e\u00ca\b\u000e\u0001\u000f\u0001\u000f\u0001\u000f\u0001\u000f"+
		"\u0001\u000f\u0001\u000f\u0003\u000f\u00d2\b\u000f\u0001\u000f\u0001\u000f"+
		"\u0001\u000f\u0005\u000f\u00d7\b\u000f\n\u000f\f\u000f\u00da\t\u000f\u0001"+
		"\u0010\u0001\u0010\u0001\u0010\u0001\u0010\u0001\u0011\u0001\u0011\u0001"+
		"\u0011\u0001\u0011\u0001\u0012\u0001\u0012\u0001\u0012\u0001\u0013\u0001"+
		"\u0013\u0001\u0013\u0001\u0013\u0001\u0013\u0001\u0013\u0003\u0013\u00ed"+
		"\b\u0013\u0001\u0013\u0001\u0013\u0001\u0014\u0001\u0014\u0001\u0014\u0001"+
		"\u0014\u0001\u0014\u0003\u0014\u00f6\b\u0014\u0001\u0014\u0001\u0014\u0001"+
		"\u0015\u0001\u0015\u0001\u0015\u0001\u0015\u0001\u0015\u0001\u0015\u0001"+
		"\u0015\u0001\u0015\u0005\u0015\u0102\b\u0015\n\u0015\f\u0015\u0105\t\u0015"+
		"\u0001\u0016\u0001\u0016\u0001\u0016\u0001\u0016\u0001\u0016\u0001\u0016"+
		"\u0001\u0016\u0003\u0016\u010e\b\u0016\u0001\u0017\u0001\u0017\u0001\u0017"+
		"\u0001\u0017\u0001\u0017\u0001\u0017\u0001\u0017\u0001\u0017\u0005\u0017"+
		"\u0118\b\u0017\n\u0017\f\u0017\u011b\t\u0017\u0001\u0018\u0001\u0018\u0001"+
		"\u0018\u0003\u0018\u0120\b\u0018\u0001\u0019\u0001\u0019\u0001\u0019\u0001"+
		"\u0019\u0003\u0019\u0126\b\u0019\u0001\u0019\u0001\u0019\u0001\u0019\u0001"+
		"\u0019\u0001\u0019\u0003\u0019\u012d\b\u0019\u0001\u0019\u0001\u0019\u0003"+
		"\u0019\u0131\b\u0019\u0001\u0019\u0000\u0006\u0002\b\f\u001e*.\u001a\u0000"+
		"\u0002\u0004\u0006\b\n\f\u000e\u0010\u0012\u0014\u0016\u0018\u001a\u001c"+
		"\u001e \"$&(*,.02\u0000\u0004\u0001\u0000)*\u0001\u0000\u001c\u001d\u0002"+
		"\u0000!\"$%\u0002\u0000##&&\u0146\u00004\u0001\u0000\u0000\u0000\u0002"+
		"=\u0001\u0000\u0000\u0000\u0004J\u0001\u0000\u0000\u0000\u0006V\u0001"+
		"\u0000\u0000\u0000\be\u0001\u0000\u0000\u0000\n\u0081\u0001\u0000\u0000"+
		"\u0000\f\u008c\u0001\u0000\u0000\u0000\u000e\u009a\u0001\u0000\u0000\u0000"+
		"\u0010\u009c\u0001\u0000\u0000\u0000\u0012\u00a8\u0001\u0000\u0000\u0000"+
		"\u0014\u00aa\u0001\u0000\u0000\u0000\u0016\u00b6\u0001\u0000\u0000\u0000"+
		"\u0018\u00b8\u0001\u0000\u0000\u0000\u001a\u00c3\u0001\u0000\u0000\u0000"+
		"\u001c\u00c5\u0001\u0000\u0000\u0000\u001e\u00d1\u0001\u0000\u0000\u0000"+
		" \u00db\u0001\u0000\u0000\u0000\"\u00df\u0001\u0000\u0000\u0000$\u00e3"+
		"\u0001\u0000\u0000\u0000&\u00e6\u0001\u0000\u0000\u0000(\u00f0\u0001\u0000"+
		"\u0000\u0000*\u00f9\u0001\u0000\u0000\u0000,\u010d\u0001\u0000\u0000\u0000"+
		".\u010f\u0001\u0000\u0000\u00000\u011c\u0001\u0000\u0000\u00002\u0130"+
		"\u0001\u0000\u0000\u000045\u0005\u0010\u0000\u000056\u0003\b\u0004\u0000"+
		"69\u0005 \u0000\u00007:\u0005-\u0000\u00008:\u0003\b\u0004\u000097\u0001"+
		"\u0000\u0000\u000098\u0001\u0000\u0000\u0000:;\u0001\u0000\u0000\u0000"+
		";<\u0005\u0011\u0000\u0000<\u0001\u0001\u0000\u0000\u0000=>\u0006\u0001"+
		"\uffff\uffff\u0000>?\u0005-\u0000\u0000?@\u0003\u0000\u0000\u0000@E\u0001"+
		"\u0000\u0000\u0000AB\n\u0001\u0000\u0000BD\u0003\u0000\u0000\u0000CA\u0001"+
		"\u0000\u0000\u0000DG\u0001\u0000\u0000\u0000EC\u0001\u0000\u0000\u0000"+
		"EF\u0001\u0000\u0000\u0000F\u0003\u0001\u0000\u0000\u0000GE\u0001\u0000"+
		"\u0000\u0000HK\u0003\u0002\u0001\u0000IK\u0005-\u0000\u0000JH\u0001\u0000"+
		"\u0000\u0000JI\u0001\u0000\u0000\u0000KL\u0001\u0000\u0000\u0000LO\u0005"+
		"\u001a\u0000\u0000MP\u0005-\u0000\u0000NP\u0003\b\u0004\u0000OM\u0001"+
		"\u0000\u0000\u0000ON\u0001\u0000\u0000\u0000PQ\u0001\u0000\u0000\u0000"+
		"QR\u0005\u001b\u0000\u0000R\u0005\u0001\u0000\u0000\u0000ST\u0005\u001d"+
		"\u0000\u0000TW\u0003\u0006\u0003\u0000UW\u0005+\u0000\u0000VS\u0001\u0000"+
		"\u0000\u0000VU\u0001\u0000\u0000\u0000W\u0007\u0001\u0000\u0000\u0000"+
		"XY\u0006\u0004\uffff\uffff\u0000YZ\u0005\u0010\u0000\u0000Z[\u0003\b\u0004"+
		"\u0000[\\\u0005\u0011\u0000\u0000\\f\u0001\u0000\u0000\u0000]^\u0005\u001d"+
		"\u0000\u0000^f\u0003\b\u0004\f_`\u0005\u001f\u0000\u0000`f\u0003\b\u0004"+
		"\u000baf\u0005-\u0000\u0000bf\u0005+\u0000\u0000cf\u0003\u0004\u0002\u0000"+
		"df\u0007\u0000\u0000\u0000eX\u0001\u0000\u0000\u0000e]\u0001\u0000\u0000"+
		"\u0000e_\u0001\u0000\u0000\u0000ea\u0001\u0000\u0000\u0000eb\u0001\u0000"+
		"\u0000\u0000ec\u0001\u0000\u0000\u0000ed\u0001\u0000\u0000\u0000f{\u0001"+
		"\u0000\u0000\u0000gh\n\n\u0000\u0000hi\u0005\u001e\u0000\u0000iz\u0003"+
		"\b\u0004\u000bjk\n\t\u0000\u0000kl\u0007\u0001\u0000\u0000lz\u0003\b\u0004"+
		"\nmn\n\b\u0000\u0000no\u0007\u0002\u0000\u0000oz\u0003\b\u0004\tpq\n\u0007"+
		"\u0000\u0000qr\u0007\u0003\u0000\u0000rz\u0003\b\u0004\bst\n\u0006\u0000"+
		"\u0000tu\u0005(\u0000\u0000uz\u0003\b\u0004\u0007vw\n\u0005\u0000\u0000"+
		"wx\u0005\'\u0000\u0000xz\u0003\b\u0004\u0006yg\u0001\u0000\u0000\u0000"+
		"yj\u0001\u0000\u0000\u0000ym\u0001\u0000\u0000\u0000yp\u0001\u0000\u0000"+
		"\u0000ys\u0001\u0000\u0000\u0000yv\u0001\u0000\u0000\u0000z}\u0001\u0000"+
		"\u0000\u0000{y\u0001\u0000\u0000\u0000{|\u0001\u0000\u0000\u0000|\t\u0001"+
		"\u0000\u0000\u0000}{\u0001\u0000\u0000\u0000~\u0082\u0005-\u0000\u0000"+
		"\u007f\u0082\u0005,\u0000\u0000\u0080\u0082\u0003\b\u0004\u0000\u0081"+
		"~\u0001\u0000\u0000\u0000\u0081\u007f\u0001\u0000\u0000\u0000\u0081\u0080"+
		"\u0001\u0000\u0000\u0000\u0082\u000b\u0001\u0000\u0000\u0000\u0083\u0084"+
		"\u0006\u0006\uffff\uffff\u0000\u0084\u0085\u0003\n\u0005\u0000\u0085\u0086"+
		"\u0005\u0019\u0000\u0000\u0086\u0087\u0003\n\u0005\u0000\u0087\u008d\u0001"+
		"\u0000\u0000\u0000\u0088\u0089\u0005\u0010\u0000\u0000\u0089\u008a\u0003"+
		"\f\u0006\u0000\u008a\u008b\u0005\u0011\u0000\u0000\u008b\u008d\u0001\u0000"+
		"\u0000\u0000\u008c\u0083\u0001\u0000\u0000\u0000\u008c\u0088\u0001\u0000"+
		"\u0000\u0000\u008d\u0093\u0001\u0000\u0000\u0000\u008e\u008f\n\u0002\u0000"+
		"\u0000\u008f\u0090\u0005\u0019\u0000\u0000\u0090\u0092\u0003\n\u0005\u0000"+
		"\u0091\u008e\u0001\u0000\u0000\u0000\u0092\u0095\u0001\u0000\u0000\u0000"+
		"\u0093\u0091\u0001\u0000\u0000\u0000\u0093\u0094\u0001\u0000\u0000\u0000"+
		"\u0094\r\u0001\u0000\u0000\u0000\u0095\u0093\u0001\u0000\u0000\u0000\u0096"+
		"\u009b\u0005-\u0000\u0000\u0097\u009b\u0005,\u0000\u0000\u0098\u009b\u0003"+
		"\b\u0004\u0000\u0099\u009b\u0003\u0002\u0001\u0000\u009a\u0096\u0001\u0000"+
		"\u0000\u0000\u009a\u0097\u0001\u0000\u0000\u0000\u009a\u0098\u0001\u0000"+
		"\u0000\u0000\u009a\u0099\u0001\u0000\u0000\u0000\u009b\u000f\u0001\u0000"+
		"\u0000\u0000\u009c\u009d\u0005-\u0000\u0000\u009d\u009e\u0005\u0016\u0000"+
		"\u0000\u009e\u00a3\u0003\u000e\u0007\u0000\u009f\u00a0\u0005\u000f\u0000"+
		"\u0000\u00a0\u00a2\u0003\u000e\u0007\u0000\u00a1\u009f\u0001\u0000\u0000"+
		"\u0000\u00a2\u00a5\u0001\u0000\u0000\u0000\u00a3\u00a1\u0001\u0000\u0000"+
		"\u0000\u00a3\u00a4\u0001\u0000\u0000\u0000\u00a4\u0011\u0001\u0000\u0000"+
		"\u0000\u00a5\u00a3\u0001\u0000\u0000\u0000\u00a6\u00a9\u0003\f\u0006\u0000"+
		"\u00a7\u00a9\u0003\b\u0004\u0000\u00a8\u00a6\u0001\u0000\u0000\u0000\u00a8"+
		"\u00a7\u0001\u0000\u0000\u0000\u00a9\u0013\u0001\u0000\u0000\u0000\u00aa"+
		"\u00ab\u0005\r\u0000\u0000\u00ab\u00ac\u0003\u0012\t\u0000\u00ac\u0015"+
		"\u0001\u0000\u0000\u0000\u00ad\u00b7\u0005\u0007\u0000\u0000\u00ae\u00b7"+
		"\u0005\b\u0000\u0000\u00af\u00b0\u0005\u000b\u0000\u0000\u00b0\u00b1\u0005"+
		"\u001a\u0000\u0000\u00b1\u00b2\u0003\u0006\u0003\u0000\u00b2\u00b3\u0005"+
		"\u0015\u0000\u0000\u00b3\u00b4\u0003\u0006\u0003\u0000\u00b4\u00b5\u0005"+
		"\u001b\u0000\u0000\u00b5\u00b7\u0001\u0000\u0000\u0000\u00b6\u00ad\u0001"+
		"\u0000\u0000\u0000\u00b6\u00ae\u0001\u0000\u0000\u0000\u00b6\u00af\u0001"+
		"\u0000\u0000\u0000\u00b7\u0017\u0001\u0000\u0000\u0000\u00b8\u00bd\u0005"+
		"-\u0000\u0000\u00b9\u00ba\u0005\u000f\u0000\u0000\u00ba\u00bc\u0005-\u0000"+
		"\u0000\u00bb\u00b9\u0001\u0000\u0000\u0000\u00bc\u00bf\u0001\u0000\u0000"+
		"\u0000\u00bd\u00bb\u0001\u0000\u0000\u0000\u00bd\u00be\u0001\u0000\u0000"+
		"\u0000\u00be\u00c0\u0001\u0000\u0000\u0000\u00bf\u00bd\u0001\u0000\u0000"+
		"\u0000\u00c0\u00c1\u0005 \u0000\u0000\u00c1\u00c2\u0003\u0016\u000b\u0000"+
		"\u00c2\u0019\u0001\u0000\u0000\u0000\u00c3\u00c4\u0003\b\u0004\u0000\u00c4"+
		"\u001b\u0001\u0000\u0000\u0000\u00c5\u00c6\u0003\u001a\r\u0000\u00c6\u00c9"+
		"\u0005\u0017\u0000\u0000\u00c7\u00ca\u0003,\u0016\u0000\u00c8\u00ca\u0003"+
		".\u0017\u0000\u00c9\u00c7\u0001\u0000\u0000\u0000\u00c9\u00c8\u0001\u0000"+
		"\u0000\u0000\u00ca\u001d\u0001\u0000\u0000\u0000\u00cb\u00cc\u0006\u000f"+
		"\uffff\uffff\u0000\u00cc\u00cd\u0003\u001c\u000e\u0000\u00cd\u00ce\u0005"+
		"\u0018\u0000\u0000\u00ce\u00cf\u0003\u001c\u000e\u0000\u00cf\u00d2\u0001"+
		"\u0000\u0000\u0000\u00d0\u00d2\u0003\u001c\u000e\u0000\u00d1\u00cb\u0001"+
		"\u0000\u0000\u0000\u00d1\u00d0\u0001\u0000\u0000\u0000\u00d2\u00d8\u0001"+
		"\u0000\u0000\u0000\u00d3\u00d4\n\u0003\u0000\u0000\u00d4\u00d5\u0005\u0018"+
		"\u0000\u0000\u00d5\u00d7\u0003\u001c\u000e\u0000\u00d6\u00d3\u0001\u0000"+
		"\u0000\u0000\u00d7\u00da\u0001\u0000\u0000\u0000\u00d8\u00d6\u0001\u0000"+
		"\u0000\u0000\u00d8\u00d9\u0001\u0000\u0000\u0000\u00d9\u001f\u0001\u0000"+
		"\u0000\u0000\u00da\u00d8\u0001\u0000\u0000\u0000\u00db\u00dc\u0005\u0001"+
		"\u0000\u0000\u00dc\u00dd\u0003\u001e\u000f\u0000\u00dd\u00de\u0005\u0002"+
		"\u0000\u0000\u00de!\u0001\u0000\u0000\u0000\u00df\u00e0\u0005-\u0000\u0000"+
		"\u00e0\u00e1\u0005\u0006\u0000\u0000\u00e1\u00e2\u0003\b\u0004\u0000\u00e2"+
		"#\u0001\u0000\u0000\u0000\u00e3\u00e4\u0005\u0005\u0000\u0000\u00e4\u00e5"+
		"\u0003\b\u0004\u0000\u00e5%\u0001\u0000\u0000\u0000\u00e6\u00e7\u0005"+
		"\t\u0000\u0000\u00e7\u00e8\u0003\"\u0011\u0000\u00e8\u00e9\u0003$\u0012"+
		"\u0000\u00e9\u00ec\u0005\u0017\u0000\u0000\u00ea\u00ed\u0003,\u0016\u0000"+
		"\u00eb\u00ed\u0003.\u0017\u0000\u00ec\u00ea\u0001\u0000\u0000\u0000\u00ec"+
		"\u00eb\u0001\u0000\u0000\u0000\u00ed\u00ee\u0001\u0000\u0000\u0000\u00ee"+
		"\u00ef\u0005\n\u0000\u0000\u00ef\'\u0001\u0000\u0000\u0000\u00f0\u00f1"+
		"\u0005\u0003\u0000\u0000\u00f1\u00f2\u0003\u001a\r\u0000\u00f2\u00f5\u0005"+
		"\u0017\u0000\u0000\u00f3\u00f6\u0003,\u0016\u0000\u00f4\u00f6\u0003.\u0017"+
		"\u0000\u00f5\u00f3\u0001\u0000\u0000\u0000\u00f5\u00f4\u0001\u0000\u0000"+
		"\u0000\u00f6\u00f7\u0001\u0000\u0000\u0000\u00f7\u00f8\u0005\u0004\u0000"+
		"\u0000\u00f8)\u0001\u0000\u0000\u0000\u00f9\u00fa\u0006\u0015\uffff\uffff"+
		"\u0000\u00fa\u00fb\u0003\u0018\f\u0000\u00fb\u00fc\u0005\u0012\u0000\u0000"+
		"\u00fc\u00fd\u0003\u0018\f\u0000\u00fd\u0103\u0001\u0000\u0000\u0000\u00fe"+
		"\u00ff\n\u0001\u0000\u0000\u00ff\u0100\u0005\u0012\u0000\u0000\u0100\u0102"+
		"\u0003\u0018\f\u0000\u0101\u00fe\u0001\u0000\u0000\u0000\u0102\u0105\u0001"+
		"\u0000\u0000\u0000\u0103\u0101\u0001\u0000\u0000\u0000\u0103\u0104\u0001"+
		"\u0000\u0000\u0000\u0104+\u0001\u0000\u0000\u0000\u0105\u0103\u0001\u0000"+
		"\u0000\u0000\u0106\u010e\u0003&\u0013\u0000\u0107\u010e\u0003 \u0010\u0000"+
		"\u0108\u010e\u0003(\u0014\u0000\u0109\u010e\u0003\u0010\b\u0000\u010a"+
		"\u010e\u0003\u0014\n\u0000\u010b\u010e\u00032\u0019\u0000\u010c\u010e"+
		"\u0005\f\u0000\u0000\u010d\u0106\u0001\u0000\u0000\u0000\u010d\u0107\u0001"+
		"\u0000\u0000\u0000\u010d\u0108\u0001\u0000\u0000\u0000\u010d\u0109\u0001"+
		"\u0000\u0000\u0000\u010d\u010a\u0001\u0000\u0000\u0000\u010d\u010b\u0001"+
		"\u0000\u0000\u0000\u010d\u010c\u0001\u0000\u0000\u0000\u010e-\u0001\u0000"+
		"\u0000\u0000\u010f\u0110\u0006\u0017\uffff\uffff\u0000\u0110\u0111\u0003"+
		",\u0016\u0000\u0111\u0112\u0005\u0012\u0000\u0000\u0112\u0113\u0003,\u0016"+
		"\u0000\u0113\u0119\u0001\u0000\u0000\u0000\u0114\u0115\n\u0001\u0000\u0000"+
		"\u0115\u0116\u0005\u0012\u0000\u0000\u0116\u0118\u0003,\u0016\u0000\u0117"+
		"\u0114\u0001\u0000\u0000\u0000\u0118\u011b\u0001\u0000\u0000\u0000\u0119"+
		"\u0117\u0001\u0000\u0000\u0000\u0119\u011a\u0001\u0000\u0000\u0000\u011a"+
		"/\u0001\u0000\u0000\u0000\u011b\u0119\u0001\u0000\u0000\u0000\u011c\u011f"+
		"\u0005\u000e\u0000\u0000\u011d\u0120\u0003\u0018\f\u0000\u011e\u0120\u0003"+
		"*\u0015\u0000\u011f\u011d\u0001\u0000\u0000\u0000\u011f\u011e\u0001\u0000"+
		"\u0000\u0000\u01201\u0001\u0000\u0000\u0000\u0121\u0122\u0005\u0013\u0000"+
		"\u0000\u0122\u0125\u00030\u0018\u0000\u0123\u0126\u0003,\u0016\u0000\u0124"+
		"\u0126\u0003.\u0017\u0000\u0125\u0123\u0001\u0000\u0000\u0000\u0125\u0124"+
		"\u0001\u0000\u0000\u0000\u0126\u0127\u0001\u0000\u0000\u0000\u0127\u0128"+
		"\u0005\u0014\u0000\u0000\u0128\u0131\u0001\u0000\u0000\u0000\u0129\u012c"+
		"\u0005\u0013\u0000\u0000\u012a\u012d\u0003,\u0016\u0000\u012b\u012d\u0003"+
		".\u0017\u0000\u012c\u012a\u0001\u0000\u0000\u0000\u012c\u012b\u0001\u0000"+
		"\u0000\u0000\u012d\u012e\u0001\u0000\u0000\u0000\u012e\u012f\u0005\u0014"+
		"\u0000\u0000\u012f\u0131\u0001\u0000\u0000\u0000\u0130\u0121\u0001\u0000"+
		"\u0000\u0000\u0130\u0129\u0001\u0000\u0000\u0000\u01313\u0001\u0000\u0000"+
		"\u0000\u001c9EJOVey{\u0081\u008c\u0093\u009a\u00a3\u00a8\u00b6\u00bd\u00c9"+
		"\u00d1\u00d8\u00ec\u00f5\u0103\u010d\u0119\u011f\u0125\u012c\u0130";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}