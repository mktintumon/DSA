
import java.util.*;

public class friendPairing{

    public static int pairing(int N , int[] dp){

        for(int n=0 ; n<=N ; n++){
            
            if(n <= 2){
               dp[n] = n;
               continue;
            }


            int single = dp[n-1];
            int pair = dp[n-2];

            dp[n] = single + (n-1)*pair;
        }

        return dp[N];
    }

    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        int dp[] = new int[n+1];
        int ans = pairing(n,dp);
        System.out.println(ans);
        sc.close();
    }

}