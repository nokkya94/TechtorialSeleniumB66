package codingBatMap;

import java.util.Arrays;

public class CodingBatIf6to7continue {
    public static void main(String[] args) {

        int [] nums={1, 6, 2, 2, 7, 1, 6, 99, 99, 7};
        int sum=0;
        for(int i=0; i<nums.length; i++){
            if(nums[i]==6){
                i++;
                if(nums[i]!=7){
                    i++;
                }else if(nums[i]==7){
                    continue;
                }
            }else{
                sum+=nums[i];
            }

        }

        System.out.println(Arrays.toString(nums));
    }
}
