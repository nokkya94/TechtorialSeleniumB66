package seleniumAllClasses.SeleniumIntro;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class SeleniumMethods2 {
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver","chromedriver.exe");
        WebDriver driver = new ChromeDriver();

        driver.get("http://www.testdiary.com/training/selenium/selenium-test-page/");

        WebElement saveButton = driver.findElement(By.id("demo"));
        System.out.println(saveButton.isEnabled());

        WebElement javaRadio=driver.findElement(By.id("java1"));
        System.out.println(javaRadio.isEnabled());

        WebElement seleniumCheckBox = driver.findElement(By.id("seleniumbox"));
        System.out.println(seleniumCheckBox.isSelected());
        seleniumCheckBox.click();
        System.out.println(seleniumCheckBox.isSelected());

        WebElement restApiCheckBox=driver.findElement(By.id("restapibox"));
        System.out.println(restApiCheckBox.isDisplayed());

        WebElement register = driver.findElement(By.xpath("//a[starts-wht(@href,'mercuryr')]"));
        System.out.println(register.getText());

    }
}
