fun main(args: Array<String>) {
    while(true) {
        val str = readln()
        println(GrammarParser(GrammarLexer(str.reader())).parse())
    }
}
