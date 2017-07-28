package com.liferay.sandbox

import org.junit.Assert
import org.openqa.selenium.By
import org.openqa.selenium.WebElement
import java.util.concurrent.TimeUnit

open class BasePageObject {
    val webDriver = FirefoxInstance.hashi()

    fun assertText(locator : String, value : String) {
        val webElement = getWebElement(locator)
        val actualText = webElement.text

        Assert.assertEquals(value, actualText)
    }

    fun assertVisible(locator : String) {
        val webElement = getWebElement(locator)
        Assert.assertEquals(true, webElement.isDisplayed)
    }

    fun click(locator : String) {
        val webElement = getWebElement(locator)
        webElement.click()
    }

    fun clickButton(button : String) {
        val locator = "//button[contains(.,'$button')]"

        click(locator)
    }

    fun clickLink(link: String) {
        val locator = "//a[contains(.,'$link')]"

        click(locator)
    }

    fun getWebElement(locator : String) : WebElement {
        val webElements : List<WebElement> = getWebElements(locator)
        if (webElements.isEmpty()) {
            println("Unable to find : \"$locator\"")
        }
        return webElements[0]
    }

    fun getWebElements(locator : String) : List<WebElement> {
        webDriver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS)
        return webDriver.findElements(By.xpath(locator))
    }

    fun isVisible(locator : String) : Boolean {
        val webElements : List<WebElement> = getWebElements(locator)
        if (webElements.isEmpty()) {
            return false
        }
        else {
            return webElements[0].isDisplayed
        }
    }

    fun open(url : String) {
        webDriver.get(url)
    }

    fun quit() {
        webDriver.quit()
    }

    fun type(locator : String, value : String) {
        val webElement = getWebElement(locator)
        webElement.clear();
        webElement.sendKeys(value)
    }

    fun typeInput(field: String, text: String) {
        val locator = "//div[label[contains(.,'$field')]]//input"

        type(locator, text)
    }
}

