package com.stepDefinition;

import com.setup.BaseSteps;
import com.pages.HomePage;
import io.cucumber.java.en.*;
import static org.testng.Assert.assertTrue;

public class LaunchSteps extends BaseSteps {

    HomePage homePage;

    @Given("I open {string} browser")
    public void i_open_browser(String browser) {
        launchBrowser(browser); // Only Chrome allowed
        homePage = new HomePage(driver);
    }

    @When("I navigate to {string}")
    public void i_navigate_to(String url) {
        driver.get(url);
    }

    @Then("the homepage should load successfully")
    public void the_homepage_should_load_successfully() {
        assertTrue(homePage.isHomePageDisplayed(), "Homepage not loaded");
        quitBrowser();
    }
}
