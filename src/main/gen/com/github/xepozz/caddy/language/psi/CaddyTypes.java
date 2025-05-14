// This is a generated file. Not intended for manual editing.
package com.github.xepozz.caddy.language.psi;

import com.intellij.psi.tree.IElementType;
import com.intellij.psi.PsiElement;
import com.intellij.lang.ASTNode;
import com.github.xepozz.caddy.language.psi.impl.*;

public interface CaddyTypes {

  IElementType ARGUMENT = new CaddyElementType("ARGUMENT");
  IElementType BLOCK = new CaddyElementType("BLOCK");
  IElementType BLOCK_NAME = new CaddyElementType("BLOCK_NAME");
  IElementType DIRECTIVE = new CaddyElementType("DIRECTIVE");
  IElementType ENV_VALUE = new CaddyElementType("ENV_VALUE");
  IElementType INSTRUCTION = new CaddyElementType("INSTRUCTION");
  IElementType NAMED_BLOCK = new CaddyElementType("NAMED_BLOCK");
  IElementType SIMPLE_VALUE = new CaddyElementType("SIMPLE_VALUE");

  IElementType COMMENT = new CaddyTokenType("COMMENT");
  IElementType EOL = new CaddyTokenType("EOL");
  IElementType IDENTIFIER = new CaddyTokenType("IDENTIFIER");
  IElementType LBRACE = new CaddyTokenType("LBRACE {");
  IElementType LBRACKET = new CaddyTokenType("LBRACKET [");
  IElementType LPAREN = new CaddyTokenType("LPAREN (");
  IElementType NUMBER = new CaddyTokenType("NUMBER");
  IElementType RBRACE = new CaddyTokenType("RBRACE }");
  IElementType RBRACKET = new CaddyTokenType("RBRACKET ]");
  IElementType RPAREN = new CaddyTokenType("RPAREN )");
  IElementType TEXT = new CaddyTokenType("TEXT");

  class Factory {
    public static PsiElement createElement(ASTNode node) {
      IElementType type = node.getElementType();
      if (type == ARGUMENT) {
        return new CaddyArgumentImpl(node);
      }
      else if (type == BLOCK) {
        return new CaddyBlockImpl(node);
      }
      else if (type == BLOCK_NAME) {
        return new CaddyBlockNameImpl(node);
      }
      else if (type == DIRECTIVE) {
        return new CaddyDirectiveImpl(node);
      }
      else if (type == ENV_VALUE) {
        return new CaddyEnvValueImpl(node);
      }
      else if (type == INSTRUCTION) {
        return new CaddyInstructionImpl(node);
      }
      else if (type == NAMED_BLOCK) {
        return new CaddyNamedBlockImpl(node);
      }
      else if (type == SIMPLE_VALUE) {
        return new CaddySimpleValueImpl(node);
      }
      throw new AssertionError("Unknown element type: " + type);
    }
  }
}
