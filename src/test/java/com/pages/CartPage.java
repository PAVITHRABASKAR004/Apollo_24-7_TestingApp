package com.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class CartPage {

    WebDriver driver;
    WebDriverWait wait;

    // ✅ Locators
    private By proceedToCartBtn = By.xpath("//span[normalize-space()='Proceed To Cart']/parent::button");
    private By firstPatient = By.xpath("//div[div[normalize-space()='Ms. pavithra baskar']]//img[contains(@src,'ic_circleplus.png')]");
    private By continueBtn = By.xpath("//span[normalize-space()='CONTINUE']/parent::button");
    
    public CartPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(20));
    }

    // ✅ Click Proceed to Cart
    public void clickProceedToCart() {
        WebElement btn = wait.until(ExpectedConditions.elementToBeClickable(proceedToCartBtn));
        btn.click();
    }

    // ✅ Select first patient
    public void selectFirstPatient() {
        WebElement patient = wait.until(ExpectedConditions.elementToBeClickable(firstPatient));
        patient.click();
    }

    // ✅ Click Continue
    public void clickContinue() {
        WebElement btn = wait.until(ExpectedConditions.elementToBeClickable(continueBtn));
        btn.click();
    }

    // ✅ Verify cart page displayed
    public boolean isCartPageDisplayed() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(proceedToCartBtn)).isDisplayed();
    }

    // ✅ Verify patient selected
    public boolean isPatientSelected() {
        WebElement patient = wait.until(ExpectedConditions.visibilityOfElementLocated(firstPatient));
        return patient.isSelected();
    }

}
