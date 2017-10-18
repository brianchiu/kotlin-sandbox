package com.liferay.pages.wem.addpanel

import com.liferay.pages.base.BasePage

class AddPanel : BasePage() {
    private val addPanel = "//div[contains(@class,'lfr-add-panel') and contains(@class,'open-admin-panel')]"
    private val plusIcon = "//*[@data-qa-id='add']"

    private val addApplicationCollapse = "//div[contains(@id,'addApplicationCollapse') and contains(@class,'show')]"
    private val addApplicationSearchInput = "//div[contains(@id,'addApplicationCollapse')]//div[@class='input-group search-bar']"

    private val addContentCollapse = "//div[contains(@id,'addContentCollapse') and contains(@class,'show')]"
    private val addContentSearchInput = "//div[contains(@id,'addContentCollapse')]//div[@class='input-group search-bar']"

    fun clickAppAdd(app : String) {
        click("//span[contains(@data-search,'-$app') and contains(@class,'add-content-item')]")
    }

    fun expandPanel() {
        if (!isVisible(addPanel)) {
            click(plusIcon)
        }

        assertVisible(addPanel)
    }

    fun expandAddApplicationCollapse() {
        if (!isVisible(addApplicationCollapse)) {
            clickLink("Applications")
        }

        assertVisible(addApplicationCollapse)
    }

    fun expandAddContentCollapse() {
        if (!isVisible(addContentCollapse)) {
            clickLink("Content")
        }

        assertVisible(addContentCollapse)
    }

    fun expandAppCategory(category : String) {
        val categoryExpanded = "//a[contains(.,'$category') and @aria-expanded='true']"

        if (!isVisible(categoryExpanded)) {
            clickLink(category)
        }

        assertVisible(categoryExpanded)
    }

    fun searchApplication(app : String) {
        type(addApplicationSearchInput, app)
    }

    fun searchContent(content : String) {
        type(addContentSearchInput, content)
    }
}