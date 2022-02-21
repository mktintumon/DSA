import java.util.*;

public class pattern15 {
    public static Scanner sc = new Scanner(System.in);

    /*
    
                            1
                    2       3       2
            3       4       5       4       3
                    2       3       2
                            1
            
    
    */

    public static void main(String[] args) {
        int n = sc.nextInt();
        if(n%2 == 0) n++;

        int nst = 1 , nsp = n/2 ;

        for(int r=1 ; r<=n ; r++){
            for(int csp=1 ; csp<=nsp ; csp++){
                System.out.print("\t");
            }

            // learn .....not intuitive
            int count = r <= (n/2 +1) ? r : (n-r+1);

            for(int cst=1 ; cst<= nst ; cst++ ){
                System.out.print(count + "\t");
                // this is intuitive
                count = (cst <= nst/2) ? count+1 : count-1;
            }

            if(r<=n/2){
                nst+=2;
                nsp--;
            }
            else{
                nsp++;
                nst-=2;
            }
            System.out.println();
    
        }
    }


}