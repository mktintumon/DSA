import java.util.*;

public class commonEle1{

public static void main(String[] args) throws Exception {
    //REMOVE concept

    Scanner sc = new Scanner(System.in);
    int n = sc.nextInt();
    int[] a = new int[n];
    for(int i=0 ; i<n ; i++){
        a[i] = sc.nextInt();
    }

    int m = sc.nextInt();
    int[] b = new int[m];
    for(int i=0 ; i<m ; i++){
        b[i] = sc.nextInt();
    }

    //process -> 1) Make aHashMap  2)Travel in b and print  3)remove found element
    
    HashMap<Integer,Integer> hm = new HashMap<>();
    for(int ele : a){
        hm.put(ele , hm.getOrDefault(ele , 0) + 1);
    }

    for(int ele : b){
        if(hm.containsKey(ele)){
            System.out.println(ele);
        }

        hm.remove(ele);
    }
    sc.close();
 }

}