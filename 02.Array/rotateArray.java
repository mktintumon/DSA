
import java.util.Scanner;

public class rotateArray {
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


    public static void swap(int [] arr, int i, int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
  
   public static void reverse(int [] arr, int i, int j){
        
        while(i<=j){
            swap(arr,i,j);
            i++;
            j--;
        }
    }
  
    public static void rotate(int[] a, int k){
        //edge cases
        k = k%a.length;
        
        if(k < 0){
            k += a.length;
        }
        
        int n = a.length;
        
      reverse(a, 0,n-k-1);
      reverse(a, n-k,n-1);
      reverse(a, 0,n-1);
    }

    public static void main(String[] args) {
        int n = sc.nextInt();


        int[] arr = new int[n];
        takeInput(arr);
        int k = sc.nextInt();

        rotate(arr,k);
        printArray(arr);
    }


    
}
