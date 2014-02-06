package problem_solving;

public class ReverseString {
	
	public static String getReverse(String str){
		char[]arr = str.toCharArray();
		int beg =0;
		int end = arr.length-1;
		int mid = (beg + end)/2;
      while(beg <= mid && end > mid ){
    	  char temp = arr[beg];
    	  arr[beg] = arr[end];
    	  arr[end] = temp;
    	  beg++;
    	  end--;
      }
      
      return new String(arr);
		
	}

	public static void main(String[] args) {
		System.out.println(getReverse(" mahi"));

	}

}
