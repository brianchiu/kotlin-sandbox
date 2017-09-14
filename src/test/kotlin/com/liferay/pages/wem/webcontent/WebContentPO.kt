package com.liferay.pages.wem.webcontent

import com.liferay.pages.base.BasePO

class WebContentPO : BasePO() {
    fun add(title : String, content : String) {
        val addButton = "//button[@data-qa-id='addButton']"

        click(addButton)
        clickLink("Basic Web Content")
        typeInput("Title", title)
        typeAlloyEditor(content)
        clickButton("Publish")
    }

    fun view(title : String, content : String) {
        clickLink(title)
        assertInputValue("Title", title)
        assertAlloyEditorText(content)
    }
}