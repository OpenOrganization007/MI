package queue;

public class Queue<E> {
	private Object[] arr;
	private int head;
	private int tail;
	private int capacity;
	public Queue(int capacity){
		this.capacity = capacity;
		head = 0;
		tail = 0;
		arr = new Object[capacity];
	}
	public void Enqueue(E item){
		if(tail == arr.length)
			throw new IllegalAccessError("queue is full");
		arr[tail++] = item;
	}
	public E Dqueue(){
		E item = (E)arr[head++];
		return item;
	}
	
	public void display(){
		System.out.print("Enter item in queue :");
		for(int temp = head ; temp < tail; temp ++){
			System.out.print(arr[temp] + ",");
		}
		System.out.println();
	}
	

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int[] test = {1,2,4,54,5,6,7};
		Queue<Integer> q = new Queue<Integer>(test.length);
		for(int i : test){
			q.Enqueue(i);
		}
		q.display();
		System.out.print("Dqueue..");
		System.out.println(q.Dqueue());
		q.display();
		
		System.out.print("Dqueue..");
		System.out.println(q.Dqueue());
		q.display();
		
		System.out.print("Dqueue..");
		System.out.println(q.Dqueue());
		q.display();
		System.out.print("Enqueue..");
		q.Enqueue(55);
		q.display();
	}

}
