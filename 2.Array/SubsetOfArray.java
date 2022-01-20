package DSA.Array;
import java.util.Scanner;

public class SubsetOfArray {
    public static Scanner sc = new Scanner(System.in);

    public static void takeInput(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            arr[i] = sc.nextInt(); // setter
        }
    }
    
    public static void subsetarray(int[] arr){
        int n = arr.length;
        int total = (int)Math.pow(2,n);

        for(int i=0 ; i<total ; i++){
            String str = " ";
            int temp = i;

            for(int j=n-1 ; j>=0 ; j--){
                int rem = temp%2;
                temp = temp/2;

                if(rem == 0){
                    str = "*\t" + str;
                }
                else{
                    str = arr[j] + "\t" + str;
                }
        }
        System.out.println(str);
    }
}

    public static void main(String[] args) {
        int n  = sc.nextInt();
        int[] arr = new int[n];
        takeInput(arr);

        subsetarray(arr);
    }
}
