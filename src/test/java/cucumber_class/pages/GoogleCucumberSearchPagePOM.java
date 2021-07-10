package cucumber_class.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class GoogleCucumberSearchPagePOM {


    public GoogleCucumberSearchPagePOM(WebDriver driver){

        PageFactory.initElements(driver,this);

    }

    @FindBy(xpath = "//div//h3")
    public List<WebElement> listOfResults;

    @FindBy(xpath = "//a[@aria-label='Page 2']")
    public WebElement secondPageButton;

    @FindBy(xpath = "//div//h3")
    public List<WebElement> getListOfResults2ndPage;


}
