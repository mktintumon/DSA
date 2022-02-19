import java.util.*;

public class pattern6 {
    public static Scanner sc = new Scanner(System.in);

    /*
     
        *       *       *       *               *       *       *       *
        *       *       *                               *       *       *
        *       *                                               *       *
        *                                                               *
        *       *                                               *       *
        *       *       *                               *       *       *
        *       *       *       *               *       *       *       *
       
        
    */

    public static void main(String[] args) {
        int n = sc.nextInt();

        if(n%2 == 0) n++;

        int nst = n/2 + 1;
        int nsp = 1;

        for(int r=1 ; r<=n ; r++){

            for(int cst=1 ; cst<=nst ; cst++){
                System.out.print("*\t");
            }

            for(int csp=1 ; csp<=nsp ; csp++){
                System.out.print("\t");
            }

            for(int cst=1 ; cst<=nst ; cst++){
                System.out.print("*\t");
            }

            if(r < (n+1)/2){
                nst -= 1;
                nsp += 2;
            }
            else{
                nsp -= 2;
                nst += 1;
            }
            System.out.println();
        }

    }
    
}


