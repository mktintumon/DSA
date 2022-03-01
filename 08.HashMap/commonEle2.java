import java.util.*;

public class commonEle2{

public static void main(String[] args) throws Exception {
    //Decrease found element frequency concept
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


    //Process 1)make a hashMap 2)travel in b and print 3) decrease freq
    HashMap<Integer,Integer> hm = new HashMap<>();
    for(int ele : a){
        hm.put(ele , hm.getOrDefault(ele , 0) + 1);
    }

    for(int ele : b){
        if(hm.containsKey(ele) && hm.get(ele) > 0 ){
            System.out.println(ele);
        
        //int oldFreq = hm.get(ele);
        //int newFreq = hm.get(ele) - 1;
        hm.put(ele , hm.get(ele) - 1);
        }
    }
    sc.close();
 }

}
