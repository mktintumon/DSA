
import java.util.Scanner;

public class permutation {
    
public static void permutate(String str , String path){
    if(str.length() == 0){
        System.out.println(path);
        return;
    }

    for(int i=0 ; i<str.length() ; i++){ // loop goes for a then b then c
        char ch = str.charAt(i);
        String rest = str.substring(0,i) + str.substring(i+1);

        permutate(rest , path+ch);
    }
}

public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    String str = sc.next();
         
    permutate(str,"");
    sc.close();

    }
}
