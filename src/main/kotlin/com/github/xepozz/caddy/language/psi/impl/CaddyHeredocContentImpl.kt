package com.github.xepozz.caddy.language.psi.impl

import com.github.xepozz.caddy.language.psi.CaddyHeredoc
import com.intellij.lang.ASTNode
import com.intellij.openapi.util.TextRange
import com.intellij.psi.ElementManipulators
import com.intellij.psi.LiteralTextEscaper
import com.intellij.psi.PsiLanguageInjectionHost
import com.intellij.psi.impl.source.tree.injected.InjectionBackgroundSuppressor

abstract class CaddyHeredocContentImpl : CaddyElementImpl, CaddyHeredoc, InjectionBackgroundSuppressor {
    constructor(node: ASTNode) : super(node)

    override fun getValue(): String? = CaddyPsiImplUtil.getValue(this)

    override fun isValidHost() = true

    override fun updateText(text: String): PsiLanguageInjectionHost {
        return ElementManipulators.handleContentChange(this, text)
    }

    override fun createLiteralTextEscaper(): LiteralTextEscaper<out PsiLanguageInjectionHost> {
        return object : LiteralTextEscaper<PsiLanguageInjectionHost>(this) {
            override fun decode(rangeInsideHost: TextRange, outChars: StringBuilder): Boolean {
                outChars.append(rangeInsideHost.substring(myHost!!.text))
                return true
            }

            override fun getOffsetInHost(offsetInDecoded: Int, rangeInsideHost: TextRange): Int {
                return rangeInsideHost.startOffset + offsetInDecoded
            }

            override fun isOneLine() = false
        }
    }
}