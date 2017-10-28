package com.liferay.pages.base

import com.liferay.poshi.runner.selenium.SeleniumUtil

import com.liferay.utils.LocatorUtil

open class BasePage {
    private val _locatorUtil = LocatorUtil()
    private val selenium = SeleniumUtil.getSelenium()

    fun assertLinkVisible(link : String) {
        assertVisible(_locatorUtil.getLink(link))
    }

    fun assertText(locator : String, value : String) {
        assertVisible(locator)
        selenium.waitForText(locator, value)
        selenium.assertText(locator, value)
    }

    fun assertVisible(locator : String) {
        selenium.waitForVisible(locator)
        selenium.assertVisible(locator)
    }

    fun check(locator : String) {
        assertVisible(locator)
        selenium.check(locator)
    }

    fun checkCheckBox(label : String) {
        check(_locatorUtil.getCheckBox(label))
    }

    fun click(locator : String) {
        assertVisible(locator)
        selenium.click(locator)
    }

    fun clickButton(button : String) {
        click(_locatorUtil.getButton(button))
    }

    fun clickLink(link : String) {
        click(_locatorUtil.getLink(link))
    }

    fun isElementPresent(locator : String) : Boolean {
        return selenium.isElementPresent(locator)
    }

    fun isVisible(locator : String) : Boolean {
        return selenium.isVisible(locator)
    }

    fun makeVisible(locator : String) {
        selenium.makeVisible(locator)
    }

    fun open(url : String) {
        selenium.open(url)
    }

    fun type(locator : String, value : String) {
        assertVisible(locator)
        selenium.type(locator, value)
    }

    fun typeInput(label : String, value : String) {
        type(_locatorUtil.getInput(label), value)
    }

    fun typeEditor(locator : String, value : String) {
        assertVisible(locator)
        selenium.typeEditor(locator, value)
    }
}