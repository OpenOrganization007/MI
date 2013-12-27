package datastructure.linkedList;

public class SLinkedList<E>{
	Node head;
	Node tail;
	
	public void add(E item){
		if(head == null){
			Node<E> node = new Node<E>(item);
			head = node;
			tail = node;
		}else{
			Node<E> node = new Node<E>(item);
			tail.next = node;
			tail = node;
		}
	}
	
	private class Node<E>{
		E data ;
		Node next;
		
		public Node(E data){
			this.data = data;
			this.next = null;
		}
	}

	public void display(){
		if(head != null){
			while(head.next != null){
				System.out.println(head.data);
				head = head.next;
			}
			System.out.println(head.data);
			
		}
	}
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		SLinkedList<Integer> list = new SLinkedList<Integer>();
		int[]test = {1,2,3,4,5,5,6,7};
		for(int i = 0; i<test.length; i++ ){
			list.add(test[i]);
		}
		
		list.display();

	}

}
