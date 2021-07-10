package seleniumAllClasses.iFrames;

import Utils.BrowserUtils;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class FrameTest {

    WebDriver driver;



    //BeforeClass annotation will run before Test
    //and BeforeMethod annotations inside the class
    @BeforeClass
    public void initializeDriver(){
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        //it will maximize the window
        driver.manage().window().maximize();

    }

    @Test
    public void test1(){

        driver.get("https://skpatro.github.io/demo/iframes/");
        String idOfParentPage = driver.getWindowHandle();

        driver.switchTo().frame("Framename1");
        WebElement category1= driver.findElement(By.xpath("//a[.='Category1']"));
        category1.click();

        String newUrl = "http://qavalidation.com/category/seleniumtesting/";
        BrowserUtils.switchByUrl(driver,newUrl);
        System.out.println(driver.getTitle());

        //we are inside the main page
        BrowserUtils.switchByID(driver,idOfParentPage);
        //we need to switch to the second frame to click category 3 button
        driver.switchTo().frame("Frame2");
        WebElement category3=driver.findElement(By.xpath("//a[.='Category3']"));
        category3.click();

        BrowserUtils.switchByUrl(driver,"http://qavalidation.com/category/softwaretesting/");
        System.out.println(driver.getCurrentUrl());

    }

}
