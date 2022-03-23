import java.util.*;

public class duplicateBracket {

   public static boolean duplicate(String s){
      Stack<Character> st = new Stack<>();

      for(int i=0 ; i<s.length() ; i++){
         char ch = s.charAt(i);

         if(ch != ')'){
            st.push(ch);
         }
         else{
            if(st.peek() == '('){
               return true;
            }

            while(st.peek() != '('){
               st.pop();
            }

            st.pop();
         }
      }

      return false;
   }

   public static void main(String[] args) throws Exception {
      Scanner scn = new Scanner(System.in);
      String s = scn.nextLine();
      boolean ans = duplicate(s);
      System.out.println(ans);
      scn.close();
    }
}
