// This is a generated file. Not intended for manual editing.
package com.github.xepozz.caddy.language.psi;

import org.jetbrains.annotations.*;
import com.intellij.psi.PsiElementVisitor;
import com.intellij.psi.PsiElement;

public class CaddyVisitor extends PsiElementVisitor {

  public void visitArgument(@NotNull CaddyArgument o) {
    visitPsiElement(o);
  }

  public void visitBlock(@NotNull CaddyBlock o) {
    visitPsiElement(o);
  }

  public void visitBlockName(@NotNull CaddyBlockName o) {
    visitPsiElement(o);
  }

  public void visitDirective(@NotNull CaddyDirective o) {
    visitPsiElement(o);
  }

  public void visitEnvValue(@NotNull CaddyEnvValue o) {
    visitPsiElement(o);
  }

  public void visitInstruction(@NotNull CaddyInstruction o) {
    visitPsiElement(o);
  }

  public void visitNamedBlock(@NotNull CaddyNamedBlock o) {
    visitPsiElement(o);
  }

  public void visitSimpleValue(@NotNull CaddySimpleValue o) {
    visitPsiElement(o);
  }

  public void visitPsiElement(@NotNull PsiElement o) {
    visitElement(o);
  }

}
