package tree;

class Node<T> {
	Node<T> left, right, parent;
	int height;
	T data;

	public Node(T item) {
		this.data = item;
		this.left = null;
		this.right = null;
		this.parent = null;
		this.height = 0;
	}

	public void setHeight(int height) {
		this.height = height;
	}
}