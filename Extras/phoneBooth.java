import java.util.Scanner;

public class phoneBooth {

    public static boolean booth(int[] arr , int k){
        int n = arr.length;
        
        if(k==0){
            return true;
        }
        

        if(n == 1 && arr[0] == 0){
            if(k==0){
                return false;
            }
            else if(k==1){
                return true;
            }
        }
        

        int count = 0;
        for(int i=0 ; i<n ; i++){
           if(i == 0){
               if(arr[i] == 0 && arr[i+1] == 0){
                   count++;
                   i++;
               }
           }
            else if(i == n-1){
                if(arr[i] == 0 && arr[i-1] == 0){
                   count++;
                    i++;
               }
            }
            else{
                if(arr[i] == 0 && arr[i-1] == 0 && arr[i+1] == 0){
                   count++;
                    i++;
               }
            }
        }
        
        if(count >= k){
           return true;
        }
        else{
             return false;
        }
    }
    
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int arr[] = new int[n];
        for(int i = 0 ; i < n ; i++){
            arr[i] = scn.nextInt();
        }

        int k = scn.nextInt();

        boolean ans = booth(arr , k);
        System.out.println(ans);
        scn.close();
    }
}