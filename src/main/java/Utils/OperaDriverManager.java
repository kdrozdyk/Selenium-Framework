package Utils;

import org.openqa.selenium.opera.OperaDriver;
import org.openqa.selenium.opera.OperaOptions;

public class OperaDriverManager extends DriverManager {
    @Override
    protected void setupWebDriver() {
        OperaOptions options = new OperaOptions();
        this.driver = new OperaDriver(options);
    }
}
