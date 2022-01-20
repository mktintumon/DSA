package DSA.Backtracking;
import java.util.Scanner;

public class floodFill_2 {
    public static Scanner sc = new Scanner(System.in);

    // we will do it by direction method for calling function using loop

    static int[][] dir = {{-1,0}, {0,-1},{1,0}, {0,1}};
    static String[] dirN =  {"t","l","d", "r"};

    public static void floodfill(int[][] arr , int sr ,int sc, String path){

        if(sr>=arr.length || sc>=arr[0].length || sr<0 || sc<0 || arr[sr][sc] == 1){
            return;
        }

        if(sr == arr.length-1 && sc == arr[0].length-1){
            System.out.println(path);
            return;
        }

        arr[sr][sc] = 1;

        for(int d=0 ; d<dir.length ; d++){ // here dir length is 4 -> t l d r
                int row = sr + dir[d][0]; 
                int col = sc + dir[d][1];

                floodfill(arr, row, col, path+dirN[d]);
        }

        arr[sr][sc] = 0;
    }


    public static void main(String[] args) {
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[][] arr = new int[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                arr[i][j] = sc.nextInt();
            }
        }
        
        
        floodfill(arr, 0, 0, "");
    }

}
