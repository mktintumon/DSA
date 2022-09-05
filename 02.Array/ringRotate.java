
import java.util.Scanner;

public class ringRotate {
    public static Scanner sc = new Scanner(System.in);

    /* PROCESS
       1-> define size of 1d array
       2-> 2d to 1d conversion(int)
       3-> rotate 1d array(void)
       4-> 1d to 2d conversion(void)
       5-> function ringrotate (here catch the 1d array and  rotate and 1d to 2d method)
    */
    
    public static void takeInput(int[][] arr){
        for(int i=0 ;i<arr.length ; i++){
            for(int j=0 ; j<arr[0].length ; j++){
                arr[i][j] = sc.nextInt();
            }
        }
    }

    public static void display(int[][] arr){
        for(int i=0 ; i<arr.length ; i++){
            for(int j=0 ; j<arr[0].length ; j++){
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static int[] twoDto1D(int[][] arr , int s){
           int n = arr.length;
           int m = arr[0].length;
           
           // lets say for shell=2
           int minR = s-1; 
           int minC = s-1;
           int maxR = n-s;
           int maxC = m-s;

           int size = 2*(maxR-minR + maxC-minC);

           int[] oneD = new int[size];
           int idx = 0;

           for(int i=minR ; i<=maxR ; i++){
               oneD[idx] = arr[i][minC];
               idx++;
           }
           minC++;

           for(int j=minC ; j<=maxC ; j++){
               oneD[idx] = arr[maxR][j];
               idx++;
           }
           maxR--;

           for(int i=maxR ; i>=minR ; i--){
               oneD[idx] = arr[i][maxC];
               idx++;
           }
           maxC--;

           for(int j=maxC ; j>=minC ; j--){
               oneD[idx] = arr[minR][j];
               idx++;
           }
           minR++;

           return oneD;
    }

    public static void reverse(int[] arr, int i , int j){

        while(i<=j){
            int temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;
            i++;
            j--;
        }
   }

    public static void rotate(int[] arr , int k){
       int n = arr.length;
       k = k%n;

       if(k<0){
           k = k + n; 
       }
       reverse(arr, 0 , n-k-1);
       reverse(arr , n-k , n-1);
       reverse(arr , 0 , n-1);
   }

    public static void oneDto2D(int[] oneD , int[][] arr , int s){
        int n = arr.length;
        int m = arr[0].length;

        int minR = s-1;
        int minC = s-1;
        int maxR = n-s;
        int maxC = m-s;

        int index = 0;
        for(int i = minR; i<=maxR; i++){
            arr[i][minC] = oneD[index];
             index++;
         }
         minC++;
 
         for(int i=minC ; i<=maxC ;i++){ //wall B
             arr[maxR][i] = oneD[index];
             index++; 
         }
         maxR--;
 
         for(int i=maxR ; i>=minR ;i--){ //wall C
             arr[i][maxC] = oneD[index];
             index++; 
         }
         maxC--;
        
         for(int i=maxC ; i>=minC ;i--){ //wall D
             arr[minR][i] = oneD[index];
             index++; 
         }
         minR++;
    }

    public static void ringRotateofArray(int[][] arr , int s , int r) {
        int[] oneD = twoDto1D(arr, s);

        rotate(oneD ,r);
        oneDto2D(oneD , arr , s);
    }

    

    public static void main(String[] args) {
        int n = sc.nextInt(); 
        int m = sc.nextInt();
        int[][] arr = new int[n][m];   
        takeInput(arr);

        int s = sc.nextInt();
        int r = sc.nextInt();

        ringRotateofArray(arr, s, r);
        display(arr);

    }
}
