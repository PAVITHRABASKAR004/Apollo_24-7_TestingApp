package com.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class SelectLabTestPackagePage {
    WebDriver driver;
    WebDriverWait wait;

    public SelectLabTestPackagePage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    // Locator for Doctor Created Health Checks section
    By doctorCreatedHealthChecks = By.xpath("//*[@id=\"mainContainerCT\"]/div[1]/div[1]/header/h2");

    // Locator for Full Body Checkup card (make it text-based, not index-based)
    By fullBodyCheckup = By.xpath("//*[@id=\"mainContainerCT\"]/div[1]/div[1]/div/div[1]/a/div");

    public void browseCategories() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(doctorCreatedHealthChecks));
    }

    public void selectFullBodyCheckup() {
        wait.until(ExpectedConditions.elementToBeClickable(fullBodyCheckup)).click();
    }

    public boolean isFullBodyCheckupDisplayed() {
        // Check heading on Full Body Checkup package page
        By fullBodyCheckupHeader = By.xpath("//*[@id=\"mainContainerCT\"]/div/div/div[1]/div[4]/div[2]/div[2]/div/header/h1");
        return wait.until(ExpectedConditions.visibilityOfElementLocated(fullBodyCheckupHeader)).isDisplayed();
    }
}
