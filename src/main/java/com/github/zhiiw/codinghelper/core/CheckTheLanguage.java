package core;

import com.intellij.openapi.actionSystem.AnActionEvent;
import com.intellij.openapi.actionSystem.CommonDataKeys;
import com.intellij.pom.Navigatable;

import java.util.StringTokenizer;

public class CheckTheLanguage {
    public String CheckLanguage(AnActionEvent anActionEvent){
        Navigatable nav = anActionEvent.getData(CommonDataKeys.NAVIGATABLE);
        StringTokenizer stringTokenizer = new StringTokenizer(nav.toString(),".");
        stringTokenizer.nextToken();
        String language =stringTokenizer.nextToken();
        return language;

    }
}
