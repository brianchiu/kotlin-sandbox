package com.liferay.sandbox

import cucumber.api.java.en.When

class LoginSteps {
    val _loginPageObject = LoginPageObject()

    @When(value = "^I can see the user avatar image$")
    fun assertLogin() {
        _loginPageObject.assertLogin()
    }

    @When(value = "^I login with email \"([^\"]*)\" and password \"([^\"]*)\"$")
    fun login(email : String, password : String) {
        _loginPageObject.login(email, password)
    }
}