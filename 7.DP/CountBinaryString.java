import java.util.*;

public class CountBinaryString{

    public static int countString(int n){
        int oldCountZero = 1;
        int oldCountOne = 1;

        for(int i=2 ; i<= n ; i++){
            int nCountZero = oldCountOne;
            int nCountOne  = oldCountOne + oldCountZero;

            oldCountZero = nCountZero; 
            oldCountOne  = nCountOne;
        }

        return (oldCountOne + oldCountZero);
    }

public static void main(String[] args) throws Exception {
    Scanner sc = new Scanner(System.in);
    int n = sc.nextInt();

    int ans = countString(n);
    System.out.println(ans);
    sc.close();
 }

}
