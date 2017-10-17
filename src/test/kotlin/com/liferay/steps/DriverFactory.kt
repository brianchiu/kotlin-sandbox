package com.liferay.steps

import java.util.concurrent.TimeUnit

import org.openqa.selenium.WebDriver
import org.openqa.selenium.firefox.FirefoxDriver

open class DriverFactory {
    companion object {
        val driver: WebDriver = FirefoxDriver()

        init {
            driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS)
        }
    }
}