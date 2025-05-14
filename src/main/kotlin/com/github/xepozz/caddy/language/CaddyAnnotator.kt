package com.github.xepozz.caddy.language

import com.intellij.lang.annotation.AnnotationHolder
import com.intellij.lang.annotation.Annotator
import com.intellij.openapi.editor.DefaultLanguageHighlighterColors
import com.intellij.openapi.editor.colors.TextAttributesKey
import com.intellij.psi.PsiElement

class CaddyAnnotator : Annotator {
    override fun annotate(element: PsiElement, holder: AnnotationHolder) {
        when (element) {
//            is CaddyPattern -> {
//                holder.newSilentAnnotation(HighlightSeverity.INFORMATION)
//                    .range(element.textRange)
//                    .textAttributes(PATTERN_HIGHLIGHT)
//                    .create()
//            }
//
//            is CaddyTeam -> {
//                holder.newSilentAnnotation(HighlightSeverity.INFORMATION)
//                    .range(element.textRange)
//                    .textAttributes(PARAMETERS_HIGHLIGHT)
//                    .create()
//            }
        }
    }

    companion object {
        val PATTERN_HIGHLIGHT = TextAttributesKey.createTextAttributesKey(
            "GITCODEOWNERS_PATTERN",
            DefaultLanguageHighlighterColors.STRING,
        )
        private val PARAMETERS_HIGHLIGHT = TextAttributesKey.createTextAttributesKey(
            "GITCODEOWNERS_IDENTIFIER",
            DefaultLanguageHighlighterColors.KEYWORD,
        )
    }
}