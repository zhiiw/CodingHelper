package com.github.zhiiw.codinghelper;

import com.intellij.openapi.editor.event.VisibleAreaEvent;
import com.intellij.openapi.editor.event.VisibleAreaListener;
import com.intellij.openapi.fileEditor.FileDocumentManager;
import com.intellij.openapi.project.Project;
import com.intellij.openapi.vfs.VirtualFile;

public class CustomVisibleAreaListener implements VisibleAreaListener {
  @Override
  public void visibleAreaChanged(VisibleAreaEvent visibleAreaEvent) {
    FileDocumentManager instance = FileDocumentManager.getInstance();
    VirtualFile file = instance.getFile(visibleAreaEvent.getEditor().getDocument());
    Project project = visibleAreaEvent.getEditor().getProject();
    /**
    if (CodingHelper.firstTime==0){
      final long currentTime = System.currentTimeMillis()/1000;
      CodingHelper.firstTime=currentTime;
    }
    long currentTime = System.currentTimeMillis() / 1000;
    CodingHelper.lastTime = currentTime;
     **/
  }
}