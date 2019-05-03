package Utils;

import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;

public class EdgeDriverManager extends DriverManager {
    @Override
    protected void setupWebDriver() {
        System.setProperty("webdriver.edge.driver", "Resources/msedgedriver.exe");
        EdgeOptions options = new EdgeOptions();
        this.driver = new EdgeDriver(options);
    }
}
