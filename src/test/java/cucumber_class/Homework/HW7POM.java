package cucumber_class.Homework;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import java.util.List;

public class HW7POM {

    public HW7POM(WebDriver driver){


        PageFactory.initElements(driver,this);
    }

    @FindBy(name = "uid")
    public WebElement username;

    @FindBy(name = "password")
    public WebElement password;

    @FindBy(name = "btnLogin")
    public WebElement logInBtn;

    @FindBy(xpath = "//a[.='Manager']")
    public WebElement managerFunc;

    @FindBy(xpath = "//a[.='New Customer']")
    public WebElement newCustomerFunc;

    @FindBy(xpath = "//a[.='Edit Customer']")
    public WebElement editCustomerFunc;

    @FindBy(xpath = "//a[.='Delete Customer']")
    public WebElement deleteCustomerFunc;

    @FindBy(xpath = "//a[.='New Account']")
    public WebElement newAccountFunc;

    @FindBy(xpath = "//a[.='Edit Account']")
    public WebElement editAccountFunc;

    @FindBy(xpath = "//a[.='Delete Account']")
    public WebElement deleteAccountFunc;

    @FindBy(xpath = "//a[.='Deposit']")
    public WebElement depositFunc;

    @FindBy(xpath = "//a[.='Withdrawal']")
    public WebElement withdrawalFunc;

    @FindBy(xpath = "//a[.='Fund Transfer']")
    public WebElement foundTransferFunc;

    @FindBy(xpath = "//a[.='Change Password']")
    public WebElement changePasswordFunc;

    @FindBy(xpath = "//a[.='Balance Enquiry']")
    public WebElement balanceEnquiryFunc;

    @FindBy(xpath = "//a[.='Mini Statement']")
    public WebElement miniStatementFunc;

    @FindBy(xpath = "//a[.='Customised Statement']")
    public WebElement CustomisedStatementFunc;

    @FindBy(xpath = "//a[.='Log out']")
    public WebElement LogOutFunc;

    @FindBy(xpath = "//div//div//ul[@class='menusubnav']//li/a")
    public List<WebElement> functionalityList;

    @FindBy(xpath = "//p[.='Add New Customer']")
    public WebElement addNewCustomerTitle;

    @FindBy(xpath = "//input[@type='text']")
    public List<WebElement> inputSixFields;

    @FindBy(xpath = "//input[@name='name']")
    public WebElement newCustomerName;

    @FindBy(xpath = "//input[@value='f']")
    public WebElement radioButtonFemale;

    @FindBy(xpath = "//input[@value='m']")
    public WebElement radioButtonMale;

    @FindBy(xpath = "//input[@id='dob']")
    public WebElement dobSendKeys;

    @FindBy(xpath = "//textarea[@name='addr']")
    public WebElement addressWindow;

    @FindBy(xpath = "//input[@name='city']")
    public WebElement cityField;

    @FindBy(xpath = "//input[@name='state']")
    public WebElement stateField;

    @FindBy(xpath = "//input[@name='pinno']")
    public WebElement pinField;

    @FindBy(xpath = "//input[@name='telephoneno']")
    public WebElement phoneNumberField;

    @FindBy(xpath = "//input[@name='emailid']")
    public WebElement emailField;

    @FindBy(xpath = "//input[@name='password']")
    public WebElement passwordField;

    @FindBy(xpath = "//input[@value='Submit']")
    public WebElement submitButton;

    @FindBy(xpath = "//p[@class='heading3']")
    public WebElement customerCreatedMessage;

    @FindBy(xpath = "//td[.='Customer Name']//following-sibling::td")
    public WebElement validateCreatedCustomerName;

    @FindBy(xpath = "//td[.='Gender']//following-sibling::td")
    public WebElement validateCreatedGender;

    @FindBy(xpath = "//td[.='Birthdate']//following-sibling::td")
    public WebElement birthDate;

    @FindBy(xpath = "//td[.='Address']//following-sibling::td")
    public WebElement customerCreatedAddress;

    @FindBy(xpath = "//td[.='City']//following-sibling::td")
    public WebElement createdCustomerCity;

    @FindBy(xpath = "//td[.='State']//following-sibling::td")
    public WebElement createdCustomerState;

    @FindBy(xpath = "//td[.='Pin']//following-sibling::td")
    public WebElement createdCustomerPin;

    @FindBy(xpath = "//td[.='Mobile No.']//following-sibling::td")
    public WebElement createdCustomePhoneNr;

    @FindBy(xpath = "//td[.='Email']//following-sibling::td")
    public WebElement createdCustomerEmail;

    @FindBy(xpath = "//input[@name='accountno']")
    public WebElement accountInfoIdRequested;

    @FindBy(xpath = "//input[@name='AccSubmit']")
    public WebElement accountInfoSubmit;
}
