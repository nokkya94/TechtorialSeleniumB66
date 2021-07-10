package seleniumAllClasses.JavaScriptExecuterPractice;

import com.google.common.base.CharMatcher;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;

public class Homework6 {
    WebDriver driver;
    SoftAssert softAssert;
    Actions actions;
    @BeforeClass
    public void setup(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        softAssert= new SoftAssert();
        actions = new Actions(driver);
    }

    @Test
    public void testCase1() throws InterruptedException{

        driver.get("https://demo.openemr.io/openemr");
        Thread.sleep(1000);
        WebElement username = driver.findElement(By.xpath("//input[@id='authUser']"));
        username.sendKeys("admin");
        Thread.sleep(1000);
        WebElement password = driver.findElement(By.xpath("//input[@id='clearPass']"));
        password.sendKeys("pass");
        Thread.sleep(500);
        String idOfParentPage=driver.getWindowHandle();
        WebElement submitButton = driver.findElement(By.xpath("//button[@type='submit']"));
        submitButton.click();
        driver.switchTo().defaultContent();
        /*
        driver.switchTo().frame(driver.findElement(By.xpath("//frameset[@cols='150,*']")));
        driver.switchTo().frame(driver.findElement(By.xpath("//frame[@src='left_nav.php']")));


         */
        WebElement searchBox = driver.findElement(By.xpath("/html/body/form/table[2]/tbody/tr[1]/td[2]/input"));
        searchBox.sendKeys("Belford");
        searchBox.sendKeys(Keys.RETURN);
        driver.switchTo().frame((WebElement) driver.findElement(By.xpath("//iframe[@name='fin']")));
        Thread.sleep(2000);
        WebElement name = driver.findElement(By.xpath("//td[@class='sorting_1']"));
        softAssert.assertTrue(name.getText().equals("Belford, Phil"));
        WebElement phNumber = driver.findElement(By.xpath("//tr[@id='pid_1']/td[2]"));
        softAssert.assertTrue(phNumber.getText().equals("333-444-2222"));
        WebElement ssn = driver.findElement(By.xpath("//tr[@id='pid_1']/td[3]"));
        softAssert.assertTrue(ssn.getText().equals("333222333"));
        WebElement dob = driver.findElement(By.xpath("//tr[@id='pid_1']/td[4]"));
        softAssert.assertTrue(dob.isDisplayed());
        WebElement externalIdHomePg = driver.findElement(By.xpath("//tr[@id='pid_1']/td[5]"));
        String externalID= externalIdHomePg.getText().trim();
        actions.moveToElement(name).click().perform();

        driver.switchTo().defaultContent();
        Thread.sleep(500);

        //Id and id are matching
        driver.switchTo().frame((WebElement) driver.findElement(By.xpath("//iframe[@name='pat']")));
        WebElement externalIdDashboard = driver.findElement(By.xpath("//td[@id='text_pubpid']"));
        String externalIdDash = externalIdDashboard.getText().trim();
        System.out.println(externalIdDashboard.getText());
        softAssert.assertTrue(externalID.equals(externalIdDash));
        //dob is displayed
        WebElement dobDash = driver.findElement(By.xpath("//td[@id='text_DOB']"));
        softAssert.assertTrue(dobDash.isDisplayed());
        String dobClean= (CharMatcher.inRange('0','9').retainFrom(dobDash.getText()));
        System.out.println(dobClean);
        DateTimeFormatter formatter=DateTimeFormatter.ofPattern("ddMMyyyy");
        LocalDate ld= LocalDate.parse("09021972" ,formatter);
        int year = ld.getYear();//birth year of the patient
        driver.switchTo().defaultContent();//we need to get out of Iframe to the upper date

        WebElement ageAccordingToDob = driver.findElement(By.xpath("//span[@data-bind='text:patient().str_dob()']"));
        String age = ageAccordingToDob.getText();
        System.out.println(age);
        age = age.substring(age.length()-2);
        int ageInt = Integer.parseInt(age);
        int currentYear =Calendar.YEAR;
        System.out.println(currentYear);
        softAssert.assertTrue(currentYear==year+ageInt);
        //now year is matching with current year - age

    }
    @Test
    public void testCase2() throws  InterruptedException{
        driver.get("https://demo.openemr.io/openemr");
        Thread.sleep(1000);
        WebElement username = driver.findElement(By.xpath("//input[@id='authUser']"));
        username.sendKeys("admin");
        Thread.sleep(1000);
        WebElement password = driver.findElement(By.xpath("//input[@id='clearPass']"));
        password.sendKeys("pass");
        Thread.sleep(500);
        String idOfParentPage=driver.getWindowHandle();
        WebElement submitButton = driver.findElement(By.xpath("//button[@type='submit']"));
        submitButton.click();
        WebElement searchBox = driver.findElement(By.xpath("//input[@id='anySearchBox']"));
        searchBox.sendKeys("Belford");
        WebElement searchButton = driver.findElement(By.xpath("//button[@id='search_globals']"));
        searchButton.click();
        Thread.sleep(1000);
        WebElement messagesButton =driver.findElement(By.xpath("//div[.='Messages']"));
        actions.moveToElement(messagesButton).click().perform();
        Thread.sleep(500);
        driver.switchTo().frame((WebElement) driver.findElement(By.xpath("//iframe[@name='msg']")));
        WebElement addButton = driver.findElement(By.xpath("//a[@class='btn btn-default btn-add']"));
        addButton.click();

        WebElement type = driver.findElement(By.id("form_note_type"));
        Select selectType = new Select(type);
        selectType.selectByVisibleText("Lab Results");

        WebElement user = driver.findElement(By.xpath("//select[@id='users']"));
        Select selectUser = new Select(user);
        selectUser.selectByVisibleText("Stone, Fred");

        WebElement textArea = driver.findElement(By.xpath("//textarea[@name='note']"));
        textArea.sendKeys("This is for testing");
        WebElement sendMessageBtn = driver.findElement(By.id("newnote"));
        sendMessageBtn.click();

        softAssert.assertTrue(textArea.isDisplayed());
        WebElement labResult = driver.findElement(By.xpath("//select[@name='form_note_type']/option[.='Lab Results']"));
        softAssert.assertTrue(labResult.isSelected());
        //there are some issues with test case 2 part 2, i dont see Contect
    }

    @Test
    public void testCase3() throws  InterruptedException{
        driver.get("https://demo.openemr.io/openemr");
        Thread.sleep(1000);
        WebElement username = driver.findElement(By.xpath("//input[@id='authUser']"));
        username.sendKeys("admin");
        Thread.sleep(1000);
        WebElement password = driver.findElement(By.xpath("//input[@id='clearPass']"));
        password.sendKeys("pass");
        Thread.sleep(500);
        String idOfParentPage=driver.getWindowHandle();
        WebElement submitButton = driver.findElement(By.xpath("//button[@type='submit']"));
        submitButton.click();
        Thread.sleep(1000);
        WebElement searchBox = driver.findElement(By.xpath("//input[@id='anySearchBox']"));
        searchBox.sendKeys("Belford");
        WebElement searchButton = driver.findElement(By.xpath("//button[@id='search_globals']"));
        searchButton.click();
        Thread.sleep(1000);



    }

}
