package com.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class LogoutPage {

    WebDriver driver;
    WebDriverWait wait;

    private By backButton = By.xpath("/html/body/main/div[1]/div/img"); 
    private By myAccountIcon = By.xpath("//*[@id=\"loginPopup\"]/img");
    private By logoutButton = By.xpath("//*[@id=\"fixedHeaderCT\"]/div/div[1]/div[2]/ul/li[2]/div/div/div[2]/div[2]/div[3]/ul/li[9]/a/span");
    private By loginButton = By.xpath("//*[@id=\"loginPopup\"]/div");

    public LogoutPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(20));
    }

    public void clickBackButton() {
        WebElement back = wait.until(ExpectedConditions.elementToBeClickable(backButton));
        back.click();
    }

    public void clickMyAccountIcon() {
        try {
            WebElement account = wait.until(
                ExpectedConditions.refreshed(
                    ExpectedConditions.elementToBeClickable(myAccountIcon)
                )
            );
            account.click();
        } catch (StaleElementReferenceException e) {
            // Retry if stale
            WebElement account = wait.until(
                ExpectedConditions.refreshed(
                    ExpectedConditions.elementToBeClickable(myAccountIcon)
                )
            );
            account.click();
        }
    }


    public void clickLogout() {
        WebElement logout = wait.until(ExpectedConditions.elementToBeClickable(logoutButton));
        logout.click();
    }

    public boolean isLoggedOut() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(loginButton)).isDisplayed();
    }
} 