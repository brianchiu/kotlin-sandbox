package com.liferay.sandbox;

import cucumber.api.java.en.When
import cucumber.api.java.en.Then

import java.util.concurrent.TimeUnit

import org.openqa.selenium.By
import org.openqa.selenium.JavascriptExecutor
import org.openqa.selenium.WebDriver
import org.openqa.selenium.WebElement
import org.openqa.selenium.firefox.FirefoxDriver

import org.junit.Assert
import org.openqa.selenium.internal.WrapsDriver

class WebDriverSteps {
	val webdriver = getWebDriver()

	@When(value = "^I click the \"([^\"]*)\" button$")
	fun clickButton(button : String) {
		val locator = "//button[contains(.,'$button')]"

		click(locator)
	}

	@When(value = "^I click the \"([^\"]*)\" link$")
	fun clickLink(link : String) {
		val locator = "//a[contains(.,'$link')]"

		click(locator)
	}

	@Then(value = "^I close the browser$")
	fun closeWebDriver() {
		webdriver.quit()
	}

	@When(value = "^I open a browser to \"(https?.+)\"$")
	fun open(url : String) {
		webdriver.get(url)
	}

	@When(value = "^I enter \"([^\"]*)\" in the \"([^\"]*)\" field$")
	fun typeInput(text: String, field: String) {
		val locator = "//div[label[contains(.,'$field')]]//input"

		type(locator, text)
	}

	@When(value = "^I login with email \"([^\"]*)\" and password \"([^\"]*)\"$")
	fun login(email : String, password : String) {
		open("http://localhost:8080")
		clickLink("Sign In")
		typeInput(email, "Email Address")
		typeInput(password, "Password")
		clickButton("Sign In")
		assertVisible("//*[@data-qa-id='openUserMenu'] | " +
				"//span[@class='user-avatar-image']")
	}

	@When(value = "^I can see the user avatar image$")
	fun assertLogin() {
		val userAvatar = "//*[@data-qa-id='openUserMenu'] | " +
				"//span[@class='user-avatar-image']"

		assertVisible(userAvatar)
	}

	// Product Menu Commands

	fun expandProductMenu() {
		val productMenuOpened = "//div[contains(@id,'sidenavSliderId') and " +
				"not(contains(@class,'closed')) and not(contains(@class," +
				"'transition'))]"
		val toggle = "//*[@data-qa-id='productMenu']"

		if (!isVisible(productMenuOpened)) {
			click(toggle)
		}

		assertVisible(productMenuOpened)
	}

	fun expandCategory(category : String) {
		val categoryCollapsed = "//div[a[@aria-expanded='true']]/../." +
				".//a[@aria-expanded='false' and contains(.,'$category')]"
		val categoryExpanded = "//div[a[@aria-expanded='true']]/../." +
				".//a[@aria-expanded='true' and contains(.,'$category')]"

		if (!isVisible(categoryExpanded)) {
			click(categoryCollapsed)
		}

		assertVisible(categoryExpanded)
	}

	@When(value = "^I navigate to \"([^\"]*)\" > \"([^\"]*)\" in the Product Menu$")
	fun gotoSitePortlet(category : String, portlet : String) {
		val portletLocator = "//div[a[@aria-expanded='true']]//a[contains" +
				"(@id,'Portlet') and @data-title='$portlet']"

		expandProductMenu()
		expandCategory(category)
		click(portletLocator)

		val headerTitle = "//*[@data-qa-id='headerTitle']"

		//assertText(headerTitle, portlet)
	}

	// Page Commands

	@When("^I add a page named \"([^\"]*)\"$")
	fun addPage(pageName : String) {
		expandProductMenu()
		expandCategory("Navigation")

		val publicPageEllipsisLocator = "//*[@data-qa-id='publicPagesOptions']"

		click(publicPageEllipsisLocator)
		clickLink("Add Public Page")
		typeInput(pageName, "Name")
		clickButton("Add Page")
		assertVisible("//a[contains(.,'$pageName')]")
	}

	// Web Content Commands

	@When("^I add a web content with title \"([^\"]*)\" in the Admin Portlet$")
	fun addWebContentInAdminPortlet(title : String) {
		val addButton = "//*[@data-qa-id='addButton']"

		click(addButton)
		clickLink("Basic Web Content")
		typeInput(title, "Title")
		clickButton("Publish")
	}

	// Base Commands

	fun assertText(locator : String, value : String) {
		val webElement = getWebElement(locator)
		val actualText = webElement.text

		Assert.assertEquals(value, actualText)
	}

	fun assertVisible(locator : String) {
		val webElement = getWebElement(locator)
		Assert.assertEquals(true, webElement.isDisplayed())
	}

	fun isVisible(locator : String) : Boolean {
		val webElements : List<WebElement> = getWebElements(locator)
		if (webElements.isEmpty()) {
			return false
		}
		else {
			return webElements[0].isDisplayed()
		}
	}

	fun click(locator : String) {
		val webElement = getWebElement(locator)
		webElement.click()
	}

	fun getWebElement(locator : String) : WebElement {
		val webElements : List<WebElement> = getWebElements(locator)
		return webElements[0]
	}

	fun getWebElements(locator : String) : List<WebElement> {
		webdriver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS)
		return webdriver.findElements(By.xpath(locator))
	}

	fun type(locator : String, value : String) {
		val webElement = getWebElement(locator)
		webElement.clear();
		webElement.sendKeys(value)
	}
}

fun getWebDriver() : WebDriver {
	return FirefoxDriver()
}