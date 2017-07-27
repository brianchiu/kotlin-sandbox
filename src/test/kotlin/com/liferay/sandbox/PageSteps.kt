package com.liferay.sandbox

import cucumber.api.java.en.When

class PageSteps {
    val _pagePageObject = PagePageObject()

    @When("^I add a page named \"([^\"]*)\"$")
    fun addPage(pageName : String) {
        _pagePageObject.addPage(pageName)
    }
}