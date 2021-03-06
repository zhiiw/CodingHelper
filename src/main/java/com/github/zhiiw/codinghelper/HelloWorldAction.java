import com.intellij.icons.AllIcons;
import com.intellij.navigation.NavigationItem;
import com.intellij.openapi.actionSystem.AnAction;
import com.intellij.openapi.actionSystem.AnActionEvent;
import com.intellij.openapi.actionSystem.CommonDataKeys;
import com.intellij.openapi.actionSystem.PlatformDataKeys;
import com.intellij.openapi.project.Project;
import com.intellij.openapi.ui.Messages;
import com.intellij.pom.Navigatable;
import org.jetbrains.annotations.NotNull;

public class HelloWorldAction extends AnAction {
    @Override
    public void actionPerformed(@NotNull AnActionEvent anActionEvent) {

        Project project = anActionEvent.getData(PlatformDataKeys.PROJECT);
        StringBuffer dlgMsg =new StringBuffer("The plugin is developed by bjtu se1902 zhiiwang.It is a time-counting plugin.");
        String dlgTitle = anActionEvent.getPresentation().getDescription();
        // If an element is selected in the editor, add info about it.
        Navigatable navigatable =anActionEvent.getData(CommonDataKeys.NAVIGATABLE);

        if (navigatable != null) {
            dlgMsg.append("The plugin is developed by bjtu se1902 zhiiwang.It is a time-counting plugin.");
        }
        Messages.showMessageDialog(project, dlgMsg.toString(), dlgTitle, Messages.getInformationIcon());


    }
}
