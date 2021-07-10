package codingBatMap;

public class taskExecuteclass {

    public static void main(String[] args) {
        //fibonacci nr
        int fibo1=1,fibo2=1,FibonacciNr;
        int iteration = 9; //we need just 9 loops to check the algorihithm
        for(int i = 0; i< iteration; i++){

            FibonacciNr=fibo1+fibo2;
            fibo1=fibo2;
            fibo2=FibonacciNr;

            System.out.println(FibonacciNr);
        }
    }
}
