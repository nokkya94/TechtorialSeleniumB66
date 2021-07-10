package codingBatMap;

import java.util.Arrays;

public class codingBatAp1MergeTwo {
    public static void main(String[] args) {

        String [] a = {"a", "c", "z"};
        String [] b = {"b", "f", "z"};

        String [] newAr = new String [a.length+b.length];
        int count =0;
        for(int i=0; i<a.length; i++){
            newAr[i]=a[i];
            count++;
        }
        for(int i=0; i<b.length; i++){
            newAr[count++]=b[i];

        }
        for(int i=0; i<newAr.length; i++){
            String temp="";
            for(int k=i+1; k<newAr.length ; k++){
                if(newAr[i].charAt(0)>newAr[k].charAt(0)){
                    temp=newAr[i];
                    newAr[i]=newAr[k];
                    newAr[k]=temp;
                }
            }
        }
        String [] newnewAr = new String[3];
        for(int i=0; i<newnewAr.length; i++){
            newnewAr[i]=newAr[i];
        }

    }
}
