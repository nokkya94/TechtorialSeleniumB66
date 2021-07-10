package HomeworkSelenium_Cucumber;

import Utils.Driver;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.cucumber.java.eo.Se;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import java.util.List;


public class stepDefEspocrm {


    WebDriver driver = Driver.getDriver("chrome");
    Pages initElements;
    PagesAccountPage initElements2;

    @Given("user navigate to {string}")
    public void user_navigate_to(String url) {
        driver.get(url);
        driver.manage().window().maximize();
        initElements = new Pages(driver);
    }

    @When("user logs in demo.espocrm")
    public void user_logs_in_demo_espocrm() throws InterruptedException {
        Thread.sleep(2000);

           initElements.loginButton.submit();

    }

    @Then("user should see the function names")
    public void user_should_see_the_function_names(io.cucumber.datatable.DataTable dataTable) throws InterruptedException{
        Thread.sleep(3000);
       List<String> functionNames = dataTable.asList();
       for (int i =0; i<functionNames.size();i++){
           System.out.println("Names from feature file: "+functionNames.get(i));
           System.out.println("Names from List of WebElements: "+initElements.functionalites.get(i).getText());
           Assert.assertEquals(initElements.functionalites.get(i).getText(),functionNames.get(i));
       }
    }



}
