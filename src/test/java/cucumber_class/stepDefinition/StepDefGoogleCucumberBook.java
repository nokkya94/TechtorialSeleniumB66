package cucumber_class.stepDefinition;

import Utils.Driver;
import cucumber_class.pages.GoogleCucumberSearchPagePOM;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

public class StepDefGoogleCucumberBook {

    WebDriver driver= Driver.getDriver("chrome");
    GoogleCucumberSearchPagePOM initElements;

    @When("user is navigating to {string}")
    public void user_is_navigating_to(String url) {
        driver.get(url);
    }

    @When("user is searching for {string}")
    public void user_is_searching_for_cucumber_book(String cucumberBook) {
        WebElement searchBar = driver.findElement(By.name("q"));
        searchBar.sendKeys(cucumberBook+ Keys.ENTER);
    }

    @Then("user should compare the number of results from 1st page and 2nd page")
    public void user_should_compare_the_number_of_results_from_1st_page_and_2nd_page() throws InterruptedException {
        initElements= new GoogleCucumberSearchPagePOM(driver);
        int firstPage=initElements.listOfResults.size();

        initElements.secondPageButton.click();
        Thread.sleep(1000);

        int secondPage = initElements.getListOfResults2ndPage.size();

        System.out.println("First page "+firstPage+" Second page "+secondPage);

        Assert.assertTrue(firstPage+secondPage>20);


    }

}
