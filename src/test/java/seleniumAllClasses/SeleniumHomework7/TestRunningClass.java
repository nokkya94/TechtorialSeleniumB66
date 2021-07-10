package seleniumAllClasses.SeleniumHomework7;

import Utils.Driver;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class TestRunningClass {



    WebDriver driver;
    POM initElements;
    SoftAssert softAssert;
    @BeforeMethod
    public void setUp() {
        driver = Driver.getDriver("chrome");
        initElements = new POM(driver);
        softAssert = new SoftAssert();

    }


    @Test
    public void test1(){

        driver.get("http://demo.guru99.com/V4/");



    }

}
