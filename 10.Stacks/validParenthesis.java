import java.util.*;

public class validParenthesis {

    public static boolean valid(String s){
        Stack<Character> st = new Stack<>();
        
        for(int i=0 ; i<s.length() ; i++){
            char ch = s.charAt(i);
            
            if(ch == '{' || ch == '[' || ch == '('){
                st.push(ch);
            }
            else{
                if(st.size() == 0){ // eg : "}}])" -> here nothing got push in stack but have to return false
                    return false;
                }
                
                if(ch == '}' && st.peek() != '{'){
                    return false;
                }
                else if(ch == ']' && st.peek() != '['){
                    return false;
                }
                else if(ch == ')' && st.peek() != '('){
                    return false;
                }
                else{
                    st.pop();
                }
            }
        }
        
        return st.size() == 0 ? true : false;
    }
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.next();

        boolean ans = valid(s);
        System.out.println(ans);
        sc.close();

    }

}
