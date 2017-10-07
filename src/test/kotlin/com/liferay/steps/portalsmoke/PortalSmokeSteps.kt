package com.liferay.steps.portalsmoke

import com.liferay.pages.foundation.login.LoginPO
import com.liferay.pages.wem.addpanel.AddPanelPO
import com.liferay.pages.wem.productmenu.ProductMenuPO
import com.liferay.pages.wem.webcontent.WebContentPO

import cucumber.api.java.en.Given
import cucumber.api.java.en.Then
import cucumber.api.java.en.When

class PortalSmokeSteps {
    @Then(value = "^I should be able to add apps$")
    fun addApps() {
        val _addPanelPO = AddPanelPO()

        _addPanelPO.addApp("Blogs")
        _addPanelPO.addApp("Web Content Display")
        _addPanelPO.addApp("Documents and Media")
    }

    @When(value = "^I add web content$")
    fun addContent() {
        val _productMenuPO = ProductMenuPO()
        val _webContentPO = WebContentPO()

        _productMenuPO.goToAppAdmin("Content", "Web Content")
        _webContentPO.add("Web Content Title", "Web Content Content")
    }

    @Then(value = "^I should be able to add pages$")
    fun addPages() {
        val _productMenuPO = ProductMenuPO()

        _productMenuPO.addPage("Test Page 1")
        _productMenuPO.addPage("Test Page 2")
        _productMenuPO.addPage("Test Page 3")
    }

    @Then(value = "^I should be able to see the web content$")
    fun viewContent() {
        val _webContentPO = WebContentPO()

        _webContentPO.view("Web Content Title", "Web Content Content")
    }

    @Given(value = "^I am logged in as the admin user$")
    fun login() {
        val _loginPO = LoginPO()

        _loginPO.login("test@liferay.com", "test")
    }
}