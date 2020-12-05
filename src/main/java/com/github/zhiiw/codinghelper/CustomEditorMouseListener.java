package com.github.zhiiw.codinghelper;

import com.intellij.notification.NotificationGroup;
import com.intellij.openapi.actionSystem.PlatformDataKeys;
import com.intellij.openapi.editor.event.EditorMouseEvent;
import com.intellij.openapi.editor.event.EditorMouseListener;
import com.intellij.openapi.fileEditor.FileDocumentManager;
import com.intellij.openapi.project.Project;
import com.intellij.openapi.ui.Messages;
import com.intellij.openapi.vfs.VirtualFile;
import org.freedesktop.dbus.messages.Message;

public class CustomEditorMouseListener implements com.intellij.openapi.editor.event.EditorMouseListener {
  @Override
  public void mousePressed(EditorMouseEvent editorMouseEvent) {
    FileDocumentManager instance = FileDocumentManager.getInstance();
    VirtualFile file = instance.getFile(editorMouseEvent.getEditor().getDocument());


    Project project = editorMouseEvent.getEditor().getProject();
    if (CodingHelper.firstTime==0){
      final long currentTime = System.currentTimeMillis()/1000;
      CodingHelper.firstTime=currentTime;
    }
    if (file!=null){
      String currentFIle =file.getPath();
      final long currentTime = System.currentTimeMillis()/1000;
      if (!currentFIle.equals(CodingHelper.lastFile)||CodingHelper.enoughTimePassed(currentTime)){
        CodingHelper.lastTime=currentTime;
        CodingHelper.lastFile =currentFIle;

        Messages.showMessageDialog(CodingHelper.firstTime+"","ee",Messages.getInformationIcon());

      }
    }
  }

  @Override
  public void mouseClicked(EditorMouseEvent editorMouseEvent) {

  }

  @Override
  public void mouseReleased(EditorMouseEvent editorMouseEvent) {
  }

  @Override
  public void mouseEntered(EditorMouseEvent editorMouseEvent) {
  }

  @Override
  public void mouseExited(EditorMouseEvent editorMouseEvent) {
  }
}