package codingBatMap;

import java.util.Arrays;

public class bat4After3 {
    public static void main(String[] args) {

        int nums[] = {2, 3, 2, 3, 2, 4, 4};

        for (int i = 0; i < nums.length; i++) {

            if (nums[i] == 4) {
                int temp = nums[i + 1];
                nums[i + 1] = 5;
                for (int j = i + 2; j < nums.length; j++) {
                    if (nums[j] == 5) {
                        nums[j] = temp;
                    }
                }

            }
        }
    }
    }
