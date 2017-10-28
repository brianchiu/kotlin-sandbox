package com.liferay.steps.foundation.signin

import cucumber.api.java.en.Then

import com.liferay.pages.base.HomePage
import com.liferay.pages.foundation.signin.SignInPage
import cucumber.api.java.en.Given

class SignInSteps {
    private val _homePage = HomePage()
    private val _signInPage = SignInPage()

    @Then(value = "^I should see the user avatar with the initials \"([^\"]*)\"")
    fun i_should_see_the_user_avatar_with_the_initials(initials : String) {
        _homePage.assertUserSignedIn(initials)
    }

    @Given(value = "^I sign in as the admin user")
    fun i_sign_in_as_the_admin_user() {
        _homePage.clickSignIn()

        _signInPage.fillInEmailAddress("test@liferay.com")
        _signInPage.fillInPassword("test")
        _signInPage.clickSignIn()

        _homePage.assertUserSignedIn("TT")
    }
}