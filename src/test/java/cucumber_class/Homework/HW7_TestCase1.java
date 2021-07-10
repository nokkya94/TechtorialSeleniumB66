package cucumber_class.Homework;

import Utils.Driver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.asserts.SoftAssert;

public class HW7_TestCase1 {

    WebDriver driver = Driver.getDriver("chrome");
    HW7POM initElements;
    SoftAssert softAssert;

    @Given("user navigates to {string} using recently saved username and password")
    public void user_navigates_to_using_recently_saved_username_and_password(String string) {
        driver.get("http://demo.guru99.com/V4/");
        initElements = new HW7POM(driver);
        softAssert = new SoftAssert();
    }

    @When("user log in with userId {string} and password {string}")
    public void user_log_in_with_user_id_and_password(String username, String password) {
        initElements.username.sendKeys(username);
        initElements.password.sendKeys(password);
        initElements.logInBtn.click();
    }
    
    @Then("user should be able to validate all the functionality names and their size")
    public void user_should_be_able_to_validate_all_the_functionality_names_and_their_size() {

        softAssert.assertEquals(initElements.managerFunc.getText(),"Manager");
        softAssert.assertEquals(initElements.newCustomerFunc.getText(),"New Customer");
        softAssert.assertEquals(initElements.editCustomerFunc.getText(),"Edit Customer");
        softAssert.assertEquals(initElements.deleteCustomerFunc.getText(),"Delete Customer");
        softAssert.assertEquals(initElements.newAccountFunc.getText(),"New Account");
        softAssert.assertEquals(initElements.editAccountFunc.getText(),"Edit Account");
        softAssert.assertEquals(initElements.deleteAccountFunc.getText(),"Delete Account");
        softAssert.assertEquals(initElements.depositFunc.getText(),"Deposit");
        softAssert.assertEquals(initElements.withdrawalFunc.getText(),"Withdrawal");
        softAssert.assertEquals(initElements.foundTransferFunc.getText(),"Fund Transfer");
        softAssert.assertEquals(initElements.changePasswordFunc.getText(),"Change Password");
        softAssert.assertEquals(initElements.balanceEnquiryFunc.getText(),"Balance Enquiry");
        softAssert.assertEquals(initElements.miniStatementFunc.getText(),"Mini Statement");
        softAssert.assertEquals(initElements.CustomisedStatementFunc.getText(),"Customised Statement");
        softAssert.assertEquals(initElements.LogOutFunc.getText(),"Log out");
        softAssert.assertTrue(initElements.functionalityList.size()==15);


    }

    @Then("all the functionality names must start with upper case")
    public void all_the_functionality_names_must_start_with_upper_case() {

        for (WebElement names : initElements.functionalityList){

            softAssert.assertTrue((Character.isUpperCase(names.getText().charAt(0))));

            if(names.getText().contains(" ")){
                softAssert.assertTrue((Character.isUpperCase(names.getText().charAt(names.getText().indexOf(" ")+1))));
            }else {
                continue;
            }

        }


    }


}
