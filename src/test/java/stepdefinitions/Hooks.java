package stepdefinitions;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.DataProvider;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import parameters.ExcelReader;
import com.setup.Base;

import io.cucumber.java.After;
import io.cucumber.java.AfterAll;
import io.cucumber.java.Before;
import io.cucumber.java.BeforeAll;
import io.cucumber.java.Scenario;

public class Hooks extends Base{
	
	//public static WebDriver driver;
	static ExtentSparkReporter spark;
	static ExtentReports extReports;
	public static ExtentTest extTest;
	
	//public static int currentrow = 0;
	public static int firstrow = 0;
	public static int secondrow = 1;
	public static int thirdrow = 3;
	
	@BeforeAll
	public static void beforeAll() {
		
		spark = new ExtentSparkReporter("ExtentReport.html");
		extReports = new ExtentReports();
		extReports.attachReporter(spark);
		launchBrowser();
		
	}
	
	@AfterAll
	public static void afterAll() {
		extReports.flush();
		
	}
	
	@Before
	public void setUp(Scenario scenario) {
		extTest = extReports.createTest(scenario.getName());
		
	}
	
	@After
	public void tearDown() {
		//currentrow++;
		
		
	}


}