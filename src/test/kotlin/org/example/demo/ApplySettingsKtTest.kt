package org.example.demo


import com.intellij.openapi.actionSystem.CustomShortcutSet

import com.intellij.openapi.editor.colors.EditorColorsManager
import com.intellij.openapi.editor.ex.EditorSettingsExternalizable
import com.intellij.openapi.keymap.KeymapManager
import com.intellij.testFramework.fixtures.BasePlatformTestCase
import kotlinx.serialization.json.Json


class ApplySettingsKtTest : BasePlatformTestCase() {

    fun testApplyFontSettings() {
        val settings = """
            {
                "fontSize" : 20
            }
        """
        applySettings(Json.parseToJsonElement(settings))
        assertEquals(EditorColorsManager.getInstance().globalScheme.editorFontSize, 20)
    }

    fun testKeymap() {
        val settings = """
            {
                "keymap" : {
                    "ZoomInIdeAction" : "ctrl alt Z"
                }
            }
        """
        applySettings(Json.parseToJsonElement(settings))
        val keymap = KeymapManager.getInstance().activeKeymap
        val shortcut = CustomShortcutSet.fromString("ctrl alt Z").shortcuts[0]
        assertEquals(keymap.getShortcuts("ZoomInIdeAction")[0], shortcut)
    }

    fun testEditorSetting() {
        val settings = """
            {
                "editor" : {
                    "TOOLTIPS_DELAY_MS" : 1000
                }
            }
        """
        applySettings(Json.parseToJsonElement(settings))
        val globalEditor = EditorSettingsExternalizable.getInstance()
        assertEquals(1000, globalEditor.options.TOOLTIPS_DELAY_MS)
    }
}