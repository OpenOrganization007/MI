package problem_solving;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

public class Anagram1 {
	
	public static void getAnagram(String[] arr){
	Map<String,String> map = new HashMap<String,String>();
	for(String s : arr){
		char[]ar = s.toCharArray();
		Arrays.sort(ar);
		String str = new String(ar);
		if( !map.containsKey(str)){
			map.put(str,s);
		}else{
		   String st = map.get(str);
		    st = st+","+s;
		   map.put(str, st);
		}
	}
	for(Entry<String, String> e:map.entrySet()){
		if(e.getKey().length() <  e.getValue().length())
		System.out.println("Anagram pairs ===> [" +e.getValue()+"]");
	}
	}
	public static void main(String[] args) {
		String test[] ={"algorithm","god","logarithm","dog","fuck","suck","ram","amr","mar"};
		getAnagram(test);

	}

}
