package stepdefinitions;

import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import com.pages.HomePage;
import stepdefinitions.Hooks;

public class LabTestsStepdef {
    WebDriver driver = Hooks.driver;
    HomePage homePage = new HomePage(driver);
    
    @When("the user clicks on Lab Tests tab")
    public void the_user_clicks_on_lab_tests_tab() {
        homePage.clickLabTests();   // ✅ correct method name
    }


    @Then("the user should be navigated to the Lab Tests page")
    public void the_user_should_be_navigated_to_the_lab_tests_page() {
        boolean result = homePage.isOnLabTestsPage();
        Assert.assertTrue(result, "User is not navigated to the Lab Tests page!");
    }

}
