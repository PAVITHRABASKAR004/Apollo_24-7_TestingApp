package com.runner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
@CucumberOptions(
	    features = "src/test/resources/features",
	    glue = "stepdefinitions",
	    plugin = {"pretty","html:reports/Cucumber-html-report.html"},
	    tags = "not @Ignore"
	)
	public class TestRunner extends AbstractTestNGCucumberTests {
	}


