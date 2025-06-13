package com.github.xepozz.caddy.language.psi.impl

import com.github.xepozz.caddy.language.psi.CaddyAddress
import com.intellij.psi.PsiElement
import com.intellij.psi.PsiReference
import com.intellij.psi.impl.source.resolve.reference.ReferenceProvidersRegistry

class CaddyPsiImplUtil {
    companion object {
        @JvmStatic
        fun getValue(element: CaddyAddress): String? = element.text

        @JvmStatic
        fun getReferences(element: PsiElement): Array<PsiReference> =
            ReferenceProvidersRegistry.getReferencesFromProviders(element)
    }
}