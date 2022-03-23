import java.io.*;
import java.util.*;

public class prefixEvalAndConversion{

    public static boolean isOptr(char ch){
        if(ch == '+' || ch == '-' || ch == '*' || ch == '/'){
            return true;
        }
        return false;
    }

    public static int calVal(int a, int b, char ch){
        if(ch == '+')
            return a + b;
        else if(ch == '-')
            return a - b;
        else if(ch == '*')
            return a * b;      
        else if(ch == '/')
            return a / b;
        else
            return 0;
    }

    public static void evaluation(char ch , Stack<Integer> eval){
        if(eval.size() > 0){
            int v1 = eval.pop();
            int v2 = eval.pop();

            int ans = calVal(v1, v2, ch);
            eval.push(ans);
        }
    }

    public static void infixExp(char ch , Stack<String> infix ){
        if(infix.size() > 0){
            String v1 = infix.pop();
            String v2 = infix.pop();

            String ans = '(' + v1 + ch + v2 + ')';
            infix.push(ans);
        }
    }

    public static void postfixExp(char ch , Stack<String> postfix ){
        if(postfix.size() > 0){
            String v1 = postfix.pop();
            String v2 = postfix.pop();

            String ans = v1 + v2 + ch;
            postfix.push(ans);
        }
    }
  

public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    String exp = br.readLine();

    Stack<Integer> eval = new Stack<>(); 
    Stack<String> infix = new Stack<>(); 
    Stack<String> postfix = new Stack<>();

    int n = exp.length();

    for(int i = n - 1; i >= 0; i--){
        char ch = exp.charAt(i);

        if(ch >= '0' && ch <= '9'){
            eval.push(ch - '0');
            infix.push(ch + "");
            postfix.push(ch + "");
        }
        else if(isOptr(ch)){
            evaluation(ch , eval);
            infixExp(ch , infix);
            postfixExp(ch , postfix);
        }

    }

    System.out.println(eval.peek());
    System.out.println(infix.peek());
    System.out.println(postfix.peek());
 }
}