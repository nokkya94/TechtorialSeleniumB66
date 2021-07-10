package codingBatMap;

public class threeAdjacentNrs {
    public static void main(String[] args) {
        int [] nums = {1, 2, 3};
        int count = 0;
        boolean bol = false;
        for(int i=0; i<nums.length; i++){
            if(i<nums.length-2 && (nums[i]+1==nums[i+1]+1) && (nums[i+1]+2==nums[i+2])){
                count++;
            }
        }
        if(count==3){
            bol = true;
        }
    }
}
