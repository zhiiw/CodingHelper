package com.github.zhiiw.codinghelper.core;

import com.intellij.openapi.actionSystem.AnActionEvent;
import com.intellij.openapi.actionSystem.CommonDataKeys;
import com.intellij.pom.Navigatable;

import java.util.StringTokenizer;

public class CheckTheLanguage {
    public static String checkLanguage(String lang){
        StringTokenizer stringTokenizer = new StringTokenizer(lang,".");
        stringTokenizer.nextToken();
        String language =stringTokenizer.nextToken();
        if (lang.equals("java")||lang.equals("c")||lang.equals("cpp")||lang.equals("js")||lang.equals("go")||lang.equals("hs")||lang.equals("kt")||lang.equals("rs")||lang.equals("py")){
            return "other";
        }
        return language;
    }
}
