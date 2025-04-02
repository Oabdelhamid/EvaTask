import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

public class Testcase {

    WebDriver driver ;
    @BeforeClass
    public void setup(){
        ChromeOptions options = new ChromeOptions();
        options.enableBiDi().addArguments("Start-maximized");
        driver = new ChromeDriver(options);

    }

    @AfterClass
    public void TearDown(){
        driver.quit();

    }
}
