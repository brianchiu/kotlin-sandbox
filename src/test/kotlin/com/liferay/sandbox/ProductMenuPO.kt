package com.liferay.sandbox

class ProductMenuPO : BasePO() {
    fun addPage(page : String) {
        val publicPagesEllipsis = "//a[@data-qa-id='publicPagesOptions']"

        expandProductMenu()
        expandCategory("Navigation")
        click(publicPagesEllipsis)
        clickLink("Add Public Page")

        typeInput("Name", page)
        clickButton("Add Page")

        clickLink(page)
    }

    fun expandCategory(category : String) {
        val categoryCollapsed = "//div[a[@aria-expanded='true']]/../..//a[@aria-expanded='false' and normalize-space()='$category']"
        val categoryExpanded = "//div[a[@aria-expanded='true']]/../..//a[@aria-expanded='true' and normalize-space()='$category']"

        if (!isElementPresent(categoryExpanded)) {
            click(categoryCollapsed)
        }

        assertVisible(categoryExpanded)
    }

    fun expandProductMenu() {
        val productMenuExpanded = "//div[contains(@id,'sidenavSliderId') and not(contains(@class,'closed')) and not(contains(@class,'transition'))]"
        val toggle = "//*[@data-qa-id='productMenu']"

        if (!isElementPresent(productMenuExpanded)) {
            click(toggle)
        }

        assertVisible(productMenuExpanded)
    }

    fun goToAppAdmin(category : String, app : String) {
        val portletLocator = "//div[a[@aria-expanded='true']]//a[contains(@id,'Portlet') and @data-title='$app']"
        val headerTitle = "//*[@data-qa-id='headerTitle']"

        expandProductMenu()
        expandCategory(category)
        click(portletLocator)
        assertText(headerTitle, app)
    }
}