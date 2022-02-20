import java.util.*;

public class pattern11{
    public static Scanner sc = new Scanner(System.in);

    /*
            1
            2       3
            4       5       6
            7       8       9       10
            11      12      13      14      15 
    
        
    */

    public static void main(String[] args) {
        int n = sc.nextInt();
        
        int nst = 1 ;
        int count = 1;

        for(int r=1 ; r<=n ; r++ ){
            for(int cst=1 ; cst<=nst ; cst++){
                System.out.print(count + "\t");
                count++;
            }
            nst++;
        System.out.println();
        }
    }
}
    


