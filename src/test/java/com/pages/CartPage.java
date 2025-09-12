package com.pages;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class CartPage {

    WebDriver driver;
    WebDriverWait wait;
    ExtentTest extTest;   // 👈 Added ExtentTest

    // ✅ Locators
    private By proceedToCartBtn = By.xpath("//span[normalize-space()='Proceed To Cart']/parent::button");
    private By firstPatient = By.xpath("//div[div[normalize-space()='Ms. pavithra baskar']]//img[contains(@src,'ic_circleplus.png')]");
    private By continueBtn = By.xpath("//span[normalize-space()='CONTINUE']/parent::button");

    // ✅ Constructor
    public CartPage(WebDriver driver, ExtentTest extTest) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        this.extTest = extTest;
    }

    // ✅ Click Proceed to Cart
    public void clickProceedToCart() {
        try {
            WebElement btn = wait.until(ExpectedConditions.elementToBeClickable(proceedToCartBtn));
            btn.click();
            extTest.log(Status.PASS, "Clicked on 'Proceed To Cart' button.");
        } catch (Exception e) {
            extTest.log(Status.FAIL, "Failed to click on 'Proceed To Cart' button. " + e.getMessage());
            throw e;
        }
    }

    // ✅ Select first patient
    public void selectFirstPatient() {
        try {
            WebElement patient = wait.until(ExpectedConditions.elementToBeClickable(firstPatient));
            patient.click();
            extTest.log(Status.PASS, "Selected the first patient: Ms. pavithra baskar.");
        } catch (Exception e) {
            extTest.log(Status.FAIL, "Failed to select the first patient. " + e.getMessage());
            throw e;
        }
    }

    // ✅ Click Continue
    public void clickContinue() {
        try {
            WebElement btn = wait.until(ExpectedConditions.elementToBeClickable(continueBtn));
            btn.click();
            extTest.log(Status.PASS, "Clicked on 'Continue' button.");
        } catch (Exception e) {
            extTest.log(Status.FAIL, "Failed to click on 'Continue' button. " + e.getMessage());
            throw e;
        }
    }

    // ✅ Verify cart page displayed
    public boolean isCartPageDisplayed() {
        try {
            boolean displayed = wait.until(ExpectedConditions.visibilityOfElementLocated(proceedToCartBtn)).isDisplayed();
            extTest.log(Status.INFO, "Cart page displayed: " + displayed);
            return displayed;
        } catch (Exception e) {
            extTest.log(Status.FAIL, "Cart page not displayed. " + e.getMessage());
            return false;
        }
    }

    // ✅ Verify patient selected
    public boolean isPatientSelected() {
        try {
            WebElement patient = wait.until(ExpectedConditions.visibilityOfElementLocated(firstPatient));
            boolean selected = patient.isSelected();
            extTest.log(Status.INFO, "First patient selection status: " + selected);
            return selected;
        } catch (Exception e) {
            extTest.log(Status.FAIL, "Failed to verify patient selection. " + e.getMessage());
            return false;
        }
    }
}
