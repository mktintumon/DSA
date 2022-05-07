import java.util.Scanner;

public class AnybaseMultiply {
    public static Scanner sc = new Scanner(System.in);

    public static int anybaseAddition( int b ,int n1 , int n2 ) {
        int ans = 0;
        int carry =0;
        int pow = 1;

        while(n1!=0 || n2!=0 || carry!=0){
            int sum = n1%10 + n2%10 + carry ;

            n1 /= 10;
            n2 /= 10;
            carry = sum/b; 
            sum %=b;   

            ans = ans + sum*pow;
            pow = pow*10;
        }

        return ans;
    }

    public static int multiplywithDigit( int b, int n , int digit){
        int ans = 0;
        int carry = 0 ;
        int pow =1;

        while(n!=0 || carry!=0){
            int prod = carry + (n%10)*digit;
            n /= 10;
            carry = prod / b;
            prod = prod %b;

            ans = ans + prod*pow;
            pow = pow*10;

        }

        return ans;

    }
    
    public static int anybaseMultiply(int b ,int n1 , int n2){
        int ans=0;
        int pow =1;

        while(n2!=0){
            int digitmultiply = multiplywithDigit(b, n1, n2%10);
            n2 /= 10;

            ans = anybaseAddition(b, ans , digitmultiply*pow);
            pow = pow*10;
        }

        return ans;
    }

    public static void main(String[] args) {
        int b = sc.nextInt();
        int n1 = sc.nextInt();
        int n2 = sc.nextInt(); 

       // System.out.println(anybaseMultiply(b,n1 ,n2));
       System.out.println(multiplywithDigit(b , n1 ,n2));
    }
    
}
