
import java.util.Scanner;

public class Indices {
    public static Scanner sc = new Scanner(System.in);
    
    public static int[] indices(int[] arr , int x , int idx , int count){
        if(idx == arr.length){
            int [] base = new int[count];
            return base;
        }
        
        if(arr[idx] == x){
            count += 1;
        }
        
        int[] recAns = indices(arr, x, idx+1, count);
        
        if(arr[idx] == x){
            recAns[count-1] = idx;
        }
        
        return recAns;
        
    }
        

    public static void main(String[] args) {
        int n = sc.nextInt();
        int[] arr = new int[n];
        for(int i=0 ; i<n ; i++){
            arr[i] = sc.nextInt();
        }

        int x = sc.nextInt();

        int[] ans = indices(arr,x,0,0);
        System.out.println(ans);
    }
}
