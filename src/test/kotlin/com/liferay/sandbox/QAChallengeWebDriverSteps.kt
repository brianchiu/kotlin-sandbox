package com.liferay.sandbox

import cucumber.api.java.en.When

class QAChallengeWebDriverSteps {
    val _qaChallengeWebDriverPageObject = QAChallengeWebDriverPageObject()

    @When(value = "^I do the QA challenge using WebDriver$")
    fun doQAChallengeStepsWithWebDriver() {
        _qaChallengeWebDriverPageObject.doQAChallengeStepsWithWebDriver()
    }
}