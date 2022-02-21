import java.util.*;

public class pattern16 {
    public static Scanner sc = new Scanner(System.in);

    /*
    
    1                                                               1
    1       2                                               2       1
    1       2       3                               3       2       1
    1       2       3       4               4       3       2       1
    1       2       3       4       5       4       3       2       1
      
    
    */

    public static void main(String[] args) {
        int n = sc.nextInt();
    
        int nst = 1 , nsp  = 2*n-3;

        for(int r=1 ; r<=n ; r++){
            int count = 1;
            for(int cst=1 ; cst<=nst ; cst++){
                System.out.print(count + "\t");
                count++;
            }

            for(int csp=1 ; csp<=nsp ; csp++){
                System.out.print("\t");
            }

            if (r == n) {
                nst--;
                count--;
            }
            
            for(int cst=1 ; cst<=nst ; cst++){
                count--;
                System.out.print(count + "\t");
                
            }
            
                
            nst += 1;
            nsp -= 2;
            System.out.println();
            
        }
    
        
    }


}