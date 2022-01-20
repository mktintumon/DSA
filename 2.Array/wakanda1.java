package DSA.Array;
import java.util.Scanner;

public class wakanda1 {
    public static Scanner sc = new Scanner(System.in);

public static void sow1(int[][] arr){
   int n = arr.length;
   int m = arr[0].length;

   for(int j=0 ; j<m ; j++){
       if(j%2 == 0){
          for(int i= 0 ; i<n ; i++){
              System.out.print(arr[i][j] + " ");
          }
          System.out.println();
       }
       else{
         for(int i=n-1 ; i>=0 ; i--){
            System.out.print(arr[i][j] + " ");
         }
         System.out.println();
     }
       }
   }


public static void main(String[] args) {
    int n = sc.nextInt();
    int m = sc.nextInt();

    int[][] arr = new int[n][m];
    for(int i=0 ; i<n ; i++){
        for(int j=0 ; j< n ; j++){
            arr[i][j] = sc.nextInt();
        }
    }

    sow1(arr);
}
    
}
