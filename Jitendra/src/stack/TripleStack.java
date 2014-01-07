package stack;

public class TripleStack<E> {
	
	final int[] top;
	final Object[] arr;
	final int c;
	final int[] min, max;
	
	public TripleStack(int c){
		this.c = c;
		arr = new Object[c * 3];
		min = new int[] {0 ,c , 2 * c};
		max = new int[] {c - 1, 2*c - 1, 3*c -1};
		top = new int[] {-1, c-1, 2*c -1};
	}
	
	public void push(int s ,E item){
		if(s < 0 && s > 2) {
			throw new IllegalArgumentException("bad stack index");
		}
		if(top[s] + 1 > max[s]){
			throw new IllegalStateException("Stack " + (s + 1) + " overflow");
		}

		arr[ ++top[s] ] = item;
	}
	
	public E pop(int s){
		if(s < 0 && s > 2){
			throw new IllegalArgumentException("bad stack index");
		}
		if(top[s] < min[s]){
			throw new IllegalStateException("Stack " +(s+1) + "underflow");
		}
		E item = (E) arr[top[s]--];
		return item;
	}
	
	public E peek(int s){
		if(s < 0 && s > 2){
			throw new IllegalArgumentException("bad stack index");
		}
		if(top[s] < min[s]){
			throw new IllegalStateException("Stack " +(s+1) + "underflow");
		}
		E item = (E) arr[top[s]];
		return item;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		TripleStack<Integer> stack = new TripleStack<>(5);
		stack.push(0, 1);
		stack.push(1, 2);
		stack.push(2, 5);
		
		System.out.println(stack.pop(0));
		System.out.println(stack.pop(0));
		
		System.out.println(stack.pop(1));

	}

}
