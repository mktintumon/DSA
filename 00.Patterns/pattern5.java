import java.util.*;

public class pattern5 {
    public static Scanner sc = new Scanner(System.in);

    /*
         
                        *
                *       *       *
        *       *       *       *       *
                *       *       *
                        *
        
    */

    public static void main(String[] args) {
        int n = sc.nextInt();

        if(n%2 == 0) n++;

        int nst = 1;
        int nsp = n/2;

        for(int r=1 ; r<=n ; r++){
            for(int csp=1 ; csp<=nsp ; csp++){
                System.out.print("\t");
            }

            for(int cst=1 ; cst<=nst ; cst++){
                System.out.print("*\t");
            }

            if(r < (n+1)/2){
                nst += 2;
                nsp -= 1;
            }
            else{
                nsp++;
                nst-=2;
            }
            System.out.println();
        }

    }
    
}

