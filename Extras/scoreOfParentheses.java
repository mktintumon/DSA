import java.util.*;

public class scoreOfParentheses {
    
    public static int sop(String s) {
        Stack<Integer> st = new Stack<>();
        
        int score = 0;
        for(int i=0 ; i<s.length() ; i++){
            char ch = s.charAt(i);
            
            if(ch == '('){
                st.push(score);
                score = 0;
            }
            else{
                int val = st.pop();
                int currScore = Math.max(2*score , 1);
                score = val + currScore;
            }
        }
        return score;
    }


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.next();
        int ans = sop(s);
        System.out.println(ans);
        sc.close();
    }
}