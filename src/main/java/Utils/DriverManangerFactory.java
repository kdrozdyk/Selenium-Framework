package Utils;

public class DriverManangerFactory {

    public enum driverType{CHROME, EDGE, FIREFOX;}
    public static DriverManager getDriverManager(driverType type){
        DriverManager driverManager;
        switch (type){
            case CHROME:
                driverManager = new ChromeDriverManager();
                break;
            /*case EDGE:
                driverManager = new EdgeDriverManager();
                break;*/
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
