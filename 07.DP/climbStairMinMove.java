import java.util.*;

public class climbStairMinMove {

    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        int[] arr = new int[n];
        for(int i=0 ; i<n ; i++){
             arr[i] = sc.nextInt();
        }
        
        // This will start each cell of dp with value = null
        Integer[] dp = new Integer[n+1];
        dp[n] = 0; //set
        
        for(int i=n-1 ; i>=0 ; i--){

            if(arr[i] > 0){ // otherwise it will remain null
                int min = Integer.MAX_VALUE;

                for(int j=1 ; j<=arr[i] && i+j < dp.length ; j++){
                    if(dp[i+j] != null){  // handle nullPointerException
                    min = Math.min(min , dp[i+j]);
                    }
                }
                
                if(min != Integer.MAX_VALUE ){
                    dp[i] = min + 1;
                }
                // else do nothing -> remain as null
                
            }
        }
        
        System.out.println(dp[0]);
        // if the place will remain null it will remain null
        sc.close();
    }

}