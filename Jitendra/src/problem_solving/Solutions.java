package problem_solving;

import java.util.Scanner;

public class Solutions {
    
    public static void insertionSort(int[] ar){
    	boolean sift = false;
        for(int i = 1; i<ar.length;i++){
           int j = i-1;
            while(j>0 && ar[i] < ar[j]){
                int temp = ar[i];
                ar[i] = ar[j];
                ar[j] = temp;
                i--;
                j--;
                sift = true;
            }
            if(sift)
            printArray(ar);
            sift = false;
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
      //  Scanner in = new Scanner(System.in);
        //int n = in.nextInt();
        int[] ar = {1 ,4 ,3 ,5 ,6 ,2};
      
        insertionSort(ar);
    }    
}