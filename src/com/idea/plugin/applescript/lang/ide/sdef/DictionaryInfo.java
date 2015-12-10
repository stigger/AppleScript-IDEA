package com.idea.plugin.applescript.lang.ide.sdef;

import com.intellij.openapi.vfs.VirtualFile;
import com.intellij.util.xml.Required;
import com.intellij.util.xmlb.annotations.Attribute;
import com.intellij.util.xmlb.annotations.OptionTag;
import com.intellij.util.xmlb.annotations.Tag;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public class DictionaryInfo {
  @NotNull private final String applicationName;
  @NotNull private VirtualFile dictionaryFile;
  @Nullable private VirtualFile applicationFile;
  @NotNull private State state;
  private boolean initialized;

  public DictionaryInfo(@NotNull String applicationName, @NotNull VirtualFile dictionaryFile,
                        @Nullable VirtualFile applicationFile) {
    this.applicationName = applicationName;
    this.dictionaryFile = dictionaryFile;
    this.applicationFile = applicationFile;
    state = new State(applicationName, dictionaryFile.getPath(),
            applicationFile != null ? applicationFile.getPath() : null);
  }

  @NotNull
  public String getApplicationName() {
    return applicationName;
  }

  @NotNull
  public VirtualFile getDictionaryFile() {
    return dictionaryFile;
  }

  @Nullable
  public VirtualFile getApplicationFile() {
    return applicationFile;
  }

  @NotNull
  public State getState() {
    return state;
  }

  public boolean isInitialized() {
    return initialized;
  }

  public boolean setInitialized(boolean initialized) {
    this.initialized = initialized;
    return initialized;
  }

  @Tag("dictionary-info")
  public static class State {
    @Attribute("applicationName")
    @Required
    public String applicationName;
    @OptionTag
    public String dictionaryUrl;
    @OptionTag
    public String applicationUrl;

    public State(@NotNull String applicationName, @NotNull String dictionaryUrl, @Nullable String applicationUrl) {
      this.applicationName = applicationName;
      this.dictionaryUrl = dictionaryUrl;
      this.applicationUrl = applicationUrl;
    }

    public State() {
    }
  }
}
