package seleniumAllClasses.SeleniumIntro;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class SeleniumTech {
    public static void main(String[] args) {

        System.setProperty("webdriver.chrome.driver","chromedriver.exe");
        //setProperty -->set the file location and use the chrome driver for selenium
        //It will set the value for your chrome driver.
        //Without setProperty we cannot launch the chrome browser
        WebDriver driver = new ChromeDriver();

        driver.get("file:///C:/Users/tanas/Desktop/Techtorial.html");

        WebElement header=driver.findElement(By.id("techtorial1"));
        //main options using element
        // get text, click element, is displayed, is selected
        // getText returns text from this element
        System.out.println(header.getText());

        WebElement firstNameInput=driver.findElement(By.id("firstname"));
        //SendKeys() method will send the given String to the input box.
        firstNameInput.sendKeys("Alex");
        WebElement lName= driver.findElement(By.id("lastName"));
        lName.sendKeys("Tanasiev");
        WebElement pNumber=driver.findElement(By.id("phoneNum"));
        pNumber.sendKeys("111222");
        WebElement eMail=driver.findElement(By.id("userName"));
        eMail.sendKeys("alex@gmail.com");

    }
}
