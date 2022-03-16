import java.io.*;
import java.util.*;

public class postfixEvalAndConversion{
    
public static boolean isOperator(char ch){
    if(ch == '+' || ch == '-' || ch == '*' || ch == '/'){
        return true;
    }

    return false;
}

public static int calculate(char optr , int a , int b){
    if(optr == '+'){
        return a+b;
    }
    else if(optr == '-'){
        return a-b;
    }
    else if(optr == '*'){
        return a*b;
    }
    else if(optr == '/'){
        return a/b;
    }

    return 0;
}

public static void evaluation(char ch , Stack<Integer> eval){
    if(eval.size()>0){
        char operator = ch;
        int v1 = eval.pop();
        int v2 = eval.pop();
        
        int val = calculate(operator , v2 , v1);
        eval.push(val);
    }
}

public static void infixExp(char ch , Stack<String> infix){
    if(infix.size()>0){
        char operator = ch;
        String v1 = infix.pop();
        String v2 = infix.pop();
        
        String val = '(' + v2 + operator + v1 + ')';
        infix.push(val);
    }
}

public static void prefixExp(char ch , Stack<String> prefix){
    if(prefix.size()>0){
        char operator = ch;
        String v1 = prefix.pop();
        String v2 = prefix.pop();
        
        String val =  operator + v2  + v1 ;
        prefix.push(val);
    }
}

public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    String exp = br.readLine(); // given postfix expression

    Stack<Integer> eval = new Stack<>();
    Stack<String> infix = new Stack<>();
    Stack<String> prefix = new Stack<>();
    
    for(int i=0 ; i<exp.length() ; i++ ){
        char ch = exp.charAt(i);
        
        if(ch >= '0' && ch <= '9'){
            eval.push(ch-'0');
            infix.push(ch+"");
            prefix.push(ch+"");
        }
        else if(isOperator(ch)){
            evaluation(ch , eval);
        
            infixExp(ch , infix);
        
            prefixExp(ch , prefix);
            
        }
    }
    
    System.out.println(eval.peek());
    System.out.println(infix.peek());
    System.out.println(prefix.peek());
 }
}