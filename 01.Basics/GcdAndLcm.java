package DSA.basics;
import java.util.Scanner;

public class GcdAndLcm {
    public static Scanner sc = new Scanner(System.in);

    public static void gcdAndLcm(int n1 , int n2){
        int realn1= n1; // as n1 n2 values changes inside loop
        int realn2 =n2;
        
        while(n1%n2 != 0){ // logic 
            int rem = n1%n2;
            n1=n2;
            n2=rem;
        }
        int gcd = n2;
        int lcm = (realn1 * realn2) / gcd; //formula
        System.out.println("GCD = " + gcd);
        System.out.println("LCM = " + lcm);
        
    }


    public static void main(String[] args) {
        int n1 = sc.nextInt();
        int n2 = sc.nextInt();

        gcdAndLcm(n1, n2);

    }

    
}
