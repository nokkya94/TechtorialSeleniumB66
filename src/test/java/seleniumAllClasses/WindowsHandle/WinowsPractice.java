package seleniumAllClasses.WindowsHandle;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Set;

public class WinowsPractice {

    @Test
    public void validate(){

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();

        driver.get("https://the-internet.herokuapp.com/windows");

        WebElement clickHere = driver.findElement(By.xpath("//a[.='Click Here']"));

        clickHere.click();


        String currentPageId = driver.getWindowHandle();
        Set<String> ids = driver.getWindowHandles();

        for (String id : ids){
            if(id.equals(currentPageId)){
                //it will switch the new window
                driver.switchTo().window(id);
            }
        }
        //it will throw stale element exception since we switch driver to the new window
        WebElement clickButton = driver.findElement(By.xpath("//a[.='Click Here']"));
        clickButton.click();

        WebElement newWindowText = driver.findElement(By.tagName("h3"));
        System.out.println("Text from new window: "+newWindowText.getText());

        Assert.assertEquals(newWindowText.getText(),"New Window");

        driver.switchTo().window(currentPageId);

        WebElement parentPageText = driver.findElement(By.tagName("h3"));
        System.out.println("Text from parent Window: "+parentPageText.getText());
    }

    @Test
    public void validateNewWindows(){
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();

        driver.get("http://www.popuptest.com/popuptest12.html");

        String parentWindow = driver.getWindowHandle();
        Set<String> ids = driver.getWindowHandles();

        for(String handle : ids) {
            if (!handle.equals(parentWindow)) {
                driver.switchTo().window(handle);
                driver.close();
            }
        }
        //System.out.println("Title 1 :"+driver.getTitle()); --> No such window exception
        //since we closed all windows except parent window.

        driver.switchTo().window(parentWindow);

        System.out.println("Title 2 :"+driver.getTitle());


    }
}
