package com.liferay.sandbox

import org.openqa.selenium.WebDriver
import org.openqa.selenium.firefox.FirefoxDriver

object FirefoxInstance {
    val webDriver : WebDriver = FirefoxDriver()

    fun hashi() : WebDriver {
        return webDriver
    }
}