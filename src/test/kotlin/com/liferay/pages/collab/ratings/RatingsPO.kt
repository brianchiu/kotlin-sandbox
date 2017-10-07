package com.liferay.pages.collab.ratings

import com.liferay.pages.base.BasePO

class RatingsPO : BasePO() {
    private val thumbDownOffLocator = "//a[contains(@class,'thumbs-down') and contains(@class,'rating-off')]"
    private val thumbDownOnLocator = "//a[contains(@class,'thumbs-down') and contains(@class,'rating-on')]"
    private val thumbUpOffLocator = "//a[contains(@class,'thumbs-up') and contains(@class,'rating-off')]"
    private val thumbUpOnLocator = "//a[contains(@class,'thumbs-up') and contains(@class,'rating-on')]"

    fun rateAsBad() {
        click(thumbDownOffLocator)
        assertVisible(thumbDownOnLocator)
    }

    fun rateAsGood() {
        click(thumbUpOffLocator)
        assertVisible(thumbUpOnLocator)
    }

    fun unRateAsBad() {
        click(thumbDownOnLocator)
        assertVisible(thumbDownOffLocator)
    }

    fun unRateAsGood() {
        click(thumbUpOnLocator)
        assertVisible(thumbUpOffLocator)
    }

    fun viewRateAsBad() {
        assertVisible(thumbDownOnLocator)
    }

    fun viewRateAsBadCount(expectedCount : String) {
        val thumbDownLocator = "//a[contains(@class,'thumbs-down')] | //span[contains(@class,'thumbs-down')]"

        assertText(thumbDownLocator, expectedCount)
    }

    fun viewRateAsGood() {
        assertVisible(thumbUpOnLocator)
    }

    fun viewRateAsGoodCount(expectedCount : String) {
        val thumbUpLocator = "//a[contains(@class,'thumbs-up')] | //span[contains(@class,'thumbs-up')]"

        assertText(thumbUpLocator, expectedCount)
    }
}