package com.github.xepozz.caddy.language

import com.github.xepozz.caddy.language.parser.CaddyLexerAdapter
import com.github.xepozz.caddy.language.psi.CaddyTypes
import com.intellij.openapi.editor.DefaultLanguageHighlighterColors
import com.intellij.openapi.editor.HighlighterColors
import com.intellij.openapi.editor.colors.TextAttributesKey
import com.intellij.openapi.fileTypes.SyntaxHighlighterBase
import com.intellij.psi.TokenType
import com.intellij.psi.tree.IElementType

class CaddySyntaxHighlighter : SyntaxHighlighterBase() {
    override fun getHighlightingLexer() = CaddyLexerAdapter()

    override fun getTokenHighlights(tokenType: IElementType) = when (tokenType) {
        CaddyTypes.COMMENT -> COMMENT_KEYS
        TokenType.BAD_CHARACTER -> BAD_CHAR_KEYS
        else -> EMPTY_KEYS
    }

    companion object {
        private val BAD_CHAR_KEYS = arrayOf(
            HighlighterColors.BAD_CHARACTER,
        )

        private val COMMENT_KEYS = arrayOf(
            DefaultLanguageHighlighterColors.DOC_COMMENT
        )
        private val EMPTY_KEYS = emptyArray<TextAttributesKey>()
    }
}