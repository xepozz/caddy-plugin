/* Caddyfile JFlex Lexer for Pattern-Based Parsing */

package com.github.xepozz.caddy.language.parser;

import com.intellij.lexer.FlexLexer;
import com.intellij.psi.tree.IElementType;
import com.intellij.psi.TokenType;
import com.github.xepozz.caddy.language.psi.CaddyTypes;
import java.util.Stack;

%%

%class CaddyLexer
%implements FlexLexer
%unicode
%function advance
%type IElementType
%eof{  return;
%eof}

%state YYINITIAL
%state IN_BLOCK

// Common macros
WHITESPACE = [ \t\f]
NEWLINE = \r\n|\r|\n
COMMENT = "#"[^\n]*

// Identifier patterns
IDENTIFIER = @?[a-zA-Z][a-zA-Z0-9_\-]*
NUMBER = [0-9]+
TEXT = [^\s{\}(\)\[\]<\>\|\#\'\`][^\s{\}(\)\[\]<\>]*

// Special symbols
LBRACE = "{"
RBRACE = "}"
LPAREN = "("
RPAREN = ")"
LBRACKET = "["
RBRACKET = "]"

%{
private Stack<Integer> stack = new Stack<>();

public void yypushState(int newState) {
  stack.push(yystate());
  yybegin(newState);
}

public void yypopState() {
  yybegin(stack.pop());
}
%}

%%

{LBRACE}                                     { yypushState(IN_BLOCK); return CaddyTypes.LBRACE; }
{RBRACE}                                     { yypopState(); return CaddyTypes.RBRACE; }

// Special symbols
{LPAREN}                                     { return CaddyTypes.LPAREN; }
{RPAREN}                                     { return CaddyTypes.RPAREN; }
{LBRACKET}                                   { return CaddyTypes.LBRACKET; }
{RBRACKET}                                   { return CaddyTypes.RBRACKET; }

// Common elements
{IDENTIFIER}                                 { return CaddyTypes.IDENTIFIER; }
{NUMBER}                                     { return CaddyTypes.NUMBER; }
{TEXT}|\"([^\"\\]+)\"                        { return CaddyTypes.TEXT; }

// Whitespace and comments
{WHITESPACE}                                 { return TokenType.WHITE_SPACE; }
{NEWLINE}                                    { return CaddyTypes.EOL; }
{COMMENT}                                    { return CaddyTypes.COMMENT; }
// Catch any other character
//[^]                                              { throw new Error("Illegal character <"+yytext()+">"); }
[^]                                              { return TokenType.BAD_CHARACTER; }