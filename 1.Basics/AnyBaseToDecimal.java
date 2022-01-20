package DSA.basics;
import java.util.Scanner;

public class AnyBaseToDecimal {
    public static Scanner sc = new Scanner(System.in);

    public static int binaryToDecimal(int n){
        int ans=0;
        int pow =1;
        while(n!=0){
           int rem = n%10;
           n /= 10;

           ans = ans + rem*pow;
           pow = pow*2;
            
        }

        return ans;
    }

    public static int AnybaseToDecimal(int n , int b){
        int ans=0;
        int pow =1;
        while(n!=0){
           int rem = n%10;
           n /= 10;

           ans = ans + rem*pow;
           pow = pow*b;
            
        }

        return ans;
    }

    public static void main(String[] args) {
        int n = sc.nextInt();
        int b = sc.nextInt();

        System.out.println(binaryToDecimal(n));
        System.out.println(AnybaseToDecimal(n,b));
        
    }
}
