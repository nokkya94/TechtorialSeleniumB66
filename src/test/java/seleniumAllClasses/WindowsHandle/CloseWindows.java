package seleniumAllClasses.WindowsHandle;

import Utils.BrowserUtils;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class CloseWindows {

    @Test
    public void validateWindowClose(){
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();

        driver.get("http://www.popuptest.com/popuptest1.html");
        String parentId = driver.getWindowHandle(); // its giving parent window Id in string format

        BrowserUtils.closeWindows(driver,parentId);

        System.out.println(driver.getCurrentUrl());


    }
}
