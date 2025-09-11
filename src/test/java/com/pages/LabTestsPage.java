package com.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.setup.Reporter;
import ObjectRepository.Locators;

import java.time.Duration;

public class LabTestsPage {

    WebDriver driver;
    WebDriverWait wait;
    ExtentTest extTest;

    public LabTestsPage(WebDriver driver, ExtentTest extTest) {
        this.driver = driver;
        this.extTest = extTest;
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    public void clickLabTestsTab() {
        wait.until(ExpectedConditions.elementToBeClickable(Locators.labTestsTab)).click();
        Reporter.generateReport(driver, extTest, Status.PASS, "Clicked on Lab Tests tab");
    }

    public void selectFullBodyCheckup() {
        wait.until(ExpectedConditions.elementToBeClickable(Locators.fullBodyCheckup)).click();
        Reporter.generateReport(driver, extTest, Status.PASS, "Selected 'Full Body Checkup' package");
    }

    public void selectFirstTest() {
        wait.until(ExpectedConditions.elementToBeClickable(Locators.firstTest)).click();
        Reporter.generateReport(driver, extTest, Status.PASS, "Selected first test under the package");
    }

    public boolean isTestInCart() {
        try {
            WebElement cart = wait.until(ExpectedConditions.visibilityOfElementLocated(Locators.cartArea));
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
