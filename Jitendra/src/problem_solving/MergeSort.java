package problem_solving;

import java.util.Arrays;

public class MergeSort {

	public void sort(int[] arr) {
		int[] helperArray = new int[arr.length];
		mergeSort(arr, helperArray, 0, arr.length - 1);
	 System.out.println("Sorted \t "+Arrays.toString(arr));
		
	}

	public void mergeSort(int[] arr, int[] helper, int low, int high) {
		if (low < high) {
			int mid = (low + high) / 2;
			mergeSort(arr, helper, low, mid);
			mergeSort(arr, helper, mid + 1, high);
			merge(arr, helper, low, mid, high);
			//System.out.println(item);
		}
	}

	public void merge(int[] arr, int[] helper, int beg, int mid, int last) {
		for (int i = beg; i < arr.length; i++) {
			helper[i] = arr[i];
		}
		int hLeft = beg;
		int current = beg;
		int hRight = mid + 1;
		while (hLeft <= mid && hRight<= last) {
			if (helper[hLeft] < helper[hRight]) {
				arr[current] = helper[hLeft];
				hLeft++;
			} else {
				arr[current] = helper[hRight];
				hRight++;
			}
			current++;
		}
		int rem = mid - hLeft;
		for (int i = 0; i <= rem; i++)
			arr[current + i] = helper[hLeft + i];
		
	}

	public static void main(String[] args) {
       int[]test = {1,24,5,6,77,8,0,-2};
         System.out.println(Arrays.toString(test));
        MergeSort  s = new MergeSort();
        s.sort(test);
	}
}
