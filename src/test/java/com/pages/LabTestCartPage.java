package com.pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

public class LabTestCartPage {

    WebDriver driver;
    WebDriverWait wait;
    ExtentTest extTest;

    public LabTestCartPage(WebDriver driver, ExtentTest extTest) {
        this.driver = driver;
        this.extTest = extTest;
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    // Click View Details button
 // Click View Details button
    public void clickViewDetails() {
        try {
            WebElement viewDetailsBtn = wait.until(ExpectedConditions
                    .visibilityOfElementLocated(By.xpath("//*[contains(text(),'View Details')]")));
            
            System.out.println("Found element text: " + viewDetailsBtn.getText()); // debug log
            viewDetailsBtn.click();
            
            extTest.log(Status.PASS, "Clicked on View Details button");
        } catch (Exception e) {
            extTest.log(Status.FAIL, "Failed to click on View Details button");
            e.printStackTrace();
        }
    }


    // Click Proceed to Cart button
    public void clickProceedToCart() {
        try {
            WebElement proceedBtn = wait.until(ExpectedConditions.elementToBeClickable(
                By.xpath("//button[contains(text(),'Proceed to Cart')]")));
            proceedBtn.click();
            extTest.log(Status.PASS, "Clicked on Proceed to Cart button");
        } catch (Exception e) {
            extTest.log(Status.FAIL, "Failed to click on Proceed to Cart button");
            e.printStackTrace();
        }
    }

    // Add members
    public void addMembers(int count) {
        try {
            for (int i = 1; i <= count; i++) {
                WebElement addMemberBtn = wait.until(ExpectedConditions.elementToBeClickable(
                    By.xpath("//button[contains(text(),'Add Member')]")));
                addMemberBtn.click();
            }
            extTest.log(Status.PASS, count + " member(s) added successfully");
        } catch (Exception e) {
            extTest.log(Status.FAIL, "Failed to add members");
            e.printStackTrace();
        }
    }
}
