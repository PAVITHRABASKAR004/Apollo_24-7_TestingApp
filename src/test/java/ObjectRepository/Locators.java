package ObjectRepository;

import org.openqa.selenium.By;

public class Locators {

    // login button
    public static By login = By.xpath("//span[text()='Login']");
    
    // Mobile Number entry
    public static By mobileNumberEntry = By.xpath("//input[@name='mobileNumber']");
    
    // continue button
    public static By continueButton = By.xpath("//button[contains(text(),'Continue')]");

    // OTP entry
    public static By otpentry = By.xpath("//input[@title='Please enter the otp']");
    
    // verify button
    public static By verifybutton = By.xpath("//button[contains(text(), 'Verify')]");
    
    // resend button
    public static By resendbtn = By.xpath("//span[text()='Resend OTP']");
    
    // validate login
    public static By validatelogin = By.xpath("//*[@id=\"loginPopup\"]/img");
    
    // mobile field
    public static By mobilefield = By.xpath("//*[@id=\"fixedHeaderCT\"]/div/div[1]/div[2]/ul/li/div/div/div[2]/div[2]/div[2]/div/p[2]");
    
    // invalid message
    public static By invalidmobileerrormsg = By.xpath("//div[text()='This seems like a wrong number']");
    
    // close button
    public static By closebtn = By.xpath("//span[@class='Rb']");
    public static By profileclose = By.xpath("//div[contains(@class, 'ProfileNew_icon-ic_cross')]");
    
    // Lab Tests tab
    public static By labTestsTab = By.xpath("//*[@id=\"fixedHeaderCT\"]/div/div[2]/div[1]/ul/li[3]/a");

    // Doctor Created Health Checks - Full Body Checkup
    public static By fullBodyCheckup = By.xpath("//*[@id=\"mainContainerCT\"]/div[1]/div[1]/div/div[1]/a/div");

    // First test under the package
    public static By firstTest = By.xpath("//*[@id=\"mainContainerCT\"]/div/div/div[1]/div[3]/div[2]/div[2]/div/div/div[1]/div/div[2]/div[2]/button");

    // Cart or selection area
    public static By cartArea = By.xpath("//*[@id=\"mainContainerCT\"]/div/div/div[2]/div/div[2]/div[1]");
    
    public static By viewDetailsButton = By.xpath("//*[@id=\"mainContainerCT\"]/div/div/div[2]/div/div[2]/div[1]/div/span");

    // Proceed to Cart button
    public static By proceedToCartButton = By.xpath("/html/body/main/div[4]/div/div[3]/div/button");

    

        // Input Fields
    public static By firstName     = By.xpath("//input[@placeholder='First Name']");
    public static By lastName      = By.xpath("//input[@placeholder='Last name']");
    public static By dob           = By.xpath("//input[@placeholder='dd/mm/yyyy']");

    // Gender Buttons
    public static By genderMale    = By.xpath("//button[text()='Male']");
    public static By genderFemale  = By.xpath("//button[text()='Female']");

    // Relation Dropdown
    public static By relation      = By.xpath("//div[@tabindex='0' and contains(@class,'AphSelect_select')]/i");

    // Email Field / Dropdown
    public static By email         = By.xpath("//div[@tabindex='0' and contains(@class,'AphSelect_select')]");

    // Buttons
    public static By saveButton    = By.xpath("//button[text()='Save']");

    // Success Messages
    public static By successMessage = By.xpath("//div[contains(text(),'Member added successfully')]");
}

