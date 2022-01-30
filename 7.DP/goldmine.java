
import java.util.*;

public class goldmine {

    // Memoization method
    public static int goldmineM(int i , int j , int[][] grid , int[][] dp){
       
       int n = grid.length;
       int m = grid[0].length;

       if(i >= n || i< 0 || j>=m ){
            return 0;
       }

       if(dp[i][j] != 0){
           return dp[i][j];
       }

       int op1 = goldmineM(i-1 , j+1 , grid , dp);
       int op3 = goldmineM(i , j+1 , grid , dp);
       int op2 = goldmineM(i+1 , j+1 , grid , dp);

       int max = Math.max(op1 , Math.max(op2,op3));

       dp[i][j] = max + grid[i][j];

       return dp[i][j];
    }

    //tabulation method
    public static int goldmineT(int[][] grid , int[][] dp){
        int n = grid.length;
        int m = grid[0].length;

        //start from last colm to first col
        for(int j=m-1 ; j>=0 ; j--){ // start from last column 
            for(int i=0 ; i<n ; i++){ // move in the row

                if(j==m-1){  // last column
                    dp[i][j] = grid[i][j];
                }

                else if(i==0){ // first row
                     int op1 = dp[i][j+1];
                     int op2 = dp[i+1][j+1];

                     dp[i][j] = grid[i][j] + Math.max(op1, op2);
                }

                else if(i == n-1){ // last row
                    int op1 = dp[i][j+1];
                    int op2 = dp[i-1][j+1];

                    dp[i][j] = grid[i][j] + Math.max(op1, op2);
                }

                else{ // left elements
                    int op1 = dp[i][j+1];
                    int op2 = dp[i+1][j+1];
                    int op3 = dp[i-1][j+1];

                    dp[i][j] = grid[i][j] + Math.max(op1, Math.max(op2 , op3));
                }
            }
        }

        int ans = 0;
        for(int i=0 ; i<n ; i++ ){
            if(dp[i][0] > ans){
                ans = dp[i][0];
            }
        }
        return ans;
    }

    public static void main(String[] args) throws Exception {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int m = scn.nextInt();
        
        int [][] arr = new int[n][m];
        for(int i = 0; i<n; i++){
            for(int j = 0; j<m; j++ ){
                arr[i][j] = scn.nextInt();
            }
        }

        int[][] dp = new int[n][m];

        // FOR MEMOIZATION
        // int ans = 0; // start
        // for(int i=0 ; i < n ; i++){ // travel in first col
            
        //     int temp = goldmineM(i , 0 , arr , dp);
        //     if(temp > ans){
        //         ans = temp;
        //     }
        // }

        int ans = goldmineT(arr , dp);

        System.out.println(ans);
        scn.close();

    }

}