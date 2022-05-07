
import java.util.Scanner;

public class primeFactors {
    public static Scanner sc = new Scanner(System.in);

    public static boolean prime(int n){
        for(int i=2 ; i*i < n ; i++){
            if(n%i == 0){
               return false;
            }
        }
        return true;
  }

    public static void primeFctr(int n){
        for(int pn=2 ; pn*pn<n ; pn++){// gives 2 3 5 only without repetition
            while(n%pn==0){ // gives 2 2 2 2 2 3 3 5
                System.out.println(pn +" ");
                n /= pn;
            }
        }
        if(n!=1) System.out.print(n); // edge case if n/=pn is not 1 during exiting loop
    }

    public static void main(String[] args) {
        int n = sc.nextInt();
        primeFctr(n);
    }
}
