package hooks;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class Hooks {
    public static WebDriver driver;

    @Before
    public void setUp() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--start-maximized")
                .addArguments("--no-sandbox")
                .addArguments("--disable-dev-shm-usage")
                .addArguments("--disable-gpu")
                .addArguments("--disable-popup-blocking")
                .addArguments("--lang=en")
                .addArguments("--window-size=1920,1080");

        driver = new ChromeDriver(options);
    }

    @After
    public void tearDown(Scenario scenario) {
        if (scenario.isFailed()) {
            TakesScreenshot ts = (TakesScreenshot) driver;
            byte[] screenshot = ts.getScreenshotAs(OutputType.BYTES);
            scenario.attach(screenshot, "image/png", "screenshot");

            // Save screenshot to disk
            File file = ts.getScreenshotAs(OutputType.FILE);
            try {
                // Ensure the screenshots directory exists
                File dir = new File("screenshots");
                if (!dir.exists()) {
                    dir.mkdirs();
                }
                // Copy screenshot to the disk with the scenario name
                Files.copy(file.toPath(), Paths.get("screenshots", scenario.getName() + ".png"));
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        driver.quit();
    }
}
