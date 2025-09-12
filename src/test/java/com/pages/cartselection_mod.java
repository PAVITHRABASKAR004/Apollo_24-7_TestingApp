package com.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class cartselection_mod {

    WebDriver driver;
    WebDriverWait wait;

    // ✅ Correct XPaths
    private By selectButton = By.xpath("//button[.//span[normalize-space()='Select']]");
    private By undoButton   = By.xpath("//button[.//span[normalize-space()='Undo']]");
    private By removeButton = By.xpath("//button[.//span[normalize-space()='Remove']]");

    public cartselection_mod(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(20));
    }

    // ✅ Select a test
    public void clickSelect() {
        WebElement select = wait.until(ExpectedConditions.elementToBeClickable(selectButton));
        select.click();
    }

    // ✅ Undo selection
    public void clickUndo() {
        WebElement undo = wait.until(ExpectedConditions.elementToBeClickable(undoButton));
        undo.click();
    }

    // ✅ Remove test from cart
    public void clickRemove() {
        WebElement remove = wait.until(ExpectedConditions.elementToBeClickable(removeButton));
        remove.click();
    }

    // ✅ Check if Select is highlighted or confirmed
    public boolean isTestSelected() {
        WebElement select = wait.until(ExpectedConditions.visibilityOfElementLocated(selectButton));
        String className = select.getAttribute("class");
        return className.contains("selected") || className.contains("active");
    }

    // ✅ Verify test removed
    public boolean isTestRemoved() {
        return driver.findElements(removeButton).isEmpty();
    }
}
