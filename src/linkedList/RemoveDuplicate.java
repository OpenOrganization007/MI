package linkedList;


public class RemoveDuplicate {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int [] testCase = {1,2,2,4,5,4,2};
          SingleList<Integer> list = new SingleList<Integer>();
		for(int i : testCase)
			if(!list.find(i)){
				list.add(i);
			}
			
		list.display();
	}

}
