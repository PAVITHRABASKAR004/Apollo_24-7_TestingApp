package stepdefinitions;

import com.pages.SelectLabTestPackagePage;
import io.cucumber.java.en.*;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class SelectLabTestPackageSteps {
    WebDriver driver;
    SelectLabTestPackagePage selectLabTestPackagePage;

    public SelectLabTestPackageSteps() {
        this.driver = Hooks.getDriver(); 
        this.selectLabTestPackagePage = new SelectLabTestPackagePage(driver);
    }

    @When("the user browses the categories")
    public void user_browses_categories() {
        selectLabTestPackagePage.browseCategories();
    }

    @When("the user selects {string} under Doctor Created Health Checks")
    public void user_selects_full_body_checkup(String packageName) {
        selectLabTestPackagePage.selectFullBodyCheckup();
    }

    
}
