package DSA.Recursion;
import java.util.Scanner;
import java.util.ArrayList;

public class getStairPath {
    public static Scanner sc = new Scanner(System.in);

    //only steps allowed is 1,2 and 3.
    public static ArrayList<String> getPath(int n){
         if(n == 0){
            ArrayList<String> base = new ArrayList<>();
            base.add("");
            return base;
         }

         ArrayList<String> myAns = new ArrayList<>();

        for(int i=1 ; i<=n ; i++){
         if(n-i>=0){
            ArrayList<String> recAns = getPath(n-i);
            for(String ele : recAns){
                myAns.add(i + ele);
            }
         }
        }
        return myAns;

    }


    
    public static void main(String[] args) {
        int n = sc.nextInt();

        ArrayList<String> ans = getPath(n);
        System.out.println(ans);
    }
}
