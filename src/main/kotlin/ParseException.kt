class ParseException(message: String = "Parse error", val pos: Int? = null,
                     val expectedAndFound: Pair<List<Token>, Token>? = null)

    : Exception(
    buildString {
        append(message)
        if (pos != null) append(" at position $pos")
        if (expectedAndFound != null) {
            append(", expected tokens: ${expectedAndFound.first}, found: ${expectedAndFound.second}")
        }
    }
) {
    companion object {
        fun expectedNotFound(lexer: BaseLexer, vararg expected: Token) =
            ParseException(pos = lexer.pos, expectedAndFound = (expected.asList() to lexer.token))
    }
}