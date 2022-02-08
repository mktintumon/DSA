
import java.util.Scanner;

public class kpcWayUp {
    public static Scanner sc = new Scanner(System.in);

    static String[] key = { ".;", "abc" , "def" , "ghi" ,"jkl" ,"mno" , "pqrs" , "tu" , "vwx" , "yz"};

    public static void kpc(String str,String path){
        if(str.length()==0){
            System.out.println(path);
            return;
        }

        char ch = str.charAt(0);
        String rest = str.substring(1);
        
        String code = key[ch - '0']; // conversion of int into string

        for(int i=0 ; i<code.length() ; i++){
            char newChar = code.charAt(i); // this step is needed bcoz in call we add this to path
            kpc(rest, path+newChar);
        }


    } 

    public static void main(String[] args) {
        String str = sc.next();
        kpc(str,"");
    }
}
