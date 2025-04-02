package POM;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class AdminAfterNewUser {
    WebDriver driver ;
    public AdminAfterNewUser(WebDriver driver){
        this.driver = driver ;
    }
    public int NumberOfRecordsAfterAddNewUser() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        By NumberOfRecords = By.cssSelector("div.orangehrm-horizontal-padding>span");
        wait.until(driver -> driver.findElement(NumberOfRecords).isDisplayed());
        String recordsText = driver.findElement(NumberOfRecords).getText();
        String number = recordsText.replaceAll("[^0-9]", "");
        return Integer.parseInt(number);
    }

    public AdminAfterNewUser SearchForUserName(String UserName){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        By inputSearch = By.xpath("//input[@wfd-id=\"id1\"]");
        wait.until(driver -> driver.findElement(inputSearch).isDisplayed());
        driver.findElement(inputSearch).sendKeys(UserName);
        By SearchButton = By.cssSelector("//button[@type=\"submit\"]");
        driver.findElement(SearchButton).click();
        return this;
    }
    public AdminAfterNewUser DeleteNewUser(){
        By Trash = By.cssSelector("i.oxd-icon.bi-trash");
        driver.findElement(Trash).click();
        By ConfirmDelete = By.xpath("//Button[contains(@class,\"label-danger\")]/i");
        driver.findElement(ConfirmDelete).click();
        return this;
    }
    public int NumberOfRecordsAfterDeleteNewUser() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        By NumberOfRecords = By.cssSelector("div.orangehrm-horizontal-padding>span");
        wait.until(driver -> driver.findElement(NumberOfRecords).isDisplayed());
        String recordsText = driver.findElement(NumberOfRecords).getText();
        String number = recordsText.replaceAll("[^0-9]", "");
        return Integer.parseInt(number);
    }

}
