
import java.util.*;

// Leetcode - 486
public class predictWinner {
    public static Scanner sc=new Scanner(System.in);

    public static int score(int[] nums,int i,int j,int[][]memo){
        if(i>j){
            return 0;
        }
        else if(i==j){
            return nums[i];
        } 
        else if(memo[i][j]!=-1){
            return memo[i][j];
        }
        
        int x1=score(nums,i+1,j-1,memo);
        int x2=score(nums,i+2,j,memo);
        int x3=score(nums,i,j-2,memo);
        return memo[i][j]=Math.max(nums[i]+Math.min(x2,x1),nums[j]+Math.min(x1,x3));
    }
    public static boolean Winner(int[] nums) {
        int n=nums.length;
        int[][]memo=new int[n][n];
        for(int[]ele:memo){
            Arrays.fill(ele,-1);
        }
        int player1=score(nums,0,n-1,memo);
        int player2=Math.min(score(nums,0,n-2,memo),score(nums,1,n-1,memo));
        return player1>=player2;
    }
    public static void main(String args[]) {
        
        int n=sc.nextInt();
        int[] nums=new int[n];
        for(int i=0;i<n;i++){
            nums[i]=sc.nextInt();
        }
        boolean ans=Winner(nums);
        System.out.println(ans);
    }
}
