import java.util.*;

public class paintManyHouse {

    //This method will run on O(n^3) -> due to (for inside for inside for)
    //Better method is O(n^2) -> using least and secondleast element;
 
    public static int manyHouse(int[][] arr){
        int n = arr.length;
        int k = arr[0].length;   

        int[][] dp = new int[n][k];

        // filling first row as it is
        for(int j=0 ; j<k ; j++){
            dp[0][j] = arr[0][j];
        }

        for(int i=1 ; i<n ; i++){
            for(int j=0 ; j<k ; j++){
                
                // we will add the cell element and the min of above array(except the same col element)
                int min = Integer.MAX_VALUE;
                for(int ch=0 ; ch<k ; ch++){
                    if(ch != j){ // checking for same col
                        min = Math.min(dp[i-1][ch] , min);
                    }
                }

                dp[i][j] = arr[i][j]+min;
            }
        }

        // returning the min element from the last row
        int min = Integer.MAX_VALUE;
        for(int i=0 ; i<k ; i++){
            min = Math.min(dp[n-1][i] , min);
        }

        return min;
    }

    public static void main(String[] args) throws Exception {
          Scanner sc = new Scanner(System.in);

          int n = sc.nextInt();
          int k = sc.nextInt();

          int[][] arr = new int[n][k];
          for(int i=0 ; i<n ; i++) {
              for(int j=0 ; j<k ; j++){
                  arr[i][j] = sc.nextInt();
              }
          }

          int ans = manyHouse(arr);
          System.out.println(ans);
          sc.close();
    }
}