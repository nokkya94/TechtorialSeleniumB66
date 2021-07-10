package codingBatMap;

public class FactorialTask {

    public static void main(String[] args) {

        long fact = 1;
        for (int i = 2; i <= 20; i++) {
            fact = fact * i;
        }
        System.out.println(fact);
    }
}
