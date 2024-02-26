# Simplified translator generator. ANTLR/Bison analog

Supports:
* only LL1 grammars
* synthesized and inherited attributes

## How to use
1) write your grammar in a \<filename\>.gram file (grammar rules are in src/main/kotlin/antlr/Grammar.g4)
2) run my translator generator (src/main/kotlin/Main.kt) 
3) you will then get a \<filename\>Lexer.kt, \<filename\>Parser.kt and a \<filename\>Test.kt file
