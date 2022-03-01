package DSA.basics;
import java.util.Scanner;

public class AnybaseSubtract {
    public static Scanner sc = new Scanner(System.in);
    
    public static int anybaseSubtraction(int b ,int n1 , int n2){
        int ans = 0;
        int borrow =0;
        int pow=1;

        while(n1!=0 || n2!=0){
            int sub = n1%10 - n2%10 + borrow;
            n1 /= 10;
            n2 /= 10;

                if(sub<0){
                   sub = sub+b; //10 will be replaced by base
                   borrow = -1;
                }else{
                   borrow=0;
                }

            ans = ans + sub*pow;
            pow = pow*10;    
        }

        return ans; 

    }
    
    public static void main(String[] args) {
        int b = sc.nextInt();
        int n1 = sc.nextInt();
        int n2 = sc.nextInt(); 

        System.out.println(anybaseSubtraction(b,n1 ,n2));
    }
    
}
