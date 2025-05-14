package com.github.xepozz.caddy.language

import com.github.xepozz.caddy.CaddyIcons
import com.intellij.openapi.fileTypes.LanguageFileType
import java.io.Serializable

class CaddyFileType private constructor() : LanguageFileType(CaddyLanguage.INSTANCE), Serializable {
    override fun getName() = "Caddyfile"

    override fun getDescription() = "Caddyfile language"

    override fun getDefaultExtension() = ""

    override fun getIcon() = CaddyIcons.FILE

    companion object {
        @JvmStatic
        val INSTANCE = CaddyFileType()
    }
}