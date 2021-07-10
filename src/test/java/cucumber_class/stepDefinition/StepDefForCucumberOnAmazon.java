package cucumber_class.stepDefinition;

import Utils.Driver;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;


public class StepDefForCucumberOnAmazon {

    WebDriver driver= Driver.getDriver("chrome");

    @When("user navigates to {string} home page")
    public void user_navigates_to_home_page(String string) {
        driver.get("https://www.amazon.com/");
    }

    @When("user is searching for cucumber in searchbox")
    public void user_is_searching_for_cucumber_in_searchbox() {
        WebElement searchBOx = driver.findElement(By.id("twotabsearchtextbox"));
        searchBOx.sendKeys("Cucumber", Keys.ENTER);
    }

    @Then("user should validate the number of search results under the search bar to be more than {int}")
    public void user_should_validate_the_number_of_search_results_under_the_search_bar(Integer moreThan100) {
        WebElement numberOfResults = driver.findElement(By.xpath("//div[@class='a-section a-spacing-small a-spacing-top-small']//span[@dir='auto']"));
        Assert.assertEquals(numberOfResults.getText(),"1-48 of 150 results for");
    }

}
