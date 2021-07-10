package cucumber_class.AssertPractice;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class AssertPractice {

    @Test
    public void test1(){
        //it will only effect the current test ann
        Assert.assertEquals(3,5);
        System.out.println("Hard assert");

    }

    @Test
    public void test2(){

        Assert.assertEquals(5,5);
        System.out.println("After asser 1");
        Assert.assertEquals(3,5);
        System.out.println("After asser 2");
        Assert.assertEquals(6,5);
        System.out.println("After asser 3");

    }

    @Test
    public void test3(){
        SoftAssert soft = new SoftAssert();
        

    }



}
