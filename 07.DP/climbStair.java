import java.util.*;

public class climbStair {
   
    public static Scanner sc = new Scanner(System.in);

    public static void display(int[] dp){
        for(int ele : dp){
            System.out.print(ele+" ");
        }
        System.out.println();
    }

    public static int climbStairR(int n){
        if(n == 0){
            return 1; // each base case give count 1 and we adding everytime in basecase
        }

        int count = 0;

        // let n=3 
        if(n-1>=0){
            count += climbStairR(n-1); // here count = 1 -> 2
        }

        if(n-2>=0){
            count += climbStairR(n-2); // count = 2-> 3
        }

        if(n-3>=0){
            count += climbStairR(n-3); // count = 3 -> 4
        }

        return count;
    }

    //Memoization
    public static int climbStairM(int n , int[] dp){
        if(n == 0){
            return dp[n]=1;
        }

        if(dp[n] != -1){
            return dp[n];
        }

        int count = 0;

        if(n-1 >= 0){
            count += climbStairM(n-1, dp);
        }

        if(n-2 >= 0){
            count += climbStairM(n-2, dp);
        }

        if(n-3 >= 0){
            count += climbStairM(n-3, dp);
        }

        return dp[n] = count;

    }

    //Tabulation
    public static int climbStairT(int N , int[] dp){
        for(int n=0 ; n<dp.length ; n++){
        if(n == 0){
            dp[n]=1;
            continue;
        }
    

        int count = 0;

        if(n-1 >= 0){
            count += dp[n-1];
        }

        if(n-2 >= 0){
            count += dp[n-2];
        }

        if(n-3 >= 0){
            count += dp[n-3];
        }

        dp[n] = count;

    }

        return dp[N];

    }


    public static void main(String[] args) {
        int n = sc.nextInt();

        int[] dp = new int[n+1];
        // Arrays.fill(dp,-1);

        // int ans = climbStairR(n);
        // 
        int ans = climbStairT(n,dp);
        //display(dp);
        System.out.println(ans);
    }
}
