package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class AddUserPage {
    WebDriver driver;
    public AddUserPage(WebDriver driver) { this.driver = driver; }

    private By addButton = By.xpath("//button[normalize-space()='Add']");
    private By employeeName = By.xpath("//input[@placeholder='Type for hints...']");
    private By username = By.xpath("(//input[@class='oxd-input oxd-input--active'])[2]");
    private By password = By.xpath("(//input[@type='password'])[1]");
    private By confirmPassword = By.xpath("(//input[@type='password'])[2]");
    private By saveButton = By.xpath("//button[normalize-space()='Save']");

    public void clickAdd() { driver.findElement(addButton).click(); }
    public void enterEmployeeName(String name) { driver.findElement(employeeName).sendKeys(name); }
    public void enterUsername(String uname) { driver.findElement(username).sendKeys(uname); }
    public void enterPassword(String pwd) { driver.findElement(password).sendKeys(pwd); }
    public void confirmPassword(String pwd) { driver.findElement(confirmPassword).sendKeys(pwd); }
    public void clickSave() { driver.findElement(saveButton).click(); }
}
