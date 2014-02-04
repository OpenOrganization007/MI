package sort;

import java.util.Arrays;

public class InsertionSort {
	
	public static void sort(int[]arr){
		for(int i = 1; i<arr.length ; i++){
			int j = i-1;
			while( j >=0 && arr[j] > arr[i]){
				int temp = arr[i];
				arr[i] = arr[j];
				arr[j] = temp;
				j--;
				i--;
			}
		}
		System.out.println(Arrays.toString(arr));
	}

	public static void main(String[] args) {
	 int[] test ={5,2,4,6,1,3};
	 sort(test);

	}

}
