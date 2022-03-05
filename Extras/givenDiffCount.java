import java.util.*;

public class givenDiffCount {
    public static Scanner sc = new Scanner(System.in);

    /*
       APPROACH ->
       1) diff is given -> we need to divide into two subsets(s1 , s2)
       2) then count the possibility of -> sum(s1) - sum(s2) == diff

       sum(s1) - sum(s2) = diff
       sum(s1) + sum(s2) = sum(arr)
       ----------------------------- -> on adding
       sum(s1) = [diff + sum(arr)] / 2

       **call TargetSumSubset with target -> sum(s1)
    
    */

    public static int diffCount(int[] arr , int diff){

        int sum = 0 ;
        for(int i=0 ; i<arr.length ; i++){
            sum += arr[i];
        }

        int target = (sum + diff)/2; // target = sum(s1)

        return countTargetSubset(arr, target);
    }

    public static int countTargetSubset(int[] arr , int tar){
        int[][] dp = new int[arr.length+1][tar+1];
        int n = dp.length;
        int m = dp[0].length;

        for(int i= 0 ; i<n ; i++){
            for(int j=0 ; j<m ; j++){
                if(i==0 && j==0){ // first cell = 1 -> {}
                    dp[i][j] = 1;
                }
                
               else if(i == 0){  // no element in array
                    dp[i][j] = 0;
                }
                else if( j == 0){ // target=0 is possible -> not play anyone
                    dp[i][j] = 1;
                }
                else{
                    // 0-1 knapsack
                    int notPick = dp[i-1][j];

                    int pick = 0;
                    if(j - arr[i-1] >= 0){
                        pick = dp[i-1][j - arr[i-1]];
                    }

                    dp[i][j] = notPick + pick;
                }
            }
        }

        return dp[n-1][m-1];
    }
   

    public static void main(String[] args) {
        int n = sc.nextInt();
        int[] arr = new int[n];
        for(int i=0 ; i< n ; i++){
            arr[i] = sc.nextInt();
        }
        int diff = sc.nextInt();

        int ans = diffCount(arr , diff);
        System.out.println(ans);
        sc.close();
    }
}
