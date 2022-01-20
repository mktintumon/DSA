package DSA.Array;
import java.util.Scanner;

public class rotate90 {
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

    public static void transpose(int[][] arr){
        int n = arr.length;

        for(int i=0 ; i<n ; i++){
            for(int j=i ; j<n ; j++){
                 int temp = arr[i][j];
                 arr[i][j] = arr[j][i];
                 arr[j][i] = temp;
            }
        }
    }

    public static void reverse1D(int[] arr){
        int n= arr.length;
        int left=0;
        int right = n-1;

       while(left<=right){
           int temp = arr[left];
           arr[left] = arr[right];
           arr[right] = temp;
           left++;
           right--;
       }
    }

    public static void rotate90deg(int[][] arr){
        for(int[] ele : arr){
            reverse1D(ele);    //best code to reverse row wise elements
        }
    }

    public static void main(String[] args) {
        int n = sc.nextInt();

        int[][] arr = new int[n][n];
        takeInput(arr);

        transpose(arr);
        display(arr);
    }
}
