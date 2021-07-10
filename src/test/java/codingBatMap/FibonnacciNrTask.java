package codingBatMap;

public class FibonnacciNrTask {

    public static void main(String[] args) {

        int maximumNumber = 20; //boundaries
        int fibonacci1 = 1, fibonacci2 = 1, FiboNumber;

        for(int i = 0; i< maximumNumber; i++){
            FiboNumber= fibonacci1+fibonacci2;
            fibonacci1=fibonacci2;
            fibonacci2=FiboNumber;

            System.out.println("Iteration  "+FiboNumber);
        }

    }



}
