package cucumber_class.Homework;

import org.testng.annotations.DataProvider;

public class DataProv_TestCase3 {

    @DataProvider(name = "First Different Customer Jet Li")
    public Object[][] firstDifferentCustomer() {

        return new Object[][]{
                {"mngr294981","jupYjYz","Li", "02021994", "332 W Tonne St", "Seattle", "Washington", "234455", "4455523232", "jetLi99@gmail.com", "1234556"}

        };

    }

    @DataProvider(name = "Second Different Customer Jakob Macecki")
    public Object[][] secondDifferentCustomer() {
        return new Object[][]{
                {"Jakob", "02021984", "322 W Chicago St", "Chicago", "Illinois", "444555", "8899776655", "Jakob99@gmail.com", "99884433"}


        };
    }

    @DataProvider(name = "Third Different Customer Mike Vazovski")
    public Object[][] thirdDifferentCustomer () {
        return new Object[][]{
              {"Mike", "02051992", "322 S Cumberland Ave", "Indianapolis", "Indiana", "678324", "1289334455", "Mike92@gmail.com", "90909090"}

        };
    }

    @DataProvider(name = "4th Different Customer Isaac Newton")
    public Object[][] ForthDifferentCustomer () {
        return new Object[][]{
                {"Isaac", "08081991", "444 N Wester Ave", "Minneapolis", "Minnesota", "888999", "6767678677", "Isaac91@gmail.com", "55566655"}

        };
    }
}