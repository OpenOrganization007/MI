package linkedList;

import java.io.DataInputStream;
import java.io.IOException;

public class DoubleLinkedList<E> {
	private Node<E> head ,tail;
	
	
	public void add(E item){
		if(head == null){
			Node<E> node = new Node<E>(item);
			head = node ;
			tail = node;
		}else{
			Node<E> node = new Node<E>(item);
			tail.next = node;
			node.prev = tail.next;
			tail = node;
		}
		
	}
	
	public E delete(E item){
		Node temp = head ;
		while (temp != null){
			if(temp.item.equals(item) && temp.prev == null){
				head = temp.next.prev;
			} 
			
			if(temp.item.equals(item) && temp.next != null && temp.prev != null){
			/*	temp.prev.next = temp.next;
				temp.next.prev = temp.prev;*/
				temp.item = null;
			}
			 if(temp.next == null && temp.item.equals(item)){
				 tail = temp.prev;
                 temp.item = null;
                 break;
         }
         temp = temp.next;
		}
		return item;
	}
	public void search(E item){
		Node temp = head;
		while (temp != null){
			if(temp.item.equals(item))
				break;
			temp = temp.next;
		}
		
	}
	 
	public void display(){
		Node temp = head;
		while (temp != null){
			System.out.print(temp.item + ",");
			temp = temp.next;
		}
	}
	
	private static class Node<E>{
	
		private Node<E> next, prev;
		private E item ;
		public Node(E item ){
			this.item = item ;
			this.next = null;
			this.prev = null;
		}
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int[] input = {1,2,4,4,5,6,7};
		DoubleLinkedList<Integer> list = new DoubleLinkedList<Integer>();
		for(int i : input){
			list.add(i);
		}
		System.out.print("Item inserted in list are :");
		list.display();
		DataInputStream dis = new DataInputStream(System.in);
		 System.out.println();
	    System.out.println("Enter item to be delete ");
	    try {
			System.out.println(list.delete(Integer.parseInt(dis.readLine())));
	
	    System.out.println("After deleting item list : ");
	    list.display();
	    } catch (NumberFormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
