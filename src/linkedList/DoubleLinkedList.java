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
	
	public void delete(E item){
		Node temp = head ;
		while (temp != null){
		/*
		 * deleting first node
		 */
		if(temp.prev == null && temp.item.equals(item)){
			head = temp.next.prev;
		}
		/*
		 * 
		 */
		if(temp.prev != null && temp.next != null && item.equals(temp.item)){
			temp.prev.next = temp.next.prev;
			temp.next.prev = temp.prev.next;
			break;
		}
		/*
		 * delete from last node
		 */
		if(temp.next == null && temp.item.equals(item)){
			 temp.prev = null;
			 tail = temp.prev;
		}
		temp = temp.next;
	  }
	}

	public Node search(E item){
		Node temp = head;
		while (temp != null && temp.item != item){
			
			temp = temp.next;
		}
		return temp;
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
			list.delete(Integer.parseInt(dis.readLine()));
	
	    System.out.println("After deleting item list : ");
	    list.display();
	    System.out.println();
	    System.out.println("Enter item to be search in list :");
	    int item = Integer.parseInt(dis.readLine());
	    Object searched = list.search(item);
	    if(searched  != null){
	    	System.out.println( item +" is found in list");
	    }else {
	    	System.out.println(item + "  is not found in list ");
	    }
	    } catch (NumberFormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
