package com.liferay.wem.addpanel

import com.liferay.base.BasePO

class AddPanelPO : BasePO() {
    fun expandAddPanel() {
        val add = "//*[@data-qa-id='controlMenu']//*[@data-qa-id='add']"
        val addPanelExpanded = "//div[contains(@class,'lfr-add-panel') and contains(@class,'open-admin-panel')]"

        if (!isElementPresent(addPanelExpanded)) {
            click(add)
        }

        assertVisible(addPanelExpanded)
    }

    fun addApp(app : String) {
        val appAdd = "//span[contains(@data-search,'-$app') and contains(@class,'add-content-item')]"
        val appPortletTitle = "//section[@class='portlet']//h2[normalize-space()='$app']"
        val applicationsExpanded = "//div[contains(@id,'addApplicationCollapse') and contains(@class,'collapse in')]"
        val searchInput = "//div[contains(@class,'search-bar')]/input"

        expandAddPanel()

        if (!isElementPresent(applicationsExpanded)) {
            clickLink("Applications")
        }

        assertVisible(applicationsExpanded)
        type(searchInput, app)
        pause("1000")
        makeVisible(appAdd)
        click(appAdd)
        assertVisible(appPortletTitle)
    }
}