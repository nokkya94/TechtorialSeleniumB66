package seleniumAllClasses.WindowsHandle;

import Utils.BrowserUtils;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class BrowserMethods {

    @Test
    public void validateSwitchUrl(){

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();

        driver.get("http://www.popuptest.com/popuptest1.html");

        BrowserUtils.switchByUrl(driver,"http://www.popuptest.com/popup6.html");

        System.out.println(driver.getCurrentUrl());
    }


}
