grammar Grammar;

file : (start (lineRule ';')+)? EOF;

start: '->' NT_ID;
lineRule : lineParserRule | lineLexerRule;

lineParserRule : '(' T_ID ')' NT_ID inAttrs? ':' prods ('|' prods)*;
inAttrs : '<' param (',' param)* '>';
param : T_ID NT_ID;
prods: prod*;
prod: NT_ID args? | T_ID | CODE;
args: '(' arg (',' arg)* ')';
arg : NT_ID | T_ID | CODE;

lineLexerRule : tokenRule | ruleToSkip;
tokenRule: T_ID '=' valueTerm ;
ruleToSkip: T_ID '\\=' valueTerm ;
valueTerm : REGEX | STRING;

NT_ID : [a-z][a-zA-Z0-9]*;
T_ID : [A-Z][a-zA-Z0-9]*;
REGEX : '\'' (~('\''|'\r' | '\n') | '\\\'')* '\'';
STRING : '"' (~('"') | '\\"')* '"';
CODE : '{' (~[{}]+ CODE?)* '}' ;
WS  : [ \t\r\n]+ -> skip ;