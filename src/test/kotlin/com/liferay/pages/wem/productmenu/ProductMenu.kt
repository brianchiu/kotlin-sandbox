package com.liferay.pages.wem.productmenu

import com.liferay.pages.base.BasePage

class ProductMenu : BasePage() {
    private val productMenu = "//div[contains(@id,'addContentCollapse') and contains(@class,'show')]"
    private val toggle = "//*[@data-qa-id='productMenu']"

    private val controlPanelCollapse = "//div[contains(@id,'control_panelCollapse') and contains(@class,'show')]"
    private val siteAdministrationCollapse = "//div[contains(@id,'site_administrationCollapse') and contains(@class,'show')]"
    private val userCollapse = "//div[contains(@id,'userCollapse') and contains(@class,'show')]"


    fun clickApp(app : String) {
        clickLink(app)
    }

    fun clickGoToSite() {
        clickLink("Go to Site")
    }

    fun clickSignOut() {
        clickLink("Sign Out")
    }

    fun expandCategory(category : String) {
        val categoryExpanded = "//div[a[@aria-expanded='true']]/../..//a[@aria-expanded='true' and normalize-space()='$category']"

        if (!isVisible(categoryExpanded)) {
            clickLink(category)
        }

        assertVisible(categoryExpanded)
    }

    fun expandControlPanelCollapse() {
        if (!isVisible(controlPanelCollapse)) {
            clickLink("Control Panel")
        }

        assertVisible(controlPanelCollapse)
    }

    fun expandProductMenu() {
        if (!isVisible(productMenu)) {
            click(toggle)
        }

        assertVisible(productMenu)
    }

    fun expandSiteAdministrationCollapse() {
        if (!isVisible(siteAdministrationCollapse)) {
            click("//a[@id='productMenuSiteAdministrationPanelCategory']")
        }
    }

    fun expandUserCollapse() {
        if (!isVisible(userCollapse)) {
            click("//a[@id='productMenuUserPanelCategory']")
        }
    }
}