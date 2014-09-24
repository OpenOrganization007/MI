package sort;

import java.util.Arrays;

public class QuickSort {
	
	public void sort(int[]arr){
		int left = 0;
		int right = arr.length-1;
		quickSort(arr,left,right);
		System.out.println(Arrays.toString(arr));
	}
	private void quickSort(int[]arr,int left,int right){
		int index = partition(arr,left,right);
		if(left < index-1){
			quickSort(arr,left,index-1);
		}
		if(index < right){
			quickSort(arr,index,right);
		}
	}
	private int partition(int[]arr, int left,int right){
		int pivot = arr[(left+right)/2];
		while(left <= right){
			/*
			 * search for smallest element from left of pivot element
			 */
			while(arr[left] < pivot){
				left++;
			}
			
			while(arr[right] > pivot){
				right--;
			}
			
			if(left <= right){
				swap(arr,left,right);
				left++;
				right--;
			}
		}
		return left;
	}
	private void swap(int[]arr,int left,int right){
		int temp = arr[left];
		arr[left] = arr[right];
		arr[right] = temp;
	}

	public static void main(String[] args) {
     int[]test = {1,3,5,65,7,7,8,0,-4};
     QuickSort qs = new QuickSort();
     qs.sort(test);
	}

}
