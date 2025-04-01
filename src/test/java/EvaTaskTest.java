import POM.Login;
import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class EvaTaskTest {
    WebDriver driver ;
  @BeforeMethod
    public void setup(){
      ChromeOptions options = new ChromeOptions();
      options.enableBiDi().addArguments("Start-maximized");
      driver = new ChromeDriver(options);

  }

  @AfterMethod
    public void TearDown(){
    driver.quit();

  }

  @Test
    public void Navigate(){

     new Login(driver).Negative().AddUsernameAndPassword("Admin","admin123").ClickLoginButton();


  }


}
