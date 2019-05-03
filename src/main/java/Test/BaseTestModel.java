package Test;

import Utils.DriverManager;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

public class BaseTestModel {

    protected WebDriver driver;
    protected DriverManager driverManager;

    @BeforeSuite
    public void setupSuite(){
        // TODO : choose the driver you wish to use for your test suite by picking to related enum from
        // DriverManagerFactory.driverType
        //driverManager = DriverManangerFactory.getDriverManager(DriverManangerFactory.driverType.EDGE);
    }

    @BeforeMethod
    public void setUpMethod(){
        // TODO : Start up your driver by using the getWebDriverMethod
        //if(driver == null){driver = new "driverManager";}
    }

    @AfterMethod
    public void tearDown(){
        if (driver != null){
            driver.quit();
            driver = null;
        }
    }
}
