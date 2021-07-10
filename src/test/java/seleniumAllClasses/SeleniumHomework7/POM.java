package seleniumAllClasses.SeleniumHomework7;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class POM {


    public POM(WebDriver driver) {
        //initElements method will initialize the webelements
        //'this' keyword refers the class itself

        PageFactory.initElements(driver, this);
    }


    @FindBy(name = "uid")
    public WebElement usernameField;

    @FindBy(name = "password")
    public WebElement passwordField;

    @FindBy(name = "btnLogin")
    public WebElement loginButton;

    

}
