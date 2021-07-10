package HomeworkSelenium_Cucumber;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class PagesForUsersPage {

    public PagesForUsersPage(WebDriver driver){

        PageFactory.initElements(driver,this);

    }
    @FindBy(xpath = "//td[@class='cell' and @data-name='name']/a")
    public List<WebElement> usersNameList;

    @FindBy(xpath = "//a[@data-action='mailTo']")
    public List<WebElement> usersEmailsList;

    @FindBy(xpath = "//span[@class='fas fa-ellipsis-h more-icon']")
    public WebElement threeDot;

    @FindBy(xpath = "//a[@href='#User']")
    public WebElement usserFromThreeDot;

}
