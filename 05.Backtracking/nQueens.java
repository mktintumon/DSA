import java.util.Scanner;

public class nQueens {
    public static Scanner sc = new Scanner(System.in);

    // fact-> (1 row = 1 queen)
    // total 8 dirention -> we choose only safe directon and neglect thinking abt others
    // out of 8 , only think about 3 dirn -> north , north-west , north-east

    // if any row left blank then it cant complete the call -> so return
    // we gonna make another function boolean isSafe() for safe check


    public static boolean isSafe(int[][] chess , int r , int c){
        int n = chess.length;

        // for dirn-> northEast
        for(int i = r-1 , j=c+1 ; i>=0 && j<n ; i--,j++){
            if(chess[i][j]==1){
                 return false;
            }
        }

        // for dirn-> north
        for(int i = r-1,j=c ; i>=0 ; i--){ //fixed col
            if(chess[i][j]==1){
                 return false;
            }
        }

        // for dirn-> northwest
        for(int i = r-1 , j=c-1 ; i>=0 && j>=0 ; i--,j--){
            if(chess[i][j]==1){
                 return false;
            }
        }

    return true;
    }

    public static void queenPlaces(int[][] chess , String path , int row){
        if(row == chess.length){
            System.out.println(path+".");
            return;
        }

           
        // row started from 0 in main function
        for(int col=0 ; col<chess.length ; col++){  // we check for each row seperately

            if(isSafe(chess , row , col)){
             chess[row][col]= 1 ;
             queenPlaces(chess,path+ row + "-" + col + ", ", row+1); // check for next row
             chess[row][col] = 0; // for backtracking 
            }
        }
    }

    public static void main(String[] args) {
        int n = sc.nextInt();

        int[][] chess = new int[n][n];

        queenPlaces(chess,"" ,0);
    }
}
