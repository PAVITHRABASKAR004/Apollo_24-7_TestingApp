package stepdefinitions;

import org.openqa.selenium.WebDriver;

import com.aventstack.extentreports.ExtentTest;
import com.pages.LabTestsPage;
import com.setup.Base;        // import Base to access Base.driver
import stepdefinitions.Hooks;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class LabTestsStep {

    LabTestsPage labTestsPage;
    WebDriver driver;
    ExtentTest extTest;

    @Given("the user is logged in")
    public void the_user_is_logged_in() {
        // Get initialized driver from Base
        driver = Base.driver;
        if(driver == null) {
            throw new RuntimeException("WebDriver is not initialized. Did you launch the browser?");
        }

        // Get ExtentTest from Hooks
        extTest = Hooks.extTest;

        // Initialize LabTestsPage
        labTestsPage = new LabTestsPage(driver, extTest);

        // Optional: check login
        //labTestsPage.verifyUserLoggedIn();
    }

    @When("the user clicks on Lab Tests tab")
    public void the_user_clicks_on_lab_tests_tab() {
        labTestsPage.clickLabTestsTab();
    }

    @Then("the user should be navigated to the Lab Tests page")
    public void the_user_should_be_navigated_to_the_lab_tests_page() {
        //labTestsPage.verifyLabTestsPageOpened();
    }

    @When("the user selects {string} under Doctor Created Health Checks")
    public void the_user_selects_package(String packageName) {
        labTestsPage.selectFullBodyCheckup(); // can later parameterize
    }

    @When("the user selects the first test")
    public void the_user_selects_the_first_test() {
        labTestsPage.selectFirstTest();
    }

    @Then("the selected test should be displayed in the cart or selection area")
    public void the_selected_test_should_be_displayed_in_the_cart_or_selection_area() {
        labTestsPage.isTestInCart();
    }
}
