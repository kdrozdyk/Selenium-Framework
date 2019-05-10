package Utils;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class ChromeDriverManager extends DriverManager {

    // This class contains settings for ChromeDriver which you will invoke to run your tests in Google Chrome

    @Override
    public void setupWebDriver() {
        System.setProperty("webdriver.chrome.driver", "Resources/chromedriver.exe");
        ChromeOptions options = new ChromeOptions();
        this.driver = new ChromeDriver(options);
    }
}
