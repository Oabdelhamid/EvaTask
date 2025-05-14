package POM;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.sql.Driver;
import java.time.Duration;

public class AddNewAdmin  extends pageObjectModel {
    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
     public AddNewAdmin (WebDriver driver){

        super(driver); ;
     }


    public AddNewAdmin addUserRole(){
            By addButton = By.cssSelector("div.orangehrm-header-container>button");
            driver.findElement(addButton).click();
            By UserRole = By.xpath("(//div[@class=\"oxd-select-wrapper\"])[1]");
            wait.until(driver -> driver.findElement(UserRole).isDisplayed());
            driver.findElement(UserRole).click();
            By Admin = By.xpath("//div/span[text()=\"Admin\"]");
            driver.findElement(Admin).click();
            return this;
        }

        public AddNewAdmin addUserStatus(){

            By Status = By.xpath("(//div[@class=\"oxd-select-wrapper\"])[2]");
            driver.findElement(Status).click();
            By Enabled = By.xpath("//div/span[text()=\"Enabled\"]");
            driver.findElement(Enabled).click();
            return this;
        }

        public AddNewAdmin addEmployeeName( String EmployName){
            By EmployeeName = By.xpath("//input[@placeholder=\"Type for hints...\"]");
            driver.findElement(EmployeeName).sendKeys(EmployName);
            By name = By.xpath("//div[@class=\"oxd-autocomplete-option\"]/span");
            wait.until(driver -> driver.findElement(name).isDisplayed());
            driver.findElement(name).click();

            return this;

        }


    public AddNewAdmin addUserNameAndPassword(String UserName, String password){


        By Password = By.xpath("//input[@wfd-id=\"id3\"]");
        wait.until(driver -> driver.findElement(Password).isDisplayed());
        driver.findElement(Password).sendKeys(password);
        By ConfirmPassword = By.xpath("//input[@wfd-id=\"id4\"]");
        wait.until(driver -> driver.findElement(ConfirmPassword).isDisplayed());
        driver.findElement(ConfirmPassword).sendKeys(password);

        By Name = By.xpath("//input[@wfd-id=\"id2\"]");
        wait.until(ExpectedConditions.visibilityOfElementLocated(Name));
        driver.findElement(Name).click();
        driver.findElement(Name).sendKeys(UserName);
        return this;
    }
    public AddNewAdmin AddSaveButton(){
        By SaveButton = By.xpath("//button[@type=\"submit\"]");
        driver.findElement(SaveButton).click();
        return this;
    }

    public boolean CheckIfUserAdded(){
        By UserAdded = By.xpath("//div[@role=\"alert\"]");
        return driver.findElement(UserAdded).isDisplayed();
    }


}
