import antlr.GrammarLexer
import antlr.GrammarParser
import org.antlr.v4.runtime.CharStream
import org.antlr.v4.runtime.CharStreams
import org.antlr.v4.runtime.CommonTokenStream
import org.antlr.v4.runtime.tree.ParseTreeWalker
import java.nio.file.Files
import java.nio.file.Paths

private fun analyze(stream: CharStream): GrammarAnalyzer {
    val analyzer = GrammarAnalyzer()
    val lexer = GrammarLexer(stream)
    val parser = GrammarParser(CommonTokenStream(lexer))
    val walker = ParseTreeWalker()
    walker.walk(analyzer, parser.file())
    return analyzer
}

private fun generate(grammarName: String, targetDir: String, analyzer: GrammarAnalyzer) {
    val test = TestPrinter(analyzer) to "Test"
    val par = ParserPrinter(analyzer) to "Parser"
    val lex = LexerPrinter(analyzer) to "Lexer"

    listOf(lex, par, test).forEach { (gen, postfix) ->
        val out = Paths.get(targetDir, "$grammarName$postfix.kt")
        out.toFile().parentFile.mkdirs()
        Files.newBufferedWriter(out).use { wr ->
            wr.write(gen.printer(grammarName))
        }
    }
}

fun main(args: Array<String>) {
    val (inputFile, targetDir) = args[0] to args[1]

    val analyzer = analyze(CharStreams.fromFileName(inputFile))

    generate(args[2], targetDir, analyzer)
}