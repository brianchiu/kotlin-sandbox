package com.liferay.steps.ratings

import com.liferay.pages.collab.blogs.BlogsPO
import cucumber.api.java.en.When

class ConfigureRatingsSteps {
    @When(value = "^I disable \"([^\"]*)\" in app configuration$")
    fun i_disable_in_app_configuration() {
        val _blogsPO = BlogsPO()

        _blogsPO.addEntry("Blogs Entry Title", "Blogs Entry Content")
    }
}