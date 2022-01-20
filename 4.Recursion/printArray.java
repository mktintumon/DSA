package DSA.Recursion;
import java.util.Scanner;

public class printArray {
    public static Scanner sc = new Scanner(System.in);

    public static void print(int[] arr , int idx){
        if(idx == arr.length){
            return;
        }
        System.out.println(arr[idx]);
        print(arr, idx+1);
    }

    public static void main(String[] args) {
        int n = sc.nextInt();
        int[] arr = new int[n];
        for(int i=0 ; i<n ; i++){
            arr[i]= sc.nextInt();
        }
        
        print(arr , 0);

    }
}
