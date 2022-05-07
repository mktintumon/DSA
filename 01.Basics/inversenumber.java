
import java.util.Scanner;


public class inversenumber {
    public static Scanner sc = new Scanner(System.in);
    
    public static int inverse(int n){
        int result =0; 
        int lastIndex = 1;
        while(n!=0){
            int  lastDigit = n%10;
            n /= 10;

            result = result + lastIndex* (int)Math.pow(10,lastDigit-1); //logic
            lastIndex++;
        }

        return result;
    }

    public static void main(String[] args) {
        int n = sc.nextInt();
        System.out.println(inverse(n));
    }
}
