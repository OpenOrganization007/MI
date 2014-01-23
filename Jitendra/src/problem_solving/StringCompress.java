package problem_solving;

public class StringCompress {
	public static String getCompressed(String str){
		int count =1;
	 String myStr = "";
	 char c = str.charAt(0);
	 for(int i =1 ; i<str.length();i++){
		 if(c == str.charAt(i)){
			 count++;
		 }else{
			 myStr = myStr+c+""+count;
			 c= str.charAt(i);
			 count = 1;
		 }
	 }
	 return myStr +c+ count;
	}

	public static void main(String[] args) {
		System.out.println(getCompressed("aabccccaaa"));

	}

}
