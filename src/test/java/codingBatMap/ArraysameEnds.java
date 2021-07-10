package codingBatMap;

public class ArraysameEnds {
    public static void main(String[] args) {

        int [] nums = {5, 6, 45, 99, 13, 5, 6};
        int len = 2;

        boolean bol = false;
        int count=0;
        for(int i=0,  j=nums.length-len; i<len ; i++){
           while(j<nums.length){
               if(nums[i]==nums[j]){
                 count++;
               }
               j++;
           }
        }
        if(count == len){
            bol=true;
        }

        System.out.println(bol);
    }
}
