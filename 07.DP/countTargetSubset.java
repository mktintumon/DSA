import java.util.*;

public class countTargetSubset {
    public static Scanner sc = new Scanner(System.in);

    public static int count(int[] arr , int[][]dp){
        int n = dp.length;
        int m = dp[0].length;

        for(int i= 0 ; i<n ; i++){
            for(int j=0 ; j<m ; j++){

                if(i==0 && j==0){ // first cell = 1 -> {}
                    dp[i][j] = 1;
                }
                else if(i == 0){  // no element in array
                    dp[i][j] = 0;
                }
                else if( j == 0){ // target=0 is possible -> not play anyone
                    dp[i][j] = 1;
                }
                else{
                    // 0-1 knapsack
                    int notPick = dp[i-1][j];

                    int pick = 0;
                    if(j - arr[i-1] >= 0){
                        pick = dp[i-1][j - arr[i-1]];
                    }

                    dp[i][j] = notPick + pick;
                }
            }
        }

        return dp[n-1][m-1];
    }
   

    public static void main(String[] args) {
        int n = sc.nextInt();
        int[] arr = new int[n];
        for(int i=0 ; i< n ; i++){
            arr[i] = sc.nextInt();
        }
         
        int tar = sc.nextInt();

        int[][] dp = new int[n+1][tar+1];

        int ans = count(arr , dp);
        System.out.println(ans);
        sc.close();
    }
}
