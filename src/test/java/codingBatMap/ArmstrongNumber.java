package codingBatMap;

public class ArmstrongNumber {

    public static void main(String[] args) {

        int num = 153; //we need initial number
        int originalnum=num; //we need a variable which represents initial number and can be changeble
        int result=0; //we need second number where we will add each digit at power 3, and then compare it with initial number
        int remainder;//we need a remainder variable which will save each last digit and then be added to resul
        while (originalnum!=0){

            remainder=originalnum%10;
            result+=Math.pow(remainder,3);
            originalnum/=10;

        }
        if(num==result){
            System.out.println("this number is armstrong number");
        }else {
            System.out.println("this is not an armstrong number");
        }



    }

}
