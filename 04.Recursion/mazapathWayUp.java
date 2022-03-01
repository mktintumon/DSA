
import java.util.Scanner;

public class mazapathWayUp {
    public static Scanner sc = new Scanner(System.in);

    public static void mazePath(int sr , int sc , int dr , int dc , String path){
            if(sr == dr && sc == dc ){
                System.out.println(path);
                return;
            }

            if( sr>dr || sc > dc){
                return;  //no need to use if before calling the function, handle here only
            }

            mazePath(sr, sc+1, dr, dc, path+"h");
            mazePath(sr+1, sc, dr, dc, path+"v");
    }

    public static void main(String[] args) {
        int n = sc.nextInt();
        int m = sc.nextInt();

        mazePath(0 , 0 , n-1 , m-1 ,"");
    }
}
