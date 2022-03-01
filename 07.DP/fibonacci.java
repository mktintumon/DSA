import java.util.*;

public class fibonacci {

public static Scanner sc = new Scanner(System.in);
  
// Recursion code
public static int fiboR(int n){
   if(n <= 1){
       return n;
   }

   int nm1 = fiboR(n-1);
   int nm2 = fiboR(n-2);

   return (nm1+nm2);
}

// Memoization by recursion code
public static int fiboM(int n , int[] dp){
    if(n <= 1){
        return dp[n]=n;
    }

    if(dp[n] != -1){
        return dp[n];
    }
 
    int nm1 = fiboM(n-1,dp);
    int nm2 = fiboM(n-2,dp);
 
    return dp[n] = (nm1+nm2);
 }

 //Tabulation by memoization code
 // Methods ->(n->N) (1.return->continue)  (2.delete value of -1)  (3.replace call by arr[idx])

 public static int fiboT(int N , int[] dp){
    //set direction
    for(int n=0 ; n<dp.length ; n++){ // N=dp.length
        if(n<=1){
            dp[n] = n;
            continue;
        }

        int nm1 = dp[n-1];
        int nm2 = dp[n-2];

        dp[n] = nm1+nm2;
    }

    return dp[N];
 }



public static void main(String[] args) {
    
     int n = sc.nextInt();

     //for memoization fill -1 in dp array
     int[] dp = new int[n+1];
     //Arrays.fill(dp,-1);

     //int ans =  fiboR(n);
     //int ans = fiboM(n,dp);
     int ans = fiboT(n,dp);
     
     System.out.println(ans);
 }
}
