package linkedList;

import java.util.Stack;

public class PolindromTest<E> {
	private Node<E> head, tail;
	Stack<Integer> st = new Stack<Integer>();
	
	
	public void add(E item){
		if(head == null){
			Node<E> node = new Node<E>(item);
			head = node ;
			tail = node ;
		}else{
			Node<E> node = new Node<E>(item);
			tail.next = node;
			tail = node;
		}
	}
	
	public boolean isPolindrom(){
		Node<E> fast = head;
		Node<E> slow = head ;
		while(fast != null && fast.next != null){
			st.push((Integer)slow.data);
                slow = slow.next;
                fast = fast.next.next;
		}
		if(fast  != null){
			slow = slow.next;
		}
		
		while(slow != null){
			Integer top = st.pop().intValue();
			if(!top.equals(slow.data)){
				return false;
			}
			slow = slow.next;
		}
		
		
		return true;
	}
	
	
	public void display(){
		Node temp = head;
		System.out.print("Data in list :");
		do{
			System.out.print(temp.data +",");
			temp = temp.next;
		}while(temp != null);
		System.out.println();
	}
	
	private static class Node<E>{
		Node<E> next ;
		E data;
		
		public Node(E item){
			this.data = item;
			this.next = null;
		}
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int[] test ={1,2,1,5};
		PolindromTest<Integer> list = new PolindromTest<Integer>();
		for(int i : test){
			list.add(i);
		}
		list.display();
		
		System.out.println(list.isPolindrom());

	}

}
