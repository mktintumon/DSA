package DSA.Array;
import java.util.Scanner;

public class subtractarray {
    public static Scanner sc = new Scanner(System.in);

    public static void takeInput(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            arr[i] = sc.nextInt(); // setter
        }
    }

     // NOTE : Two edge cases to be handled at the end
    public static int[] subtract(int[] arr1 , int[] arr2){
        int n1 = arr1.length;
        int n2 = arr2.length;
        int borrow=0;

        int[] ans = new int[n2];
         
        int i = n1-1;
        int j = n2-1;
        int k = ans.length-1;

        while(j>=0){ // second number is bigger 
            int sub=0;
            sub = borrow + arr2[j]; 

            if(i>=0){
                sub = sub - arr1[i];
            }

            if(sub<0){
                sub = sub + 10;
                borrow = -1;
            }else{
                borrow = 0;
            }

            ans[k] = sub;

            i--;
            j--;
            k--;
        }

        return ans;
    }


    public static void main(String[] args) {
        int n = sc.nextInt();
        int[] arr1 = new int[n];
        takeInput(arr1);

        int m = sc.nextInt();
        int[] arr2 = new int[m];
        takeInput(arr2);

        int[] result = subtract(arr1, arr2);

        //fnzi = first non zero index
        int fnzi =-1;
        for(int i=0 ; i<result.length ; i++){
            if(result[i]!=0){
                fnzi = i;
                break;
            }
        }

        if(fnzi==-1){
            System.out.println("0");
            return; // main function breaks
        }
        
        for(int i=fnzi ; i<result.length ; i++){
            System.out.print(result[i] + " ");
        }

    }
    
}
