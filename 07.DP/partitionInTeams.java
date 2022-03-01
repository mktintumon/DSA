import java.util.*;

public class partitionInTeams {
        
    public static long partitionKSubset(int n, int k) {
        if(n==0 || k==0 || n<k){
            return 0;
        }
         
        long[][] dp = new long[k+1][n+1];
        // p = peoples
        // t = teams

        for(int t=1 ; t<=k ; t++ ){
            for(int p=1 ; p<=n ; p++){
                if(t == p){
                    dp[t][p] = 1;
                }
                else if(p < t){
                    dp[t][p] = 0;
                }
                else{
                    // formula
                    dp[t][p] = dp[t-1][p-1] + (dp[t][p-1])*t;
                }
            }
        }

        return dp[k][n];
    }
    
    public static void main(String[] args) throws Exception {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int k = scn.nextInt();
        
        long res = partitionKSubset(n, k);
        System.out.println(res);
        scn.close();
    }
}