package com.liferay.pages

import org.openqa.selenium.WebDriver
import org.openqa.selenium.WebElement
import org.openqa.selenium.support.FindBy
import org.openqa.selenium.support.PageFactory

class WelcomePage(private val driver : WebDriver) {
    @FindBy(xpath = "//a[contains(.,'Sign In')]")
    private val signInLink : WebElement? = null

    init {
        PageFactory.initElements(driver, this)
    }

    fun clickSignInLink() {
        signInLink?.click()
    }
}