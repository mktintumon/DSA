import java.util.*;
import java.io.*;

public class KlargestElement {
    public static void main(String[] args) throws Exception {
        // Input output given
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];
  
        for (int i = 0; i < n; i++) {
           arr[i] = Integer.parseInt(br.readLine());
        }
  
        int k = Integer.parseInt(br.readLine());

        // k-largest -> min pq
        // k-smallest -> max pq
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for(int i=0 ; i<n ; i++){
            if(i<k){
                pq.add(arr[i]);
            }
            else{
                if(pq.peek() < arr[i]){
                    pq.remove();
                    pq.add(arr[i]);
                }
            }
        }

        while(pq.size() != 0){
            System.out.println(pq.remove());
        }
         

        //System.out.println(pq);
    }
}
