package com.liferay.pages.foundation.login

import com.liferay.pages.base.BasePO

class LoginPO : BasePO() {
    fun login(email : String, password : String) {
        val userAvatar = "//*[@data-qa-id='openUserMenu'] | //span[@class='user-avatar-image']"

        open("http://localhost:8080")
        clickLink("Sign In")
        typeInput("Email Address", email)
        typeInput("Password", password)
        clickButton("Sign In")
        assertVisible(userAvatar)
    }
}