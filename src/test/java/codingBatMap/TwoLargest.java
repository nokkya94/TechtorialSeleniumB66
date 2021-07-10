package codingBatMap;

import java.util.Arrays;

public class TwoLargest {
    public static void main(String[] args) {

        int a[] = {1, 20, 2, 50};
        int b[] = {3,4,5};


        int largestA = 0;
        int largestB = 0;
        for (int i = 0; i < a.length; i++) {
            int temp = 0;
            for (int k = i + 1; k < a.length; k++) {
                if (a[i] > a[k]) {
                    temp = a[i];
                    a[i] = a[k];
                    a[k] = temp;
                }
            }
        }
        for (int i = 0; i < b.length; i++) {
            int temp = 0;
            for (int k = i + 1; k < b.length; k++) {

                if (b[i] > b[k]) {
                    temp = b[i];
                    b[i] = b[k];
                    b[k] = temp;
                }
            }
        }
        System.out.println(Arrays.toString(a));
        System.out.println(Arrays.toString(b));
        for (int i = a.length - 1; i >= 0; i--) {
            if (a[i] % 10 == 0) {
                largestA = a[i];
                break;
            }
        }
        System.out.println(largestA);
        for (int i = b.length - 1; i >= 0; i--) {
            if (b[i] % 10 == 0) {
                largestB = b[i];
                break;
            }
        }
        System.out.println(largestB);

        System.out.println(largestA+largestB);
    }
}
