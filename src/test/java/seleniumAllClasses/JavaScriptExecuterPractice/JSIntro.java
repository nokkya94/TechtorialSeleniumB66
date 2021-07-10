package seleniumAllClasses.JavaScriptExecuterPractice;

import seleniumAllClasses.Sentrifugo.Tests.TestBase;
import org.openqa.selenium.*;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class JSIntro extends TestBase {


    SoftAssert softAssert;


    @Test
    public void validationJSExecutor(){

        driver.get("https://www.techtorialacademy.com/");
        JavascriptExecutor js= (JavascriptExecutor) driver;
        String title=js.executeScript("return document.title").toString();
        System.out.println(title);

        WebElement browseCourse = driver.findElement(By.linkText("Browse Course"));

        js.executeScript("arguments[0].click()",browseCourse);

        System.out.println(js.executeScript("return document.title").toString());

        js.executeScript("alert (\" Techtorial Academy Javascript executor\")");
        Alert alert=driver.switchTo().alert();
        System.out.println(alert.getText());
        alert.accept();

        WebElement getStartButton = driver.findElement(By.xpath("//h4[.='Online Course']/following-sibling::div/a"));

        js.executeScript("arguments[0].scollIntoView(true);",getStartButton);

        WebElement programsHeader = driver.findElement(By.tagName("h1"));

        js.executeScript("arguments[0].scrollintoView(true);");

    }

    @Test
    public void scrollUnitEndOfTHePage() throws  InterruptedException{
        driver.get("https://www.techtorialacademy.com/");

        JavascriptExecutor js=(JavascriptExecutor) driver;

        js.executeScript("window.scrollTo(0,document.body.scrollHeight)");
        //driver.navigate().refresh();
        //driver.navigate().back();
        //driver.navigate().forward();
        Thread.sleep(2000);
        js.executeScript("history.go(0)");
        WebElement onlineCOurse = driver.findElement(By.xpath("//a[.='Online Course']"));
        Point buttonCord=onlineCOurse.getLocation();
        int xCord=buttonCord.getX();
        int yCord=buttonCord.getY();
        js.executeScript("window.scrollTo("+xCord+", "+yCord+")");//we need to scroll to see
        //the element and then execute our code

        js.executeScript("arguments[0].setAttribute('style','background-color:red')",onlineCOurse);



    }


}
