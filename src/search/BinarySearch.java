package search;

public class BinarySearch {
	
	public static  int search(int[]arr,int item){
		int low = 0;
		int high = arr.length-1;
		int indexLocation =0;
		while(low < high){
			int mid = (low+high)/2;
			if(arr[mid] > item){
				high = mid;
			}
			if(arr[mid] < item){
				low = mid+1;
			}
			if(arr[mid] == item){
				indexLocation = mid;
				break;
			}
		}
		return indexLocation;
	}

	public static void main(String[] args) {

		int[]test = {3,4,5,6,7,8,12,34};
		int index = search(test,8);
		if(index > 0)
		System.out.println("item found at location :\t"+ index);
		else 
			System.out.println("item not found in array");
		
	}

}
