package DSA.Array;
import java.util.ArrayList;
import java.util.Scanner;

public class removePrime {
    public static Scanner sc = new Scanner(System.in);

    public static boolean isPrime(int n){
        for(int i=2 ; i*i <=n ; i++){
            if( n%i == 0){
                return false;
            }
        }
        return true;
    }

    public static void removeP(ArrayList<Integer> ans){
        for(int i=ans.size()-1 ; i>=0 ; i--){
            int value = ans.get(i);

            if(isPrime(value) == true){
                   ans.remove(i);
            }
        }
    }

    public static void main(String[] args) {
        int n = sc.nextInt();

        ArrayList<Integer> ans = new ArrayList<>();
        for(int i=0 ; i<n ; i++){
            ans.add(sc.nextInt());
        }

        removeP(ans);
        System.out.println(ans);
    }
}
