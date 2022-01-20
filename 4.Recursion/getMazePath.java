package DSA.Recursion;
import java.util.Scanner;
import java.util.ArrayList;

public class getMazePath {
    public static Scanner sc = new Scanner(System.in);

    //  sr = starting row
    //  sc = starting column
    //  dr = destination row
    //  dc = destination column
    public static ArrayList<String> mazepath(int sr , int sc , int dr , int dc){
          if(sr==dr && sc==dc ){ // we use && becoz we want blank arraylist from both side(H,V) 
              ArrayList<String> base = new ArrayList<>();
              base.add("");
              return base;
          }

          ArrayList<String> myAns = new ArrayList<>();

          if(sc+1 <= dc){
               ArrayList<String> recAns = mazepath(sr, sc+1 , dr, dc);
               for(String ele : recAns){
                   myAns.add("h" + ele);
               }
          }

          if(sr+1 <= dr){
            ArrayList<String> recAns = mazepath(sr+1 , sc , dr, dc);
            for(String ele : recAns){
                myAns.add("v" + ele);
            }
          }

          return myAns;
    }

    public static void main(String[] args) {
        int n = sc.nextInt();
        int m = sc.nextInt();

        ArrayList<String> ans = mazepath(0 , 0 , n-1 , m-1);
        System.out.println(ans);

    }
}
