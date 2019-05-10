package Utils;

import org.openqa.selenium.WebDriver;

// This is an abstract class containing the structure for Driver managers, which makes it easier to set up your
// browsers.

public abstract class DriverManager {
    protected WebDriver driver;
    protected abstract void setupWebDriver();
    public WebDriver getWebDriver(){
        if (driver == null){
            setupWebDriver();
        }
        return driver;
    }
}
