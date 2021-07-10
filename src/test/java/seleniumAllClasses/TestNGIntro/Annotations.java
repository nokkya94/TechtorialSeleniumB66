package seleniumAllClasses.TestNGIntro;

import org.testng.Assert;
import org.testng.annotations.Test;

public class Annotations {

    @Test
    public void testB(){
        System.out.println("Test annotation 1");
        String expectedTitle = "Techtorial";

        Assert.assertEquals("Tech",expectedTitle);
        //Hard Assertion: If assert fails. the code will stop running and next line will not be executed
    }
    @Test
    public void testA(){
        System.out.println("Test annotation 2");
        String expectedURL="www.google.com";
        String actualURL="www.google.com";

        Assert.assertTrue(expectedURL.equals(actualURL));

    }

}
