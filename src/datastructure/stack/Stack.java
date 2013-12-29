package datastructure.stack;

public class Stack<E> {
	private Node min;
	private Node top;
	
	public void push(int item){
		if(top == null){
			Node node = new Node(item);
		}
	}
	
	
	private class Node{
	  int data;
	  Node  next;
	  Node prevMin;
	
	public Node(int item){
		this.data = item;
		this.next = null;
		this.prevMin = null;
	}
	}
	/**
	 * @param args
	 */
//	public static void main(String[] args) {
//		Stack<Integer> stack = new Stack<Integer>(5);
//		stack.push(4);
//		stack.push(5);
//		stack.push(8);
//		stack.push(-4);
//		System.out.println(stack.minValue);
//		System.out.println(stack.pop());
//		System.out.println(stack.minValue);
//
//	}

}
