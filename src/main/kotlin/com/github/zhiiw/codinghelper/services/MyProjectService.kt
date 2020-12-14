/**package com.github.zhiiw.codinghelper.services

import com.intellij.openapi.project.Project
import com.github.zhiiw.codinghelper.MyBundle

class MyProjectService(project: Project) {

    init {
        println(MyBundle.message("projectService", project.name))
    }
}
*/