package com.liferay.steps.base

import cucumber.api.java.en.When

import com.liferay.pages.base.BasePage

class BaseSteps {
    private val _basePage = BasePage()

    @When(value = "^I click the \"([^\"]*)\" button$")
    fun clickButton(button : String) {
        _basePage.clickButton(button)
    }

    @When(value = "^I click the \"([^\"]*)\" link$")
    fun clickLink(button : String) {
        _basePage.clickLink(button)
    }

    @When(value = "^I open a browser to \"(https?.+)\"$")
    fun open(url : String) {
        _basePage.open(url)
    }

    @When(value = "^I enter \"([^\"]*)\" in the \"([^\"]*)\" field$")
    fun typeInput(text: String, field: String) {
        _basePage.typeInput(field, text)
    }
}