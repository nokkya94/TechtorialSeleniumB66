package codingBatMap;

import java.util.Arrays;

public class alphaCharacterInString {
    public static void main(String[] args) {

        String str = "Asjifskjfsjk12345Gfsfgfg44tt66";
        String arr [] = str.split("");

        System.out.println(Arrays.toString(arr));

        for (int i = 0; i<arr.length;i++){
            if(arr[i].equals("[^0-9.]")){
               arr[i] = arr[i].replace(arr[i],"");
            }
        }

        System.out.println(Arrays.toString(arr));

    }
}
