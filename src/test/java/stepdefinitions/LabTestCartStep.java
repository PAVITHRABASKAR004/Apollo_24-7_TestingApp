package stepdefinitions;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;   // ✅ import Status

import com.pages.LabTestCartPage;
import stepdefinitions.Hooks;
import io.cucumber.java.en.When;

import java.time.Duration;

public class LabTestCartStep {

    WebDriver driver = Hooks.driver;
    ExtentTest extTest = Hooks.extTest;
    LabTestCartPage labTestCartPage;
    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10)); // ✅ define wait

    @When("the user clicks View Details")
    public void the_user_clicks_view_details() {
        labTestCartPage = new LabTestCartPage(driver, extTest); 
        labTestCartPage.clickViewDetails();
    }

    
}
