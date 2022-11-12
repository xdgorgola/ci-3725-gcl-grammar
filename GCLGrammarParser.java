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
		RULE_block = 0, RULE_declaration = 1, RULE_seq = 2, RULE_decl = 3, RULE_type = 4, 
		RULE_asig = 5, RULE_print = 6, RULE_op = 7, RULE_sum = 8, RULE_sus = 9, 
		RULE_mult = 10, RULE_neg = 11, RULE_mayor = 12, RULE_menor = 13, RULE_mayorig = 14, 
		RULE_menorig = 15, RULE_desig = 16, RULE_y = 17, RULE_o = 18, RULE_no = 19, 
		RULE_conc = 20, RULE_ident = 21, RULE_readA = 22, RULE_lit = 23;
	private static String[] makeRuleNames() {
		return new String[] {
			"block", "declaration", "seq", "decl", "type", "asig", "print", "op", 
			"sum", "sus", "mult", "neg", "mayor", "menor", "mayorig", "menorig", 
			"desig", "y", "o", "no", "conc", "ident", "readA", "lit"
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
	public static class BlockContext extends ParserRuleContext {
		public TerminalNode TkOBlock() { return getToken(GCLGrammarParser.TkOBlock, 0); }
		public SeqContext seq() {
			return getRuleContext(SeqContext.class,0);
		}
		public TerminalNode TkCBlock() { return getToken(GCLGrammarParser.TkCBlock, 0); }
		public List<DeclarationContext> declaration() {
			return getRuleContexts(DeclarationContext.class);
		}
		public DeclarationContext declaration(int i) {
			return getRuleContext(DeclarationContext.class,i);
		}
		public BlockContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_block; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GCLGrammarListener ) ((GCLGrammarListener)listener).enterBlock(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GCLGrammarListener ) ((GCLGrammarListener)listener).exitBlock(this);
		}
	}

	public final BlockContext block() throws RecognitionException {
		BlockContext _localctx = new BlockContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_block);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(48);
			match(TkOBlock);
			setState(52);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==TkDeclare) {
				{
				{
				setState(49);
				declaration();
				}
				}
				setState(54);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(55);
			seq();
			setState(56);
			match(TkCBlock);
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
	public static class DeclarationContext extends ParserRuleContext {
		public TerminalNode TkDeclare() { return getToken(GCLGrammarParser.TkDeclare, 0); }
		public SeqContext seq() {
			return getRuleContext(SeqContext.class,0);
		}
		public DeclContext decl() {
			return getRuleContext(DeclContext.class,0);
		}
		public DeclarationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_declaration; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GCLGrammarListener ) ((GCLGrammarListener)listener).enterDeclaration(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GCLGrammarListener ) ((GCLGrammarListener)listener).exitDeclaration(this);
		}
	}

	public final DeclarationContext declaration() throws RecognitionException {
		DeclarationContext _localctx = new DeclarationContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_declaration);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(58);
			match(TkDeclare);
			setState(61);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,1,_ctx) ) {
			case 1:
				{
				setState(59);
				seq();
				}
				break;
			case 2:
				{
				setState(60);
				decl();
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
	public static class SeqContext extends ParserRuleContext {
		public List<DeclContext> decl() {
			return getRuleContexts(DeclContext.class);
		}
		public DeclContext decl(int i) {
			return getRuleContext(DeclContext.class,i);
		}
		public List<TerminalNode> TkSemicolon() { return getTokens(GCLGrammarParser.TkSemicolon); }
		public TerminalNode TkSemicolon(int i) {
			return getToken(GCLGrammarParser.TkSemicolon, i);
		}
		public List<SeqContext> seq() {
			return getRuleContexts(SeqContext.class);
		}
		public SeqContext seq(int i) {
			return getRuleContext(SeqContext.class,i);
		}
		public AsigContext asig() {
			return getRuleContext(AsigContext.class,0);
		}
		public PrintContext print() {
			return getRuleContext(PrintContext.class,0);
		}
		public SeqContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_seq; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GCLGrammarListener ) ((GCLGrammarListener)listener).enterSeq(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GCLGrammarListener ) ((GCLGrammarListener)listener).exitSeq(this);
		}
	}

	public final SeqContext seq() throws RecognitionException {
		SeqContext _localctx = new SeqContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_seq);
		try {
			int _alt;
			setState(93);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,6,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(63);
				decl();
				setState(66); 
				_errHandler.sync(this);
				_alt = 1;
				do {
					switch (_alt) {
					case 1:
						{
						{
						setState(64);
						match(TkSemicolon);
						setState(65);
						decl();
						}
						}
						break;
					default:
						throw new NoViableAltException(this);
					}
					setState(68); 
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,2,_ctx);
				} while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER );
				setState(74);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,3,_ctx);
				while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
					if ( _alt==1 ) {
						{
						{
						setState(70);
						match(TkSemicolon);
						setState(71);
						seq();
						}
						} 
					}
					setState(76);
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,3,_ctx);
				}
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(77);
				asig();
				setState(82);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,4,_ctx);
				while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
					if ( _alt==1 ) {
						{
						{
						setState(78);
						match(TkSemicolon);
						setState(79);
						seq();
						}
						} 
					}
					setState(84);
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,4,_ctx);
				}
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(85);
				print();
				setState(90);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,5,_ctx);
				while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
					if ( _alt==1 ) {
						{
						{
						setState(86);
						match(TkSemicolon);
						setState(87);
						seq();
						}
						} 
					}
					setState(92);
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,5,_ctx);
				}
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
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GCLGrammarListener ) ((GCLGrammarListener)listener).enterDecl(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GCLGrammarListener ) ((GCLGrammarListener)listener).exitDecl(this);
		}
	}

	public final DeclContext decl() throws RecognitionException {
		DeclContext _localctx = new DeclContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_decl);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(95);
			match(TkId);
			setState(100);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==TkComma) {
				{
				{
				setState(96);
				match(TkComma);
				setState(97);
				match(TkId);
				}
				}
				setState(102);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(103);
			match(TkTwoPoints);
			setState(104);
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
	public static class TypeContext extends ParserRuleContext {
		public TerminalNode TkInt() { return getToken(GCLGrammarParser.TkInt, 0); }
		public TerminalNode TkBool() { return getToken(GCLGrammarParser.TkBool, 0); }
		public TerminalNode TkArray() { return getToken(GCLGrammarParser.TkArray, 0); }
		public TerminalNode TkOBracket() { return getToken(GCLGrammarParser.TkOBracket, 0); }
		public List<TerminalNode> TkNum() { return getTokens(GCLGrammarParser.TkNum); }
		public TerminalNode TkNum(int i) {
			return getToken(GCLGrammarParser.TkNum, i);
		}
		public TerminalNode TkSoForth() { return getToken(GCLGrammarParser.TkSoForth, 0); }
		public TerminalNode TkCBracket() { return getToken(GCLGrammarParser.TkCBracket, 0); }
		public TypeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_type; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GCLGrammarListener ) ((GCLGrammarListener)listener).enterType(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GCLGrammarListener ) ((GCLGrammarListener)listener).exitType(this);
		}
	}

	public final TypeContext type() throws RecognitionException {
		TypeContext _localctx = new TypeContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_type);
		try {
			setState(114);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case TkInt:
				enterOuterAlt(_localctx, 1);
				{
				setState(106);
				match(TkInt);
				}
				break;
			case TkBool:
				enterOuterAlt(_localctx, 2);
				{
				setState(107);
				match(TkBool);
				}
				break;
			case TkArray:
				enterOuterAlt(_localctx, 3);
				{
				setState(108);
				match(TkArray);
				setState(109);
				match(TkOBracket);
				setState(110);
				match(TkNum);
				setState(111);
				match(TkSoForth);
				setState(112);
				match(TkNum);
				setState(113);
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
	public static class AsigContext extends ParserRuleContext {
		public TerminalNode TkId() { return getToken(GCLGrammarParser.TkId, 0); }
		public TerminalNode TkAsig() { return getToken(GCLGrammarParser.TkAsig, 0); }
		public LitContext lit() {
			return getRuleContext(LitContext.class,0);
		}
		public OpContext op() {
			return getRuleContext(OpContext.class,0);
		}
		public AsigContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_asig; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GCLGrammarListener ) ((GCLGrammarListener)listener).enterAsig(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GCLGrammarListener ) ((GCLGrammarListener)listener).exitAsig(this);
		}
	}

	public final AsigContext asig() throws RecognitionException {
		AsigContext _localctx = new AsigContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_asig);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(116);
			match(TkId);
			setState(117);
			match(TkAsig);
			setState(120);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,9,_ctx) ) {
			case 1:
				{
				setState(118);
				lit();
				}
				break;
			case 2:
				{
				setState(119);
				op();
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
	public static class PrintContext extends ParserRuleContext {
		public TerminalNode TkPrint() { return getToken(GCLGrammarParser.TkPrint, 0); }
		public OpContext op() {
			return getRuleContext(OpContext.class,0);
		}
		public LitContext lit() {
			return getRuleContext(LitContext.class,0);
		}
		public IdentContext ident() {
			return getRuleContext(IdentContext.class,0);
		}
		public ReadAContext readA() {
			return getRuleContext(ReadAContext.class,0);
		}
		public PrintContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_print; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GCLGrammarListener ) ((GCLGrammarListener)listener).enterPrint(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GCLGrammarListener ) ((GCLGrammarListener)listener).exitPrint(this);
		}
	}

	public final PrintContext print() throws RecognitionException {
		PrintContext _localctx = new PrintContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_print);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(122);
			match(TkPrint);
			setState(127);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,10,_ctx) ) {
			case 1:
				{
				setState(123);
				op();
				}
				break;
			case 2:
				{
				setState(124);
				lit();
				}
				break;
			case 3:
				{
				setState(125);
				ident();
				}
				break;
			case 4:
				{
				setState(126);
				readA();
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
	public static class OpContext extends ParserRuleContext {
		public SumContext sum() {
			return getRuleContext(SumContext.class,0);
		}
		public SusContext sus() {
			return getRuleContext(SusContext.class,0);
		}
		public MultContext mult() {
			return getRuleContext(MultContext.class,0);
		}
		public NegContext neg() {
			return getRuleContext(NegContext.class,0);
		}
		public MayorContext mayor() {
			return getRuleContext(MayorContext.class,0);
		}
		public MenorContext menor() {
			return getRuleContext(MenorContext.class,0);
		}
		public MayorigContext mayorig() {
			return getRuleContext(MayorigContext.class,0);
		}
		public MenorigContext menorig() {
			return getRuleContext(MenorigContext.class,0);
		}
		public YContext y() {
			return getRuleContext(YContext.class,0);
		}
		public OContext o() {
			return getRuleContext(OContext.class,0);
		}
		public NoContext no() {
			return getRuleContext(NoContext.class,0);
		}
		public DesigContext desig() {
			return getRuleContext(DesigContext.class,0);
		}
		public ConcContext conc() {
			return getRuleContext(ConcContext.class,0);
		}
		public OpContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_op; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GCLGrammarListener ) ((GCLGrammarListener)listener).enterOp(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GCLGrammarListener ) ((GCLGrammarListener)listener).exitOp(this);
		}
	}

	public final OpContext op() throws RecognitionException {
		OpContext _localctx = new OpContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_op);
		try {
			setState(142);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,11,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(129);
				sum();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(130);
				sus();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(131);
				mult();
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(132);
				neg();
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(133);
				mayor();
				}
				break;
			case 6:
				enterOuterAlt(_localctx, 6);
				{
				setState(134);
				menor();
				}
				break;
			case 7:
				enterOuterAlt(_localctx, 7);
				{
				setState(135);
				mayorig();
				}
				break;
			case 8:
				enterOuterAlt(_localctx, 8);
				{
				setState(136);
				menorig();
				}
				break;
			case 9:
				enterOuterAlt(_localctx, 9);
				{
				setState(137);
				y();
				}
				break;
			case 10:
				enterOuterAlt(_localctx, 10);
				{
				setState(138);
				o();
				}
				break;
			case 11:
				enterOuterAlt(_localctx, 11);
				{
				setState(139);
				no();
				}
				break;
			case 12:
				enterOuterAlt(_localctx, 12);
				{
				setState(140);
				desig();
				}
				break;
			case 13:
				enterOuterAlt(_localctx, 13);
				{
				setState(141);
				conc();
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
	public static class SumContext extends ParserRuleContext {
		public TerminalNode TkPlus() { return getToken(GCLGrammarParser.TkPlus, 0); }
		public List<IdentContext> ident() {
			return getRuleContexts(IdentContext.class);
		}
		public IdentContext ident(int i) {
			return getRuleContext(IdentContext.class,i);
		}
		public List<LitContext> lit() {
			return getRuleContexts(LitContext.class);
		}
		public LitContext lit(int i) {
			return getRuleContext(LitContext.class,i);
		}
		public SumContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_sum; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GCLGrammarListener ) ((GCLGrammarListener)listener).enterSum(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GCLGrammarListener ) ((GCLGrammarListener)listener).exitSum(this);
		}
	}

	public final SumContext sum() throws RecognitionException {
		SumContext _localctx = new SumContext(_ctx, getState());
		enterRule(_localctx, 16, RULE_sum);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(146);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case TkId:
				{
				setState(144);
				ident();
				}
				break;
			case TkOBracket:
			case TkTrue:
			case TkFalse:
			case TkNum:
			case TkString:
				{
				setState(145);
				lit();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			setState(148);
			match(TkPlus);
			setState(151);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case TkId:
				{
				setState(149);
				ident();
				}
				break;
			case TkOBracket:
			case TkTrue:
			case TkFalse:
			case TkNum:
			case TkString:
				{
				setState(150);
				lit();
				}
				break;
			default:
				throw new NoViableAltException(this);
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
	public static class SusContext extends ParserRuleContext {
		public TerminalNode TkMinus() { return getToken(GCLGrammarParser.TkMinus, 0); }
		public List<IdentContext> ident() {
			return getRuleContexts(IdentContext.class);
		}
		public IdentContext ident(int i) {
			return getRuleContext(IdentContext.class,i);
		}
		public List<LitContext> lit() {
			return getRuleContexts(LitContext.class);
		}
		public LitContext lit(int i) {
			return getRuleContext(LitContext.class,i);
		}
		public SusContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_sus; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GCLGrammarListener ) ((GCLGrammarListener)listener).enterSus(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GCLGrammarListener ) ((GCLGrammarListener)listener).exitSus(this);
		}
	}

	public final SusContext sus() throws RecognitionException {
		SusContext _localctx = new SusContext(_ctx, getState());
		enterRule(_localctx, 18, RULE_sus);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(155);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case TkId:
				{
				setState(153);
				ident();
				}
				break;
			case TkOBracket:
			case TkTrue:
			case TkFalse:
			case TkNum:
			case TkString:
				{
				setState(154);
				lit();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			setState(157);
			match(TkMinus);
			setState(160);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case TkId:
				{
				setState(158);
				ident();
				}
				break;
			case TkOBracket:
			case TkTrue:
			case TkFalse:
			case TkNum:
			case TkString:
				{
				setState(159);
				lit();
				}
				break;
			default:
				throw new NoViableAltException(this);
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
	public static class MultContext extends ParserRuleContext {
		public TerminalNode TkMult() { return getToken(GCLGrammarParser.TkMult, 0); }
		public List<IdentContext> ident() {
			return getRuleContexts(IdentContext.class);
		}
		public IdentContext ident(int i) {
			return getRuleContext(IdentContext.class,i);
		}
		public List<LitContext> lit() {
			return getRuleContexts(LitContext.class);
		}
		public LitContext lit(int i) {
			return getRuleContext(LitContext.class,i);
		}
		public MultContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_mult; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GCLGrammarListener ) ((GCLGrammarListener)listener).enterMult(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GCLGrammarListener ) ((GCLGrammarListener)listener).exitMult(this);
		}
	}

	public final MultContext mult() throws RecognitionException {
		MultContext _localctx = new MultContext(_ctx, getState());
		enterRule(_localctx, 20, RULE_mult);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(164);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case TkId:
				{
				setState(162);
				ident();
				}
				break;
			case TkOBracket:
			case TkTrue:
			case TkFalse:
			case TkNum:
			case TkString:
				{
				setState(163);
				lit();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			setState(166);
			match(TkMult);
			setState(169);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case TkId:
				{
				setState(167);
				ident();
				}
				break;
			case TkOBracket:
			case TkTrue:
			case TkFalse:
			case TkNum:
			case TkString:
				{
				setState(168);
				lit();
				}
				break;
			default:
				throw new NoViableAltException(this);
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
	public static class NegContext extends ParserRuleContext {
		public TerminalNode TkMinus() { return getToken(GCLGrammarParser.TkMinus, 0); }
		public IdentContext ident() {
			return getRuleContext(IdentContext.class,0);
		}
		public LitContext lit() {
			return getRuleContext(LitContext.class,0);
		}
		public NegContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_neg; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GCLGrammarListener ) ((GCLGrammarListener)listener).enterNeg(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GCLGrammarListener ) ((GCLGrammarListener)listener).exitNeg(this);
		}
	}

	public final NegContext neg() throws RecognitionException {
		NegContext _localctx = new NegContext(_ctx, getState());
		enterRule(_localctx, 22, RULE_neg);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(171);
			match(TkMinus);
			setState(174);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case TkId:
				{
				setState(172);
				ident();
				}
				break;
			case TkOBracket:
			case TkTrue:
			case TkFalse:
			case TkNum:
			case TkString:
				{
				setState(173);
				lit();
				}
				break;
			default:
				throw new NoViableAltException(this);
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
	public static class MayorContext extends ParserRuleContext {
		public TerminalNode TkGreater() { return getToken(GCLGrammarParser.TkGreater, 0); }
		public List<IdentContext> ident() {
			return getRuleContexts(IdentContext.class);
		}
		public IdentContext ident(int i) {
			return getRuleContext(IdentContext.class,i);
		}
		public List<LitContext> lit() {
			return getRuleContexts(LitContext.class);
		}
		public LitContext lit(int i) {
			return getRuleContext(LitContext.class,i);
		}
		public MayorContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_mayor; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GCLGrammarListener ) ((GCLGrammarListener)listener).enterMayor(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GCLGrammarListener ) ((GCLGrammarListener)listener).exitMayor(this);
		}
	}

	public final MayorContext mayor() throws RecognitionException {
		MayorContext _localctx = new MayorContext(_ctx, getState());
		enterRule(_localctx, 24, RULE_mayor);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(178);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case TkId:
				{
				setState(176);
				ident();
				}
				break;
			case TkOBracket:
			case TkTrue:
			case TkFalse:
			case TkNum:
			case TkString:
				{
				setState(177);
				lit();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			setState(180);
			match(TkGreater);
			setState(183);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case TkId:
				{
				setState(181);
				ident();
				}
				break;
			case TkOBracket:
			case TkTrue:
			case TkFalse:
			case TkNum:
			case TkString:
				{
				setState(182);
				lit();
				}
				break;
			default:
				throw new NoViableAltException(this);
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
	public static class MenorContext extends ParserRuleContext {
		public TerminalNode TkLess() { return getToken(GCLGrammarParser.TkLess, 0); }
		public List<IdentContext> ident() {
			return getRuleContexts(IdentContext.class);
		}
		public IdentContext ident(int i) {
			return getRuleContext(IdentContext.class,i);
		}
		public List<LitContext> lit() {
			return getRuleContexts(LitContext.class);
		}
		public LitContext lit(int i) {
			return getRuleContext(LitContext.class,i);
		}
		public MenorContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_menor; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GCLGrammarListener ) ((GCLGrammarListener)listener).enterMenor(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GCLGrammarListener ) ((GCLGrammarListener)listener).exitMenor(this);
		}
	}

	public final MenorContext menor() throws RecognitionException {
		MenorContext _localctx = new MenorContext(_ctx, getState());
		enterRule(_localctx, 26, RULE_menor);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(187);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case TkId:
				{
				setState(185);
				ident();
				}
				break;
			case TkOBracket:
			case TkTrue:
			case TkFalse:
			case TkNum:
			case TkString:
				{
				setState(186);
				lit();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			setState(189);
			match(TkLess);
			setState(192);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case TkId:
				{
				setState(190);
				ident();
				}
				break;
			case TkOBracket:
			case TkTrue:
			case TkFalse:
			case TkNum:
			case TkString:
				{
				setState(191);
				lit();
				}
				break;
			default:
				throw new NoViableAltException(this);
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
	public static class MayorigContext extends ParserRuleContext {
		public TerminalNode TkGeq() { return getToken(GCLGrammarParser.TkGeq, 0); }
		public List<IdentContext> ident() {
			return getRuleContexts(IdentContext.class);
		}
		public IdentContext ident(int i) {
			return getRuleContext(IdentContext.class,i);
		}
		public List<LitContext> lit() {
			return getRuleContexts(LitContext.class);
		}
		public LitContext lit(int i) {
			return getRuleContext(LitContext.class,i);
		}
		public MayorigContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_mayorig; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GCLGrammarListener ) ((GCLGrammarListener)listener).enterMayorig(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GCLGrammarListener ) ((GCLGrammarListener)listener).exitMayorig(this);
		}
	}

	public final MayorigContext mayorig() throws RecognitionException {
		MayorigContext _localctx = new MayorigContext(_ctx, getState());
		enterRule(_localctx, 28, RULE_mayorig);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(196);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case TkId:
				{
				setState(194);
				ident();
				}
				break;
			case TkOBracket:
			case TkTrue:
			case TkFalse:
			case TkNum:
			case TkString:
				{
				setState(195);
				lit();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			setState(198);
			match(TkGeq);
			setState(201);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case TkId:
				{
				setState(199);
				ident();
				}
				break;
			case TkOBracket:
			case TkTrue:
			case TkFalse:
			case TkNum:
			case TkString:
				{
				setState(200);
				lit();
				}
				break;
			default:
				throw new NoViableAltException(this);
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
	public static class MenorigContext extends ParserRuleContext {
		public TerminalNode TkLeq() { return getToken(GCLGrammarParser.TkLeq, 0); }
		public List<IdentContext> ident() {
			return getRuleContexts(IdentContext.class);
		}
		public IdentContext ident(int i) {
			return getRuleContext(IdentContext.class,i);
		}
		public List<LitContext> lit() {
			return getRuleContexts(LitContext.class);
		}
		public LitContext lit(int i) {
			return getRuleContext(LitContext.class,i);
		}
		public MenorigContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_menorig; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GCLGrammarListener ) ((GCLGrammarListener)listener).enterMenorig(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GCLGrammarListener ) ((GCLGrammarListener)listener).exitMenorig(this);
		}
	}

	public final MenorigContext menorig() throws RecognitionException {
		MenorigContext _localctx = new MenorigContext(_ctx, getState());
		enterRule(_localctx, 30, RULE_menorig);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(205);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case TkId:
				{
				setState(203);
				ident();
				}
				break;
			case TkOBracket:
			case TkTrue:
			case TkFalse:
			case TkNum:
			case TkString:
				{
				setState(204);
				lit();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			setState(207);
			match(TkLeq);
			setState(210);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case TkId:
				{
				setState(208);
				ident();
				}
				break;
			case TkOBracket:
			case TkTrue:
			case TkFalse:
			case TkNum:
			case TkString:
				{
				setState(209);
				lit();
				}
				break;
			default:
				throw new NoViableAltException(this);
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
	public static class DesigContext extends ParserRuleContext {
		public TerminalNode TkNEqual() { return getToken(GCLGrammarParser.TkNEqual, 0); }
		public List<IdentContext> ident() {
			return getRuleContexts(IdentContext.class);
		}
		public IdentContext ident(int i) {
			return getRuleContext(IdentContext.class,i);
		}
		public List<LitContext> lit() {
			return getRuleContexts(LitContext.class);
		}
		public LitContext lit(int i) {
			return getRuleContext(LitContext.class,i);
		}
		public DesigContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_desig; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GCLGrammarListener ) ((GCLGrammarListener)listener).enterDesig(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GCLGrammarListener ) ((GCLGrammarListener)listener).exitDesig(this);
		}
	}

	public final DesigContext desig() throws RecognitionException {
		DesigContext _localctx = new DesigContext(_ctx, getState());
		enterRule(_localctx, 32, RULE_desig);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(214);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case TkId:
				{
				setState(212);
				ident();
				}
				break;
			case TkOBracket:
			case TkTrue:
			case TkFalse:
			case TkNum:
			case TkString:
				{
				setState(213);
				lit();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			setState(216);
			match(TkNEqual);
			setState(219);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case TkId:
				{
				setState(217);
				ident();
				}
				break;
			case TkOBracket:
			case TkTrue:
			case TkFalse:
			case TkNum:
			case TkString:
				{
				setState(218);
				lit();
				}
				break;
			default:
				throw new NoViableAltException(this);
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
	public static class YContext extends ParserRuleContext {
		public TerminalNode TkAnd() { return getToken(GCLGrammarParser.TkAnd, 0); }
		public List<IdentContext> ident() {
			return getRuleContexts(IdentContext.class);
		}
		public IdentContext ident(int i) {
			return getRuleContext(IdentContext.class,i);
		}
		public List<LitContext> lit() {
			return getRuleContexts(LitContext.class);
		}
		public LitContext lit(int i) {
			return getRuleContext(LitContext.class,i);
		}
		public YContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_y; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GCLGrammarListener ) ((GCLGrammarListener)listener).enterY(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GCLGrammarListener ) ((GCLGrammarListener)listener).exitY(this);
		}
	}

	public final YContext y() throws RecognitionException {
		YContext _localctx = new YContext(_ctx, getState());
		enterRule(_localctx, 34, RULE_y);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(223);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case TkId:
				{
				setState(221);
				ident();
				}
				break;
			case TkOBracket:
			case TkTrue:
			case TkFalse:
			case TkNum:
			case TkString:
				{
				setState(222);
				lit();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			setState(225);
			match(TkAnd);
			setState(228);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case TkId:
				{
				setState(226);
				ident();
				}
				break;
			case TkOBracket:
			case TkTrue:
			case TkFalse:
			case TkNum:
			case TkString:
				{
				setState(227);
				lit();
				}
				break;
			default:
				throw new NoViableAltException(this);
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
	public static class OContext extends ParserRuleContext {
		public TerminalNode TkOr() { return getToken(GCLGrammarParser.TkOr, 0); }
		public List<IdentContext> ident() {
			return getRuleContexts(IdentContext.class);
		}
		public IdentContext ident(int i) {
			return getRuleContext(IdentContext.class,i);
		}
		public List<LitContext> lit() {
			return getRuleContexts(LitContext.class);
		}
		public LitContext lit(int i) {
			return getRuleContext(LitContext.class,i);
		}
		public OContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_o; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GCLGrammarListener ) ((GCLGrammarListener)listener).enterO(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GCLGrammarListener ) ((GCLGrammarListener)listener).exitO(this);
		}
	}

	public final OContext o() throws RecognitionException {
		OContext _localctx = new OContext(_ctx, getState());
		enterRule(_localctx, 36, RULE_o);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(232);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case TkId:
				{
				setState(230);
				ident();
				}
				break;
			case TkOBracket:
			case TkTrue:
			case TkFalse:
			case TkNum:
			case TkString:
				{
				setState(231);
				lit();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			setState(234);
			match(TkOr);
			setState(237);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case TkId:
				{
				setState(235);
				ident();
				}
				break;
			case TkOBracket:
			case TkTrue:
			case TkFalse:
			case TkNum:
			case TkString:
				{
				setState(236);
				lit();
				}
				break;
			default:
				throw new NoViableAltException(this);
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
	public static class NoContext extends ParserRuleContext {
		public TerminalNode TkNot() { return getToken(GCLGrammarParser.TkNot, 0); }
		public IdentContext ident() {
			return getRuleContext(IdentContext.class,0);
		}
		public LitContext lit() {
			return getRuleContext(LitContext.class,0);
		}
		public NoContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_no; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GCLGrammarListener ) ((GCLGrammarListener)listener).enterNo(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GCLGrammarListener ) ((GCLGrammarListener)listener).exitNo(this);
		}
	}

	public final NoContext no() throws RecognitionException {
		NoContext _localctx = new NoContext(_ctx, getState());
		enterRule(_localctx, 38, RULE_no);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(239);
			match(TkNot);
			setState(242);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case TkId:
				{
				setState(240);
				ident();
				}
				break;
			case TkOBracket:
			case TkTrue:
			case TkFalse:
			case TkNum:
			case TkString:
				{
				setState(241);
				lit();
				}
				break;
			default:
				throw new NoViableAltException(this);
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
	public static class ConcContext extends ParserRuleContext {
		public TerminalNode TkConcat() { return getToken(GCLGrammarParser.TkConcat, 0); }
		public List<LitContext> lit() {
			return getRuleContexts(LitContext.class);
		}
		public LitContext lit(int i) {
			return getRuleContext(LitContext.class,i);
		}
		public List<IdentContext> ident() {
			return getRuleContexts(IdentContext.class);
		}
		public IdentContext ident(int i) {
			return getRuleContext(IdentContext.class,i);
		}
		public List<ConcContext> conc() {
			return getRuleContexts(ConcContext.class);
		}
		public ConcContext conc(int i) {
			return getRuleContext(ConcContext.class,i);
		}
		public ConcContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_conc; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GCLGrammarListener ) ((GCLGrammarListener)listener).enterConc(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GCLGrammarListener ) ((GCLGrammarListener)listener).exitConc(this);
		}
	}

	public final ConcContext conc() throws RecognitionException {
		ConcContext _localctx = new ConcContext(_ctx, getState());
		enterRule(_localctx, 40, RULE_conc);
		try {
			int _alt;
			setState(264);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,38,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(246);
				_errHandler.sync(this);
				switch (_input.LA(1)) {
				case TkOBracket:
				case TkTrue:
				case TkFalse:
				case TkNum:
				case TkString:
					{
					setState(244);
					lit();
					}
					break;
				case TkId:
					{
					setState(245);
					ident();
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(248);
				match(TkConcat);
				setState(252);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,35,_ctx);
				while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
					if ( _alt==1 ) {
						{
						{
						setState(249);
						conc();
						}
						} 
					}
					setState(254);
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,35,_ctx);
				}
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(257);
				_errHandler.sync(this);
				switch (_input.LA(1)) {
				case TkOBracket:
				case TkTrue:
				case TkFalse:
				case TkNum:
				case TkString:
					{
					setState(255);
					lit();
					}
					break;
				case TkId:
					{
					setState(256);
					ident();
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(259);
				match(TkConcat);
				setState(262);
				_errHandler.sync(this);
				switch (_input.LA(1)) {
				case TkOBracket:
				case TkTrue:
				case TkFalse:
				case TkNum:
				case TkString:
					{
					setState(260);
					lit();
					}
					break;
				case TkId:
					{
					setState(261);
					ident();
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
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
	public static class IdentContext extends ParserRuleContext {
		public TerminalNode TkId() { return getToken(GCLGrammarParser.TkId, 0); }
		public IdentContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_ident; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GCLGrammarListener ) ((GCLGrammarListener)listener).enterIdent(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GCLGrammarListener ) ((GCLGrammarListener)listener).exitIdent(this);
		}
	}

	public final IdentContext ident() throws RecognitionException {
		IdentContext _localctx = new IdentContext(_ctx, getState());
		enterRule(_localctx, 42, RULE_ident);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(266);
			match(TkId);
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
	public static class ReadAContext extends ParserRuleContext {
		public TerminalNode TkId() { return getToken(GCLGrammarParser.TkId, 0); }
		public TerminalNode TkOBracket() { return getToken(GCLGrammarParser.TkOBracket, 0); }
		public TerminalNode TkNum() { return getToken(GCLGrammarParser.TkNum, 0); }
		public TerminalNode TkCBracket() { return getToken(GCLGrammarParser.TkCBracket, 0); }
		public ReadAContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_readA; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GCLGrammarListener ) ((GCLGrammarListener)listener).enterReadA(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GCLGrammarListener ) ((GCLGrammarListener)listener).exitReadA(this);
		}
	}

	public final ReadAContext readA() throws RecognitionException {
		ReadAContext _localctx = new ReadAContext(_ctx, getState());
		enterRule(_localctx, 44, RULE_readA);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(268);
			match(TkId);
			setState(269);
			match(TkOBracket);
			setState(270);
			match(TkNum);
			setState(271);
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
	public static class LitContext extends ParserRuleContext {
		public List<TerminalNode> TkNum() { return getTokens(GCLGrammarParser.TkNum); }
		public TerminalNode TkNum(int i) {
			return getToken(GCLGrammarParser.TkNum, i);
		}
		public TerminalNode TkTrue() { return getToken(GCLGrammarParser.TkTrue, 0); }
		public TerminalNode TkFalse() { return getToken(GCLGrammarParser.TkFalse, 0); }
		public TerminalNode TkString() { return getToken(GCLGrammarParser.TkString, 0); }
		public TerminalNode TkOBracket() { return getToken(GCLGrammarParser.TkOBracket, 0); }
		public TerminalNode TkSoForth() { return getToken(GCLGrammarParser.TkSoForth, 0); }
		public TerminalNode TkCBracket() { return getToken(GCLGrammarParser.TkCBracket, 0); }
		public LitContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_lit; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GCLGrammarListener ) ((GCLGrammarListener)listener).enterLit(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GCLGrammarListener ) ((GCLGrammarListener)listener).exitLit(this);
		}
	}

	public final LitContext lit() throws RecognitionException {
		LitContext _localctx = new LitContext(_ctx, getState());
		enterRule(_localctx, 46, RULE_lit);
		try {
			setState(282);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case TkNum:
				enterOuterAlt(_localctx, 1);
				{
				setState(273);
				match(TkNum);
				}
				break;
			case TkTrue:
				enterOuterAlt(_localctx, 2);
				{
				setState(274);
				match(TkTrue);
				}
				break;
			case TkFalse:
				enterOuterAlt(_localctx, 3);
				{
				setState(275);
				match(TkFalse);
				}
				break;
			case TkString:
				enterOuterAlt(_localctx, 4);
				{
				setState(276);
				match(TkString);
				}
				break;
			case TkOBracket:
				enterOuterAlt(_localctx, 5);
				{
				setState(277);
				match(TkOBracket);
				setState(278);
				match(TkNum);
				setState(279);
				match(TkSoForth);
				setState(280);
				match(TkNum);
				setState(281);
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

	public static final String _serializedATN =
		"\u0004\u0001/\u011d\u0002\u0000\u0007\u0000\u0002\u0001\u0007\u0001\u0002"+
		"\u0002\u0007\u0002\u0002\u0003\u0007\u0003\u0002\u0004\u0007\u0004\u0002"+
		"\u0005\u0007\u0005\u0002\u0006\u0007\u0006\u0002\u0007\u0007\u0007\u0002"+
		"\b\u0007\b\u0002\t\u0007\t\u0002\n\u0007\n\u0002\u000b\u0007\u000b\u0002"+
		"\f\u0007\f\u0002\r\u0007\r\u0002\u000e\u0007\u000e\u0002\u000f\u0007\u000f"+
		"\u0002\u0010\u0007\u0010\u0002\u0011\u0007\u0011\u0002\u0012\u0007\u0012"+
		"\u0002\u0013\u0007\u0013\u0002\u0014\u0007\u0014\u0002\u0015\u0007\u0015"+
		"\u0002\u0016\u0007\u0016\u0002\u0017\u0007\u0017\u0001\u0000\u0001\u0000"+
		"\u0005\u00003\b\u0000\n\u0000\f\u00006\t\u0000\u0001\u0000\u0001\u0000"+
		"\u0001\u0000\u0001\u0001\u0001\u0001\u0001\u0001\u0003\u0001>\b\u0001"+
		"\u0001\u0002\u0001\u0002\u0001\u0002\u0004\u0002C\b\u0002\u000b\u0002"+
		"\f\u0002D\u0001\u0002\u0001\u0002\u0005\u0002I\b\u0002\n\u0002\f\u0002"+
		"L\t\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0005\u0002Q\b\u0002\n\u0002"+
		"\f\u0002T\t\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0005\u0002Y\b\u0002"+
		"\n\u0002\f\u0002\\\t\u0002\u0003\u0002^\b\u0002\u0001\u0003\u0001\u0003"+
		"\u0001\u0003\u0005\u0003c\b\u0003\n\u0003\f\u0003f\t\u0003\u0001\u0003"+
		"\u0001\u0003\u0001\u0003\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004"+
		"\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0003\u0004s\b\u0004"+
		"\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0003\u0005y\b\u0005"+
		"\u0001\u0006\u0001\u0006\u0001\u0006\u0001\u0006\u0001\u0006\u0003\u0006"+
		"\u0080\b\u0006\u0001\u0007\u0001\u0007\u0001\u0007\u0001\u0007\u0001\u0007"+
		"\u0001\u0007\u0001\u0007\u0001\u0007\u0001\u0007\u0001\u0007\u0001\u0007"+
		"\u0001\u0007\u0001\u0007\u0003\u0007\u008f\b\u0007\u0001\b\u0001\b\u0003"+
		"\b\u0093\b\b\u0001\b\u0001\b\u0001\b\u0003\b\u0098\b\b\u0001\t\u0001\t"+
		"\u0003\t\u009c\b\t\u0001\t\u0001\t\u0001\t\u0003\t\u00a1\b\t\u0001\n\u0001"+
		"\n\u0003\n\u00a5\b\n\u0001\n\u0001\n\u0001\n\u0003\n\u00aa\b\n\u0001\u000b"+
		"\u0001\u000b\u0001\u000b\u0003\u000b\u00af\b\u000b\u0001\f\u0001\f\u0003"+
		"\f\u00b3\b\f\u0001\f\u0001\f\u0001\f\u0003\f\u00b8\b\f\u0001\r\u0001\r"+
		"\u0003\r\u00bc\b\r\u0001\r\u0001\r\u0001\r\u0003\r\u00c1\b\r\u0001\u000e"+
		"\u0001\u000e\u0003\u000e\u00c5\b\u000e\u0001\u000e\u0001\u000e\u0001\u000e"+
		"\u0003\u000e\u00ca\b\u000e\u0001\u000f\u0001\u000f\u0003\u000f\u00ce\b"+
		"\u000f\u0001\u000f\u0001\u000f\u0001\u000f\u0003\u000f\u00d3\b\u000f\u0001"+
		"\u0010\u0001\u0010\u0003\u0010\u00d7\b\u0010\u0001\u0010\u0001\u0010\u0001"+
		"\u0010\u0003\u0010\u00dc\b\u0010\u0001\u0011\u0001\u0011\u0003\u0011\u00e0"+
		"\b\u0011\u0001\u0011\u0001\u0011\u0001\u0011\u0003\u0011\u00e5\b\u0011"+
		"\u0001\u0012\u0001\u0012\u0003\u0012\u00e9\b\u0012\u0001\u0012\u0001\u0012"+
		"\u0001\u0012\u0003\u0012\u00ee\b\u0012\u0001\u0013\u0001\u0013\u0001\u0013"+
		"\u0003\u0013\u00f3\b\u0013\u0001\u0014\u0001\u0014\u0003\u0014\u00f7\b"+
		"\u0014\u0001\u0014\u0001\u0014\u0005\u0014\u00fb\b\u0014\n\u0014\f\u0014"+
		"\u00fe\t\u0014\u0001\u0014\u0001\u0014\u0003\u0014\u0102\b\u0014\u0001"+
		"\u0014\u0001\u0014\u0001\u0014\u0003\u0014\u0107\b\u0014\u0003\u0014\u0109"+
		"\b\u0014\u0001\u0015\u0001\u0015\u0001\u0016\u0001\u0016\u0001\u0016\u0001"+
		"\u0016\u0001\u0016\u0001\u0017\u0001\u0017\u0001\u0017\u0001\u0017\u0001"+
		"\u0017\u0001\u0017\u0001\u0017\u0001\u0017\u0001\u0017\u0003\u0017\u011b"+
		"\b\u0017\u0001\u0017\u0000\u0000\u0018\u0000\u0002\u0004\u0006\b\n\f\u000e"+
		"\u0010\u0012\u0014\u0016\u0018\u001a\u001c\u001e \"$&(*,.\u0000\u0000"+
		"\u013e\u00000\u0001\u0000\u0000\u0000\u0002:\u0001\u0000\u0000\u0000\u0004"+
		"]\u0001\u0000\u0000\u0000\u0006_\u0001\u0000\u0000\u0000\br\u0001\u0000"+
		"\u0000\u0000\nt\u0001\u0000\u0000\u0000\fz\u0001\u0000\u0000\u0000\u000e"+
		"\u008e\u0001\u0000\u0000\u0000\u0010\u0092\u0001\u0000\u0000\u0000\u0012"+
		"\u009b\u0001\u0000\u0000\u0000\u0014\u00a4\u0001\u0000\u0000\u0000\u0016"+
		"\u00ab\u0001\u0000\u0000\u0000\u0018\u00b2\u0001\u0000\u0000\u0000\u001a"+
		"\u00bb\u0001\u0000\u0000\u0000\u001c\u00c4\u0001\u0000\u0000\u0000\u001e"+
		"\u00cd\u0001\u0000\u0000\u0000 \u00d6\u0001\u0000\u0000\u0000\"\u00df"+
		"\u0001\u0000\u0000\u0000$\u00e8\u0001\u0000\u0000\u0000&\u00ef\u0001\u0000"+
		"\u0000\u0000(\u0108\u0001\u0000\u0000\u0000*\u010a\u0001\u0000\u0000\u0000"+
		",\u010c\u0001\u0000\u0000\u0000.\u011a\u0001\u0000\u0000\u000004\u0005"+
		"\u0013\u0000\u000013\u0003\u0002\u0001\u000021\u0001\u0000\u0000\u0000"+
		"36\u0001\u0000\u0000\u000042\u0001\u0000\u0000\u000045\u0001\u0000\u0000"+
		"\u000057\u0001\u0000\u0000\u000064\u0001\u0000\u0000\u000078\u0003\u0004"+
		"\u0002\u000089\u0005\u0014\u0000\u00009\u0001\u0001\u0000\u0000\u0000"+
		":=\u0005\u000e\u0000\u0000;>\u0003\u0004\u0002\u0000<>\u0003\u0006\u0003"+
		"\u0000=;\u0001\u0000\u0000\u0000=<\u0001\u0000\u0000\u0000>\u0003\u0001"+
		"\u0000\u0000\u0000?B\u0003\u0006\u0003\u0000@A\u0005\u0012\u0000\u0000"+
		"AC\u0003\u0006\u0003\u0000B@\u0001\u0000\u0000\u0000CD\u0001\u0000\u0000"+
		"\u0000DB\u0001\u0000\u0000\u0000DE\u0001\u0000\u0000\u0000EJ\u0001\u0000"+
		"\u0000\u0000FG\u0005\u0012\u0000\u0000GI\u0003\u0004\u0002\u0000HF\u0001"+
		"\u0000\u0000\u0000IL\u0001\u0000\u0000\u0000JH\u0001\u0000\u0000\u0000"+
		"JK\u0001\u0000\u0000\u0000K^\u0001\u0000\u0000\u0000LJ\u0001\u0000\u0000"+
		"\u0000MR\u0003\n\u0005\u0000NO\u0005\u0012\u0000\u0000OQ\u0003\u0004\u0002"+
		"\u0000PN\u0001\u0000\u0000\u0000QT\u0001\u0000\u0000\u0000RP\u0001\u0000"+
		"\u0000\u0000RS\u0001\u0000\u0000\u0000S^\u0001\u0000\u0000\u0000TR\u0001"+
		"\u0000\u0000\u0000UZ\u0003\f\u0006\u0000VW\u0005\u0012\u0000\u0000WY\u0003"+
		"\u0004\u0002\u0000XV\u0001\u0000\u0000\u0000Y\\\u0001\u0000\u0000\u0000"+
		"ZX\u0001\u0000\u0000\u0000Z[\u0001\u0000\u0000\u0000[^\u0001\u0000\u0000"+
		"\u0000\\Z\u0001\u0000\u0000\u0000]?\u0001\u0000\u0000\u0000]M\u0001\u0000"+
		"\u0000\u0000]U\u0001\u0000\u0000\u0000^\u0005\u0001\u0000\u0000\u0000"+
		"_d\u0005-\u0000\u0000`a\u0005\u000f\u0000\u0000ac\u0005-\u0000\u0000b"+
		"`\u0001\u0000\u0000\u0000cf\u0001\u0000\u0000\u0000db\u0001\u0000\u0000"+
		"\u0000de\u0001\u0000\u0000\u0000eg\u0001\u0000\u0000\u0000fd\u0001\u0000"+
		"\u0000\u0000gh\u0005 \u0000\u0000hi\u0003\b\u0004\u0000i\u0007\u0001\u0000"+
		"\u0000\u0000js\u0005\u0007\u0000\u0000ks\u0005\b\u0000\u0000lm\u0005\u000b"+
		"\u0000\u0000mn\u0005\u001a\u0000\u0000no\u0005+\u0000\u0000op\u0005\u0015"+
		"\u0000\u0000pq\u0005+\u0000\u0000qs\u0005\u001b\u0000\u0000rj\u0001\u0000"+
		"\u0000\u0000rk\u0001\u0000\u0000\u0000rl\u0001\u0000\u0000\u0000s\t\u0001"+
		"\u0000\u0000\u0000tu\u0005-\u0000\u0000ux\u0005\u0016\u0000\u0000vy\u0003"+
		".\u0017\u0000wy\u0003\u000e\u0007\u0000xv\u0001\u0000\u0000\u0000xw\u0001"+
		"\u0000\u0000\u0000y\u000b\u0001\u0000\u0000\u0000z\u007f\u0005\r\u0000"+
		"\u0000{\u0080\u0003\u000e\u0007\u0000|\u0080\u0003.\u0017\u0000}\u0080"+
		"\u0003*\u0015\u0000~\u0080\u0003,\u0016\u0000\u007f{\u0001\u0000\u0000"+
		"\u0000\u007f|\u0001\u0000\u0000\u0000\u007f}\u0001\u0000\u0000\u0000\u007f"+
		"~\u0001\u0000\u0000\u0000\u0080\r\u0001\u0000\u0000\u0000\u0081\u008f"+
		"\u0003\u0010\b\u0000\u0082\u008f\u0003\u0012\t\u0000\u0083\u008f\u0003"+
		"\u0014\n\u0000\u0084\u008f\u0003\u0016\u000b\u0000\u0085\u008f\u0003\u0018"+
		"\f\u0000\u0086\u008f\u0003\u001a\r\u0000\u0087\u008f\u0003\u001c\u000e"+
		"\u0000\u0088\u008f\u0003\u001e\u000f\u0000\u0089\u008f\u0003\"\u0011\u0000"+
		"\u008a\u008f\u0003$\u0012\u0000\u008b\u008f\u0003&\u0013\u0000\u008c\u008f"+
		"\u0003 \u0010\u0000\u008d\u008f\u0003(\u0014\u0000\u008e\u0081\u0001\u0000"+
		"\u0000\u0000\u008e\u0082\u0001\u0000\u0000\u0000\u008e\u0083\u0001\u0000"+
		"\u0000\u0000\u008e\u0084\u0001\u0000\u0000\u0000\u008e\u0085\u0001\u0000"+
		"\u0000\u0000\u008e\u0086\u0001\u0000\u0000\u0000\u008e\u0087\u0001\u0000"+
		"\u0000\u0000\u008e\u0088\u0001\u0000\u0000\u0000\u008e\u0089\u0001\u0000"+
		"\u0000\u0000\u008e\u008a\u0001\u0000\u0000\u0000\u008e\u008b\u0001\u0000"+
		"\u0000\u0000\u008e\u008c\u0001\u0000\u0000\u0000\u008e\u008d\u0001\u0000"+
		"\u0000\u0000\u008f\u000f\u0001\u0000\u0000\u0000\u0090\u0093\u0003*\u0015"+
		"\u0000\u0091\u0093\u0003.\u0017\u0000\u0092\u0090\u0001\u0000\u0000\u0000"+
		"\u0092\u0091\u0001\u0000\u0000\u0000\u0093\u0094\u0001\u0000\u0000\u0000"+
		"\u0094\u0097\u0005\u001c\u0000\u0000\u0095\u0098\u0003*\u0015\u0000\u0096"+
		"\u0098\u0003.\u0017\u0000\u0097\u0095\u0001\u0000\u0000\u0000\u0097\u0096"+
		"\u0001\u0000\u0000\u0000\u0098\u0011\u0001\u0000\u0000\u0000\u0099\u009c"+
		"\u0003*\u0015\u0000\u009a\u009c\u0003.\u0017\u0000\u009b\u0099\u0001\u0000"+
		"\u0000\u0000\u009b\u009a\u0001\u0000\u0000\u0000\u009c\u009d\u0001\u0000"+
		"\u0000\u0000\u009d\u00a0\u0005\u001d\u0000\u0000\u009e\u00a1\u0003*\u0015"+
		"\u0000\u009f\u00a1\u0003.\u0017\u0000\u00a0\u009e\u0001\u0000\u0000\u0000"+
		"\u00a0\u009f\u0001\u0000\u0000\u0000\u00a1\u0013\u0001\u0000\u0000\u0000"+
		"\u00a2\u00a5\u0003*\u0015\u0000\u00a3\u00a5\u0003.\u0017\u0000\u00a4\u00a2"+
		"\u0001\u0000\u0000\u0000\u00a4\u00a3\u0001\u0000\u0000\u0000\u00a5\u00a6"+
		"\u0001\u0000\u0000\u0000\u00a6\u00a9\u0005\u001e\u0000\u0000\u00a7\u00aa"+
		"\u0003*\u0015\u0000\u00a8\u00aa\u0003.\u0017\u0000\u00a9\u00a7\u0001\u0000"+
		"\u0000\u0000\u00a9\u00a8\u0001\u0000\u0000\u0000\u00aa\u0015\u0001\u0000"+
		"\u0000\u0000\u00ab\u00ae\u0005\u001d\u0000\u0000\u00ac\u00af\u0003*\u0015"+
		"\u0000\u00ad\u00af\u0003.\u0017\u0000\u00ae\u00ac\u0001\u0000\u0000\u0000"+
		"\u00ae\u00ad\u0001\u0000\u0000\u0000\u00af\u0017\u0001\u0000\u0000\u0000"+
		"\u00b0\u00b3\u0003*\u0015\u0000\u00b1\u00b3\u0003.\u0017\u0000\u00b2\u00b0"+
		"\u0001\u0000\u0000\u0000\u00b2\u00b1\u0001\u0000\u0000\u0000\u00b3\u00b4"+
		"\u0001\u0000\u0000\u0000\u00b4\u00b7\u0005\"\u0000\u0000\u00b5\u00b8\u0003"+
		"*\u0015\u0000\u00b6\u00b8\u0003.\u0017\u0000\u00b7\u00b5\u0001\u0000\u0000"+
		"\u0000\u00b7\u00b6\u0001\u0000\u0000\u0000\u00b8\u0019\u0001\u0000\u0000"+
		"\u0000\u00b9\u00bc\u0003*\u0015\u0000\u00ba\u00bc\u0003.\u0017\u0000\u00bb"+
		"\u00b9\u0001\u0000\u0000\u0000\u00bb\u00ba\u0001\u0000\u0000\u0000\u00bc"+
		"\u00bd\u0001\u0000\u0000\u0000\u00bd\u00c0\u0005!\u0000\u0000\u00be\u00c1"+
		"\u0003*\u0015\u0000\u00bf\u00c1\u0003.\u0017\u0000\u00c0\u00be\u0001\u0000"+
		"\u0000\u0000\u00c0\u00bf\u0001\u0000\u0000\u0000\u00c1\u001b\u0001\u0000"+
		"\u0000\u0000\u00c2\u00c5\u0003*\u0015\u0000\u00c3\u00c5\u0003.\u0017\u0000"+
		"\u00c4\u00c2\u0001\u0000\u0000\u0000\u00c4\u00c3\u0001\u0000\u0000\u0000"+
		"\u00c5\u00c6\u0001\u0000\u0000\u0000\u00c6\u00c9\u0005%\u0000\u0000\u00c7"+
		"\u00ca\u0003*\u0015\u0000\u00c8\u00ca\u0003.\u0017\u0000\u00c9\u00c7\u0001"+
		"\u0000\u0000\u0000\u00c9\u00c8\u0001\u0000\u0000\u0000\u00ca\u001d\u0001"+
		"\u0000\u0000\u0000\u00cb\u00ce\u0003*\u0015\u0000\u00cc\u00ce\u0003.\u0017"+
		"\u0000\u00cd\u00cb\u0001\u0000\u0000\u0000\u00cd\u00cc\u0001\u0000\u0000"+
		"\u0000\u00ce\u00cf\u0001\u0000\u0000\u0000\u00cf\u00d2\u0005$\u0000\u0000"+
		"\u00d0\u00d3\u0003*\u0015\u0000\u00d1\u00d3\u0003.\u0017\u0000\u00d2\u00d0"+
		"\u0001\u0000\u0000\u0000\u00d2\u00d1\u0001\u0000\u0000\u0000\u00d3\u001f"+
		"\u0001\u0000\u0000\u0000\u00d4\u00d7\u0003*\u0015\u0000\u00d5\u00d7\u0003"+
		".\u0017\u0000\u00d6\u00d4\u0001\u0000\u0000\u0000\u00d6\u00d5\u0001\u0000"+
		"\u0000\u0000\u00d7\u00d8\u0001\u0000\u0000\u0000\u00d8\u00db\u0005#\u0000"+
		"\u0000\u00d9\u00dc\u0003*\u0015\u0000\u00da\u00dc\u0003.\u0017\u0000\u00db"+
		"\u00d9\u0001\u0000\u0000\u0000\u00db\u00da\u0001\u0000\u0000\u0000\u00dc"+
		"!\u0001\u0000\u0000\u0000\u00dd\u00e0\u0003*\u0015\u0000\u00de\u00e0\u0003"+
		".\u0017\u0000\u00df\u00dd\u0001\u0000\u0000\u0000\u00df\u00de\u0001\u0000"+
		"\u0000\u0000\u00e0\u00e1\u0001\u0000\u0000\u0000\u00e1\u00e4\u0005(\u0000"+
		"\u0000\u00e2\u00e5\u0003*\u0015\u0000\u00e3\u00e5\u0003.\u0017\u0000\u00e4"+
		"\u00e2\u0001\u0000\u0000\u0000\u00e4\u00e3\u0001\u0000\u0000\u0000\u00e5"+
		"#\u0001\u0000\u0000\u0000\u00e6\u00e9\u0003*\u0015\u0000\u00e7\u00e9\u0003"+
		".\u0017\u0000\u00e8\u00e6\u0001\u0000\u0000\u0000\u00e8\u00e7\u0001\u0000"+
		"\u0000\u0000\u00e9\u00ea\u0001\u0000\u0000\u0000\u00ea\u00ed\u0005\'\u0000"+
		"\u0000\u00eb\u00ee\u0003*\u0015\u0000\u00ec\u00ee\u0003.\u0017\u0000\u00ed"+
		"\u00eb\u0001\u0000\u0000\u0000\u00ed\u00ec\u0001\u0000\u0000\u0000\u00ee"+
		"%\u0001\u0000\u0000\u0000\u00ef\u00f2\u0005\u001f\u0000\u0000\u00f0\u00f3"+
		"\u0003*\u0015\u0000\u00f1\u00f3\u0003.\u0017\u0000\u00f2\u00f0\u0001\u0000"+
		"\u0000\u0000\u00f2\u00f1\u0001\u0000\u0000\u0000\u00f3\'\u0001\u0000\u0000"+
		"\u0000\u00f4\u00f7\u0003.\u0017\u0000\u00f5\u00f7\u0003*\u0015\u0000\u00f6"+
		"\u00f4\u0001\u0000\u0000\u0000\u00f6\u00f5\u0001\u0000\u0000\u0000\u00f7"+
		"\u00f8\u0001\u0000\u0000\u0000\u00f8\u00fc\u0005\u0019\u0000\u0000\u00f9"+
		"\u00fb\u0003(\u0014\u0000\u00fa\u00f9\u0001\u0000\u0000\u0000\u00fb\u00fe"+
		"\u0001\u0000\u0000\u0000\u00fc\u00fa\u0001\u0000\u0000\u0000\u00fc\u00fd"+
		"\u0001\u0000\u0000\u0000\u00fd\u0109\u0001\u0000\u0000\u0000\u00fe\u00fc"+
		"\u0001\u0000\u0000\u0000\u00ff\u0102\u0003.\u0017\u0000\u0100\u0102\u0003"+
		"*\u0015\u0000\u0101\u00ff\u0001\u0000\u0000\u0000\u0101\u0100\u0001\u0000"+
		"\u0000\u0000\u0102\u0103\u0001\u0000\u0000\u0000\u0103\u0106\u0005\u0019"+
		"\u0000\u0000\u0104\u0107\u0003.\u0017\u0000\u0105\u0107\u0003*\u0015\u0000"+
		"\u0106\u0104\u0001\u0000\u0000\u0000\u0106\u0105\u0001\u0000\u0000\u0000"+
		"\u0107\u0109\u0001\u0000\u0000\u0000\u0108\u00f6\u0001\u0000\u0000\u0000"+
		"\u0108\u0101\u0001\u0000\u0000\u0000\u0109)\u0001\u0000\u0000\u0000\u010a"+
		"\u010b\u0005-\u0000\u0000\u010b+\u0001\u0000\u0000\u0000\u010c\u010d\u0005"+
		"-\u0000\u0000\u010d\u010e\u0005\u001a\u0000\u0000\u010e\u010f\u0005+\u0000"+
		"\u0000\u010f\u0110\u0005\u001b\u0000\u0000\u0110-\u0001\u0000\u0000\u0000"+
		"\u0111\u011b\u0005+\u0000\u0000\u0112\u011b\u0005)\u0000\u0000\u0113\u011b"+
		"\u0005*\u0000\u0000\u0114\u011b\u0005,\u0000\u0000\u0115\u0116\u0005\u001a"+
		"\u0000\u0000\u0116\u0117\u0005+\u0000\u0000\u0117\u0118\u0005\u0015\u0000"+
		"\u0000\u0118\u0119\u0005+\u0000\u0000\u0119\u011b\u0005\u001b\u0000\u0000"+
		"\u011a\u0111\u0001\u0000\u0000\u0000\u011a\u0112\u0001\u0000\u0000\u0000"+
		"\u011a\u0113\u0001\u0000\u0000\u0000\u011a\u0114\u0001\u0000\u0000\u0000"+
		"\u011a\u0115\u0001\u0000\u0000\u0000\u011b/\u0001\u0000\u0000\u0000(4"+
		"=DJRZ]drx\u007f\u008e\u0092\u0097\u009b\u00a0\u00a4\u00a9\u00ae\u00b2"+
		"\u00b7\u00bb\u00c0\u00c4\u00c9\u00cd\u00d2\u00d6\u00db\u00df\u00e4\u00e8"+
		"\u00ed\u00f2\u00f6\u00fc\u0101\u0106\u0108\u011a";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}