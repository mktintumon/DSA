import java.io.*;
import java.util.*;

public class mergeIntervals {

    public static void main(String[] args) throws Exception {
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[][] arr = new int[n][2];

        for (int j = 0; j < n; j++) {
            String line = br.readLine();
            arr[j][0] = Integer.parseInt(line.split(" ")[0]);
            arr[j][1] = Integer.parseInt(line.split(" ")[1]);
        }

        mergeOverlappingIntervals(arr);
    }

    public static void mergeOverlappingIntervals(int[][] intervals) {
         Arrays.sort(intervals , (a,b)->{
            return a[0] - b[0];
        });
            
        Stack<int[]> st = new Stack<>(); 
        st.push(intervals[0]);
        
        for(int i=1 ; i<intervals.length ; i++){
            int[] temp = st.pop();
            
            int start1 = temp[0];
            int end1 = temp[1];
            
            int start2 = intervals[i][0];
            int end2 = intervals[i][1];
            
            if(start2 <= end1){
                int endMax = Math.max(end1 , end2);
                int[] merge = {start1 , endMax};
                st.push(merge);
            }
            else{
                st.push(temp);
                st.push(intervals[i]);
            }
        }
        
        int[][] ans = new int[st.size()][2];
        for(int i=ans.length-1 ; i>=0 ; i--){
            int[] val = st.pop();
            ans[i][0] = val[0];
            ans[i][1] = val[1];
        }
        
        // return ans
        for(int[] d : ans){
            System.out.println(d[0] + " " + d[1]);
        }
        
    }

}
