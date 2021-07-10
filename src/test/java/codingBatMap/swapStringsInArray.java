package codingBatMap;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class swapStringsInArray {

    public static void main(String[] args) {

        String [] str = {"ax", "bx", "cx", "cy", "by", "ay", "aaa", "azz"};

//        for (int i = 0; i<str.length ; i++){
//            String startingWith = str[i].substring(0,1);
//            for(int j = i+1; j<str.length ; j++){
//                if(str[j].startsWith(startingWith) && str[j].length()==str[i].length()) {
//                    String temp = str[i];
//                    str[i] = str[j];
//                    str[j] = temp;
//                }
//            }
//
//        }
//        System.out.println(Arrays.toString(str));

        Map<String,Integer> map = new HashMap<>();

        for(int i = 0; i<str.length; i++){
            String key = String.valueOf(str[i].charAt(0));
            if(map.containsKey(key)){

                int position = map.get(key);
                String temp = str[position];
                str[position] = str[i];
                str[i] = temp;

                map.remove(key);

            }else {
                map.put(key,i);
            }
        }
        System.out.println(Arrays.toString(str));


    }



}
