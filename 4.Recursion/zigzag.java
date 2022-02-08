
import java.util.Scanner;

public class zigzag {
    public static Scanner sc = new Scanner(System.in);

    public static void printZigZag(int n){
        if(n==0){
            return;
        }

        System.out.print(n + " ");
        printZigZag(n-1);
        System.out.print(n + " ");
        printZigZag(n-1);
        System.out.print(n + " ");
    }

    public static void main(String[] args) {
        int n = sc.nextInt();
        printZigZag(n);
    }
}
