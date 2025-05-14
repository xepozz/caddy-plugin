package com.github.xepozz.caddy.language.psi

import com.github.xepozz.caddy.language.CaddyLanguage
import com.intellij.psi.tree.IElementType

class CaddyTokenType(debugName: String) : IElementType(debugName, CaddyLanguage.INSTANCE) {
    override fun toString() = "CaddyTokenType." + super.toString()
}