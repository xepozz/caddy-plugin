package com.github.xepozz.caddy.language.psi

import com.intellij.psi.tree.TokenSet

object CaddyTokenSets {
    val EMPTY_SET = TokenSet.EMPTY

    val COMMENTS = TokenSet.create(CaddyTypes.COMMENT)
    val WHITESPACES = TokenSet.WHITE_SPACE
    val STRING_LITERALS = TokenSet.create(CaddyTypes.HEREDOC_CONTENT)
//    val STRING_LITERALS = TokenSet.create(CaddyTypes.TEXT, CaddyTypes.HEREDOC_CONTENT)
}
