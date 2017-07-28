package com.liferay.sandbox

class LoginPageObject : BasePageObject() {
    fun assertLogin() {
        val userAvatar = "//*[@data-qa-id='openUserMenu'] | " +
                "//span[@class='user-avatar-image']"

        assertVisible(userAvatar)
    }

    fun login(email : String, password : String) {
        open("http://localhost:8080")
        clickLink("Sign In")
        typeInput(email, "Email Address")
        typeInput(password, "Password")
        clickButton("Sign In")
        assertVisible("//*[@data-qa-id='openUserMenu'] | " +
                "//span[@class='user-avatar-image']")
    }
}