package com.liferay.sandbox

import cucumber.api.java.en.When

class QAChallengePoshiSteps {
    val _qaChallengePoshiPageObject = QAChallengePoshiPageObject()

    @When(value = "^I do the QA challenge using Poshi$")
    fun doQAChallengeStepsWithPoshi() {
        _qaChallengePoshiPageObject.doQAChallengeStepsWithPoshi()
    }
}