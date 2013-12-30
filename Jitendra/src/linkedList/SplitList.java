package linkedList;

public class SplitList {
	private Node head, tail;
	
	public void add(int item){
		if(head == null){
			Node  node = new Node(item);
			head = node;
			tail = node;
		}else{
			Node node = new Node(item);
			tail.next = node ;
			tail = node ;
		}
	}
	public void display(){
		Node temp = head;
		System.out.print("item in list : ");
		while(temp != null){
			System.out.print(temp.data +",");
			temp = temp.next;
		}
		System.out.println();
	}
	
	public void splitList(int key){
		SplitList before = new SplitList();
		SplitList after = new SplitList();
		Node temp = head;
		while(temp != null){
			if(temp.data < key){
				before.add(temp.data);
			}else{
				after.add(temp.data);
			}
			temp = temp.next;
		}
		
		System.out.println("Items before key :" + key);
		before.display();
		System.out.println("Items after key :" + key);
		after.display();
		
	}
	
	
	private static class Node{
		Node next;
		int data;
		
		public Node(int item){
			this.data = item;
			this.next = null;
		}
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int[] test = {1,2,43,4,5,6,6,7,8};
		SplitList list = new SplitList();
		for(int i: test){
			list.add(i);
		}
		
		list.display();
		
		list.splitList(5);

	}

}
