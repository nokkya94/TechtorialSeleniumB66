package codingBatMap;

public class SwapTwoNumbers {

    public static void main(String[] args) {

        int a = 345;
        int b = 678;

        a = a + b; //800
        b = a - b; // 800 - 200; = 600
        a = a - b; // 800 - 600 = 200

        System.out.println(a+ " "+ b);

        String c = "Makaka";
        String d = "Banana";

        c= c+d; //makakabanana
        d = c.substring(0, c.length() - d.length());
        c = c.substring(d.length());

        System.out.println(c+ " " + d);
    }
}
