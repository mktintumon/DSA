
import java.util.*;

public class coinPermutation {

    public static int coinChangePermutation(int[] arr , int amt){
        int[] dp = new int[amt+1];
        dp[0] = 1; // fixed

        // we give chance to every cell to fill using every element of array then go to next cell
        for(int j=1 ; j< dp.length ; j++){
           for(int i=0 ; i<arr.length ; i++){
                 
                 if(j-arr[i] >= 0){
                     dp[j] += dp[j-arr[i]]; // addition
                 }
            }
        }

        return dp[amt];
    }

    public static void main(String[] args) throws Exception {
         
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();

        int [] arr = new int[n];
        for(int i = 0; i<n; i++)
            arr[i] = scn.nextInt();

        int amt = scn.nextInt();

        int ans = coinChangePermutation(arr, amt);
        System.out.println(ans);
        scn.close();
    }
}