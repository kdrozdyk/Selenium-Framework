package Utils;

import org.openqa.selenium.opera.OperaDriver;
import org.openqa.selenium.opera.OperaOptions;

public class OperaDriverManager extends DriverManager {
    @Override
    public void setupWebDriver() {
        System.setProperty("webdriver.opera.driver", "Resources/operadriver.exe");
        OperaOptions options = new OperaOptions();
        this.driver = new OperaDriver(options);
    }
}
