
import java.util.Scanner;
import java.util.ArrayList;

public class getKeyPad {
    public static Scanner sc = new Scanner(System.in);

    static String[] key = { ".;", "abc" , "def" , "ghi" ,"jkl" ,"mno" , "pqrs" , "tu" , "vwx" , "yz"};
    
    public static ArrayList<String> keypad(String str){
        if(str.length() == 0){
             ArrayList<String> base = new ArrayList<>();
             base.add("");
             return base;
        }
        
        //str = 57
        char ch = str.charAt(0); // ch=5
        String rest = str.substring(1); // rest = 7

        ArrayList<String> recAns = keypad(rest);
        ArrayList<String> myAns = new ArrayList<>();

        int idx = ch - '0'; // it will change string  ch=7 to int 7 value by ascii
        String code = key[idx];  // key[5] = mno


        for(int i=0 ; i<code.length() ; i++){  // code = mno
            char newChar = code.charAt(i);  // newChar = m
            for(String ele : recAns){
                myAns.add(newChar + ele);
            }
        }

        return myAns;
    }

    public static void main(String[] args) {
        String str = sc.next();
        ArrayList<String> ans = keypad(str);
        System.out.println(ans);
    }
}
