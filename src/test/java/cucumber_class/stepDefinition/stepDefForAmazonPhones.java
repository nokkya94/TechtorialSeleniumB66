package cucumber_class.stepDefinition;

import Utils.Driver;
import cucumber_class.pages.AmazonHomePagePOM;
import cucumber_class.pages.AmazonSearchIphone12Page;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

public class stepDefForAmazonPhones {

    WebDriver driver = Driver.getDriver("chrome");
    AmazonSearchIphone12Page initElements2;
    AmazonHomePagePOM initElements;

    @Given("user navigates to {string} for searching")
    public void user_navigates_to_for_searching(String url) {
        driver.get(url);


    }

    @When("user is searching for {string} in search box")
    public void user_is_searching_for_in_search_box(String iphone) {

        initElements = new AmazonHomePagePOM(driver);
        initElements.amazonSearhBar.sendKeys(iphone + Keys.ENTER);

    }

    @Then("number of results should be more than {int}")
    public void number_of_results_should_be_more_than(Integer numberOfResults) {


        initElements2 = new AmazonSearchIphone12Page(driver);
        Assert.assertTrue(initElements2.allResultssPrices.size() > 0);


    }

    @Then("sum of the result's prices must be > than {int}")
    public void sum_of_the_result_s_prices_must_be_than(Integer int1) {

        initElements2 = new AmazonSearchIphone12Page(driver);
        double sum = 0;
        for (WebElement prices : initElements2.allResultssPrices) {

            System.out.println(prices.getText());
            if (prices.getText().contains(",")) {
                sum += Double.parseDouble(prices.getText().replace(",",""));
            }else {
                sum +=Double.parseDouble(prices.getText());
            }

        }
        System.out.println(sum);
    }
}