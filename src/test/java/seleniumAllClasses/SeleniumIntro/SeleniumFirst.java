package seleniumAllClasses.SeleniumIntro;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class SeleniumFirst {
    public static void main(String[] args) {

        System.setProperty("webdriver.chrome.driver","chromedriver.exe");

        WebDriver driver= new ChromeDriver();
        //GET METHOD ---> NAVIGATE TO THE GIVEN URL
        driver.get("https://www.google.com/");
        String googleTitle=driver.getTitle();
        System.out.println(googleTitle);

        driver.navigate().to("https://www.techtorialacademy.com/");
        String techtorialTitle= driver.getTitle();
        System.out.println(techtorialTitle);
        if(techtorialTitle.equals("Home Page - Techtorial")){
            System.out.println("Title is correct");
        }else{
            System.out.println("Title is not correct");
        }
        //GET TITLE ----> IT WILL GET THE TITLE OF THE PAGE

        //getcurrenturl
        String currentUrl=driver.getCurrentUrl();
        System.out.println(currentUrl);
        //System.out.println(driver.getPageSource());

        /*We have two ways to navigate to the page
        1-driver.get("url")-->it will wait until your page get loaded
        2-driver.navigate().to("url");-->it will not wait until the whole page will get loaded
         */
        driver.navigate().to("https://www.facebook.com/");

        driver.navigate().back();
        driver.navigate().forward();

        driver.navigate().to("file:///C:/Users/tanas/Desktop/TechtorialMainPage.html");

    }
}
