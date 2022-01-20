package DSA.basics;
import java.util.Scanner;

public class rotateNumber {
    public static Scanner sc = new Scanner(System.in);

    public static void reverse(int n){

        while(n!=0){
            int ans = n % 10;
            System.out.print(ans);
            n /= 10;
        }
        System.out.println();
    }

    public static int countOfNumber(int n){
        int count=0;
        while(n!=0){
            n=n/10;
            count++;
        }
        return count;
      }
  

    public static int rotate(int n,int k){ // n = 12345 , k =2 , res = 45123 
        int length = countOfNumber(n); 

        k = (k%length) % length; // learn
       
        int  a = n / (int)Math.pow(10,k); // 123
        int  b = n % ((int)Math.pow(10 ,k)); // 45

        return (b*(int)Math.pow(10,length-k) + a);

    }

    public static void main(String[] args) {
        int n = sc.nextInt();
        int k = sc.nextInt();

        System.out.println(rotate(n,k));

    }
    
}
