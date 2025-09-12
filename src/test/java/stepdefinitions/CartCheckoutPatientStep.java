package stepdefinitions;

import com.pages.CartPage;
import io.cucumber.java.en.*;
import org.testng.Assert;
import org.openqa.selenium.WebDriver;
import com.setup.Base;

public class CartCheckoutPatientStep extends Base {

    WebDriver driver = getDriver();
    CartPage cartPage = new CartPage(driver);

    @When("the user clicks {string}")
    public void the_user_clicks_button(String buttonName) {
        if (buttonName.equalsIgnoreCase("Proceed to Cart")) {
            cartPage.clickProceedToCart();
        } else if (buttonName.equalsIgnoreCase("Continue")) {
            cartPage.clickContinue();
        }
    }

    @Then("the cart page should be displayed")
    public void the_cart_page_should_be_displayed() {
        Assert.assertTrue(cartPage.isCartPageDisplayed(), "Cart page not displayed!");
    }

    @Given("the user is on the cart page")
    public void the_user_is_on_the_cart_page() {
        Assert.assertTrue(cartPage.isCartPageDisplayed(), "Not on cart page!");
    }

    @When("the user selects the first patient")
    public void the_user_selects_the_first_patient() {
        cartPage.selectFirstPatient();
    }

    @Then("the patient should be highlighted or marked as selected")
    public void the_patient_should_be_highlighted_or_marked_as_selected() {
        Assert.assertTrue(cartPage.isPatientSelected(), "Patient not selected!");
    }

    @Given("the user has selected a patient")
    public void the_user_has_selected_a_patient() {
        cartPage.selectFirstPatient();
        Assert.assertTrue(cartPage.isPatientSelected(), "No patient selected!");
    }

    @Then("the user should be navigated to the address selection page")
    public void the_user_should_be_navigated_to_the_address_selection_page() {
        // Simple check for Pincode input field text
        boolean addressVisible = driver.getPageSource().contains("Enter Pincode");
        Assert.assertTrue(addressVisible, "Address selection page not displayed!");
    }
}

