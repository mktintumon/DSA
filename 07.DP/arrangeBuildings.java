import java.util.*;

public class arrangeBuildings{
    //same as count binary string 

    public static int arrangeBuild(int n){

        int oldBuilding = 1;
        int oldSpace = 1;

        for(int i=2 ; i<=n ; i++){
             int nBuilding = oldSpace;
             int nSpace = oldSpace + oldBuilding ;

             oldBuilding = nBuilding;
             oldSpace =  nSpace;

        }

        int total = oldBuilding + oldSpace;
        return total; 
    }

public static void main(String[] args) throws Exception {
      Scanner sc = new Scanner(System.in);

      int n = sc.nextInt();
      long ans = arrangeBuild(n); // ans cant store in int , so change to long
      System.out.println(ans*ans);
      sc.close();
 }

}