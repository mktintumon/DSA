package DSA.Recursion;
import java.util.Scanner;

public class towerOfHanoi {
     public static Scanner sc = new Scanner(System.in);

    public static void toh(int n ,int A,int B,int C){
        if(n==0){
            return;
        }

        //move all disc except lowest one from a to c
         toh(n-1,A,C,B);
         System.out.println(n + "[" + A + "->" + B + "]");

         //move lowest one to b and all disc from c to b
         toh(n-1,C,B,A);
    }

     public static void main(String[] args) {
         int n = sc.nextInt();
         int A = sc.nextInt();
         int B = sc.nextInt();
         int C = sc.nextInt();

         toh(n,A,B,C);
     }
}
