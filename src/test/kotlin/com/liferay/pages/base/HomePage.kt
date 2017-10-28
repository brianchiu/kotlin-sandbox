package com.liferay.pages.base

import com.liferay.pages.base.BasePage

class HomePage : BasePage() {
    private val siteLogo = "//a[contains(@class,'default-logo')]"
    private val userAvatar = "//*[@data-qa-id='openUserMenu']"

    fun assertUserSignedIn() {
        assertVisible(userAvatar)
    }

    fun assertUserSignedIn(initials : String) {
        assertVisible("//span[@class='user-avatar-image']//span[.='$initials']")
    }

    fun assertUserSignedOut() {
        assertLinkVisible("Sign In")
    }

    fun clickSiteLogo() {
        click(siteLogo)
    }

    fun clickSignIn() {
        clickLink("Sign In")
    }

    fun navigateToPage(page : String) {
        clickLink(page)
    }

    fun openUserMenu() {
        click(userAvatar)
    }
}