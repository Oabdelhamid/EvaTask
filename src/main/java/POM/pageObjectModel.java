package POM;

import org.openqa.selenium.WebDriver;

    public abstract class pageObjectModel {
        WebDriver driver;

        public pageObjectModel (WebDriver driver) {
            this.driver = driver ;
        }
}
