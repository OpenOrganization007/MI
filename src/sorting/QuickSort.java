package sorting;

public class QuickSort {
	private int[]array;
	private int low;
	private int high;
	
	public QuickSort(int[]array,int low,int high ){
		this.array = array;
		this.low = low;
		this.high = high-1;
	}
	
	public void quickSort(){
		quickSort(array,low,high);
	}
	private void quickSort(int[]array,int low,int high){
		int index = partion(array,low,high);
		if(low <= index){
			quickSort(array,low,index-1);
		}
		if(index < high){
			quickSort(array,index,high);
		}
	}
	
	private int partion(int[]array,int low,int high){
		int pivot = array[(low+high)/2];
		/*
		 * move element to right side who deserve
		 */
		while(array[low] < pivot){
			low++;
		}
		/*
		 * move element to left side who deserve
		 */
		while(pivot < array[high]){
			high--;
		}
		if(low <= high){
			swap(array,low,high);
			low++;
			high--;
		}
		return low;
	}
	
	private void swap(int[] array,int low,int high){
		int temp = array[low];
		array[low] = array[high];
		array[high] = temp;
	}
	
	public void print(){
		for(int i:array){
			System.out.print(i +",");
		}
	}
	
	public static void main(String[] args) {
        int[]test = {3,54,6,7,8,1,0};
        QuickSort sort = new QuickSort(test,0,test.length);
        sort.quickSort();sort.print();
//        sort.mergeSort(test);
	}


}
