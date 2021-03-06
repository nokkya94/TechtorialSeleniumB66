package seleniumAllClasses.TestNGIntro;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DataProviderAnnotation2 {

    @Test(dataProvider = "data")
    public void testData(String name, int age){

        System.out.println("Name :"+ name +", age: "+ age);

    }
    @DataProvider(name = "data")
    public Object [] [] get(){

        return generateData();

    }

    public static Object [] [] generateData(){
        return new Object[][]{
                {"Adam",19},
                {"Sarah",20},
        };
    }
}
