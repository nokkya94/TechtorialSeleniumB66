package cucumber_class.ActionsPractice;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.List;

public class ActionsIntro {
    WebDriver driver;
    @BeforeClass
    public void initialize(){
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
    }
    @Test
    public void validationOfContextClick(){



        driver.get("https://the-internet.herokuapp.com/context_menu");

        WebElement box = driver.findElement(By.id("hot-spot"));

        Actions actions = new Actions(driver);

        actions.contextClick(box).perform();


    }
    @Test
    public void hoverActions(){


        driver.get("https://the-internet.herokuapp.com/hovers");
        List<WebElement> headers = driver.findElements(By.xpath("//h5"));
        for (WebElement header : headers){
            System.out.println("header "+header.getText());
        }
        List<WebElement> images = driver.findElements(By.xpath("//div[@class='figure']//img"));
        Actions actions = new Actions(driver);

        for (int i = 0; i<images.size();i++){
           actions.moveToElement(images.get(i)).perform();
            System.out.println("header2: "+headers.get(i).getText());
        }

    }
    @Test
    public void findElements(){
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();

        driver.get("https://www.primefaces.org/showcase/ui/misc/effect.xhtml");
        /*
        WebElement blindContent = driver.findElement(By.xpath("//div[@id='blind_content']"));
        WebElement clipContent = driver.findElement(By.xpath("//div[@id='clip_content']"));
        WebElement dropContent = driver.findElement(By.xpath("//div[@id='drop_content']"));
        WebElement explodeContent = driver.findElement(By.xpath("//div[@id='explode_content']"));
        WebElement  foldContent = driver.findElement(By.xpath("//div[@id='fold_content']"));
        WebElement puffContent = driver.findElement(By.xpath("//div[@id='puff_content']"));

         */
        List<WebElement> elements = driver.findElements(By.xpath("//table//div[@class='ui-panel-content ui-widget-content']"));
        Actions actions = new Actions(driver);
        for (WebElement element: elements){
            switch (element.getText()){
                case "click":
                    element.click();
                    break;
                case "doubleclick":
                Actions actions1= new Actions(driver);
                actions1.doubleClick(element).perform();
                break;
            }
            }
        }
    }

