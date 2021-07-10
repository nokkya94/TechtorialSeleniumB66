package cucumber_class.ActionsPractice;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class DragAndDropPractice {
    @Test
    public void validateDragAndDrop(){

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();

        driver.get("https://demos.telerik.com/kendo-ui/dragdrop/index");

        WebElement source=driver.findElement(By.id("draggable"));
        WebElement target=driver.findElement(By.id("droptarget"));

        Actions actions = new Actions(driver);

        actions.clickAndHold(source).moveToElement(target).release(target).perform();

        String actual = target.getText();
        String expected = "You did great";
        Assert.assertEquals(actual,expected);


    }
    @Test
    public void validateDragAndDropMethod(){
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();

        driver.get("https://demos.telerik.com/kendo-ui/dragdrop/index");

        WebElement source=driver.findElement(By.id("draggable"));
        WebElement target=driver.findElement(By.id("droptarget"));

        Actions actions = new Actions(driver);

        actions.dragAndDrop(source,target).perform();




    }
    @Test
    public void drgDropTask(){
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("https://demos.telerik.com/kendo-ui/dragdrop/area");

        WebElement source = driver.findElement(By.xpath("//*[@id=\"draggable\"]"));
        WebElement target = driver.findElement(By.xpath("//*[@id=\"droptarget\"]/div[2]"));

        Actions actions = new Actions(driver);

        actions.dragAndDrop(source,target).perform();
        String expected = "You did great!";
        WebElement actual = driver.findElement(By.xpath("//*[@id=\"droptarget\"]/div[2]"));
        String actualstr= actual.getText();
        System.out.println(actualstr);
        Assert.assertEquals(actual.getText(),expected);
    }

}
