package problem_solving;

import java.util.Scanner;

public class Solution1 {
    
    static void insertionSort(int[] arr) {
    	int item = arr[arr.length-1];
        for(int i = arr.length-1;i >0 ; i--){
		int j = i-1;
		if(item < arr[j]){
			//shift element right one cell
			arr[i] = arr[j];
		}else{
			arr[i] = item;
		}
		printArray(arr);
	}
              
    }  

/* Tail starts here */

static void printArray(int[] ar) {
   for(int n: ar){
      System.out.print(n+" ");
   }
     System.out.println("");
}
 
public static void main(String[] args) {

     int[] ar = {1, 3, 5, 9, 13, 22, 27, 35, 46, 51, 55, 83, 87, 23};
    
     insertionSort(ar);
 }    
}