package com.github.xepozz.caddy.language.psi

import com.github.xepozz.caddy.language.CaddyFileType
import com.github.xepozz.caddy.language.CaddyLanguage
import com.github.xepozz.caddy.language.psi.impl.CaddyElementImpl
import com.intellij.openapi.util.TextRange
import com.intellij.psi.AbstractElementManipulator
import com.intellij.psi.util.PsiTreeUtil
import com.intellij.util.IncorrectOperationException

class CaddyElementManipulator : AbstractElementManipulator<CaddyElementImpl>() {

    @Throws(IncorrectOperationException::class)
    override fun handleContentChange(entry: CaddyElementImpl, range: TextRange, newContent: String): CaddyElementImpl {
        val language = entry.language as? CaddyLanguage ?: return entry

        val fileType = language.associatedFileType as CaddyFileType
        val file = CaddyElementFactory
            .createFile(entry.project, entry.text)

        val newEntry = PsiTreeUtil.findChildOfType(file, CaddyElementImpl::class.java)

        return when (newEntry) {
            null -> entry
            else -> entry.replace(newEntry) as CaddyElementImpl
        }
    }
}