import java.util.*;

public class pattern1 {
    public static Scanner sc = new Scanner(System.in);

    /*

        *
        *       *
        *       *       *
        *       *       *       *
        *       *       *       *       *
    
    */

    public static void main(String[] args) {
        int n = sc.nextInt();

        int nst = 1;
        int nsp = 0;

        for(int r=1 ; r<=n ; r++){

            for(int csp=1 ; csp<=nsp ; csp++){
                System.out.print("\t");
            }

            for(int cst=1 ; cst<=nst ; cst++){
                System.out.print("*\t");
            }

            nst++;
            nsp += 0;
            System.out.println();
        }
    }
    
}
