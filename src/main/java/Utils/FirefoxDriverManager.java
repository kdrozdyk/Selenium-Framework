package Utils;

import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

public class FirefoxDriverManager extends DriverManager{
    @Override
    public void setupWebDriver() {
        System.setProperty("webdriver.gecko.driver", "Resources/geckodriver.exe");
        FirefoxOptions options = new FirefoxOptions();
        this.driver = new FirefoxDriver(options);
    }
}
