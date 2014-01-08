package tree;

public class BinaryTree<T> {
	private Node<T> root;
	private int height;
	
	
	public void add(T item) {
		if (root == null) {
			Node<T> node = new Node<T>(item);
			root = node;
		} else{
			add(item, root);
		}
	}

	private void add(T item, Node<T> root) {
		Node<T> node = new Node<T>(item);
		Node<T> temp = root;
		if (temp.right == null) {
			temp.right = node;
		} else if (temp.left == null) {
			temp.left = node;
		} else {
			int leftSubTreeHeight = height(temp.left);
			int rightSubTreeHeight = height(temp.right);

			if (leftSubTreeHeight < rightSubTreeHeight) {
				add(item, temp.left);
			} else {
				add(item, temp.right);
			}
		}
	
	/*	int leftSubTreeHeight = height(temp.left);
		int rightSubTreeHeight = height(temp.right);
		if (leftSubTreeHeight < rightSubTreeHeight) {
			add(item, temp.left);
		} else {
			add(item, temp.right);
		}*/

	}

	private int height(Node<T> temp){
		if(temp == null ) return 0;
		   return 1+Math.max(height(temp.left), height(temp.right));
	}

	
	
	private static class Node<T>{
		Node<T> left;
		Node<T> right;
		T item;
		public Node(T item){
			this.item = item;
			this.left = null;
			this.right = null;
		}
	}
	
	public void BinaryTree(){
		this.height = 0;
	}
	
	public void print(){
	     displayTree(root);
	}
	private void displayTree(Node<T> temp){
		Node temp1 = temp;
		if(temp1 == null) return;
		if(temp1 != null){
			System.out.println(temp1.item);
		}
		displayTree(temp1.left);
		displayTree(temp1.right);
	}


	public static void main(String[] args) {
		BinaryTree<Integer> tree = new BinaryTree<Integer>();
		int [] test ={13,4,5,56,6,6,7};
		for(int i: test){
			tree.add(i);
		}
		tree.print();

	}

}
