package com.liferay.pages.collab.blogs

import com.liferay.pages.base.BasePO

class BlogsPO : BasePO() {
    fun addEntry(title : String, content : String) {
        if (isLinkPresent("Add Blog Entry")) {
            clickLink("Add Blog Entry")
        }
        else {
            click("//*[@data-qa-id='addButton']")
        }

        typeEditorTitle(title)
        typeEditorContent(content)
        clickButton("Publish")
        assertLinkVisible(title)
    }

    fun gotoEntry(title : String) {
        val entryPageTitle = "//div[@class='entry-title']/h1"

        clickLink(title)
        assertVisible((entryPageTitle))
    }
}