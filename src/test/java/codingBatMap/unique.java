package codingBatMap;

public class unique {
    public static void main(String[] args) {
        int [] nums = {1,1,2,2,3,3,4};
        int i=0;

        while (i<nums.length) {
            if (nums[i] != nums[i + 1]) {
                System.out.println(nums[i]);
            }
            i = i + 2;
        }

    }
}
