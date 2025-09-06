package com.runner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
        features = "src/test/resources/Features",
        glue = {"com.stepDefinition"},
        plugin = {
                "pretty",
                "html:target/CucumberReport.html",
                "json:target/CucumberReport.json"
        },
        monochrome = true
)
public class TestRunnerTestNG extends AbstractTestNGCucumberTests {
}
