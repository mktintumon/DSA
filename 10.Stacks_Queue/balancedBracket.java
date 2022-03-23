import java.util.*;

public class balancedBracket {
    
    public static boolean balanced(String s){
        Stack<Character> st = new Stack<>();
        for(int i=0 ; i<s.length() ; i++){
            char ch = s.charAt(i);
            
            if(ch == '(' || ch == '{' || ch == '['){
                st.push(ch);
            }
            else if(ch == ')'){
                boolean val = handleClosingBracket(st , '(');
                if(val == false){
                    return false;
                }
            }
            else if(ch == '}'){
                boolean val = handleClosingBracket(st , '{');
                if(val == false){
                    return false;
                }
            }
            else if(ch == ']'){
                boolean val = handleClosingBracket(st , '[');
                if(val == false){
                    return false;
                }
            }
        }
        
        if(st.size() == 0 ){ 
            return true;
        }
        else{
            return false; // means no. of opening bracket is more than closing one
        }
    }
    
    public static boolean handleClosingBracket(Stack<Character> st , char counterBracket){
        if(st.size() == 0){  // this means no. of closing bracket is more than opening bracket
            return false;
        }
        else if(st.peek() != counterBracket){
            return false;
        }
        else{
            st.pop();
            return true;
        }
        
    }

    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        
        boolean ans = balanced(s);
        System.out.println(ans);
        sc.close();
    }

}