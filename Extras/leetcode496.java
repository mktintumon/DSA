import java.util.*;


/*
  Approach:-

  1) create hashmap<I,I> and stack<I>
  2) travel from n-1 to 0 in nums2
  3) put in stack and accordingly put in hashmap
  4) lastly we dont need to create extra arr , we get the element<pair> 
     of nums1 from hashmap as <value> in O(1) and returns nums1  


*/

class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        Stack<Integer> st = new Stack<>();
        HashMap<Integer,Integer> hm = new HashMap<>();
        
        for(int i=nums2.length-1 ; i>=0 ; i--){
            while(st.size() != 0 && st.peek() <= nums2[i]){
                st.pop();
            }
            
            if(st.size() == 0 ){
                hm.put(nums2[i] , -1);
            }
            else{
                hm.put(nums2[i] , st.peek() );
            }
            
            st.push(nums2[i]);
        }
        
        for(int i=0 ; i<nums1.length ; i++){
            nums1[i] = hm.get(nums1[i]); 
        }
        
        return nums1;
            
    }
}