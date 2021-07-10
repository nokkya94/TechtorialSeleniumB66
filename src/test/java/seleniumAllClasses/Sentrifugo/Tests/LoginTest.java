package seleniumAllClasses.Sentrifugo.Tests;

import seleniumAllClasses.Sentrifugo.LoginPage;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class LoginTest extends TestBase {
    LoginPage loginPage;

    @BeforeClass(alwaysRun = true)
    public void setUpPage() {
        loginPage = new LoginPage(driver);
        System.out.println("page");
    }

    // Task : Create new xml runner for Sentrifugo and run only loginTest class and give the parameter annotation for
    // first test annotation. Correct username and correct password
    @Parameters({"userName", "password"})
    @Test(priority = 4)
    public void loginTest1(String userName, String password) {
        driver.get("http://demo.sentrifugo.com/index.php/");
        loginPage.login(userName, password);
        Assert.assertEquals(driver.getTitle(), "Sentrifugo - Open Source HRMS");
    }

    @Test(priority = 1)
    public void negativeTest() {
        driver.get("http://demo.sentrifugo.com/index.php/");
        loginPage.login("EM01", "Test");
        String actualErrorMessage = loginPage.errorMessage.getText().trim();
        String expectedErrorMessage = "The username or password you entered is incorrect.";
        Assert.assertEquals(actualErrorMessage, expectedErrorMessage);
    }

    @Test(priority = 2)
    public void negativeTest2() {
        driver.get("http://demo.sentrifugo.com/index.php/");
        loginPage.login("TEST", "senft");
        String actualErrorMessage = loginPage.errorMessage.getText().trim();
        String expectedErrorMessage = "The username or password you entered is incorrect.";
        Assert.assertEquals(actualErrorMessage, expectedErrorMessage);
    }

    @Test(priority = 3)
    public void negativeTest3() {
        driver.get("http://demo.sentrifugo.com/index.php/");
        loginPage.login("Test", "test");
        String actualErrorMessage = loginPage.errorMessage.getText().trim();
        String expectedErrorMessage = "The username or password you entered is incorrect.";
        Assert.assertEquals(actualErrorMessage, expectedErrorMessage);

    }
}
