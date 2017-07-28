package com.liferay.sandbox

class PagePageObject : BasePageObject() {
    fun addPage(pageName : String) {
        val p = ProductMenuPageObject()
        p.expandProductMenu()
        p.expandCategory("Navigation")

        val publicPageEllipsisLocator = "//*[@data-qa-id='publicPagesOptions']"

        click(publicPageEllipsisLocator)
        clickLink("Add Public Page")
        typeInput("Name", pageName)
        clickButton("Add Page")
        open("http://localhost:8080")
        assertVisible("//a[contains(.,'$pageName')]")
    }
}