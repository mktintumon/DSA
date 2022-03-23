import java.io.*;
import java.util.*;

public class celebrityProblem {

    public static void main(String[] args) throws Exception {
        // write your code here
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[][] arr = new int[n][n];

        for (int j = 0; j < n; j++) {
            String line = br.readLine();
            for (int k = 0; k < n; k++) {
                arr[j][k] = line.charAt(k) - '0';
            }
        }

        findCelebrity(arr);

    }

    public static void findCelebrity(int[][] arr) {
        // if a celebrity is there print it's index (not position), if there is not then
        // print "none"
        
        Stack<Integer> st = new Stack<>();
        for(int i=0 ; i<arr.length ; i++){
            st.push(i);
        }
        
        while(st.size() >= 2){
            int val1 = st.pop();
            int val2 = st.pop();
            
            if(arr[val2][val1] == 1){
                // this means val2 knows val1 , so val2 cant be celebrity
                st.push(val1);
            }
            else{
                st.push(val2);
            }
        
        }
        
        //potential celebrity
        int pc = st.pop();
        
        boolean ans = true;

        // checking row for 0 and col for 1
        for(int i=0 ; i<arr.length ; i++){
            if((pc != i && (arr[pc][i] == 1 || arr[i][pc] == 0))){
                ans = false;
            }
        }
        
        if(ans == true) System.out.println(pc);
        else System.out.println("none");
    }

}