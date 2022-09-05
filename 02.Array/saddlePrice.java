
import java.util.Scanner;

public class saddlePrice {
    public static Scanner sc = new Scanner(System.in);

    public static void takeInput(int[][] arr){
        for(int i=0 ;i<arr.length ; i++){
            for(int j=0 ; j<arr[0].length ; j++){
                arr[i][j] = sc.nextInt();
            }
        }
    }

    public static void display(int[][] arr){
        for(int i=0 ; i<arr.length ; i++){
            for(int j=0 ; j<arr[0].length ; j++){
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static void saddle(int[][] arr){
        int n = arr.length;

        for(int i=0 ; i<n ; i++){
            int lowCol = 0 ;
            
            // checking row for min element
            for(int j=1; j<n ;j++ ){
                if(arr[i][j] < arr[i][lowCol] ){
                  lowCol = j;
                  break;
                }
            }

            //checking column for max element
            boolean flag = true;
            for(int k=1 ; k<n ; k++){
                if(arr[k][lowCol] > arr[i][lowCol]){
                    flag = false;
                    break;
                }
            }

            if(flag == true){
                System.out.println(arr[i][lowCol]);
                return; // return is must needed , otherwise both result and invalid input will get print
            }
            

        }

        System.out.println("Invalid input");
    }



    public static void main(String[] args) {
        int n = sc.nextInt();
        int[][] arr = new int[n][n];
        takeInput(arr);

        saddle(arr);

    }
}
