package linkedList;


public class FindBeginingLoopNode<E> {
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
	
	/*
	 * find starting point in circular list
	 */
	public E findBegningNode(){
		Node<E> faster = head;
		Node<E> slower = head;
		
		while(faster != null && faster.next != null){
			slower = slower.next;
			faster = faster.next.next;
			if(slower == faster) { // collision point
				break;
			}
		}
		
		if(faster == null || faster.next == null)
		return null;
		slower = head;
		while(slower != faster){
			slower = slower.next;
			faster = faster.next;
		}
		return  (E) faster.data;
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
	public void addCurruptNode(E item){
		Node temp = head;
		while(!temp.data.equals(item)){
			temp = temp.next;
		}
		tail.next = temp;
		
	}
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		char []test = {'A','B','C','D','E'};
		FindBeginingLoopNode<Character> list = new FindBeginingLoopNode<Character>();
		for(char i: test){
			list.add(i);
		}
		list.addCurruptNode('B');
		System.out.print("start node is :");
		System.out.print(list.findBegningNode());

	}

}
