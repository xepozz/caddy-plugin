// This is a generated file. Not intended for manual editing.
package com.github.xepozz.caddy.language.psi;

import org.jetbrains.annotations.*;
import com.intellij.psi.PsiElementVisitor;
import com.intellij.psi.PsiElement;
import com.intellij.psi.NavigatablePsiElement;
import com.intellij.psi.PsiNamedElement;

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
    visitNavigatablePsiElement(o);
    // visitPsiNamedElement(o);
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

  public void visitNavigatablePsiElement(@NotNull NavigatablePsiElement o) {
    visitElement(o);
  }

  public void visitPsiElement(@NotNull PsiElement o) {
    visitElement(o);
  }

}
