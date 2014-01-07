package stack;

public class TwoStack<E> {
	private Object[]arr;
	private int capacity;
	private int[] top = {0,0};
	
	public TwoStack(int capacity){
		this.capacity = capacity ;
		arr = new Object[capacity];
		top[0] = -1;
		top[1] = capacity;
	}
	
	public void push(int s, E item) {
		if (s < 0 && s > 1) {
			throw new IllegalArgumentException("bad paramenter");
		}
		if (top[0]+1 == top[1]) {
			throw new IllegalAccessError("Stack over flow");
		} else {
			if (s == 0) {
				arr[++top[s]] = item;
			}
			if (s == 1) {
				top[s]--;
				arr[top[s]] = item;
			}
		}
	}
	
	public E pop(int s){
		E item = null;
		if(s < 0 && s > 1)
			throw new IllegalArgumentException("wrong parameter");
		if(top[0] - 1 < 0)
			throw  new IllegalAccessError("stack under flow");
		if(top[1] + 1 == arr.length){
			throw  new IllegalAccessError("stack under flow");
		}
		if(s == 0 && top[s] > arr.length){
			item = (E)arr[top[s]];
			arr[top[s]] = null;
			top[s]--;
		}
		if(s == 1 && top[s] < arr.length){
			item = (E)arr[top[s]];
			arr[top[s]] = null;
			top[s]++;
		}
		return item;
	}
	
	public void display(){
		System.out.print("displaying stacks :");
		for(Object i : arr){
			System.out.print(i +",");
		}
		System.out.println();
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		TwoStack<Integer> stack = new TwoStack<Integer>(10);
		stack.push(0, 5);
		stack.display();
		stack.push(0, 2);
		stack.push(0, -1);
		stack.display();
		stack.push(1, 9);
		stack.push(1, 51);
		stack.push(1, 35);
		stack.display();
		stack.push(0, 4);
		stack.push(0, 7);
		stack.display();
		stack.push(1, 22);
		stack.push(1, 23);
		stack.display();
//		System.out.println("not it will give us error overflow");
//		stack.push(1, 29);
		
		/*
		 * testing pop operation
		 */
		System.out.println(stack.pop(0));
		System.out.println("After poping from 1");
		stack.display();
		System.out.println(stack.pop(0));
		System.out.println("After poping from 1");
		stack.display();
		
		System.out.println(stack.pop(1));
		System.out.println(stack.pop(1));
		System.out.println(stack.pop(1));
		System.out.println(stack.pop(1));
		System.out.println(stack.pop(1));
		System.out.println("After poping from 2");
		stack.display();
		System.out.println(stack.pop(1));
		stack.display();

	}

}
