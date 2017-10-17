package com.liferay.steps

import cucumber.api.java.en.When

import com.liferay.pages.WelcomePage
import com.liferay.pages.SignInPage

class PortalSmokeSteps : DriverFactory() {
    @When(value = "^I open a browser to \"(https?.+)\"$")
    fun open(url : String) {
        driver.get(url);
    }

    @When(value = "I sign in$")
    fun i_sign_in() {
        WelcomePage(driver).clickSignInLink()
        SignInPage(driver).signIn("test@liferay.com", "test")
    }
}