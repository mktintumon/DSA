
import java.util.Scanner;

public class powerLog {
    public static Scanner sc = new Scanner(System.in);

    public static int powLog(int x,int n){
         if(n==0){
             return 1;
         }

         //In linear we call (x,n-1) -> height will be n
         //But in power log we call (x,n/2) -> height will be logn

         // for even  -> pow(2,n) = pow(2,n/2) * pow(2,n/2)
         // for odd   -> pow(2,n) = pow(2,n/2) * pow(2,n/2) * 2
         
         int recAns = powLog(x, n/2);
         int myAns = x * recAns;

         if(n%2 != 0){
             myAns = myAns*x;
         }

         return myAns;
    }

    public static void main(String[] args) {
        int x = sc.nextInt();
        int n = sc.nextInt();

        // we will find x raised to power n : pow(x,n)
        System.out.println(powLog(x,n));
    }
}
