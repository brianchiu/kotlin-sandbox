package com.liferay.pages.base

import com.liferay.poshi.runner.selenium.SeleniumUtil

open class BasePage {
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

    fun check(locator : String) {
        assertVisible(locator)
        selenium.check(locator)
    }

    fun checkCheckBox(label : String) {
        check("//label[contains(.,'$label')]/input[@type='checkbox']")
    }

    fun click(locator : String) {
        assertVisible(locator)
        selenium.click(locator)
    }

    fun clickButton(button : String) {
        click("//button[normalize-space()='$button']")
    }

    fun clickLink(link : String) {
        click("//a[normalize-space()='$link']")
    }

    fun isElementPresent(locator : String) : Boolean {
        return selenium.isElementPresent(locator)
    }

    fun isVisible(locator : String) : Boolean {
        return selenium.isVisible(locator)
    }

    fun open(url : String) {
        selenium.open(url)
    }

    fun type(locator : String, value : String) {
        assertVisible(locator)
        selenium.type(locator, value)
    }

    fun typeInput(label : String, value : String) {
        type("//div[label[normalize-space()='$label' or normalize-space()='$label Required']]//input", value)
    }

    fun typeEditor(locator : String, value : String) {
        assertVisible(locator)
        selenium.typeEditor(locator, value)
    }
}