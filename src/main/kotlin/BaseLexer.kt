import java.io.IOException
import java.io.Reader

typealias Token = Int

open class BaseLexer(reader: Reader,
                     literalMap: Map<Token, String>,
                     regexs: Map<Token, Regex>,
                     private val skipTokens: Set<Token>,
                     private val EOF_TOKEN: Token = -1) {
    private val allTokens: Map<Token, Regex> = literalMap.mapValues { (_, v) -> Regex.escape(v).toRegex() } + regexs
    private val groupsToTokens: MutableMap<Int, Token> = LinkedHashMap()

    private val tokenStream: Iterator<TokenMatch>

    var token: Token = EOF_TOKEN
        private set
    var tokenValue: String? = null
        private set
    var pos: Int = -1
        private set

    fun doNext() {
        if (!tokenStream.hasNext()) {
            if (token != EOF_TOKEN) {
                token = EOF_TOKEN
                tokenValue = null
                return
            } else throw IOException("no tokens")
        }
        val (g, s, v) = tokenStream.next()
        token = groupsToTokens.getValue(g - 1)
        pos = s
        tokenValue = v
    }

    fun next() {
        do {
            doNext()
        } while (token in skipTokens)
    }

    init {
        val text = reader.readText()
        var currGroup = 0

        tokenStream = allTokens
            .map { (t, r) ->
                groupsToTokens[currGroup++] = t
                "($r)"
            }.joinToString("|")
            .toRegex().findAll(text)
            .map {
                it.groups.mapIndexedNotNull { i, g ->
                    if (i == 0 || g == null) null else TokenMatch(i, g.range.first, g.value)
                }.singleOrNull() ?: throw ParseException("Too many tokens")
            }
            .iterator()
    }

    data class TokenMatch(val groupPos: Int, val strPos: Int, val value: String? = null)
}














