package POM;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class  Login extends pageObjectModel  {

     public Login(WebDriver driver) {
         super(driver);
     }
    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));

    public Login Negative(){
       driver.navigate().to("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
        wait.until(driver -> driver.findElement(By.xpath("//input[@name=\"username\"]")).isDisplayed());

    return this;
    }

    public Login AddUsernameAndPassword(String username, String password){
        driver.findElement(By.xpath("//input[@name=\"username\"]")).sendKeys(username);
        driver.findElement(By.xpath("//input[@name='password']")).sendKeys(password);
        return this;

    }
    public Login ClickLoginButton(){
        driver.findElement(By.xpath("//button[@type='submit']")).click();
        wait.until(driver -> driver.findElement(By.xpath("//span[text()='Admin']")).isDisplayed());
        return this;
    }

    }
