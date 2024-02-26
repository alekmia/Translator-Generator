import Token

class GrammarParser(val lexer: GrammarLexer) {

    fun skip(token: Token): String {
        if (lexer.token != token) throw ParseException.expectedNotFound(lexer, token)
        val res = lexer.tokenValue ?: throw IllegalArgumentException("cant skip EOF token")
        lexer.next()
        return res
    }

    fun Expr() : Int = when(lexer.token) {
        TOKENS.OPEN, TOKENS.NUM -> {
            val term = Term()
            val exprs = Exprs(term)
            exprs
        }
        else -> throw ParseException.expectedNotFound(lexer, TOKENS.OPEN, TOKENS.NUM)
    }

    fun Exprs(curr: Int) : Int = when(lexer.token) {
        TOKENS.PLUS -> {
            val PLUS = skip(TOKENS.PLUS)
            val term = Term()
            val next = curr + term
            val exprs = Exprs(next)
            exprs
        }
        TOKENS.MINUS -> {
            val MINUS = skip(TOKENS.MINUS)
            val term = Term()
            val next = curr - term
            val exprs = Exprs(next)
            exprs
        }
        TOKENS.EOF, TOKENS.CLOSE -> {
            curr
        }
        else -> throw ParseException.expectedNotFound(lexer, TOKENS.PLUS, TOKENS.MINUS, TOKENS.EOF, TOKENS.CLOSE)
    }

    fun Term() : Int = when(lexer.token) {
        TOKENS.OPEN, TOKENS.NUM -> {
            val factor = Factor()
            val terms = Terms(factor)
            terms
        }
        else -> throw ParseException.expectedNotFound(lexer, TOKENS.OPEN, TOKENS.NUM)
    }

    fun Terms(curr: Int) : Int = when(lexer.token) {
        TOKENS.MUL -> {
            val MUL = skip(TOKENS.MUL)
            val factor = Factor()
            val terms = Terms(curr * factor)
            terms
        }
        TOKENS.DIV -> {
            val DIV = skip(TOKENS.DIV)
            val factor = Factor()
            val terms = Terms(curr / factor)
            terms
        }
        TOKENS.PLUS, TOKENS.MINUS, TOKENS.EOF, TOKENS.CLOSE -> {
            curr
        }
        else -> throw ParseException.expectedNotFound(lexer, TOKENS.MUL, TOKENS.DIV, TOKENS.PLUS, TOKENS.MINUS, TOKENS.EOF, TOKENS.CLOSE)
    }

    fun Factor() : Int = when(lexer.token) {
        TOKENS.OPEN, TOKENS.NUM -> {
            val single = Single()
            val logs = Logs(single)
            logs
        }
        else -> throw ParseException.expectedNotFound(lexer, TOKENS.OPEN, TOKENS.NUM)
    }

    fun Logs(curr: Int) : Int = when(lexer.token) {
        TOKENS.LOG -> {
            val LOG = skip(TOKENS.LOG)
            val single = Single()
            val logs = Logs(single)
            kotlin.math.log(curr.toDouble(), logs.toDouble()).toInt()
        }
        TOKENS.MUL, TOKENS.DIV, TOKENS.PLUS, TOKENS.MINUS, TOKENS.EOF, TOKENS.CLOSE -> {
            curr
        }
        else -> throw ParseException.expectedNotFound(lexer, TOKENS.LOG, TOKENS.MUL, TOKENS.DIV, TOKENS.PLUS, TOKENS.MINUS, TOKENS.EOF, TOKENS.CLOSE)
    }

    fun Single() : Int = when(lexer.token) {
        TOKENS.OPEN -> {
            val OPEN = skip(TOKENS.OPEN)
            val expr = Expr()
            val CLOSE = skip(TOKENS.CLOSE)
            expr
        }
        TOKENS.NUM -> {
            val num = Num()
            num
        }
        else -> throw ParseException.expectedNotFound(lexer, TOKENS.OPEN, TOKENS.NUM)
    }

    fun Num() : Int = when(lexer.token) {
        TOKENS.NUM -> {
            val NUM = skip(TOKENS.NUM)
            NUM.toInt()
        }
        else -> throw ParseException.expectedNotFound(lexer, TOKENS.NUM)
    }

    fun parse() : Int { 
        lexer.next()
        return Expr()
    }
}
