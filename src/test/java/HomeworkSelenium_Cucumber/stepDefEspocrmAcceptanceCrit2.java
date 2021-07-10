package HomeworkSelenium_Cucumber;

import Utils.Driver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import java.util.concurrent.TimeUnit;

public class stepDefEspocrmAcceptanceCrit2 {

    WebDriver driver= Driver.getDriver("chrome");
    PagesAccountPage initElements2;
    Pages initElements;
    String expectedName;

    @Given("user navigates to {string} for creating an account")
    public void user_navigates_to_for_creating_an_account(String url) {
        driver.get(url);
        driver.manage().window().maximize();
        initElements2=new PagesAccountPage(driver);
        initElements=new Pages(driver);
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

    }

    @When("user opens the Accounts")
    public void user_opens_the_accounts() throws InterruptedException{
        Thread.sleep(2000);
        try{
            initElements.loginButton.submit();
        }catch (Exception ex){
            System.out.println("You are already logged in");
        }
        Thread.sleep(1000);
        initElements.accountsButton.click();

    }

    @Then("user clicks the Create Account button")
    public void user_clicks_the_create_account_button() {
        initElements2.createNewAccountBtn.click();
    }

    @Then("the user creates {int} new accounts with following data:{string},{string},{string},{string}")
    public void the_user_creates_new_accounts_with_following_data(Integer int1, String name, String webSite, String email, String phoneNr) {
        initElements2.name.sendKeys(name);
        initElements2.website.sendKeys(webSite);
        initElements2.email.sendKeys(email);
        initElements2.phoneNr.sendKeys(phoneNr);
        expectedName = name;
    }

    @Then("with billing Address: {string},{string},{string},{string},{string}")
    public void with_billing_address(String bilAddressStreet, String bilAddressCity, String bilAddressState, String bilAddressPostalCode, String bilAddressCountry) {

        initElements2.billingAddressStreet.sendKeys(bilAddressStreet);
        initElements2.billingAddressCity.sendKeys(bilAddressCity);
        initElements2.billingAddressState.sendKeys(bilAddressState);
        initElements2.billingAddressPostalCode.sendKeys(bilAddressPostalCode);
        initElements2.billingAddressCountry.sendKeys(bilAddressCountry);
    }

    @Then("with Shipping Address: {string},{string},{string},{string},{string}")
    public void with_shipping_address(String shipAddressStreet, String shipAddressCity, String shipAddressState, String shipAddressPostalCode, String shipAddressCountry) {

        initElements2.shippingAddressStreet.sendKeys(shipAddressStreet);
        initElements2.shippingAddressCity.sendKeys(shipAddressCity);
        initElements2.shippingAddressState.sendKeys(shipAddressState);
        initElements2.shippingAddressPostalCode.sendKeys(shipAddressPostalCode);
        initElements2.shippingAddressCountry.sendKeys(shipAddressCountry);
    }

    @Then("with Details {string} and {string} writing this {string}")
    public void with_details_and_writing_this(String typeSelectElement, String IndustrySelectElement, String descriptionText) {


        Select select = new Select(initElements2.detailsTypeSelectElement);
        select.selectByVisibleText(typeSelectElement);

        Select select1 = new Select(initElements2.detailsIndustrySelectElement);
        select1.selectByVisibleText(IndustrySelectElement);

        initElements2.descriptionText.sendKeys(descriptionText);
    }

    @Then("with {string} and {string}")
    public void with_and(String assignedUser, String teams) {
        initElements2.assignedUserDeleteXsign.click();
        initElements2.assignedUser.sendKeys(assignedUser+ Keys.ENTER);
        initElements2.teamsSelectElementArrow.click();
        initElements2.salesDepartmentTeam.click();
        initElements2.saveNewAccountBtn.click();
    }

    @Then("the user validate the new users are created")
    public void the_user_validate_the_new_users_are_created() throws InterruptedException{

      Assert.assertEquals(initElements2.confirmNewAccount.getText(),expectedName);
      Thread.sleep(2000);
    }

}
