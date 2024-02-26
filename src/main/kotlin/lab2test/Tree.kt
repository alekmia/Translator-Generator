class Tree(val name: String, val isTerminal: Boolean, vararg childs: Tree) {
    var children: Array<out Tree> = childs
    override fun toString() : String =
        name +
                (if (isTerminal) {"(term)"} else {""}) +
                " -> {" +
                children.map { it.toString() }.joinToString() +
                "}"
}