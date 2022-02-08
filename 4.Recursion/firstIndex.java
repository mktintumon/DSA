
import java.util.Scanner;

public class firstIndex {
    public static Scanner sc = new Scanner(System.in);

    public static int first(int[] arr,int idx , int x){
        if(idx == arr.length){
            return -1;
        }
        
        if(arr[idx] == x){
            return idx;
        }

        return first(arr , idx+1 , x); // int ans = call(); and return ans;
    }
    
    public static void main(String[] args) {
        int n = sc.nextInt();
        int[] arr = new int[n];
        for(int i=0 ; i<n ; i++){
            arr[i]= sc.nextInt();
        }

        int x = sc.nextInt();
        
        int ans = first(arr , 0 , x);
        System.out.println(ans);
    }
}
