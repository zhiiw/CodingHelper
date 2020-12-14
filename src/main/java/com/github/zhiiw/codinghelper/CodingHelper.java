package com.github.zhiiw.codinghelper;

import com.github.zhiiw.codinghelper.core.DataBaseUse;
import com.intellij.AppTopics;
import com.intellij.openapi.application.ApplicationManager;
import com.intellij.openapi.components.ApplicationComponent;
import com.intellij.openapi.components.BaseComponent;
import com.intellij.openapi.editor.EditorFactory;
import com.intellij.openapi.project.Project;
import com.intellij.openapi.ui.Messages;
import com.intellij.openapi.vfs.VirtualFile;
import com.intellij.util.messages.MessageBus;
import com.intellij.util.messages.MessageBusConnection;

import java.math.BigDecimal;


public class CodingHelper implements ApplicationComponent {
  public static boolean isState =false;//which means you are anti indulged or study pattern.
  public static MessageBusConnection connection;
  public static String lastFile =null;
  public static long lastTime=0;
  public static long firstTime=0;
  @Override
  public void initComponent() {
    DataBaseUse.addNewDay();

    setupListeners();
  }

  @Override
  public void disposeComponent() {

  }
  public static boolean enoughTimePassed(long time){
    if (CodingHelper.lastTime+120<time){
      return true;
    }
    return CodingHelper.lastTime+120<time;
  }
  public static void setupListeners(){
    ApplicationManager.getApplication().invokeLater(new Runnable() {
      @Override
      public void run() {
        MessageBus messageBus =ApplicationManager.getApplication().getMessageBus();
        connection =messageBus.connect();
        connection.subscribe(AppTopics.FILE_DOCUMENT_SYNC,new SaveListener());

        EditorFactory.getInstance().getEventMulticaster().addDocumentListener(new CustomDocumentListener());
        EditorFactory.getInstance().getEventMulticaster().addEditorMouseListener(new CustomEditorMouseListener());
        EditorFactory.getInstance().getEventMulticaster().addVisibleAreaListener(new CustomVisibleAreaListener());
      }
    });
  }



  public static BigDecimal getCurrentTimestamp() {
    return new BigDecimal(String.valueOf(System.currentTimeMillis() / 1000.0)).setScale(4, BigDecimal.ROUND_HALF_UP);
  }


}
