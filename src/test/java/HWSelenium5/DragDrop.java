package HWSelenium5;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class DragDrop {

    @Test
    public void task1() throws InterruptedException{

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();

        driver.get("https://demos.telerik.com/kendo-ui/dragdrop/area");
        driver.manage().window().maximize();
        WebElement blueCircle = driver.findElement(By.xpath("//div[@id='draggable']"));
        WebElement someElementFromTheLeft = driver.findElement(By.xpath("//a[@class='kd-link active']"));
        WebElement blueSquare = driver.findElement(By.xpath("//div[@class='test1']"));
        WebElement orangeSquare = driver.findElement(By.xpath("//div[@class='test2']"));
        System.out.println(blueSquare.getText());//the xpath is correct
        Thread.sleep(1000);
        Actions actionsBlCircle = new Actions(driver);

        actionsBlCircle.clickAndHold(blueCircle).moveToElement(someElementFromTheLeft).perform();
        Thread.sleep(1000);
        Thread.sleep(1000);
        WebElement blueSquare1 = driver.findElement(By.xpath("//div[@class='test1']"));
        WebElement orangeSquare1 = driver.findElement(By.xpath("//div[@class='test2']"));
        Assert.assertTrue(blueSquare1.getText().equals("(Drop Here)")&&orangeSquare1.getText().equals("(Drop Here)"));

    }

    @Test
    public void testcase2() throws InterruptedException{

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();

        driver.get("https://demos.telerik.com/kendo-ui/dragdrop/area");
        driver.manage().window().maximize();
        WebElement blueCircle = driver.findElement(By.xpath("//div[@id='draggable']"));

        WebElement blueSquare = driver.findElement(By.xpath("//div[@class='test1']"));
        WebElement orangeSquare = driver.findElement(By.xpath("//div[@class='test2']"));


        Actions actionsBlCircle = new Actions(driver);
        Thread.sleep(1000);
        actionsBlCircle.clickAndHold(blueCircle).moveToElement(blueSquare).perform();
        Thread.sleep(1000);
        WebElement blueSquare1 = driver.findElement(By.xpath("//div[@class='test1']"));
        WebElement orangeSquare1= driver.findElement(By.xpath("//div[@class='test2']"));

        Assert.assertTrue(blueSquare1.getText().equals("Now you can drop it.")&&orangeSquare1.getText().equals("(Drop Here)"));
    }

    @Test
    public void testcase3() throws  InterruptedException{

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();

        driver.get("https://demos.telerik.com/kendo-ui/dragdrop/area");
        driver.manage().window().maximize();
        WebElement blueCircle = driver.findElement(By.xpath("//div[@id='draggable']"));
        WebElement blueSquare = driver.findElement(By.xpath("//div[@class='test1']"));
        WebElement orangeSquare = driver.findElement(By.xpath("//div[@class='test2']"));

        Actions actionsBlCircle = new Actions(driver);
        Thread.sleep(1000);
        actionsBlCircle.clickAndHold(blueCircle).moveToElement(orangeSquare).perform();
        Thread.sleep(1000);

        Assert.assertTrue(blueSquare.getText().equals("(Drop Here)")&&orangeSquare.getText().equals("Now you can drop it."));

    }
}
