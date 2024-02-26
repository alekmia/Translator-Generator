// Generated from Grammar.g4 by ANTLR 4.13.1
package antlr;
import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.TokenStream;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.misc.*;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast", "CheckReturnValue", "this-escape"})
public class GrammarLexer extends Lexer {
	static { RuntimeMetaData.checkVersion("4.13.1", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__0=1, T__1=2, T__2=3, T__3=4, T__4=5, T__5=6, T__6=7, T__7=8, T__8=9, 
		T__9=10, T__10=11, NT_ID=12, T_ID=13, REGEX=14, STRING=15, CODE=16, WS=17;
	public static String[] channelNames = {
		"DEFAULT_TOKEN_CHANNEL", "HIDDEN"
	};

	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	private static String[] makeRuleNames() {
		return new String[] {
			"T__0", "T__1", "T__2", "T__3", "T__4", "T__5", "T__6", "T__7", "T__8", 
			"T__9", "T__10", "NT_ID", "T_ID", "REGEX", "STRING", "CODE", "WS"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "';'", "'->'", "'('", "')'", "':'", "'|'", "'<'", "','", "'>'", 
			"'='", "'\\='"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, null, null, null, null, null, null, null, null, null, null, null, 
			"NT_ID", "T_ID", "REGEX", "STRING", "CODE", "WS"
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


	public GrammarLexer(CharStream input) {
		super(input);
		_interp = new LexerATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@Override
	public String getGrammarFileName() { return "Grammar.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public String[] getChannelNames() { return channelNames; }

	@Override
	public String[] getModeNames() { return modeNames; }

	@Override
	public ATN getATN() { return _ATN; }

	public static final String _serializedATN =
		"\u0004\u0000\u0011v\u0006\uffff\uffff\u0002\u0000\u0007\u0000\u0002\u0001"+
		"\u0007\u0001\u0002\u0002\u0007\u0002\u0002\u0003\u0007\u0003\u0002\u0004"+
		"\u0007\u0004\u0002\u0005\u0007\u0005\u0002\u0006\u0007\u0006\u0002\u0007"+
		"\u0007\u0007\u0002\b\u0007\b\u0002\t\u0007\t\u0002\n\u0007\n\u0002\u000b"+
		"\u0007\u000b\u0002\f\u0007\f\u0002\r\u0007\r\u0002\u000e\u0007\u000e\u0002"+
		"\u000f\u0007\u000f\u0002\u0010\u0007\u0010\u0001\u0000\u0001\u0000\u0001"+
		"\u0001\u0001\u0001\u0001\u0001\u0001\u0002\u0001\u0002\u0001\u0003\u0001"+
		"\u0003\u0001\u0004\u0001\u0004\u0001\u0005\u0001\u0005\u0001\u0006\u0001"+
		"\u0006\u0001\u0007\u0001\u0007\u0001\b\u0001\b\u0001\t\u0001\t\u0001\n"+
		"\u0001\n\u0001\n\u0001\u000b\u0001\u000b\u0005\u000b>\b\u000b\n\u000b"+
		"\f\u000bA\t\u000b\u0001\f\u0001\f\u0005\fE\b\f\n\f\f\fH\t\f\u0001\r\u0001"+
		"\r\u0001\r\u0001\r\u0005\rN\b\r\n\r\f\rQ\t\r\u0001\r\u0001\r\u0001\u000e"+
		"\u0001\u000e\u0001\u000e\u0001\u000e\u0005\u000eY\b\u000e\n\u000e\f\u000e"+
		"\\\t\u000e\u0001\u000e\u0001\u000e\u0001\u000f\u0001\u000f\u0004\u000f"+
		"b\b\u000f\u000b\u000f\f\u000fc\u0001\u000f\u0003\u000fg\b\u000f\u0005"+
		"\u000fi\b\u000f\n\u000f\f\u000fl\t\u000f\u0001\u000f\u0001\u000f\u0001"+
		"\u0010\u0004\u0010q\b\u0010\u000b\u0010\f\u0010r\u0001\u0010\u0001\u0010"+
		"\u0000\u0000\u0011\u0001\u0001\u0003\u0002\u0005\u0003\u0007\u0004\t\u0005"+
		"\u000b\u0006\r\u0007\u000f\b\u0011\t\u0013\n\u0015\u000b\u0017\f\u0019"+
		"\r\u001b\u000e\u001d\u000f\u001f\u0010!\u0011\u0001\u0000\u0007\u0001"+
		"\u0000az\u0003\u000009AZaz\u0001\u0000AZ\u0003\u0000\n\n\r\r\'\'\u0001"+
		"\u0000\"\"\u0002\u0000{{}}\u0003\u0000\t\n\r\r  \u007f\u0000\u0001\u0001"+
		"\u0000\u0000\u0000\u0000\u0003\u0001\u0000\u0000\u0000\u0000\u0005\u0001"+
		"\u0000\u0000\u0000\u0000\u0007\u0001\u0000\u0000\u0000\u0000\t\u0001\u0000"+
		"\u0000\u0000\u0000\u000b\u0001\u0000\u0000\u0000\u0000\r\u0001\u0000\u0000"+
		"\u0000\u0000\u000f\u0001\u0000\u0000\u0000\u0000\u0011\u0001\u0000\u0000"+
		"\u0000\u0000\u0013\u0001\u0000\u0000\u0000\u0000\u0015\u0001\u0000\u0000"+
		"\u0000\u0000\u0017\u0001\u0000\u0000\u0000\u0000\u0019\u0001\u0000\u0000"+
		"\u0000\u0000\u001b\u0001\u0000\u0000\u0000\u0000\u001d\u0001\u0000\u0000"+
		"\u0000\u0000\u001f\u0001\u0000\u0000\u0000\u0000!\u0001\u0000\u0000\u0000"+
		"\u0001#\u0001\u0000\u0000\u0000\u0003%\u0001\u0000\u0000\u0000\u0005("+
		"\u0001\u0000\u0000\u0000\u0007*\u0001\u0000\u0000\u0000\t,\u0001\u0000"+
		"\u0000\u0000\u000b.\u0001\u0000\u0000\u0000\r0\u0001\u0000\u0000\u0000"+
		"\u000f2\u0001\u0000\u0000\u0000\u00114\u0001\u0000\u0000\u0000\u00136"+
		"\u0001\u0000\u0000\u0000\u00158\u0001\u0000\u0000\u0000\u0017;\u0001\u0000"+
		"\u0000\u0000\u0019B\u0001\u0000\u0000\u0000\u001bI\u0001\u0000\u0000\u0000"+
		"\u001dT\u0001\u0000\u0000\u0000\u001f_\u0001\u0000\u0000\u0000!p\u0001"+
		"\u0000\u0000\u0000#$\u0005;\u0000\u0000$\u0002\u0001\u0000\u0000\u0000"+
		"%&\u0005-\u0000\u0000&\'\u0005>\u0000\u0000\'\u0004\u0001\u0000\u0000"+
		"\u0000()\u0005(\u0000\u0000)\u0006\u0001\u0000\u0000\u0000*+\u0005)\u0000"+
		"\u0000+\b\u0001\u0000\u0000\u0000,-\u0005:\u0000\u0000-\n\u0001\u0000"+
		"\u0000\u0000./\u0005|\u0000\u0000/\f\u0001\u0000\u0000\u000001\u0005<"+
		"\u0000\u00001\u000e\u0001\u0000\u0000\u000023\u0005,\u0000\u00003\u0010"+
		"\u0001\u0000\u0000\u000045\u0005>\u0000\u00005\u0012\u0001\u0000\u0000"+
		"\u000067\u0005=\u0000\u00007\u0014\u0001\u0000\u0000\u000089\u0005\\\u0000"+
		"\u00009:\u0005=\u0000\u0000:\u0016\u0001\u0000\u0000\u0000;?\u0007\u0000"+
		"\u0000\u0000<>\u0007\u0001\u0000\u0000=<\u0001\u0000\u0000\u0000>A\u0001"+
		"\u0000\u0000\u0000?=\u0001\u0000\u0000\u0000?@\u0001\u0000\u0000\u0000"+
		"@\u0018\u0001\u0000\u0000\u0000A?\u0001\u0000\u0000\u0000BF\u0007\u0002"+
		"\u0000\u0000CE\u0007\u0001\u0000\u0000DC\u0001\u0000\u0000\u0000EH\u0001"+
		"\u0000\u0000\u0000FD\u0001\u0000\u0000\u0000FG\u0001\u0000\u0000\u0000"+
		"G\u001a\u0001\u0000\u0000\u0000HF\u0001\u0000\u0000\u0000IO\u0005\'\u0000"+
		"\u0000JN\b\u0003\u0000\u0000KL\u0005\\\u0000\u0000LN\u0005\'\u0000\u0000"+
		"MJ\u0001\u0000\u0000\u0000MK\u0001\u0000\u0000\u0000NQ\u0001\u0000\u0000"+
		"\u0000OM\u0001\u0000\u0000\u0000OP\u0001\u0000\u0000\u0000PR\u0001\u0000"+
		"\u0000\u0000QO\u0001\u0000\u0000\u0000RS\u0005\'\u0000\u0000S\u001c\u0001"+
		"\u0000\u0000\u0000TZ\u0005\"\u0000\u0000UY\b\u0004\u0000\u0000VW\u0005"+
		"\\\u0000\u0000WY\u0005\"\u0000\u0000XU\u0001\u0000\u0000\u0000XV\u0001"+
		"\u0000\u0000\u0000Y\\\u0001\u0000\u0000\u0000ZX\u0001\u0000\u0000\u0000"+
		"Z[\u0001\u0000\u0000\u0000[]\u0001\u0000\u0000\u0000\\Z\u0001\u0000\u0000"+
		"\u0000]^\u0005\"\u0000\u0000^\u001e\u0001\u0000\u0000\u0000_j\u0005{\u0000"+
		"\u0000`b\b\u0005\u0000\u0000a`\u0001\u0000\u0000\u0000bc\u0001\u0000\u0000"+
		"\u0000ca\u0001\u0000\u0000\u0000cd\u0001\u0000\u0000\u0000df\u0001\u0000"+
		"\u0000\u0000eg\u0003\u001f\u000f\u0000fe\u0001\u0000\u0000\u0000fg\u0001"+
		"\u0000\u0000\u0000gi\u0001\u0000\u0000\u0000ha\u0001\u0000\u0000\u0000"+
		"il\u0001\u0000\u0000\u0000jh\u0001\u0000\u0000\u0000jk\u0001\u0000\u0000"+
		"\u0000km\u0001\u0000\u0000\u0000lj\u0001\u0000\u0000\u0000mn\u0005}\u0000"+
		"\u0000n \u0001\u0000\u0000\u0000oq\u0007\u0006\u0000\u0000po\u0001\u0000"+
		"\u0000\u0000qr\u0001\u0000\u0000\u0000rp\u0001\u0000\u0000\u0000rs\u0001"+
		"\u0000\u0000\u0000st\u0001\u0000\u0000\u0000tu\u0006\u0010\u0000\u0000"+
		"u\"\u0001\u0000\u0000\u0000\u000b\u0000?FMOXZcfjr\u0001\u0006\u0000\u0000";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}