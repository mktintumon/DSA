import java.util.*;

public class pattern10{
    public static Scanner sc = new Scanner(System.in);

    /*
     
                            *
                    *               *
            *                               *
    *                                               *
            *                               *
                    *               *
                            *
                    
        
    */

    public static void main(String[] args) {
        int n = sc.nextInt();
        if(n%2 == 0) n++;
        
        // we print stars manually so taking formula of only outer and inner space 
        int outSp = n/2;
        int inSp = -1;
        
        for(int r=1 ; r<=n ; r++){

            for(int csp=1 ; csp<=outSp ; csp++){
                System.out.print("\t");
            }

            System.out.print("*\t");

            for(int csp=1 ; csp<=inSp ; csp++){
                System.out.print("\t");
            }
            
            // without this condition we get only left half
            if(r>1 && r<n){
                System.out.print("*\t");
            }


            if(r<=n/2){
                outSp--;
                inSp+=2;
            }
            else{
                inSp-=2;
                outSp++;
            }
            System.out.println();

        }
    }
    
}

