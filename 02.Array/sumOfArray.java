package DSA.Array;
import java.util.Scanner;


public class sumOfArray {
    public static Scanner sc = new Scanner(System.in);
   
    public static void takeInput(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            arr[i] = sc.nextInt(); // setter
        }
    }
    
    // sum of array by i, j , k method 
    public static void sumArray(int[] arr1 , int[] arr2){
        int n1 = arr1.length;
        int n2 = arr2.length;
        int carry = 0;

        int size = (n1>n2) ? n1 : n2;
        int[] ans = new int[size];

        int i = n1-1;
        int j = n2-1;
        int k = ans.length -1;

        while(k>=0){
             int sum=0;
             sum = sum + carry ; 

             if(i>=0){
                 sum = sum + arr1[i];
             }

             if(j>=0){
                 sum = sum + arr2[j];
             }

             carry = sum/10;
             int value = sum%10;

             ans[k] = value;
             i--;
             j--;
             k--;

        }

        if(carry!=0){ //edge case
            System.out.println(carry);
        }

        for(int ele : ans){
            System.out.print(ele + " ");
        }
    } 
    
    
 
    public static void main(String[] args) {
        int n = sc.nextInt();
        int[] arr1 = new int[n];
        takeInput(arr1);

        int m = sc.nextInt();
        int[] arr2 = new int[m];
        takeInput(arr2);
        
        sumArray(arr1, arr2);

        

    }
}
