package com.liferay.sandbox

import cucumber.api.java.en.When

class LoginSteps {
    private val _loginPO = LoginPO()

    @When(value = "^I login with email address \"([^\"]*)\" and password \"([^\"]*)\"$")
    fun login(email : String, password : String) {
        _loginPO.login(email, password)
    }
}