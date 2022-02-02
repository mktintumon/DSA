import java.util.*;

public class zeroOneKnapsack {

    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] profit = new int[n];
        for(int i=0 ; i< n ; i++){
            profit[i] = sc.nextInt();
        }

        int[] weight = new int[n];
         for(int i=0 ; i< n ; i++){
            weight[i] = sc.nextInt();
        }

        int capacity = sc.nextInt();

        int[][] dp = new int[n+1][capacity+1];

        for(int i=0 ; i<dp.length ; i++){
            for(int j=0 ; j<dp[0].length ; j++){
                if( i == 0){
                    dp[i][j] = 0; // first row of dp when nobody plays
                }
                else{
                    int op1 = dp[i-1][j];  // not playing 

                    int op2 = 0; // playing -> then check for condition below
                     if(j - weight[i-1] >= 0){
                       op2 = profit[i-1] + dp[i-1][j-weight[i-1]]; //update playing 
                     }

                   dp[i][j] = Math.max(op1 , op2);
                }
            }
        }

        System.out.println(dp[n][capacity]);
        sc.close();
    }
}
