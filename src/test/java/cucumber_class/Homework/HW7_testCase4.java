package cucumber_class.Homework;

import Utils.Driver;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class HW7_testCase4 {


    WebDriver driver;
    HW7POM initElements;
    SoftAssert softAssert;
    @BeforeMethod
    public void setUp() {
        driver = Driver.getDriver("chrome");
        initElements = new HW7POM(driver);
        softAssert = new SoftAssert();
        driver.manage().window().maximize();

    }


    @Parameters({"username","password","id"})
    @Test
    public void logIn(String username, String password,String id) throws InterruptedException {


        driver.get("http://demo.guru99.com/V4/");

        initElements.username.sendKeys(username);
        initElements.password.sendKeys(password);
        initElements.logInBtn.click();

        initElements.editAccountFunc.click();
        initElements.accountInfoIdRequested.sendKeys(id);
        initElements.accountInfoSubmit.click();



    }
}
