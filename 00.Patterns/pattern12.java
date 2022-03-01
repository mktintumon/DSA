import java.util.*;

public class pattern12{
    public static Scanner sc = new Scanner(System.in);

    /*   fibonacci
     
    0
    1       1
    2       3       5
    8       13      21      34
    55      89      144     233     377
    
        
    */

    public static void main(String[] args) {
        int n = sc.nextInt();
        
        int nst = 1 ;
        int a = 0;
        int b = 1;
        

        for(int r=1 ; r<=n ; r++ ){
            for(int cst=1 ; cst<=nst ; cst++){
                System.out.print(a + "\t");
                int c = a+b;
                a = b ;
                b = c;

            }
            nst++;
        System.out.println();
        }
    }
}
    



