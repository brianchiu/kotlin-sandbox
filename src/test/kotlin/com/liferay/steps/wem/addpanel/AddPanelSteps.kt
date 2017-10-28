package com.liferay.steps.wem.addpanel

import cucumber.api.java.en.Then
import cucumber.api.java.en.When

import com.liferay.pages.wem.addpanel.AddPanel
import com.liferay.pages.base.BasePortlet

class AddPanelSteps {
    private val _addPanel = AddPanel()
    private val _basePortlet = BasePortlet()

    @When(value = "^I add a \"([^\"]*)\" portlet")
    fun i_add_a_portlet(portlet : String) {
        _addPanel.expandPanel()
        _addPanel.expandAddApplicationCollapse()
        _addPanel.searchApplication(portlet)
        _addPanel.clickAppAdd(portlet)

        _basePortlet.assertPortletPresent(portlet)
    }
}