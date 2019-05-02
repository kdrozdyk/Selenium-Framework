package Test;

import Utils.DriverManager;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class BaseTestModel {

    protected WebDriver driver;
    protected DriverManager driverManager;
/*
    @BeforeMethod
    public void setUp(){
        //System.setProperty("driver", "location");
        //driver = new "driver";
    }
*/
    @AfterMethod
    public void tearDown(){
        if (driver != null){
            driver.quit();
        }
    }
}
