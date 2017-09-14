package com.liferay.wem.addpanel

import cucumber.api.java.en.When

class AddPanelSteps {
    private val _addPanelPO = AddPanelPO()

    @When(value = "^I add the \"([^\"]*)\" app$")
    fun addApp(app : String) {
        _addPanelPO.addApp(app)
    }
}