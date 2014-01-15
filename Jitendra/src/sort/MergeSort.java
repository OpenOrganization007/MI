package sort;

import java.util.Arrays;

public class MergeSort {
	
	public void sort(int[]arr){
		int[]helper = new int[arr.length];
		mergeSort(arr, helper, 0, arr.length-1);
		System.out.println(Arrays.toString(arr));
	}
	
	private void mergeSort(int[]arr,int[]helper,int beg,int end){
		if(beg < end){
			int mid = (beg+end)/2;
			mergeSort(arr,helper,beg,mid);
			mergeSort(arr,helper,mid+1,end);
			merge(arr,helper,beg,mid,end);
		}
		
	}
	private void merge(int[]arr,int[]helper,int beg,int mid,int end){
		for(int i=beg;i<=end;i++){
			helper[i] = arr[i];
		}
		int current = beg;
		int left = beg;
		int right = mid+1;
		while(left <= mid && right <= end){
			if(helper[left] <= helper[right]){
				arr[current] = helper[left];
				left++;
			}else{
				arr[current] = helper[right];
				right++;
			}
			current++;
		}
		int itemRemain = mid - left;
		for(int i=0;i <= itemRemain; i++){
			arr[current+i] = helper[left+i];
		}
		
		
	}
	

	public static void main(String[] args) {
		int[] test = {1,4,6,8,2};
		MergeSort ms = new MergeSort();
		ms.sort(test);

	}

}
