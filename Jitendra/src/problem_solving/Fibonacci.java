package problem_solving;

import java.util.Scanner;

public class Fibonacci {
	 int[] arr ;
	 public Fibonacci(){
		 arr = new int[1000];
	 }
	 
	 public int fibo(int n){
		 if(n== 0) return 0;
		 if(n==1) return 1;
		 if(arr[n] != 0)
			 return arr[n];
		 arr[n] = fibo(n-1)+fibo(n-2);
		 return arr[n];
	 }
	
   public void display(){
	   for(int i : arr){
		   System.out.println(arr[i]);
	   }
   }
	
	

	public static void main(StringQn[] args) {
      Scanner sc = new Scanner(System.in);
      Fibonacci  fb = new Fibonacci();
      System.out.println("Enter no for fibo");
      System.out.println(fb.fibo(sc.nextInt()));
//      fb.display();
      System.out.println("Integer max value" +Integer.MIN_VALUE);
	}

}
