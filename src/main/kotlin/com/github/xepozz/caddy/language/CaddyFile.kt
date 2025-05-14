package com.github.xepozz.caddy.language

import com.intellij.extapi.psi.PsiFileBase
import com.intellij.psi.FileViewProvider

class CaddyFile(viewProvider: FileViewProvider) : PsiFileBase(viewProvider, CaddyLanguage.INSTANCE) {
    override fun getFileType() = CaddyFileType.INSTANCE

    override fun toString() = "Caddy File"
}