
import java.util.*;

public class encoding {

    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        
        String str = sc.next();
        printEncodings(str,"");
        sc.close();
    }

    public static void printEncodings(String str,String path) {
        if(str.length()==0){
            System.out.println(path);
            return;
        }
        
        if(str.charAt(0) == '0'){
         return;
        }
        
        // string -> 655196
        
        char ch1 = str.charAt(0);         // char->'6'
        int v1 = ch1 -'0';                // int->6
        String rest1 = str.substring(1);  // string left->55196
        
        printEncodings(rest1 , path+ (char)(v1+'a'-1)); // (char)(6+97-1) = 102 = f
        
        if(str.length() > 1){
            char ch2 = str.charAt(1);  // '5'
            int v2 = ch2 -'0';         //  5
            int num = (v1*10) + v2;    // (6*10)+5 = 65
            
            String rest2 = str.substring(2);            
            if(num<=26){
                printEncodings(rest2 , path+ (char)(num+'a'-1));
            }
            
        }
        
        
    }

}