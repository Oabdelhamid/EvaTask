package POM;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Dashbaord extends pageObjectModel {

    public Dashbaord(WebDriver driver){

        super(driver);
    }
    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));

   public Dashbaord NagivateToAdminPage(){
       By Admin = By.xpath("//span[text()='Admin']");
       wait.until(driver -> driver.findElement(Admin).isDisplayed());
       driver.findElement(Admin).click();
       wait.until(driver -> driver.findElement(By.cssSelector("div.orangehrm-horizontal-padding>span")).isDisplayed());
       return this;

   }

    public int NumberOfRecordsBeforeAddNewUser() {
        By NumberOfRecords = By.cssSelector("div.orangehrm-horizontal-padding>span");
        String recordsText = driver.findElement(NumberOfRecords).getText();
        String number = recordsText.replaceAll("[^0-9]", "");
        return Integer.parseInt(number);

    }

}
