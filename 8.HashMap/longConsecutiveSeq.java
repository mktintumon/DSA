import java.util.*;

public class longConsecutiveSeq{

    /*
    PROCESS :
    1.create hm with <Integer , Boolean>  (true)
    2.find potential starting point by checking n-1 avilability and turn into false
    3.make loop over remaining true value and initiate (maxL and StartingPoint) as 0
    
    */ 

public static void main(String[] args) throws Exception {
    Scanner sc = new Scanner(System.in);
    int n = sc.nextInt();
    int[] arr = new int[n];
    for(int i=0 ; i<n ; i++){
        arr[i] = sc.nextInt();
    }
    
    // 1
    HashMap<Integer , Boolean> hm = new HashMap<>();
    for(int ele : arr){
        hm.put(ele , true);
    }

    // 2
    for(int i=0 ; i<n ; i++){
        if( hm.containsKey(arr[i]-1) ){
            hm.put(arr[i] , false);
        }
    }

    // 3
    int maxLen = 0;
    int maxStrPt = 0;
    for(int ele : arr){
        if(hm.get(ele) == true){
            int tempLen = 1;
            int tempStrPt = ele;
        

        while(hm.containsKey(tempLen + tempStrPt)){
            tempLen++;
        }

        if(tempLen > maxLen){
            maxLen = tempLen;
            maxStrPt = tempStrPt;
        }
    }
    }

    for(int i=maxStrPt ; i<(maxStrPt+maxLen) ; i++){
        System.out.println(i);
    }

    sc.close();
 }

}