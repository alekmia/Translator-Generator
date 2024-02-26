class TestPrinter(val collector: GrammarAnalyzer) : AbstractPrinter() {
    override fun printer(grammarName: String) = buildString {
        val gn = grammarName.capitalize()
        printLine("fun main(args: Array<String>) {")
        indentRight()
        printLine("println(${gn}Parser(${gn}Lexer(args[0].reader())).parse())")
        indentLeft()
        printLine("}")
    }

}

class ParserPrinter(val collector: GrammarAnalyzer) : AbstractPrinter() {

    val first: Map<String, Set<String>> by lazy {
        val fst: MutableMap<String, MutableSet<String>> = mutableMapOf()

        collector.terms.forEach { fst.put(it, mutableSetOf(it)) }
        collector.ruleMap.forEach { (name, rule) ->
            fst.put(name, mutableSetOf())
            if (rule.productions.any { it.first().name == EPS }) fst[name]!!.add(EPS)
        }

        var changed = true
        while (changed) {
            changed = false
            for ((name, rule) in collector.ruleMap) {
                for (prod in rule.productions) {
                    for (i in prod.indices) {
                        val curNT = prod[i].name
                        if (EPS in fst.getValue(curNT)) {
                            changed = changed || fst.getValue(name).addAll(fst.getValue(curNT))
                            if (i == prod.size - 1) changed = changed || fst.getValue(name).add(EPS)
                        } else {
                            changed = changed || fst.getValue(name).addAll(fst.getValue(curNT))
                            break
                        }
                    }
                }
            }
        }
        fst
    }

    val follow: Map<String, Set<String>> by lazy {
        val flw: MutableMap<String, MutableSet<String>> = mutableMapOf()

        collector.nonTerms.forEach { flw.put(it, mutableSetOf()) }
        flw.getValue(collector.start).add(EOF)

        var changed = true
        while (changed) {
            changed = false
            for ((name, rule) in collector.ruleMap) {
                rule.productions.forEach { prod ->
                    (0..prod.size - 2)
                        .filter { prod[it] is Element.NonTerminal }
                        .forEach { i ->
                            changed = changed || flw.getValue(prod[i].name).addAll(
                                first.getValue(prod[i + 1].name).filter { it != EPS }
                            )
                        }

                    if (prod.last() is Element.NonTerminal)
                        changed = changed || flw.getValue(prod.last().name).addAll(flw.getValue(name))

                    if (prod.size > 1 && EPS in first.getValue(prod.last().name)) {
                        val prelast = prod[prod.size - 2]
                        if (prelast is Element.NonTerminal)
                            changed = changed || flw.getValue(prelast.name).addAll(flw.getValue(name))
                    }
                }
            }
        }
        flw
    }

    override fun printer(grammarName: String) = buildString {
        val capGramName = grammarName.capitalize()
        printLine("import Token")
        emptyLine
        printLine("class ${capGramName}Parser(val lexer: ${capGramName}Lexer) {")
        emptyLine
        indentRight()
        printLine("fun skip(token: Token): String {")
        indentRight()
        printLine("if (lexer.token != token) throw ParseException.expectedNotFound(lexer, token)")
        printLine("val res = lexer.tokenValue ?: throw IllegalArgumentException(\"cant skip EOF token\")")
        printLine("lexer.next()")
        printLine("return res")
        indentLeft()
        printLine("}")
        emptyLine
        for ((name, rule) in collector.ruleMap) {
            printLine("fun ${name.capitalize()}(${rule.getArgs()}) : ${rule.returnType ?: "Unit"} = when(lexer.token) {")
            val mappedRules = mapRules(name, rule)
            indentRight()
            for ((prod, tokens) in mappedRules) {
                printLine("${tokens.joinToString { "TOKENS.$it" }} -> {")
                indentRight()

                forName@ for (exElem in prod.native) {
                    when (exElem) {
                        is DiffElem.Code -> printLine(exElem.code)

                        is DiffElem.Base -> {
                            when (val elem = exElem.elem) {
                                is Element.Terminal -> {
                                    if (elem.name == EPS) continue@forName
                                    printLine("val ${elem.name} = skip(TOKENS.${elem.name})")
                                }
                                is Element.NonTerminal -> {
                                    val callAttrs = elem.callAttrs?.joinToString().orEmpty()
                                    printLine("val ${elem.name} = ${elem.name.capitalize()}($callAttrs)")
                                }
                            }
                        }
                    }
                }

                indentLeft()
                printLine("}")
            }

            printLine(
                "else -> throw ParseException.expectedNotFound(lexer, " +
                        "${mappedRules.values.flatten().joinToString { "TOKENS.$it" }})"
            )

            indentLeft()
            printLine("}")
            emptyLine
        }
        val startRule = collector.ruleMap.getValue(collector.start)

        printLine("fun parse(${startRule.getArgs()}) : ${startRule.returnType ?: "Unit"} { ")
        indentRight()
        printLine("lexer.next()")
        printLine("return ${collector.start.capitalize()}(${startRule.args?.joinToString { (a, _) -> a }.orEmpty()})")
        indentLeft()
        printLine("}")
        indentLeft()
        printLine("}")
    }

    fun mapRules(name: String, rule: Rule) = rule.productions
        .associate { prod ->
            if (prod[0].name == EPS) prod to follow.getValue(name).toList()
            else prod to first.getValue(prod[0].name).toList()
        }
        .also {
            it.values.flatten().also {
                if (it.size != it.distinct().size) throw ParseException("grammar isnt ll1")
            }
        }
}

class LexerPrinter(val collector: GrammarAnalyzer) : AbstractPrinter() {

    val skipTokens: Set<Token>
        get() = collector.skipTokens

    val literalMap: Map<Token, String>
        get() = collector.literalMap

    val regexs: Map<Token, Regex>
        get() = collector.regexs

    val tokenMap: Map<String, Token>
        get() {
            return if (collector.hasEPSprods) {
                collector.tokenMap + (EPS to collector.tokenMap.size - 1)
            } else {
                collector.tokenMap
            }
        }

    override fun printer(grammarName: String) = buildString {
        printLine("import java.io.Reader")
        emptyLine
        printLine("val literalMap: Map<Token, String> = mapOf(")
        indentRight()
        literalMap.forEach { (t, s) -> printLine("$t to \"${s}\",") }
        indentLeft()
        printLine(")")
        emptyLine
        printLine("val regexs: Map<Token, Regex> = mapOf(")
        indentRight()
        regexs.forEach { (t, r) -> printLine("$t to Regex(\"${r.toString().escape()}\"),") }
        indentLeft()
        printLine(")")
        emptyLine
        printLine("val skipTokens = setOf(${skipTokens.joinToString()})")
        emptyLine
        printLine("object TOKENS {")
        indentRight()
        (tokenMap - skipTokens).forEach { (t, i) -> printLine("val $t = $i") }
        indentLeft()
        printLine("}")
        emptyLine
        printLine("class ${grammarName.capitalize()}Lexer(reader: Reader)")
        indentRight()
        printLine(": BaseLexer(reader, literalMap, regexs, skipTokens, TOKENS.EOF)")
        indentLeft()
    }

    fun String.escape() = replace("\\", "\\\\").replace("\"", "\\\"")
}

abstract class AbstractPrinter {

    var indent = 0

    fun StringBuilder.printLine(line: String) {
        for (i in 0 until indent) append(" ")
        append(line)
        append("\n")
    }

    val StringBuilder.emptyLine: Unit
        get() {
            append("\n")
        }

    fun indentRight() {
        indent += 4
    }

    fun indentLeft() {
        indent -= 4
    }

    abstract fun printer(grammarName: String): String
}

fun Rule.getArgs() = args?.joinToString { (n, t) -> "$n: $t" }.orEmpty()