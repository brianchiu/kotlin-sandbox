package com.liferay.steps.sandbox.sample;

import cucumber.api.java.en.When;
import cucumber.api.java.en.Then;
import org.junit.Assert;

class AdditionSteps {
    private var result: Int? = null

    @When(value = "^I add \"(\\d+)\" and \"(\\d+)\"$")
    fun add(a: Int, b: Int) {
        result = a + b
    }

    @Then(value = "^I get \"(\\d+)\"$")
    fun total(t: Int) {
        Assert.assertEquals(t, result)
        println("ALSKFJASLKFDJSAA")
    }

}