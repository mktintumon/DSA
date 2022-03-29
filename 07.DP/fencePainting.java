import java.util.*;

public class fencePainting {

    public static long fencePaint(int n , int k){
        long same = k;
        long diff = k*(k-1);
        long total = same + diff;

        for(int i=3 ; i<=n ; i++){
            same = diff*1;
            diff = total * (k-1);

            total = same + diff;
        }

        return total;
    }

    public static void main(String[] args) throws Exception {
           Scanner sc = new Scanner(System.in);

           int n = sc.nextInt();
           int k = sc.nextInt();

           long ans = fencePaint(n,k);
           System.out.println(ans);
           sc.close();
    }
}