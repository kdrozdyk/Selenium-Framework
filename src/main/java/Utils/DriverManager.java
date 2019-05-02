package Utils;

import org.openqa.selenium.WebDriver;

public abstract class DriverManager {
    protected WebDriver driver;
    public enum driverType{CHROME, OPERA, FIREFOX;}
    public abstract void setupWebDriver();
}
