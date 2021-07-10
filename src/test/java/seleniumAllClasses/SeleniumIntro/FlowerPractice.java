package seleniumAllClasses.SeleniumIntro;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

public class FlowerPractice {
    public static void main(String[] args) {

        System.setProperty("webdriver.chromedriver.driver", "chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        String flowerLink = "https://www.google.com/search?q=flower&rlz=1C1CHBF_enUS879US879&sxsrf=ALeKk01hIff2UCscypApIZnbvj7zuL2-Cw:1603291223010&source=lnms&tbm=isch&sa=X&ved=2ahUKEwiLg8ae9cXsAhWIbc0KHaI2DKUQ_AUoAXoECBcQAw";
        driver.get(flowerLink);
        List<WebElement> links = driver.findElements(By.xpath("//div[@jsname='ixzLGf']//a"));
        String winHandleBefore = driver.getWindowHandle();
        for (WebElement allPages : links) {
            String strLinks= allPages.getAttribute("href");
            //System.out.println(allPages.getAttribute("href"));

            if(strLinks!=null) {
                System.out.println(strLinks);
                driver.switchTo().window(strLinks);
                driver.close();

            }



        }


    }
}
