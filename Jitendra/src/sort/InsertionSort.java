package sort;

import java.util.Arrays;

public class InsertionSort {
	public static void sort(int[] arr){
		for(int i =1 ;i<arr.length;i++){
			int key = arr[i];
			int j = i-1;
			while(j >=0 && arr[j] > key){
				arr[j+1] = arr[j];
				j--;
				System.out.println(Arrays.toString(arr));
				arr[j+1] = key;
			}
		}
		System.out.println(Arrays.toString(arr));
	}

	public static void main(String[] args) {
     int[]arr= {2,4,6,8,3};
     sort(arr);
	}

}
