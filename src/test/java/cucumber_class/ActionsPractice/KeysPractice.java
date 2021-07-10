package cucumber_class.ActionsPractice;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

public class KeysPractice {

    @Test
    public void validateGoogleSearch(){

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();

        driver.get("https://www.google.com/");

        WebElement searchBox=driver.findElement(By.name("q"));

        Actions actions = new Actions(driver);
        actions.moveToElement(searchBox)
                .click(searchBox)
                .keyDown(searchBox, Keys.SHIFT)
                .sendKeys("selenium")
                .keyUp(searchBox,Keys.SHIFT)
                .doubleClick()
                .contextClick()
                .perform();

        searchBox.sendKeys(Keys.ARROW_DOWN);
        searchBox.sendKeys(Keys.ARROW_DOWN);
        searchBox.sendKeys(Keys.ENTER);


        /*

         */


    }

}
