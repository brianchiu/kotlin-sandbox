package com.liferay.pages.base

import com.liferay.poshi.runner.selenium.SeleniumUtil

open class BasePO {
    private val selenium = SeleniumUtil.getSelenium()

    fun assertText(locator : String, value : String) {
        assertVisible(locator)
        selenium.waitForText(locator, value)
        selenium.assertText(locator, value)
    }

    fun assertVisible(locator : String) {
        selenium.waitForVisible(locator)
        selenium.assertVisible(locator)
    }

    fun click(locator : String) {
        assertVisible(locator)
        selenium.click(locator)
    }

    fun clickButton(button : String) {
        click("//button[contains(.,'$button')]")
    }

    fun clickLink(link : String) {
        click("//a[contains(.,'$link')]")
    }

    fun isElementPresent(locator : String) {
        selenium.isElementPresent(locator)
    }

    fun open(url : String) {
        selenium.open(url)
    }

    fun type(locator : String, value : String) {
        assertVisible(locator)
        selenium.type(locator, value)
    }

    fun typeInput(label : String, value : String) {
        type("//div[label[contains(.,'$label')]]//input", value)
    }

    fun typeEditor(locator : String, value : String) {
        assertVisible(locator)
        selenium.typeEditor(locator, value)
    }
}