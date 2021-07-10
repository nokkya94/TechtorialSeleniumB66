package cucumber_class.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AmazonHomePagePOM {

    public AmazonHomePagePOM(WebDriver driver){

        PageFactory.initElements(driver, this);

    }
    @FindBy(id = "twotabsearchtextbox")
    public WebElement amazonSearhBar;

}
