package seleniumAllClasses.SeleniumIntro;

import Utils.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class FileUpload {

    WebDriver driver;


    @BeforeMethod
    public void setUp() {
        driver = Driver.getDriver("chrome");
    }

    @Test
    public void uploadFile() {

        driver.get("http://the-internet.herokuapp.com/upload");

        WebElement chooseFileButton = driver.findElement(By.cssSelector("#file-upload"));
        chooseFileButton.sendKeys("C:\\Users\\tanas\\Downloads\\alexUploads.txt");
        WebElement fileSubmit = driver.findElement(By.cssSelector("#file-submit"));
        fileSubmit.click();
        WebElement fileUploadedVerification = driver.findElement(By.xpath("//h3[.='File Uploaded!']"));
        String expected = "File Uploaded!";
        Assert.assertEquals(fileUploadedVerification.getText(), expected);
        WebElement myFileName = driver.findElement(By.xpath("//div[@class='panel text-center']"));
        String expectedFileName = "alexUploads.txt";
        Assert.assertEquals(myFileName.getText(), expectedFileName);
    }


    @Test(dataProvider = "dataProvider")
    public void uploadFile2(String username, String password) {

        driver.get("https://demo.openmrs.org/openmrs/login.htm");
        WebElement usernameField = driver.findElement(By.id("username"));
        usernameField.sendKeys(username);
        WebElement passwordField = driver.findElement(By.id("password"));
        passwordField.sendKeys(password);
        WebElement locationForSession = driver.findElement(By.id("Pharmacy"));
        locationForSession.click();
        WebElement loginButton = driver.findElement(By.id("loginButton"));
        loginButton.click();

    }


    //method with names
    public static Object[][] namesGenerator() {
        return new Object[][]{
                {"Turtle", "Michelangelo"},
                {"Turtle", "Leonardo"},
                {"Turtle", "Raphael"},
                {"Turtle", "Donatello"},
                {"admin123", "adminadmin"}
        };

    }

    @DataProvider(name = "dataProvider")
    public Object[][] getNamesGenerator() {

        return namesGenerator();

    }
}
