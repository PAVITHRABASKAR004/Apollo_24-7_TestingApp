package stepdefinitions;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.pages.AddTestPage;
import com.setup.Base;
import io.cucumber.java.en.*;
import org.testng.Assert;
import org.openqa.selenium.WebDriver;

public class AddTestStep extends Base {

    WebDriver driver = Hooks.driver;
    ExtentTest extTest = Hooks.extTest;
    AddTestPage addTestPage = new AddTestPage(driver);

    // ------------------------
    // Scenario: Scroll down and click Add Test
    // ------------------------
    @When("the user scrolls down to the {string} button")
    public void the_user_scrolls_down_to_the_button(String buttonName) {
        if (buttonName.equalsIgnoreCase("Add Test")) {
            addTestPage.scrollToElement(addTestPage.getAddTestsButton());
            extTest.log(Status.PASS, "Scrolled down to Add Test button");
        } else if (buttonName.equalsIgnoreCase("Go to Cart")) {
            addTestPage.scrollToElement(addTestPage.getGoToCartButton());
            extTest.log(Status.PASS, "Scrolled down to Go To Cart button");
        }
    }

    @When("the user clicks on the {string} button")
    public void the_user_clicks_on_the_button(String buttonName) {
        if (buttonName.equalsIgnoreCase("Add Test")) {
            addTestPage.clickAddTestsButton();
            extTest.log(Status.PASS, "Clicked on Add Test button");
        } else if (buttonName.equalsIgnoreCase("Go to Cart")) {
            addTestPage.clickGoToCart();
            extTest.log(Status.PASS, "Clicked on Go To Cart button");
        }
    }

    @Then("the Add Test section should be displayed")
    public void the_add_test_section_should_be_displayed() {
        Assert.assertTrue(addTestPage.isAddTestSectionDisplayed(), "Add Test section not visible!");
        extTest.log(Status.PASS, "Add Test section is displayed");
    }

    // ------------------------
    // Scenario: Select PCOD Screening under WomenCare
    // ------------------------
    @When("the user scrolls up to the WomenCare category")
    public void the_user_scrolls_up_to_the_women_care_category() {
        addTestPage.scrollToElement(addTestPage.getPCODScreeningTest());
        extTest.log(Status.PASS, "Scrolled to WomenCare category");
    }

    @When("the user selects {string} from WomenCare")
    public void the_user_selects_from_women_care(String testName) {
        if (testName.equalsIgnoreCase("PCOD Screening")) {
            addTestPage.selectPCODScreening();
            extTest.log(Status.PASS, "Selected PCOD Screening from WomenCare");
        }
    }

    @Then("the PCOD Screening details should be displayed")
    public void the_pcod_screening_details_should_be_displayed() {
        Assert.assertTrue(addTestPage.isPCODScreeningDisplayed(), "PCOD Screening details not displayed!");
        extTest.log(Status.PASS, "PCOD Screening details are displayed");
    }

    // ------------------------
    // Scenario: select test
    // ------------------------
    @Given("the user clicks first test from {string}")
    public void the_user_clicks_first_test_from(String string) {
        addTestPage.addFirstAvailableTest();
        extTest.log(Status.PASS, "Clicked the first test from " + string);
    }

    @When("the user selects the first available test")
    public void the_user_selects_the_first_available_test() {
        addTestPage.addFirstAvailableTest();
        extTest.log(Status.PASS, "Selected the first available test");
    }

    @Then("the selected test should be added to the cart")
    public void the_selected_test_should_be_added_to_the_cart() {
        Assert.assertTrue(addTestPage.isTestAddedToCart(), "Test not added to cart!");
        extTest.log(Status.PASS, "Selected test is added to the cart");
    }

    // ------------------------
    // Scenario: Navigate to cart after adding test
    // ------------------------
    @Then("the cart page should display the newly added test")
    public void the_cart_page_should_display_the_newly_added_test() {
        Assert.assertTrue(addTestPage.isTestAddedToCart(), "Cart does not show the added test!");
        extTest.log(Status.PASS, "Cart displays the newly added test");
    }
}
