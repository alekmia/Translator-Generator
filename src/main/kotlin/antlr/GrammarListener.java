// Generated from Grammar.g4 by ANTLR 4.13.1
package antlr;
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link GrammarParser}.
 */
public interface GrammarListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link GrammarParser#file}.
	 * @param ctx the parse tree
	 */
	void enterFile(GrammarParser.FileContext ctx);
	/**
	 * Exit a parse tree produced by {@link GrammarParser#file}.
	 * @param ctx the parse tree
	 */
	void exitFile(GrammarParser.FileContext ctx);
	/**
	 * Enter a parse tree produced by {@link GrammarParser#start}.
	 * @param ctx the parse tree
	 */
	void enterStart(GrammarParser.StartContext ctx);
	/**
	 * Exit a parse tree produced by {@link GrammarParser#start}.
	 * @param ctx the parse tree
	 */
	void exitStart(GrammarParser.StartContext ctx);
	/**
	 * Enter a parse tree produced by {@link GrammarParser#lineRule}.
	 * @param ctx the parse tree
	 */
	void enterLineRule(GrammarParser.LineRuleContext ctx);
	/**
	 * Exit a parse tree produced by {@link GrammarParser#lineRule}.
	 * @param ctx the parse tree
	 */
	void exitLineRule(GrammarParser.LineRuleContext ctx);
	/**
	 * Enter a parse tree produced by {@link GrammarParser#lineParserRule}.
	 * @param ctx the parse tree
	 */
	void enterLineParserRule(GrammarParser.LineParserRuleContext ctx);
	/**
	 * Exit a parse tree produced by {@link GrammarParser#lineParserRule}.
	 * @param ctx the parse tree
	 */
	void exitLineParserRule(GrammarParser.LineParserRuleContext ctx);
	/**
	 * Enter a parse tree produced by {@link GrammarParser#inAttrs}.
	 * @param ctx the parse tree
	 */
	void enterInAttrs(GrammarParser.InAttrsContext ctx);
	/**
	 * Exit a parse tree produced by {@link GrammarParser#inAttrs}.
	 * @param ctx the parse tree
	 */
	void exitInAttrs(GrammarParser.InAttrsContext ctx);
	/**
	 * Enter a parse tree produced by {@link GrammarParser#param}.
	 * @param ctx the parse tree
	 */
	void enterParam(GrammarParser.ParamContext ctx);
	/**
	 * Exit a parse tree produced by {@link GrammarParser#param}.
	 * @param ctx the parse tree
	 */
	void exitParam(GrammarParser.ParamContext ctx);
	/**
	 * Enter a parse tree produced by {@link GrammarParser#prods}.
	 * @param ctx the parse tree
	 */
	void enterProds(GrammarParser.ProdsContext ctx);
	/**
	 * Exit a parse tree produced by {@link GrammarParser#prods}.
	 * @param ctx the parse tree
	 */
	void exitProds(GrammarParser.ProdsContext ctx);
	/**
	 * Enter a parse tree produced by {@link GrammarParser#prod}.
	 * @param ctx the parse tree
	 */
	void enterProd(GrammarParser.ProdContext ctx);
	/**
	 * Exit a parse tree produced by {@link GrammarParser#prod}.
	 * @param ctx the parse tree
	 */
	void exitProd(GrammarParser.ProdContext ctx);
	/**
	 * Enter a parse tree produced by {@link GrammarParser#args}.
	 * @param ctx the parse tree
	 */
	void enterArgs(GrammarParser.ArgsContext ctx);
	/**
	 * Exit a parse tree produced by {@link GrammarParser#args}.
	 * @param ctx the parse tree
	 */
	void exitArgs(GrammarParser.ArgsContext ctx);
	/**
	 * Enter a parse tree produced by {@link GrammarParser#arg}.
	 * @param ctx the parse tree
	 */
	void enterArg(GrammarParser.ArgContext ctx);
	/**
	 * Exit a parse tree produced by {@link GrammarParser#arg}.
	 * @param ctx the parse tree
	 */
	void exitArg(GrammarParser.ArgContext ctx);
	/**
	 * Enter a parse tree produced by {@link GrammarParser#lineLexerRule}.
	 * @param ctx the parse tree
	 */
	void enterLineLexerRule(GrammarParser.LineLexerRuleContext ctx);
	/**
	 * Exit a parse tree produced by {@link GrammarParser#lineLexerRule}.
	 * @param ctx the parse tree
	 */
	void exitLineLexerRule(GrammarParser.LineLexerRuleContext ctx);
	/**
	 * Enter a parse tree produced by {@link GrammarParser#tokenRule}.
	 * @param ctx the parse tree
	 */
	void enterTokenRule(GrammarParser.TokenRuleContext ctx);
	/**
	 * Exit a parse tree produced by {@link GrammarParser#tokenRule}.
	 * @param ctx the parse tree
	 */
	void exitTokenRule(GrammarParser.TokenRuleContext ctx);
	/**
	 * Enter a parse tree produced by {@link GrammarParser#ruleToSkip}.
	 * @param ctx the parse tree
	 */
	void enterRuleToSkip(GrammarParser.RuleToSkipContext ctx);
	/**
	 * Exit a parse tree produced by {@link GrammarParser#ruleToSkip}.
	 * @param ctx the parse tree
	 */
	void exitRuleToSkip(GrammarParser.RuleToSkipContext ctx);
	/**
	 * Enter a parse tree produced by {@link GrammarParser#valueTerm}.
	 * @param ctx the parse tree
	 */
	void enterValueTerm(GrammarParser.ValueTermContext ctx);
	/**
	 * Exit a parse tree produced by {@link GrammarParser#valueTerm}.
	 * @param ctx the parse tree
	 */
	void exitValueTerm(GrammarParser.ValueTermContext ctx);
}