package com.idea.plugin.applescript.lang.resolve;

import com.idea.plugin.applescript.psi.AppleScriptComponent;
import com.idea.plugin.applescript.psi.AppleScriptTargetVariable;
import com.intellij.openapi.util.Key;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * Created by Andrey on 20.04.2015.
 */
public class AppleScriptComponentScopeProcessor extends AppleScriptPsiScopeProcessor {

  private final @NotNull Set<AppleScriptComponent> myResult;
  private final Map<String, AppleScriptTargetVariable> myCollectedTargets =
          new HashMap<String, AppleScriptTargetVariable>();

  public AppleScriptComponentScopeProcessor(@NotNull Set<AppleScriptComponent> myResult) {
    this.myResult = myResult;
  }

  @Override
  protected boolean doExecute(@NotNull AppleScriptComponent element) {
    if (element instanceof AppleScriptTargetVariable) {
      final AppleScriptTargetVariable targetVar = (AppleScriptTargetVariable) element;
      if (!myCollectedTargets.containsKey(targetVar.getName())) {
        myCollectedTargets.put(targetVar.getName(), targetVar);
        myResult.add(targetVar);
      } else if (targetVar.getContainingFile() != myCollectedTargets.get(targetVar.getName()).getContainingFile()) {
        myResult.add(targetVar);//should not happen if the file is the same
        AppleScriptTargetVariable addedVar = myCollectedTargets.get(targetVar.getName());
        // if there already variable with the same name defined it should be located in the same local context
        // (file, handler etc)
        throw new AssertionError("Elements are defined in different files:");
      }
    } else
      myResult.add(element);

    return true;
  }

  @Nullable
  @Override
  public <T> T getHint(@NotNull Key<T> hintKey) {
    return null;
  }

  @Override
  public void handleEvent(@NotNull Event event, @Nullable Object associated) {

  }
}
