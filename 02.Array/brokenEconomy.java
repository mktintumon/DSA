
import java.util.Scanner;

public class brokenEconomy {
    public static Scanner sc = new Scanner(System.in);

    public static void takeInput(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            arr[i] = sc.nextInt(); // setter
        }
    }

    public static  void brokeneconomy(int[] arr , int x){
        int  n = arr.length;
        int left = 0;
        int right = n-1;
        int floor = 0;
        int ceil = 0;

        while(left<=right){
            int mid = (left+right)/2;

            if(arr[mid] == x){
               floor = arr[mid];
               ceil = arr[mid];
               break;
            }
                
            else if(arr[mid] < x){
                floor = arr[mid];
                left = mid + 1;
            }

            else if(arr[mid] > x){
                ceil = arr[mid];
                right = mid-1;
            }
        }

        System.out.println(floor);
        System.out.println(ceil);

    }

    public static void main(String[] args) {
        int n = sc.nextInt();
        int[] arr = new int[n];
        takeInput(arr);
        int x = sc.nextInt();

        brokeneconomy(arr,x);
    }
    
}

