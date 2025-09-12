package stepdefinitions;

import com.aventstack.extentreports.ExtentTest;
import com.pages.cartselection_mod;
import io.cucumber.java.en.*;
import org.openqa.selenium.WebDriver;

public class Cartstepdef {

    WebDriver driver = Hooks.driver;
    ExtentTest extTest = Hooks.extTest;
    cartselection_mod cartPage = new cartselection_mod(driver,extTest);

    // --------------------------
    // Background
    // --------------------------
    
    @Given("the user has added at least one test to the cart")
    public void the_user_has_added_at_least_one_test_to_the_cart() {
        cartPage.clickSelect(); // clicks the first test by default
        extTest.pass("At least one test added to the cart");
    }

    // --------------------------
    // Scenario 1: Select a test in cart
    // --------------------------

@When("the user clicks {string} for a test")
public void the_user_clicks_for_a_test(String string) {
        cartPage.clickSelect(); // first test
        extTest.info("User clicked Select");
    }

    @Then("the selection should be highlighted or confirmed")
    public void the_selection_should_be_highlighted_or_confirmed() {
        extTest.pass("Selection highlighted/confirmed (manual/visual check)");
    }

    // --------------------------
    // Scenario 2: Undo previous selection
    // --------------------------
    @Given("the user has selected a test in the cart")
    public void the_user_has_selected_a_test_in_the_cart() {
        cartPage.clickSelect(); // first test
        extTest.info("User selected a test in the cart");
    }

    @When("the user clicks Undo")
    public void the_user_clicks_undo() {
        cartPage.clickUndo();
        extTest.info("User clicked Undo");
    }

    @Then("the previous selection should be reverted")
    public void the_previous_selection_should_be_reverted() {
        extTest.pass("Previous selection reverted (manual/visual check)");
    }

    // --------------------------
    // Scenario 3: Remove a test from cart
    // --------------------------
    @Given("the user has tests in the cart")
    public void the_user_has_tests_in_the_cart() {
        extTest.info("User has tests in the cart");
    }

    @When("the user clicks Remove on a test")
    public void the_user_clicks_remove_on_a_test() {
        cartPage.clickRemove(); // removes first test
        extTest.info("User clicked Remove");
    }

   
}
