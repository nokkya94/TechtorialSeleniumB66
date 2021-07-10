package cucumber_class.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class EtsyResultsPage {

    public EtsyResultsPage(WebDriver driver){
        PageFactory.initElements(driver,this);
    }
    public  static  EtsyResultsPage getEtsyResultsPage(WebDriver driver){

        return new EtsyResultsPage(driver);
    }

    @FindBy(xpath = "//span[@class='currency-value']")
    public List<WebElement> allPrices;

}
