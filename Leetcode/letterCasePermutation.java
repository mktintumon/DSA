package DSA.Leetcode;
import java.util.Scanner;
import java.util.ArrayList;

public class letterCasePermutation {


    public static ArrayList<String> Permutation(String s) {
        if(s.length() == 0){
            ArrayList<String> base = new ArrayList<String>();
            base.add("");
            return base;
        }
        
        char ch = s.charAt(0);
        String rest = s.substring(1); 
        
        ArrayList<String> myAns = new ArrayList<String>();
        ArrayList<String> recAns = Permutation(rest);
        
        for(String ele : recAns){
            myAns.add(ch+ele);
        }
        
        for(String ele : recAns){
            if(ch>='A' && ch<='Z'){
                myAns.add((char)(ch - 'A' + 'a') + ele);
            }
            
            if(ch>='a' && ch<='z'){
                myAns.add((char)(ch - 'a' + 'A') + ele);
            }
        }
        
        return myAns;
    }
    
    
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        String str = sc.next();
        
       ArrayList<String> ans = Permutation(str);
       System.out.println(ans);
       sc.close();
    
    }
}
