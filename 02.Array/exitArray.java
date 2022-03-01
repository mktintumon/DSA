package DSA.Array;
import java.util.Scanner;

public class exitArray {
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

    public static void exitpoint(int[][] arr){
         int n= arr.length;
         int m =arr[0].length;

         int i=0;
         int j=0;
         int dir = 0;

         while(true){ // always inters the loop , at last we forcefully stop loop by break
              dir = dir + arr[i][j];
              dir %= 4;

              //move 90 degree process
              if(dir==0){
                  j++;
              }
              if(dir==1){
                  i++;
              }
              if(dir==2){
                  j--;
              }
              if(dir==3){
                  i--;
              }

              // for stopping loop
              if(i<0 || j<0 || i>=n || j>=m ){
                  break;
              }
         }
        
         // index goes out of matrix , so bring one step back
         if(i<0){
             i++;
         }
         if(j<0){
             j++;
         }
         if(i>=n){
             i--;
         }
         if(j>=m){
             j--;
         }

         System.out.println(i);
         System.out.println(j);


    }

    public static void main(String[] args) {
        int n = sc.nextInt();
        int m = sc.nextInt();

        int[][] arr = new int[n][m];
        takeInput(arr);

        exitpoint(arr);
    }
}
