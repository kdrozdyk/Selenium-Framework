package Utils;

// A class that manages the different Driver Managers.

public class DriverManangerFactory {

    // By creating enums that identify each and every one of the available browsers in the framework we
    // enable the following method that using this identification runs one of the Manager classes.

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
