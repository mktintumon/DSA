
import java.util.*;

public class climbStairVarJump {

    public static Scanner sc = new Scanner(System.in);


    public static int climbStairVarJumpR(int[] arr , int src , int dest){
        if(src == dest) {
            return 1;
        }

        int count = 0;

        for(int jump=1 ; jump<=arr[src] && src+jump<= dest ; jump++){
            count += climbStairVarJumpR(arr,src+jump , dest);
        }

        return count;
    }


    public static int climbStairVarJumpM(int[] arr , int src , int dest , int[] dp){
        if(src == dest) {
            return dp[src] = 1;
        }

        if(dp[src] != -1){
            return dp[src];
        }

        int count = 0;

        for(int jump=1 ; jump<=arr[src] && src+jump<= dest ; jump++){
            count += climbStairVarJumpM(arr,src+jump , dest ,dp);
        }

        return dp[src] = count;
    }


    public static int climbStairVarJumpT(int[] arr , int SRC , int dest , int[] dp){
       
       for(int src=dp.length-1 ; src >= SRC ; src--){
          if(src == dest) {
             dp[src] = 1;
            continue;
          }

        int count = 0;

        for(int jump=1 ; jump<=arr[src] && src+jump<= dest ; jump++){
            count += dp[src+jump];
        }
           dp[src] = count;
       }

        return dp[SRC];
    }


    public static void main(String[] args) throws Exception {
        int n = sc.nextInt();
        int[] arr = new int[n];
        for(int i=0 ; i<n ; i++){
            arr[i] = sc.nextInt();
        }

        int[] dp = new int[n+1];
        // Arrays.fill(dp,-1);

        // int ans = climbStairVarJump(arr , 0 , n );
        // int ans = climbStairVarJumpM(arr , 0 , n ,dp );
        int ans = climbStairVarJumpT(arr , 0 , n ,dp );
        System.out.println(ans);
    }

}