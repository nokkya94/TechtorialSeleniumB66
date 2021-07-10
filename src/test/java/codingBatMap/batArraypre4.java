package codingBatMap;

import java.util.Arrays;

public class batArraypre4 {
    public static void main(String[] args) {
        int [] nums={4, 4, 1, 2, 3};
        int len=0;
        for(int i=nums.length-1; i>0; i--){
            if(nums[i]!=4){
                len++;
            }else{
                break;
            }
        }
        System.out.println(len);
        int [] newArr = new int[len];

        for(int i=nums.length-len, q=0; i>0&&q<newArr.length; i++){
            if(nums[i]!=4){
                newArr[q]=nums[i];
                q++;
            }else{
                break;
            }
        }
        System.out.println(Arrays.toString(newArr));

    }
}
