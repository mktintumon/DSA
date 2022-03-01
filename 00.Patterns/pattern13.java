import java.util.*;

public class pattern13 {

    /*  print ncr , where n=row  and and r=0,1,2 ... 
    
        1
        1       1
        1       2       1
        1       3       3       1
        1       4       6       4       1
        
    */

   
    public static void print13(int rows) {
    for (int n = 0; n <rows; n++) {
        int val = 1;
        for (int r = 0; r <= n; r++) {
            // System.out.print(n + "C" + r + "\t");
            System.out.print(val + "\t");
            val = ((n - r) * val) / (r + 1);
        }

        System.out.println();
        }
    }

     public static void main(String[] args) {

        Scanner scn = new Scanner(System.in);

        int rows = scn.nextInt();

        print13(rows);

        scn.close();
        
        }

    }