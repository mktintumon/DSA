import java.util.*;

public class pattern8 {
    public static Scanner sc = new Scanner(System.in);

    /*
                                                      *
                                            *
                                    *
                            *
                    *
            *
               
            
        
    */

    public static void main(String[] args) {
        int n = sc.nextInt();

        for(int r=1 ; r<=n ; r++){
            for(int c=1 ; c<=n ; c++){
                if(r+c == n+1){
                    System.out.print("*\t");
                }
                else{
                    System.out.print("\t");
                }
            }
            System.out.println();
        }
    }
    
}