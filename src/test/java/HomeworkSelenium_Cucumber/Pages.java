package HomeworkSelenium_Cucumber;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class Pages {

    public Pages(WebDriver driver){

        PageFactory.initElements(driver,this);

    }
    @FindBy(xpath = "//li[contains(@class,'not-in-more tab')]//span[@class='full-label']")
    public List<WebElement> functionalites;

    @FindBy(id = "field-lang")
    public WebElement selectLanguage;

    @FindBy(id = "btn-login")
    public WebElement loginButton;

    @FindBy(id = "nav-menu-dropdown")
    public WebElement hamburgerMenuClickNotSelect;

    @FindBy(id = "//a[@href='javascript:' and @class='nav-link action']")
    public WebElement logOutClickBtn;

    @FindBy(xpath = "//span[.='Accounts']")
    public WebElement accountsButton;
}
