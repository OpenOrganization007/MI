package tree;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Avl<T> {
	private Node<T> root;
	private Comparator<T> comp;

	public void add(T item) {
		if (root == null) {
			Node<T> node = new Node<T>(item);
			root = node;
		} else {
			add(item, root);
		}
	}

	private void add(T item, Node<T> temp) {
		int res = comp.compare(item, temp.data);
		if (res > 0) {
			if (temp.right == null) {
				Node<T> node = new Node<T>(item);
				temp.right = node;
				node.parent = temp;
			} else {
				add(item, temp.right);
			}
		} else {
			if (temp.left == null) {
				Node<T> node = new Node<T>(item);
				temp.left = node;
				node.parent = temp;
			} else {
				add(item, temp.left);
			}
		}
//		temp.setHeight(height(temp));
		balance(temp);
	}

	private void balance(Node<T> temp) {
		if (Math.abs(getBf(temp)) <= 1) {
			return;
		}
		
		if (temp.left != null) {
			if (getBf(temp.left) < 0) {
				Node<T> x = rotateLeft(temp.left);
				temp.left = x;
			}
			
			Node<T> x = rotateRight(temp);
			updateParent(temp.parent, temp, x);
		}
		if (temp.right != null) {
			if (getBf(temp.right) > 0) {
				Node<T> x = rotateRight(temp.right);
				temp.right = x;
			}

			Node<T> x = rotateLeft(temp);
			updateParent(temp.parent, temp, x);
		}
	}
	
	private void updateParent(Node<T> parent, Node<T> current, Node<T> newRoot) {
		if(parent != null) {
			if(parent.left == current) parent.left = newRoot;
			if(parent.right == current) parent.right = newRoot;
		} else {
			if(current == root) {
				root = newRoot;
			}
		}
	}

	private Node<T> rotateLeft(Node<T> node) {
		Node<T> x = node;
		Node<T> y = node.right;
		x.right = y.left;
		y.left = x;
		return y;
	}

	private Node<T> rotateRight(Node<T> node) {
		Node<T> y = node, x = node.left;
		y.left = x.right;
		x.right = y;
		return x;
	}

	private int getBf(Node<T> temp) {
		return height(temp.left) - height(temp.right);
	}

	private int height(Node<T> temp) {
		if (temp == null)
			return 0;
		return Math.max(height(temp.left), height(temp.right)) + 1;
	}

	public Avl(Comparator<T> com) {
		this.comp = com;
	}

	public static void main(String[] args) {

		int[] test = { 64, 1, 14, 26, 13, 110, 98, 85 };
//		String[]arr = {"Ram","syam","sita" ,"gita","mukes","hari"};
		

			Avl<Integer> tree = new Avl<Integer>(new Comparator<Integer>() {
			@Override
			public int compare(Integer a, Integer b) {
				if (a == null && b != null) {
					return b;
				}
				if (a != null && b == null) {
					return a;
				}
				if (a != null && b != null) {
					return a - b;
				}
				return 0;
			}
		});

		

	
		for(int i : test){
			tree.add(i);
			tree.print();
		}
	
	}

	public void print() {
		TreePrinter.printNode(root);
	}

}



