package com.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.setup.Reporter;

import java.time.Duration;

public class LabTestsPage {

    WebDriver driver;
    WebDriverWait wait;
    ExtentTest extTest;

    // ✅ Locators used in this page
    private By labTestsTab      = By.xpath("//*[@id=\"fixedHeaderCT\"]/div/div[2]/div[1]/ul/li[3]/a");
    private By fullBodyCheckup  = By.xpath("//*[@id=\"mainContainerCT\"]/div[1]/div[1]/div/div[1]/a/div");
    private By firstTest        = By.xpath("//*[@id=\"mainContainerCT\"]/div/div/div[1]/div[3]/div[2]/div[2]/div/div/div[1]/div/div[2]/div[2]/button");
    private By cartArea         = By.xpath("//*[@id=\"mainContainerCT\"]/div/div/div[2]/div/div[2]/div[1]");

    public LabTestsPage(WebDriver driver, ExtentTest extTest) {
        this.driver = driver;
        this.extTest = extTest;
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    public void clickLabTestsTab() {
        wait.until(ExpectedConditions.elementToBeClickable(labTestsTab)).click();
        Reporter.generateReport(driver, extTest, Status.PASS, "Clicked on Lab Tests tab");
    }

    public void selectFullBodyCheckup() {
        wait.until(ExpectedConditions.elementToBeClickable(fullBodyCheckup)).click();
        Reporter.generateReport(driver, extTest, Status.PASS, "Selected 'Full Body Checkup' package");
    }

    public void selectFirstTest() {
        wait.until(ExpectedConditions.elementToBeClickable(firstTest)).click();
        Reporter.generateReport(driver, extTest, Status.PASS, "Selected first test under the package");
    }

    public boolean isTestInCart() {
        try {
            WebElement cart = wait.until(ExpectedConditions.visibilityOfElementLocated(cartArea));
            boolean displayed = cart.isDisplayed();
            if(displayed) {
                Reporter.generateReport(driver, extTest, Status.PASS, "Selected test is displayed in the cart");
            }
            return displayed;
        } catch (Exception e) {
            Reporter.generateReport(driver, extTest, Status.FAIL, "Selected test not displayed in the cart");
            return false;
        }
    }
}
