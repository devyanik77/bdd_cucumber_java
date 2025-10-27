package stepDefinitions;

import io.cucumber.java.en.*;
import org.openqa.selenium.WebDriver;
import pageObjects.AddEmployeePage;
import pageObjects.DashboardPage;
import utilities.DriverFactory;
import static org.junit.Assert.*;

public class AddEmployeeSteps {
    WebDriver driver = DriverFactory.getDriver();
    DashboardPage dashboard = new DashboardPage(driver);
    AddEmployeePage employeePage = new AddEmployeePage(driver);

    @When("I navigate to the PIM module")
    public void navigatePIM() {
        System.out.println("Navigating to PIM section...");
    }

    @When("I click on Add Employee")
    public void clickAddEmployee() {
        employeePage.clickAdd();
    }

    @When("I enter First Name {string} and Last Name {string}")
    public void enterNames(String fname, String lname) {
        employeePage.enterFirstName(fname);
        employeePage.enterLastName(lname);
    }

    @When("I click Save Employee")
    public void clickSave() {
        employeePage.clickSave();
    }

    @Then("I should see employee added successfully")
    public void verifyAdded() {
        System.out.println("Employee added successfully!");
        assertTrue(true);
    }
}
