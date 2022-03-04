import java.util.*;

public class minSubsetDIff {
/*
     Approach ->
     1) first find sum of array for making number line of range
     2)then we call target sum 
     3)and take out the last row element of dp which is true till range/2, which is s1 partition
     **-> two partition (s1,s2) -> (s1 , range-s1)
       ->we find difference -> (s2-s1) -> (range - 2*s1)
     4)Then find the min diff by checking all element by (range - 2*s1)  
*/

    public static int minDiff(int[] arr){
        int n = arr.length;
        int range = 0;
        for(int i=0 ; i<n ; i++){
            range += arr[i];
        }

        ArrayList<Integer> candidate = new ArrayList<>();
        for(int i=0 ; i<=range/2 ; i++){
            if(targetSum(arr, i) == true){
                candidate.add(i);
            }
        }

        int min = Integer.MAX_VALUE;
        for(int i=0 ; i<candidate.size() ; i++){
            min = Math.min(min , range-(2*candidate.get(i)));
        }

        return min;
    }
 
    public static boolean targetSum(int[] arr , int range){
        boolean[][] dp = new boolean[arr.length+1][range+1];
        for(int i=0 ; i<dp.length ; i++){
            for(int j=0 ; j<dp[0].length ; j++){
                if(i==0 && j==0){
                    dp[i][j] = true;
                }
                else if(i == 0){
                    dp[i][j] = false;
                }

                else if(j == 0){
                    dp[i][j] = true;
                }

                else{
                    // not play -> ask previous
                    boolean noCall = dp[i-1][j];

                    // will play sets to false
                    boolean yesCall = false;
                    if(j - arr[i-1] >= 0){
                            yesCall = dp[i-1][j-arr[i-1]];
                    }

                    dp[i][j] = noCall || yesCall ;
                }
            }
        }

        return dp[arr.length][range];
    }
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int[] arr = new int[n];
        for(int i=0 ; i<n ; i++){
            arr[i] = sc.nextInt();
        }

        int ans = minDiff(arr);
        System.out.println(ans);
        sc.close();
    }
}
