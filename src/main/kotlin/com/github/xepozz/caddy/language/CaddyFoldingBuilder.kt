package com.github.xepozz.caddy.language

import com.github.xepozz.caddy.language.psi.CaddyBlock
import com.intellij.lang.ASTNode
import com.intellij.lang.folding.FoldingBuilderEx
import com.intellij.lang.folding.FoldingDescriptor
import com.intellij.openapi.editor.Document
import com.intellij.openapi.project.DumbAware
import com.intellij.psi.PsiElement
import com.intellij.psi.util.PsiTreeUtil

class CaddyFoldingBuilder : FoldingBuilderEx(), DumbAware {

    override fun buildFoldRegions(root: PsiElement, document: Document, quick: Boolean) =
        collectFoldingBlocks(root).toTypedArray()

    private fun collectFoldingBlocks(element: PsiElement) =
        PsiTreeUtil
            .findChildrenOfType(element, CaddyBlock::class.java)
            .map { FoldingDescriptor(it.node, it.textRange) }

    override fun getPlaceholderText(node: ASTNode) = "{ ... }"

    override fun isCollapsedByDefault(node: ASTNode) = false
}
