import java.util.*;

public class pattern18 {
    public static Scanner sc = new Scanner(System.in);

    /*
    
            *       *       *       *                       *
                                    *                       *
                                    *                       *
            *       *       *       *       *       *       *
            *                       *
            *                       *
            *                       *       *       *       *
        
    */

    public static void main(String[] args) {
        int n = sc.nextInt();
    
        if(n%2==0) n++;

        for(int r=1 ; r<=n ; r++){

            for(int cst=1 ; cst<=n ; cst++){

                if(r == 1){
                    if(cst == n || cst <= n/2+1){
                        System.out.print("*\t");
                    }
                    else{
                        System.out.print("\t");
                    }
                }
                else if(r <= n/2){

                    if(cst == n || cst == n/2+1){
                        System.out.print("*\t");
                    }
                    else{
                        System.out.print("\t");
                    }
                }
                else if(r == n/2 + 1){
                    System.out.print("*\t");
                }
                else if(r < n){
                    if(cst==1 || cst==n/2+1){
                        System.out.print("*\t");
                    }else{
                        System.out.print("\t");
                    } 
                }
                else{
                    if(cst==1 || cst>=n/2+1){
                        System.out.print("*\t");
                    }else{
                        System.out.print("\t");
                    }
                }
                

            }
            System.out.println();
        }
        
    }


}

