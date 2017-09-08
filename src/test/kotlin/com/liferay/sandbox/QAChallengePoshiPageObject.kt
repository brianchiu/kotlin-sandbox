package com.liferay.sandbox;

import com.liferay.poshi.runner.selenium.SeleniumUtil

class QAChallengePoshiPageObject {
    val selenium = SeleniumUtil.getSelenium()

    fun doQAChallengeStepsWithPoshi() {
        selenium.open("http://www.liferay.com")
        selenium.click("//a[@id='menuToggle']")
        selenium.waitForVisible("//input[@class='doc-search-input']")
        selenium.type("//input[@class='doc-search-input']", "Liferay DXP Tech Specs")
        selenium.click("//a[@class='submit-search']")
    }
}