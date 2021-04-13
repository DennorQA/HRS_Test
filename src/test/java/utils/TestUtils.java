package utils;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class TestUtils {

    public static void click(WebDriverWait wait, WebElement element) {
        wait.until(ExpectedConditions.visibilityOf(element));
        wait.until(ExpectedConditions.elementToBeClickable(element)).click();
    }

    public static void inputKeys(WebDriverWait wait, WebElement element, String keys) {
        wait.until(ExpectedConditions.visibilityOf(element));
        element.sendKeys(keys);
    }

    public static void elementVisibility(WebDriverWait wait, WebElement element) {
        wait.until(ExpectedConditions.visibilityOf(element));
    }

    public static Boolean elementIsClickable(WebDriverWait wait, WebElement element) {
        try
        {
            wait.until(ExpectedConditions.elementToBeClickable(element));
            return true;
        }
        catch (Exception e)
        {
            return false;
        }
    }
}