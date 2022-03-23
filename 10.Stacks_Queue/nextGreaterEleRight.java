import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

/*
  APPROACH
  1)Each element that pushed in stack will say -
      [ Mujhse bda element aayega , mujhe pop() krega aur mera answer bn jayega ]

*/

/*
  For Next smaller element in right -> ( arr[st.peek()] > arr[i] )
*/

public class nextGreaterEleRight{
  public static void display(int[] a){
    StringBuilder sb = new StringBuilder();

    for(int val: a){
      sb.append(val + "\n");
    }
    System.out.println(sb);
  }

public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    int n = Integer.parseInt(br.readLine());
    int[] a = new int[n];
    for(int i = 0; i < n; i++){
       a[i] = Integer.parseInt(br.readLine());
    }

    int[] nge = solve(a);
    display(nge);
 }


  // SOLVE ONLY THIS PART
 public static int[] solve(int[] arr){
    int n = arr.length;
    int[] ans = new int[n];
    Arrays.fill(ans,-1);

    Stack<Integer> st = new Stack<>();

    for(int i=0 ; i<n ; i++){

      while(st.size() != 0 && arr[st.peek()] < arr[i]){  // checking size for underflow
          int idx = st.pop();
          ans[idx] = arr[i];
      }
        st.push(i);
    }

    return ans;
 }

}