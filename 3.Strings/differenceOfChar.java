import java.util.Scanner;

public class differenceOfChar {
    public static Scanner sc =new Scanner(System.in);
 
    public static void difference(String str){
        int n = str.length();

        StringBuilder ans = new StringBuilder();
        ans.append(str.charAt(0));

        for(int i=1 ; i<n ; i++){
            char current = str.charAt(i);
            char previous = str.charAt(i-1);

            int gap = current - previous;

            ans.append(gap);
            ans.append(current);
        }

        System.out.println(ans);
    }

    public static void main(String[] args) {
        String str= sc.next();
        difference(str);
    }
}
