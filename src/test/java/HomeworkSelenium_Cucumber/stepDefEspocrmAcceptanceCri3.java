package HomeworkSelenium_Cucumber;

import Utils.Driver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class stepDefEspocrmAcceptanceCri3 {

    WebDriver driver= Driver.getDriver("chrome");
    PagesForUsersPage initElements;
    Pages initElements2;

    @Given("user navigates to {string} to validate users")
    public void user_navigates_to_to_validate_users(String url)throws InterruptedException {
        driver.get(url);
        driver.manage().window().maximize();
        initElements = new PagesForUsersPage(driver);
        WebElement loginBtn = driver.findElement(By.id("btn-login"));
        try {
            loginBtn.click();
        }catch (Exception ex){
            System.out.println("User is logged in already");
        }
        Thread.sleep(3000);

    }

    @When("user click the three dots at the end of functionality names")
    public void user_click_the_three_dots_at_the_end_of_functionality_names() throws InterruptedException{
        Thread.sleep(1000);
      initElements.threeDot.click();
    }

    @Then("user clicks the Users")
    public void user_clicks_the_users() {
     initElements.usserFromThreeDot.click();
      
    }



    @Then("user should see given table of Name and Email columns")
    public void user_should_see_given_table_of_name_and_email_columns(io.cucumber.datatable.DataTable dataTable) {

        Map<String,String>  usersData =  dataTable.asMap(String.class,String.class);

        System.out.println(usersData);

        Map<String,String> twoArrays = new LinkedHashMap<>();

        /*
        String expectedName;
        String expectedEmail;
        for (int i = 0 ; i<initElements.usersNameList.size();i++){
            expectedName="Name="+initElements.usersNameList.get(i).getText();
            expectedEmail="Email="+initElements.usersEmailsList.get(i).getText();
            System.out.println(expectedName+" , "+expectedEmail);
           // System.out.println(usersData.getKey);
        }

        throw new io.cucumber.java.PendingException();

         */
    }



}
