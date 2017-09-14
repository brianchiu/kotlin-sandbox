package com.liferay.sandbox;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

import org.junit.runner.RunWith;

@CucumberOptions(
	features = arrayOf("src/test/resources/features"),
	glue = arrayOf("com.liferay.sandbox"),
	format = arrayOf("pretty", "html:build/cucumber-report/")
)
@RunWith(Cucumber::class)
class CucumberTest {
}