package seleniumAllClasses.TestNGIntro;

import Utils.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DataProviderAnnotationsIntro {
    WebDriver driver;


    @BeforeMethod
    public void setUp(){
        driver= Driver.getDriver("chrome");
    }
    @AfterMethod
    public void cleanup(){
        driver.quit();

    }

    @Test(dataProvider = "testData")
    public void test1(String firstName, String lastName){

        System.out.println("First name: "+firstName+" , last name: "+lastName);

    }



    @DataProvider(name = "testData")
    public Object[][] getTestData() {
        return new Object[][]{
                {"John", "Smith"},
                {"Mike", "Green"},
                {"Priyanka", "Khan"},
                {"admin", "Admin123"},
                {" ", "Admin123"},
                {" ", " "},
                {"admin1", "adminadmin"}
        };


    }
    @Test(dataProvider = "testData")
    public void test4(String userName, String password){


        driver.get("https://demo.openmrs.org/openmrs/login.htm");
        WebElement usernameField = driver.findElement(By.id("username"));
        usernameField.sendKeys(userName);

        WebElement passwordField = driver.findElement(By.cssSelector("#password"));
        passwordField.sendKeys(password);

        WebElement loginButton = driver.findElement(By.cssSelector("#loginButton"));
        loginButton.click();

        WebElement loginLocationErrorMessage = driver.findElement(By.cssSelector("#sessionLocationError"));

        Assert.assertEquals(loginLocationErrorMessage.getText(),"You must choose a location!");
    }




}
