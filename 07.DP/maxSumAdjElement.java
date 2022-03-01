
import java.util.*;

public class maxSumAdjElement {

    public static int maxSum(int[] arr){
        int pickSum = arr[0];
        int noPickSum = 0;

        for(int i=1 ; i<arr.length ; i++){
            int newPickSum = arr[i] + noPickSum;
            int newNoPickSum = Math.max(pickSum , noPickSum);

            pickSum = newPickSum;
            noPickSum = newNoPickSum;
        }

        return Math.max(pickSum , noPickSum);
    }

    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int[] arr = new int[n];
        for(int i=0 ; i<n ; i++ ){
            arr[i] = sc.nextInt();
        }

        int ans = maxSum(arr);
        System.out.println(ans);
        sc.close();
    }
}
