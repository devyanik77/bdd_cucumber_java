package pageObjects;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class LoginPage {
    WebDriver driver;
    WebDriverWait wait;

    public LoginPage(WebDriver driver) {
        this.driver = driver;
        // 10-second wait for all element interactions
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    // ===== Locators =====
    private By username = By.name("username");
    private By password = By.name("password");
    private By loginButton = By.xpath("//button[normalize-space()='Login']");
    private By errorMsg = By.cssSelector(".oxd-alert-content-text");

    // ===== Page Actions =====
    public void open(String url) {
        driver.get(url);
        System.out.println("Opened URL: " + url);
    }

    public void enterUsername(String uname) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(username));
        driver.findElement(username).clear();
        driver.findElement(username).sendKeys(uname);
        System.out.println("Entered username: " + uname);
    }

    public void enterPassword(String pwd) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(password));
        driver.findElement(password).clear();
        driver.findElement(password).sendKeys(pwd);
        System.out.println("Entered password.");
    }

    public void clickLogin() {
        wait.until(ExpectedConditions.elementToBeClickable(loginButton));
        driver.findElement(loginButton).click();
        System.out.println("Clicked Login button.");
    }

    public String getErrorMessage() {
        try {
            wait.until(ExpectedConditions.visibilityOfElementLocated(errorMsg));
            return driver.findElement(errorMsg).getText();
        } catch (TimeoutException e) {
            return "No error message visible.";
        }
    }
}
