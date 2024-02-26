val EPS = "EPS"
val EOF = "EOF"

data class Rule(
    val name: String,
    var productions: List<Prod> = ArrayList(),
    var returnType: String? = null,
    var args: List<Pair<String, String>>? = null
)

data class Prod(val prods: List<Element>, val native: List<DiffElem>) : List<Element> by prods

sealed class Element {
    abstract val name: String

    data class Terminal(override val name: String) : Element()
    data class NonTerminal(override val name: String, val callAttrs: List<String>?) : Element()
}

sealed class DiffElem {
    data class Base(val elem: Element) : DiffElem()
    data class Code(val code: String) : DiffElem()
}