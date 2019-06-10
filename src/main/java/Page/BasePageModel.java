package Page;

import Utils.DateUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public abstract class BasePageModel {
    private WebDriver driver;
    protected BasePageModel(WebDriver driver){
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    private WebElement getElement(final By locator, int timeOut){
        WebElement returnElement;
        if(timeOut < 0 || timeOut > 15){
            timeOut = 15;
        }
        WebDriverWait wait = new WebDriverWait(driver, timeOut);
        try {
            wait.until(ExpectedConditions.elementToBeClickable(locator));
            returnElement = driver.findElement(locator);
        }
        catch (TimeoutException e){
            returnElement = null;
        }
        return returnElement;
    }

    public void type(final By locator, final String text , final int timeOut){
        WebElement element = getElement(locator, timeOut);
        if (element != null){
            element.sendKeys(text);
        }
        else {
            System.out.println(locator.toString() + "Has not been found");
        }
    }

    public void click(final By locator, final int timeOut){
        WebElement element = getElement(locator, timeOut);
        if (element != null){
            element.click();
        }
        else {
            System.out.println(locator.toString() + "Has not been found");
        }
    }

    /**
     *
     * @param locator Is the path to the element you are trying to reach
     * @param timeOut Is the time limit in seconds of how long the browser will hold before throwing an error
     * @param period Is an Enum with values of TODAY, TOMORROW and WEEK
     * @param format Is the format that you want the date in
     */
    public void sendDate(final By locator, final int timeOut, DateUtils.period period, String format){
        WebElement element = getElement(locator, timeOut);
        String date = DateUtils.returnTheDate(period, format);
        if (element != null && !"".equals(date)){
            element.sendKeys(date);
        }
        else {
            System.out.println("Please check that the path to the element is correct and every input is correct.    ");
        }
    }
    public void sendDate(final By locator, final int timeOut, DateUtils.period period){
        WebElement element = getElement(locator, timeOut);
        String date = DateUtils.returnTheDate(period);
        if (element != null && !"".equals(date)){
            element.sendKeys(date);
        }
        else {
            System.out.println(locator.toString() + "Has not been found");
        }
    }

    /**
     * This method will send todays date in format dd-MM-yyyy
     */
    public void sendTodaysDate(final By locator, final int timeOut){
        WebElement element = getElement(locator, timeOut);
        String date = DateUtils.getTodaysDate();
        if (element != null){
            element.sendKeys(date);
        }
        else {
            System.out.println(locator.toString() + "Has not been located");
        }
    }
    public abstract boolean isLoaded();
}
