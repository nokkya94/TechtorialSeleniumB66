package seleniumAllClasses.TestNGIntro;

import org.testng.annotations.Test;

public class Annotations2{



    @Test(invocationCount = 10)
    public void test1(){
        System.out.println("Test 1 execution");
    }
    @Test(expectedExceptions = {ArithmeticException.class , RuntimeException.class})
    public void test3(){
        System.out.println("Test");
        throw new ArithmeticException();
    }


}
