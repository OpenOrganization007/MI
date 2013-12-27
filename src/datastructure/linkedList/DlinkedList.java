package datastructure.linkedList;

public class DlinkedList<E> {
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
			node.prev = tail;
			tail = node;
		}
	}
	
	public E remove(E item){
		Node temp = head;
		if(head != null){
			while(temp != null){
				/*
				 * remove start node
				 */
				if(temp.prev == null && temp.data.equals(item)){
					head = temp.next;
					temp.next.prev = null;
					break;
				}
				/*
				 * removing from middle
				 */
				if(temp.data.equals(item) && temp.next != null && temp.prev != null){
					temp.prev.next = temp.next;
					temp.next.prev = temp.prev;
					/*
					 * without break we can remove all duplicated item in list
					 */
					break;
				}
				/*
				 * delete last node from list
				 */
				
				if(temp.next == null){
					temp.prev.next = null;
					temp = temp.prev;
				}
				temp = temp.next;
			}
			
		}
		return  item;
	}
	
	public void display(){
		if(head == null) return;
		Node temp = head;
		while(temp.next != null){
			System.out.println(temp.data);
			temp = temp.next;
		}
		System.out.println(temp.data);
	}
	
	
	private class Node<E>{
		Node next;
		Node prev;
		E data;
		
		public Node(E item){
			this.data = item;
			this.next = null;
			this.prev = null;
		}
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		DlinkedList<Integer> list = new DlinkedList<Integer>();
		int[] integerTest = {1,3,4,5,5,6,7};
		for(int i = 0 ; i<integerTest.length; i++ ){
			list.add(integerTest[i]);
		}
		list.display();
		System.out.println("remove 7");
		list.remove(4);
		System.out.println("after removing");
		list.display();
		

	}

}
