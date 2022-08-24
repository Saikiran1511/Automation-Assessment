package utils;

import base.TestBase;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class UIUtils extends TestBase {

    WebDriver driver;

    public UIUtils(WebDriver driver){
        super(driver);
        this.driver = driver;
    }

    public void waitAndClickElement(WebElement element){
        WebDriverWait wait;
        JavascriptExecutor executor = (JavascriptExecutor)driver;
        try{
            wait = new WebDriverWait(driver, Duration.ofSeconds(10));
            wait.until(ExpectedConditions.visibilityOf(element));
            executor.executeScript("arguments[0].click();", element);
        }
        catch(Exception e)
        {
            throw e;
        }
    }

    public void waitAndSetText(WebElement element, String value){
        WebDriverWait wait;
        try{
            wait = new WebDriverWait(driver, Duration.ofSeconds(10));
            wait.until(ExpectedConditions.visibilityOf(element));
            element.sendKeys(value);
        }
        catch(Exception e)
        {
            throw e;
        }
    }

    public String getElementText(WebElement element){
        WebDriverWait wait;
        String text = "";
        try{
            wait = new WebDriverWait(driver, Duration.ofSeconds(10));
            wait.until(ExpectedConditions.visibilityOf(element));
            text = element.getText();
        }
        catch(Exception e)
        {
            throw e;
        }
        return text;
    }



    public boolean isElementVisible(WebElement element) {
        boolean isVisible = false;
        try {
            isVisible = element.isDisplayed();

        } catch (Exception e) {
            e.printStackTrace();
        }
        return isVisible;
    }
}
