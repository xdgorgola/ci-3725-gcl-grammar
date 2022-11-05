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
		T__0=1, TkIf=2, TkFi=3, TkDo=4, TkOd=5, TkTo=6, TkIn=7, TkInt=8, TkBool=9, 
		TkFor=10, TkRof=11, TkArray=12, TkSkip=13, TkPrint=14, TkDeclare=15, TkComma=16, 
		TkOpenPar=17, TkClosePar=18, TkSemicolon=19, TkOBlock=20, TkCBlock=21, 
		TkSoForth=22, TkAsig=23, TkArrow=24, TkGuard=25, TkConcat=26, TkOBracket=27, 
		TkCBracket=28, TkPlus=29, TkMinus=30, TkMult=31, TkNot=32, TkTwoPoints=33, 
		TkLess=34, TkGreater=35, TkNEqual=36, TkLeq=37, TkGeq=38, TkEqual=39, 
		TkOr=40, TkAnd=41, TkTrue=42, TkFalse=43, TkNum=44, TkString=45, TkId=46, 
		SLCMT=47, WS=48;
	public static final int
		RULE_dummy_rule = 0;
	private static String[] makeRuleNames() {
		return new String[] {
			"dummy_rule"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "'a'", "'if'", "'fi'", "'do'", "'od'", "'to'", "'in'", "'int'", 
			"'bool'", "'for'", "'rof'", "'array'", "'skip'", "'print'", "'declare'", 
			"','", "'('", "')'", "';'", "'|['", "']|'", "'..'", "':='", "'-->'", 
			"'[]'", "'.'", "'['", "']'", "'+'", "'-'", "'*'", "'!'", "':'", "'<'", 
			"'>'", "'!='", "'<='", "'>='", "'=='", "'\\/'", "'/\\'", "'true'", "'false'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, null, "TkIf", "TkFi", "TkDo", "TkOd", "TkTo", "TkIn", "TkInt", 
			"TkBool", "TkFor", "TkRof", "TkArray", "TkSkip", "TkPrint", "TkDeclare", 
			"TkComma", "TkOpenPar", "TkClosePar", "TkSemicolon", "TkOBlock", "TkCBlock", 
			"TkSoForth", "TkAsig", "TkArrow", "TkGuard", "TkConcat", "TkOBracket", 
			"TkCBracket", "TkPlus", "TkMinus", "TkMult", "TkNot", "TkTwoPoints", 
			"TkLess", "TkGreater", "TkNEqual", "TkLeq", "TkGeq", "TkEqual", "TkOr", 
			"TkAnd", "TkTrue", "TkFalse", "TkNum", "TkString", "TkId", "SLCMT", "WS"
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
	public static class Dummy_ruleContext extends ParserRuleContext {
		public Dummy_ruleContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_dummy_rule; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GCLGrammarListener ) ((GCLGrammarListener)listener).enterDummy_rule(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GCLGrammarListener ) ((GCLGrammarListener)listener).exitDummy_rule(this);
		}
	}

	public final Dummy_ruleContext dummy_rule() throws RecognitionException {
		Dummy_ruleContext _localctx = new Dummy_ruleContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_dummy_rule);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(2);
			match(T__0);
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
		"\u0004\u00010\u0005\u0002\u0000\u0007\u0000\u0001\u0000\u0001\u0000\u0001"+
		"\u0000\u0000\u0000\u0001\u0000\u0000\u0000\u0003\u0000\u0002\u0001\u0000"+
		"\u0000\u0000\u0002\u0003\u0005\u0001\u0000\u0000\u0003\u0001\u0001\u0000"+
		"\u0000\u0000\u0000";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}