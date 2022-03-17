import java.util.*;
public class lambdaExp{
	public static void main(String[] args) {
	   // int [] arr = {1,6,3,6,9,3,7};  -> 1D arr

		int [][] arr =  {{1,4},
		                 {5,7},
		                 {3,12},
		                 {18,20},
		                 {6,10}};
		              
		Arrays.sort(arr, (a,b)->{

            return a[0] - b[0];  
          //return a[1] - b[1];    -> return incresing wrt idx 1
          //return b[0] - a[0];    -> return decresing wrt idx 0
          //return b[1] - a[1];    -> return decresing wrt idx 1
          
        });

		for(int [] d : arr){
		        System.out.println(d[0] + " " + d[1]);
		}
		              
	    
	}
}