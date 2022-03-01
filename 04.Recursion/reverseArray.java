
import java.util.Scanner;

public class reverseArray{
    public static Scanner sc = new Scanner(System.in);

    public static void reverse(int[] arr , int idx){
        if(idx == arr.length){
            return;
        }
        
        reverse(arr, idx+1);
        System.out.println(arr[idx]);
    }

    public static void main(String[] args) {
        int n = sc.nextInt();
        int[] arr = new int[n];
        for(int i=0 ; i<n ; i++){
            arr[i]= sc.nextInt();
        }
        
        reverse(arr , 0);

    }
}

