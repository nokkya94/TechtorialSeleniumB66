package codingBatMap;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class CodingMap {
    public static void main(String[] args) {
//        String [] strings = {"salt", "tea", "soda", "toast"};
//        Map<String,String> map = new HashMap<>();
//        for(int i=0; i<strings.length; i++){
//            String key = strings[i].substring(0,1);
//            String word = strings[i];
//            if(map.containsKey(key)){
//                map.put(key,map.get(key)+strings[i]);
//            }else{
//                map.put(key,word);
//            }
//
//        }
//        System.out.println(map);

        String [] str = {"a", "b", "a", "c", "a", "d", "a"};
        String result="";
        Map<String,Integer> accuracy = new HashMap<>();
        for(int i =0 ; i<str.length; i++){

            if(accuracy.containsKey(str[i])) {
                accuracy.put(str[i], accuracy.get(str[i])+1);
            }else{
                accuracy.put(str[i],1);
            }

            if(accuracy.get(str[i])%2==0){
                result+=str[i];
            }
        }

        System.out.println(result);
    }
}
