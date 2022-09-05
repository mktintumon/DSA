

import java.util.Scanner;

public class display{
public static Scanner sc = new Scanner(System.in);

    public static void takeInput(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            arr[i] = sc.nextInt(); // setter
        }
    }

    public static void printArray(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " "); // getter
        }
        System.out.println();
    }

    public static void main(String[] args) {
        int n = sc.nextInt();
        int[] arr = new int[n];

        takeInput(arr);
        printArray(arr);

    }
}
