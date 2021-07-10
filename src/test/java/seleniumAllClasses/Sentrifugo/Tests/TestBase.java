package seleniumAllClasses.Sentrifugo.Tests;

import Utils.Driver;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

public class TestBase {
    // inside this class i will br initializing the Webdriver and call the driver from this class
    // this one will help is to avoid creating WebdriverMAneger.ChromeDriver.setup() in every class

    public WebDriver driver;
    @Parameters("driverName")
    @BeforeClass(alwaysRun = true)
    public void setUp(String driverName){
        driver= Driver.getDriver(driverName);
    }


}
