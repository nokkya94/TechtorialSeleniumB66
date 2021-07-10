package Utils;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;

import java.io.File;
import java.io.IOException;
import java.util.Set;

public class BrowserUtils {

    public static void closeWindows(WebDriver driver, String parentWindowId) {

        Set<String> ids = driver.getWindowHandles();
        for (String id : ids) {

            if (!id.equals(parentWindowId)) {

                driver.switchTo().window(id);
                driver.close();
            }
        }
        driver.switchTo().window(parentWindowId);

    }

    /*
    this method will switch the driver to the new window
    until finding the given url
     */
    public static void switchByUrl(WebDriver driver, String targetUrl) {

        Set<String> ids = driver.getWindowHandles();
        for (String id : ids) {
            if (driver.getCurrentUrl().equals(targetUrl)) {
                driver.switchTo().window(id);
            }
        }
    }


    public static void swithchByTitle(WebDriver driver, String targetTtile) {

        Set<String> ids = driver.getWindowHandles();
        for (String id : ids) {
            if (!driver.getTitle().equals(targetTtile)) {
                driver.switchTo().window(id); //function for switching the driver
            }
        }


    }

    public static void switchByID(WebDriver driver, String pageid) {

        Set<String> ids = driver.getWindowHandles();
        for (String id : ids) {
            if (id.equals(pageid)) {
                driver.switchTo().window(id); //function for switching the driver
            }
        }

    }

    public static void scrollIntoView(WebDriver driver, WebElement element) {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView(true)", element);
    }

    public static void hoverOver(WebDriver driver, WebElement element) {
        Actions actions = new Actions(driver);
        actions.moveToElement(element).perform();
    }

    public static void click(WebDriver driver, WebElement element) {
        Actions actions = new Actions(driver);
        actions.click(element).perform();
    }

    public static void jsClick(WebDriver driver, WebElement element) {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].click()", element);
    }

    public static void takeScreenSchot(WebDriver driver, String testCaseName) throws IOException {

        File file = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        long timestamp = System.currentTimeMillis();
        File destinationDir = new File("screenshots/"+ testCaseName +"_"+ timestamp + ".png");
        FileUtils.copyFile(file, destinationDir);

    }


}
