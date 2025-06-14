package com.github.xepozz.caddy.language.psi.impl

import com.github.xepozz.caddy.language.psi.CaddyAddress
import com.github.xepozz.caddy.language.psi.CaddyHeredoc
import com.github.xepozz.caddy.language.psi.CaddyTypes
import com.intellij.psi.LiteralTextEscaper
import com.intellij.psi.PsiElement
import com.intellij.psi.PsiLanguageInjectionHost
import com.intellij.psi.PsiReference
import com.intellij.psi.impl.source.resolve.reference.ReferenceProvidersRegistry

class CaddyPsiImplUtil {
    companion object {
        @JvmStatic
        fun getValue(element: CaddyAddress): String? = element.text

        @JvmStatic
        fun isValidHost(element: CaddyHeredoc): Boolean = element.isValidHost

        @JvmStatic
        fun updateText(element: CaddyHeredoc, newText: String): PsiLanguageInjectionHost = element.updateText(newText)

        @JvmStatic
        fun createLiteralTextEscaper(element: CaddyHeredoc): LiteralTextEscaper<out PsiLanguageInjectionHost> =
            element.createLiteralTextEscaper()

        @JvmStatic
        fun getValue(element: CaddyHeredoc): String? =
            element.node.findChildByType(CaddyTypes.HEREDOC_CONTENT)?.text?.trimIndent()

        @JvmStatic
        fun getReferences(element: PsiElement): Array<PsiReference> =
            ReferenceProvidersRegistry.getReferencesFromProviders(element)
    }
}