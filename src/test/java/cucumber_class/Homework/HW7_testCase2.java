package cucumber_class.Homework;

import Utils.Driver;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class HW7_testCase2 {


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


    @Parameters({"username","password","newCustomerName","dob","Address","City","State","pin","phoneNumber","mail","passwordForNewCustomer"})
    @Test
    public void logIn(String username, String password, String newCustomerName, String dob, String address, String city, String state,
                      String pin, String phoneNumber, String email, String passwordNewCustomer) throws InterruptedException{



        driver.get("http://demo.guru99.com/V4/");

        initElements.username.sendKeys(username);
        initElements.password.sendKeys(password);
        initElements.logInBtn.click();
        initElements.newCustomerFunc.click();
        softAssert.assertEquals(initElements.addNewCustomerTitle.getText(),"Add New Customer");
        initElements.newCustomerName.sendKeys(newCustomerName);
        initElements.radioButtonFemale.click();
        initElements.dobSendKeys.sendKeys(dob);
        initElements.addressWindow.sendKeys(address);
        initElements.cityField.sendKeys(city);
        initElements.stateField.sendKeys(state);
        initElements.pinField.sendKeys(pin);
        initElements.phoneNumberField.sendKeys(phoneNumber);
        initElements.emailField.sendKeys(email);
        initElements.passwordField.sendKeys(passwordNewCustomer);
        Thread.sleep(500);
        initElements.submitButton.click();
        softAssert.assertEquals(initElements.customerCreatedMessage.getText(),"Customer Registered Successfully!!!");
        softAssert.assertEquals(initElements.validateCreatedCustomerName.getText(),newCustomerName);
        softAssert.assertEquals(initElements.validateCreatedGender.getText(),"female");
        softAssert.assertEquals(initElements.birthDate.getText(),"1988-05-03");
        softAssert.assertEquals(initElements.customerCreatedAddress.getText(),address);
        softAssert.assertEquals(initElements.createdCustomerCity.getText(),city);
        softAssert.assertEquals(initElements.createdCustomerState.getText(),state);
        softAssert.assertEquals(initElements.createdCustomerPin.getText(),pin);
        softAssert.assertEquals(initElements.createdCustomePhoneNr.getText(),phoneNumber);
        softAssert.assertEquals(initElements.createdCustomerEmail.getText(),email);



    }





}
