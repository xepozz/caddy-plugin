package com.github.xepozz.caddy.language.parser

import com.intellij.lexer.FlexAdapter

class CaddyLexerAdapter : FlexAdapter(CaddyLexer(null))