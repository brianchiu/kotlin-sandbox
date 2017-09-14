package com.liferay.sandbox

import cucumber.api.java.en.When

class ProductMenuSteps {
    private val _productMenuPO = ProductMenuPO()

    @When(value = "^I add a page with name \"([^\"]*)\"$")
    fun addPage(page : String) {
        _productMenuPO.addPage(page)
    }

    @When(value = "^I navigate to \"([^\"]*)\" > \"([^\"]*)\" in the Product Menu$")
    fun goToAppAdmin(category : String, app : String) {
        _productMenuPO.goToAppAdmin(category, app)
    }
}