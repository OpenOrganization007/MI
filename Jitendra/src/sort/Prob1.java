package sort;

import java.util.Arrays;

public class Prob1 {
	
	public static void merge(int[]a,int[]b,int lastA,int lastB){
		int indexA = lastA-1;
		int indexB = lastB-1;
		int indexMerge = indexA+indexB;
		while(indexMerge >=0 && indexB >=0){
			if(a[indexA] >= b[indexB]){
				a[indexMerge] = a[indexA];
				indexMerge--;
				indexA--;
			}else{
				a[indexMerge] = b[indexB];
				indexMerge--;
				indexB--;
			}
		}
		while(indexB >= 0){
			a[indexMerge] = b[indexB];
			indexMerge--;
			indexB--;;
		}
		
		System.out.println(Arrays.toString(a));
		
	}

	public static void main(String[] args) {
		int[]a = new int[]{1,2,3,4,9,22,0,0,0,0,0,0,0};
		//int[]b={9,12,13,14,17,20,22};
		int[]b ={6,7,10,12,15};
		
		merge(a,b,6,5);

	}

}
