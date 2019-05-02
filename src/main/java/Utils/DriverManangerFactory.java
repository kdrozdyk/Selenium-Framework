package Utils;

public class DriverManangerFactory {
    public static DriverManager getDriverManager(DriverManager.driverType type){
        DriverManager driverManager;
        switch (type){
            case CHROME:
                driverManager = new ChromeDriverManager();
                break;
            case OPERA:
                driverManager = new OperaDriverManager();
                break;
            case FIREFOX:
                driverManager = new FirefoxDriverManager();
                break;
            default:
                driverManager = new FirefoxDriverManager();
                break;
        }
        return driverManager;
    }
}
