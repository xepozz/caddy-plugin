package com.github.xepozz.caddy.language.psi.impl

import com.github.xepozz.caddy.language.psi.CaddyAddress
import com.intellij.icons.AllIcons
import com.intellij.ide.projectView.PresentationData
import com.intellij.lang.ASTNode
import com.intellij.psi.PsiLiteralValue

abstract class CaddyAddressBaseImpl : CaddyAddress, CaddyElementImpl, PsiLiteralValue {
    constructor(node: ASTNode) : super(node)

    override fun getValue(): String? = text

    override fun getText(): String? = node.text

    override fun getName(): String? = text

    override fun getPresentation() = PresentationData(text, null, getIcon(0), null)

    override fun getIcon(flags: Int) = AllIcons.General.Web
}