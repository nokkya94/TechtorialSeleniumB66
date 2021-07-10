package codingBatMap;

import java.util.Arrays;

public class FizzBuzz {
    public static void main(String[] args) {
        int start=1;
        int end=6;
        String [] str = new String [end-start];
        for(int i = 0; i<str.length; i++){
            int temp = start+i;
            if(temp%3==0 ){
                str[i]="Fizz";
            }else if(temp%5==0 ){
                str[i]="Buzz";
            }else if(temp%3==0 && temp%5==0 ){
                str[i]="FizzBuzz";
            }else {
                str[i]=String.valueOf(i);
            }
        }
        System.out.println(Arrays.toString(str));
    }
}
