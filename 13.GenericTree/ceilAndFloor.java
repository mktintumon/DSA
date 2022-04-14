import java.io.*;
import java.util.*;

public class ceilAndFloor {
  private static class Node {
    int data;
    ArrayList<Node> children = new ArrayList<>();
  }

  public static void display(Node node) {
    String str = node.data + " -> ";
    for (Node child : node.children) {
      str += child.data + ", ";
    }
    str += ".";
    System.out.println(str);

    for (Node child : node.children) {
      display(child);
    }
  }

  public static Node construct(int[] arr) {
    Node root = null;

    Stack<Node> st = new Stack<>();
    for (int i = 0; i < arr.length; i++) {
      if (arr[i] == -1) {
        st.pop();
      } else {
        Node t = new Node();
        t.data = arr[i];

        if (st.size() > 0) {
          st.peek().children.add(t);
        } else {
          root = t;
        }

        st.push(t);
      }
    }

    return root;
  }

  
  static int ceil;  // set at +infinity
  static int floor; // set at -infinity
  public static void ceilFloor(Node node, int data) {
      
    if(node.data > data){
    // potential ceil members enter

        if(node.data < ceil){
        ceil = node.data;
        }
    }
    else if(node.data < data){
    // potential floor members enters

        if(node.data > floor){
        floor = node.data;
        }
    }

    // travel 
    for(Node child : node.children){
        ceilFloor(child , data);
    }
  }

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int n = Integer.parseInt(br.readLine());
    int[] arr = new int[n];
    String[] values = br.readLine().split(" ");
    for (int i = 0; i < n; i++) {
      arr[i] = Integer.parseInt(values[i]);
    }

    int data = Integer.parseInt(br.readLine());

    Node root = construct(arr);
    ceil = Integer.MAX_VALUE;  // smallest among larger
    floor = Integer.MIN_VALUE; // largest among smaller
    ceilFloor(root, data);
    System.out.println("CEIL = " + ceil);
    System.out.println("FLOOR = " + floor);
  }

}