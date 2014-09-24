package tree;

import java.util.Comparator;
import java.util.Stack;

public class BinaryTree<T>
{
    private Node<T> root;
    private Comparator<T> comp;

    public void add(T item)
    {
	if (root == null)
	{
	    root = new Node<T>(item);
	}
	else
	{
	    add(item, root);
	}
    }

    private void add(T item, Node<T> temp)
    {
	if (temp == null)
	    return;

	if (comp.compare(item, temp.data) > 0)
	{
	    if (temp.right != null)
	    {
		add(item, temp.right);
	    }
	    else
	    {
		Node<T> node = new Node<T>(item);
		temp.right = node;
	    }
	}
	else
	{
	    if (temp.left != null)
	    {
		add(item, temp.left);
	    }
	    else
	    {
		Node<T> node = new Node<T>(item);
		temp.left = node;
	    }

	}

    }

    private void delete(T item, Node<T> temp)
    {
	if (root == null)
	    return;
	Node<T> parent = temp;
	while (item != temp.data && temp != null)
	{
	    parent = temp;
	    if (comp.compare(item, temp.data) > 0)
	    {
		temp = temp.right;
	    }
	    else
	    {
		temp = temp.left;
	    }
	}
	/*
	 * deletion case1 item has no left and right child then delete node
	 */
	if (temp.left == null && temp.right == null)
	{
	    if (temp == parent.left)
	    {
		parent.left = null;
	    }
	    else
	    {
		parent.right = null;
	    }
	}
	/*
	 * case 2 it current node have one children may be left or right
	 */
	else if (temp.left != null && temp.right == null)
	{
	    parent.right = temp.left;
	}
	else if (temp.left == null && temp.right != null)
	{
	    parent.right = temp.right;
	}

	/*
	 * current node having both left and right child
	 */
	else if (temp.left != null && temp.right != null)
	{
	    Node y = getSuccessor(temp.data);
	    System.out.println(y.data);
	    /*
	     * if( y == temp.right){ // replace z with y }else{ y = y.right; }
	     */

	}

	// System.out.println("item found "+temp.data);
	// System.out.println("item parent is "+parent.data);

    }

    private Node getMinimum(Node temp)
    {
	if (temp == null)
	    return null;
	while (temp != null)
	{
	    temp = temp.left;
	}
	return temp;
    }

    private Node getSuccessor(T item)
    {
	Node temp = root;
	Node successor = root;
	while (temp.data != item)
	{
	    if (comp.compare(item, (T) temp.data) > 0)
	    {
		temp = temp.right;
		successor = temp;
	    }
	    else
	    {
		temp = temp.left;
	    }
	}
	if (temp.right != null && (comp.compare((T) successor.data, (T) temp.data) > 0))
	{
	    successor = temp.right;
	}
	return successor;

    }

    private int height(Node<T> temp)
    {
	if (temp == null)
	    return 0;
	return 1 + Math.max(height(temp.left), height(temp.right));
    }

    public BinaryTree(Comparator<T> comp)
    {
	this.comp = comp;
    }

    public void print()
    {
	TreePrinter.printNode(root);
    }

    public boolean isBalence()
    {
	if (root == null)
	    return true;
	else
	{
	    int left = height(root.left);
	    int right = height(root.right);
	    if (left - right > 1 || right - left > 1)
	    {
		return false;
	    }
	}
	return true;
    }

    public void deleteNode(T item)
    {
	delete(item, root);
    }

    /**
     * create Inorder traversal using auxilary stack
     */
    public void inOrder()
    {
	Stack<Node> s = new Stack<Node>();
	Node current = root;
	boolean done = true;
                 System.out.print(" Inorder :");
	// make temp as current head and look left most node until current ->
	// left != null
	while (done)
	{

	    if (current != null)
	    {
		s.push(current);
		current = current.left;
	    }
	    else
	    {
		// after pushing all left nodes pop left most ie top object of
		// stack
		// and change current head
		if (!s.isEmpty())
		{
		   current = s.pop();
		    System.out.print(" "+current.data);
		    current = current.right;
		}else{
		    done = false;
		}
	    }
	}

    }

    public static void main(String[] args)
    {
	BinaryTree<Integer> tree = new BinaryTree<Integer>(new Comparator<Integer>()
	{

	    @Override
	    public int compare(Integer o1, Integer o2)
	    {
		if (o1 != null && o2 != null)
		{
		    return o1 - o2;
		}
		if (o1 != null && o2 == null)
		{
		    return o1;
		}
		if (o1 == null && o2 != null)
		{
		    return o2;
		}
		return 0;
	    }
	});
	int[] test = { 13, 4, 5, 56, 6, 7, 2, 14, 12 };
	for (int i : test)
	{
	    tree.add(i);
	}
	tree.print();
	tree.inOrder();

	// tree.deleteNode(4);
	// System.out.println(tree.getSuccessor(2).data);

	// System.out.println(tree.isBalence());

    }

}
