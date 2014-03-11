package problem_solving;
import java.util.*; 
import java.io.*;

public class Function {  
	String LongestWord(String sen) { 
		String str=	sen.replaceAll("[^a-zA-Z0-9]", "");
		char[] arr = str.toCharArray();
		ArrayList<String> list = new ArrayList<String>();
		for(int i =0 ;i< arr.length ;i++){
			if(arr[i] == ' '){
				StringBuilder sb = new StringBuilder();
		      for(int j = i-1 ;(j >=0 && arr[j] != ' ') ;j-- ){
		    	  sb.append(arr[j]);
		      }
		      list.add(sb.reverse().toString());
			}
		}
		int maxLen = list.get(0).length();
		String maxLenString = (String)list.get(0);
		for(String s : list){
			int len = s.length();
			if(len > maxLen){
				maxLen = len;
				maxLenString = s;
			}
		}
	
		return maxLenString;
		
	}

  public static void main (String[] args) {  
   
    // keep this function call here     
    Scanner  s = new Scanner(System.in);
    Function c = new Function();
    System.out.print(c.LongestWord(s.nextLine())); 
    
  }
} 








  