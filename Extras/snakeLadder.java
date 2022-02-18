import java.util.*;

/*
1. Take input n  and m (boardsize and dice faces)
a. Write a recursive function which returns the count of different ways the
board can be travelled using the dice. Print the value returned.

b. Write a recursive function which returns an ArrayList of dice values for all
valid paths across the board. Print the value returned.

c. Write a recursive function which prints dice-values for all valid paths across
the board (void is the return type for function).

OUTPUT:
16
[11111, 1112, 1121, 113, 1211, 122, 131, 14, 2111, 212, 221, 23, 311, 32, 41, 5]
11111
1112
1121
113
1211
122
131
14
2111
212
221
23
311
32
41
5
*/

public class snakeLadder {
    public static Scanner sc = new Scanner(System.in);

    public static int count(int n , int m){
        if(n == 0){
           return 1;
        }

        int count = 0;
        for(int i=1 ; i<=m ; i++){
            if(n-i >= 0 ){
                count += count(n-i , m);
                
            }
        }

        return count;
    }


    public static void pathPrint(int n , int m , String path){
        if(n == 0){
           System.out.println(path);
           return;
        }

        for(int i=1 ; i<= m ; i++){
            if(n-i >= 0){
                pathPrint(n-i , m , path+i);
            }
        }
    } 


    public static ArrayList<String> pathsInAL(int n , int m){
        if(n == 0){
            ArrayList<String> base = new ArrayList<>();
            base.add("");
            return base;
        }

        ArrayList<String> myAns = new ArrayList<>();

        for(int i=1 ; i<=n && i<=m ; i++){ //i<=m bcoz dice may be small
            ArrayList<String> recAns = pathsInAL(n-i, m);

            for(String ele : recAns){
                myAns.add(i + ele);
            }
        }

        return myAns;

    }

    public static void main(String[] args) {
        int n = sc.nextInt(); //board
        int m = sc.nextInt(); //dice
        
        // Q-1
        System.out.println(count(n,m));

        //Q-2
        System.out.println(pathsInAL(n,m));

        //Q-3
        pathPrint(n,m,"");

    }
}
