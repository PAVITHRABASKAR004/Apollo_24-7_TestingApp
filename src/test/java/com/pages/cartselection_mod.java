package com.pages;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class cartselection_mod {

    WebDriver driver;
    WebDriverWait wait;
    ExtentTest extTest;   // ✅ Added ExtentTest

    // ✅ Correct XPaths
    private By selectButton = By.xpath("//button[.//span[normalize-space()='Select']]");
    private By undoButton   = By.xpath("//button[.//span[normalize-space()='Undo']]");
    private By removeButton = By.xpath("//button[.//span[normalize-space()='Remove']]");

    // ✅ Constructor with ExtentTest
    public cartselection_mod(WebDriver driver, ExtentTest extTest) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        this.extTest = extTest;
    }

    // ✅ Select a test
    public void clickSelect() {
        try {
            WebElement select = wait.until(ExpectedConditions.elementToBeClickable(selectButton));
            select.click();
            extTest.log(Status.PASS, "Clicked on 'Select' button.");
        } catch (Exception e) {
            extTest.log(Status.FAIL, "Failed to click on 'Select' button. " + e.getMessage());
            throw e;
        }
    }

    // ✅ Undo selection
    public void clickUndo() {
        try {
            WebElement undo = wait.until(ExpectedConditions.elementToBeClickable(undoButton));
            undo.click();
            extTest.log(Status.PASS, "Clicked on 'Undo' button.");
        } catch (Exception e) {
            extTest.log(Status.FAIL, "Failed to click on 'Undo' button. " + e.getMessage());
            throw e;
        }
    }

    // ✅ Remove test from cart
    public void clickRemove() {
        try {
            WebElement remove = wait.until(ExpectedConditions.elementToBeClickable(removeButton));
            remove.click();
            extTest.log(Status.PASS, "Clicked on 'Remove' button.");
        } catch (Exception e) {
            extTest.log(Status.FAIL, "Failed to click on 'Remove' button. " + e.getMessage());
            throw e;
        }
    }

    // ✅ Check if Select is highlighted or confirmed
    public boolean isTestSelected() {
        try {
            WebElement select = wait.until(ExpectedConditions.visibilityOfElementLocated(selectButton));
            String className = select.getAttribute("class");
            boolean selected = className.contains("selected") || className.contains("active");
            extTest.log(Status.INFO, "Test selected status: " + selected);
            return selected;
        } catch (Exception e) {
            extTest.log(Status.FAIL, "Failed to verify if test is selected. " + e.getMessage());
            return false;
        }
    }

    // ✅ Verify test removed
    public boolean isTestRemoved() {
        try {
            boolean removed = driver.findElements(removeButton).isEmpty();
            extTest.log(Status.INFO, "Test removed status: " + removed);
            return removed;
        } catch (Exception e) {
            extTest.log(Status.FAIL, "Failed to verify if test is removed. " + e.getMessage());
            return false;
        }
    }
}
