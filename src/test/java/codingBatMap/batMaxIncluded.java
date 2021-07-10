package codingBatMap;

public class batMaxIncluded {
    public static void main(String[] args) {

        int [] nums = {1, 2, 1, 1, 3};
        int ans=0;
        for(int i=0; i<nums.length; i++){

            for(int j=0; j<nums.length; j++){

                if(nums[i]==nums[j]){
                    int max=j-i+1;
                    if(max>ans){
                        ans=max;
                    }
                }
            }
        }
        System.out.println(ans);

    }
}
