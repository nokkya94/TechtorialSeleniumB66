package cucumber_class.AlertPractice;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class AlertTest {

    WebDriver driver;
    SoftAssert softAssert;

    @BeforeClass
    public void setup(){
        WebDriverManager.chromedriver().setup();
        driver= new ChromeDriver();
        softAssert = new SoftAssert();
    }
    @Test
    public void validateHtmlPopup() throws InterruptedException{

        driver.get("https://sweetalert.js.org/");
        WebElement htmlPreview = driver.findElement(By.xpath("/html/body/div[2]/div/div[3]/button"));
        htmlPreview.click();
        Thread.sleep(1000);
        WebElement errorSymbol = driver.findElement(By.xpath("//div[@role='dialog']//div[contains(@class, 'swal-icon--error')]"));

        softAssert.assertTrue(errorSymbol.isDisplayed());

        WebElement swalTitle = driver.findElement(By.xpath("//div[@class='swal-title']"));
        String actualTitle =swalTitle.getText();
        String expectedTItle = "Oops";

        softAssert.assertEquals(actualTitle,expectedTItle);

        WebElement swalTextBelowTitle = driver.findElement(By.xpath("//div[@class='swal-text']"));
        String actualText = swalTextBelowTitle.getText();
        String expectedText = "Something went wrong!";

        softAssert.assertEquals(actualText,expectedText);

        WebElement okButton = driver.findElement(By.xpath("//button[.='OK']"));
        okButton.click();

        softAssert.assertAll("HTML Popup Validate Message");

    }

    @Test
    public void validateJSAlert(){
        driver.navigate().to("https://the-internet.herokuapp.com/javascript_alerts");

        WebElement jsAlert = driver.findElement(By.xpath("//*[@id=\"content\"]/div/ul/li[1]/button"));
        jsAlert.click();

        Alert alert = driver.switchTo().alert();
        //we have 4 methods inside alert class 1-Accept() 2-Dismiss() 3-getText() 4-sendKey()
        String actualMessage = alert.getText();
        String expectedMessage="I am a JS Alert";

        softAssert.assertEquals(actualMessage,expectedMessage);

        alert.accept();

        WebElement resultMessage = driver.findElement(By.id("result"));
        String actualResult=resultMessage.getText();
        String expectedResult = "You successfuly clicked an alert";

        softAssert.assertEquals(actualResult,expectedResult);

        softAssert.assertAll("JS Alert Validation");
    }
    @Test
    public void validateJsPromptDismiss(){

        driver.get("https://the-internet.herokuapp.com/javascript_alerts");

        WebElement jsPrompt = driver.findElement(By.xpath("//button[@onclick='jsPrompt()']"));
        jsPrompt.click();

        Alert alert = driver.switchTo().alert();

        String actualdAlertText = alert.getText();
        String expectedAlertText = "I am a JS prompt";

        softAssert.assertEquals(actualdAlertText,expectedAlertText);
        alert.sendKeys("Techtorial");
        alert.dismiss();

        WebElement result = driver.findElement(By.id("result"));
        String actualResult = result.getText();
        String expectedResult = "You entered: null";
        softAssert.assertEquals(actualResult,expectedResult);

        softAssert.assertAll("Validate of JS Prompt dismiss");
    }

  


}
