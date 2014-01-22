package knowledgeBase_java;

import java.util.Arrays;
import java.util.Iterator;

public class CircularArray<T> implements Iterable<T> {
	private T[]items;
	private int head = 0;
	
	public CircularArray(int size) {
	  items = (T[])new Object[size];
	}

	@Override
	public Iterator<T> iterator() {
		return new CircularArrayIterator<T>(this);
	}
	
	private int convertIndex(int index){
		if(index < 0){
			head = index + items.length;
		}
		return (head+index)%items.length;
	}
	
	public void rotate(int shiftRight){
		head = convertIndex(shiftRight);
	}
	
	public void set(int i,T item){
		items[convertIndex(i)] = item;
	}

	public T get(int i){
		if(i < 0 && i >= items.length){
			throw new ArrayIndexOutOfBoundsException();
		}
		return (T) items[convertIndex(i)];
	}
	public void print(){
		System.out.println(Arrays.toString(items));
	}
	private class CircularArrayIterator<E> implements Iterator<E> {

		private int current = -1;
		private E[] _items;

		public CircularArrayIterator(CircularArray<E> array) {
			_items = array.items;
		}

		@Override
		public boolean hasNext() {
			return current < _items.length - 1;
		}

		@Override
		public E next() {
			current++;
			E value = (E) _items[current];
			return value;
		}

		@Override
		public void remove() {
			
		}
	}

	public static void main(String[] args) {
		CircularArray<Integer> array = new CircularArray<Integer>(5);
       for(int i = 0; i <5 ;i++){
    	   array.set(i, i);
       }
    
	}

}
