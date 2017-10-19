package com.liferay.utils

import com.liferay.pages.base.HomePage
import com.liferay.pages.foundation.signin.SignInPage
import com.liferay.pages.wem.productmenu.ProductMenu

class SignInUtil {
    val _homePage = HomePage()
    val _productMenu = ProductMenu()
    val _signInPage = SignInPage()

    fun signIn(email : String, password : String) {
        _homePage.clickSignIn()
        _signInPage.fillInEmailAddress(email)
        _signInPage.fillInPassword(password)
        _signInPage.clickSignIn()
        _homePage.assertUserSignedIn()
    }

    fun signOut() {
        _homePage.openUserMenu()
        _productMenu.clickSignOut()
    }
}