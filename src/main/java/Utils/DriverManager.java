package Utils;

import org.openqa.selenium.WebDriver;

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
