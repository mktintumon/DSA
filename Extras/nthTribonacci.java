import java.util.*;

public class nthTribonacci {

    /*
    
    The Tribonacci sequence Tn is defined as follows: 

    T0 = 0, T1 = 1, T2 = 1, and Tn+3 = Tn + Tn+1 + Tn+2 for n >= 0.
    
    */
    public static int tribonacci(int N) {
        int[] dp = new int[N+1];
        for(int n=0 ; n<dp.length ; n++){
        
        if(n <= 1){
            dp[n] = n;
            continue;
        }
        if(n == 2){
            dp[n] = 1;
            continue;
        }
        
        dp[n] = dp[n-1] + dp[n-2] + dp[n-3];
        }
        
        return dp[N];
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int ans = tribonacci(n);
        System.out.println(ans);
        sc.close();
    }
}
