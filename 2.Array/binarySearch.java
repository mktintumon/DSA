package DSA.Array;
import java.util.Scanner;

public class binarySearch {
    public static Scanner sc = new Scanner(System.in);

    public static void takeInput(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            arr[i] = sc.nextInt(); // setter
        }
    }

    public static int binarysearch(int[] arr , int x){
        int  n = arr.length;
        int left = 0;
        int right = n-1;

        while(left<=right){
            int mid = (left+right)/2;

            if(arr[mid] == x)
                return mid;

            else if(arr[mid] < x){
                left = mid + 1;
            }

            else if(arr[mid] > x){
                right = mid-1;
            }
        }

        return -1;
    }

    public static void main(String[] args) {
        int n = sc.nextInt();
        int[] arr = new int[n];
        takeInput(arr);
        int x = sc.nextInt();

        int ans = binarysearch(arr,x);
        System.out.println(ans);
    }
    
}
