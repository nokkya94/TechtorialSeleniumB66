package codingBatMap;

import java.util.Arrays;

public class batnotAlone {
    public static void main(String[] args) {
        int val =2;
        int [] nums = {1,2,3,2,5,2};
        boolean isAlone = false;
        for(int i=1; i<nums.length-1; i++){

            if(nums[i]==val && (nums[i-1]!=val && nums[i-1]>0) && (nums[i+1]!=val && nums[i+1]>0)){
                isAlone=true;
            }
            if(isAlone){
                if(nums[i-1]>nums[i] && nums[i-1]>nums[i+1]){
                    nums[i]=nums[i-1];
                }else if(nums[i+1]>nums[i] && nums[i+1]>nums[i-1]){
                    nums[i]=nums[i-1];
                }
            }
        }
        System.out.println(Arrays.toString(nums));
    }
}
