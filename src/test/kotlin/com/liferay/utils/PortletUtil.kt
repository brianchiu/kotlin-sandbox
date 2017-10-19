package com.liferay.utils

import com.liferay.pages.wem.addpanel.AddPanel

class PortletUtil {
    val _addPanel = AddPanel()

    fun addPortlet(portlet : String) {
        _addPanel.expandPanel()
        _addPanel.expandAddApplicationCollapse()
        _addPanel.searchApplication(portlet)
        _addPanel.clickAppAdd(portlet)
    }
}