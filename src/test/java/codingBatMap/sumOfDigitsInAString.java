package codingBatMap;

public class sumOfDigitsInAString {

    public static void main(String[] args) {
        String value = "aasasd45-5ff221ff4-455tt";

        int sum=0;
        for(int i=0;i<value.length();i++){
            int counter=0;
            if((Character.isDigit(value.charAt(i)) )&& !(value.charAt(i-1)=='-')){
                String number=value.substring(i,i+1); //4
                counter++; //1
                for(int b=i+1;b<value.length();b++) {
                    if(Character.isAlphabetic(value.charAt(b))){
                        break;
                    }
                    if(Character.isDigit(value.charAt(b))) {
                        number = number + value.substring(b,b+1);
                        counter++;
                    }
                }
                sum=sum+Integer.parseInt(number);
            }else if((Character.isDigit(value.charAt(i))) && (value.charAt(i-1)=='-')){
                String number=value.substring(i,i+1);
                counter++;
                for(int b=i+1;b<value.length();b++) {
                    if(Character.isAlphabetic(value.charAt(b))){
                        break;
                    }
                    if(Character.isDigit(value.charAt(b))) {
                        number = number + value.substring(b,b+1);
                        counter++;
                    }
                }
                sum=sum-Integer.parseInt(number);
            }

            i=i+counter;
        }
        System.out.println(sum);
    }

}
