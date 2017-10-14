package com.liferay.pages

import org.openqa.selenium.WebDriver
import org.openqa.selenium.WebElement
import org.openqa.selenium.support.FindBy
import org.openqa.selenium.support.PageFactory

class SignInPage(private val driver: WebDriver) {
    @FindBy(id = "_com_liferay_login_web_portlet_LoginPortlet_login")
    private val emailField : WebElement? = null

    @FindBy(id = "_com_liferay_login_web_portlet_LoginPortlet_password")
    private val passwordField : WebElement? = null

    @FindBy(id = "_com_liferay_login_web_portlet_LoginPortlet_rememberMe")
    private val rememberMeCheckBox : WebElement? = null

    @FindBy(xpath = "//button[contains(.,'Sign In')]")
    private val signInButton : WebElement? = null

    init {
        PageFactory.initElements(driver, this)
    }

    fun checkRememberMeCheckBox() {
        rememberMeCheckBox.click()
    }

    fun clickSignInButton() {
        signInButton.click()
    }

    fun fillInEmailField(email : String) {
        emailField.clear()
        emailField.sendKeys(email)
    }

    fun fillInPasswordField(password : String) {
        passwordField.clear()
        passwordField.sendKeys(password)
    }

    fun signIn(email : String, password : String) {
        fillInEmailField(email)
        fillInPasswordField(password)
        clickSignInButton()
    }
}