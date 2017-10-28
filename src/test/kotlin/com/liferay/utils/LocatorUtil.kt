package com.liferay.utils

class LocatorUtil {
    fun getButton(button : String) : String {
        return "//button[normalize-space()='$button']"
    }

    fun getCheckBox(label : String) : String {
        return "//label[contains(.,'$label')]/input[@type='checkbox']"
    }

    fun getInput(label : String) : String {
        return "//div[label[normalize-space()='$label' or normalize-space()='$label Required']]//input"
    }

    fun getLink(link : String) : String {
        return "//a[normalize-space()='$link']"
    }
}