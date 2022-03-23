import java.io.*;
import java.util.*;

public class infixEvaluation{

    /*
        Assumptions Given :=

        1) only single digit (0-9)
        2) only 4 operator ( + , - , * , / )
        3) precedence( * == / ) > precedence( + == - )
        4) bracket () -> may be given or not
    
    
    */

public static int precedence(char ch){
    if(ch == '+' || ch == '-'){
        return 1;
    }

    return 2;
}

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
  

public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    String exp = br.readLine();

    Stack<Character> operator = new Stack<>();
    Stack<Integer> operand = new Stack<>();

    for(int i=0 ; i<exp.length() ; i++){
        char ch = exp.charAt(i);

        if(ch == '('){
            operator.push(ch);
        }
        else if(ch >= '0' && ch<='9'){
            operand.push(ch-'0');
        }
        else if(ch == ')'){

            while(operator.peek() != '('){
                char optr = operator.pop();
                int value2 = operand.pop();
                int value1 = operand.pop();
                int ans = calculate(optr , value1 , value2);
                operand.push(ans);
            }

            operator.pop();

        }
        else if(isOperator(ch)){

            while(operator.size() > 0 && operator.peek() != '(' && precedence(ch) <= precedence(operator.peek())){
                char optr = operator.pop();
                int value2 = operand.pop();
                int value1 = operand.pop();
                int ans = calculate(optr , value1 , value2);
                operand.push(ans);
            }

            operator.push(ch);
        }
    }

    // if anything left in operator stack 
    while(operator.size() != 0){
        char ch = operator.pop();
        int value2 = operand.pop();
        int value1 = operand.pop();
        int ans = calculate(ch , value1 , value2);
        operand.push(ans);
    }

    System.out.println(operand.peek());

}
}
