package DSA.Recursion;
import java.util.Scanner;

public class factorial {

    public static int fact(int n){
        return (n==0) ? 1 : n*fact(n-1);
    }
    
public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int n = sc.nextInt();
    System.out.println(fact(n));
    sc.close();
}
}
