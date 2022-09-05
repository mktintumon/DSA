
import java.util.Scanner;

public class subArray {
    public static Scanner sc = new Scanner(System.in);
    
    public static void takeInput(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            arr[i] = sc.nextInt(); // setter
        }
    }

    public static void subarray(int[] arr){
        int n = arr.length;

        //int sum=0;    for finding sum of odd length subarray
        //              end+=2 and sum += arr[k] and return sum.

        for(int start=0 ; start<n ; start++){
            for(int end = start ; end<n ; end++){
                for(int k = start; k<=end ; k++){
                    System.out.print(arr[k]+ " ");
                }
                System.out.println();
        }
    }

    }

    public static void main(String[] args) {
        int n  = sc.nextInt();
        int[] arr = new int[n];
        takeInput(arr);

        subarray(arr); // total subarray = (n*(n+1))/2
    }
}
