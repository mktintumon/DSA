import java.util.*;

public class selectionSort {

  public static void selection_Sort(int[] arr) {
    int n = arr.length;

    for(int i=0 ; i<n-1 ; i++){
        int minEleIdx = i;
        
        for(int j=i+1 ; j<n ; j++){
            if( isSmaller(arr , j , minEleIdx) == true ){
              minEleIdx = j;
            }
        }

        swap(arr , i , minEleIdx);
    }
  }

  // used for swapping ith and jth elements of array
  public static void swap(int[] arr, int i, int j) {
    System.out.println("Swapping " + arr[i] + " and " + arr[j]);
    int temp = arr[i];
    arr[i] = arr[j];
    arr[j] = temp;
  }

  // return true if ith element is smaller than jth element
  public static boolean isSmaller(int[] arr, int i, int j) {
    System.out.println("Comparing " + arr[i] + " and " + arr[j]);
    if (arr[i] < arr[j]) {
      return true;
    } else {
      return false;
    }
  }

  public static void print(int[] arr) {
    for (int i = 0; i < arr.length; i++) {
      System.out.println(arr[i]);
    }
  }

  public static void main(String[] args) throws Exception {
    Scanner scn = new Scanner(System.in);
    int n = scn.nextInt();
    int[] arr = new int[n];
    for (int i = 0; i < n; i++) {
      arr[i] = scn.nextInt();
    }
    selection_Sort(arr);
    print(arr);
    scn.close();
  }

}