package DSA.Recursion;
import java.util.Scanner;

public class stairpathWayUp {
    public static Scanner sc = new Scanner(System.in);

    public static void stairPath(int n , String path){
        if(n == 0){
            System.out.println(path);
            return;
        }

        for(int step=1 ; step<=3 ; step++){
            if(n-step>=0){
                stairPath(n-step, path+step);
            }
        }
    }

    public static void main(String[] args) {
        int n = sc.nextInt();
        stairPath(n,"");
    }
}
