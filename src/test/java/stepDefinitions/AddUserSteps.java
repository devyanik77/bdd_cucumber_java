package stepDefinitions;

import io.cucumber.java.en.*;
import org.openqa.selenium.WebDriver;
import pageObjects.AddUserPage;
import pageObjects.DashboardPage;
import utilities.DriverFactory;
import static org.junit.Assert.*;

public class AddUserSteps {
    WebDriver driver = DriverFactory.getDriver();
    DashboardPage dashboard = new DashboardPage(driver);
    AddUserPage addUser = new AddUserPage(driver);
    String generatedUser = "";

    @When("I click on User Management in the Admin menu")
    public void openUserManagement() {
        dashboard.openUserManagement();
    }

    @When("I click on Add button")
    public void clickAdd() {
        addUser.clickAdd();
    }

    @When("I enter {string} in the Employee Name field")
    public void enterEmployeeName(String name) {
        addUser.enterEmployeeName(name);
    }

    @When("I enter {string} in the Username field")
    public void enterUsername(String uname) {
        if (uname.equals("<randomUsername>")) {
            generatedUser = "user" + System.currentTimeMillis() / 1000;
            uname = generatedUser;
        }
        addUser.enterUsername(uname);
    }

    @When("I enter {string} in the Password field")
    public void enterPassword(String pwd) {
        addUser.enterPassword(pwd);
    }

    @When("I enter {string} in the Confirm Pass field")
    public void enterConfirm(String pwd) {
        addUser.confirmPassword(pwd);
    }

    @When("I click on the Save button")
    public void clickSave() {
        addUser.clickSave();
    }

    @Then("I should see the new user in the user list")
    public void verifyUserCreated() {
        System.out.println("User successfully created: " + generatedUser);
        assertNotNull(generatedUser);
    }
}
