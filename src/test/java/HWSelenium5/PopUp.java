package HWSelenium5;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.LocalDate;
import java.util.Iterator;
import java.util.Set;

public class PopUp {

    @Test
    public void popup(){

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();

        driver.get("http://www.popuptest.com/popuptest4.html");


        WebElement hoverMouseHere = driver.findElement(By.xpath("//a[@href='#']"));

        Actions actions = new Actions(driver);
        actions.moveToElement(hoverMouseHere).perform();

        String parentWindowHandle = driver.getWindowHandle();
        System.out.println("This is parent Window: "+parentWindowHandle);
        Set<String> allWindowHandles = driver.getWindowHandles();
        System.out.println("All windows: "+allWindowHandles);

        for(String id : allWindowHandles){
            if(!id.equals(parentWindowHandle)){
                driver.switchTo().window(id);
            }

        }
        Dimension initial_size = driver.manage().window().getSize();
        int height = initial_size.getHeight();
        int width = initial_size.getWidth();
        int size = width/height;
        System.out.println("The size is: "+width/height);
        Assert.assertTrue(size==3,"Size is not 3");

        String currentWindowTitle = driver.getTitle();
        System.out.println("Title is date :"+currentWindowTitle);
        LocalDate todayDate = LocalDate.now();
        System.out.println("This is date provided by Local Date method: "+todayDate);
        //I got a problem here todays date is 2020-10-30
        //and the title of the webpage is PopupTest Friday October, 30 2020
        //Assert.assertTrue(todayDate.equals(currentWindowTitle));
        String currentWindowURL = driver.getCurrentUrl();
        Assert.assertTrue(currentWindowURL.contains("popup9"));
        String currentWindowhHandle = driver.getWindowHandle();

        for (String id: allWindowHandles){
            if(!id.equals(parentWindowHandle)&&!id.equals(currentWindowhHandle)){
                driver.switchTo().window(id);
            }
        }

        String currentWindowURL2 = driver.getCurrentUrl();
        System.out.println(currentWindowURL2);
        Assert.assertTrue(currentWindowURL2.contains("popup10"));

    }

    @Test
    public void MultipleBlogSpot() throws InterruptedException{


        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("http://seleniumpractise.blogspot.com/2017/");
        WebElement facebook = driver.findElement(By.xpath("//a[.=' Click here for Facebook ']"));
        facebook.click();

        String parentWindowHandle = driver.getWindowHandle();
        Set<String> getAllWindows = driver.getWindowHandles();

        for(String id : getAllWindows){
            if(!id.equals(parentWindowHandle)){
                driver.switchTo().window(id);
            }
        }


        WebElement createNewAccountButton = driver.findElement(By.xpath("//a[@data-testid='open-registration-form-button']"));
        createNewAccountButton.click();
        System.out.println("i clicked on create New Account button");
        Thread.sleep(1000);
        WebElement fName = driver.findElement(By.id("u_1_b"));
        fName.sendKeys("Techtorial");
        Thread.sleep(1000);
        WebElement lName =driver.findElement(By.xpath("//input[@name='lastname']"));
        lName.sendKeys("Academy");
        Thread.sleep(1000);
        WebElement pNumber = driver.findElement(By.xpath("//input[@name='reg_email__']"));
        pNumber.sendKeys("2223334455");
        Thread.sleep(1000);
        WebElement thePassword = driver.findElement(By.xpath("//input[@name='reg_passwd__']"));
        thePassword.sendKeys("techtorial123");
        Thread.sleep(1000);
        WebElement monthDrpDown = driver.findElement(By.xpath("//select[@aria-label='Month']"));
        Select monthDropDwnBox =  new Select(monthDrpDown);
        monthDropDwnBox.selectByVisibleText("Apr");
        Thread.sleep(1000);
        WebElement dayDrpDown = driver.findElement(By.id("day"));
        Select dayDropDownBox = new Select(dayDrpDown);
        dayDropDownBox.selectByVisibleText("20");
        Thread.sleep(1000);
        WebElement yearDropDown = driver.findElement(By.xpath("//select[@aria-label='Year']"));
        Select yearDropDownBox = new Select(yearDropDown);
        yearDropDownBox.selectByVisibleText("2002");
        Thread.sleep(1000);
        WebElement gender = driver.findElement(By.id("u_1_4"));
        gender.click();

        driver.close();
        driver.switchTo().window(parentWindowHandle);
        String parentWindowTitle = driver.getTitle();
        System.out.println(parentWindowTitle);

        Assert.assertTrue(parentWindowTitle.equals("Selenium Practise: 2017"));
    }
}
