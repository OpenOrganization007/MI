package sorting;

public class MergeSort {
	
	public void mergeSort(int[] array){
		int[]helper = new int[array.length];
		mergeSort(array,helper,0,array.length-1);
		for(int i:array){
			System.out.println(i);
		}
		
	}
	private void mergeSort(int[]array,int[]helper,int low,int high){
		while(low < high){
			int mid = (low + high)/2;
			mergeSort(array,helper,low ,mid);
			mergeSort(array,helper ,mid+1,high);
			merge(array , helper ,low, mid,high);
		}
	
	}
	
	private void merge(int[]array,int[]helper,int low,int mid,int high){
//		System.arraycopy(array, 0, helper, low, array.length);
		for(int i = low; i<high ;i++){
			helper[i] = array[i];
		}
		int leftHelper = low;
		int rightHelper = mid+1;
		int current   = low;
		while(leftHelper <= mid && rightHelper <= high){
			if(helper[leftHelper] <= helper[rightHelper]){
				array[current] = helper[leftHelper];
				leftHelper++;
			}else{
				array[current] = helper[rightHelper];
				rightHelper++;
			}
			current++;
		}
		int rem = mid - leftHelper;
		for(int i = 0;i<rem; i++){
			array[current+i] = helper[leftHelper+i];
		}
	}

	public static void main(String[] args) {
        int[]test = {3,54,6,7,8,1,0};
        MergeSort sort = new MergeSort();
        sort.mergeSort(test);
	}

}
