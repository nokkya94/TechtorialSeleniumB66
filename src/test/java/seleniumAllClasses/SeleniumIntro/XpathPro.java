package seleniumAllClasses.SeleniumIntro;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

public class XpathPro {
    public static void main(String[] args) {

        System.setProperty("webdriver.chromedriver.driver","chromedriver.exe");
        WebDriver driver = new ChromeDriver();

        driver.get("file:///C:/Users/tanas/Desktop/Techtorial.html");

        List<WebElement> titles = driver.findElements(By.xpath("//b"));
        for(WebElement title : titles){
            System.out.println(title.getText());
        }

        List <WebElement> links = driver.findElements(By.xpath("//tr[@valign='top']//a"));
        for (WebElement link : links){
            System.out.println(link.getAttribute("href"));
        }


    }
}
