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

	@When(value = "^I login with email \"([^\"]*)\" and password \"([^\"]*)\"$")
	fun login(email : String, password : String) {
		_basePageObject.open("http://localhost:8080")
		clickLink("Sign In")
		typeInput(email, "Email Address")
		typeInput(password, "Password")
		clickButton("Sign In")
		_basePageObject.assertVisible("//*[@data-qa-id='openUserMenu'] | " +
				"//span[@class='user-avatar-image']")
	}

	@When(value = "^I can see the user avatar image$")
	fun assertLogin() {
		val userAvatar = "//*[@data-qa-id='openUserMenu'] | " +
				"//span[@class='user-avatar-image']"

		_basePageObject.assertVisible(userAvatar)
	}

	// Product Menu Commands

//	fun expandProductMenu() {
//		val productMenuOpened = "//div[contains(@id,'sidenavSliderId') and " +
//				"not(contains(@class,'closed')) and not(contains(@class," +
//				"'transition'))]"
//		val toggle = "//*[@data-qa-id='productMenu']"
//
//		if (!isVisible(productMenuOpened)) {
//			click(toggle)
//		}
//
//		assertVisible(productMenuOpened)
//	}
//
//	fun expandCategory(category : String) {
//		val categoryCollapsed = "//div[a[@aria-expanded='true']]/../." +
//				".//a[@aria-expanded='false' and contains(.,'$category')]"
//		val categoryExpanded = "//div[a[@aria-expanded='true']]/../." +
//				".//a[@aria-expanded='true' and contains(.,'$category')]"
//
//		if (!isVisible(categoryExpanded)) {
//			click(categoryCollapsed)
//		}
//
//		assertVisible(categoryExpanded)
//	}
//
//	@When(value = "^I navigate to \"([^\"]*)\" > \"([^\"]*)\" in the Product Menu$")
//	fun gotoSitePortlet(category : String, portlet : String) {
//		val portletLocator = "//div[a[@aria-expanded='true']]//a[contains" +
//				"(@id,'Portlet') and @data-title='$portlet']"
//
//		expandProductMenu()
//		expandCategory(category)
//		click(portletLocator)
//
//		val headerTitle = "//*[@data-qa-id='headerTitle']"
//
//		//assertText(headerTitle, portlet)
//	}

	// Page Commands

//	@When("^I add a page named \"([^\"]*)\"$")
//	fun addPage(pageName : String) {
//		expandProductMenu()
//		expandCategory("Navigation")
//
//		val publicPageEllipsisLocator = "//*[@data-qa-id='publicPagesOptions']"
//
//		click(publicPageEllipsisLocator)
//		clickLink("Add Public Page")
//		typeInput(pageName, "Name")
//		clickButton("Add Page")
//		assertVisible("//a[contains(.,'$pageName')]")
//	}

	// Web Content Commands

	@When("^I add a web content with title \"([^\"]*)\" in the Admin Portlet$")
	fun addWebContentInAdminPortlet(title : String) {
		val addButton = "//*[@data-qa-id='addButton']"

		_basePageObject.click(addButton)
		clickLink("Basic Web Content")
		typeInput(title, "Title")
		clickButton("Publish")
	}
}