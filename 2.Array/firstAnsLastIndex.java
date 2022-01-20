package DSA.Array;
import java.util.Scanner;

public class firstAnsLastIndex {
    public static Scanner sc = new Scanner(System.in);

    public static void takeInput(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            arr[i] = sc.nextInt(); // setter
        }
    }
    
    public static int  firstindex(int[] arr , int x){
        int right = arr.length-1;
        int left = 0;
        int first = -1;
         while(left<=right){
             int mid = (left+right)/2;

             if(arr[mid] == x){
                 first = mid;
                 right = mid-1;
             }

             if(arr[mid] > x){
                 left = mid+1;
             }

             if(arr[mid] < x){
                 right = mid-1;
             }
         }

         return first;

    }

    public static int  lastindex(int[] arr , int x){
        int right = arr.length-1;
        int left = 0;
        int last = -1;
         while(left<=right){
             int mid = (left+right)/2;

             if(arr[mid] == x){
                 last = mid;
                 left = mid +1;
             }

             if(arr[mid] > x){
                right = mid-1;
             }

             if(arr[mid] < x){
                 left = mid +1;
             }
         }

         return last;

    }


    public static void main(String[] args) {
        int n = sc.nextInt();
        int[] arr = new int[n]; // sorted array
        takeInput(arr);
        int x = sc.nextInt();

        int first = firstindex(arr,x);
        int last = lastindex(arr,x);

        System.out.println(first);
        System.out.println(last);
    }
    
}
