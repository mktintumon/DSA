import java.util.*;

public class equalSumPartition{
    public static Scanner sc = new Scanner(System.in);

    public static boolean equalPartition(int[] arr){
        int n = arr.length;

        int sum = 0;
        for(int i=0 ; i<arr.length ; i++){
             sum += arr[i];
        }
        // if the sum of given arr is odd then not possibility of equal partition
        if(sum%2 != 0){
           return false;
        }

        // now question becomes same as target sum problem
        boolean[][] dp = new boolean[n+1][(sum/2)+1];
        return targetSum(arr , dp);
        
    }

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


    public static void main(String[] args) {
        int n = sc.nextInt();
        int[] arr = new int[n];
        for(int i=0 ; i<n ; i++){
            arr[i] = sc.nextInt();
        }

        boolean ans =  equalPartition(arr);
        System.out.println(ans);
    }
}