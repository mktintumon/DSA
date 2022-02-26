import java.util.Scanner;

public class strCompression {
     public static Scanner sc = new Scanner (System.in);
    
     public static void compression1(String str){
         int n = str.length();
          
         System.out.print(str.charAt(0));

         for(int i=1 ; i<n ;i++){
         char current = str.charAt(i);
         char previous = str.charAt(i-1);

         if(current != previous){
             System.out.print(current);
         }
         }
         System.out.println();
     }

     public static String compression2(String str){
		String ans =  str.charAt(0) + "";
		int count = 1;
		
		for(int i = 1; i<str.length(); i++){
		    char curr = str.charAt(i);
		    char prev = str.charAt(i-1);
		    
		    if(curr == prev){
		        count++;
		    }
		    else{
		        if(count > 1){
		            ans += count;
		            count = 1;
		        }
		        ans += curr;
		    }
		}
		 if(count > 1)
		    ans += count;
		    
		return ans;
	}

     public static void main(String[] args) {
         String str = sc.next();

         compression1(str);
         System.out.println(compression2(str));
     }
}
