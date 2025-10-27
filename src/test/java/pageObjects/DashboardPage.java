package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;


public class DashboardPage {
    WebDriver driver;
    WebDriverWait wait;

    public DashboardPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(50));
    }

    // ===== Locators =====
    private By dashboardHeader = By.xpath("//h6[normalize-space()='Dashboard']");
    private By adminMenu = By.xpath("//span[text()='Admin']");
    private By userManagement = By.xpath("//span[text()='User Management']");
    private By users = By.xpath("//a[contains(@href,'viewSystemUsers')]");
    private By userDropdown = By.xpath("//i[@class=\"oxd-icon bi-caret-down-fill oxd-userdropdown-icon\"]");
    private By logoutButton = By.xpath("(//a[normalize-space()=\"Logout\"])[1]");

    // ===== Actions =====

    /** Verifies if Dashboard is visible after login */
    public boolean isDashboardVisible() {
        try {
            System.out.println("Waiting for Dashboard header to be visible...");
            WebDriverWait localWait = new WebDriverWait(driver, Duration.ofSeconds(15));
            localWait.until(ExpectedConditions.visibilityOfElementLocated(dashboardHeader));

            WebElement header = driver.findElement(dashboardHeader);
            System.out.println("Dashboard found with text: " + header.getText());
            return header.isDisplayed();
        } catch (Exception e) {
            System.out.println("Dashboard not visible: " + e.getMessage());
            return false;
        }
    }



    /** Opens the user dropdown (top-right corner) */
    public void openUserDropdown() {
        try {
            wait.until(ExpectedConditions.visibilityOfElementLocated(userDropdown));
            WebElement dropdown = driver.findElement(userDropdown);
            dropdown.click();
            System.out.println("Opened user dropdown.");
        } catch (Exception e) {
            System.out.println("Failed to open user dropdown: " + e.getMessage());
        }
    }

    /** Clicks Logout from the user dropdown */
    public void logout() {
        try {
            wait.until(ExpectedConditions.visibilityOfElementLocated(logoutButton));
            WebElement logout = driver.findElement(logoutButton);
            logout.click();
            System.out.println("Clicked logout button.");
        } catch (Exception e) {
            System.out.println("Logout failed: " + e.getMessage());
        }
    }

    /** Navigates to Admin > User Management > Users */
    public void openUserManagement() {
        try {
            wait.until(ExpectedConditions.elementToBeClickable(adminMenu)).click();
            wait.until(ExpectedConditions.elementToBeClickable(userManagement)).click();
            wait.until(ExpectedConditions.elementToBeClickable(users)).click();
            System.out.println("Navigated to User Management > Users.");
        } catch (Exception e) {
            System.out.println("Failed to open User Management: " + e.getMessage());
        }
    }
}