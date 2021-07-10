package cucumber_class.Homework;

import Utils.Driver;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class HW7_TestCase3 {



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

    @Test(dataProvider = "First Different Customer Jet Li", dataProviderClass = DataProv_TestCase3.class)
    public void sendKeysFromProvider(String username, String password,String name, String dob, String address, String city, String state, String pin, String phoneNr, String email, String passowrdCustomer)
    throws  InterruptedException{

        driver.get("http://demo.guru99.com/V4/");

        initElements.username.sendKeys(username);
        initElements.password.sendKeys(password);
        initElements.logInBtn.click();
        initElements.newCustomerFunc.click();
        initElements.newCustomerName.sendKeys(name);
        initElements.dobSendKeys.sendKeys(dob);
        initElements.addressWindow.sendKeys(address);
        initElements.cityField.sendKeys(city);
        initElements.stateField.sendKeys(state);
        initElements.pinField.sendKeys(pin);
        initElements.phoneNumberField.sendKeys(phoneNr);
        initElements.emailField.sendKeys(email);
        initElements.passwordField.sendKeys(passowrdCustomer);
        Thread.sleep(500);
        initElements.submitButton.click();
        softAssert.assertEquals(initElements.customerCreatedMessage.getText(),"Customer Registered Successfully!!!");
        softAssert.assertEquals(initElements.validateCreatedCustomerName.getText(),name);
        softAssert.assertEquals(initElements.validateCreatedGender.getText(),"male");
        //softAssert.assertEquals(initElements.birthDate.getText(),"1988-05-03");
        softAssert.assertEquals(initElements.customerCreatedAddress.getText(),address);
        softAssert.assertEquals(initElements.createdCustomerCity.getText(),city);
        softAssert.assertEquals(initElements.createdCustomerState.getText(),state);
        softAssert.assertEquals(initElements.createdCustomerPin.getText(),pin);
        softAssert.assertEquals(initElements.createdCustomePhoneNr.getText(),phoneNr);
        softAssert.assertEquals(initElements.createdCustomerEmail.getText(),email);


    }
    @Test(dataProvider = "Second Different Customer Jakob Macecki", dataProviderClass = DataProv_TestCase3.class)
    public void sendKeysFromProvider2(String username, String password,String name, String dob, String address, String city, String state, String pin, String phoneNr, String email, String passowrdCustomer)
            throws  InterruptedException{

        driver.get("http://demo.guru99.com/V4/");

        initElements.username.sendKeys(username);
        initElements.password.sendKeys(password);
        initElements.logInBtn.click();
        initElements.newCustomerFunc.click();
        initElements.newCustomerName.sendKeys(name);
        initElements.dobSendKeys.sendKeys(dob);
        initElements.addressWindow.sendKeys(address);
        initElements.cityField.sendKeys(city);
        initElements.stateField.sendKeys(state);
        initElements.pinField.sendKeys(pin);
        initElements.phoneNumberField.sendKeys(phoneNr);
        initElements.emailField.sendKeys(email);
        initElements.passwordField.sendKeys(passowrdCustomer);
        Thread.sleep(500);
        initElements.submitButton.click();
        softAssert.assertEquals(initElements.customerCreatedMessage.getText(),"Customer Registered Successfully!!!");
        softAssert.assertEquals(initElements.validateCreatedCustomerName.getText(),name);
        softAssert.assertEquals(initElements.validateCreatedGender.getText(),"male");
        //softAssert.assertEquals(initElements.birthDate.getText(),"1988-05-03");
        softAssert.assertEquals(initElements.customerCreatedAddress.getText(),address);
        softAssert.assertEquals(initElements.createdCustomerCity.getText(),city);
        softAssert.assertEquals(initElements.createdCustomerState.getText(),state);
        softAssert.assertEquals(initElements.createdCustomerPin.getText(),pin);
        softAssert.assertEquals(initElements.createdCustomePhoneNr.getText(),phoneNr);
        softAssert.assertEquals(initElements.createdCustomerEmail.getText(),email);


    }



}
