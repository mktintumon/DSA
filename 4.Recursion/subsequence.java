package DSA.Recursion;
import java.util.ArrayList;
import java.util.Scanner;

public class subsequence {
    public static Scanner sc = new Scanner(System.in);

    public static ArrayList<String> subseq(String s){
        if(s.length() == 0){
            ArrayList<String> base = new ArrayList<>();
            base.add("");
            return base;
         }

         char ch = s.charAt(0);
         String rest = s.substring(1);

         ArrayList<String> recAns = subseq(rest);
         ArrayList<String> myAns = new ArrayList<>();

         for(String ele : recAns){
             myAns.add(ele);
         }

         for(String ele : recAns){
             myAns.add(ch+ele);
         }

         return myAns;
    }

    public static void main(String[] args) {
        String s = sc.next();

        ArrayList<String> ans = subseq(s); //func return arraylist only
        System.out.println(ans);
    }

}
