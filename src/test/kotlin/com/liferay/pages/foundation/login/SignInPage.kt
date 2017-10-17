package com.liferay.pages.foundation.login

import com.liferay.pages.base.BasePage

class SignInPage : BasePage() {
    fun checkRememberMe() {
        checkCheckBox("Remember Me")
    }

    fun clickCreateAccount() {
        clickLink("Create Account")
    }

    fun clickForgotPassword() {
        clickLink("Forgot Password")
    }

    fun clickSignIn() {
        clickButton("Sign In")
    }

    fun fillInEmailAddress(emailAddress : String) {
        typeInput("Email Address", emailAddress)
    }

    fun fillInPassword(password : String) {
        typeInput("Password", password)
    }
}