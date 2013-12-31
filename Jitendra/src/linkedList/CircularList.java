package linkedList;

public class CircularList<E> {
	private Node<E> head , tail;
	
	private static class Node<E>{
		Node<E> next ,prev;
		E data;
		public Node(E item){
			this.data = item;
			this.next = null;
			this.prev = null;
		}
	}
	
	public void add(E item){
		if(head == null){
			Node<E> node = new Node<E>(item);
			head = node;
			tail = node;
		}else{
			Node<E>node = new Node<E>(item);
			tail.next = node;
			node.prev =tail;
			tail = node;
			tail.next = head;
			head.prev = tail;
		}
	}
	
	public void display(){
		Node temp = head ;
		System.out.print("Item in list :");
		do{
			System.out.print(temp.data  +",");
			temp = temp.next;
		}while (temp != head);
		
		System.out.println();
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int []test = {1,2,4,4,5,6,7};
		CircularList<Integer> list = new CircularList<Integer>();
		for(int i: test){
			list.add(i);
		}
		list.display();

	}

}
