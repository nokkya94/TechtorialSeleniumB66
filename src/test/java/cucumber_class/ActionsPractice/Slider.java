package cucumber_class.ActionsPractice;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

public class Slider {


    @Test
    public void validateHerokuAppSlider(){


        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();

        driver.navigate().to("https://the-internet.herokuapp.com/horizontal_slider");
        WebElement slider = driver.findElement(By.xpath("//input[@type='range']"));
        WebElement text = driver.findElement(By.id("range"));

        moveToTarget(driver,slider,text,"0");

    }

    public void moveToTarget(WebDriver driver, WebElement element, WebElement textElement, String target){

        Actions actions = new Actions(driver);
        double db=Double.parseDouble(target);

        if (db>2.5) {
            int xCord=10;
            while (!textElement.getText().equals(target)) {
                actions.clickAndHold()
                        .moveByOffset(xCord,0)
                        .perform();
                xCord+=10;
            }
        }else if(db<2.5){
            int xCord=-10;
            while (!textElement.getText().equals(target)) {
                actions.clickAndHold()
                        .moveByOffset(xCord,0)
                        .perform();
                xCord+=-10;
            }
        }else if(db==2.5){
           actions.clickAndHold().perform();
            }
    }



}
