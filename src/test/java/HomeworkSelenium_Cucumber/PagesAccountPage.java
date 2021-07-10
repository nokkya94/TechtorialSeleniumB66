package HomeworkSelenium_Cucumber;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PagesAccountPage {


    public PagesAccountPage(WebDriver driver){

        PageFactory.initElements(driver,this);

    }

    @FindBy(xpath = "//a[@data-name='create']")
    public WebElement createNewAccountBtn;

    @FindBy(xpath = "//input[@data-name='name']")
    public WebElement name;

    @FindBy(xpath = "//input[@data-name='website']")
    public WebElement website;

    @FindBy(xpath = "//input[@type='email']")
    public WebElement email;

    @FindBy(xpath = "//input[@class='form-control phone-number no-margin-shifting']")
    public WebElement phoneNr;

    @FindBy(xpath = "//textarea[@data-name='billingAddressStreet']")
    public WebElement billingAddressStreet;

    @FindBy(xpath = "//input[@data-name='billingAddressCity']")
    public WebElement billingAddressCity;

    @FindBy(xpath = "//input[@data-name='billingAddressState']")
    public WebElement billingAddressState;

    @FindBy(xpath = "//input[@data-name='billingAddressPostalCode']")
    public WebElement billingAddressPostalCode;

    @FindBy(xpath = "//input[@data-name='billingAddressCountry']")
    public WebElement billingAddressCountry;

    @FindBy(xpath = "//textarea[@data-name='shippingAddressStreet']")
    public WebElement shippingAddressStreet;

    @FindBy(xpath = "//input[@data-name='shippingAddressCity']")
    public WebElement shippingAddressCity;

    @FindBy(xpath = "//input[@data-name='shippingAddressState']")
    public WebElement shippingAddressState;

    @FindBy(xpath = "//input[@data-name='shippingAddressPostalCode']")
    public WebElement shippingAddressPostalCode;

    @FindBy(xpath = "//input[@data-name='shippingAddressCountry']")
    public WebElement shippingAddressCountry;

    @FindBy(xpath = "//select[@data-name='type' and @class='form-control main-element']")
    public WebElement detailsTypeSelectElement;

    @FindBy(xpath = "//select[@data-name='industry' and @class='form-control main-element']")
    public WebElement detailsIndustrySelectElement;

    @FindBy(xpath = "//textarea[@data-name='description']")
    public WebElement descriptionText;

    @FindBy(xpath = "//i[@class='fas fa-times']")
    public WebElement assignedUserDeleteXsign;

    @FindBy(xpath = "//input[@autocomplete='espo-assignedUser']")
    public WebElement assignedUser;

    @FindBy(xpath = "//span[@class='fas fa-angle-up']")
    public WebElement teamsSelectElementArrow;

    @FindBy(xpath = "//a[@title='Sales Department']")
    public WebElement salesDepartmentTeam;

    @FindBy(xpath = "//button[@class='btn btn-primary action']")
    public WebElement saveNewAccountBtn;

    @FindBy(xpath = "//span[@class='font-size-flexible title']")
    public WebElement confirmNewAccount;

}
