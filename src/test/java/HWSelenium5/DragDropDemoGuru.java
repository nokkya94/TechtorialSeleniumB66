package HWSelenium5;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Base64;
import java.util.List;

public class DragDropDemoGuru {


    @Test
    public void testCase4() throws InterruptedException {

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();

        driver.get("http://demo.guru99.com/test/drag_drop.html");
        driver.manage().window().maximize();
        Thread.sleep(1000);
        WebElement dragMinusFiveThousand = driver.findElement(By.xpath("//*[.=' -5000 ']"));
        WebElement dragFiveThousand = driver.findElement(By.xpath("//*[.=' 5000 ']"));// icreated this element because
        //if we just click and hold on -5000 nothing happens, we need to move it a little bit, so i decided to move
        //to location of 5000
        WebElement pleaseSelectAnother = driver.findElement(By.xpath("//div[@class='e14']"));

        Actions dragYellowBoxes = new Actions(driver);
        dragYellowBoxes.clickAndHold(dragMinusFiveThousand).moveToElement(dragFiveThousand).perform();
        Assert.assertTrue(pleaseSelectAnother.isDisplayed());//true
        
    }
    @Test
    public void testCase4sametask() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();

        driver.get("http://demo.guru99.com/test/drag_drop.html");
        driver.manage().window().maximize();
        Thread.sleep(1000);

        WebElement dragFiveThousand = driver.findElement(By.xpath("//*[.=' 5000 ']"));//element
        WebElement AmountFirstBox = driver.findElement(By.id("amt7"));//target


        Actions dragYellowBoxes1 = new Actions(driver);

        dragYellowBoxes1.dragAndDrop(dragFiveThousand,AmountFirstBox).perform();


        List<WebElement> tableBelow = driver.findElements(By.xpath("//td[@width='350']"));

        //4 elements from table below

        String DebitMovement=tableBelow.get(0).getText();
        System.out.println(DebitMovement);

        String AmountFromDebitMovement=tableBelow.get(1).getText();
        System.out.println(AmountFromDebitMovement);

        String CreditMovement=tableBelow.get(2).getText();
        System.out.println(CreditMovement);

        String AmountFromCreditMovement=tableBelow.get(3).getText();
        System.out.println(AmountFromCreditMovement);

        Assert.assertTrue(DebitMovement.equals("Debit Movement")&&AmountFromDebitMovement.equals("5000")
        &&CreditMovement.equals("Credit Movement")&&AmountFromCreditMovement.equals("0"));

        WebElement secondFiveThousand= driver.findElement(By.xpath("//li[@data-id='2'][2]//a"));
        WebElement creditSideAmount = driver.findElement(By.id("amt8"));


        dragYellowBoxes1.dragAndDrop(secondFiveThousand,creditSideAmount).perform();
        //I made different variables for second dragging of 5000 to credit
        String DebitMovement2=tableBelow.get(0).getText();
        System.out.println(DebitMovement);

        String AmountFromDebitMovement2=tableBelow.get(1).getText();
        System.out.println(AmountFromDebitMovement);

        String CreditMovement2=tableBelow.get(2).getText();
        System.out.println(CreditMovement);

        String AmountFromCreditMovement2=tableBelow.get(3).getText();
        System.out.println(AmountFromCreditMovement);

        Assert.assertTrue(DebitMovement2.equals("Debit Movement")&&AmountFromDebitMovement2.equals("5000")
                &&CreditMovement2.equals("Credit Movement")&&AmountFromCreditMovement2.equals("5000"));

        WebElement BANK = driver.findElement(By.xpath("//*[.=' BANK ']"));
        WebElement debitSideAccount = driver.findElement(By.xpath("//*[@id='bank']/li"));

        dragYellowBoxes1.dragAndDrop(BANK,debitSideAccount).perform();
        Thread.sleep(1000);
        WebElement debitSideAccountBoxText = driver.findElement(By.xpath("//ol//li[@data-id='5']"));
        Assert.assertTrue(debitSideAccountBoxText.getText().equals("BANK")&& debitSideAccountBoxText.isDisplayed());


        WebElement salesYellowBox = driver.findElement(By.xpath("//*[.=' SALES ']"));
        WebElement creditSideAccount = driver.findElement(By.xpath("//ol[@class='field15 ui-droppable ui-sortable']"));

        dragYellowBoxes1.dragAndDrop(salesYellowBox,creditSideAccount).perform();
        WebElement accountCreditSideBoxText = driver.findElement(By.xpath("//ol//li[@data-id='6']"));
        Assert.assertTrue(accountCreditSideBoxText.getText().equals("SALES")&&accountCreditSideBoxText.isDisplayed());

    }



}
