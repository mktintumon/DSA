import java.util.Scanner;

public class squareRoot  { 

    public static double square_Root(int num){    
        double temp;  
        double sqrtroot = num/2;  

        do{  
            temp = sqrtroot;  
            sqrtroot = (temp+(num/temp))/2;  
        }   
        while((temp-sqrtroot)!= 0); 

        return sqrtroot;  
    }  

 
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in); 
        System.out.println("Enter a number: ");  
        int n = sc.nextInt();  
        System.out.println("The square root of "+ n + " is: " + square_Root(n));
        sc.close();  
    }       
} 


// private static double sqrt(double X) {
//     for (int i = 1; i < X; ++i) {
//         int p = i * i;
//         if (p == X) {
//             // perfect square
//             return i;
//         }
//         if (p > X) {
//             // found left part of decimal
//             return sqrt(X, i - 1, i);
//         }
//     }
//     return Double.NaN;
// }


// private static double sqrt(double X, double low, double high) {
//     double mid = (low + high) / 2;
//     double p = mid * mid;
    
//     // System.out.println(low + " " + high + " " + mid + " " + p);

//     if (p == X || (Math.abs(X - p) < PRECISION)) {
//         return mid;
//     }
//     if (p < X) {
//         return sqrt(X, mid, high);
//     }
//     return sqrt(X, low, mid);
// }
