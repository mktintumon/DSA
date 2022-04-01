import java.io.*;
import java.util.*;

public class isBinarySearchTree {

  // Making  pair 
  public static class pairBST {
      boolean isBST;
      int max;
      int min;

      pairBST(){};

      pairBST(boolean isBST , int max , int min){
        this.isBST = isBST;
        this.max = max;
        this.min = min;
      }
  }


  public static class Node {
    int data;
    Node left;
    Node right;

    Node(int data, Node left, Node right) {
      this.data = data;
      this.left = left;
      this.right = right;
    }
  }

  public static class Pair {
    Node node;
    int state;

    Pair(Node node, int state) {
      this.node = node;
      this.state = state;
    }
  }

  public static Node construct(Integer[] arr) {
    Node root = new Node(arr[0], null, null);
    Pair rtp = new Pair(root, 1);

    Stack<Pair> st = new Stack<>();
    st.push(rtp);

    int idx = 0;
    while (st.size() > 0) {
      Pair top = st.peek();
      if (top.state == 1) {
        idx++;
        if (arr[idx] != null) {
          top.node.left = new Node(arr[idx], null, null);
          Pair lp = new Pair(top.node.left, 1);
          st.push(lp);
        } else {
          top.node.left = null;
        }

        top.state++;
      } else if (top.state == 2) {
        idx++;
        if (arr[idx] != null) {
          top.node.right = new Node(arr[idx], null, null);
          Pair rp = new Pair(top.node.right, 1);
          st.push(rp);
        } else {
          top.node.right = null;
        }

        top.state++;
      } else {
        st.pop();
      }
    }

    return root;
  }

  public static void display(Node node) {
    if (node == null) {
      return;
    }

    String str = "";
    str += node.left == null ? "." : node.left.data + "";
    str += " <- " + node.data + " -> ";
    str += node.right == null ? "." : node.right.data + "";
    System.out.println(str);

    display(node.left);
    display(node.right);
  }

  public static int height(Node node) {
    if (node == null) {
      return -1;
    }

    int lh = height(node.left);
    int rh = height(node.right);

    int th = Math.max(lh, rh) + 1;
    return th;
  }

  // APPROACH -  pair method
  public static pairBST is_BST(Node root){
    if(root == null){
      return new pairBST(true , Integer.MIN_VALUE , Integer.MAX_VALUE);
    }

    pairBST left = is_BST(root.left);
    pairBST right = is_BST(root.right);

    pairBST myAns = new pairBST();

    myAns.isBST = left.isBST == true && right.isBST==true && left.max < root.data && right.min > root.data;
    myAns.max = Math.max(root.data , right.max);
    myAns.min = Math.min(root.data , left.min);

    return myAns;
  }

/*
      APPROACH - taking previous ans use inorder trversal
  
    class Solution {
    
    long prev = Long.MIN_VALUE;
    public boolean isValidBST(TreeNode root) {
        if(root == null) return true;
        
        boolean left = isValidBST(root.left);
        if(left == false) return false;
        
        if(prev >= root.val) return false;
        
        prev = root.val;
        
        boolean right= isValidBST(root.right);
        if(right == false) return false;
        
        return true;
    }
}
  
*/

 
  
  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int n = Integer.parseInt(br.readLine());
    Integer[] arr = new Integer[n];
    String[] values = br.readLine().split(" ");
    for (int i = 0; i < n; i++) {
      if (values[i].equals("n") == false) {
        arr[i] = Integer.parseInt(values[i]);
      } else {
        arr[i] = null;
      }
    }

    Node root = construct(arr);
    
    pairBST ans = is_BST(root);
    System.out.println(ans.isBST);
  }

}