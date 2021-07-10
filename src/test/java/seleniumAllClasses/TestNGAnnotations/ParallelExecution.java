package seleniumAllClasses.TestNGAnnotations;

import Utils.Driver;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class ParallelExecution {

    @BeforeMethod
    public void setup(){

        WebDriverManager.chromedriver().setup();

    }

    @Test
    public void test1() throws InterruptedException{
        WebDriver driver = Driver.getDriver("chrome");

        System.out.println("Executing test1");
        driver.get("https://amazon.com");
        Thread.sleep(1000);
        Assert.assertTrue(driver.getCurrentUrl().contains("amazon"));

    }

    @Test
    public void test2() throws InterruptedException{
        WebDriver driver = Driver.getDriver("chrome");

        System.out.println("Executing test2");
        driver.get("https://techtorialacademy.com");
        Thread.sleep(1000);
        Assert.assertTrue(driver.getCurrentUrl().contains("techtorial"));


    }


}
