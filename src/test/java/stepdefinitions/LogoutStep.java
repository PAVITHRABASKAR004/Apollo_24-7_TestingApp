package stepdefinitions;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.pages.LogoutPage;
import com.setup.Base;
import io.cucumber.java.en.*;
import org.testng.Assert;
import org.openqa.selenium.WebDriver;

public class LogoutStep extends Base {

    WebDriver driver = Hooks.driver;
    ExtentTest extTest = Hooks.extTest;
    LogoutPage logoutPage = new LogoutPage(driver);

    @When("the user clicks the Back button")
    public void the_user_clicks_the_back_button() {
        logoutPage.clickBackButton();
        extTest.log(Status.PASS, "Clicked on Back button");
    }

    @When("the user clicks on the My Account icon")
    public void the_user_clicks_on_the_my_account_icon() {
        logoutPage.clickMyAccountIcon();
        extTest.log(Status.PASS, "Clicked on My Account icon");
    }

    @When("the user clicks Logout")
    public void the_user_clicks_logout() {
        logoutPage.clickLogout();
        extTest.log(Status.PASS, "Clicked on Logout button");
    }

    @Then("the user should be logged out successfully")
    public void the_user_should_be_logged_out_successfully() {
        Assert.assertTrue(logoutPage.isLoggedOut(), "Logout was not successful!");
        extTest.log(Status.PASS, "User logged out successfully");
    }
}
