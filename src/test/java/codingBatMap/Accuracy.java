package codingBatMap;

import java.util.HashMap;
import java.util.Map;

public class Accuracy {
    String lol;
    public static void main(String[] args) {
        String str = "Hellooo";
        Map<Character,Integer> accuracy = new HashMap<>();

        for(int i =0 ; i<str.length(); i++){

            if(accuracy.containsKey(str.charAt(i))) {
                accuracy.put(str.charAt(i), accuracy.get(str.charAt(i))+1);
            }else{
                accuracy.put(str.charAt(i),1);
            }
        }
        System.out.println(accuracy);


    }

}
