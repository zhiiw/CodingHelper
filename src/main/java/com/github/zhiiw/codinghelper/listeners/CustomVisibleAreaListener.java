package com.github.zhiiw.codinghelper.listeners;

import com.github.zhiiw.codinghelper.CodingHelper;
import com.github.zhiiw.codinghelper.core.CheckTheLanguage;
import com.github.zhiiw.codinghelper.core.DataBaseUse;
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

    if (CodingHelper.firstTime==0){
      final long currentTime = System.currentTimeMillis()/1000;
      CodingHelper.firstTime=currentTime;

    }
    long time =CodingHelper.lastTime;

    if (System.currentTimeMillis()/1000-time>=60){
      long border =System.currentTimeMillis()/1000-time;
      CodingHelper.firstTime+=border;
    }
    final long currentTime = System.currentTimeMillis()/1000;

    if (CodingHelper.enoughTimePassed(currentTime)){
      String fileName = file != null ? file.getName() : null;
      DataBaseUse.updateTime(CheckTheLanguage.checkLanguage(fileName),(currentTime-CodingHelper.lastTime)/60);
      CodingHelper.lastTime=currentTime;
    }


  }
}