# Description
This is a plugin written in Kotlin for Intellij IDEA that allows users to store settings in a dotfile and automatically applies them to the editor with live reload (whenever the file is saved the settings are automatically applied.)

# Usage instructions
1. To test the plugin you can clone the repo and open it in intellij idea, then use the "Run Plugin" option.
2. Create a file named ".idea_settings.json" in your project's root directory. This is where you can store the settings.
3. Edit the ".idea_settings.json" file to add settings! Consult with the example below to see what settings the plugin supports. Use the JSON format. You can only change a subset of the IDE settings,  such as fontSize, font (font name). You can also change the keymap by adding new shortcuts in the "keymap" object
4. Save the .idea_settings.json file to apply changes! You can also use the custom action "Apply Settings" added by the plugin.
# Example .idea_settings.json
This is an example of a .idea_settings.json file that this plugin supports.
All the supported editor settings are listed in the "editor" object,
but you can add any shortcut you want to the keymap, simply add the "action name" with a string representing the shortcut in a similar format to the example.
```
{
  "fontSize" : 14,
  "font" : "JetBrains Mono",
  "keymap" : {
    "ZoomInIdeAction" : "ctrl alt Z",
    "ZoomOutIdeAction" : "ctrl shift O",
    "ShowNavBar" : "ctrl T"
  },
  "editor" : {
    "LINE_SEPARATOR" : null,
    "USE_SOFT_WRAPS" : null,
    "SOFT_WRAP_FILE_MASKS" : null,
    "USE_CUSTOM_SOFT_WRAP_INDENT" : true,
    "CUSTOM_SOFT_WRAP_INDENT" : 0,
    "IS_VIRTUAL_SPACE" : false,
    "IS_CARET_INSIDE_TABS" : false,
    "STRIP_TRAILING_SPACES" : "Changed",
    "IS_ENSURE_NEWLINE_AT_EOF" : false,
    "REMOVE_TRAILING_BLANK_LINES" : false,
    "SHOW_QUICK_DOC_ON_MOUSE_OVER_ELEMENT" : true,
    "SHOW_INSPECTION_WIDGET" : true,
    "TOOLTIPS_DELAY_MS" : 500,
    "SHOW_INTENTION_BULB" : false,
    "IS_CARET_BLINKING" : false,
    "CARET_BLINKING_PERIOD" : 500,
    "IS_RIGHT_MARGIN_SHOWN" : true,
    "ARE_LINE_NUMBERS_SHOWN" : true,
    "ARE_GUTTER_ICONS_SHOWN" : true,
    "IS_FOLDING_OUTLINE_SHOWN" : true,
    "IS_FOLDING_ENDINGS_SHOWN" : false,
    "SHOW_BREADCRUMBS_ABOVE" : false,
    "SHOW_BREADCRUMBS" : true,
    "ENABLE_RENDERED_DOC" : false,
    "SHOW_INTENTION_PREVIEW" : true,
    "USE_EDITOR_FONT_IN_INLAYS" : false,
    "SMART_HOME" : true,
    "IS_BLOCK_CURSOR" : false,
    "IS_WHITESPACES_SHOWN" : false,
    "IS_LEADING_WHITESPACES_SHOWN" : true,
    "IS_INNER_WHITESPACES_SHOWN" : true,
    "IS_TRAILING_WHITESPACES_SHOWN" : true,
    "IS_ALL_SOFTWRAPS_SHOWN" : false,
    "IS_INDENT_GUIDES_SHOWN" : true,
    "IS_FOCUS_MODE" : false,
    "IS_ANIMATED_SCROLLING" : true,
    "IS_CAMEL_WORDS" : false,
    "ADDITIONAL_PAGE_AT_BOTTOM" : false,
    "IS_DND_ENABLED" : true,
    "IS_WHEEL_FONTCHANGE_ENABLED" : false,
    "IS_WHEEL_FONTCHANGE_PERSISTENT" : false,
    "IS_MOUSE_CLICK_SELECTION_HONORS_CAMEL_WORDS" : true,
    "RENAME_VARIABLES_INPLACE" : true,
    "PRESELECT_RENAME" : true,
    "SHOW_INLINE_DIALOG" : true,
    "REFRAIN_FROM_SCROLLING" : false,
    "ADD_CARETS_ON_DOUBLE_CTRL" : true,
    "SHOW_PARAMETER_NAME_HINTS" : true,
    "KEEP_TRAILING_SPACE_ON_CARET_LINE" : true,
    "INSERT_PARANTHESES_AUTOMATICALLY" : true
  }
}
```
