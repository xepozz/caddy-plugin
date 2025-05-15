// This is a generated file. Not intended for manual editing.
package com.github.xepozz.caddy.language.psi;

import java.util.List;
import org.jetbrains.annotations.*;
import com.intellij.psi.PsiElement;
import com.intellij.psi.NavigatablePsiElement;
import com.intellij.psi.PsiNamedElement;

public interface CaddyDirective extends NavigatablePsiElement, PsiNamedElement {

  @NotNull
  List<CaddyArgument> getArgumentList();

  @Nullable
  CaddyBlock getBlock();

}
