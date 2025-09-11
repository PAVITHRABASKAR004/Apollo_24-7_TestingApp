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

    // ✅ Click Proceed to Cart button
    @When("the user clicks Proceed to Cart")
    public void the_user_clicks_proceed_to_cart() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));

        WebElement proceedBtn = wait.until(ExpectedConditions.elementToBeClickable(
                By.xpath("//*[@id=\"mainContainerCT\"]/div/div/div[2]/div/div[3]/div/button")
        ));

        Assert.assertTrue(proceedBtn.isDisplayed(), "'Proceed to Cart' button is not displayed!");
        proceedBtn.click();
    }



    @When("the user adds {int} member")
    public void the_user_adds_member(int count) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));

        WebElement addMemberBtn = wait.until(ExpectedConditions.elementToBeClickable(
                By.xpath("/html/body/main/div[2]/div[1]/div/div[1]/div[2]/button/span")
        ));

        Assert.assertTrue(addMemberBtn.isDisplayed(), "'Add Member' button is not displayed!");
        addMemberBtn.click();
    }

}
