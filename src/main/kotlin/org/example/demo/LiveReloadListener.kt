package org.example.demo

import com.intellij.openapi.actionSystem.ActionManager
import com.intellij.openapi.actionSystem.AnActionEvent
import com.intellij.openapi.actionSystem.CommonDataKeys
import com.intellij.openapi.editor.Document
import com.intellij.openapi.externalSystem.autoimport.changes.FilesChangesListener
import com.intellij.openapi.fileEditor.FileDocumentManager
import com.intellij.openapi.fileEditor.FileDocumentManagerListener
import com.intellij.openapi.vfs.VirtualFile
import com.intellij.openapi.vfs.VirtualFileEvent
import com.intellij.openapi.vfs.VirtualFileListener
import com.intellij.openapi.vfs.VirtualFilePropertyEvent
import com.intellij.openapi.vfs.newvfs.BulkFileListener
import com.intellij.openapi.vfs.newvfs.events.VFileEvent
import kotlinx.serialization.json.Json


class LiveReloadListener: BulkFileListener {

    override fun after(events: MutableList<out VFileEvent>) {
        for (event in events) {
            val file = event.file
            if (file?.name == ".idea_settings.json") {
                val contentBytes = file.contentsToByteArray()
                val contentJson = String(contentBytes, Charsets.US_ASCII)
                val content = Json.parseToJsonElement(contentJson)
                applySettings(content)
            }
        }
    }
}