package com.github.zhiiw.codinghelper;

import com.intellij.openapi.editor.Document;
import com.intellij.openapi.fileEditor.FileDocumentManager;
import com.intellij.openapi.fileEditor.FileDocumentManagerListener;
import com.intellij.openapi.ui.Messages;
import com.intellij.openapi.vfs.VirtualFile;
import org.jetbrains.annotations.NotNull;

public class SaveListener implements FileDocumentManagerListener {

  @Override
  public void beforeDocumentSaving(Document document) {

    FileDocumentManager instance = FileDocumentManager.getInstance();
    VirtualFile file = instance.getFile(document);

    String currentFile =instance.getFile(document).getPath();
    /**long currentTime = System.currentTimeMillis() / 1000;

    CodingHelper.lastFile = currentFile;
    CodingHelper.lastTime = currentTime;*/
  }

  @Override
  public void beforeAllDocumentsSaving() {
  }

  @Override
  public void beforeFileContentReload(@NotNull VirtualFile file, @NotNull Document document) {
  }

  @Override
  public void fileWithNoDocumentChanged(@NotNull VirtualFile file) {
  }

  @Override
  public void fileContentReloaded(@NotNull VirtualFile file, @NotNull Document document) {
  }

  @Override
  public void fileContentLoaded(@NotNull VirtualFile file, @NotNull Document document) {
  }

  @Override
  public void unsavedDocumentsDropped() {
  }
}
