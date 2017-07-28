package com.liferay.sandbox

class WebContentPageObject : BasePageObject() {
    val _basePageObject = BasePageObject()

    fun addWebContentInAdminPortlet(title : String) {
        val addButton = "//*[@data-qa-id='addButton']"

        _basePageObject.click(addButton)
        clickLink("Basic Web Content")
        typeInput("Title", title)
        clickButton("Publish")
    }
}