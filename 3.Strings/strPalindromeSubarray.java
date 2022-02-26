import java.util.Scanner;

public class strPalindromeSubarray {
    public static Scanner sc = new Scanner(System.in);
   
    public static boolean isPalindrome(String str){
        int n = str.length();
         int i=0;
         int j=n-1;

         while(i<=j){
             char ch1 = str.charAt(i);
             char ch2 = str.charAt(j);

             if(ch1!=ch2){
                 return false;
             }
             i++;
             j--;
         }
         return true;
    }

    public static void palindromesubarray(String str){
        int n= str.length();
        
        //subarray solution
        for(int start=0 ; start<n ; start++){
            for(int end=start ; end<n ; end++){

                String test = str.substring(start , end+1);

                if(isPalindrome(test)==true){
                    System.out.println(test);
                }
            }
        }
    }


    public static void main(String[] args) {
        String str = sc.next();
        
        palindromesubarray(str);
    }
}
