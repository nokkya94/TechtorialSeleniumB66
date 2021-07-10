package seleniumAllClasses.TestNGAnnotations;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class ParallelExecution2 {

    @Test
    @Parameters("url")// name is url from testNg file class
    public void navigateToUrl(String myFavUrl){  //string myFavUrl is value from testng file
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.get("https://" + myFavUrl + ".com");
        Assert.assertTrue(driver.getCurrentUrl().contains(myFavUrl));
    }






}
