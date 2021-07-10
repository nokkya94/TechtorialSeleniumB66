package cucumber_class.stepDefinition;

import Utils.Driver;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

public class StepDefForCucumberOnGoogle {


    WebDriver driver= Driver.getDriver("chrome");


    @When("user navigates to {string}")
    public void user_navigates_to(String google) {
       driver.get("https://www.google.com/");
    }

    @When("user is searching for cucumber")
    public void user_is_searching_for_cucumber() {


        WebElement searchBar = driver.findElement(By.name("q"));
        searchBar.sendKeys("Cucumber", Keys.ENTER);


    }

    @Then("user should validate the number of search results to be more than {int}")
    public void user_should_validate_the_number_of_search_results(Integer morethan100) {
        WebElement searchResults = driver.findElement(By.id("result-stats"));
        Assert.assertEquals(searchResults.getText(),"About 234,000,000 results");
    }




}
