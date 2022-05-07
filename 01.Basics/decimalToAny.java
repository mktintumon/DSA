
import java.util.Scanner;

public class decimalToAny {
    public static Scanner sc = new Scanner(System.in);
    
    public static int decimalToBinary(int n){
        int ans=0;
        int pow =1;
        while(n!=0){
           int rem = n%2;
           n /= 2;

           ans = ans + rem*pow;
           pow = pow*10;
            
        }

        return ans;
    }

    public static int decimalToAnyBase(int n , int b){
        int ans=0;
        int pow =1;
        while(n!=0){
           int rem = n%b;
           n /= b;

           ans = ans + rem*pow;
           pow = pow*10;
            
        }

        return ans;
    }




    public static void main(String[] args) {
        int n = sc.nextInt();
        int b = sc.nextInt();
        
        System.out.println(decimalToBinary(n));
        System.out.println(decimalToAnyBase(n, b));

    }
    
}
