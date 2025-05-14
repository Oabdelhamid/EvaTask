package hooks;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

public class Hooks {
 public static WebDriver driver;




    @Before
    public void setUp() {
        ChromeOptions options = new ChromeOptions();
        options
                .addArguments("--start-maximized")
                .addArguments("--no-sandbox")
                .addArguments("--disable-dev-shm-usage")
                .addArguments("--disable-gpu")
                .addArguments("--disable-popup-blocking")
                //.addArguments("--headless=new")
                . addArguments("--window-size=1920,1080");

       driver = new ChromeDriver(options);



    }

    @After
    public void tearDown() {
        driver.quit();

    }


}
