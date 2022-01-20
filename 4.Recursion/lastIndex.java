package DSA.Recursion;
import java.util.Scanner;

public class lastIndex {
    public static Scanner sc = new Scanner(System.in);
    
    public static int last(int[] arr , int idx , int x){
          if(idx == arr.length){
              return -1;
          }

          int result = last(arr , idx+1 , x); // call and store value

          if(result == -1){
              //we have to find the last index
                if(arr[idx] == x){
                    return idx; // checking every element while returning
                }
                else{
                    return result;
                }
          }
          else{
              //we got the last index
              return result;
          }
    }


    public static void main(String[] args) {
        int n = sc.nextInt();
        int[] arr = new int[n];
        for(int i=0 ; i<n ; i++){
            arr[i]= sc.nextInt();
        }

        int x = sc.nextInt();
        
        int ans = last(arr , 0 , x);
        System.out.println(ans);
    }
}
