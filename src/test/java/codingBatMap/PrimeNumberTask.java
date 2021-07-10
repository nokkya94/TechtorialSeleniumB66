package codingBatMap;

import java.util.Scanner;

public class PrimeNumberTask {

    public static void main(String[] args) {
//        Scanner scanner = new Scanner(System.in);
//        int StartingNumber = scanner.nextInt();
//        int endingNumber = scanner.nextInt();
//        int countPrimes;
//
//        for (int i = StartingNumber; i <= endingNumber; i++) {
//            countPrimes=0;
//            for (int j = 1; j <= i; j++) {
//                if (i % j == 0) {
//                    countPrimes = countPrimes + 1;
//                }
//            }
//
//            if (countPrimes == 2) {
//                System.out.println("This number" + i + " is prime");
//            }
//
//        }


        boolean isPrime = true;
        Scanner scanner1 = new Scanner(System.in);
        int oneNumber = scanner1.nextInt();
        int temp;

        for(int i = 2; i<oneNumber/2; i++){
            temp=oneNumber%i;
            if(temp==0){
                isPrime=false;
                break;
            }
        }
        if(isPrime){
            System.out.println(oneNumber+"is Prime Number");
        }else{
            System.out.println(oneNumber+" is not a Prime Number");
        }

    }
}