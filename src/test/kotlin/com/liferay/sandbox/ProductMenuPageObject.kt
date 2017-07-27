package com.liferay.sandbox

import cucumber.api.java.en.When

class ProductMenuPageObject : BasePageObject() {
    fun expandProductMenu() {
        val productMenuOpened = "//div[contains(@id,'sidenavSliderId') and " +
                "not(contains(@class,'closed')) and not(contains(@class," +
                "'transition'))]"
        val toggle = "//*[@data-qa-id='productMenu']"

        if (!isVisible(productMenuOpened)) {
            click(toggle)
        }

        assertVisible(productMenuOpened)
    }

    fun expandCategory(category : String) {
        val categoryCollapsed = "//div[a[@aria-expanded='true']]/../." +
                ".//a[@aria-expanded='false' and contains(.,'$category')]"
        val categoryExpanded = "//div[a[@aria-expanded='true']]/../." +
                ".//a[@aria-expanded='true' and contains(.,'$category')]"

        if (!isVisible(categoryExpanded)) {
            click(categoryCollapsed)
        }

        assertVisible(categoryExpanded)
    }

    fun gotoSitePortlet(category : String, portlet : String) {
        val portletLocator = "//div[a[@aria-expanded='true']]//a[contains" +
                "(@id,'Portlet') and @data-title='$portlet']"

        expandProductMenu()
        expandCategory(category)
        click(portletLocator)

        val headerTitle = "//*[@data-qa-id='headerTitle']"

        //assertText(headerTitle, portlet)
    }
}