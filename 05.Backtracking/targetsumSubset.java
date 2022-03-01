import java.util.*;

public class targetsumSubset {
    public static Scanner sc = new Scanner(System.in);

    public static void targetSum(int[] arr , String path , int idx , int tar , int sum){
        if(sum > tar){
            return;
        } 
        
        if(arr.length ==idx){
             //reach the base case then check for the sum=target
             //if not get the sum=target then it backtrace the path 
             if(sum == tar){
                 System.out.println(path + ".");
             }
              return;
         }


         targetSum(arr, path+arr[idx]+",", idx+1 , tar ,sum+arr[idx]); // pick
         targetSum(arr, path, idx+1, tar, sum); // not pick

    }

    public static void main(String[] args) {
        int n = sc.nextInt();
        int[] arr = new int[n];
        for(int i=0 ; i<n ; i++){
            arr[i] = sc.nextInt();
        }

        int tar = sc.nextInt();
        targetSum(arr,"" ,0,tar,0);    
        
    }
}
