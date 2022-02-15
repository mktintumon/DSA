import java.util.*;

public class highestFreq {

    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        String str = sc.next();

        HashMap<Character,Integer> hm = new HashMap<>();

        for(int i=0 ; i<str.length() ; i++){
            char ch = str.charAt(i);
            // if(hm.containsKey(ch)){
            //     int val = hm.get(ch);
            //     hm.put(ch,val+1);
            // }
            // else{
            //     hm.put(ch,1);
            // }

            hm.put(ch , hm.getOrDefault(ch, 0) + 1);

        }

        char maxFreq = str.charAt(0);
        for(Character key : hm.keySet()){
            if(hm.get(key) > hm.get(maxFreq)){
                maxFreq = key;
            }
        }

        System.out.println(maxFreq);
        sc.close();
    }

}