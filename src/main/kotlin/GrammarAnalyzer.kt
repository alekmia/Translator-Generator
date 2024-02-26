import antlr.GrammarBaseListener
import antlr.GrammarParser

class GrammarAnalyzer : GrammarBaseListener() {
    private var tokenAmount = 0
    var hasEPSprods = false
    lateinit var start: String

    val tokenMap: MutableMap<String, Token> = LinkedHashMap()
    val terms: Set<String>
        get() = if (hasEPSprods) tokenMap.keys + EPS else tokenMap.keys
    val nonTerms: Set<String>
        get() = ruleMap.keys

    val regexs: MutableMap<Token, Regex> = HashMap()
    val literalMap: MutableMap<Token, String> = HashMap()
    val skipTokens: MutableSet<Token> = HashSet()

    val ruleMap: MutableMap<String, Rule> = LinkedHashMap()

    override fun exitLineParserRule(ctx: GrammarParser.LineParserRuleContext) {
        val curRule = ruleMap.getOrPut(ctx.NT_ID().text, { Rule(ctx.NT_ID().text) })

        if (ctx.T_ID().text != null) {
            curRule.returnType = ctx.T_ID().text
        }
        if (ctx.inAttrs() != null) {
            curRule.args = ctx.inAttrs().param().map {
                it.NT_ID().text to it.T_ID().text
            }
        }

        curRule.productions = ctx.prods().map { prodsCtx ->
            var prod = if (prodsCtx.prod().isEmpty()) {
                hasEPSprods = true
                listOf(DiffElem.Base(Element.Terminal(EPS)))
            } else
                prodsCtx.prod().map { prodCtx ->
                    if (prodCtx.NT_ID() != null) {
                        DiffElem.Base(Element.NonTerminal(
                            prodCtx.NT_ID().text,
                            prodCtx.args()?.arg()?.map { it.text.trimBrack() }
                        ))
                    } else if (prodCtx.T_ID() != null) {
                        DiffElem.Base(Element.Terminal(prodCtx.T_ID().text))
                    } else {
                        DiffElem.Code(prodCtx.CODE().text.trimBrack())
                    }
                }
            var elems = prod.filterIsInstance<DiffElem.Base>()
            if (elems.isEmpty()) {
                hasEPSprods = true
                elems = listOf(DiffElem.Base(Element.Terminal(EPS)))
                prod = elems + prod
            }
            Prod(elems.map { it.elem }, prod)
        }
    }


    override fun exitTokenRule(ctx: GrammarParser.TokenRuleContext) {
        fillMap(ctx.T_ID().text, ctx.valueTerm(), false)
    }

    override fun exitRuleToSkip(ctx: GrammarParser.RuleToSkipContext) {
        fillMap(ctx.T_ID().text, ctx.valueTerm(), true)
    }

    override fun exitFile(ctx: GrammarParser.FileContext?) {
        tokenMap.put(EOF, -1)
    }

    fun fillMap(token: String, right: GrammarParser.ValueTermContext, skip: Boolean) {
        val token_id = tokenMap.getOrPut(token, { tokenAmount++ })
        if (right.STRING() != null) {
            literalMap.put(token_id, right.STRING().text.trim('\"'))
        } else {
            regexs.put(token_id, Regex(right.REGEX().text.trim('\'')))
        }
        if (skip) skipTokens.add(token_id)
    }

    fun String.trimBrack() = this.trim('{', '}', ' ')

    override fun exitStart(ctx: GrammarParser.StartContext) {
        start = ctx.NT_ID().text
    }
}