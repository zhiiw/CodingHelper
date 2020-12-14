package com.github.zhiiw.codinghelper;

import com.github.zhiiw.codinghelper.core.DataBaseUse;
import com.github.zhiiw.codinghelper.core.GetPoem;
import com.intellij.notification.Notification;
import com.intellij.notification.NotificationDisplayType;
import com.intellij.notification.NotificationGroup;
import com.intellij.notification.Notifications;
import com.intellij.openapi.application.ApplicationManager;
import com.intellij.openapi.components.ServiceManager;
import com.intellij.openapi.project.Project;
import com.intellij.openapi.project.ProjectManagerListener;
import com.intellij.openapi.ui.MessageType;
import com.intellij.openapi.ui.Messages;
import org.jetbrains.annotations.NotNull;

import java.io.IOException;

public class ProjectListener implements ProjectManagerListener {
  @Override
  public void projectOpened(@NotNull Project project) {
    try {
      Messages.showMessageDialog(project, GetPoem.getPoem(),"Daily poems",Messages.getInformationIcon());
    } catch (IOException e) {
      e.printStackTrace();
    }

    if (ApplicationManager.getApplication().isUnitTestMode()) {
      return;
    }
    if (CodingHelper.isState&&CodingHelper.lastTime-CodingHelper.firstTime>=1000) {
      String title = String.format("Opening Project \"%s\"", project.getName());
      String message = "<br>You have achieved today 's language learning goals .<br><br>" + "This is not an error<br><br>";
      Messages.showMessageDialog(project, message, title, Messages.getInformationIcon());
    }else if (!CodingHelper.isState&&CodingHelper.lastTime-CodingHelper.firstTime>=1000){
      String title = String.format("Opening Project \"%s\"", project.getName());
      String message = "You have reached today 's language learning limits ." + "Please shut down your ide";

    }
  }

  /**
   * it helps to remind user the time will come.
   */
  public void notifyTheTime(){
    if (CodingHelper.firstTime-CodingHelper.lastTime<0){
      NotificationGroup notificationGroup=new NotificationGroup("plugin_id", NotificationDisplayType.BALLOON,true);
      Notification notification=notificationGroup.createNotification("You have five minutes to reach today's goal.",MessageType.INFO);
      Notifications.Bus.notify(notification);
    }
  }
  /**
   * Invoked on project close.
   *
   * @param project closing project
   */
  @Override
  public void projectClosed(@NotNull Project project) {
    // Ensure this isn't part of testing
    if (ApplicationManager.getApplication().isUnitTestMode()) {
      return;
    }


  }
}
