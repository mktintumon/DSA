

import java.util.Scanner;

public class primeTillN {
    public static Scanner sc = new Scanner(System.in);

    public static boolean prime(int n){
          for(int i=2 ; i*i < n ; i++){
              if(n%i == 0){
                 return false;
              }
          }
          return true;
    }

    public static void main(String[] args) {
        int n = sc.nextInt();
        int m = sc.nextInt();

        for(int i=n ; i<=m ; i++){
            if(prime(i)){
                System.out.println(i);
            }
        }

       
        
    }
}
