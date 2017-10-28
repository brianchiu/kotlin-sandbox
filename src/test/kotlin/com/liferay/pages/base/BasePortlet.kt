package com.liferay.pages.base

class BasePortlet : BasePage() {
    private val portletBody = "//*[@data-qa-id='app-loaded']"
    private val portletTitle = "//span[@class='portlet-name-text']"

    fun assertPortletPresent(portlet : String) {
        assertVisible(portletBody)
        assertText(portletTitle, portlet)
    }
}