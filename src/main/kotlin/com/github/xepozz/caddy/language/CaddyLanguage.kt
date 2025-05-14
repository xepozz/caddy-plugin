package com.github.xepozz.caddy.language

import com.intellij.lang.Language

class CaddyLanguage : Language("Caddyfile") {
    companion object {
        @JvmStatic
        val INSTANCE = CaddyLanguage();
    }
}