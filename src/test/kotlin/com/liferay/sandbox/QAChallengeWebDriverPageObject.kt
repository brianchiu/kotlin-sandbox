package com.liferay.sandbox

class QAChallengeWebDriverPageObject : BasePageObject() {
    fun doQAChallengeStepsWithWebDriver() {
        open("http://www.liferay.com")
        click("//a[@id='menuToggle']")
        type("//input[@class='doc-search-input']", "Liferay DXP Tech Specs")
        click("//a[@class='submit-search']")
    }
}