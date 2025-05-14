package com.github.xepozz.caddy.language.parser

import com.github.xepozz.caddy.language.CaddyFile
import com.github.xepozz.caddy.language.CaddyLanguage
import com.github.xepozz.caddy.language.psi.CaddyTokenSets
import com.github.xepozz.caddy.language.psi.CaddyTypes
import com.intellij.lang.ASTNode
import com.intellij.lang.ParserDefinition
import com.intellij.openapi.project.Project
import com.intellij.psi.FileViewProvider
import com.intellij.psi.PsiElement
import com.intellij.psi.tree.IFileElementType
import com.intellij.psi.tree.TokenSet

internal class CaddyParserDefinition : ParserDefinition {
    override fun createLexer(project: Project) = CaddyLexerAdapter()

    override fun getCommentTokens() = CaddyTokenSets.COMMENTS

    override fun getWhitespaceTokens(): TokenSet = CaddyTokenSets.WHITESPACES

    override fun getStringLiteralElements(): TokenSet = TokenSet.EMPTY

    override fun createParser(project: Project?) = CaddyParser()

    override fun getFileNodeType() = FILE

    override fun createFile(viewProvider: FileViewProvider) = CaddyFile(viewProvider)

    override fun createElement(node: ASTNode): PsiElement = CaddyTypes.Factory.createElement(node)

    companion object {
        val FILE = IFileElementType(CaddyLanguage.INSTANCE)
    }
}