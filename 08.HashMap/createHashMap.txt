import java.io.*;
import java.util.*;

public class createHashMap {

    // let k = 2
    public static class HashMap<K, V> {
    private class HMNode {
      K key;
      V value;
      
      HMNode(K key, V value) {
        this.key = key;
        this.value = value;
      }
    }

    private int size; // n
    private LinkedList<HMNode>[] buckets; // N = buckets.length

    public HashMap() {
      initbuckets(4);
      size = 0;
    }

    private void initbuckets(int N) {
      buckets = new LinkedList[N];
      for (int bi = 0; bi < buckets.length; bi++) {
        buckets[bi] = new LinkedList<>();
      }
    }

    private int findBucketIdx(K key){
        int hc = key.hashCode(); // java inbuilt method gives -> -infi to +infi
        int bi = Math.abs(hc) % buckets.length;

        return bi;
    }

    private int findDataIdxInBucket(K key , int bi){
        LinkedList<HMNode> temp  = buckets[bi];
        for(int i=0 ; i<temp.size() ; i++){
            HMNode curr = temp.get(i);

            if(key.equals(curr.key)){
                return i;
            }
        }

        return -1;
    }

    //REHASHING
    private void rehashing()throws Exception{
        LinkedList<HMNode> [] prevBuckets = buckets; //storing prev bucket size 
        initbuckets(2 * prevBuckets.length);  // double the size of bucket
        size = 0;

        for(int bi = 0; bi<prevBuckets.length; bi++){
            for(int p = 0; p<prevBuckets[bi].size(); p++){
              HMNode currNode = prevBuckets[bi].get(p);
              put(currNode.key, currNode.value);
            }
        }
    }

    // PUT
    public void put(K key, V value) throws Exception {
        int bi = findBucketIdx(key);            //bucketIdx
        int di = findDataIdxInBucket(key, bi);  //dataIdx

        if(di == -1){
            //insert
            LinkedList<HMNode> temp = buckets[bi];
            HMNode node  = new HMNode(key , value);
            temp.add(node);  //addLast
            size++;
        }
        else{
            //update
            LinkedList<HMNode> temp = buckets[bi];
            HMNode node = temp.get(di);
            node.value = value;
        }

        //Condition for rehashing
        double lambda = (size*1.0)/ buckets.length;
        if(lambda > 2){ // as k=2
        rehashing();
        }
 
    }

    // GET
    public V get(K key) throws Exception {
        int bi = findBucketIdx(key);            //bucketIdx
        int di = findDataIdxInBucket(key, bi);  //dataIdx

        if(di == -1){
            return null;
        }
        else{
            LinkedList<HMNode> temp = buckets[bi];
            HMNode curr = temp.get(di);
            return curr.value;
        }
    }

    // CONTAINS-KEY
    public boolean containsKey(K key) {
        int bi = findBucketIdx(key);            //bucketIdx
        int di = findDataIdxInBucket(key, bi);  //dataIdx

        if(di == -1){
            return false;
        }
        else{
            return true;
        }
    }


    // REMOVE
    public V remove(K key) throws Exception {
        int bi = findBucketIdx(key);            //bucketIdx
        int di = findDataIdxInBucket(key, bi);  //dataIdx

        if(di == -1){
            //key is not present in HashMap
            return null;
        }
        else{
            //key is present in HashMap
            LinkedList<HMNode> temp = buckets[bi];
            HMNode curr = temp.get(di);
            V val = curr.value;
            temp.remove(di);
            size--;

            return val;
        }

    }


    // KEY-SET
    public ArrayList<K> keyset() throws Exception {
        ArrayList<K> ks = new ArrayList<>();

        for(int bi = 0; bi<buckets.length; bi++){
            for(int p = 0; p<buckets[bi].size(); p++){
              HMNode curr = buckets[bi].get(p);
              ks.add(curr.key);
            }
        }

        return ks;
    
    }

    // SIZE 
    public int size() {
      return this.size;
    }

   public void display() {
      System.out.println("Display Begins");
      for (int bi = 0; bi < buckets.length; bi++) {
        System.out.print("Bucket" + bi + " ");
        for (HMNode node : buckets[bi]) {
          System.out.print( node.key + "@" + node.value + " ");
        }
        System.out.println(".");
      }
      System.out.println("Display Ends");
  }
}

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    HashMap<String, Integer> map = new HashMap();

    String str = br.readLine();
    while (str.equals("quit") == false) {
      if (str.startsWith("put")) {
        String[] parts = str.split(" ");
        String key = parts[1];
        Integer val = Integer.parseInt(parts[2]);
        map.put(key, val);
      } else if (str.startsWith("get")) {
        String[] parts = str.split(" ");
        String key = parts[1];
        System.out.println(map.get(key));
      } else if (str.startsWith("containsKey")) {
        String[] parts = str.split(" ");
        String key = parts[1];
        System.out.println(map.containsKey(key));
      } else if (str.startsWith("remove")) {
        String[] parts = str.split(" ");
        String key = parts[1];
        System.out.println(map.remove(key));
      } else if (str.startsWith("size")) {
        System.out.println(map.size());
      } else if (str.startsWith("keyset")) {
        System.out.println(map.keyset());
      } else if (str.startsWith("display")) {
        map.display();
      }
      str = br.readLine();
    }
  }
}
