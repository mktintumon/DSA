import java.util.Scanner;

public class AnybaseAddition {
    public static Scanner sc = new Scanner(System.in);

    public static int anybaseAddition( int b ,int n1 , int n2 ) {
        int ans = 0;
        int carry =0;
        int pow = 1;

        while(n1!=0 || n2!=0 || carry!=0){
            int sum = n1%10 + n2%10 + carry ;

            n1 /= 10;
            n2 /= 10;
            carry = sum/b; // 10 changes to b
            sum %=b;   // 10 changes to b

            ans = ans + sum*pow;
            pow = pow*10;
        }

        return ans;
    }
 
    public static void main(String[] args) {
        int b = sc.nextInt();
        int n1 = sc.nextInt();
        int n2 = sc.nextInt(); 

        System.out.println(anybaseAddition(b,n1 ,n2));
    }
    
}
