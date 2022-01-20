package DSA.Recursion;
import java.util.Scanner;

public class maxInArray {
    public static Scanner sc = new Scanner(System.in);

    public static int maxOfArray(int[] arr,int idx){
         if(idx == arr.length-1){ // if only one element then return that only
             return arr[idx];     // so we use (arr.length-1)
         }

         int recAns = maxOfArray(arr, idx+1);
         int myAns = arr[idx];

         return (myAns>recAns) ? myAns : recAns;
    }

    public static void main(String[] args) {
        int n = sc.nextInt();
        int[] arr = new int[n];
        for(int i=0 ; i<n ; i++){
            arr[i]= sc.nextInt();
        }
        
        int ans = maxOfArray(arr , 0);
        System.out.println(ans);

    }
    
}
