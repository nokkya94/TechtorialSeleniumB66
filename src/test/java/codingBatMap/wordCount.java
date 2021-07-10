package codingBatMap;

import java.util.Arrays;

public class wordCount {
    public static void main(String[] args) {

        String str= "aa bb cc";
        String [] arr = str.split(" ");
        System.out.println(Arrays.toString(arr));
        int count = arr.length;
        System.out.println(count);

    }
}
