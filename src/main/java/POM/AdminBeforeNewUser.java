package POM;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class AdminBeforeNewUser {
    WebDriver driver ;
    public AdminBeforeNewUser(WebDriver driver){
        this.driver = driver ;
    }

    public int NumberOfRecordsBeforeAddNewUser() {
        By NumberOfRecords = By.cssSelector("div.orangehrm-horizontal-padding>span");
        String recordsText = driver.findElement(NumberOfRecords).getText();
        String number = recordsText.replaceAll("[^0-9]", "");
        return Integer.parseInt(number);

    }

}
