// This is a generated file. Not intended for manual editing.
package com.idea.plugin.applescript.psi.impl;

import java.util.List;
import org.jetbrains.annotations.*;
import com.intellij.lang.ASTNode;
import com.intellij.psi.PsiElement;
import com.intellij.psi.PsiElementVisitor;
import com.intellij.psi.util.PsiTreeUtil;
import static com.idea.plugin.applescript.psi.AppleScriptTypes.*;
import com.idea.plugin.applescript.psi.*;

public class AppleScriptObjectRefImpl extends AppleScriptPsiElementImpl implements AppleScriptObjectRef {

  public AppleScriptObjectRefImpl(ASTNode node) {
    super(node);
  }

  public void accept(@NotNull PsiElementVisitor visitor) {
    if (visitor instanceof AppleScriptVisitor) ((AppleScriptVisitor)visitor).visitObjectRef(this);
    else super.accept(visitor);
  }

  @Override
  @Nullable
  public AppleScriptApplicationObjectReference getApplicationObjectReference() {
    return findChildByClass(AppleScriptApplicationObjectReference.class);
  }

  @Override
  @NotNull
  public List<AppleScriptExpression> getExpressionList() {
    return PsiTreeUtil.getChildrenOfTypeAsList(this, AppleScriptExpression.class);
  }

  @Override
  @NotNull
  public List<AppleScriptFilterReference> getFilterReferenceList() {
    return PsiTreeUtil.getChildrenOfTypeAsList(this, AppleScriptFilterReference.class);
  }

  @Override
  @NotNull
  public List<AppleScriptHandlerInterleavedParametersCall> getHandlerInterleavedParametersCallList() {
    return PsiTreeUtil.getChildrenOfTypeAsList(this, AppleScriptHandlerInterleavedParametersCall.class);
  }

  @Override
  @NotNull
  public List<AppleScriptHandlerParameterLabel> getHandlerParameterLabelList() {
    return PsiTreeUtil.getChildrenOfTypeAsList(this, AppleScriptHandlerParameterLabel.class);
  }

  @Override
  @NotNull
  public List<AppleScriptNumericConstant> getNumericConstantList() {
    return PsiTreeUtil.getChildrenOfTypeAsList(this, AppleScriptNumericConstant.class);
  }

  @Override
  @Nullable
  public AppleScriptObjectRef getObjectRef() {
    return findChildByClass(AppleScriptObjectRef.class);
  }

}
