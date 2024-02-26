import java.io.Reader

val literalMap: Map<Token, String> = mapOf(
    0 to "//",
    1 to "+",
    2 to "-",
    3 to "*",
    4 to "/",
    5 to "(",
    6 to ")",
)

val regexs: Map<Token, Regex> = mapOf(
    7 to Regex("[0-9]+"),
    8 to Regex("\\s+"),
)

val skipTokens = setOf(8)

object TOKENS {
    val LOG = 0
    val PLUS = 1
    val MINUS = 2
    val MUL = 3
    val DIV = 4
    val OPEN = 5
    val CLOSE = 6
    val NUM = 7
    val WS = 8
    val EOF = -1
    val EPS = 9
}

class GrammarLexer(reader: Reader)
    : BaseLexer(reader, literalMap, regexs, skipTokens, TOKENS.EOF)
