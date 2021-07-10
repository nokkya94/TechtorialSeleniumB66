package seleniumAllClasses.Synchronization;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;

public class FluentWaitIntro {

    WebDriver driver;



    @BeforeMethod
    public void setup(){



        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();

    }


    @Test
    public void test1(){

        driver.get("https://google.com");
        Wait<WebDriver> fluentWait = new FluentWait<WebDriver>(driver)
                .pollingEvery(Duration.ofSeconds(2))
                .withMessage("The element has not been located yet")
                .withTimeout(Duration.ofSeconds(20))
                .ignoring(Exception.class);


        WebElement loginButton = fluentWait.until(myDriver -> myDriver.findElement(By.id("randomId")));
        //any interfaces that have only one abstract method are called functional interface
        //and lambda "->" its used there
    }

}
