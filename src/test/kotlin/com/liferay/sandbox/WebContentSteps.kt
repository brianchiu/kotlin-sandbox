package com.liferay.sandbox

import cucumber.api.java.en.When

class WebContentSteps {
    val _webContentPageObject = WebContentPageObject()

    @When("^I add a web content with title \"([^\"]*)\" in the Admin Portlet$")
    fun addWebContentInAdminPortlet(title : String) {
        _webContentPageObject.addWebContentInAdminPortlet(title)
    }
}