package cucumber_class.ActionsPractice;

import com.google.common.base.CharMatcher;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

public class HomeworkSelenium4 {
    @Test
    public void Task1(){
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();

        driver.get("http://uitestpractice.com/Students/Select#");

        WebElement countrySelect = driver.findElement(By.xpath("//select[@id='countriesSingle']"));
        Select select = new Select(countrySelect);

        if(select.getFirstSelectedOption().getText().equals("India")){
            System.out.println("India by default, Validation succeed");
        }else{
            System.out.println("India is not by default, failed");
        }
        List<WebElement> dropDownOptions = select.getOptions();
        if(dropDownOptions.size()==4){
            System.out.println("Size of drop down box is 4, Validation succeed");
        }else{
            System.out.println("Validaton failed, size is not 4");
        }
        String[] countries = {"India","United states of America","China","England"};
        for (int i = 0; i<dropDownOptions.size();i++){
            if(dropDownOptions.get(i).getText().equals(countries[i])){
                System.out.println("Validation for drop down box country "+countries[i]+" succeed.");
            }else{
                System.out.println("Validation for drop down box country "+countries[i]+" failed.");
            }

        }

        select.selectByIndex(2);
        select.selectByValue("england");
        select.selectByVisibleText("United states of America");


    }
    @Test
    public void Task2(){
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();

        driver.get("http://uitestpractice.com/Students/Select#");
        WebElement countrySelect = driver.findElement(By.xpath("//select[@id='countriesMultiple']"));
        Select select = new Select(countrySelect);
        List<WebElement> dropDownOptions = select.getOptions();
        String[] countries = {"India","United states of America","China","England"};
        for (int i = 0; i<dropDownOptions.size();i++) {
            if (dropDownOptions.get(i).getText().equals(countries[i])) {
                System.out.println("Validation for drop down box country " + countries[i] + " succeed.");
            } else {
                System.out.println("Validation for drop down box country " + countries[i] + " failed.");
            }

        }
        select.selectByVisibleText("China");
        select.selectByVisibleText("England");
        WebElement displayedCountries = driver.findElement(By.xpath("//div[@id='result']"));

        if(displayedCountries.getText().equals("China England ")){
            System.out.println("Validation succeed, China England  is displayed.");
        }else {
            System.out.println("Validation failed, China England  is not displyed");
        }
        select.deselectAll();
        //now select all
        System.out.println("Select all thru for each");
        for (WebElement dropdowncountries : dropDownOptions){
            select.selectByVisibleText(dropdowncountries.getText());
        }
        if(displayedCountries.getText().equals("India United states of America China England")){
            System.out.println("Validation succeed, India United states of America China England");
        }else {
            System.out.println("Validation failed, India United states of America China England are not displayed");
        }
        select.deselectByIndex(2);
        System.out.println("China is deselected");
        select.deselectByValue("england");
        System.out.println("England is deselected");


    }
    @Test
    public void Task3() throws InterruptedException{
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();

        driver.get("https://www.cars.com/");
        driver.manage().window().maximize();
        WebElement newAndUsedCarsDrpDown = driver.findElement(By.xpath("//select[@aria-label='Select a stock type']"));
        Select select = new Select(newAndUsedCarsDrpDown);
        select.selectByVisibleText("Certified Cars");
        WebElement selectAmake = driver.findElement(By.xpath("//select[@aria-label='Select a make']"));
        Select select1 = new Select(selectAmake);
        select1.selectByVisibleText("Toyota");
        WebElement selectAmodel = driver.findElement(By.xpath("//select[@aria-label='Select a model']"));
        Select select2 = new Select(selectAmodel);
        select2.selectByVisibleText("Corolla");
        WebElement selectMaxPrice = driver.findElement(By.xpath("//select[@aria-label='Select a maximum price']"));
        Select select3 = new Select(selectMaxPrice);
        select3.selectByVisibleText("$30,000");
        WebElement selectMileage = driver.findElement(By.xpath("//select[@aria-label='Select a maximum distance']"));
        Select select4 = new Select(selectMileage);
        select4.selectByVisibleText("40 Miles from");
        WebElement zipCode = driver.findElement(By.xpath("//input[@type='tel']"));
        zipCode.sendKeys("60018");
        WebElement submit = driver.findElement(By.xpath("//input[@type='submit']"));
        submit.click();
        Thread.sleep(1000);

        WebElement titleElement = driver.findElement(By.className("srp-header"));

        Thread.sleep(1000);
        System.out.println(titleElement.getText());
        if(titleElement.getText().contains("Certified Used")){
            System.out.println("Validation Certified Used in title succeed");
        }else{
            System.out.println("Validation Certified Used in title failed");
        }
        System.out.println("Certified Used Toyota Corolla for Sale is displayed : " +titleElement.getText());

        //Here starts test3part2
        WebElement selectMiles = driver.findElement(By.xpath("//select[@name='rd']"));
        Select select5 = new Select(selectMiles);
        if(select5.getFirstSelectedOption().getText().equals("40 miles")){
            System.out.println("Validation 40 miles is selected passed");
        }else {
            System.out.println("Validtaion 40 miles is selected failed");
        }
        //Cert preowned is selected
        WebElement certPreownedRadio = driver.findElement(By.xpath("//input[@data-dtm='{ \"name\" :\"stkTypId\" ,\"value\": \"Certified Pre-Owned\" }']"));
        Assert.assertTrue(certPreownedRadio.isSelected(),"Certified Preowned Radio button is not selected");

        //Toyota is selected
        WebElement toyotaIsSelected = driver.findElement(By.xpath("//input[@value='20088']"));
        Assert.assertTrue(toyotaIsSelected.isSelected(),"Toyota is not selected in checkBox");

        //Corolla is selected
        WebElement corollaIsSelected = driver.findElement(By.xpath("//input[@value='20861']"));
        Assert.assertTrue(corollaIsSelected.isSelected(),"Corolla is not selected");
    }

    @Test
    public void testCase4() throws  InterruptedException{
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();

        driver.get("https://www.cars.com/");
        driver.manage().window().maximize();
        WebElement newAndUsedCarsDrpDown = driver.findElement(By.xpath("//select[@aria-label='Select a stock type']"));
        Select select = new Select(newAndUsedCarsDrpDown);
        select.selectByVisibleText("Certified Cars");
        WebElement selectAmake = driver.findElement(By.xpath("//select[@aria-label='Select a make']"));
        Select select1 = new Select(selectAmake);
        select1.selectByVisibleText("Lexus");
        WebElement selectAmodel = driver.findElement(By.xpath("//select[@aria-label='Select a model']"));
        Select select2 = new Select(selectAmodel);
        select2.selectByVisibleText("- ES 350");
        WebElement selectMaxPrice = driver.findElement(By.xpath("//select[@aria-label='Select a maximum price']"));
        Select select3 = new Select(selectMaxPrice);
        select3.selectByVisibleText("$50,000");
        WebElement selectMileage = driver.findElement(By.xpath("//select[@aria-label='Select a maximum distance']"));
        Select select4 = new Select(selectMileage);
        select4.selectByVisibleText("50 Miles from");
        WebElement zipCode = driver.findElement(By.xpath("//input[@type='tel']"));
        zipCode.sendKeys("60016");
        WebElement submit = driver.findElement(By.xpath("//input[@type='submit']"));
        submit.click();
        Thread.sleep(1000);
        //count the cars which are displayed on the first page
        List<WebElement> countOfAllCars = driver.findElements(By.xpath("//div[@class='shop-srp-listings__inner']"));
        int letsCount=0;
        for(int i = 0; i<countOfAllCars.size();i++){
            if(countOfAllCars.get(i).isDisplayed()) {
                letsCount++;
            }
        }
        System.out.println("Count of cars from the page is :"+letsCount);
        Assert.assertTrue(letsCount<=20,"Validation failed, there are more than 20 cars");

        List<WebElement> allTheCarsNames = driver.findElements(By.xpath("//h2[@class='listing-row__title']"));

        ArrayList<String> carNamesHasLX350 = new ArrayList<>();//we need this list to check if all names have Lexus ES 350
        for (int i= 0; i<allTheCarsNames.size();i++) {

            System.out.println(allTheCarsNames.get(i).getText());
            carNamesHasLX350.add(allTheCarsNames.get(i).getText());
        }
        //Validate all the cars have 'Lexus ES 350' in their name
        int anotherCount=0; // I will use this count to check if number of cars with LexusES350 is equal to the number of all the cars from the page
        for (int i=0; i<carNamesHasLX350.size();i++){
            if(carNamesHasLX350.get(i).contains("Lexus ES 350")){
                anotherCount++;
            }
        }
        Assert.assertTrue(letsCount==anotherCount,"Not all cars contain 'Lexus ES 350' in their name");

        //Getting how far is this car from the ZIP code
        List<WebElement> milesFromZipCode = driver.findElements(By.xpath("//div[@class='listing-row__distance ']"));
        List<Integer> letsGetMilesFromTheText = new ArrayList<>();
        int miles;
        int countOfCarsWithLessThan50=0;
        for(int i = 0 ; i <milesFromZipCode.size(); i++){
            System.out.println(milesFromZipCode.get(i).getText());
            //Here is an algorithm to get that miles from the text
            String s1;
            s1 = milesFromZipCode.get(i).getText();
            System.out.println(s1);
            s1= s1.substring(0,s1.indexOf(' '));
            miles = Integer.parseInt(s1);
            letsGetMilesFromTheText.add(miles);
            if(letsGetMilesFromTheText.get(i)<50){
                countOfCarsWithLessThan50++;
            }

        }
        System.out.println(letsGetMilesFromTheText);
        Assert.assertTrue(letsCount==countOfCarsWithLessThan50,"There are cars with miles from the zip code bigger than 50");

        WebElement selectSortBy = driver.findElement(By.xpath("//select[@class='select-sort-options']"));
        Thread.sleep(1000);

        Select select6 = new Select(selectSortBy);
        select6.selectByVisibleText("Price: Highest");
        List<WebElement> pricesOfAllCars = driver.findElements(By.xpath("//span[@class='listing-row__price ']"));
        List<Integer> pricesArr = new ArrayList<>();
        int pricesintDataType;
        boolean pricesRelatedBoolean= true;


        String s2 = pricesOfAllCars.get(0).getText();
        String s3 = CharMatcher.inRange('0','9').retainFrom(s2);

        for(int i=0; i<pricesOfAllCars.size();i++){
            System.out.println(pricesOfAllCars.get(i).getText());

            pricesintDataType = Integer.parseInt(s3);
            pricesArr.add(pricesintDataType);

        }
        Assert.assertTrue(pricesArr.get(0)<50000,"First car's price is higher than 50.000");

         



    }
}
