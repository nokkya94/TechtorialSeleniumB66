package seleniumAllClasses.SeleniumIntro;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

public class FirefoxTest {
    public static void main(String[] args) {

        System.setProperty("webdriver.geckodriver.driver","geckodriver.exe");

        WebDriver driver = new FirefoxDriver();

        driver.navigate().to("https://the-internet.herokuapp.com/");

        List<WebElement> links=driver.findElements(By.tagName("//li/a"));

        ArrayList<String> webOrder = new ArrayList<>();

        for(WebElement link : links){
            webOrder.add(link.getText());
        }

        Set<String> ascendingOrder = new TreeSet<>(webOrder);
        ArrayList<String> ascendingList = new ArrayList<>(ascendingOrder);


        for(int i=0; i<webOrder.size();i++){
            if(!webOrder.get(i).equals(ascendingList.get(i)));
            System.out.println("The Text is not following ascending order");
            break;
        }

    }
}
