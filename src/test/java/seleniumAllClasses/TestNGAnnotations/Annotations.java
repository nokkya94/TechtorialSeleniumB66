package seleniumAllClasses.TestNGAnnotations;

import org.testng.Assert;
import org.testng.annotations.*;

public class Annotations {


    @Test(priority = 1, enabled = false)
    public void test1(){
        System.out.println("Test An 1");
    }
    @Test(priority = 0)
    public void test2(){
        System.out.println("Test An 2");
    }
    @Test(dependsOnMethods = "test4")
    public void test3(){
        System.out.println("Test An 3");
    }
    @Test
    public void test4(){
        System.out.println("Test An 4");
        Assert.assertTrue(false);
    }

    @BeforeMethod
    public void beforeMethod(){
        System.out.println("Before Method An");
    }
    @AfterMethod
    public void afterMethod(){
        System.out.println("After Methpd An");
    }
    @BeforeClass
    public void beforeClass(){
        System.out.println("Before Class An");
    }
    @AfterClass
    public void afterClass(){
        System.out.println("After Class An");
    }
    @BeforeTest
    public void beforeTest(){
        System.out.println("Before Test Annotation");
    }
    @AfterTest
    public void afterTest(){
        System.out.println("After Test Annotation");
    }
    @BeforeSuite
    public void beforeSuite(){
        System.out.println("Before suite Annotation");
    }
    @AfterSuite
    public void afterSuite(){
        System.out.println("After suite Annotation");
    }


}
