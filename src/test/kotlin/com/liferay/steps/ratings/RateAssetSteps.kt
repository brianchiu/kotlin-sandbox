package com.liferay.steps.ratings

import com.liferay.pages.base.BasePO
import com.liferay.pages.collab.blogs.BlogsPO
import com.liferay.pages.collab.ratings.RatingsPO
import com.liferay.pages.wem.addpanel.AddPanelPO
import com.liferay.pages.wem.productmenu.ProductMenuPO
import cucumber.api.java.After
import cucumber.api.java.Before

import cucumber.api.java.en.Then
import cucumber.api.java.en.When

class RateAssetSteps {
    @When(value = "^I add a blogs entry$")
    fun i_add_a_blogs_entry() {
        val _blogsPO = BlogsPO()

        _blogsPO.addEntry("Blogs Entry Title", "Blogs Entry Content")
    }

    @When(value = "^I add a page$")
    fun i_add_a_page() {
        val _productMenuPO = ProductMenuPO()

        _productMenuPO.addPage("Ratings Test Page")
    }

    @When(value = "^I add the \"([^\"]*)\" app$")
    fun i_add_the_app(app : String) {
        val _addPanelPO = AddPanelPO()

        _addPanelPO.addApp(app)
    }

    @When(value = "^I navigate to the blogs entry$")
    fun i_navigate_to_the_blogs_entry() {
        val _basePO = BasePO()
        val _blogsPO = BlogsPO()

        _basePO.clickLink("Welcome")
        _basePO.clickLink("Ratings Test Page")
        _blogsPO.gotoEntry("Blogs Entry Title")
    }

    @When(value = "^I navigate to the page named \"([^\"]*)\"$")
    fun i_navigate_to_the_page_named(pageName : String) {
        val _basePO = BasePO()

        _basePO.clickLink(pageName)
    }

    @When(value = "^I rate the entry as bad$")
    fun i_rate_the_entry_as_bad() {
        val _ratingsPO = RatingsPO()

        _ratingsPO.rateAsBad()
    }

    @When(value = "^I rate the entry as good$")
    fun i_rate_the_entry_as_good() {
        val _ratingsPO = RatingsPO()

        _ratingsPO.rateAsGood()
    }

    @When(value = "^I unrate the entry as bad$")
    fun i_unrate_the_entry_as_bad() {
        val _ratingsPO = RatingsPO()

        _ratingsPO.unrateAsBad()
    }

    @When(value = "^I unrate the entry as good$")
    fun i_unrate_the_entry_as_good() {
        val _ratingsPO = RatingsPO()

        _ratingsPO.unrateAsGood()
    }

    @Then(value = "^I should see the thumbs down clicked")
    fun i_should_see_the_thumbs_down_activated() {
        val _ratingsPO = RatingsPO()

        _ratingsPO.viewRateAsBad()
    }

    @Then(value = "^I should see the thumbs down not clicked")
    fun i_should_see_the_thumbs_down_deactivated() {
        val _ratingsPO = RatingsPO()

        _ratingsPO.viewUnrateAsBad()
    }

    @Then(value = "^I should see the thumbs up clicked")
    fun i_should_see_the_thumbs_up_activated() {
        val _ratingsPO = RatingsPO()

        _ratingsPO.viewRateAsGood()
    }

    @Then(value = "^I should see the thumbs up not clicked")
    fun i_should_see_the_thumbs_up_deactivated() {
        val _ratingsPO = RatingsPO()

        _ratingsPO.viewUnrateAsGood()
    }

    @Then(value = "^I should see the thumbs down count display \"([^\"]*)\"$")
    fun i_should_see_the_thumbs_down_count_display(count : String) {
        val _ratingsPO = RatingsPO()

        _ratingsPO.viewRateAsBadCount(count)
    }

    @Then(value = "^I should see the thumbs up count display \"([^\"]*)\"$")
    fun i_should_see_the_thumbs_up_count_display(count : String) {
        val _ratingsPO = RatingsPO()

        _ratingsPO.viewRateAsGoodCount(count)
    }
//
//    @After
//    fun tearDown() {
//        println("Tear Down Now")
//    }
//
//    @Before
//    fun setup() {
//        println("Setup Now")
//    }
}