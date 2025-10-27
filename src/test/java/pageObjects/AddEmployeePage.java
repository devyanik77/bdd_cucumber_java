package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class AddEmployeePage {
    WebDriver driver;
    public AddEmployeePage(WebDriver driver) { this.driver = driver; }

    private By addButton = By.xpath("//button[normalize-space()='Add']");
    private By firstName = By.name("firstName");
    private By lastName = By.name("lastName");
    private By saveButton = By.xpath("//button[normalize-space()='Save']");

    public void clickAdd() { driver.findElement(addButton).click(); }
    public void enterFirstName(String fname) { driver.findElement(firstName).sendKeys(fname); }
    public void enterLastName(String lname) { driver.findElement(lastName).sendKeys(lname); }
    public void clickSave() { driver.findElement(saveButton).click(); }
}
