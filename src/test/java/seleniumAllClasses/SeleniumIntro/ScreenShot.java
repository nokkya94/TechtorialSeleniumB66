package seleniumAllClasses.SeleniumIntro;

import Utils.BrowserUtils;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Array;
import java.util.List;
import java.util.Map;

public class ScreenShot {

        WebDriver driver;

        @Test
        public void test1() throws IOException {
            WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver();
            driver.get("https://techtorial.com");

            File screenshot = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
            long timestamp = System.currentTimeMillis();
            //File destinationFolder = new File("src/test/java/seleniumAllClasses.SeleniumIntro/firstScreenshot-"+timestamp+".png");

            //FileUtils.copyFile(screenshot,destinationFolder);




        }

        @Test(testName = "my fav test")
        public void test2(){

            driver.get("https://google.com");
            driver.findElement(By.id("w"));

        }

        @AfterMethod
        public void tearDown(ITestResult result) throws IOException{
            if(!result.isSuccess()){
                try {
                    BrowserUtils.takeScreenSchot(driver, result.getTestName());
                }catch (IOException ex){
                    ex.printStackTrace();
                }

            }
        }




}
