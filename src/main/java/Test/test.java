package Test;

import Utils.DriverManager;
import Utils.DriverManangerFactory;
import Utils.FirefoxDriverManager;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

public class test extends BaseTestModel {
    @Test
    public void test(){
        driverManager = DriverManangerFactory.getDriverManager(DriverManangerFactory.driverType.EDGE);
        driver = driverManager.getWebDriver();
        driver.get("https://www.google.se");
    }

}
