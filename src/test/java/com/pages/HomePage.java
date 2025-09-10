package com.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class HomePage {
    WebDriver driver;
    WebDriverWait wait;

    public HomePage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    // Locator for Lab Tests tab
    By labTestsTab = By.xpath("//*[@id='fixedHeaderCT']/div/div[2]/div[1]/ul/li[3]");

    // Locator for popup background (blocking element)
    By popupBackground = By.cssSelector(".ProfileNew_modalBackground__tCWPu");

    // Click Lab Tests tab safely
    public void clickLabTests() {
        try {
            // Wait for popup and close it if present
            wait.withTimeout(Duration.ofSeconds(3));
            WebElement popup = wait.until(ExpectedConditions.visibilityOfElementLocated(popupBackground));
            if (popup.isDisplayed()) {
                System.out.println("Popup detected. Closing it...");
                popup.click(); // click outside / or ESC key if needed
                Thread.sleep(500); // small wait for it to disappear
            }
        } catch (Exception e) {
            System.out.println("No popup blocking, continuing...");
        }

        // Now click Lab Tests tab
        wait.until(ExpectedConditions.elementToBeClickable(labTestsTab)).click();
    }

    // Verify navigation
    public boolean isOnLabTestsPage() {
        return driver.getCurrentUrl().contains("lab-tests");
    }
}
