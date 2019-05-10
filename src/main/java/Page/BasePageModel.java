package Page;

import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


// Abstract class that should contain all communication with selenium. All of the Page Objects should extend this
// and override all abstract methods.

public abstract class BasePageModel {
    protected WebDriver driver;

    // Following function allows this class to be identified as a PageFactory allowing for easier navigation for your
    // tests

    protected BasePageModel(WebDriver driver){
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    // A function that fetches an element. It uses explicit wait and has a try/catch block that prevents failure of
    // your tests in case the element can not be found.

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

    // Function that fetches an element with previously created function "getElement" and later sends in
    // a string into the element. If the element is equal to null it will simply print a message in the console
    // and skip this step.

    public void type(final By locator, final String text , final int timeOut){
        WebElement element = getElement(locator, timeOut);
        if (element != null){
            element.sendKeys(text);
        }
        else {
            System.out.println(locator.toString() + "Has not been found");
        }
    }

    // This function fetches an element using the previously created function "getElement" and later
    // stimulates a mouse click on said element. If the element is equal to null it will simply print a
    // message in the console and skip this step.

    public void click(final By locator, final int timeOut){
        WebElement element = getElement(locator, timeOut);
        if (element != null){
            element.click();
        }
        else {
            System.out.println(locator.toString() + "Has not been found");
        }
    }

    // An abstract method that should be inherited by child classes. This should be overriden in each inheriting class
    // and the purpose is to have an function that checks if the page is fully loaded, to signal the tests to move on.

    public abstract boolean isLoaded();

}
