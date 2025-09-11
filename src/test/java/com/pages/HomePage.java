package com.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;
import java.util.List;

public class homepage {

    WebDriver driver;
    WebDriverWait wait;

    public homepage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(15));
    }

    By labTestsTab = By.xpath("//*[@id=\"fixedHeaderCT\"]/div/div[2]/div[1]/ul/li[3]/a");
    By modalOverlay = By.cssSelector(".ProfileNew_modalBackground__tCWPu");

    public void clickLabTests() {
        By labTestsTab = By.xpath("//*[@id=\"fixedHeaderCT\"]/div/div[2]/div[1]/ul/li[3]/a");

        WebElement labTab = new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.presenceOfElementLocated(labTestsTab));

        // Force click via JavaScript
        ((org.openqa.selenium.JavascriptExecutor) driver).executeScript("arguments[0].click();", labTab);

        System.out.println("Clicked Lab Tests tab using JS executor.");
    }

}