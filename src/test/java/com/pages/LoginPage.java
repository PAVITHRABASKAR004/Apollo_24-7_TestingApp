package com.pages;

import java.time.Duration;
import java.util.Properties;
import java.util.Scanner;

import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.setup.Base;
import com.setup.PropertyReader;
import com.setup.Reporter;
import stepdefinitions.Hooks;

public class LoginPage {
	
	WebDriver driver;
	WebDriverWait wait;
	ExtentTest extTest;
	ExtentReports extReports;
	String mobile_number;
	String invalidmobile_no;
	String invalidotp;
	String validotp;
	Scanner scanner = new Scanner(System.in);
	Properties prop = PropertyReader.readProperties();

	// ✅ Locators used inside this page
	private By login               = By.xpath("//span[text()='Login']");
	private By mobileNumberEntry   = By.xpath("//input[@name='mobileNumber']");
	private By continueButton      = By.xpath("//button[contains(text(),'Continue')]");
	private By otpentry            = By.xpath("//input[@title='Please enter the otp']");
	private By verifybutton        = By.xpath("//button[contains(text(), 'Verify')]");
	private By resendbtn           = By.xpath("//span[text()='Resend OTP']");
	private By validatelogin       = By.xpath("//*[@id=\"loginPopup\"]/img");
	private By mobilefield         = By.xpath("//*[@id=\"fixedHeaderCT\"]/div/div[1]/div[2]/ul/li/div/div/div[2]/div[2]/div[2]/div/p[2]");
	private By profileclose        = By.xpath("//div[contains(@class, 'ProfileNew_icon-ic_cross')]");
	private By invalidmobileerrormsg = By.xpath("//div[text()='This seems like a wrong number']");
	private By closebtn            = By.xpath("//span[@class='Rb']");
	
	public LoginPage(WebDriver driver, ExtentTest extTest2) {
		this.driver = Base.driver;
		wait = new WebDriverWait(driver,Duration.ofSeconds(10));
		this.extTest = extTest2;
	}
	
	public void clickloginbutton() {
		wait = new WebDriverWait(driver,Duration.ofSeconds(20));
		wait.until(ExpectedConditions.elementToBeClickable(login)).click();
	}
	
	public void entermobilenumber(String mnumber) {
		try {
			WebElement mobile = wait.until(ExpectedConditions.visibilityOfElementLocated(mobileNumberEntry));
			mobile.click();
			mobile_number = mnumber;
			mobile.sendKeys(mobile_number);
			wait = new WebDriverWait(driver, Duration.ofSeconds(10));
			wait.until(ExpectedConditions.elementToBeClickable(continueButton)).click();	
			Reporter.generateReport(driver,extTest,Status.PASS,"Valid mobile number is accepted");
		}
		catch(TimeoutException te) {
			Reporter.generateReport(driver,extTest,Status.FAIL,"Valid mobile number is not acccepted");
		}
	}

	public void clickcontinuebutton() {
		driver.findElement(continueButton).click();
	}
	
	public void enterotp() {
	    try {
	        System.out.println("Enter the OTP received (you have 40 seconds): ");
	        String userInput = waitForConsoleInput(40);  // first 40s

	        if (userInput == null || userInput.isEmpty()) {
	            WebElement resendBtn = wait.until(ExpectedConditions.elementToBeClickable(resendbtn));
	            resendBtn.click();
	            Reporter.generateReport(driver, extTest, Status.INFO, "No OTP entered in 40s. Resend OTP clicked.");
	            System.out.println("Enter the OTP received after resend (you have 40 seconds): ");
	            userInput = waitForConsoleInput(40);
	        }

	        if (userInput == null || userInput.isEmpty()) {
	            Reporter.generateReport(driver, extTest, Status.FAIL, "No OTP entered even after resend.");
	            return;
	        }

	        validotp = userInput;
	        WebElement otp_input = wait.until(ExpectedConditions.visibilityOfElementLocated(otpentry));
	        otp_input.click();
	        otp_input.sendKeys(validotp);
	        driver.findElement(verifybutton).click();

	        Reporter.generateReport(driver, extTest, Status.PASS, "Valid OTP entered and verified");

	    } catch (TimeoutException te) {
	        Reporter.generateReport(driver, extTest, Status.FAIL, "OTP input field not available");
	    } catch (Exception e) {
	        e.printStackTrace();
	    }
	}

	private String waitForConsoleInput(int seconds) throws Exception {
	    long startTime = System.currentTimeMillis();
	    String input = null;

	    while ((System.currentTimeMillis() - startTime) < seconds * 1000L) {
	        if (System.in.available() > 0) {
	            input = scanner.nextLine().trim();
	            if (!input.isEmpty()) {
	                break;
	            }
	        }
	        Thread.sleep(500);
	    }
	    return input;
	}
	
	public void validatelogin() {
		try {
			wait.until(ExpectedConditions.visibilityOfElementLocated(validatelogin)).click();
			WebElement mobile = wait.until(ExpectedConditions.visibilityOfElementLocated(mobilefield));
			Reporter.generateReport(driver,extTest,Status.PASS,"User log in success");
			driver.findElement(profileclose).click();
	  	}
		catch (TimeoutException te) {
			Reporter.generateReport(driver,extTest,Status.FAIL,"User log in failed");
		}
	}
	
	public void enterinvalidmobilenumber(String invalidmobile_number) {
		try {
			WebElement invalidmobile = wait.until(ExpectedConditions.visibilityOfElementLocated(mobileNumberEntry));
			invalidmobile.click();
			invalidmobile_no = invalidmobile_number;
			invalidmobile.sendKeys(invalidmobile_no);
			String errmsg = driver.findElement(invalidmobileerrormsg).getText();	
			Reporter.generateReport(driver,extTest,Status.PASS,errmsg);
			driver.findElement(closebtn).click();
		}
		catch(TimeoutException te) {
			Reporter.generateReport(driver,extTest,Status.FAIL,"Invalid mobile number accepted");
		}
	}
	
	public void enterinvalidotp() {
		try {
			System.out.print("Enter the otp : ");
			invalidotp = scanner.next();
			wait.until(ExpectedConditions.visibilityOfElementLocated(otpentry)).sendKeys(invalidotp);
			driver.findElement(verifybutton).click();
			wait = new WebDriverWait(driver, Duration.ofSeconds(30));
			Reporter.generateReport(driver,extTest,Status.PASS,"Invalid otp number is not accepted");
			driver.findElement(closebtn).click();
		}
		catch (TimeoutException te) {
			Reporter.generateReport(driver,extTest,Status.FAIL,"Invalid otp number is acccepted");
		}
	}
}
