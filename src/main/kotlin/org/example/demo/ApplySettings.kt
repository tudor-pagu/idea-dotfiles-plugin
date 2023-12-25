package org.example.demo

import com.intellij.openapi.actionSystem.ActionManager
import com.intellij.openapi.actionSystem.ActionUpdateThread
import com.intellij.openapi.actionSystem.AnAction
import com.intellij.openapi.actionSystem.AnActionEvent
import com.intellij.openapi.actionSystem.CustomShortcutSet
import com.intellij.openapi.actionSystem.PlatformDataKeys
import com.intellij.openapi.actionSystem.Shortcut
import com.intellij.openapi.editor.EditorFactory
import com.intellij.openapi.editor.actionSystem.EditorActionManager
import com.intellij.openapi.editor.colors.EditorColorsManager
import com.intellij.openapi.editor.colors.EditorColorsScheme
import com.intellij.openapi.keymap.KeymapManager
import com.intellij.openapi.keymap.KeymapUtil
import com.intellij.psi.codeStyle.CodeStyleSettingsManager
import com.intellij.psi.search.FilenameIndex
import com.intellij.psi.search.GlobalSearchScope
import kotlinx.serialization.json.*
import java.io.BufferedReader

class ApplySettings : AnAction() {
    override fun update(event: AnActionEvent) {
        return super.update(event)
    }
    private fun applySettings(settings : JsonElement, p0 : AnActionEvent) {
        if (settings is JsonObject) {

            // fontSize

            val fontSize = settings["fontSize"]?.jsonPrimitive?.contentOrNull?.toInt()
            if (fontSize != null) {
                val editColorsScheme: EditorColorsScheme = EditorColorsManager.getInstance().globalScheme
                editColorsScheme.editorFontSize = fontSize
            }

            // fontName

            val fontName = settings["font"]?.jsonPrimitive?.contentOrNull
            if (fontName != null) {
                val editColorsScheme: EditorColorsScheme = EditorColorsManager.getInstance().globalScheme
                editColorsScheme.editorFontName = fontName
            }

            // keymap
            val jsonKeymap = settings["keymap"]
            if (jsonKeymap is JsonObject) {
                val keymapManager = KeymapManager.getInstance()
                val keymap = keymapManager.getKeymap("GNOME")

                for (entry in jsonKeymap) {
                    val actionId : String = entry.key
                    val binding : String = entry.value.jsonPrimitive.content
                    println("action : $actionId binding : $binding")
                    keymap?.removeAllActionShortcuts(actionId)
                    keymap?.addShortcut(actionId, CustomShortcutSet.fromString(binding).shortcuts[0])
                    //keymapManager.bindShortcuts(actionId, binding)
                }
            }

            EditorFactory.getInstance().refreshAllEditors()


        }
    }
    override fun actionPerformed(p0: AnActionEvent) {
        p0.getData(PlatformDataKeys.VIRTUAL_FILE)
        val project = p0.project
        if (project != null) {
            val projectScope = GlobalSearchScope.allScope(project)
            val files = FilenameIndex.getVirtualFilesByName(".idea_settings.json", projectScope)
            for (file in files) {
                val contentBytes = file.contentsToByteArray()
                val contentJson = String(contentBytes, Charsets.US_ASCII)
                val content = Json.parseToJsonElement(contentJson)
                applySettings(content, p0)
                print("test")
            }
            print("hi")
        }
    }

    override fun getActionUpdateThread(): ActionUpdateThread {
        return super.getActionUpdateThread()
    }

}