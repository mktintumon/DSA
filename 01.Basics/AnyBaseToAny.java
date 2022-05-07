
import java.util.Scanner;

public class AnyBaseToAny {
    public static Scanner sc = new Scanner(System.in);

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
        int b1 = sc.nextInt();
        int b2 = sc.nextInt();

        int decimal = AnybaseToDecimal(n, b1);
        int ans = decimalToAnyBase(decimal, b2);

        System.out.println(ans);



        
    }
    
}
