package com.liferay.sandbox

import cucumber.api.java.en.When

class ProductMenuSteps {
    val _productMenuPageObject = ProductMenuPageObject()

    @When(value = "^I navigate to \"([^\"]*)\" > \"([^\"]*)\" in the Product Menu$")
    fun gotoSitePortlet(category : String, portlet : String) {
        _productMenuPageObject.gotoSitePortlet(category, portlet)
    }
}