package stepDefinitions;

import io.cucumber.java.en.*;
import org.openqa.selenium.WebDriver;
import pageObjects.LoginPage;
import pageObjects.DashboardPage;
import utilities.DriverFactory;
import utilities.ConfigReader;

// Change from JUnit to TestNG assertions
import static org.testng.Assert.*;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class LoginSteps {
    WebDriver driver = DriverFactory.getDriver();
    LoginPage login = new LoginPage(driver);
    DashboardPage dashboard = new DashboardPage(driver);

    @Given("I navigate to the OrangeHRM login page")
    public void iNavigateToLoginPage() {
        System.out.println("Navigating to OrangeHRM login page...");
        login.open(ConfigReader.getProperty("url"));
    }

    @When("I enter valid username {string}")
    public void enterUsername(String uname) {
        System.out.println("Entering username: " + uname);
        login.enterUsername(uname);
    }

    @When("I enter valid password {string}")
    public void enterPassword(String pwd) {
        System.out.println("Entering password: [PROTECTED]");
        login.enterPassword(pwd);
    }

    @When("I click on Login button")
    public void clickLogin() {
        System.out.println("Clicking Login button...");
        login.clickLogin();
    }

    @Then("I should see the Dashboard")
    public void verifyDashboard() {
        System.out.println("Verifying Dashboard is visible...");
        assertTrue(dashboard.isDashboardVisible(), "Dashboard should be visible after login");
    }

    @Then("I should see an error message {string}")
    public void verifyError(String expected) {
        System.out.println("Verifying error message: " + expected);
        String actualError = login.getErrorMessage();
        assertTrue(actualError.contains(expected), 
                  "Expected error message to contain: " + expected + " but was: " + actualError);
    }

    @Then("I should be redirected to the dashboard")
    public void i_should_be_redirected_to_the_dashboard() {
        System.out.println("Verifying redirection to dashboard...");
        assertTrue(dashboard.isDashboardVisible(), 
                  "User should be redirected to dashboard after successful login");
    }

    @When("I click on the user dropdown in the top-right corner")
    public void i_click_on_the_user_dropdown_in_the_top_right_corner() {
        System.out.println("clicking user dropdown in top-right corner...");
        dashboard.openUserDropdown();
    }

    @When("I select Logout")
    public void i_select_logout() {
        System.out.println("Selecting Logout option...");
        dashboard.logout();
    }
    
    @Then("I should be redirected to the login page")
    public void i_should_be_redirected_to_the_login_page() {
        System.out.println("Verifying redirection to login page...");
        String currentUrl = driver.getCurrentUrl();
        assertTrue(currentUrl.contains("/auth/login"), 
                  "Expected to be on login page but current URL is: " + currentUrl);
    }
    
    @Then("I should see the Login button")
    public void i_should_see_the_login_button() {
        System.out.println("Verifying Login button is visible...");
        By loginButton = By.xpath("//button[@type='submit']");
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        
        try {
            wait.until(ExpectedConditions.visibilityOfElementLocated(loginButton));
            assertTrue(driver.findElement(loginButton).isDisplayed(), 
                      "Login button should be visible on login page");
            System.out.println("Login button found and visible");
        } catch (Exception e) {
            fail("Login button not found or not visible: " + e.getMessage());
        }
    }
}