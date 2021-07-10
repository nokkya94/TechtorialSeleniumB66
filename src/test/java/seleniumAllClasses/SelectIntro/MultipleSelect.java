package seleniumAllClasses.SelectIntro;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

public class MultipleSelect {
    @Test
    public void testA() throws InterruptedException{
        WebDriverManager.chromedriver().setup();
        WebDriver driver=new ChromeDriver();

        driver.get("https://mdbootstrap.com/docs/jquery/forms/multiselect/");

        WebElement dropDown = driver.findElement(By.xpath("//select[starts-with(@class , 'custom-select')]"));
        Select select = new Select(dropDown);
        select.deselectAll();
        select.selectByValue("2");
        Thread.sleep(1000);
        select.selectByVisibleText("Three");
        Thread.sleep(1000);
        select.selectByIndex(1);
        Thread.sleep(1000);
        select.deselectByIndex(3);
        Thread.sleep(1000);
        select.deselectByValue("2");
        Thread.sleep(1000);
        select.deselectByVisibleText("One");
    }
    @Test
    public void Task() throws  InterruptedException{
        WebDriverManager.chromedriver().setup();
        WebDriver driver=new ChromeDriver();

        driver.get("https://www.google.com/");
        WebElement searchBox = driver.findElement(By.name("q"));
        searchBox.sendKeys("Selenium");
        WebElement searchButton = driver.findElement(By.xpath("//div[@class='tfB0Bf']//input[@class='gNO89b']"));
        searchButton.click();
        Thread.sleep(1000);

    }
}
