package com.pages;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class AddTestPage {
    WebDriver driver;
    WebDriverWait wait;

    // Locators
    private By addTestsButton = By.xpath("//button[.//span[contains(text(),'Add Tests')]]");
    private By pcodScreeningTest = By.xpath("//p[contains(text(),'PCOD Screening')]");
    private By firstAvailableTest = By.xpath("(//button[.//span[normalize-space()='Add']])[1]");
    private By goToCartButton = By.xpath("//button[.//span[contains(text(),'Go To Cart')]]");

    // Overlay (blocking header)
    private By headerOverlay = By.cssSelector("div.HeaderNew_headerTop__tz04l");

    public AddTestPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(20));
    }

    // Utility: Retry scroll with fallback
    public void scrollToElement(By locator) {
        for (int i = 0; i < 5; i++) {
            try {
                WebElement el = wait.until(ExpectedConditions.presenceOfElementLocated(locator));
                ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView({block: 'center'});", el);
                wait.until(ExpectedConditions.visibilityOf(el));
                wait.until(ExpectedConditions.elementToBeClickable(el));
                return;
            } catch (TimeoutException e) {
                ((JavascriptExecutor) driver).executeScript("window.scrollBy(0, 500);");
            }
        }
        throw new TimeoutException("Element not found after retries: " + locator);
    }

    private void waitForOverlayToDisappear() {
        try {
            wait.until(ExpectedConditions.invisibilityOfElementLocated(headerOverlay));
        } catch (TimeoutException ignored) {}
    }

    // Actions
    public void clickAddTestsButton() {
        waitForOverlayToDisappear();
        scrollToElement(addTestsButton);
        wait.until(ExpectedConditions.elementToBeClickable(addTestsButton)).click();
    }

    public void selectPCODScreening() {
        scrollToElement(pcodScreeningTest);
        wait.until(ExpectedConditions.elementToBeClickable(pcodScreeningTest)).click();
    }

    public void addFirstAvailableTest() {
        scrollToElement(firstAvailableTest);
        wait.until(ExpectedConditions.elementToBeClickable(firstAvailableTest)).click();
    }

    public void clickGoToCart() {
        scrollToElement(goToCartButton);
        wait.until(ExpectedConditions.elementToBeClickable(goToCartButton)).click();
    }

    // Validation methods
    public boolean isAddTestSectionDisplayed() {
        return driver.getPageSource().contains("Add Tests");
    }

    public boolean isPCODScreeningDisplayed() {
        return driver.getPageSource().contains("PCOD Screening");
    }

    public boolean isTestAddedToCart() {
        return driver.getPageSource().contains("Added to Cart")
                || driver.getPageSource().contains("Go To Cart");
    }

    // Getters for stepdefinitions
    public By getAddTestsButton() {
        return addTestsButton;
    }

    public By getGoToCartButton() {
        return goToCartButton;
    }

    public By getPCODScreeningTest() {
        return pcodScreeningTest;
    }
}
