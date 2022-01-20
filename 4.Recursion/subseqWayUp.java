package DSA.Recursion;
import java.util.Scanner;

public class subseqWayUp {
    public static Scanner sc = new Scanner(System.in);

    public static void subsequence(String str , String ans){
        if(str.length() == 0){
            System.out.println(ans);
            return;
        }

        char ch = str.charAt(0);
        String rest = str.substring(1);

        // 2 choices - include and exclude
        subsequence(rest, ans+ch);
        subsequence(rest, ans);
    }

    public static void main(String[] args) {
        String str = sc.next();
        subsequence(str , "");
    }
}
