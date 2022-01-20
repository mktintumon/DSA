package DSA.Recursion;
import java.util.ArrayList;
import java.util.Scanner;

public class mazepathJump{
    public static Scanner sc = new Scanner(System.in);

    public static ArrayList<String> mazepathWithJump(int sr ,int sc,int dr,int dc){
        if(sr==dr && sc==dc){
            ArrayList<String> base = new ArrayList<>();
            base.add("");
            return base;
        }

        ArrayList<String> myAns = new ArrayList<>();

        for(int jump=1 ; sc+jump<=dc ; jump++ ){
            ArrayList<String> hCall = mazepathWithJump(sr, sc+jump, dr, dc);
            for(String ele : hCall){
                myAns.add("h" + jump + ele);
            }
        }

        for(int jump=1 ; sr+jump<=dr ; jump++ ){
            ArrayList<String> vCall = mazepathWithJump(sr+jump , sc, dr, dc);
            for(String ele : vCall){
                myAns.add("v" + jump + ele);
            }
        }

        for(int jump=1 ; sc+jump<=dc && sr+jump<=dr ; jump++ ){
            ArrayList<String> dCall = mazepathWithJump(sr+jump, sc+jump, dr, dc);
            for(String ele : dCall){
                myAns.add("d" + jump + ele);
            }
        }

        return myAns;
    }

    public static void main(String[] args) {
        int n = sc.nextInt();
        int m = sc.nextInt();

        System.out.println(mazepathWithJump(0 , 0 , n-1 , m-1));
    }
}