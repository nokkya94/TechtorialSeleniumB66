package codingBatMap;

public class secondLargest {
    public static void main(String[] args) {

        int [] arr = {200,100,300,500,400,450,800,250,900};
        int largest = arr [0];
        int secondLargest = 0;

        for (int i = 1; i<arr.length;i++ ){
            if(arr[i]>largest){
                secondLargest=largest;
                largest=arr[i];
            }
        }
        System.out.println(largest+" "+secondLargest);

    }
}
