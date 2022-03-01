import java.util.*;

public class floorTiling2x1{

    public static int tiling(int n){
        int[] dp = new int[n+1];
        // At idx 0 , not possible to place tile
        dp[1] = 1; // only H
        dp[2] = 2; // only H and V

        // else placements
        for(int i=3 ; i<=n ; i++){
            dp[i] = dp[i-1] + dp[i-2];
        }

        return dp[n];
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        System.out.println(tiling(n));
        sc.close();
    }
}