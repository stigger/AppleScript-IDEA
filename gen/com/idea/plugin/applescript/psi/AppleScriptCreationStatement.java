// This is a generated file. Not intended for manual editing.
package com.idea.plugin.applescript.psi;

import java.util.List;
import org.jetbrains.annotations.*;
import com.intellij.psi.PsiElement;

public interface AppleScriptCreationStatement extends AppleScriptPsiElement {

  @NotNull
  List<AppleScriptExpression> getExpressionList();

  @Nullable
  AppleScriptReferenceIdentifier getReferenceIdentifier();

  @Nullable
  AppleScriptTargetListLiteral getTargetListLiteral();

  @Nullable
  AppleScriptTargetRecordLiteral getTargetRecordLiteral();

  @Nullable
  AppleScriptTargetVariable getTargetVariable();

  @Nullable
  AppleScriptPsiElement getAssignmentTarget();

  @NotNull
  List<AppleScriptComponentName> getTargetVariableList();

}
