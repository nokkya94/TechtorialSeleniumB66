package seleniumAllClasses.SeleniumIntro;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class SeleniumTestSite {
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver","chromedriver.exe");

        WebDriver driver = new ChromeDriver();
        driver.get("https://www.seleniumeasy.com/test/basic-checkbox-demo.html");
        //task 1 point 2
        WebElement checkAllButton = driver.findElement(By.id("check1"));
        System.out.println(checkAllButton.isDisplayed());
        //task 1 point 3
        System.out.println(checkAllButton.getAttribute("value").equals("Check All")); //false dunno why
        //task 1 point 4
        checkAllButton.click();
        System.out.println("Click by id");
        //task 1 point 5
        String valueAttribute= checkAllButton.getAttribute("value");
        if(valueAttribute.equals("Uncheck All")){
            System.out.println("All check boxes are selected");
        }else if(valueAttribute.equals("Check All")){
            System.out.println("All check boxes are not selected");
        }
        //task 1 point 6
        System.out.println(checkAllButton.getAttribute("value").equals("Uncheck All"));
        //task 2 point 3
        WebElement checkBox4= driver.findElement(By.xpath("(//input[@class='cb1-element'])[4]\n"));
        System.out.println(checkBox4.isSelected());// its not
        //task 2 point 4
        checkBox4.click();
        System.out.println("Click");
        if(valueAttribute.equals("Uncheck All")){
            System.out.println("Uncheck All");
        }else if(valueAttribute.equals("Check All")){
            System.out.println("Check All");
        }







    }
}
