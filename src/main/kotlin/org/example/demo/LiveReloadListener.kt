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
import kotlinx.serialization.json.Json


class LiveReloadListener: FileDocumentManagerListener {
    override fun fileContentLoaded(file: VirtualFile, document: Document) {
        super.fileContentLoaded(file, document)
    }

    override fun afterDocumentUnbound(file: VirtualFile, document: Document) {
        super.afterDocumentUnbound(file, document)
    }

    override fun fileContentReloaded(file: VirtualFile, document: Document) {
        super.fileContentReloaded(file, document)
    }



    override fun beforeDocumentSaving(document: Document) {
        // This method is called before a document is saved
        // You can perform your live reload action here
        val virtualFile = FileDocumentManager.getInstance().getFile(document)
        if (virtualFile != null) {
            // Check if the file is of interest (optional)
            if (isFileOfInterest(virtualFile)) {
                performLiveReloadAction(virtualFile)
            }
        }
    }

    private fun isFileOfInterest(virtualFile: VirtualFile): Boolean {
        // Implement your logic to check if the file is of interest for live reload
        // For example, check file extension, location, etc.
        return virtualFile.name == ".idea_settings.json"
    }

    private fun performLiveReloadAction(virtualFile: VirtualFile) {
        val contentBytes = virtualFile.contentsToByteArray()
        val contentJson = String(contentBytes, Charsets.US_ASCII)
        val content = Json.parseToJsonElement(contentJson)
        applySettings(content)
    }
}