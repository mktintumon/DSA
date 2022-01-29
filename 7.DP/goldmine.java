
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