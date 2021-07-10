package seleniumAllClasses.SelectIntro;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SelectPractice {
    @Test
    public void test1() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver=new ChromeDriver();
        driver.get("https://www.facebook.com/");
        WebElement createNew=driver.findElement(By.id("u_0_2"));
        createNew.click();
        Thread.sleep(2000);
        WebElement firstName=driver.findElement(By.name("firstname"));
        firstName.sendKeys("imir");
        WebElement lastName= driver.findElement(By.name("lastname"));
        lastName.sendKeys("fis");
        WebElement PhoneNum=driver.findElement(By.name("reg_email__"));
        PhoneNum.sendKeys("3324325435435564564");
        WebElement password=driver.findElement(By.id("password_step_input"));
        password.sendKeys("test1234");
        //mount.sendKeys("May");
//        selectMount.selectByVisibleText("May");
//        Thread.sleep(1000);
//        selectMount.selectByValue("2");
//        Thread.sleep(1000);
        WebElement mount=driver.findElement(By.id("month"));
        Select selectMount=new Select(mount);
        selectMount.selectByIndex(6);
        WebElement day= driver.findElement(By.id("day"));
        Select selectday=new Select(day);
        selectday.selectByValue("26");
        WebElement year=driver.findElement(By.id("year"));
        Select selectyear=new Select(year);
        selectyear.selectByVisibleText("1998");
        /*
        Task: Navigate to Facebook page and click create new account button
        // select the mount June using by index
        // select the day 26  using by value
        // select the year 1998 using by text
         */
    }
    @Test
    public void test2() throws InterruptedException{
        WebDriverManager.chromedriver().setup();
        WebDriver driver=new ChromeDriver();
        driver.get("https://www.facebook.com/");
        WebElement createNew=driver.findElement(By.id("u_0_2"));
        createNew.click();
        Thread.sleep(2000);
        WebElement mount=driver.findElement(By.id("month"));
        Select selectMount=new Select(mount);
        WebElement selectedOption = selectMount.getFirstSelectedOption();
        String actual = selectedOption.getText().toLowerCase();

        String expected = LocalDate.now().getMonth().toString().substring(0,3).toLowerCase();
        Assert.assertEquals(actual,expected);


    }
    @Test
    public void test3() throws InterruptedException{
        WebDriverManager.chromedriver().setup();
        WebDriver driver=new ChromeDriver();
        driver.get("https://www.facebook.com/");
        WebElement createNew=driver.findElement(By.id("u_0_2"));
        createNew.click();
        Thread.sleep(2000);
        WebElement mount=driver.findElement(By.id("month"));
        Select selectMount=new Select(mount);
        //getOption() --> returns all options under given select element. We
        //can store this method as List of webElements

        List<WebElement> options = selectMount.getOptions();
        ArrayList<String> actualOptions = new ArrayList<>();

        for(WebElement option:options){
            actualOptions.add(option.getText());
        }
        String [] expOptions={"Month","Jan","Feb","Mar","Apr","May","Jun","Jul","Aug","Sep","Oct","Nov","Dec"};
        List<String> expectedOptions=Arrays.asList(expOptions);

        Assert.assertEquals(actualOptions,expectedOptions);


    }

}
