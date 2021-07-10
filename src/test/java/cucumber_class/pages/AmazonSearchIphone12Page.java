package cucumber_class.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class AmazonSearchIphone12Page {

    public AmazonSearchIphone12Page(WebDriver driver){

        PageFactory.initElements(driver, this);

    }


    @FindBy(xpath = "//span[@class='a-price-whole']")
    public List<WebElement> allResultssPrices ;

}
