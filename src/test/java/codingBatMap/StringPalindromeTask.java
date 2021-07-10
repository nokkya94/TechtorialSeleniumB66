package codingBatMap;

public class StringPalindromeTask {

    public static void main(String[] args) {

        String palindrom = "civic";
        boolean isPalindrome = true;

           for (int i = 0 , j = palindrom.length()-1; i < j ; i++, j--){
               if(palindrom.charAt(i)!=palindrom.charAt(j)){
                   isPalindrome=false;
                   break;
               }
           }

        System.out.println(isPalindrome);


    }
}
