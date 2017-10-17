package com.liferay.steps.base

import cucumber.api.java.en.When

import com.liferay.pages.base.BasePO

class BaseSteps {
    private val _basePO = BasePO()

    @When(value = "^I click the \"([^\"]*)\" button$")
    fun clickButton(button : String) {
        _basePO.clickButton(button)
    }

    @When(value = "^I click the \"([^\"]*)\" link$")
    fun clickLink(button : String) {
        _basePO.clickLink(button)
    }

    @When(value = "^I open a browser to \"(https?.+)\"$")
    fun open(url : String) {
        _basePO.open(url)
    }

    @When(value = "^I enter \"([^\"]*)\" in the \"([^\"]*)\" field$")
    fun typeInput(text: String, field: String) {
        _basePO.typeInput(field, text)
    }
}