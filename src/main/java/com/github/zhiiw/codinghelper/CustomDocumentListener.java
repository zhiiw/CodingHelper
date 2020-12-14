package com.github.zhiiw.codinghelper;

import com.github.zhiiw.codinghelper.core.CheckTheLanguage;
import com.github.zhiiw.codinghelper.core.DataBaseUse;
import com.intellij.openapi.editor.Document;
import com.intellij.openapi.editor.event.DocumentEvent;
import com.intellij.openapi.editor.event.DocumentListener;
import com.intellij.openapi.fileEditor.FileDocumentManager;
import com.intellij.openapi.ui.Messages;
import com.intellij.openapi.vfs.VirtualFile;

public class CustomDocumentListener implements DocumentListener {
  @Override
  public void beforeDocumentChange(DocumentEvent documentEvent) {
  }

  @Override
  public void documentChanged(DocumentEvent documentEvent) {

    Document document = documentEvent.getDocument();
    FileDocumentManager instance = FileDocumentManager.getInstance();
    VirtualFile file = instance.getFile(document);
    String fileName = file != null ? file.getName() : null;


    if (CodingHelper.firstTime==0){
      final long currentTime = System.currentTimeMillis()/1000;
      CodingHelper.firstTime=currentTime;
    }
    if (file!=null){
      long time =CodingHelper.lastTime;
      if (System.currentTimeMillis()/1000-time>=60){
        long border =System.currentTimeMillis()/1000-time;
        CodingHelper.firstTime+=border;
      }
      String currentFIle =  file.getPath();
      final long currentTime = System.currentTimeMillis()/1000;
      if (currentFIle.equals(CodingHelper.lastFile)&&CodingHelper.enoughTimePassed(currentTime)){
        DataBaseUse.updateTime(CheckTheLanguage.checkLanguage(fileName),(currentTime-CodingHelper.lastTime)/60);

        CodingHelper.lastTime=currentTime;
        CodingHelper.lastFile =currentFIle;
      }
    }
  }
}