import java.util.*;

public class priorityQueueDemo {
    
    public static void main(String[] args) {
        int [] arr =  {21, 57, 92, 13, 43, 22, 21, 6};

        // By default -> min priority queue

        /*
            PriorityQueue<Integer> pq = new PriorityQueue<>();
            for(int ele : arr){
                pq.add(ele);
            }

            while(pq.size() != 0){
                System.out.println(pq.peek());
                pq.remove();// -> automatically remove the min element(its min pq)
            }

        */

        // Making max priority queue
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
            for(int ele : arr){
                pq.add(ele);
            }


        while(pq.size() != 0){
            System.out.println(pq.peek());
            pq.remove();// -> automatically remove the max element(its max pq)
        }

        
    }
}
