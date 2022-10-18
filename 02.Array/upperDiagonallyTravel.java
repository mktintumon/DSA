
import java.util.Scanner;

public class upperDiagonallyTravel {

    public static Scanner sc = new Scanner(System.in);

    public static void takeInput(int[][] arr) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[0].length; j++) {
                arr[i][j] = sc.nextInt();
            }
        }
    }

    // GAP STRATEGY
    public static void sow2(int[][] arr) {
        int n = arr.length;

        for (int gap = 0; gap < n; gap++) {
            for (int i = 0, j = gap; j < n; i++, j++) {
                System.out.print(arr[i][j] + " ");
            }
        }

    }

    public static void main(String[] args) {
        int n = sc.nextInt();

        int[][] arr = new int[n][n];
        takeInput(arr);

        sow2(arr);
    }
}
