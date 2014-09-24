package search;

public class StringSearch {

	public static int searchString(String[] strings, String str) {
		if (strings == null || str == "" || str == null) {
			return -1;
		} else {
			return search(strings, str, 0, strings.length - 1);
		}
	}

	private static int search(String[]arr, String str,int beg,int end){
		if(beg > end){
			return -1;
		}
		int mid = (beg + end)/2;
      if(arr[mid].isEmpty()){
    	  int left = mid -1;
    	  int right = mid +1;
    	  
    	  while(true){
    		  if(left < beg && right > end){
    		  return -1;
    		  }else if(right <= end && !arr[right].isEmpty()){
    			  mid = right;
    			  break;
    		  
    		  }else if(left >= beg && !arr[left].isEmpty()){
    			  mid = left;
    			  break;
    		  }
    	  right++;
    	  left--;
    	  }
      }
      if(arr[mid].equals(str)){
    	  return mid;
      }else if(arr[mid].compareTo(str) < 0){ // search right
    	  return search(arr,str,mid+1,end);
      }else{                                   // search left
    	  return search(arr,str,beg,mid-1);
      }

	}

	public static void main(String[] args) {
		char c=064770;
		System.out.println(c);
	/*	String[]test = {"hello","", "i", "am", "jitendra"};
		int index = searchString(test,"am");
		if(index > 0){
			System.out.println("item found in array");
		}else{
			System.out.println("item is not found in array");
		}*/

	}

}
