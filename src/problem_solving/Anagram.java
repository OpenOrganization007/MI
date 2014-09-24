package problem_solving;

import java.util.Arrays;

public class Anagram {
	private static String sort(String s){
		char[]arr = s.toCharArray();
		Arrays.sort(arr);
		return new String(arr);
	}
	public static boolean isAnagram(String s1,String s2){
		if(s1.length() != s2.length()){
			return false;
		}
		return sort(s1).equals(sort(s2));
	}
	public static void main(String[]args){
		System.out.println(isAnagram("dog", "god"));
		
	}

}
