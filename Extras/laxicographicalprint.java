import java.util.*;

/*
Input:
20
output
1 10 11 12 13 14 15 16 17 18 19 2 3 4 5 6 7 8 9
*/

public class laxicographicalprint {
    public static Scanner sc = new Scanner(System.in);

    public static void print(int i , int n){
        if(i>= n ){
           return;
        }

        System.out.println(i); // printing all output from here

        for(int j=0 ; j<=9 ; j++){
            print(10*i + j , n);
        }
    }

    public static void main(String[] args) {
        int n = sc.nextInt();
        for(int i=1 ; i<=9 ; i++ ){
            print(i,n);
        }
    }
}
