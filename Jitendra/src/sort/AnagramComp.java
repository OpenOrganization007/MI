package sort;

import java.util.Arrays;
import java.util.Comparator;

public class AnagramComp implements Comparator<String> {
	
	public static String sortChars(String s){
		char[]ch = s.toCharArray();
		Arrays.sort(ch);
		return new String(ch);
	}


	@Override
	public int compare(String o1, String o2) {
		return sortChars(o1).compareTo(sortChars(o2));
	}
	public static void main(String[] args) {
		String[] test ={"jitendra","tendraji"};
		AnagramComp comp = new AnagramComp();
		for(String s : test){
			System.out.println(comp.sortChars(s));
		}
	}

}
