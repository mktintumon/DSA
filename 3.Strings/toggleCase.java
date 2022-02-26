import java.util.Scanner;

    public class toggleCase {
    public static Scanner sc = new Scanner(System.in);

    public static String toggle(String str){
        StringBuilder ans = new StringBuilder();

        // ('D' - 'A') = ('d' - 'a')
        // 'D' - 'A' + 'a' = 'd'
        // CH  = ch - 'a' + 'A'
        // ch  = CH - 'A' + 'a'

        for(int i=0 ; i<str.length() ; i++){
            char ch = str.charAt(i);

            if(ch>='A' && ch<='Z'){
                char lc = (char)(ch - 'A' + 'a');
                ans.append(lc);
            }

            if(ch>='a' && ch<='z'){
                char uc = (char)(ch - 'a' + 'A');
                ans.append(uc);
            }
        }

        return ans.toString(); // ans is stringbuilder , so we attach tostring to convert in string
    }

    public static void main(String[] args) {
        String str = sc.next();
        System.out.println(toggle(str));
    }
}
