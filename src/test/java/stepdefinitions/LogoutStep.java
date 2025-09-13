package stepdefinitions;

import com.pages.AddTestPage;
import com.pages.LogoutPage;
import com.setup.Base;
import io.cucumber.java.en.*;
import org.testng.Assert;
import org.openqa.selenium.WebDriver;

public class LogoutStep extends Base {

    WebDriver driver = getDriver();
    LogoutPage logoutPage = new LogoutPage(driver);

    @When("the user clicks the Back button")
    public void the_user_clicks_the_back_button() {
        logoutPage.clickBackButton();
    }

    @When("the user clicks on the My Account icon")
    public void the_user_clicks_on_the_my_account_icon() {
        logoutPage.clickMyAccountIcon();
    }

    @When("the user clicks Logout")
    public void the_user_clicks_logout() {
        logoutPage.clickLogout();
    }

    @Then("the user should be logged out successfully")
    public void the_user_should_be_logged_out_successfully() {
        Assert.assertTrue(logoutPage.isLoggedOut(), "Logout was not successful!");
    }
}
