package com.github.xepozz.caddy.language.psi

import com.github.xepozz.caddy.language.CaddyFile
import com.github.xepozz.caddy.language.CaddyFileType
import com.intellij.openapi.project.Project

object CaddyElementFactory {
    fun createFile(project: Project, text: String): CaddyFile {
        val name = "Caddyfile"
        return com.intellij.psi.PsiFileFactory.getInstance(project)
            .createFileFromText(name, CaddyFileType.INSTANCE, text) as CaddyFile
    }
}