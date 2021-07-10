package codingBatMap;

public class FibonacciRecursion {
    public static void main(String[] args) {

        int numIteration = 9;
        System.out.println("Recursion:"+fibo(numIteration));

    }
    public static int fibo(int number){

        return fibo(number-1) + fibo(number-2);

    }
}
