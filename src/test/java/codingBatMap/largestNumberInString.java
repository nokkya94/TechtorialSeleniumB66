package codingBatMap;


import java.util.Arrays;

public class largestNumberInString {
    public static void main(String[] args) {

        int [] nums = {2,11,5,10,43,212,88,8,9};


        for(int i=0; i< nums.length; i++){
            int temp=0;
           for(int j=i+1; j< nums.length; j++){
               if(nums[i]>nums[j])
               {
                   temp=nums[i];
                   nums[i]=nums[j];
                   nums[j]=temp;
               }
           }
        }

        String [] str= new String[nums.length];
        String temp1="";
        String largestNr="";
        for(int i=0; i<nums.length; i++){
            str[i]=String.valueOf(nums[i]);
        }
        for(int i=0; i< str.length; i++) {

            for (int j = i + 1; j < str.length; j++) {
                String str1 = "" + str[i] + str[j]; //211
                String str2 = "" + str[j] + str[i]; //112
                if (Integer.parseInt(str1) > Integer.parseInt(str2)) {
                    temp1=str[i];
                    str[i]=str[j];
                    str[j]=temp1;
                }
            }
        }
        for(int i= str.length-1; i>=0; i--){
            largestNr+=str[i];
        }
        System.out.println(largestNr);
        System.out.println(Arrays.toString(str));






    }
}
