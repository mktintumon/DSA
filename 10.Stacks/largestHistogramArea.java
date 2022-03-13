import java.util.*;

public class largestHistogramArea {
    
    // nsor = nextSmallerOnRight
    // nsol = nextSmallerOnleft
    
    public int largestRectangleArea(int[] heights) {
        int maxArea = 0;
        int maxWidth = 0;
        
        int[] nsor = nsor(heights);
        int[] nsol = nsol(heights);
        
        for(int i=0 ; i<heights.length ; i++){
            maxWidth = nsor[i] - nsol[i] -1 ; // derived formula
            int currArea = heights[i]*maxWidth;
            
            maxArea = Math.max(maxArea , currArea);
        }
        
        return maxArea;
    }
    
    private int[] nsor(int[] heights){
        int n = heights.length;
        int[] ans = new int[n];
        Arrays.fill(ans,n);

        Stack<Integer> st = new Stack<>();

        for(int i=0 ; i<n ; i++){

        while(st.size() != 0 && heights[st.peek()] > heights[i]){ 
          int idx = st.pop();
          ans[idx] = i;
        }
        st.push(i);
        }

        return ans;
    }
    
    public static int[] nsol(int[] heights){
        int n = heights.length;
        int[] ans = new int[n];
        Arrays.fill(ans,-1);
    
        Stack<Integer> st = new Stack<>();
    
        for(int i=n-1 ; i>=0 ; i--){ 
          while(st.size() != 0 && heights[st.peek()] > heights[i]){  
              int idx = st.pop();
              ans[idx] = i;
          }
            st.push(i);
          }
    
          return ans;
    }
}
