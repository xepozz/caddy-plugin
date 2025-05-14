package com.github.xepozz.caddy.language.psi

import com.github.xepozz.caddy.language.CaddyLanguage
import com.intellij.psi.tree.IElementType

class CaddyElementType(debugName: String) : IElementType("CaddyElementType($debugName)", CaddyLanguage.INSTANCE)
