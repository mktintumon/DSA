package DSA.Recursion;
import java.util.Scanner;

public class mazepathJumpWayUp{
    public static Scanner sc = new Scanner(System.in);

    //make global scope for not using for loop each for h , v , d 

    static int[][] dir = {{0,1} , {1,0} , {1,1}}; // for direction 
    static String[] dirN = {"h" , "v" , "d"};     // name for each direction

    //solve with new method , helps in level 2 
    public static void mazePathJump(int sr ,int sc , int dr , int dc , String path){
        if(sr == dr && sc==dc){
              System.out.println(path);
              return;
        }

        for(int d=0 ; d<dir.length ; d++){ // loop for h,v and d

            for(int jump=1 ; jump<=Math.max(dr,dc) ; jump++){
                 
                int row = sr + (jump*dir[d][0]);
                int col = sc + (jump*dir[d][1]);

                if(row>=0 && col>=0 && row<=dr && col<=dc){
                    mazePathJump(row , col , dr, dc, path + dirN[d] + jump);
                }
            }
        }

    }                                                                                                                                                                                                                                                                      


    public static void main(String[] args) {
        int n = sc.nextInt();
        int m = sc.nextInt();

        mazePathJump(0 , 0 , n-1 , m-1 , "");
    }
}