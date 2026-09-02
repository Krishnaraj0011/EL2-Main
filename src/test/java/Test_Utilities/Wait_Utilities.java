package Test_Utilities;

import java.time.Duration;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.ElementClickInterceptedException;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Wait_Utilities {

    public static WebDriver driver;
    WebDriverWait wait;

    public Wait_Utilities(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        PageFactory.initElements(driver, this);
    }

    // Wait until element is clickable
    public void waitForClickable(WebElement element) {
        wait.until(ExpectedConditions.elementToBeClickable(element));
    }

    // Wait until element is visible
    public void waitForVisible(WebElement element) {
        wait.until(ExpectedConditions.visibilityOf(element));
    }
    
    public void Hardwait(int i) throws InterruptedException
    {
    	Thread.sleep(i);
    }
   
    public void clickWithStaleRetry(WebElement element, Object page) {

        for (int i = 0; i < 3; i++) {

            try {
                wait.until(ExpectedConditions.elementToBeClickable(element));
                element.click();
                return;

            } catch (StaleElementReferenceException e) {

                //System.out.println("Stale element. Retrying...");

            } catch (ElementClickInterceptedException e) {

               // System.out.println("Element click intercepted. Retrying...");
            }
        }

        throw new RuntimeException("Element could not be clicked");
    }
    
    public void switchToFrameWithRetry(WebElement frame, Object pageObject) {

        for (int i = 0; i < 3; i++) {
            try {
                wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(frame));
                return;

            } catch (StaleElementReferenceException e) {
                //System.out.println("Frame is stale. Retrying...");
                PageFactory.initElements(driver, pageObject);
            }
        }

        throw new RuntimeException("Unable to switch to frame");
    }

}
