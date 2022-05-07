

import java.util.Scanner;

public class fabonacci {
    public static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {  // 0 1 1 2 3 5 8 13 21 34 55 
        int n = sc.nextInt();

        int a = 0;
        int b =1;

        System.out.println(a);
        System.out.println(b);

        for(int i=2 ; i<=n ; i++){
            int 
            c= a+b;
            System.out.println(c);
            a=b;
            b=c;
        }

    }
}
