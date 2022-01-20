import java.io.*;
import java.util.*;


public class listToStack {

    // java have pre made functions and we just import them and use
    // some of them are getfirst() , getLast() , getAt() , size() etc

    public static class LLToStackAdapter {
        LinkedList<Integer> list;
    
        public LLToStackAdapter() {
          list = new LinkedList<>();
        }
    
    
        // we use first() function bcoz it runs in O(1)
        // ignore last() function due to O(n) --> refer notes

        // print in FIFO manner
        int size() {
         return list.size();
        }
    
        void push(int val) {
          list.addFirst(val);
        }
    
        int pop() {
           if(list.size() == 0)
            {
                System.out.println("Stack underflow");
                return -1; 
            }
            else{
              return list.removeFirst();
            }
        }
    
        int top() {
           if(list.size() == 0)
            {
                System.out.println("Stack underflow");
                return -1; 
            }
            else{
              return list.getFirst();
            }
        }
      }
    
      public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        LLToStackAdapter st = new LLToStackAdapter();
    
        String str = br.readLine();
        while(str.equals("quit") == false){
          if(str.startsWith("push")){
            int val = Integer.parseInt(str.split(" ")[1]);
            st.push(val);
          } else if(str.startsWith("pop")){
            int val = st.pop();
            if(val != -1){
              System.out.println(val);
            }
          } else if(str.startsWith("top")){
            int val = st.top();
            if(val != -1){
              System.out.println(val);
            }
          } else if(str.startsWith("size")){
            System.out.println(st.size());
          }
          str = br.readLine();
        }
      }
}
