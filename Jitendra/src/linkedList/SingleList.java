package linkedList;

import java.io.DataInputStream;
import java.io.IOException;

public class SingleList<E> {
	private Node<E> head , tail ;
	
	private static class Node<E>{
		private Node<E> next;
		private E data ;
		
		public Node(E item){
			this.data = item;
			this.next = null;
		}
	}
	
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
	
	public void delete(E item){
		Node temp = head ;
		while(temp != null){
			
			if(temp.data.equals(item)){
				temp.data = null;
				break;
			}
			temp = temp.next;
		}
		
	}
	
	public E search(E item){
		Node temp = head ;
		while(temp != null){
			
			if(temp.data.equals(item)){
				break;
			}
			temp = temp.next;
		}
		return item;
	}

	public void display(){
		Node temp = head;
		System.out.print ("item inserted : ");
			while(temp != null){
				if(temp.data != null)
				System.out.print(temp.data +",");
				temp = temp.next;
			}
			
	}
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int[] input = {1,2,4,4,5,6,7};
		SingleList<Integer> list = new SingleList<Integer>();
		for(int i : input){
			list.add(i);
		}
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
