package stepdefinitions;

import com.aventstack.extentreports.ExtentTest;
import com.pages.CartPage;
import io.cucumber.java.en.*;
import org.testng.Assert;
import org.openqa.selenium.WebDriver;
import com.setup.Base;

public class CartCheckoutPatientStep extends Base {

    WebDriver driver = getDriver();
    ExtentTest extTest = Hooks.extTest;   // ✅ get ExtentTest from Hooks
    CartPage cartPage = new CartPage(driver, extTest); // ✅ updated

    @When("the user clicks {string}")
    public void the_user_clicks_button(String buttonName) {
        if (buttonName.equalsIgnoreCase("Proceed to Cart")) {
            cartPage.clickProceedToCart();
            extTest.info("Clicked Proceed to Cart button");
        } else if (buttonName.equalsIgnoreCase("Continue")) {
            cartPage.clickContinue();
            extTest.info("Clicked Continue button");
        }
    }

    @Then("the cart page should be displayed")
    public void the_cart_page_should_be_displayed() {
        Assert.assertTrue(cartPage.isCartPageDisplayed(), "Cart page not displayed!");
        extTest.pass("Cart page is displayed successfully");
    }

    @Given("the user is on the cart page")
    public void the_user_is_on_the_cart_page() {
        Assert.assertTrue(cartPage.isCartPageDisplayed(), "Not on cart page!");
        extTest.info("Verified user is on the cart page");
    }

    @When("the user selects the first patient")
    public void the_user_selects_the_first_patient() {
        cartPage.selectFirstPatient();
        extTest.info("Selected the first patient");
    }

    @Then("the patient should be highlighted or marked as selected")
    public void the_patient_should_be_highlighted_or_marked_as_selected() {
        Assert.assertTrue(cartPage.isPatientSelected(), "Patient not selected!");
        extTest.pass("Patient is highlighted/marked as selected");
    }

    @Given("the user has selected a patient")
    public void the_user_has_selected_a_patient() {
        cartPage.selectFirstPatient();
        Assert.assertTrue(cartPage.isPatientSelected(), "No patient selected!");
        extTest.info("Patient was already selected");
    }

    @Then("the user should be navigated to the address selection page")
    public void the_user_should_be_navigated_to_the_address_selection_page() {
        boolean addressVisible = driver.getPageSource().contains("Enter Pincode");
        Assert.assertTrue(addressVisible, "Address selection page not displayed!");
        extTest.pass("Navigated to the address selection page");
    }
}
