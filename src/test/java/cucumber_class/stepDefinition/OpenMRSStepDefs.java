package cucumber_class.stepDefinition;

import Utils.Driver;
import Utils.PropertyReader;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.cucumber.java.eo.Se;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import java.util.List;
import java.util.Map;

import static Utils.PropertyReader.readPropertyByKey;

public class OpenMRSStepDefs {

    WebDriver driver= Driver.getDriver("chrome");


    @When("user navigates to demo.openmrs.org")
    public void user_navigates_to_demo_openmrs_org() {
        driver.get("https://demo.openmrs.org/openmrs/login.htm");
    }

    @When("user is logging in Registration Desk {string} and {string}")
    public void user_is_logging_in_registration_desk(String username, String passWord) {

        WebElement registrationDesk = driver.findElement(By.id("Registration Desk"));
        registrationDesk.click();
        WebElement userName = driver.findElement(By.id("username"));
        userName.sendKeys(readPropertyByKey("username"));
        WebElement password = driver.findElement(By.id("password"));
        password.sendKeys(readPropertyByKey("password"));
        WebElement logint = driver.findElement(By.id("loginButton"));
        logint.click();
    }

    @Then("verify if user is {string}")
    public void verify_if_user_is(String superUser) {
        WebElement superAdminText = driver.findElement(By.xpath("//h4"));

        Assert.assertTrue(superAdminText.getText().contains(superUser));
    }
    /*
    @Given("user logged in to demo.openmrs.org")
    public void user_logged_in_to_demo_openmrs_org() {
        WebElement registrationDesk = driver.findElement(By.id("Registration Desk"));
        registrationDesk.click();
        WebElement userName = driver.findElement(By.id("username"));
        userName.sendKeys("admin");
        WebElement password = driver.findElement(By.id("password"));
        password.sendKeys("Admin123");
        WebElement logint = driver.findElement(By.id("loginButton"));
        logint.click();
    }

     */
    @When("user navigates to open MRS Home page")
    public void user_navigates_to_open_mrs_home_page() {


        driver.get("https://demo.openmrs.org/openmrs/login.htm");


    }




    @When("user logs in using following data:")
    public void user_logs_in_using_following_data(io.cucumber.datatable.DataTable dataTable) {

        List<Map<String, String>> dataTableList = dataTable.asMaps();

        System.out.println("Size of list of maps is :"+ dataTableList.size());
        Map<String,String> dataMap = dataTableList.get(0);
        String usernameValue = dataMap.get("username");
        String passwordValue = dataMap.get("password");

        System.out.println("Username "+usernameValue);
        System.out.println("Password "+passwordValue);

        WebElement userNameField = driver.findElement(By.id("username"));
        userNameField.sendKeys(usernameValue);
        WebElement passWordField = driver.findElement(By.id("password"));
        passWordField.sendKeys(passwordValue);

        WebElement registrationDesk = driver.findElement(By.id("Registration Desk"));
        registrationDesk.click();

        WebElement loginBtn = driver.findElement(By.id("loginButton"));
        loginBtn.click();

    }
    @Then("user is logged in as {string}")
    public void user_is_logged_in_as(String string) {
        WebElement title  = driver.findElement(By.xpath("//h4"));

        Assert.assertTrue(title.getText().contains(string));
    }

    @Given("user logged in to demo.openmrs.org as {string}")
    public void user_logged_in_to_demo_openmrs_org_admin(String admin) {

        WebElement title  = driver.findElement(By.xpath("//h4"));

        Assert.assertTrue(title.getText().contains(admin));

    }

    @When("user registers a new patent with following information:")
    public void user_registers_a_new_patent_with_following_information(io.cucumber.datatable.DataTable dataTable) {

        List<Map<String, String>> newPatinetMap = dataTable.asMaps();
        Map<String,String> dataMapForPatient = newPatinetMap.get(0);
        String givenName = dataMapForPatient.get("GivenName");
        String familyName = dataMapForPatient.get("FamilyName");
        String gender = dataMapForPatient.get("Gender");
        String birthDay = dataMapForPatient.get("Birth Day");
        String birthMonth = dataMapForPatient.get("Birth Month");
        String birthYear = dataMapForPatient.get("Birth Year");
        String address = dataMapForPatient.get("Address");
        String city = dataMapForPatient.get("City");
        String state = dataMapForPatient.get("State");
        String country = dataMapForPatient.get("Country");
        String PostalCode = dataMapForPatient.get("PostalCode");
        String phoneNr = dataMapForPatient.get("PhoneNumber");
        String relative = dataMapForPatient.get("RelativeName");


        WebElement registerApatient = driver.findElement(By.id("referenceapplication-registrationapp-registerPatient-homepageLink-referenceapplication-registrationapp-registerPatient-homepageLink-extension"));
        registerApatient.click();
        WebElement givenNameField = driver.findElement(By.name("givenName"));
        givenNameField.sendKeys(givenName);
        WebElement familyNameField = driver.findElement(By.name("familyName"));
        familyNameField.sendKeys(familyName);
        //Move to gender section
        WebElement genderSection = driver.findElement(By.id("genderLabel"));
        genderSection.click();
        WebElement genderSelect = driver.findElement(By.id("gender-field"));
        Select selectGender = new Select(genderSelect);
        selectGender.selectByVisibleText(gender);
        //Move to birthday section
        WebElement birthDaySection = driver.findElement(By.id("birthdateLabel"));
        birthDaySection.click();
        WebElement dayField = driver.findElement(By.id("birthdateDay-field"));
        dayField.sendKeys(birthDay);
        WebElement MonthField = driver.findElement(By.id("birthdateMonth-field"));
        Select selectMonthSelect = new Select(MonthField);
        selectMonthSelect.selectByVisibleText(birthMonth);
        WebElement birthYearField = driver.findElement(By.id("birthdateYear-field"));
        birthYearField.sendKeys(birthYear);
        //Move to address
        WebElement addressSection = driver.findElement(By.xpath("//span[.='Address']"));
        addressSection.click();
        WebElement addressField = driver.findElement(By.id("address1"));
        addressField.sendKeys(address);
        WebElement cityField = driver.findElement(By.id("cityVillage"));
        cityField.sendKeys(city);
        WebElement stateField = driver.findElement(By.id("stateProvince"));
        stateField.sendKeys(state);
        WebElement countryField = driver.findElement(By.id("country"));
        countryField.sendKeys(country);
        WebElement postalCodeField = driver.findElement(By.id("postalCode"));
        postalCodeField.sendKeys(PostalCode);
        //Move to ph number
        WebElement phoneNumberSection = driver.findElement(By.xpath("//span[.='Phone Number']"));
        phoneNumberSection.click();
        WebElement phoneNrField = driver.findElement(By.name("phoneNumber"));
        phoneNrField.sendKeys(phoneNr);
        //Relatives section
        WebElement relativesSection = driver.findElement(By.xpath("//span[.='Relatives']"));
        relativesSection.click();
        WebElement relativesNameField= driver.findElement(By.xpath("//input[@placeholder='Person Name']"));
        relativesNameField.sendKeys(relative);
        //Confirm Section
        WebElement confirmSection = driver.findElement(By.id("confirmation_label"));
        confirmSection.click();
        WebElement confirmButton = driver.findElement(By.id("submit"));
        confirmButton.click();
    }

    @Then("new patient is registered")
    public void new_patient_is_registered() {
       // WebElement createdName = driver.findElement(By.className("PersonName-givenName"));
    }

    @Given("user logged in to demo.openmrs.org as {string} for a new map")
    public void user_logged_in_to_demo_openmrs_org_as_for_a_new_map(String string) {
        driver.get("https://demo.openmrs.org/openmrs/login.htm");
    }




    @When("user registers a new patent with following information: for a new map")
    public void user_registers_a_new_patent_with_following_information_for_a_new_map(io.cucumber.datatable.DataTable dataTable) throws InterruptedException{

        Map<String,String> dataMapForPatient =  dataTable.asMap(String.class, String.class);
        String givenName = dataMapForPatient.get("GivenName");
        String familyName = dataMapForPatient.get("FamilyName");
        String gender = dataMapForPatient.get("Gender");
        String birthDay = dataMapForPatient.get("Birth Day");
        String birthMonth = dataMapForPatient.get("Birth Month");
        String birthYear = dataMapForPatient.get("Birth Year");
        String address = dataMapForPatient.get("Address");
        String city = dataMapForPatient.get("City");
        String state = dataMapForPatient.get("State");
        String country = dataMapForPatient.get("Country");
        String PostalCode = dataMapForPatient.get("PostalCode");
        String phoneNr = dataMapForPatient.get("PhoneNumber");
        String relative = dataMapForPatient.get("RelativeName");


        WebElement registerApatient = driver.findElement(By.id("referenceapplication-registrationapp-registerPatient-homepageLink-referenceapplication-registrationapp-registerPatient-homepageLink-extension"));
        registerApatient.click();
        Thread.sleep(1000);
        WebElement givenNameField = driver.findElement(By.name("givenName"));
        givenNameField.sendKeys(givenName);
        WebElement familyNameField = driver.findElement(By.name("familyName"));
        familyNameField.sendKeys(familyName);
        //Move to gender section
        WebElement genderSection = driver.findElement(By.id("genderLabel"));
        genderSection.click();
        WebElement genderSelect = driver.findElement(By.id("gender-field"));
        Select selectGender = new Select(genderSelect);
        selectGender.selectByVisibleText(gender);
        //Move to birthday section
        WebElement birthDaySection = driver.findElement(By.id("birthdateLabel"));
        birthDaySection.click();
        WebElement dayField = driver.findElement(By.id("birthdateDay-field"));
        dayField.sendKeys(birthDay);
        WebElement MonthField = driver.findElement(By.id("birthdateMonth-field"));
        Select selectMonthSelect = new Select(MonthField);
        selectMonthSelect.selectByVisibleText(birthMonth);
        WebElement birthYearField = driver.findElement(By.id("birthdateYear-field"));
        birthYearField.sendKeys(birthYear);
        //Move to address
        WebElement addressSection = driver.findElement(By.xpath("//span[.='Address']"));
        addressSection.click();
        WebElement addressField = driver.findElement(By.id("address1"));
        addressField.sendKeys(address);
        WebElement cityField = driver.findElement(By.id("cityVillage"));
        cityField.sendKeys(city);
        WebElement stateField = driver.findElement(By.id("stateProvince"));
        stateField.sendKeys(state);
        WebElement countryField = driver.findElement(By.id("country"));
        countryField.sendKeys(country);
        WebElement postalCodeField = driver.findElement(By.id("postalCode"));
        postalCodeField.sendKeys(PostalCode);
        //Move to ph number
        WebElement phoneNumberSection = driver.findElement(By.xpath("//span[.='Phone Number']"));
        phoneNumberSection.click();
        WebElement phoneNrField = driver.findElement(By.name("phoneNumber"));
        phoneNrField.sendKeys(phoneNr);
        //Relatives section
        WebElement relativesSection = driver.findElement(By.xpath("//span[.='Relatives']"));
        relativesSection.click();
        WebElement relativesNameField= driver.findElement(By.xpath("//input[@placeholder='Person Name']"));
        relativesNameField.sendKeys(relative);
        //Confirm Section
        WebElement confirmSection = driver.findElement(By.id("confirmation_label"));
        confirmSection.click();
        WebElement confirmButton = driver.findElement(By.id("submit"));
        confirmButton.click();
    }
    @Then("new patient is registered in the new table")
    public void new_patient_is_registered_in_the_new_table() {

    }

    @Given("user is logged in to demo.openmrs.org as admin")
    public void user_is_logged_in_to_demo_openmrs_org_as_admin() {
        System.out.println("Navigate to openMRS and login as admin");
    }




    @When("user creates a new patient with following base data: {string},{string},{string}")
    public void user_creates_a_new_patient_with_following_base_data(String givenName, String familyName, String gender) {
        System.out.println("Given name of new patient: "+givenName);
        System.out.println("Family name of new patient: "+familyName);
        System.out.println("Gender of new patient: "+gender);
    }
    @When("with extra information {string},{string},{string}")
    public void with_extra_information(String birthDay, String birthMonth, String birthYear) {
        System.out.println("Birth date is: "+birthDay+" "+birthMonth+" "+birthYear);
    }
    @When("with address: {string},{string},{string},{string}, and {string}")
    public void with_address_and(String address, String city, String state, String country, String postalCode) {
        System.out.println("Patient address is: "+address);
        System.out.println("Patient city is: "+city);
        System.out.println("Patient state is: "+state);
        System.out.println("Patient country is: "+country);
        System.out.println("Patient posta code is: "+postalCode);

    }
    @Then("new patient has beed registered with {string} and {string}")
    public void new_patient_has_beed_registered_with_and(String givenName, String familyName) {
        System.out.println("Registered patined with name: "+givenName+" and family name "+familyName);
    }
    @Then("address of new patient is {string},{string},{string}")
    public void address_of_new_patient_is(String address, String city, String state) {

        System.out.println("Registered patient address : "+address);
        System.out.println("Patient city is: "+city);
        System.out.println("Patient state is: "+state);
    }

    @Given("user2 logged in to demo.openmrs.org using negative data")
    public void user2_logged_in_to_demo_openmrs_org_using_negative_data() {

        driver.get("https://demo.openmrs.org/openmrs/login.htm");

    }




    @When("user is using given data:{string},{string},{string}")
    public void user_is_using_given_data(String usernameValue, String passwordValue, String location) {
        WebElement userNameField = driver.findElement(By.id("username"));
        userNameField.sendKeys(usernameValue);
        WebElement passWordField = driver.findElement(By.id("password"));
        passWordField.sendKeys(passwordValue);

        WebElement pharmacy = driver.findElement(By.id(location));
        pharmacy.click();

        WebElement loginBtn = driver.findElement(By.id("loginButton"));
        loginBtn.click();
    }
    @Then("{string} is shown")
    public void is_shown(String errorMessage) {
        WebElement error = driver.findElement(By.id("error-message"));
        Assert.assertTrue(error.isDisplayed());
    }
    @Then("user is still on login page")
    public void user_is_still_on_login_page() {
        String currentUrl = driver.getCurrentUrl();
        Assert.assertEquals(currentUrl,"https://demo.openmrs.org/openmrs/referenceapplication/login.page");
    }




}
