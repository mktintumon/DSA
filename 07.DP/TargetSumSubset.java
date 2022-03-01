
import java.util.*;

public class TargetSumSubset {

    public static boolean targetSum(int[] arr , boolean[][] dp){

        for(int i=0 ; i<dp.length ; i++){
            for(int j=0 ; j<dp[0].length ; j++){

                if(i == 0){
                    dp[i][j] = false;
                }

                else if(j == 0){
                    dp[i][j] = true;
                }

                else{
                    // not play -> ask previous
                    boolean noCall = dp[i-1][j];

                    // will play sets to false
                    boolean yesCall = false;
                    if(j - arr[i-1] >= 0){
                            yesCall = dp[i-1][j-arr[i-1]];
                    }

                    dp[i][j] = noCall || yesCall ;
                }
            }
        }

        return dp[dp.length-1][dp[0].length-1];
    }

    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int[] arr = new int[n];
        for(int i=0 ; i<n ; i++){
            arr[i] = sc.nextInt();
        }

        int target = sc.nextInt();

        boolean[][] dp = new boolean[n+1][target+1];
        boolean ans = targetSum(arr,dp);
        System.out.println(ans);
        sc.close();
    }
}