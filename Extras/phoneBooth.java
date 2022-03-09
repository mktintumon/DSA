import java.util.Scanner;

public class phoneBooth {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int arr[] = new int[n];
        for(int i = 0 ; i < n ; i++){
            arr[i] = scn.nextInt();
        }

        int k = scn.nextInt();

        int count = 0;
        for(int i=0 ; i<n ; i++){
           if(i == 0){
               if(arr[i] == 0 && arr[i+1] == 0){
                   count++;
               }
           }
            else if(i == n-1){
                if(arr[i] == 0 && arr[i-1] == 0){
                   count++;
               }
            }
            else{
                if(arr[i] == 0 && arr[i-1] == 0 && arr[i+1] == 0){
                   count++;
               }
            }
        }
        
        if(count >= k){
           System.out.println("true");
        }
        else{
             System.out.println("false");
        }

        scn.close();
    }
}