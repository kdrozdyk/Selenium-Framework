package Test;

import Utils.DriverManager;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

// This is a Base structure for your tests. It should contain methods to set up and tear down your tests.

public class BaseTestModel {

    protected WebDriver driver;
    protected DriverManager driverManager;

    // Before suite classes will run before a suite of test scripts. Meaning this is a good spot to put the settings
    // that will be used to execute all of the tests that the suite contains.

    @BeforeSuite
    public void setupSuite(){
        // TODO : choose the driver you wish to use for your test suite by picking to related enum from
        // DriverManagerFactory.driverType
        //driverManager = DriverManangerFactory.getDriverManager(DriverManangerFactory.driverType.EDGE);
    }

    // Before method classes will run before EACH test. It should contain functions that you want to run before each test.
    // Typicly the best practice is to open your browser here. To avoid any errors you can use the created "if"
    // block to make sure that no other browser is open, optimazing the performance.

    @BeforeMethod
    public void setUpMethod(){
        // TODO : Start up your driver by using the getWebDriverMethod
        //if(driver == null){driver = new "driverManager";}
    }

    // After method will run after each test script. This usualy contains a function that closes the browser if open.

    @AfterMethod
    public void tearDown(){
        if (driver != null){
            driver.quit();
            driver = null;
        }
    }
}
