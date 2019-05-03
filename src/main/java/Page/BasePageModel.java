package Page;


import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BasePageModel {
    private WebDriver driver;

    public BasePageModel(WebDriver driver){
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
}
