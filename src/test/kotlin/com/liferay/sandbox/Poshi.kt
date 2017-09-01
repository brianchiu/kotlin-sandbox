package com.liferay.sandbox;

import com.liferay.poshi.runner.selenium.SeleniumUtil

import cucumber.api.java.en.When

import java.lang.String

class Poshi {
    val selenium = SeleniumUtil.getSelenium()

    @When(value = "^I use poshi$")
    fun poshiTest() {
        selenium.open("http://www.liferay.com")
        selenium.click("//a[@id='menuToggle']")
        selenium.waitForVisible("//input[@class='doc-search-input']")
        selenium.type("//input[@class='doc-search-input']", "Liferay DXP Tech Specs")
        selenium.click("//a[@class='submit-search']")
    }
}