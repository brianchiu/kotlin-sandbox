package com.liferay.sandbox;

import cucumber.api.java.en.When
import cucumber.api.java.en.Then

import com.liferay.sandbox.BasePageObject

class BaseSteps {
	val _basePageObject = BasePageObject()

	@When(value = "^I click the \"([^\"]*)\" button$")
	fun clickButton(button : String) {
		_basePageObject.clickButton(button)
	}

	@When(value = "^I click the \"([^\"]*)\" link$")
	fun clickLink(link : String) {
		_basePageObject.clickLink(link)
	}

	@Then(value = "^I close the browser$")
	fun closeBrowser() {
		_basePageObject.quit()
	}

	@When(value = "^I open a browser to \"(https?.+)\"$")
	fun open(url : String) {
		_basePageObject.open(url)
	}

	@When(value = "^I enter \"([^\"]*)\" in the \"([^\"]*)\" field$")
	fun typeInput(text: String, field: String) {
		_basePageObject.typeInput(field, text)
	}
}