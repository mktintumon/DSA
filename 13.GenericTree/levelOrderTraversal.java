import java.io.*;
import java.util.*;

/*
    1. Same line traversal
    2. level wise traversal 
    3. ZigZag traversal
*/

public class levelOrderTraversal {
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

 // LEVEL ORDER SAME LINE
  public static void levelOrder(Node node){
    Queue<Node> qu = new LinkedList<>();
    qu.add(node);

    while(qu.size() != 0){
      Node rem = qu.remove();
      System.out.print(rem.data + " ");

      for(Node child : rem.children){
        qu.add(child);
      }
    }

    System.out.println(".");
  }


   // LEVEL ORDER LINE WISE
  public static void levelOrderLinewise(Node node){
    Queue<Node> qu = new LinkedList<>();
    qu.add(node);

    while(qu.size() != 0){
      int count = qu.size();

      for(int i=0 ; i<count ; i++){
        node = qu.remove();
        System.out.print(node.data + " ");

        for(Node child : node.children){
          qu.add(child);
        }
      }
      System.out.println();
    }

  }

 // ZigZag traversal
  public static void levelOrderZigZag(Node node){
    Stack<Node> mainSt = new Stack<>();
    mainSt.push(node);

    Stack<Node> childSt = new Stack<>();
    int level = 1;

    while(mainSt.size() != 0){
      node = mainSt.pop();
      System.out.print(node.data + " ");

      if(level % 2 == 1){
        // odd level (direction-->)
         for(int i=0 ; i<node.children.size() ; i++){
           Node child = node.children.get(i);
           childSt.push(child);
         }
      }
      else{
        // even level (direction <--)
        for(int i=node.children.size()-1 ; i>=0 ; i--){
           Node child = node.children.get(i);
           childSt.push(child);
         }
      }


     if(mainSt.size() == 0){
     mainSt = childSt;
     childSt = new Stack<>();
     level++;
     System.out.println();
    } 
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

    Node root = construct(arr);
    levelOrderLinewise(root);
  }

}
