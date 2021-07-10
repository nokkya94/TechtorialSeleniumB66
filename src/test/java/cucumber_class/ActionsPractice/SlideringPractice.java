package cucumber_class.ActionsPractice;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

public class SlideringPractice {
    @Test
    public void slider() {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://demos.telerik.com/kendo-ui/slider/angular");

        WebElement redCircle = driver.findElement(By.xpath("//div[contains(@class, 'vertical')]//a[@role='slider']"));

        WebElement ten = driver.findElement(By.xpath("//div[contains(@class, 'vertical')]//li[@title='10']"));
        WebElement zero = driver.findElement(By.xpath("//div[contains(@class, 'vertical')]//li[@title='0']"));

        org.openqa.selenium.Point tenPoint = ten.getLocation();
        Point zeroPoint = zero.getLocation();
        System.out.println(tenPoint.getY());
        System.out.println(zeroPoint.getY());
        System.out.println(tenPoint.getY() - zeroPoint.getY());//we got the distance betbween them is -88

        Actions actions = new Actions(driver);
        actions.clickAndHold(redCircle)
                .moveByOffset(0, -25)
                .release()
                .perform();


        System.out.println("===========================================");
    }
    @Test
    public void secondSlide(){
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://demos.telerik.com/kendo-ui/slider/angular");

        WebElement redCircleX = driver.findElement(By.xpath("//div[contains(@class, 'horizontal')]//a[@role='slider']"));
        WebElement tenX = driver.findElement(By.xpath("//div[contains(@class, 'horizontal')]//li[@title='10']"));
        WebElement zeroX = driver.findElement(By.xpath("//div[contains(@class, 'horizontal')]//li[@title='0']"));
        Point tenPointX = tenX.getLocation();
        Point zeroPointX = zeroX.getLocation();

        System.out.println(tenPointX.getX());
        System.out.println(zeroPointX.getX());
        System.out.println(tenPointX.getX()- zeroPointX.getX());//we got the distance betbween them is -88
        int difference = tenPointX.getX()- zeroPointX.getX();

        Actions actionsX = new Actions(driver);
        actionsX.clickAndHold(redCircleX)
                .moveByOffset(difference+5,0)
                .release()
                .perform();

    }
}
