package com.github.xepozz.caddy.language

import com.github.xepozz.caddy.language.psi.CaddyTypes
import com.intellij.lang.BracePair
import com.intellij.lang.PairedBraceMatcher
import com.intellij.psi.PsiFile
import com.intellij.psi.tree.IElementType

class CaddyBraceMatcher : PairedBraceMatcher {
    private val bracePairs = arrayOf(
        BracePair(CaddyTypes.LBRACE, CaddyTypes.RBRACE, true),
        BracePair(CaddyTypes.LPAREN, CaddyTypes.RPAREN, true),
    )

    override fun getPairs() = bracePairs

    override fun isPairedBracesAllowedBeforeType(
        p0: IElementType,
        p1: IElementType?
    ) = true

    override fun getCodeConstructStart(
        file: PsiFile,
        openingBraceOffset: Int
    ): Int = openingBraceOffset

}