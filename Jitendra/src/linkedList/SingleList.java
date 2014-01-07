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
	
	public boolean find(E item){
		boolean status = false ;
		Node temp = head;
		while(temp != null){
			
			if(temp.data.equals(item)){
				status = true;
				break;
			}
			temp = temp.next;
		}
		return status;
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
	
	public int getCount(){
		int count = 0;
		Node temp = head ;
		while(temp != null){
			count++;
			temp = temp.next;
		}
		return count;
	}
	
	public E findKth(SingleList list,int kth){
		Node temp = head;
		E item = null;
		int count = list.getCount();
		int skipNode = count - kth;
		if(temp != null){
		for(int i = 0;i< skipNode ; i++){
		temp = temp.next;
		}
		 item = (E)temp.data;
		}
		
		return item;
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
    	System.out.println();
		DataInputStream dis = new DataInputStream(System.in);
		 System.out.println();
    System.out.println("Enter item to be delete ");
    try {
			list.delete(Integer.parseInt(dis.readLine()));
	
	    System.out.println("After deleting item list : ");
	    list.display();
//	    System.out.println();
//	    System.out.println("Enter item to be search in list :");
//	    int item = Integer.parseInt(dis.readLine());
//	    Object searched = list.search(item);
//	    if(searched  != null){
//	    	System.out.println( item +" is found in list");
//	    }else {
//	    	System.out.println(item + "  is not found in list ");
//	    }
	    
		} catch (NumberFormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
//		System.out.println("Kth element in list is");
//	    System.out.println(list.findKth(list, 6));
	}

}
