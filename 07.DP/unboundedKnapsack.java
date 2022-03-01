import java.util.*;

public class unboundedKnapsack {

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

        int[] dp = new int[capacity+1];

        dp[0] = 0;

        for(int bag=1 ; bag <= capacity ; bag++){
             
            int max= 0 ;
            for(int i=0 ; i<weight.length ; i++){
                if(bag - weight[i] >= 0){
                     int remaining = bag - weight[i];
                     int remOptimal = dp[remaining];

                     int finalOptimal = profit[i] + remOptimal;

                     if(finalOptimal > max){
                        max = finalOptimal;
                     }
                }
            }

              dp[bag] = max;
        }

        System.out.println(dp[capacity]);
        sc.close();
    }
}