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
    protected WebDriver driver;
    protected BasePageModel(WebDriver driver){
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    public WebElement getElement(final By locator, int timeOut){
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
    public void sendDate(final By locator, final int timeOut, DateUtils.period period, String format){
        String date = "";
        WebElement element = getElement(locator, timeOut);
        date = DateUtils.returnTheDate(period, format);
        if (element != null && date != ""){
            element.sendKeys(date);
        }
        else {
            System.out.println("Please check that the path to the element is correct and every input is correct.    ");
        }
    }
    public abstract boolean isLoaded();
}
