package seleniumAllClasses.SeleniumIntro;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;


public class Locators {
    public static void main(String[] args) {


        System.setProperty("webdriver.chrome.driver","chromedriver.exe");
        WebDriver driver=new ChromeDriver();

        driver.get("file:///C:/Users/tanas/Desktop/Techtorial.html");

        WebElement addressOne = driver.findElement((By.name("address1")));
        addressOne.sendKeys("2200 E Devon Ave");
        WebElement addressTwo = driver.findElement(By.name("address2"));
        addressTwo.sendKeys("suite 309");
        WebElement cityInput = driver.findElement(By.name("city"));
        cityInput.sendKeys("Chicago");
        WebElement stateInput=driver.findElement(By.className("state"));
        stateInput.sendKeys("IL");
        WebElement zipCode=driver.findElement(By.className("pstlCode"));
        zipCode.sendKeys("60018");
        WebElement country=driver.findElement(By.name("country"));
        country.sendKeys("ANDORRA");
        WebElement header=driver.findElement(By.tagName("h1"));
        System.out.println(header.getText());

        WebElement bTag=driver.findElement(By.tagName("b"));
        //FindElement returns single element. if we have more than one matching
        //locator value in the html, find eleemnt method returns the first one
        System.out.println(bTag.getText());

        WebElement seleniumButton = driver.findElement(By.linkText("Selenium"));
        //I have only one matching a tag on the html which has Selenium text
        //that makes it unique
        seleniumButton.click();

        WebElement testNG = driver.findElement(By.linkText("TestNG"));
        testNG.click();
        driver.navigate().back();
        WebElement apiButton=driver.findElement(By.partialLinkText("Rest"));
        apiButton.click();
        driver.navigate().back();
//////////////////////////////////////////////////////////////
        addressOne=driver.findElement(By.name("address1"));
        addressTwo=driver.findElement(By.name("address2"));
        cityInput=driver.findElement(By.name("city"));
        stateInput=driver.findElement(By.name("state"));
        addressOne.clear();
        addressTwo.clear();
        cityInput.clear();
        stateInput.clear();

        WebElement cucumber=driver.findElement(By.linkText("Cucumber"));
        cucumber.submit();

        WebElement submitButton = driver.findElement(By.id("submitbutton"));
        submitButton.submit();

    }
}
