import java.io.*;

public class questions {
  public static class Node {
    int data;
    Node next;
  }

  public static class LinkedList {
    Node head;
    Node tail;
    int size;

    void addLast(int val) {
      Node temp = new Node();
      temp.data = val;
      temp.next = null;

      if (size == 0) {
        head = tail = temp;
      } else {
        tail.next = temp;
        tail = temp;
      }

      size++;
    }

    public int size() {
      return size;
    }

    public void display() {
      for (Node temp = head; temp != null; temp = temp.next) {
        System.out.print(temp.data + " ");
      }
      System.out.println();
    }

    public void removeFirst() {
      if (size == 0) {
        System.out.println("List is empty");
      } else if (size == 1) {
        head = tail = null;
        size = 0;
      } else {
        head = head.next;
        size--;
      }
    }

    public int getFirst() {
      if (size == 0) {
        System.out.println("List is empty");
        return -1;
      } else {
        return head.data;
      }
    }

    public int getLast() {
      if (size == 0) {
        System.out.println("List is empty");
        return -1;
      } else {
        return tail.data;
      }
    }

    public int getAt(int idx) {
      if (size == 0) {
        System.out.println("List is empty");
        return -1;
      } else if (idx < 0 || idx >= size) {
        System.out.println("Invalid arguments");
        return -1;
      } else {
        Node temp = head;
        for (int i = 0; i < idx; i++) {
          temp = temp.next;
        }
        return temp.data;
      }
    }

    public void addFirst(int val) {
      Node temp = new Node();
      temp.data = val;
      temp.next = head;
      head = temp;

      if (size == 0) {
        tail = temp;
      }

      size++;
    }

    public void addAt(int idx, int val) {
      if (idx < 0 || idx > size) {
        System.out.println("Invalid arguments");
      } else if (idx == 0) {
        addFirst(val);
      } else if (idx == size) {
        addLast(val);
      } else {
        Node node = new Node();
        node.data = val;

        Node temp = head;
        for (int i = 0; i < idx - 1; i++) {
          temp = temp.next;
        }
        node.next = temp.next;

        temp.next = node;
        size++;
      }
    }

    public void removeLast() {
      if (size == 0) {
        System.out.println("List is empty");
      } else if (size == 1) {
        head = tail = null;
        size = 0;
      } else {
        Node temp = head;
        for (int i = 0; i < size - 2; i++) {
          temp = temp.next;
        }

        tail = temp;
        tail.next = null;
        size--;
      }
    }

    public void removeAt(int idx) {
      if (idx < 0 || idx >= size) {
        System.out.println("Invalid arguments");
      } else if (idx == 0) {
        removeFirst();
      } else if (idx == size - 1) {
        removeLast();
      } else {
        Node temp = head;
        for (int i = 0; i < idx - 1; i++) {
          temp = temp.next;
        }

        temp.next = temp.next.next;
        size--;
      }
    }

    private Node getNodeAt(int idx) {
      Node temp = head;
      for (int i = 0; i < idx; i++) {
        temp = temp.next;
      }
      return temp;
    }

    public void reverseDI() {
      int li = 0;
      int ri = size - 1;
      while(li < ri){
        Node left = getNodeAt(li);
        Node right = getNodeAt(ri);

        int temp = left.data;
        left.data = right.data;
        right.data = temp;

        li++;
        ri--;
      }
    }
 
    public void reversePI(){
      if(size <= 1){
        return;
      }

      Node prev = null;
      Node curr = head;
      while(curr != null){
        Node next = curr.next;
        
        curr.next = prev;
        prev = curr;
        curr = next;
      }

      Node temp = head;
      head = tail;
      tail = temp;
    }
  
    // 1. FInd the kth node data from the last , based on 0 indexing 

    public int kthFromLast(int k){
      Node slow = head;
      Node fast = head;

      for(int i=0 ;i<k ; i++){
        fast = fast.next;
      }

      while(fast.next!=null){
        slow = slow.next;
        fast = fast.next;
      }

      return slow.data;
    }

    // 2. find the mid-data of linkedlist

    public int mid(){
        Node slow = head;
        Node fast = head;
  
        while(fast.next!=null && fast.next.next!=null){
          slow = slow.next;
          fast = fast.next.next;
        }
  
        return slow.data;
      }

      //3. find the mid node of linked list-> given-> head and tail
      
      public static Node midNode(Node head, Node tail) {
        Node slow = head;
        Node fast = head;
        
        while(fast != tail && fast.next != tail){
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
      }

      // 4. Merge two sorted list

      public static LinkedList mergeTwoSortedLists(LinkedList l1, LinkedList l2) {
        LinkedList l3 = new LinkedList(); // initialize new list

          Node c1 = l1.head;
          Node c2 = l2.head;

          while( c1 != null && c2 != null){ // till any one of them get exhausted
              if(c1.data < c2.data){
                  l3.addLast(c1.data);
                  c1 = c1.next;
              }
              else{
                  l3.addLast(c2.data);
                  c2 = c2.next;
              }
          }

          while(c1 != null){ // if c2 exhaust then print only c1
              l3.addLast(c1.data);
              c1 = c1.next;
          }

          while( c2 != null){ // if c1 exhaust then print only c2
              l3.addLast(c2.data);
              c2 = c2.next;
          }

          return l3; // return list
  }

      // 5. MERGE SORT

      public static LinkedList mergeSort(Node head, Node tail){
        if(head == tail){
           LinkedList base = new LinkedList();
           base.addFirst(head.data);
           return base;
        }
  
        Node mid = midNode(head,tail);
  
        LinkedList left = mergeSort(head,mid);
        LinkedList right = mergeSort(mid.next,tail);
  
        return mergeTwoSortedLists(left,right);
        
      }

      // 6.Remove Duplicates

      public void removeDuplicates(){
        LinkedList nl = new LinkedList(); // store in new list
  
        // get -> remove -> check -> add
        while(this.size > 0){
          int val = this.getFirst();
          this.removeFirst();
  
          if(nl.size == 0 || nl.tail.data != val){
            nl.addLast(val);
          }
        }
  
        //deep copy
        this.head = nl.head;
        this.tail = nl.tail;
        this.size = nl.size;
      }

      // 7.Odd-Even linked list

      public void oddEven(){
        LinkedList odd = new LinkedList();
        LinkedList even = new LinkedList();
  
        while(this.size > 0){
          // get -> remove -> check -> add
          int val = this.getFirst();
          this.removeFirst();
  
          if(val%2 == 0){
            //even
            even.addLast(val);
          }
          else{
            //odd
            odd.addLast(val);
          }
        }
  
        //three edge cases to handle
        if(odd.size > 0 && even.size > 0){ // both list exists
           odd.tail.next = even.head;
           this.head = odd.head;
           this.tail = even.tail;
           this.size = odd.size + even.size;
        }
  
        else if(odd.size > 0){ // only odd list exists
           this.head = odd.head;
           this.tail = odd.tail;
           this.size = odd.size;
        }
  
        else if(even.size > 0){ // only even list exists
           this.head = even.head;
           this.tail = even.tail;
           this.size = even.size;
        }
      }


      // 8. K-reverse in linked list
        
      public void kReverse(int k) {
        if(k > this.size){ //return same list
          return;
        }
 
        LinkedList ans = new LinkedList(); // store actual answer
 
        while(this.size >= k){
          LinkedList temp = new LinkedList(); //store answer for k reverse
          
          // Now reverse the k elements
          for(int i=0 ; i<k ; i++){
            int val = this.getFirst();
            this.removeFirst();
            temp.addFirst(val);// -> will reverse 
          }
  
        if(ans.size == 0){
          ans = temp; // transfer full temp list to ans list
        }
        else{
          ans.tail.next = temp.head;
          ans.tail = temp.tail;
          ans.size += temp.size; // size(before) + current(temp size)
        }
     }
 
        // now operate the left over elements
        if(this.size > 0){
          ans.tail.next = this.head;
          ans.tail = this.tail;
          ans.size += this.size;
        }
 
        //deep copy
        this.head = ans.head;
        this.tail = ans.tail;
        this.size = ans.size;
     }
     
}

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    LinkedList list = new LinkedList();

    String str = br.readLine();
    while (str.equals("quit") == false) {
      if (str.startsWith("addLast")) {
        int val = Integer.parseInt(str.split(" ")[1]);
        list.addLast(val);
      } else if (str.startsWith("size")) {
        System.out.println(list.size());
      } else if (str.startsWith("display")) {
        list.display();
      } else if (str.startsWith("removeFirst")) {
        list.removeFirst();
      } else if (str.startsWith("getFirst")) {
        int val = list.getFirst();
        if (val != -1) {
          System.out.println(val);
        }
      } else if (str.startsWith("getLast")) {
        int val = list.getLast();
        if (val != -1) {
          System.out.println(val);
        }
      } else if (str.startsWith("getAt")) {
        int idx = Integer.parseInt(str.split(" ")[1]);
        int val = list.getAt(idx);
        if (val != -1) {
          System.out.println(val);
        }
      } else if (str.startsWith("addFirst")) {
        int val = Integer.parseInt(str.split(" ")[1]);
        list.addFirst(val);
      } else if (str.startsWith("addAt")) {
        int idx = Integer.parseInt(str.split(" ")[1]);
        int val = Integer.parseInt(str.split(" ")[2]);
        list.addAt(idx, val);
      } else if (str.startsWith("removeLast")) {
        list.removeLast();
      } else if (str.startsWith("removeAt")) {
        int idx = Integer.parseInt(str.split(" ")[1]);
        list.removeAt(idx);
      } else if(str.startsWith("reverseDI")){
        list.reverseDI();
      } else if(str.startsWith("reversePI")){
        list.reversePI();
      } else if(str.startsWith("kthFromEnd")){
        int idx = Integer.parseInt(str.split(" ")[1]);
        System.out.println(list.kthFromLast(idx));
      }
      str = br.readLine();
    }
  }
}