package com.liferay.wem.webcontent

import cucumber.api.java.en.When

class WebContentSteps {
    private val _webContentPO = WebContentPO()

    @When(value = "^I add a Web Content article with title \"([^\"]*)\" and content \"([^\"]*)\" in the admin app$")
    fun add(title : String, content : String) {
        _webContentPO.add(title, content)
    }

    @When(value = "^I view the Web Content article with title \"([^\"]*)\" and content \"([^\"]*)\" in the admin app$")
    fun view(title : String, content : String) {
        _webContentPO.view(title, content)
    }
}