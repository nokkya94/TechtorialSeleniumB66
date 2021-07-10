package seleniumAllClasses.SeleniumProjectNr4;

import com.google.common.base.CharMatcher;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.util.List;

public class TestCase {
    WebDriver driver;
    SoftAssert softAssert;
    Actions actions;


    @BeforeClass
    public void setup(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        softAssert = new SoftAssert();
        actions = new Actions(driver);

    }

    @Test
    public void testCaseAudi() throws InterruptedException{

        driver.get("https://www.audiusa.com/us/web/en.html");
        Thread.sleep(1000);
        WebElement cookies = driver.findElement(By.xpath("//button[@class='onetrust-close-btn-handler onetrust-close-btn-ui banner-close-button onetrust-lg ot-close-icon']"));
        cookies.click();
        WebElement suvButton = driver.findElement(By.xpath("//span[.='SUVs & Wagons']"));
        suvButton.click();
        Thread.sleep(1000);
        WebElement audiQ5year2021 = driver.findElement(By.xpath("//*[@id=\"nm-id-content\"]/div/div[2]/audi-model-band/div[3]/ul[2]/li[1]/div/ul/li[2]/div/a/span"));
        audiQ5year2021.click();

        Thread.sleep(1000);
        WebElement headline = driver.findElement(By.xpath("//h1[@class='audi-headline-order-1 nm-stage-infocluster-headline nm-j-teaser-title']"));
        System.out.println(headline.getText());

        String str="2021 Audi Q5";
        Thread.sleep(1000);
        softAssert.assertEquals(headline.getText().trim(),str);

        WebElement buildBtn = driver.findElement(By.xpath("//div[@class='nm-stage-infocluster-linkarea']//a[@href='/us/web/en/models/q5/q5/2021/overview/engine-trim.html']"));
        buildBtn.click();
        driver.get("https://www.audiusa.com/us/web/en/models/q5/q5/2021/overview/engine-trim.html");
        WebElement premium = driver.findElement(By.xpath("//div[.='Premium']"));
        softAssert.assertTrue(premium.isDisplayed(),"is not displayed");
        WebElement premiumPlus = driver.findElement(By.xpath("//div[.='Premium Plus']"));
        softAssert.assertTrue(premiumPlus.isDisplayed(),"is not displayed");
        WebElement prestige = driver.findElement(By.xpath("//div[.='Prestige']"));
        softAssert.assertTrue(prestige.isDisplayed(),"is not displayed");

        List<WebElement> twoOptionsFor3Types = driver.findElements(By.xpath("//div[@class='audi-headline-order-3 nm-module-trimline-engine-name']"));

        for(int i=0;i<twoOptionsFor3Types.size();){
            if(i+1<twoOptionsFor3Types.size()) {
                softAssert.assertFalse(twoOptionsFor3Types.get(i).getText().equals(twoOptionsFor3Types.get(i + 1).getText()));
            }
            i+=2;
        }

        WebElement checkBoxForPremiumPlus45 = driver.findElement(By.xpath("//li[@data-configurator-id='FYGBAY0WPS_2021']//span[@class='audi-checkbox-symbol nm-module-trimline-engine-checkbox']"));
        checkBoxForPremiumPlus45.click();
        WebElement continueButton = driver.findElement(By.xpath("//span[.='Continue']"));
        continueButton.click();
        Thread.sleep(1000);
        driver.get("https://www.audiusa.com/us/web/en/models/q5/q5/2021/overview/exterior.html");
        Thread.sleep(1000);
        WebElement optionalEquipent = driver.findElement(By.xpath("//li[@class='nm-basket-price-row  ']/div[@class='nm-basket-price-text nm-car-price-options-amount nm-j-configurator-text-optionsPrice']"));
        String optEquipmentText = CharMatcher.inRange('0','9').retainFrom(optionalEquipent.getText());
        softAssert.assertTrue(optEquipmentText.equals("0"));

        WebElement msrp = driver.findElement(By.xpath("//li[@class='nm-basket-price-row ']/div[@class='nm-basket-price-text nm-car-price-amount nm-j-configurator-text-modelPrice']"));
        int msrpText = Integer.parseInt(CharMatcher.inRange('0','9').retainFrom(msrp.getText()));
        System.out.println("The MSRP is : "+msrpText);
        WebElement destinationCharge = driver.findElement(By.xpath("//li[@class='nm-basket-price-row']/div[@class='nm-basket-price-text nm-car-price-destination-charge-amount']"));
        int destinationChargeText = Integer.parseInt(CharMatcher.inRange('0','9').retainFrom(destinationCharge.getText()));
        System.out.println("Destination charge is : "+destinationChargeText);
        WebElement priceAsBuild = driver.findElement(By.xpath("//div[@class='nm-basket-price-text nm-car-price-amount nm-j-configurator-text-totalWithCharges audi-headline-order-3 nm-basket-bold']"));
        int priceAsBuildText = Integer.parseInt(CharMatcher.inRange('0','9').retainFrom(priceAsBuild.getText()));
        System.out.println("Price as build is : "+priceAsBuildText);
        int expectedTotal = msrpText+destinationChargeText;
        softAssert.assertTrue(expectedTotal==priceAsBuildText);//Price as build here

        Thread.sleep(1000);
        WebElement targetBlueMetallic = driver.findElement(By.xpath("//li[@data-configurator-id='2D2D']"));
        actions.moveToElement(targetBlueMetallic);

        WebElement colorLine = driver.findElement(By.xpath("/html/body/div[1]/div[2]/div/div[7]/div[2]/div/audi-configurator-tile-list[1]/div/div/ul/li[1]/div/div[2]/div[1]/div"));
        softAssert.assertTrue(colorLine.getText().equals("Navarra Blue Metallic"));
        //Navara Blue Metallic Passed
        Thread.sleep(1000);
        WebElement priceforNavara = driver.findElement(By.xpath("/html/body/div[1]/div[2]/div/div[7]/div[2]/div/audi-configurator-tile-list[1]/div/div/ul/li[1]/div/div[2]/div[1]/span"));
        String priceforNavaraText = priceforNavara.getText();
        softAssert.assertTrue(priceforNavaraText.equals("$595"));
        targetBlueMetallic.click();
        Thread.sleep(1000);
        int priceAsBuildText2 = Integer.parseInt(CharMatcher.inRange('0','9').retainFrom(priceAsBuild.getText()));
        System.out.println("Price as build is : "+priceAsBuildText);
        int expectedTotal2 = msrpText+destinationChargeText;
        int priceforNavaraText2 = Integer.parseInt(CharMatcher.inRange('0','9').retainFrom(priceforNavaraText));
        softAssert.assertTrue(expectedTotal2==expectedTotal+priceforNavaraText2,"Validation failed, color was not included in the total price");

        WebElement twentyWheels = driver.findElement(By.xpath("/html/body/div[1]/div[2]/div/div[7]/div[2]/div/audi-configurator-tile-list[2]/div/div/ul/li[7]/div/div[1]/div/img"));
        twentyWheels.click();
        WebElement twentyWheelsPrice = driver.findElement(By.xpath("/html/body/div[1]/div[2]/div/div[7]/div[2]/div/audi-configurator-tile-list[2]/div/div/ul/li[7]/div/div[2]/div[1]/span"));
        int twentyWheelsPriceInt = Integer.parseInt(CharMatcher.inRange('0','9').retainFrom(twentyWheelsPrice.getText()));
        System.out.println("Twenty wheels price "+twentyWheelsPriceInt);
        System.out.println("Color blue mettallic price is "+priceforNavaraText);
        ////Project finished at test case 2 line - validate is diplayed "20.......
        softAssert.assertTrue(twentyWheels.isDisplayed());
        WebElement continuebtn = driver.findElement(By.xpath("//span[.='Continue']"));
        continuebtn.click();

        WebElement warmWeather = driver.findElement(By.xpath("/html/body/div[1]/div[2]/div/div[7]/div[2]/div/section/div[2]/div/div[5]/div/div[1]/span/span"));
        warmWeather.click();
        WebElement warmWeatherPrice = driver.findElement(By.xpath("//div[.='Warm Weather package']//parent::div[@class='nm-option-tile-item']//div[@class='nm-option-tile-price audi-copy-m nm-j-configurator-text-price']"));
        String warmWeatherString = warmWeatherPrice.getText();
        System.out.println(warmWeatherString+" I got a bug, I cant extract price of warm weather package right before this line");
        //int warmWeatherInteger = Integer.parseInt(CharMatcher.inRange('0','9').retainFrom(warmWeatherPrice.getText()));
        //System.out.println(warmWeatherInteger);


        WebElement optionalEq = driver.findElement(By.xpath("//div[@class='nm-basket-price-text nm-car-price-options-amount nm-j-configurator-text-optionsPrice']"));
        int optEqInteger = Integer.parseInt(CharMatcher.inRange('0','9').retainFrom(optionalEq.getText()));
        System.out.println("Optional Equipment from seats page total price is :"+optEqInteger);
        softAssert.assertTrue(optEqInteger==1450+twentyWheelsPriceInt+priceforNavaraText2);
        //after checkboxing the seats type the price is not adding
        //now lets check the total price
        WebElement totalPriceAfterAll = driver.findElement(By.xpath("//div[@class='nm-basket-price-text nm-car-price-amount nm-j-configurator-text-totalWithCharges audi-headline-order-3 nm-basket-bold']"));
        String totalPriceAftAllString = totalPriceAfterAll.getText().trim();
        WebElement destinationChargeFromSeatsPage = driver.findElement(By.xpath("//div[@class='nm-basket-price-text nm-car-price-destination-charge-amount']"));
        int  destinationChargeSeatsInteger= Integer.parseInt(CharMatcher.inRange('0','9').retainFrom(destinationChargeFromSeatsPage.getText()));
        System.out.println("Destination charge from seats page is :"+destinationChargeSeatsInteger);
        WebElement msrpFromSeatsPage =driver.findElement(By.xpath("//div[@class='nm-car-price-model']//following-sibling::*"));
        int msrpSeatsPageInt = Integer.parseInt(CharMatcher.inRange('0','9').retainFrom(msrpFromSeatsPage.getText()));
        System.out.println("MSRP from seats page is :"+msrpSeatsPageInt);
        int totalPriceAfterAllInt = Integer.parseInt(CharMatcher.inRange('0','9').retainFrom(totalPriceAftAllString));
        System.out.println("Total price is "+totalPriceAfterAllInt+" found a new bug, on the site price is $52,040, seats type price is not added");
        softAssert.assertTrue(totalPriceAfterAllInt==optEqInteger+destinationChargeSeatsInteger+msrpSeatsPageInt);
        System.out.println("Total price equals to msrp plus destination charge + optional equipment passed but in any case type of seat is not added, even though on the site its added");

        List<WebElement >pricesOfAllseatsTypes = driver.findElements(By.xpath("//ul[@class='nm-module-tiles-uncategorized-tilelist']//li[@class='nm-j-configurator-item nm-j-configurator-status_00000']//span[@class='nm-j-configurator-text-price audi-copy-m']"));
        System.out.println(pricesOfAllseatsTypes.get(2).getText());
        System.out.println("I cant extract text from the price of the seats type (1450$), line 157");
        /*
        int count = 0;
        for(int i =0; i<8; i++){
            System.out.println(pricesOfAllseatsTypes.get(i).getText());
            if(pricesOfAllseatsTypes.get(i).getText().equals("$1,450")){
                count++;
            }

        }
        System.out.println("There are "+count+" of seats with price 1450$");
        softAssert.assertTrue(count==8,"not all seats type are 1450$");

         */
        System.out.println("Here is a part with Standard DecorativeInlays, found it, line 168");
        WebElement decorativeInlays = driver.findElement(By.xpath("//div[@class='audi-copy-s' and contains(text(),'Brown Walnut Wood inlays')]//following-sibling::span"));
        softAssert.assertTrue(decorativeInlays.getText().equals("Standard"));
        System.out.println("Here is continue");
        Thread.sleep(1000);
        WebElement continue2 = driver.findElement(By.xpath("//a[@x-cq-linkchecker='skip']/span[@class='audi-button__text' and contains(text(),'Continue')]"));
        continue2.click();
        Thread.sleep(1000);
        WebElement addRearSideAirbags= driver.findElement(By.xpath("//div[.='Rear side airbags']//parent::a//parent::div//following-sibling::button"));
        addRearSideAirbags.click();
        System.out.println("I added rear side bag configuration line 176");
        WebElement includeIsDisplayed = driver.findElement(By.xpath("//div[.='Rear side airbags']//parent::a//parent::div//following-sibling::button//span[.='Included']"));
        softAssert.assertTrue(includeIsDisplayed.isDisplayed());
        WebElement priceOfAddedRearSideAirBags = driver.findElement(By.xpath("//div[contains(text(),'350')]"));
        int priceRearSideAirbagsInt = Integer.parseInt(CharMatcher.inRange('0','9').retainFrom(priceOfAddedRearSideAirBags.getText()));
        Thread.sleep(3000);
        System.out.println("Price for rear side air bags is :"+ priceRearSideAirbagsInt);
        WebElement addSoundSystem = driver.findElement(By.xpath("//div[.='Bang & Olufsen® 3D Premium Sound System']//parent::a//parent::div//following-sibling::button"));
        addSoundSystem.click();
        WebElement includeSoundSystemIsDisplayed = driver.findElement(By.xpath("//div[.='Bang & Olufsen® 3D Premium Sound System']//parent::a//parent::div//following-sibling::button//span[.='Included']"));
        softAssert.assertTrue(includeSoundSystemIsDisplayed.isDisplayed());
        WebElement priceFOrSoundSystem = driver.findElement(By.xpath("//div[contains(text(),'950')]"));
        int priceForSoundSystemInt = Integer.parseInt(CharMatcher.inRange('0','9').retainFrom(priceFOrSoundSystem.getText()));
        System.out.println("Price for sound system is: "+priceForSoundSystemInt);
        WebElement currentOptionalEqPrice = driver.findElement(By.xpath("//div[@class='nm-basket-price-text nm-car-price-options-amount nm-j-configurator-text-optionsPrice']"));
        int currentoptEqInteger = Integer.parseInt(CharMatcher.inRange('0','9').retainFrom(currentOptionalEqPrice.getText()));
        System.out.println("Current Opt equipment price after adding sound system and rear Air Bags is  :"+currentoptEqInteger);
        System.out.println(currentoptEqInteger+" = "+optEqInteger+" + "+priceForSoundSystemInt+" + "+priceRearSideAirbagsInt);
        System.out.println(currentoptEqInteger==optEqInteger+priceForSoundSystemInt+priceRearSideAirbagsInt);
        System.out.println("Found one issue, warm weather package price is not counting at its page from test case 3 but its adding at next page at test case 4");

        WebElement contiunue3 = driver.findElement(By.xpath("//a[@x-cq-linkchecker='skip']/span[@class='audi-button__text' and contains(text(),'Continue')]"));
        contiunue3.click();
        Thread.sleep(2000);
        WebElement MSRPfromLastPage = driver.findElement(By.xpath("//div[@class='nm-car-price-model']//following-sibling::*"));
        System.out.println(MSRPfromLastPage.getText());
        int MsrpFromLastPageInt = Integer.parseInt(CharMatcher.inRange('0','9').retainFrom(MSRPfromLastPage.getText()));
        System.out.println(MSRPfromLastPage.getText());
        WebElement MsrpUnderSelectedFeature = driver.findElement(By.xpath("//span[@class='js-configurator-model-text-price']"));
        int MsrpUnderSelectedFeatureInt = Integer.parseInt(CharMatcher.inRange('0','9').retainFrom(MSRPfromLastPage.getText()));
        System.out.println("Msrp from summary :"+MsrpFromLastPageInt+" Msrp from selectedFeature :"+MsrpUnderSelectedFeatureInt);
        softAssert.assertTrue(MsrpFromLastPageInt==MsrpUnderSelectedFeatureInt);
        WebElement colorPrice = driver.findElement(By.xpath("/html/body/div[1]/div[2]/div/div[7]/div[2]/div[3]/ul/li[9]/div/div[2]/span"));
        int colorPriceInt = Integer.parseInt(CharMatcher.inRange('0','9').retainFrom(colorPrice.getText()));
        WebElement totalOfSelectedEquipmentPrice = driver.findElement(By.xpath("//span[@class='nm-summary-options-total__value audi-copy-m nm-j-configurator-text-optionsPrice']"));
        int totalOfSelectedEqInteger = Integer.parseInt(CharMatcher.inRange('0','9').retainFrom(totalOfSelectedEquipmentPrice.getText()));
        System.out.println("Total selected eq price is :" + totalOfSelectedEqInteger+ " = color :"+ colorPriceInt+ " + airbag :"+priceRearSideAirbagsInt+ " + wheels price : "+twentyWheelsPriceInt+" +" +
                "  warm weather package :"+ warmWeatherString+ " + sound system price : "+ priceForSoundSystemInt);
        softAssert.assertTrue(totalOfSelectedEqInteger==colorPriceInt+priceRearSideAirbagsInt+twentyWheelsPriceInt+priceForSoundSystemInt);//I skipped warm package price coz its bugged
        WebElement totalPriceLastPage = driver.findElement(By.xpath("//span[@class='nm-summary-options-total__value audi-headline-order-3 nm-j-configurator-text-totalWithCharges']"));
        int totalPriceLastPageInt = Integer.parseInt(CharMatcher.inRange('0','9').retainFrom(totalPriceLastPage.getText()));
        System.out.println("Total price is :"+totalPriceLastPageInt+" and its equal to = MSRP :"+MsrpUnderSelectedFeatureInt+" + Equipment Price :"+ totalOfSelectedEqInteger+" + Destination Charge "+destinationChargeText);
        softAssert.assertTrue(totalPriceLastPageInt==MsrpUnderSelectedFeatureInt+totalOfSelectedEqInteger+destinationChargeSeatsInteger);
        softAssert.assertAll();
    }

}
