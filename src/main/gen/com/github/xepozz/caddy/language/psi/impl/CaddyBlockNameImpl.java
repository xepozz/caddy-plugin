// This is a generated file. Not intended for manual editing.
package com.github.xepozz.caddy.language.psi.impl;

import java.util.List;
import org.jetbrains.annotations.*;
import com.intellij.lang.ASTNode;
import com.intellij.psi.PsiElement;
import com.intellij.psi.PsiElementVisitor;
import com.intellij.psi.util.PsiTreeUtil;
import static com.github.xepozz.caddy.language.psi.CaddyTypes.*;
import com.intellij.extapi.psi.ASTWrapperPsiElement;
import com.github.xepozz.caddy.language.psi.*;

public class CaddyBlockNameImpl extends ASTWrapperPsiElement implements CaddyBlockName {

  public CaddyBlockNameImpl(@NotNull ASTNode node) {
    super(node);
  }

  public void accept(@NotNull CaddyVisitor visitor) {
    visitor.visitBlockName(this);
  }

  @Override
  public void accept(@NotNull PsiElementVisitor visitor) {
    if (visitor instanceof CaddyVisitor) accept((CaddyVisitor)visitor);
    else super.accept(visitor);
  }

}
