package com.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import java.util.List;

public class LabTestsPage {
    WebDriver driver;

    // Constructor
    public LabTestsPage(WebDriver driver) {
        this.driver = driver;
    }

    // Locator for Filters - Top Deals
    By topDealsFilter = By.xpath("//div[contains(text(),'Top Deals')]");

    // Locator for Type of Tests section
    By typeOfTests = By.xpath("//div[contains(text(),'Type of Tests')]");

    // Locator for first test under Type of Tests
    By firstTest = By.cssSelector(".type-of-tests-list li:first-child"); 
    // 🔼 update with actual DOM if structure differs

    public void clickTopDeals() {
        driver.findElement(topDealsFilter).click();
    }

    public void clickTypeOfTests() {
        driver.findElement(typeOfTests).click();
    }

    public void selectFirstTest() {
        WebElement first = driver.findElement(firstTest);
        first.click();
    }
}
