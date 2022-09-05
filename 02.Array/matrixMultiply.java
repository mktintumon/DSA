
import java.util.Scanner;

public class matrixMultiply{
    public static Scanner sc = new Scanner(System.in);

      public static void takeInput(int[][] arr){
          for(int i=0 ;i<arr.length ; i++){
              for(int j=0 ; j<arr[0].length ; j++){
                  arr[i][j] = sc.nextInt();
              }
          }
      }

      public static void display(int[][] arr){
        for(int i=0 ;i<arr.length ; i++){
            for(int j=0 ; j<arr[0].length ; j++){
               System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }
    }
   
    public static int[][] multiply(int[][] arr1 , int[][] arr2){
           int n1 = arr1.length;
           int m1 = arr1[0].length;
           //int n2 = arr2.length;
           int m2 = arr2[0].length;

           int[][] ans = new int[n1][m2]; 

           for(int i=0 ; i<n1 ; i++){
               for(int j=0 ; j<m2 ;j++){
                  int sum = 0;
                for(int k=0 ; k<m1 ; k++){
                    sum = sum + arr1[i][k] * arr2[k][j];
                }
                ans[i][j] = sum;
               }
           }

           return ans;
    }
     
       public static void main(String[] args) {
          int n1 = sc.nextInt();
          int m1 = sc.nextInt();

          int[][] arr1 = new int[n1][m1];
          takeInput(arr1);

          int n2 = sc.nextInt();
          int m2 = sc.nextInt();

          int[][] arr2 = new int[n2][m2];
          takeInput(arr2);

          if(m1 != n2){
              System.out.println("Invalid input");
          }
          else{
          int[][] ans = multiply(arr1 , arr2);
          display(ans);
          }
       }
}