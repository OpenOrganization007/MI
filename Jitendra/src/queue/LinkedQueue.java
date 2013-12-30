package queue;

public class LinkedQueue<E> {
	private Node<E> head ,tail;
	
	private static class Node<E>{
		Node<E> next,prev;
		E data ;
		
		public Node(E item){
			this.data = item ;
			
		}
	}
	
	public void enQueue(E item){
		if(head == null){
			Node<E> node = new Node<E>(item);
			head = node ;
			tail = node;
		}else{
			Node<E> node = new Node<E>(item);
			tail.prev = node;
			node.prev = tail.next;
			tail = node;
		}
	}
	
	public E deQueue(){
	        E item = head.data;
	        head = head.prev;
	        return item;
	}
	
	public void displayQueue(){
		Node<E> temp = head ;
		System.out.print("displaying enqued data :");
		while(temp != null){
			System.out.print(temp.data +",");
			temp = temp.prev;
		}
		System.out.println();
	}

	public static void main(String[] args) {
		LinkedQueue<Integer> q = new LinkedQueue<Integer>();
		int[] test ={1,2,4,4,5,7,6};
		for(int i : test){
			q.enQueue(i);
		}
		q.displayQueue();
		System.out.println("Dqueing operation");
		q.deQueue();
		q.deQueue();
		q.deQueue();
		q.displayQueue();
		

	}

}
