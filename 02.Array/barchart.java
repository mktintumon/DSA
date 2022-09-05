
import java.util.Scanner;

public class barchart {
    public static Scanner sc = new Scanner(System.in);
    
    public static void takeInput(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            arr[i] = sc.nextInt(); // setter
        }
    }

    //max element
    public static int maxElement(int[] arr){
        int n = arr.length;
        int maxEle = Integer.MIN_VALUE;

        for(int i=0 ; i<n ; i++){
            maxEle = Math.max(maxEle , arr[i]);
        }
        return maxEle;
    }

    public static void barChart(int[] arr){
        int n = arr.length;
        int height = maxElement(arr);
        
       for(int h = height ; h>0 ; h--){
           for(int i=0 ; i<n ; i++){
               if(arr[i]>=h){
                   System.out.print("*\t");
               }else{
                   System.out.print("\t");
               }
           }
           System.out.println();
       }
    }

    public static void main(String[] args) {
        int n = sc.nextInt();
        int[] arr = new int[n];

        takeInput(arr);
        barChart(arr);

    }
}
