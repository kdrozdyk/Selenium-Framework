package Test;

import Utils.DriverManager;
import Utils.DriverManangerFactory;
import Utils.FirefoxDriverManager;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

public class test extends BaseTestModel {
    @Test
    public void test(){
        driverManager = DriverManangerFactory.getDriverManager(DriverManager.driverType.FIREFOX);
        driver = driverManager.setupWebDriver();
        driver.get("google.se");
    }

}
