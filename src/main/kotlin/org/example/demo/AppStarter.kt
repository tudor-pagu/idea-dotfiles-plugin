package org.example.demo

import com.intellij.openapi.project.Project
import com.intellij.openapi.startup.ProjectActivity
import com.intellij.openapi.startup.StartupActivity
import com.intellij.openapi.vfs.VirtualFileManager

class AppStarter : ProjectActivity {
    override suspend fun execute(project: Project) {
        project.messageBus.connect().subscribe(VirtualFileManager.VFS_CHANGES, LiveReloadListener())
        print("STARTING PLUGIN")
    }


}