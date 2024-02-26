// Generated from Grammar.g4 by ANTLR 4.13.1
package antlr;
import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link GrammarParser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface GrammarVisitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by {@link GrammarParser#file}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFile(GrammarParser.FileContext ctx);
	/**
	 * Visit a parse tree produced by {@link GrammarParser#start}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStart(GrammarParser.StartContext ctx);
	/**
	 * Visit a parse tree produced by {@link GrammarParser#lineRule}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLineRule(GrammarParser.LineRuleContext ctx);
	/**
	 * Visit a parse tree produced by {@link GrammarParser#lineParserRule}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLineParserRule(GrammarParser.LineParserRuleContext ctx);
	/**
	 * Visit a parse tree produced by {@link GrammarParser#inAttrs}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitInAttrs(GrammarParser.InAttrsContext ctx);
	/**
	 * Visit a parse tree produced by {@link GrammarParser#param}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitParam(GrammarParser.ParamContext ctx);
	/**
	 * Visit a parse tree produced by {@link GrammarParser#prods}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitProds(GrammarParser.ProdsContext ctx);
	/**
	 * Visit a parse tree produced by {@link GrammarParser#prod}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitProd(GrammarParser.ProdContext ctx);
	/**
	 * Visit a parse tree produced by {@link GrammarParser#args}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitArgs(GrammarParser.ArgsContext ctx);
	/**
	 * Visit a parse tree produced by {@link GrammarParser#arg}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitArg(GrammarParser.ArgContext ctx);
	/**
	 * Visit a parse tree produced by {@link GrammarParser#lineLexerRule}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLineLexerRule(GrammarParser.LineLexerRuleContext ctx);
	/**
	 * Visit a parse tree produced by {@link GrammarParser#tokenRule}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTokenRule(GrammarParser.TokenRuleContext ctx);
	/**
	 * Visit a parse tree produced by {@link GrammarParser#ruleToSkip}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitRuleToSkip(GrammarParser.RuleToSkipContext ctx);
	/**
	 * Visit a parse tree produced by {@link GrammarParser#valueTerm}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitValueTerm(GrammarParser.ValueTermContext ctx);
}