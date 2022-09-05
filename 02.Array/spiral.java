
import java.util.Scanner;

public class spiral {
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
               System.out.print(arr[i] + " ");
        }
            System.out.println();
    }

    public static void spiralPrint(int[][] arr){
        int n=arr.length;
        int m= arr[0].length;

        int minR =0;
        int maxR =n-1;
        int minC=0;
        int maxC=m-1;

        // for finding where to stop
        int count=0;
        int total = n*m;

        //no need to initiate array for storing answer 
        // just find element and print it
        
        while(count <= total){

            // 4 loop - each loop have (count<total) to stop printing extra element at last
            for(int i=minR ; i<=maxR && count<total ; i++ ){
                System.out.print(arr[i][minC] + " ");
                count++;
            }
            minC++;

            for(int i=minC ; i<=maxC && count<total; i++ ){
                System.out.print(arr[maxR][i] + " ");
                count++;
            }
            maxR--;

            for(int i=maxR ; i>=minR && count<total; i-- ){
                System.out.print(arr[i][maxC] + " ");
                count++;
            }
            maxC--;

            for(int i=maxC ; i>=minC && count<total; i-- ){
                System.out.print(arr[minR][i] + " ");
                count++;
            }
            minR++;
    }
}


    public static void main(String[] args) {
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[][] arr = new int[n][m];
        takeInput(arr);

        spiralPrint(arr);
        
    }
}
