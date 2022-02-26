import java.util.Scanner;

public class floodFill {
    public static Scanner sc = new Scanner(System.in);

    public static void floodFillAlgo(int[][] arr , int sr , int sc , String path){

        if(sr>=arr.length || sc>=arr[0].length || sr<0 || sc<0 || arr[sr][sc] == 1){
            return;
        }

        if(sr == arr.length-1 && sc == arr[0].length-1){
            System.out.println(path);
            return;
        }

        arr[sr][sc] = 1;
        floodFillAlgo(arr, sr-1, sc, path+"t");
        floodFillAlgo(arr, sr, sc-1, path+"l");
        floodFillAlgo(arr, sr+1, sc, path+"d");
        floodFillAlgo(arr, sr, sc+1, path+"r");
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

        floodFillAlgo(arr, 0, 0, "");
    }
}
