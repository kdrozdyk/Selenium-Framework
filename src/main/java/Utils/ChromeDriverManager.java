package Utils;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class ChromeDriverManager extends DriverManager {

    @Override
    protected void setupWebDriver() {
        System.setProperty("webdriver.chrome.driver", "Resuorces");
        ChromeOptions options = new ChromeOptions();
        this.driver = new ChromeDriver(options);
    }
}
