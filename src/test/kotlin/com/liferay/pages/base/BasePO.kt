package com.liferay.pages.base;

import com.liferay.poshi.runner.selenium.SeleniumUtil

open class BasePO {
    private val selenium = SeleniumUtil.getSelenium()

    fun assertEditorContentText(value : String) {
        val locator = "//div[(contains(@id,'body') or contains(@id,'content')) and contains(@class,'alloy-editor-container')]//div[contains(@class,'alloy-editor-placeholder')]"

        assertText(locator, value)
    }

    fun assertLinkVisible(link : String) {
        val locator = "//a[normalize-space()='$link']"

        assertVisible(locator)
    }

    fun assertText(locator : String, value : String) {
        waitForVisible(locator)
        selenium.waitForText(locator, value)
        selenium.assertText(locator, value)
    }

    fun assertInputValue(label : String, value : String) {
        val locator = "//div[label[normalize-space()='$label' or normalize-space()='$label Required']]//input"

        assertValue(locator, value)
    }

    fun assertValue(locator: String, value : String) {
        waitForVisible(locator)
        selenium.assertValue(locator, value)
    }

    fun assertVisible(locator : String) {
        waitForVisible(locator)
        selenium.assertVisible(locator)
    }

    fun click(locator : String) {
        waitForVisible(locator)
        selenium.click(locator)
    }

    fun clickButton(button : String) {
        val locator = "//button[normalize-space()='$button']"

        click(locator)
    }

    fun clickLink(link : String) {
        val locator = "//a[normalize-space()='$link']"

        click(locator)
    }

    fun clickText(text : String) {
        val locator = "//*[normalize-space()='$text']"

        click(locator)
    }

    fun isButtonPresent(button : String) : Boolean {
        val locator = "//button[normalize-space()='$button']"

        return selenium.isElementNotPresent(locator)
    }

    fun isElementPresent(locator : String) : Boolean {
        return selenium.isElementPresent(locator)
    }

    fun isLinkPresent(link : String) : Boolean {
        val locator = "//a[normalize-space()='$link']"

        return selenium.isElementPresent(locator)
    }

    fun isVisible(locator : String) : Boolean {
        return selenium.isVisible(locator)
    }

    fun makeVisible(locator : String) {
        waitForElementPresent(locator)
        selenium.makeVisible(locator)
    }

    fun mouseOver(locator : String) {
        selenium.mouseOver(locator)
    }

    fun open(url : String) {
        selenium.open(url)
    }

    fun pause(milliseconds : String) {
        selenium.pause(milliseconds)
    }

    fun type(locator : String, value : String) {
        waitForVisible(locator)
        selenium.type(locator, value)
    }

    fun typeInput(label : String, value : String) {
        val locator = "//div[label[normalize-space()='$label' or normalize-space()='$label Required']]//input"

        type(locator, value)
    }

    fun typeEditor(locator : String, value : String) {
        waitForVisible(locator)
        selenium.typeEditor(locator, value)
    }

    fun typeEditorContent(value : String) {
        val locator = "//div[(contains(@id,'body') or contains(@id,'content')) and contains(@class,'alloy-editor-container')]//div[contains(@class,'alloy-editor-placeholder')]"

        typeEditor(locator, value)
    }
    fun typeEditorTitle(value : String) {
        val locator = "//div[contains(@id,'titleEditor') and contains(@aria-label,'Rich Text Editor')]"

        typeEditor(locator, value)
    }

    fun waitForElementPresent(locator : String) {
        selenium.waitForElementPresent(locator)
    }

    fun waitForVisible(locator : String) {
        selenium.waitForVisible(locator)
    }
}