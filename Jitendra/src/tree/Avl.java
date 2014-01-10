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

class TreePrinter {
	public static void printNode(Node root) {
		int maxLevel = TreePrinter.maxLevel(root);

		printNodeInternal(Collections.singletonList(root), 1, maxLevel);
	}

	private static void printNodeInternal(List<Node> nodes, int level,
			int maxLevel) {
		if (nodes.isEmpty() || TreePrinter.isAllElementsNull(nodes))
			return;

		int floor = maxLevel - level + 1;
		int endgeLines = (int) Math.pow(2, (Math.max(floor - 1, 0)));
		int firstSpaces = (int) Math.pow(2, (floor)) - 1;
		int betweenSpaces = (int) Math.pow(2, (floor + 1)) - 1;

		TreePrinter.printWhitespaces(firstSpaces);

		List<Node> newNodes = new ArrayList<Node>();
		for (Node node : nodes) {
			if (node != null) {
				System.out.print(node.data);
				newNodes.add(node.left);
				newNodes.add(node.right);
			} else {
				newNodes.add(null);
				newNodes.add(null);
				System.out.print(" ");
			}

			TreePrinter.printWhitespaces(betweenSpaces);
		}
		System.out.println("");

		for (int i = 1; i <= endgeLines; i++) {
			for (int j = 0; j < nodes.size(); j++) {
				TreePrinter.printWhitespaces(firstSpaces - i);
				if (nodes.get(j) == null) {
					TreePrinter.printWhitespaces(endgeLines + endgeLines + i
							+ 1);
					continue;
				}

				if (nodes.get(j).left != null)
					System.out.print("/");
				else
					TreePrinter.printWhitespaces(1);

				TreePrinter.printWhitespaces(i + i - 1);

				if (nodes.get(j).right != null)
					System.out.print("\\");
				else
					TreePrinter.printWhitespaces(1);

				TreePrinter.printWhitespaces(endgeLines + endgeLines - i);
			}

			System.out.println("");
		}

		printNodeInternal(newNodes, level + 1, maxLevel);
	}

	private static void printWhitespaces(int count) {
		for (int i = 0; i < count; i++)
			System.out.print(" ");
	}

	private static <T extends Comparable<?>> int maxLevel(Node node) {
		if (node == null)
			return 0;

		return Math.max(TreePrinter.maxLevel(node.left),
				TreePrinter.maxLevel(node.right)) + 1;
	}

	private static <T> boolean isAllElementsNull(List<T> list) {
		for (Object object : list) {
			if (object != null)
				return false;
		}

		return true;
	}

}
