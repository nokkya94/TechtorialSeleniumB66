package codingBatMap;

import java.util.HashMap;
import java.util.Map;

public class codingBatMap {

    public static void main(String[] args) {
        String [] strings = {"a", "b", "a", "c", "b"};

        Map<String, Boolean> map = new HashMap<>();

        for(int i = 0; i<strings.length; i++){
            boolean b=false;
            for(int j = i+1; j<strings.length;j++){
                if(strings[i].equals(strings[j])){
                    b=true;
                }


            }
            if(!map.containsKey(strings[i])) {
                map.put(strings[i], b);
            }

        }

        System.out.println(map);


    }



}
