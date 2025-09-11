package com.setup;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import org.apache.commons.io.FileUtils;

public class Reporter {
    public static void generateReport(WebDriver driver, ExtentTest extTest, Status status, String message) {
        extTest.log(status, message);
    }

    // Overloaded method to include screenshots
    public static void generateReport(WebDriver driver, ExtentTest extTest, Status status, String message, String base64Screenshot) {
        extTest.log(status, message,
            MediaEntityBuilder.createScreenCaptureFromBase64String(base64Screenshot).build());
    }
}
