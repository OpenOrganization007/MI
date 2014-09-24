package problem_solving;

public class Permutation {
	
	private static boolean isPermutaion(String s1,String s2){
		if(s1.length() != s2.length()){
			return false;
		}
		int[]letters = new int[256];
		char[]arr = s1.toCharArray();
		for(char c: arr){
			letters[c]++;
		}
		for(int i=0; i<s2.length();i++){
			int index = (int)s2.charAt(i);
			if(--letters[index] < 0){
				return false;
			}
		}
		return true;
	}

	public static void main(String[] args) {
		
		System.out.println(isPermutaion("dog", "god"));

	}

}
