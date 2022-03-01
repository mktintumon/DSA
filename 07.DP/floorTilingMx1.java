import java.util.*;

public class floorTilingMx1{

    public static int tiling(int n , int m){
        int[] dp = new int[n+1];
        dp[1] = 1;
        dp[2] = 2;

        //Three cases to handle
        for(int i=3 ; i<=n ; i++){

            if(i < m){
                dp[i]  = 1; // only horizontal placement
            }
            else if(i == m){ // only hori and vert placement , no other possible
                dp[i] = 2 ; 
            }
            else{ // all others except above two

                dp[i] = dp[i-1] + dp[i-m];
            }
        }

        return dp[n];
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int m = sc.nextInt();
        System.out.println(tiling(n,m));
        sc.close();
    }
}