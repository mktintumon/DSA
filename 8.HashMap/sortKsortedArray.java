import java.io.*;
import java.util.*;

public class sortKsortedArray {

   public static void main(String[] args) throws Exception {
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
      int n = Integer.parseInt(br.readLine());
      int[] arr = new int[n];

      for (int i = 0; i < n; i++) {
         arr[i] = Integer.parseInt(br.readLine());
      }

      int k = Integer.parseInt(br.readLine());
      
      PriorityQueue<Integer> pq = new PriorityQueue<>();
      
      // input first k element
      for(int i=0 ; i<=k ; i++){
         pq.add(arr[i]);
      }

      // print min and remove min and add the next element
      for(int i= k+1 ; i<arr.length ; i++){
         System.out.println( pq.remove());
         pq.add(arr[i]);
      }

      // print all left out element
      while(pq.size() != 0){
         System.out.println(pq.remove());
      }
   }

}
